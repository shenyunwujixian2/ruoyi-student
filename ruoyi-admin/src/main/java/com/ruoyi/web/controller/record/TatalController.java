package com.ruoyi.web.controller.record;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.dbbase.domain.BdStudentGread;
import com.ruoyi.dbbase.domain.BdXgxtXgxtBjfdyxxQywx;
import com.ruoyi.dbbase.domain.BdZtsjZtsjJwzxsxxQywx;
import com.ruoyi.dbbase.service.IBdStudentGreadService;
import com.ruoyi.dbbase.service.impl.BdStudentGreadServiceImpl;
import com.ruoyi.dbbase.service.impl.BdXgxtXgxtBjfdyxxQywxServiceImpl;
import com.ruoyi.dbbase.service.impl.BdZtsjZtsjJwzxsxxQywxServiceImpl;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.late.domain.UserLate;
import com.ruoyi.late.service.IUserLateService;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.domain.SysRecordWaring;
import com.ruoyi.record.service.EachDayService;
import com.ruoyi.record.service.ISysRecordWaringService;
import com.ruoyi.record.service.impl.SysRecordWaringServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 用户信息
 *
 * @author ruoyi
 */
@Api(tags = "3.2、查询统计")
@RestController
@RequestMapping("/record/total")
public class TatalController extends BaseController {
    //学工班级辅导信息 辅导员信息
    @Autowired
    private BdXgxtXgxtBjfdyxxQywxServiceImpl bdXgxtXgxtBjfdyxxQywxServiceImpl;
    //教务在校生信息
    @Autowired
    private BdZtsjZtsjJwzxsxxQywxServiceImpl bdZtsjZtsjJwzxsxxQywxServiceImpl;
    //教务在校生信息
    @Autowired
    private BdStudentGreadServiceImpl bdStudentGreadServiceImpl;

    @ApiOperation("按照辅导员查询未归统计")
//    @PreAuthorize("@ss.hasPermi('record:total:list')")
    @GetMapping("/list")
    public AjaxResult list(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx) {
//        if (StrKit.isEmpty(bdXgxtXgxtBjfdyxxQywx.getShowTime())) {
//            bdXgxtXgxtBjfdyxxQywx.setShowTime(DateUtils.getBeforeDateStr());
//        }
        //返回数据
        List<HashMap<String, Object>> returnList = new ArrayList<>();
        //返回数据
        HashMap<String, Object> returnMap = new HashMap<>();
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        String dwdm = "";
        if(roleIds.equals(110L)){
            String dwmc ="";
            dwdm = loginUser.getUser().getRemark()+"";
            bdXgxtXgxtBjfdyxxQywx.setFdyjzgh(null);
            BdStudentGread seachBdStudentGread = new BdStudentGread();
            seachBdStudentGread.setDwdm(dwdm);
            startPage();
            List<BdStudentGread> mList = bdStudentGreadServiceImpl.selectBdStudentGreadGroupZyList(seachBdStudentGread);
            if(mList.size()>0){
                BdStudentGread oneBdStudentGread= mList.get(0);
                if (oneBdStudentGread!=null){
                    dwmc = oneBdStudentGread.getDwmc();
                }
            }
            bdXgxtXgxtBjfdyxxQywx.setDwmc(dwmc);
        }
        startPage();
        List<BdXgxtXgxtBjfdyxxQywx> list = bdXgxtXgxtBjfdyxxQywxServiceImpl.selectBdXgxtXgxtBjfdyxxQywxList(bdXgxtXgxtBjfdyxxQywx);

        List<Map<String, Object>> listReturnTeach = new ArrayList<>();
        for (BdXgxtXgxtBjfdyxxQywx baseModel : list) {
            Map<String, Object> oneMap = BeanUtils.convertBeanToMap(baseModel);
            String bjdm = baseModel.getBjdm(); //根据班级代码 去干更多事情

            //统计班级人数
            List mListStudent = getStudentList(bjdm);
            System.out.println(mListStudent.size());
            oneMap.put("studentAll", mListStudent.size());

            //昨天晚归
            HashMap<String,Object> searchMap = new HashMap<>();
//            searchMap.put("showTime", bdXgxtXgxtBjfdyxxQywx.getShowTime());
            searchMap.put("startshowTime", bdXgxtXgxtBjfdyxxQywx.getStartshowTime());
            searchMap.put("endshowTime", bdXgxtXgxtBjfdyxxQywx.getEndshowTime());
            searchMap.put("lateStatus", 2);
            searchMap.put("bjdm", bjdm);
            oneMap.put("lateNum", getLateStudentNum(searchMap));
            //未归人数
            HashMap<String,Object> searchNoBackMap = new HashMap<>();
//            searchNoBackMap.put("showTime", bdXgxtXgxtBjfdyxxQywx.getShowTime());
            searchNoBackMap.put("startshowTime", bdXgxtXgxtBjfdyxxQywx.getStartshowTime());
            searchNoBackMap.put("endshowTime", bdXgxtXgxtBjfdyxxQywx.getEndshowTime());
            searchNoBackMap.put("lateStatus", "0");
            searchNoBackMap.put("bjdm", bjdm);
            oneMap.put("noBackNum", getLateStudentNum(searchNoBackMap));

            //黄牌警告
            HashMap<String, Object> searchYellowWaring = new HashMap<>();
            searchYellowWaring.put("bjdm", bjdm);
            searchYellowWaring.put("getYellowWaring", 1);
            searchYellowWaring.put("groupByField", "bjdm");
            searchYellowWaring.put("startshowTime", bdXgxtXgxtBjfdyxxQywx.getStartshowTime());
            searchYellowWaring.put("endshowTime", bdXgxtXgxtBjfdyxxQywx.getEndshowTime());
            String yellowWaringNum = getWaringCount(searchYellowWaring);
            oneMap.put("yellowWaringNum",yellowWaringNum);

            //红牌警告
            HashMap<String, Object> searchRedWaring = new HashMap<>();
            searchRedWaring.put("bjdm", bjdm);
            searchRedWaring.put("getRedWaring", 1);
            searchRedWaring.put("groupByField", "bjdm");
            searchRedWaring.put("startshowTime", bdXgxtXgxtBjfdyxxQywx.getStartshowTime());
            searchRedWaring.put("endshowTime", bdXgxtXgxtBjfdyxxQywx.getEndshowTime());
            String redWaringNum = getWaringCount(searchRedWaring);
            oneMap.put("redWaringNum",redWaringNum);

            //未处理
            oneMap.put("teachNoStatusNum", getTeachNoStatus(bjdm,bdXgxtXgxtBjfdyxxQywx.getStartshowTime(),bdXgxtXgxtBjfdyxxQywx.getEndshowTime()));
            listReturnTeach.add(oneMap);
        }
        returnMap.put("rows", listReturnTeach);
        returnMap.put("total", new PageInfo(list).getTotal());
        returnMap.put("pageNum", new PageInfo(list).getPageNum());
        returnMap.put("pageSize", new PageInfo(list).getPageSize());
        returnMap.put("pages", new PageInfo(list).getPages());
        returnList.add(returnMap);
        return AjaxResult.success(returnMap);
    }

    /**
     * 通过班级获取学学生
     *
     * @param bjdm
     * @return
     */
    private List getStudentList(String bjdm) {
        BdZtsjZtsjJwzxsxxQywx searchModel = new BdZtsjZtsjJwzxsxxQywx();
        searchModel.setBjdm(bjdm);
        PageHelper.startPage(1, 1, "");
        List<BdZtsjZtsjJwzxsxxQywx> mListStudent = bdZtsjZtsjJwzxsxxQywxServiceImpl.selectBdZtsjZtsjJwzxsxxQywxList(searchModel);
        return mListStudent;
    }

    @Autowired
    private EachDayService eachDayService;

    //按时间获取晚归列表
    private List getLateStudentList(HashMap<String, Object> searchMap) {
        PageHelper.startPage(1, 1, "");
        List<EachDayModel> mListEachDay = eachDayService.getList(searchMap);
        return mListEachDay;
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
    private String getWaringCount(HashMap<String, Object> searchMap){
        PageHelper.startPage(1, 1, "");
        List<Map<String, Object>> mListWaring = sysRecordWaringServiceImpl.getCount(searchMap);
        String yNum ="0";
        if(mListWaring.size()>0){
            Map<String,Object> yMap = mListWaring.get(0);
            yNum = yMap.get("allNum").toString();
        }
        return yNum;
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
        searchMap.put("startshowTime",startshowTime);
        searchMap.put("endshowTime",endshowTime);
//        searchMap.put("groupByFieldName", "bjdm");
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

    @Autowired
    private TokenService tokenService;
    @ApiOperation("每日统计")
//    @PreAuthorize("@ss.hasPermi('record:total:daylist')")
    @GetMapping("/daylist")
    public TableDataInfo daylist(UserLate userLate) {
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        if(!roleIds.equals(100L)){
            userLate.setTeachId(loginUser.getUsername());
        }
        String dwdm = "";
        if(roleIds.equals(110L)){
            dwdm = loginUser.getUser().getRemark()+"";
            userLate.setTeachId(null);
            userLate.setDwdm(dwdm);
        }
        //昨天晚归人数
        startPage();
//        if (StrKit.isEmpty(userLate.getShowTime())) {
//            userLate.setShowTime(DateUtils.getBeforeDateStr());
//        }
        if (StrKit.isEmpty(userLate.getLateStatus())) {
            userLate.setLateStatus(2);
        }
        List<UserLate> mListUserLate = userLateService.selectUserLateList(userLate);
        return getDataTable(mListUserLate);
    }

    @Autowired
    private IBdStudentGreadService bdStudentGreadService;

    @ApiOperation("按学院统计")
//    @PreAuthorize("@ss.hasPermi('record:total:xydaylist')")
    @GetMapping("/xydaylist")
    public AjaxResult xydaylist(UserLate userLate) {
        //昨天晚归人数
//        if (StrKit.isEmpty(eachDayModel.getShowTime())) {
//            eachDayModel.setShowTime(DateUtils.getBeforeDateStr());
//        }
//        String lateTimeStart = eachDayModel.getShowTime() + " 22:30:00";
//        String lateTimeEnd = eachDayModel.getShowTime() + " 23:59:59";
        //返回数据
        List<HashMap<String, Object>> returnList = new ArrayList<>();
        //返回数据
        HashMap<String, Object> returnMap = new HashMap<>();
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        String dwdmLogin = "";
        if(roleIds.equals(110L)){
            dwdmLogin = loginUser.getUser().getRemark()+"";
            userLate.setDwdm(dwdmLogin);
        }

        startPage();
        BdStudentGread bdStudentGread = new BdStudentGread();
        bdStudentGread.setSearchValue("`dwdm`");
        List<BdStudentGread> list = bdStudentGreadService.selectBdStudentGreadGroupZyList(bdStudentGread);
        List<Map<String, Object>> listReturnGread = new ArrayList<>();
        for (BdStudentGread oneModel : list){
            Map<String, Object> oneMap = BeanUtils.convertBeanToMap(oneModel);
            String dwdm = oneModel.getDwdm(); //根据班级代码 去干更多事情
            //晚归人数
            HashMap<String,Object> searchMap = new HashMap<>();
//            searchMap.put("showTime", eachDayModel.getShowTime());
            searchMap.put("startshowTime", userLate.getStartshowTime());
            searchMap.put("endshowTime", userLate.getEndshowTime());
            searchMap.put("lateStatus", 2);


            searchMap.put("dwdm", dwdm);
            oneMap.put("lateNum", getLateStudentNum(searchMap));
            //未归人数
            HashMap<String,Object> searchNoBackMap = new HashMap<>();
//            searchNoBackMap.put("showTime", eachDayModel.getShowTime());
            searchNoBackMap.put("startshowTime", userLate.getStartshowTime());
            searchNoBackMap.put("endshowTime", userLate.getEndshowTime());
            searchNoBackMap.put("lateStatus", "0");


            searchNoBackMap.put("dwdm", dwdm);
            oneMap.put("noBackNum", getLateStudentNum(searchNoBackMap));

            //黄牌警告
            HashMap<String, Object> searchYellowWaring = new HashMap<>();
            searchYellowWaring.put("dwdm", dwdm);
            searchYellowWaring.put("getYellowWaring", 1);
            searchYellowWaring.put("groupByField", "dwdm");
            searchYellowWaring.put("startshowTime", userLate.getStartshowTime());
            searchYellowWaring.put("endshowTime", userLate.getEndshowTime());
            String yellowWaringNum = getWaringCount(searchYellowWaring);
            oneMap.put("yellowWaringNum",yellowWaringNum);

            //红牌警告
            HashMap<String, Object> searchRedWaring = new HashMap<>();
            searchRedWaring.put("dwdm", dwdm);
            searchRedWaring.put("getRedWaring", 1);
            searchRedWaring.put("groupByField", "dwdm");
            searchRedWaring.put("startshowTime", userLate.getStartshowTime());
            searchRedWaring.put("endshowTime", userLate.getEndshowTime());
            String redWaringNum = getWaringCount(searchRedWaring);
            oneMap.put("redWaringNum",redWaringNum);

            //未处理
            oneMap.put("teachNoStatusNum", getTeachNoStatusByDwdm(dwdm,userLate.getStartshowTime(), userLate.getEndshowTime()));
            listReturnGread.add(oneMap);
        }
        returnMap.put("rows", listReturnGread);
        returnMap.put("total", new PageInfo(list).getTotal());
        returnMap.put("pageNum", new PageInfo(list).getPageNum());
        returnMap.put("pageSize", new PageInfo(list).getPageSize());
        returnMap.put("pages", new PageInfo(list).getPages());
        returnList.add(returnMap);
        return AjaxResult.success(returnList);
    }

    /**
     * 获取老师没有处理的列表
     *
     * @param dwdm
     * @param startshowTime
     * @param endshowTime
     * @return
     */
    private String getTeachNoStatusByDwdm(String dwdm, String startshowTime, String endshowTime){
        HashMap<String,Object> searchMap = new HashMap<>();
        searchMap.put("teachStatus", -1);
        searchMap.put("dwdm", dwdm);
//        searchMap.put("showTime",showTime);
        searchMap.put("startshowTime",startshowTime);
        searchMap.put("endshowTime",endshowTime);
        startPage();
        List<Map<String,Object>> list = userLateService.getList(searchMap);
        if(list.size() <1){
            return "0";
        }

        Map<String,Object> oneMap = list.get(0);
        String total = "0";
        if(!StrKit.isEmpty(oneMap.get("num"))){
            total =oneMap.get("num").toString();
        }
        return total + "";
    }

    @Autowired
    private ISysRecordWaringService sysRecordWaringService;

    /**
     * 查询学生晚归次数告警信息列表
     */
    @ApiOperation("警告列表（按照班级统计）")
//    @PreAuthorize("@ss.hasPermi('record:waring:list')")
    @GetMapping("/listbybjdm")
    public AjaxResult listbybjdm(SysRecordWaring sysRecordWaring)
    {
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
            searchYellowWaring.put("startshowTime", sysRecordWaring.getStartshowTime());
            searchYellowWaring.put("endshowTime", sysRecordWaring.getEndshowTime());
            String yellowWaringNum = getWaringCount(searchYellowWaring);
            oneMap.put("yellowWaringNum",yellowWaringNum);

            //红牌警告人数
            HashMap<String, Object> searchRedWaring = new HashMap<>();
            searchRedWaring.put("bjdm", bjdm);
            searchRedWaring.put("getRedWaring", 1);
            searchRedWaring.put("groupByField", "bjdm");
            searchRedWaring.put("startshowTime", sysRecordWaring.getStartshowTime());
            searchRedWaring.put("endshowTime", sysRecordWaring.getEndshowTime());
            String redWaringNum = getWaringCount(searchRedWaring);
            oneMap.put("redWaringNum",redWaringNum);

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

}
