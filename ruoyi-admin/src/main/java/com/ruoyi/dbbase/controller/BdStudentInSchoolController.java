package com.ruoyi.dbbase.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.dbbase.domain.BdStudentGread;
import com.ruoyi.dbbase.domain.BdXgxtXgxtSscwhrzxxQywx;
import com.ruoyi.dbbase.service.impl.BdStudentGreadServiceImpl;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.late.domain.UserLate;
import com.ruoyi.late.domain.UserLateNum;
import com.ruoyi.late.service.IUserLateService;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.service.EachDayService;
import com.ruoyi.record.service.impl.SysRecordWaringServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.dbbase.domain.BdStudentInSchool;
import com.ruoyi.dbbase.service.IBdStudentInSchoolService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学校入住学生（要使用）Controller
 *
 * @author xiaoafu
 * @date 2021-04-07
 */
@Api(tags = "4月17日、学生晚归统计")
@RestController
@RequestMapping("/dbbase/inschool")
public class BdStudentInSchoolController extends BaseController {
    @Autowired
    private IBdStudentInSchoolService bdStudentInSchoolService;

    //教务在校生信息
    @Autowired
    private BdStudentGreadServiceImpl bdStudentGreadServiceImpl;
    //当天学生列表
    @Autowired
    private EachDayService eachDayService;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private IUserLateService userLateService;

    /**
     * 查询学校入住学生（要使用）列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:inschool:list')")
    @GetMapping("/list")
    public TableDataInfo list(BdStudentInSchool bdStudentInSchool) {
        startPage();
        List<BdStudentInSchool> list = bdStudentInSchoolService.selectBdStudentInSchoolList(bdStudentInSchool);
        return getDataTable(list);
    }

    @ApiOperation("学生统计晚归次数")
    @GetMapping("/listlatenum")
    public AjaxResult listlatenum(UserLate bdStudentInSchool) {
        List<HashMap<String, Object>> returnList = returnListLateNum(bdStudentInSchool);
        return AjaxResult.success(returnList);
    }

    /**
     * 查询学校入住学生（要使用）列表
     */
    private List<HashMap<String, Object>> returnListLateNum(UserLate bdStudentInSchool) {
        //返回数据
        List<HashMap<String, Object>> returnList = new ArrayList<>();
        //返回数据
        HashMap<String, Object> returnMap = new HashMap<>();
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        if (!roleIds.equals(100L)) {
            bdStudentInSchool.setTeachName(loginUser.getUser().getNickName());
        }
        String dwdm = "";
        if (roleIds.equals(110L)) {
            String dwmc = "";
            dwdm = loginUser.getUser().getRemark() + "";
            BdStudentGread seachBdStudentGread = new BdStudentGread();
            seachBdStudentGread.setDwdm(dwdm);
            startPage();
            List<BdStudentGread> mList = bdStudentGreadServiceImpl.selectBdStudentGreadGroupZyList(seachBdStudentGread);
            if (mList.size() > 0) {
                BdStudentGread oneBdStudentGread = mList.get(0);
                if (oneBdStudentGread != null) {
                    dwmc = oneBdStudentGread.getDwmc();
                }
            }
//            bdStudentInSchool.setXymc(dwmc);
            bdStudentInSchool.setDwmc(dwmc);
        }

        startPage();
        HashMap<String, Object> reqMap = (HashMap<String, Object>) BeanUtils.convertBeanToMap(bdStudentInSchool);
        reqMap.put("groupByFieldName", "xh");
        reqMap.put("teachStatusArr", "-1,0,2");
        List<Map<String, Object>> list = userLateService.getList(reqMap);
        List<Map<String, Object>> listBdStudentInSchool = new ArrayList<>();
        for (Map<String, Object> oneMap : list) {
            String xh = oneMap.get("xh").toString(); //根据学号 去干更多事情
            //查询该学生 晚归次数  晚归已处理 未归次数  未归未处理  总未处理数
            String lateNum = getLateNum(xh, bdStudentInSchool.getStartshowTime(), bdStudentInSchool.getEndshowTime(), "2", null, "haveTeachStatus");
            oneMap.put("lateNum", lateNum);
            // 晚归未处理
            String lateNumNoStatus = getLateNum(xh, bdStudentInSchool.getStartshowTime(), bdStudentInSchool.getEndshowTime(), "2", "-1", null);
            oneMap.put("lateNumNoStatus", lateNumNoStatus);

            // 所有晚归
            String allLateNum = getLateNum(xh, bdStudentInSchool.getStartshowTime(), bdStudentInSchool.getEndshowTime(), "2", null, null);
            oneMap.put("allLateNum", allLateNum);

            String noBackNum = getLateNum(xh, bdStudentInSchool.getStartshowTime(), bdStudentInSchool.getEndshowTime(), "0", null, "haveTeachStatus");
            oneMap.put("noBackNum", noBackNum);

            String noBackNumNoStatus = getLateNum(xh, bdStudentInSchool.getStartshowTime(), bdStudentInSchool.getEndshowTime(), "0", "-1", null);
            oneMap.put("noBackNumNoStatus", noBackNumNoStatus);
            //所有未归
            String allNoBackNum = getLateNum(xh, bdStudentInSchool.getStartshowTime(), bdStudentInSchool.getEndshowTime(), "0", null, null);
            oneMap.put("allNoBackNum", allNoBackNum);

            String allNoTeachStatus = getLateNum(xh, bdStudentInSchool.getStartshowTime(), bdStudentInSchool.getEndshowTime(), null, "-1", null);
            oneMap.put("allNoTeachStatus", allNoTeachStatus);

            HashMap<String, Object> searchWaringNum = new HashMap<>();
            searchWaringNum.put("xh", xh);
            String waringNum = getWaringCount(searchWaringNum);
            int waringLateNum = Integer.valueOf(waringNum);
            int waringNoBackNum = Integer.valueOf(waringNum);

            //黄牌警告
            Integer yellowWaringNum = waringLateNum / 3;
            oneMap.put("yellowWaringNum", yellowWaringNum + "");

            //红牌警告
            Integer redWaringNum = waringLateNum / 6 + waringNoBackNum / 2;
            oneMap.put("redWaringNum", redWaringNum + "");

            //  警告处分
            Integer jgcfNum = waringLateNum / 10 + waringNoBackNum / 3;
            oneMap.put("jgcfNum", jgcfNum + "");

            //  严重警告处分
            Integer yzjgNum = waringLateNum / 15 + waringNoBackNum / 6;
            oneMap.put("yzjgNum", yzjgNum + "");

            //  记过处分
            Integer jgChuFenNum = waringLateNum / 20 + waringNoBackNum / 10;
            oneMap.put("jgChuFenNum", jgChuFenNum + "");

            //  留校察看处分
            Integer lxckNum = waringLateNum / 21 + waringNoBackNum / 11;
            oneMap.put("lxckNum", lxckNum + "");

            listBdStudentInSchool.add(oneMap);
        }
        returnMap.put("rows", listBdStudentInSchool);
        returnMap.put("total", new PageInfo(list).getTotal());
        returnMap.put("pageNum", new PageInfo(list).getPageNum());
        returnMap.put("pageSize", new PageInfo(list).getPageSize());
        returnMap.put("pages", new PageInfo(list).getPages());
        returnList.add(returnMap);
//        return AjaxResult.success(returnList);
        return returnList;
    }


    @ApiOperation("4月26日、导出学生统计晚归次数")
    @GetMapping("/exportlatenum")
    public AjaxResult exportlatenum(UserLate bdStudentInSchool) {
        List<HashMap<String, Object>> returnList = returnListLateNum(bdStudentInSchool);
        List<Map<String, Object>> list = (List<Map<String, Object>>) returnList.get(0).get("rows");
        List<UserLateNum> listExport = new ArrayList<>();
        for (Map<String, Object> oneMap : list) {
            UserLateNum baseModel = (UserLateNum) BeanUtils.convertMapToBean(oneMap, UserLateNum.class);
            listExport.add(baseModel);
        }
        ExcelUtil<UserLateNum> util = new ExcelUtil<UserLateNum>(UserLateNum.class);
        return util.exportExcel(listExport, "学生晚归记录导出");
    }


    /**
     * 根据学号 获取某段时间的 晚归次数  晚归已处理 未归次数  未归未处理  总未处理数
     *
     * @param xh
     * @param startshowTime
     * @param endshowTime
     * @return
     */
    private String getLateNum(String xh, String startshowTime, String endshowTime, String status, String teachStatus, String searchValue) {
        String num = "0";
        HashMap<String, Object> searchMap = new HashMap<>();
//        searchMap.put("showTime", startshowTime);
        searchMap.put("startshowTime", startshowTime);
        searchMap.put("endshowTime", endshowTime);
        searchMap.put("xh", xh);
        if (!StrKit.isEmpty(status)) {
            searchMap.put("status", status);
        }
        if (!StrKit.isEmpty(teachStatus)) {
            searchMap.put("teachStatus", teachStatus);
        }
        if (!StrKit.isEmpty(searchValue)) {
            searchMap.put("searchValue", searchValue);
        }
        Map<String, Object> returnMap = userLateService.getCountByHashMap(searchMap);
        if (returnMap != null) {
            num = returnMap.get("num").toString();
        }
        return num;
    }

    @Autowired
    SysRecordWaringServiceImpl sysRecordWaringServiceImpl;

    //获取警告人数
    private String getWaringCount(HashMap<String, Object> searchMap) {
        PageHelper.startPage(1, 1, "");
        List<Map<String, Object>> mListWaring = sysRecordWaringServiceImpl.getCount(searchMap);
        String yNum = "0";
        if (mListWaring.size() > 0) {
            Map<String, Object> yMap = mListWaring.get(0);
            yNum = yMap.get("allNum").toString();
        }
        return yNum;
    }


    /**
     * 导出学校入住学生（要使用）列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:inschool:export')")
    @Log(title = "学校入住学生（要使用）", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BdStudentInSchool bdStudentInSchool) {
        List<BdStudentInSchool> list = bdStudentInSchoolService.selectBdStudentInSchoolList(bdStudentInSchool);
        ExcelUtil<BdStudentInSchool> util = new ExcelUtil<BdStudentInSchool>(BdStudentInSchool.class);
        return util.exportExcel(list, "inschool");
    }

    /**
     * 获取学校入住学生（要使用）详细信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:inschool:query')")
    @GetMapping(value = "/{xh}")
    public AjaxResult getInfo(@PathVariable("xh") String xh) {
        return AjaxResult.success(bdStudentInSchoolService.selectBdStudentInSchoolById(xh));
    }

    /**
     * 新增学校入住学生（要使用）
     */
    @PreAuthorize("@ss.hasPermi('dbbase:inschool:add')")
    @Log(title = "学校入住学生（要使用）", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BdStudentInSchool bdStudentInSchool) {
        return toAjax(bdStudentInSchoolService.insertBdStudentInSchool(bdStudentInSchool));
    }

    /**
     * 修改学校入住学生（要使用）
     */
    @PreAuthorize("@ss.hasPermi('dbbase:inschool:edit')")
    @Log(title = "学校入住学生（要使用）", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BdStudentInSchool bdStudentInSchool) {
        return toAjax(bdStudentInSchoolService.updateBdStudentInSchool(bdStudentInSchool));
    }

    /**
     * 删除学校入住学生（要使用）
     */
    @PreAuthorize("@ss.hasPermi('dbbase:inschool:remove')")
    @Log(title = "学校入住学生（要使用）", businessType = BusinessType.DELETE)
    @DeleteMapping("/{xhs}")
    public AjaxResult remove(@PathVariable String[] xhs) {
        return toAjax(bdStudentInSchoolService.deleteBdStudentInSchoolByIds(xhs));
    }
}
