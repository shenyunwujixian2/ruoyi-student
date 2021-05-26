package com.ruoyi.open;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.dbbase.domain.BdStudentGread;
import com.ruoyi.dbbase.domain.BdXgxtXgxtBjfdyxxQywx;
import com.ruoyi.dbbase.domain.BdZtsjZtsjJwzxsxxQywx;
import com.ruoyi.dbbase.service.IBdStudentGreadService;
import com.ruoyi.dbbase.service.impl.BdXgxtXgxtBjfdyxxQywxServiceImpl;
import com.ruoyi.dbbase.service.impl.BdZtsjZtsjJwzxsxxQywxServiceImpl;
import com.ruoyi.late.domain.SysRecordPushMessageHistory;
import com.ruoyi.late.domain.UserLate;
import com.ruoyi.late.service.IUserLateService;
import com.ruoyi.late.service.impl.SysRecordPushMessageHistoryServiceImpl;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.domain.SysRecordWaring;
import com.ruoyi.record.service.EachDayService;
import com.ruoyi.record.service.ISysRecordWaringService;
import com.ruoyi.record.service.impl.SysRecordWaringServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息
 *
 * @author ruoyi
 */
@Api(tags = "3.33、查询统计（不需要登陆）")
@RestController
@RequestMapping("/open/total")
public class OpenTatalController extends BaseController {
    //学工班级辅导信息 辅导员信息
    @Autowired
    private BdXgxtXgxtBjfdyxxQywxServiceImpl bdXgxtXgxtBjfdyxxQywxServiceImpl;
    //教务在校生信息
    @Autowired
    private BdZtsjZtsjJwzxsxxQywxServiceImpl bdZtsjZtsjJwzxsxxQywxServiceImpl;

    @ApiOperation("按照辅导员查询未归统计")
//    @PreAuthorize("@ss.hasPermi('record:total:list')")
    @GetMapping("/list")
    public AjaxResult list(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx) {
        if (StrKit.isEmpty(bdXgxtXgxtBjfdyxxQywx.getShowTime())) {
            bdXgxtXgxtBjfdyxxQywx.setShowTime(DateUtils.getBeforeDateStr());
        }

        //返回数据
        List<HashMap<String, Object>> returnList = new ArrayList<>();
        //返回数据
        HashMap<String, Object> returnMap = new HashMap<>();
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
            searchMap.put("showTime", bdXgxtXgxtBjfdyxxQywx.getShowTime());
            searchMap.put("lateStatus", 2);
            searchMap.put("bjdm", bjdm);
            oneMap.put("lateNum", getLateStudentNum(searchMap));
            //未归人数
            HashMap<String,Object> searchNoBackMap = new HashMap<>();
            searchNoBackMap.put("showTime", bdXgxtXgxtBjfdyxxQywx.getShowTime());
            searchNoBackMap.put("lateStatus", "0");
            searchNoBackMap.put("bjdm", bjdm);
            oneMap.put("noBackNum", getLateStudentNum(searchNoBackMap));

            //黄牌警告
            HashMap<String, Object> searchYellowWaring = new HashMap<>();
            searchYellowWaring.put("bjdm", bjdm);
            searchYellowWaring.put("getYellowWaring", 1);
            searchYellowWaring.put("groupByField", "bjdm");
//            List mListYellowWaring = getWaringCount(searchYellowWaring);
//            oneMap.put("yellowWaringNum",new PageInfo(mListYellowWaring).getTotal());
            String yellowWaringNum = getWaringCount(searchYellowWaring);
            oneMap.put("yellowWaringNum",yellowWaringNum);

            //红牌警告
            HashMap<String, Object> searchRedWaring = new HashMap<>();
            searchRedWaring.put("bjdm", bjdm);
            searchRedWaring.put("getRedWaring", 1);
            searchRedWaring.put("groupByField", "bjdm");
//            List mListRedWaring = getWaringCount(searchRedWaring);
//            oneMap.put("redWaringNum",new PageInfo(mListRedWaring).getTotal());
            String redWaringNum = getWaringCount(searchRedWaring);
            oneMap.put("redWaringNum",redWaringNum);

            //未处理
            oneMap.put("teachNoStatusNum", getTeachNoStatus(bjdm,bdXgxtXgxtBjfdyxxQywx.getShowTime()));
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
//    //获取警告人数
//    private List<Map<String,Object>> getWaringCount(HashMap<String, Object> searchMap){
//        PageHelper.startPage(1, 1, "");
//        List<Map<String, Object>> mListWaring = sysRecordWaringServiceImpl.getCount(searchMap);
//        return mListWaring;
//    }
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
    private String getTeachNoStatus(String bjdm, String showTime){
        HashMap<String,Object> searchMap = new HashMap<>();
        searchMap.put("teachStatus", -1);
        searchMap.put("bjdm", bjdm);
        searchMap.put("showTime",showTime);
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
    /**
     * 获取老师没有处理的列表
     *
     * @param dwdm
     * @param showTime
     * @return
     */
    private String getTeachNoStatusByDwdm(String dwdm, String showTime){
        HashMap<String,Object> searchMap = new HashMap<>();
        searchMap.put("teachStatus", -1);
        searchMap.put("dwdm", dwdm);
        searchMap.put("showTime",showTime);
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
    /**
     * 获取老师没有处理的列表
     *
     * @param zydm
     * @param showTime
     * @return
     */
    private String getTeachNoStatusByZydm(String zydm, String showTime){
        HashMap<String,Object> searchMap = new HashMap<>();
        searchMap.put("teachStatus", -1);
        searchMap.put("zydm", zydm);
        searchMap.put("showTime",showTime);
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
        return total;
    }



    @ApiOperation("每日统计")
//    @PreAuthorize("@ss.hasPermi('record:total:daylist')")
    @GetMapping("/daylist")
    public TableDataInfo daylist(UserLate userLate) {
        //昨天晚归人数
        startPage();
        if (StrKit.isEmpty(userLate.getShowTime())) {
            userLate.setShowTime(DateUtils.getBeforeDateStr());
        }
        if (StrKit.isEmpty(userLate.getLateStatus())) {
            userLate.setLateStatus(2);
        }
        List<UserLate> mListUserLate = userLateService.selectUserLateList(userLate);
        return getDataTable(mListUserLate);
    }

    @Autowired
    private IBdStudentGreadService bdStudentGreadService;

    @ApiOperation("按学院统计")
    @GetMapping("/xydaylist")
    public AjaxResult xydaylist(EachDayModel eachDayModel) {
        //昨天晚归人数
        if (StrKit.isEmpty(eachDayModel.getShowTime())) {
            eachDayModel.setShowTime(DateUtils.getBeforeDateStr());
        }
//        String lateTimeStart = eachDayModel.getShowTime() + " 22:30:00";
//        String lateTimeEnd = eachDayModel.getShowTime() + " 23:59:59";
        //返回数据
        List<HashMap<String, Object>> returnList = new ArrayList<>();
        //返回数据
        HashMap<String, Object> returnMap = new HashMap<>();
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
            searchMap.put("showTime", eachDayModel.getShowTime());
            searchMap.put("lateStatus", 2);
            searchMap.put("dwdm", dwdm);
            oneMap.put("lateNum", getLateStudentNum(searchMap));
            //未归人数
            HashMap<String,Object> searchNoBackMap = new HashMap<>();
            searchNoBackMap.put("showTime", eachDayModel.getShowTime());
            searchNoBackMap.put("lateStatus", "0");
            searchNoBackMap.put("dwdm", dwdm);
            oneMap.put("noBackNum", getLateStudentNum(searchNoBackMap));

            //未处理
            oneMap.put("teachNoStatusNum", getTeachNoStatusByDwdm(dwdm,eachDayModel.getShowTime()));
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

    @ApiOperation("按学院下的专业统计")
    @GetMapping("/zydaylist")
    public AjaxResult zydaylist(EachDayModel eachDayModel) {
        //昨天晚归人数
        if (StrKit.isEmpty(eachDayModel.getShowTime())) {
            eachDayModel.setShowTime(DateUtils.getBeforeDateStr());
        }
//        String lateTimeStart = eachDayModel.getShowTime() + " 22:30:00";
//        String lateTimeEnd = eachDayModel.getShowTime() + " 23:59:59";
        //返回数据
        List<HashMap<String, Object>> returnList = new ArrayList<>();
        //返回数据
        HashMap<String, Object> returnMap = new HashMap<>();
        startPage();
        BdStudentGread bdStudentGread = new BdStudentGread();
        if(!StrKit.isEmpty(eachDayModel.getDwdm())){
            bdStudentGread.setDwdm(eachDayModel.getDwdm());
        }
        bdStudentGread.setSearchValue("`zydm`");
        List<BdStudentGread> list = bdStudentGreadService.selectBdStudentGreadGroupZyList(bdStudentGread);

        List<Map<String, Object>> listReturnGread = new ArrayList<>();
        for (BdStudentGread oneModel : list){
            Map<String, Object> oneMap = BeanUtils.convertBeanToMap(oneModel);
            String zydm = oneModel.getZydm(); //根据班级代码 去干更多事情
            //晚归人数
            HashMap<String,Object> searchMap = new HashMap<>();
            searchMap.put("showTime", eachDayModel.getShowTime());
            searchMap.put("lateStatus", 2);
            searchMap.put("zydm", zydm);
            oneMap.put("lateNum", getLateStudentNum(searchMap));
            //未归人数
            HashMap<String,Object> searchNoBackMap = new HashMap<>();
            searchNoBackMap.put("showTime", eachDayModel.getShowTime());
            searchNoBackMap.put("lateStatus", "0");
            searchNoBackMap.put("zydm", zydm);
            oneMap.put("noBackNum", getLateStudentNum(searchNoBackMap));

            //未处理
            oneMap.put("teachNoStatusNum",getTeachNoStatusByZydm(zydm,eachDayModel.getShowTime()));
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
        String showTime = DateUtils.getBeforeDateStr();
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
            searchMap.put("showTime", showTime);
            searchMap.put("lateStatus", 2);
            searchMap.put("bjdm", bjdm);
            oneMap.put("lateNum", getLateStudentNum(searchMap));

            // 未回寝人数
            HashMap<String,Object> searchNoBackMap = new HashMap<>();
            searchNoBackMap.put("showTime", showTime);
            searchNoBackMap.put("lateStatus", "0");
            searchNoBackMap.put("bjdm", bjdm);
            oneMap.put("noBackNum", getLateStudentNum(searchNoBackMap));

            //班级的黄牌警告
            HashMap<String, Object> searchYellowWaring = new HashMap<>();
            searchYellowWaring.put("bjdm", bjdm);
            searchYellowWaring.put("getYellowWaring", 1);
            searchYellowWaring.put("groupByField", "bjdm");
//            List mListYellowWaring = getWaringCount(searchYellowWaring);
//            oneMap.put("yellowWaringNum",new PageInfo(mListYellowWaring).getTotal());
            String yellowWaringNum = getWaringCount(searchYellowWaring);
            oneMap.put("yellowWaringNum",yellowWaringNum);
            //红牌警告人数
            HashMap<String, Object> searchRedWaring = new HashMap<>();
            searchRedWaring.put("bjdm", bjdm);
            searchRedWaring.put("getRedWaring", 1);
            searchRedWaring.put("groupByField", "bjdm");
//            List mListRedWaring = getWaringCount(searchRedWaring);
//            oneMap.put("redWaringNum",new PageInfo(mListRedWaring).getTotal());
            String redWaringNum = getWaringCount(searchRedWaring);
            oneMap.put("redWaringNum",redWaringNum);

            //未处理
            oneMap.put("teachNoStatusNum", getTeachNoStatus(bjdm,showTime));
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

    //推送消息信息
    @Autowired
    private SysRecordPushMessageHistoryServiceImpl sysRecordPushMessageHistoryServiceImpl;
    /**
     * 查询迟到晚归信息列表
     */
    @ApiOperation("4.2.1.-1、发送的消息中绑定信息(学院领导)")
    @GetMapping("/showleader")
    public AjaxResult showleader(SearchMessageModel searchMessageModel) {
        if (StrKit.isEmpty(searchMessageModel.getName())) {
            return AjaxResult.error("消息字符串不能为空");
        }
        SysRecordPushMessageHistory sysRecordPushMessageHistory = new SysRecordPushMessageHistory();
        sysRecordPushMessageHistory.setName(searchMessageModel.getName());
        List<SysRecordPushMessageHistory> mList = sysRecordPushMessageHistoryServiceImpl.selectSysRecordPushMessageHistoryList(sysRecordPushMessageHistory);
        if (mList.size() < 1) {
            return AjaxResult.error("数据不存在");
        }
        SysRecordPushMessageHistory baseModel = mList.get(0);
        if(baseModel==null){
            return AjaxResult.error("消息数据错误");
        }
        //设置查询条件
        UserLate serLateModel = new UserLate();
        serLateModel.setDwdm(baseModel.getToUser()); //专业代码传进查询条件
        if (StrKit.isEmpty(baseModel.getShowTime())) {
            serLateModel.setShowTime(DateUtils.getBeforeDateStr());
        }else {
            serLateModel.setShowTime(baseModel.getShowTime());
        }
        //返回数据
        List<HashMap<String, Object>> returnList = new ArrayList<>();
        //返回数据
        HashMap<String, Object> returnMap = new HashMap<>();
        startPage();
        BdStudentGread bdStudentGread = new BdStudentGread();
        if(!StrKit.isEmpty(serLateModel.getDwdm())){
            bdStudentGread.setDwdm(serLateModel.getDwdm());
        }
        bdStudentGread.setSearchValue("`zydm`");
        List<BdStudentGread> list = bdStudentGreadService.selectBdStudentGreadGroupZyList(bdStudentGread);

        List<Map<String, Object>> listReturnGread = new ArrayList<>();
        for (BdStudentGread oneModel : list){
            Map<String, Object> oneMap = BeanUtils.convertBeanToMap(oneModel);
            String zydm = oneModel.getZydm(); //根据班级代码 去干更多事情
            //晚归人数
            HashMap<String,Object> searchMap = new HashMap<>();
            searchMap.put("showTime", serLateModel.getShowTime());
            searchMap.put("lateStatus", 2);
            searchMap.put("zydm", zydm);
            oneMap.put("lateNum", getLateStudentNum(searchMap));
            //未归人数
            HashMap<String,Object> searchNoBackMap = new HashMap<>();
            searchNoBackMap.put("showTime", serLateModel.getShowTime());
            searchNoBackMap.put("lateStatus", "0");
            searchNoBackMap.put("zydm", zydm);
            oneMap.put("noBackNum", getLateStudentNum(searchNoBackMap));

            //未处理
            oneMap.put("teachNoStatusNum",getTeachNoStatusByZydm(zydm,serLateModel.getShowTime()));
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

}
