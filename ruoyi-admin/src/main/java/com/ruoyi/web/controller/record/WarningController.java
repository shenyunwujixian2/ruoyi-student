package com.ruoyi.web.controller.record;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.late.service.IUserLateService;
import com.ruoyi.offline.domain.XgxtXgxtBjfdyxxQywx;
import com.ruoyi.offline.service.IXgxtXgxtBjfdyxxQywxService;
import com.ruoyi.offline.service.IZtsjZtsjJwzxsxxQywxService;
import com.ruoyi.record.domain.SysRecordWaring;
import com.ruoyi.record.service.ISysRecordWaringService;
import com.ruoyi.record.service.impl.SysRecordWaringServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * 学生晚归次数告警信息Controller
 *
 * @author xiaoafu
 * @date 2021-04-04
 */
@Api(tags = "5.5.1、警告列表")
@RestController
@RequestMapping("/record/waring")
public class WarningController extends BaseController {
    @Autowired
    private ISysRecordWaringService sysRecordWaringService;


    /**
     * 查询学生晚归次数告警信息列表
     */
//    @ApiOperation("警告列表")
//    @PreAuthorize("@ss.hasPermi('record:waring:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysRecordWaring sysRecordWaring)
    {
        startPage();
        List<SysRecordWaring> list = sysRecordWaringService.selectSysRecordWaringList(sysRecordWaring);
        return getDataTable(list);
    }

    /**
     * 查询学生晚归次数告警信息列表
     */
    @ApiOperation("黄牌警告列表")
//    @PreAuthorize("@ss.hasPermi('record:waring:list')")
    @GetMapping("/listyellow")
    public TableDataInfo listyellow(SysRecordWaring sysRecordWaring)
    {
        startPage();
        sysRecordWaring.setSearchValue("getYellowList");
        List<SysRecordWaring> list = sysRecordWaringService.selectSysRecordWaringList(sysRecordWaring);
        return getDataTable(list);
    }

    /**
     * 查询学生晚归次数告警信息列表
     */
    @ApiOperation("红牌警告列表")
//    @PreAuthorize("@ss.hasPermi('record:waring:list')")
    @GetMapping("/listred")
    public TableDataInfo listred(SysRecordWaring sysRecordWaring)
    {
        startPage();
        sysRecordWaring.setSearchValue("getRedList");
        List<SysRecordWaring> list = sysRecordWaringService.selectSysRecordWaringList(sysRecordWaring);
        return getDataTable(list);
    }

    /**
     * 导出学生晚归次数告警信息列表
     */
    @ApiOperation("4月15日、导出学生晚归次数告警信息")
//    @PreAuthorize("@ss.hasPermi('record:waring:export')")
//    @Log(title = "学生晚归次数告警信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysRecordWaring sysRecordWaring)
    {
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        if(!roleIds.equals(100L)){
            sysRecordWaring.setTeachId(loginUser.getUsername());
        }
        String dwdm = "";
        if(roleIds.equals(110L)){
//            teachId = "";
            dwdm = loginUser.getUser().getRemark()+"";
            sysRecordWaring.setTeachId(null);
            sysRecordWaring.setDwdm(dwdm);
        }
        List<SysRecordWaring> list = sysRecordWaringService.selectSysRecordWaringList(sysRecordWaring);
        ExcelUtil<SysRecordWaring> util = new ExcelUtil<SysRecordWaring>(SysRecordWaring.class);
        return util.exportExcel(list, "学生违纪信息");
    }

    /**
     * 获取学生晚归次数告警信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('record:waring:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysRecordWaringService.selectSysRecordWaringById(id));
    }

    /**
     * 新增学生晚归次数告警信息
     */
    @PreAuthorize("@ss.hasPermi('record:waring:add')")
    @Log(title = "学生晚归次数告警信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRecordWaring sysRecordWaring)
    {
        return toAjax(sysRecordWaringService.insertSysRecordWaring(sysRecordWaring));
    }

    /**
     * 修改学生晚归次数告警信息
     */
    @PreAuthorize("@ss.hasPermi('record:waring:edit')")
    @Log(title = "学生晚归次数告警信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRecordWaring sysRecordWaring)
    {
        return toAjax(sysRecordWaringService.updateSysRecordWaring(sysRecordWaring));
    }

    /**
     * 删除学生晚归次数告警信息
     */
    @PreAuthorize("@ss.hasPermi('record:waring:remove')")
    @Log(title = "学生晚归次数告警信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysRecordWaringService.deleteSysRecordWaringByIds(ids));
    }


    @Autowired
    private TokenService tokenService;
    /**
     * 查询学生晚归次数告警信息列表
     */
    @ApiOperation("警告列表（按照班级统计，需要登录）")
//    @PreAuthorize("@ss.hasPermi('record:waring:list')")
    @GetMapping("/listbybjdm")
    public AjaxResult listbybjdm(SysRecordWaring sysRecordWaring)
    {
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        if(!roleIds.equals(100L)){
            sysRecordWaring.setTeachId(loginUser.getUsername());
        }

//        String showTime = DateUtils.getBeforeDateStr();
        //返回数据
        List<HashMap<String, Object>> returnList = new ArrayList<>();
        //返回数据
        HashMap<String, Object> returnMap = new HashMap<>();
        startPage();
        sysRecordWaring.setSearchValue("yellowGroupByBjdm");
        List<SysRecordWaring> list = sysRecordWaringService.selectSysRecordWaringList(sysRecordWaring);

        List<Map<String, Object>> listReturnWaring = new ArrayList<>();
        for (SysRecordWaring baseModel : list) {
            Map<String, Object> oneMap = BeanUtils.convertBeanToMap(baseModel);
            String bjdm = baseModel.getBjdm(); //根据班级代码 去干更多事情
            //晚归人数
            HashMap<String,Object> searchMap = new HashMap<>();
//            searchMap.put("showTime", showTime);
            searchMap.put("startshowTime", sysRecordWaring.getStartshowTime());
            searchMap.put("endshowTime", sysRecordWaring.getEndshowTime());
            searchMap.put("lateStatus", 2);
            searchMap.put("bjdm", bjdm);
            oneMap.put("lateNum", getLateStudentNum(searchMap));

            // 未回寝人数
            HashMap<String,Object> searchNoBackMap = new HashMap<>();
//            searchNoBackMap.put("showTime", showTime);
            searchNoBackMap.put("startshowTime", sysRecordWaring.getStartshowTime());
            searchNoBackMap.put("endshowTime", sysRecordWaring.getEndshowTime());
            searchNoBackMap.put("lateStatus", "0");
            searchNoBackMap.put("bjdm", bjdm);
            oneMap.put("noBackNum", getLateStudentNum(searchNoBackMap));

            //班级的黄牌警告
            HashMap<String, Object> searchYellowWaring = new HashMap<>();
            searchYellowWaring.put("bjdm", bjdm);
            searchYellowWaring.put("getYellowWaring", 1);
            searchYellowWaring.put("groupByField", "bjdm");
            List<Map<String,Object>> mListYellowWaring = getWaringCount(searchYellowWaring);
            String yNum ="0";
            if(mListYellowWaring.size()>0){
                Map<String,Object> yMap = mListYellowWaring.get(0);
                yNum = yMap.get("allNum").toString();
            }
            oneMap.put("yellowWaringNum",yNum);
//            oneMap.put("yellowWaringNum",new PageInfo(mListYellowWaring).getTotal());

            //红牌警告人数
            HashMap<String, Object> searchRedWaring = new HashMap<>();
            searchRedWaring.put("bjdm", bjdm);
            searchRedWaring.put("getRedWaring", 1);
            searchRedWaring.put("groupByField", "bjdm");
            List mListRedWaring = getWaringCount(searchRedWaring);
            String redNum ="0";
            if(mListRedWaring.size()>0){
                Map<String,Object> redMap = mListYellowWaring.get(0);
                redNum = redMap.get("allNum").toString();
            }
            oneMap.put("redWaringNum",redNum);
//            oneMap.put("redWaringNum",new PageInfo(mListRedWaring).getTotal());

            //未处理
            oneMap.put("teachNoStatusNum", getTeachNoStatus(bjdm,sysRecordWaring.getStartshowTime(), sysRecordWaring.getEndshowTime()));
            listReturnWaring.add(oneMap);
        }
        returnMap.put("rows", listReturnWaring);
        returnMap.put("total", new PageInfo(list).getTotal());
        returnMap.put("pageNum", new PageInfo(list).getPageNum());
        returnMap.put("pageSize", new PageInfo(list).getPageSize());
        returnMap.put("pages", new PageInfo(list).getPages());
        returnList.add(returnMap);
        return AjaxResult.success(returnList);
    }

    @Autowired
    private IUserLateService userLateService;
    private String getLateStudentNum(HashMap<String, Object> searchMap) {
        Map<String,Object> returnMap = userLateService.getCountByHashMap(searchMap);
        String num = "0" ;
        if(!StrKit.isEmpty(returnMap.get("num"))){
            num = returnMap.get("num").toString();
        }
        return num;
    }

    @Autowired
    SysRecordWaringServiceImpl sysRecordWaringServiceImpl;
    //获取警告人数
    private List<Map<String,Object>> getWaringCount(HashMap<String, Object> searchMap){
        PageHelper.startPage(1, 1, "");
        List<Map<String, Object>> mListWaring = sysRecordWaringServiceImpl.getCount(searchMap);
        return mListWaring;
    }

    /**
     * 获取老师没有处理的列表
     * @param bjdm
     * @return
     */
    private String getTeachNoStatus(String bjdm, String startshowTime, String endshowTime){
        HashMap<String,Object> searchMap = new HashMap<>();
        searchMap.put("teachStatus", -1);
        searchMap.put("bjdm", bjdm);
//        searchMap.put("showTime",showTime);
        searchMap.put("startshowTime", startshowTime);
        searchMap.put("endshowTime", endshowTime);
        startPage();
        List<Map<String,Object>> list = userLateService.getList(searchMap);
        if(list.size() <1){
            return "0";
        }
//        Long total = new PageInfo(list).getTotal();
        Map<String,Object> oneMap = list.get(0);
        String total = "0";
        if(!StrKit.isEmpty(oneMap.get("num"))){
            total =oneMap.get("num").toString();
        }
        return total + "";
    }

}
