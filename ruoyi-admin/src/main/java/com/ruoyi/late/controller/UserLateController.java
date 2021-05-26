package com.ruoyi.late.controller;

import java.util.*;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.late.domain.UserLateGread;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.service.EachDayService;
import io.swagger.annotations.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.late.domain.UserLate;
import com.ruoyi.late.service.IUserLateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生晚归迟到记录Controller
 *
 * @author 小阿福
 * @date 2021-03-24
 */

@Api(tags = "5.1、学生晚归迟到记录信息")
@RestController
@RequestMapping("/late/late")
public class UserLateController extends BaseController {
    @Autowired
    private IUserLateService userLateService;

    /**
     * 查询学生晚归迟到记录列表
     */
//    @ApiOperation("查询学生晚归迟到记录列表")
//    @PreAuthorize("@ss.hasPermi('late:late:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserLate userLate) {
        startPage();
        List<UserLate> list = userLateService.selectUserLateList(userLate);
        return getDataTable(list);
    }


    @Autowired
    private TokenService tokenService;
    /**
     * 晚归归列表
     *
     * @param userLate
     * @return
     */
    @ApiOperation("5.1.1.1、晚归列表(需要登录)")
    @GetMapping("/latelist")
    public TableDataInfo latelist(UserLate userLate) {
//        if (StrKit.isEmpty(userLate.getShowTime())) {
//            userLate.setShowTime(DateUtils.getBeforeDateStr());
//        }
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        if(!roleIds.equals(100L)){
            userLate.setTeachId(loginUser.getUsername());
        }
        String dwdm = "";
        if(roleIds.equals(110L)){
//            teachId = "";
            dwdm = loginUser.getUser().getRemark()+"";
            userLate.setTeachId(null);
            userLate.setDwdm(dwdm);
        }
//        userLate.setLateStatus(2);
        startPage();
        List<UserLate> lateList = userLateService.selectUserLateList(userLate);
        return getDataTable(lateList);
    }

    /**
     * 未回归列表
     *
     * @param userLate
     * @return
     */
    @ApiOperation("5.1.1.2、晚归列表(后台需要老师登录处理 ---丢弃)")
    @GetMapping("/latelistneedteachstatus")
    public TableDataInfo latelistneedteachstatus(UserLate userLate) {
//        if (StrKit.isEmpty(userLate.getShowTime())) {
//            userLate.setShowTime(DateUtils.getBeforeDateStr());
//        }
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        if(!roleIds.equals(100L)){
            userLate.setTeachId(loginUser.getUsername());
        }
        String dwdm = "";
        if(roleIds.equals(110L)){
//            teachId = "";
            dwdm = loginUser.getUser().getRemark()+"";
            userLate.setTeachId(null);
            userLate.setDwdm(dwdm);
        }

        userLate.setLateStatus(0);
        userLate.setTeachStatus(-1);
        startPage();
        List<UserLate> lateList = userLateService.selectUserLateList(userLate);
        return getDataTable(lateList);
    }


    /**
     * 未回归列表
     *
     * @param userLate
     * @return
     */
    @ApiOperation("5.1.1.3、老师未处理/已处理列表 (需要登录)")
    @GetMapping("/noteachstatuslist")
    public AjaxResult noteachstatuslist(UserLate userLate) {
        userLate.setSearchValue("haveTeachStatus");
        if (StrKit.isEmpty(userLate.getTeachStatus())) {
            userLate.setTeachStatus(-1); //默认选中未处理
        }
        if (userLate.getTeachStatus() == -1) {
            userLate.setSearchValue(null);
        } else {
            userLate.setTeachStatus(null);
        }
//        if (StrKit.isEmpty(userLate.getShowTime())) {
//            userLate.setShowTime(DateUtils.getBeforeDateStr());
//        }
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        if(!roleIds.equals(100L)){
            userLate.setTeachId(loginUser.getUsername());
        }
        String dwdm = "";
        if(roleIds.equals(110L)){
//            teachId = "";
            dwdm = loginUser.getUser().getRemark()+"";
            userLate.setTeachId(null);
            userLate.setDwdm(dwdm);
        }

        startPage();
        List<UserLate> noBackList = userLateService.selectUserLateList(userLate);
        return AjaxResult.success(getDataTable(noBackList));
    }

    /**
     * 老师确认违纪加上未处理的晚归未归列表
     *
     * @param userLate
     * @return
     */
    @ApiOperation("4月23日、老师确认违纪加上未处理的晚归未归列表 ")
    @GetMapping("/teachstatuslist")
    public AjaxResult teachstatuslist(UserLate userLate) {
        userLate.setSearchValue("teachStatusArr");
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        if(!roleIds.equals(100L)){
            userLate.setTeachId(loginUser.getUsername());
        }
        String dwdm = "";
        if(roleIds.equals(110L)){
//            teachId = "";
            dwdm = loginUser.getUser().getRemark()+"";
            userLate.setTeachId(null);
            userLate.setDwdm(dwdm);
        }
        startPage();
        List<UserLate> noBackList = userLateService.selectUserLateList(userLate);
        return AjaxResult.success(getDataTable(noBackList));
    }

    /**
     * 导出学生晚归迟到记录列表
     */
    @ApiOperation("4月15日、导出晚归记录")
//    @PreAuthorize("@ss.hasPermi('late:late:export')")
//    @Log(title = "学生晚归迟到记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(UserLate userLate) {
        userLate.setSearchValue("haveTeachStatus");
        if (StrKit.isEmpty(userLate.getTeachStatus())) {
            userLate.setTeachStatus(-1); //默认选中未处理
        }
        if (userLate.getTeachStatus() == -1) {
            userLate.setSearchValue(null);
        } else {
            userLate.setTeachStatus(null);
        }
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        if(!roleIds.equals(100L)){
            userLate.setTeachId(loginUser.getUsername());
        }
        String dwdm = "";
        if(roleIds.equals(110L)){
//            teachId = "";
            dwdm = loginUser.getUser().getRemark()+"";
            userLate.setTeachId(null);
            userLate.setDwdm(dwdm);
        }
        List<UserLate> list = userLateService.selectUserLateList(userLate);
        ExcelUtil<UserLate> util = new ExcelUtil<UserLate>(UserLate.class);
        return util.exportExcel(list, "晚归记录");
    }

    /**
     * 按学院到处晚归记录
     */
    @ApiOperation("4月22日、按学院到处晚归记录")
//    @PreAuthorize("@ss.hasPermi('late:late:export')")
//    @Log(title = "学生晚归迟到记录", businessType = BusinessType.EXPORT)
    @GetMapping("/exportbygreads")
    public AjaxResult exportbygreads(UserLate userLate) {
        HashMap<String,Object> reqMap = (HashMap<String, Object>) BeanUtils.convertBeanToMap(userLate);
        reqMap.put("teachStatusArr","-1,0,2");
        List<Map<String,Object>> list = userLateService.getByGreadList(reqMap);
        List<UserLateGread> listExport = new ArrayList<>();
        for (Map<String,Object> oneMap : list){
//            UserLateGread baseModel = new UserLateGread();
//            BeanUtils.copyProperties(oneMap, baseModel,UserLateGread.class);
            UserLateGread baseModel = (UserLateGread) BeanUtils.convertMapToBean(oneMap,UserLateGread.class);
            listExport.add(baseModel);
        }
        ExcelUtil<UserLateGread> util = new ExcelUtil<UserLateGread>(UserLateGread.class);
        return util.exportExcel(listExport, "学院晚归记录导出");
    }

    /**
     * 获取学生晚归迟到记录详细信息
     */
//    @ApiOperation("获取学生晚归迟到记录详细信息")
    @PreAuthorize("@ss.hasPermi('late:late:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(userLateService.selectUserLateById(id));
    }
    @Autowired
    private EachDayService eachDayService;
    /**
     * 新增学生晚归迟到记录
     */
    @ApiOperation("4月17日、新增学生晚归迟到记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="showTime",value="时间", required=true,dataType="String"),
            @ApiImplicitParam(name="teachStatus",value="老师处理状态"),
            @ApiImplicitParam(name="xh",value="学生学号")
    })
    @PostMapping("/addlate")
    public AjaxResult addlate(@RequestBody UserLate userLate) {
        if(StrKit.isEmpty(userLate.getShowTime())){
            return AjaxResult.error("时间不能为空");
        }
        if(StrKit.isEmpty(userLate.getTeachStatus())){
            return AjaxResult.error("类型不能为空");
        }
        if(StrKit.isEmpty(userLate.getXh())){
            return AjaxResult.error("学号不能为空");
        }
        UserLate userLateSearch = new UserLate();
        userLateSearch.setShowTime(userLate.getShowTime());
        userLateSearch.setXh(userLate.getXh());
        List<UserLate> mlist = userLateService.selectUserLateList(userLateSearch);
        if(mlist.size()>0){
            UserLate haveModel = mlist.get(0);
            haveModel.setTeachStatus(userLate.getTeachStatus());
            haveModel.setLateStatus(userLate.getTeachStatus());
            haveModel.setRemark("老师手动刷新");
            int update = userLateService.updateUserLate(haveModel);
            //刷新当天状态
            if(null != haveModel.getDayId()){
                EachDayModel eachDayModel = new EachDayModel();
                eachDayModel.setLateStatus(userLate.getTeachStatus()+"");
                eachDayModel.setId(haveModel.getDayId());
                eachDayService.edit(eachDayModel);
            }
            return AjaxResult.success(update);
        }
        //查询当天
        int addresult = addUserLateInfo(userLate);
        return toAjax(addresult);
    }

    /**
     * 根据当天信息 添加晚归
     * @param userLate
     */
    private int addUserLateInfo(UserLate userLate){
        int addBoolean = 0;
        HashMap searchMap = new HashMap();
        searchMap.put("showTime",userLate.getShowTime());
        searchMap.put("xh",userLate.getXh());
        EachDayModel eachDayModel = eachDayService.getModelInfo(searchMap);
        if(null != eachDayModel){
            UserLate  baseModel = new UserLate();
            BeanUtils.copyProperties(eachDayModel,baseModel);
            baseModel.setId(null);
            baseModel.setDayId(eachDayModel.getId());
            baseModel.setCreateTime(null);
            baseModel.setUpdateTime(null);
            //设置 晚归标识
            baseModel.setLateStatus(userLate.getTeachStatus());
            baseModel.setTeachStatus(userLate.getTeachStatus());
            baseModel.setTeachTime(DateUtils.getTime());
            baseModel.setStatus(userLate.getTeachStatus());
            baseModel.setCreateTime(new Date());
            baseModel.setRemark("老师手动添加");
            addBoolean = userLateService.insertUserLate(baseModel);
            //刷新当天状态
            eachDayModel.setLateStatus(userLate.getTeachStatus()+"");
            eachDayModel.setId(baseModel.getDayId());
            eachDayService.edit(eachDayModel);
        }else{
            HashMap searchMapHave = new HashMap();
            searchMapHave.put("xh",userLate.getXh());
            EachDayModel eachDayhaveModel = eachDayService.getModelInfo(searchMapHave);
            UserLate  baseModel = new UserLate();
            BeanUtils.copyProperties(eachDayhaveModel,baseModel);
            baseModel.setId(null);
            baseModel.setDayId(null);
            baseModel.setCreateTime(null);
            baseModel.setUpdateTime(null);
            //设置 晚归标识
            baseModel.setLateStatus(userLate.getTeachStatus());
            baseModel.setTeachStatus(userLate.getTeachStatus());
            baseModel.setTeachTime(DateUtils.getTime());
            baseModel.setStatus(userLate.getTeachStatus());
            baseModel.setCreateTime(new Date());
            baseModel.setShowTime(userLate.getShowTime());
            baseModel.setRemark("老师手动添加");
            addBoolean = userLateService.insertUserLate(baseModel);
        }
        return addBoolean;
    }

    /**
     * 新增学生晚归迟到记录
     */
    @PreAuthorize("@ss.hasPermi('late:late:add')")
    @Log(title = "学生晚归迟到记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserLate userLate) {
        return toAjax(userLateService.insertUserLate(userLate));
    }

    /**
     * 修改学生晚归迟到记录
     */
    @PreAuthorize("@ss.hasPermi('late:late:edit')")
    @Log(title = "学生晚归迟到记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserLate userLate) {
        return toAjax(userLateService.updateUserLate(userLate));
    }

    /**
     * 删除学生晚归迟到记录
     */
    @PreAuthorize("@ss.hasPermi('late:late:remove')")
    @Log(title = "学生晚归迟到记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(userLateService.deleteUserLateByIds(ids));
    }

}

