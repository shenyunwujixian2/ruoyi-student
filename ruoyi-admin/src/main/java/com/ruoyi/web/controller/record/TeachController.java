package com.ruoyi.web.controller.record;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.dbbase.domain.BdStudentGread;
import com.ruoyi.dbbase.domain.BdXgxtXgxtBjfdyxxQywx;
import com.ruoyi.dbbase.domain.BdZtsjZtsjJwzxsxxQywx;
import com.ruoyi.dbbase.service.impl.BdStudentGreadServiceImpl;
import com.ruoyi.dbbase.service.impl.BdXgxtXgxtBjfdyxxQywxServiceImpl;
import com.ruoyi.dbbase.service.impl.BdZtsjZtsjJwzxsxxQywxServiceImpl;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.late.domain.TeachLateNum;
import com.ruoyi.late.service.IUserLateService;
import com.ruoyi.person.Bean.UniResult;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.service.EachDayService;
import com.ruoyi.record.service.impl.SysRecordWaringServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 用户信息
 *
 * @author ruoyi
 */
@Api(tags = "3.3、教师管理")
@RestController
@RequestMapping("/record/teach")
public class TeachController extends BaseController {
    //学工班级辅导信息 辅导员信息
    @Autowired
    private BdXgxtXgxtBjfdyxxQywxServiceImpl bdXgxtXgxtBjfdyxxQywxServiceImpl;
    //教务在校生信息
    @Autowired
    private BdZtsjZtsjJwzxsxxQywxServiceImpl bdZtsjZtsjJwzxsxxQywxServiceImpl;
    //教务在校生信息
    @Autowired
    private BdStudentGreadServiceImpl bdStudentGreadServiceImpl;

    @Autowired
    private TokenService tokenService;


    @ApiOperation("辅导员查询")
    @GetMapping("/list")
    public AjaxResult list(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx) {
        HashMap<String, Object> returnMap = getReturnMap(bdXgxtXgxtBjfdyxxQywx);
        return AjaxResult.success(returnMap);
    }

    @ApiOperation("4月29日、辅导员查询导出")
    @GetMapping("/listexport")
    public AjaxResult listexport(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx) {
        HashMap<String, Object> returnMap = getReturnMap(bdXgxtXgxtBjfdyxxQywx);
        List<Map<String, Object>> list = (List<Map<String, Object>>) returnMap.get("rows");
        List<TeachLateNum> listExport = new ArrayList<>();
        for (Map<String,Object> oneMap : list){
            TeachLateNum baseModel = (TeachLateNum) BeanUtils.convertMapToBean(oneMap,TeachLateNum.class);
            listExport.add(baseModel);
        }
        ExcelUtil<TeachLateNum> util = new ExcelUtil<>(TeachLateNum.class);
        return util.exportExcel(listExport, "辅导员查询导出");
    }

    /**
     * 公共方法
     * @param bdXgxtXgxtBjfdyxxQywx
     * @return
     */
    private HashMap<String, Object> getReturnMap(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx){
        //返回数据
        HashMap<String, Object> returnMap = new HashMap<>();
        bdXgxtXgxtBjfdyxxQywx = addSearchValue(bdXgxtXgxtBjfdyxxQywx);
        startPage();
        List<BdXgxtXgxtBjfdyxxQywx> list = bdXgxtXgxtBjfdyxxQywxServiceImpl.selectBdXgxtXgxtBjfdyxxQywxList(bdXgxtXgxtBjfdyxxQywx);

        List<Map<String, Object>> listReturnTeach = new ArrayList<>();
        for (BdXgxtXgxtBjfdyxxQywx baseModel : list) {
            Map<String, Object> oneMap = BeanUtils.convertBeanToMap(baseModel);
            String bjdm = baseModel.getBjdm(); //根据班级代码 去干更多事情
//            //统计班级人数
//            List mListStudent = getStudentList(bjdm);
//            System.out.println(mListStudent.size());
//            oneMap.put("studentAll", new PageInfo(mListStudent).getTotal());
            //晚归人数
            HashMap<String,Object> searchMap = new HashMap<>();
//            searchMap.put("showTime", DateUtils.getBeforeDateStr());
            searchMap.put("startshowTime", bdXgxtXgxtBjfdyxxQywx.getStartshowTime());
            searchMap.put("endshowTime", bdXgxtXgxtBjfdyxxQywx.getEndshowTime());
            searchMap.put("lateStatus", "2");
            searchMap.put("bjdm", bjdm);
            oneMap.put("lateNum", getLateStudentNum(searchMap));
            //未归人数
            HashMap<String,Object> searchNoBackMap = new HashMap<>();
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
            String yellowWaringNum = getWaringCount(searchYellowWaring);
            oneMap.put("yellowWaringNum",yellowWaringNum);

            //红牌警告
            HashMap<String, Object> searchRedWaring = new HashMap<>();
            searchRedWaring.put("bjdm", bjdm);
            searchRedWaring.put("getRedWaring", 1);
            searchRedWaring.put("groupByField", "bjdm");
            String redWaringNum = getWaringCount(searchRedWaring);
            oneMap.put("redWaringNum",redWaringNum);

            //未处理
            oneMap.put("teachNoStatusNum", getTeachNoStatus(bjdm,bdXgxtXgxtBjfdyxxQywx.getStartshowTime(), bdXgxtXgxtBjfdyxxQywx.getEndshowTime()));
            listReturnTeach.add(oneMap);
        }
        returnMap.put("rows", listReturnTeach);
        returnMap.put("total", new PageInfo(list).getTotal());
        returnMap.put("pageNum", new PageInfo(list).getPageNum());
        returnMap.put("pageSize", new PageInfo(list).getPageSize());
        returnMap.put("pages", new PageInfo(list).getPages());
        return returnMap;
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

    private String getTeachNoStatus(String bjdm,String startshowTime,String endshowTime){
       return getTeachNoStatus(bjdm, startshowTime,endshowTime,null );
    }
    /**
     * 获取老师没有处理的列表
     * @param bjdm
     * @return
     */
    private String getTeachNoStatus(String bjdm,String startshowTime,String endshowTime, String teachId){
        HashMap<String,Object> searchMap = new HashMap<>();
        searchMap.put("teachStatus", -1);
        if(null!= bjdm){
            searchMap.put("bjdm", bjdm);
        }
        if(null!= teachId){
            searchMap.put("teachId", teachId);
        }
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



//    @ApiOperation("辅导员管理")
//    @PreAuthorize("@ss.hasPermi('system:teach:list')")
    @GetMapping("/managelist")
    public AjaxResult managelist(EachDayModel eachDayModel) {
        //晚归人数
        if (StrKit.isEmpty(eachDayModel.getShowTime())) {
            eachDayModel.setShowTime(DateUtils.getDate());
        }
        String lateTimeStart = eachDayModel.getShowTime() + " 22:30:00";
        String lateTimeEnd = eachDayModel.getShowTime() + " 23:59:59";
        HashMap<String, Object> searchMapLate = new HashMap<>();
        searchMapLate.put("showTime", DateUtils.getDate());
        searchMapLate.put("lateStart", lateTimeStart);
        searchMapLate.put("lateEnd", lateTimeEnd);
        //按学院称查
        if(StrKit.isEmpty(eachDayModel.getDwdm())){
            searchMapLate.put("dwdm", eachDayModel.getDwdm());
        }
        if(StrKit.isEmpty(eachDayModel.getDwmc())){
            searchMapLate.put("dwmc", eachDayModel.getDwmc());
        }
        //按班级代码
        if(StrKit.isEmpty(eachDayModel.getBjdm())){
            searchMapLate.put("bjdm", eachDayModel.getBjdm());
        }
        if(StrKit.isEmpty(eachDayModel.getBjjc())){
            searchMapLate.put("bjjc", eachDayModel.getBjjc());
        }
        //辅导员
        if(StrKit.isEmpty(eachDayModel.getTeachId())){
            searchMapLate.put("teachId", eachDayModel.getTeachId());
        }
        //辅导员名称
        if(StrKit.isEmpty(eachDayModel.getTeachName())){
            searchMapLate.put("teachName", eachDayModel.getTeachName());
        }
        //姓名
        if(StrKit.isEmpty(eachDayModel.getXm())){
            searchMapLate.put("xm", eachDayModel.getXm());
        }

        List mListLateStudent = getLateStudentList(searchMapLate);
        return AjaxResult.success(mListLateStudent);
    }


    @ApiOperation("4.14（日）按辅导员查询")
//    @PreAuthorize("@ss.hasPermi('record:teach:listbyteach')")
    @GetMapping("/listbyteach")
    public AjaxResult listbyteach(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx) {
        HashMap<String, Object> returnMap = getTeachReturnMap(bdXgxtXgxtBjfdyxxQywx);
        return AjaxResult.success(returnMap);
    }

    @ApiOperation("4.29（日）按辅导员统计导出")
    @GetMapping("/listbyteachexport")
    public AjaxResult listbyteachexport(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx) {
        HashMap<String, Object> returnMap = getTeachReturnMap(bdXgxtXgxtBjfdyxxQywx);
        List<Map<String, Object>> list = (List<Map<String, Object>>) returnMap.get("rows");
        List<TeachLateNum> listExport = new ArrayList<>();
        for (Map<String,Object> oneMap : list){
            TeachLateNum baseModel = (TeachLateNum) BeanUtils.convertMapToBean(oneMap,TeachLateNum.class);
            listExport.add(baseModel);
        }
        ExcelUtil<TeachLateNum> util = new ExcelUtil<>(TeachLateNum.class);
        return util.exportExcel(listExport, "辅导员统计导出");
    }

    /**
     * 返回 辅导员
     * @param bdXgxtXgxtBjfdyxxQywx
     * @return
     */
    private   HashMap<String, Object> getTeachReturnMap(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx) {
        //返回数据
        HashMap<String, Object> returnMap = new HashMap<>();
        bdXgxtXgxtBjfdyxxQywx = addSearchValue(bdXgxtXgxtBjfdyxxQywx);
        bdXgxtXgxtBjfdyxxQywx.setSearchValue("groupByJZGH");
        startPage();
        List<BdXgxtXgxtBjfdyxxQywx> list = bdXgxtXgxtBjfdyxxQywxServiceImpl.selectBdXgxtXgxtBjfdyxxQywxList(bdXgxtXgxtBjfdyxxQywx);

        List<Map<String, Object>> listReturnTeach = new ArrayList<>();
        for (BdXgxtXgxtBjfdyxxQywx baseModel : list) {
            Map<String, Object> oneMap = BeanUtils.convertBeanToMap(baseModel);

            String teachId = baseModel.getFdyjzgh(); //根据班级代码 去干更多事情
            //晚归人数
            HashMap<String,Object> searchMap = new HashMap<>();
//            searchMap.put("showTime", DateUtils.getBeforeDateStr());
            searchMap.put("startshowTime", bdXgxtXgxtBjfdyxxQywx.getStartshowTime());
            searchMap.put("endshowTime", bdXgxtXgxtBjfdyxxQywx.getEndshowTime());
            searchMap.put("lateStatus", "2");
            searchMap.put("teachId", teachId);
            oneMap.put("lateNum", getLateStudentNum(searchMap));
            //未归人数
            HashMap<String,Object> searchNoBackMap = new HashMap<>();
            searchNoBackMap.put("startshowTime", bdXgxtXgxtBjfdyxxQywx.getStartshowTime());
            searchNoBackMap.put("endshowTime", bdXgxtXgxtBjfdyxxQywx.getEndshowTime());
            searchNoBackMap.put("lateStatus", "0");
            searchNoBackMap.put("teachId", teachId);
            oneMap.put("noBackNum", getLateStudentNum(searchNoBackMap));
            //黄牌警告
            HashMap<String, Object> searchYellowWaring = new HashMap<>();
            searchYellowWaring.put("teachId", teachId);
            searchYellowWaring.put("getYellowWaring", 1);
            searchYellowWaring.put("groupByField", "teach_id");
            String yellowWaringNum = getWaringCount(searchYellowWaring);
            oneMap.put("yellowWaringNum",yellowWaringNum);

            //红牌警告
            HashMap<String, Object> searchRedWaring = new HashMap<>();
            searchRedWaring.put("teachId", teachId);
            searchRedWaring.put("getRedWaring", 1);
            searchRedWaring.put("groupByField", "teach_id");
            String redWaringNum = getWaringCount(searchRedWaring);
            oneMap.put("redWaringNum",redWaringNum);

            //未处理
            oneMap.put("teachNoStatusNum", getTeachNoStatus(null,bdXgxtXgxtBjfdyxxQywx.getStartshowTime(), bdXgxtXgxtBjfdyxxQywx.getEndshowTime(), teachId));
            listReturnTeach.add(oneMap);
        }
        returnMap.put("rows", listReturnTeach);
        returnMap.put("total", new PageInfo(list).getTotal());
        returnMap.put("pageNum", new PageInfo(list).getPageNum());
        returnMap.put("pageSize", new PageInfo(list).getPageSize());
        returnMap.put("pages", new PageInfo(list).getPages());
        return  returnMap;
    }


    private BdXgxtXgxtBjfdyxxQywx addSearchValue(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx){
        try {
            //获取用户权限 增加查询列表
            LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            Long roleIds = loginUser.getUser().getDeptId();
            if(!roleIds.equals(100L)){
                bdXgxtXgxtBjfdyxxQywx.setFdyjzgh(loginUser.getUsername());
            }
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
        }catch (Exception e){

        }
        return  bdXgxtXgxtBjfdyxxQywx;
    }


}
