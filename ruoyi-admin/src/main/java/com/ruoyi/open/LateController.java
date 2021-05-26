package com.ruoyi.open;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.dbbase.domain.BdStudentGread;
import com.ruoyi.dbbase.domain.BdXgxtXgxtBjfdyxxQywx;
import com.ruoyi.dbbase.service.IBdStudentGreadService;
import com.ruoyi.dbbase.service.impl.BdXgxtXgxtBjfdyxxQywxServiceImpl;
import com.ruoyi.late.domain.SysRecordPushMessageHistory;
import com.ruoyi.late.domain.UserLate;
import com.ruoyi.late.service.impl.SysRecordPushMessageHistoryServiceImpl;
import com.ruoyi.late.service.impl.UserLateServiceImpl;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.service.EachDayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 老师同消息查看内容
 *
 * @author ruoyi
 * @date 2021-03-26
 */
@Api(tags = "4.2、昨天晚归信息")
@RestController
@RequestMapping("/open/late")
public class LateController extends BaseController {
    //推送消息信息
    @Autowired
    private SysRecordPushMessageHistoryServiceImpl sysRecordPushMessageHistoryServiceImpl;
    //辅导员信息
    @Autowired
    BdXgxtXgxtBjfdyxxQywxServiceImpl bdXgxtXgxtBjfdyxxQywxServiceImpl;

    //迟到信息
    @Autowired
    private UserLateServiceImpl userLateServiceImpl;

    /**
     * 查询迟到晚归信息列表
     */
    @ApiOperation("4.2.1、发送的消息中绑定信息")
    @GetMapping("/show")
    public AjaxResult show(SearchMessageModel searchMessageModel) {
        if (StrKit.isEmpty(searchMessageModel.getName())) {
            return AjaxResult.error("请求名称不能为空");
        }
//        if (StrKit.isEmpty(searchMessageModel.getTeachStatus())) {
//            searchMessageModel.setTeachStatus(-1);
//        }
        SysRecordPushMessageHistory sysRecordPushMessageHistory = new SysRecordPushMessageHistory();
        sysRecordPushMessageHistory.setName(searchMessageModel.getName());
        List<SysRecordPushMessageHistory> mList = sysRecordPushMessageHistoryServiceImpl.selectSysRecordPushMessageHistoryList(sysRecordPushMessageHistory);
        if (mList.size() < 1) {
            return AjaxResult.error("数据不存在");
        }
        SysRecordPushMessageHistory baseModel = mList.get(0);
        BdXgxtXgxtBjfdyxxQywx searchModel = new BdXgxtXgxtBjfdyxxQywx();
        String phoneStr = baseModel.getPhone();
        String[] phoneArr = phoneStr.split("\\|");
        String fdyjzgh = phoneArr[0];
        searchModel.setFdyjzgh(fdyjzgh);// 老师电话
        List<BdXgxtXgxtBjfdyxxQywx> mListTeach = bdXgxtXgxtBjfdyxxQywxServiceImpl.selectBdXgxtXgxtBjfdyxxQywxList(searchModel);
        if (mListTeach.size() < 1) {
            return AjaxResult.error("老师信息错误");
        }
        BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx = mListTeach.get(0);
        //查询该老师下面的列表
        UserLate searchUserLate = new UserLate();
        searchUserLate.setShowTime(baseModel.getShowTime());
        searchUserLate.setTeachId(bdXgxtXgxtBjfdyxxQywx.getFdyjzgh());

        searchUserLate.setSearchValue("haveTeachStatus");
        if (searchMessageModel.getTeachStatus() == -1) {
            searchUserLate.setTeachStatus(-1); //默认选中未处理
            searchUserLate.setSearchValue(null);
        }

        List<UserLate> noBackList = userLateServiceImpl.selectUserLateList(searchUserLate);

        return AjaxResult.success(noBackList);
    }

    /**
     * 查询迟到晚归信息列表
     */
    @ApiOperation("4月20日、推送24小未出寝室学生")
    @GetMapping("/show24hour")
    public AjaxResult show24hour(SearchMessageModel searchMessageModel) {
        if (StrKit.isEmpty(searchMessageModel.getName())) {
            return AjaxResult.error("请求名称不能为空");
        }
        SysRecordPushMessageHistory sysRecordPushMessageHistory = new SysRecordPushMessageHistory();
        sysRecordPushMessageHistory.setName(searchMessageModel.getName());
        List<SysRecordPushMessageHistory> mList = sysRecordPushMessageHistoryServiceImpl.selectSysRecordPushMessageHistoryList(sysRecordPushMessageHistory);
        if (mList.size() < 1) {
            return AjaxResult.error("数据不存在");
        }
        SysRecordPushMessageHistory baseModel = mList.get(0);
        BdXgxtXgxtBjfdyxxQywx searchModel = new BdXgxtXgxtBjfdyxxQywx();
        String phoneStr = baseModel.getPhone();
        String[] phoneArr = phoneStr.split("\\|");
        String fdyjzgh = phoneArr[0];
        searchModel.setFdyjzgh(fdyjzgh);// 老师电话
        List<BdXgxtXgxtBjfdyxxQywx> mListTeach = bdXgxtXgxtBjfdyxxQywxServiceImpl.selectBdXgxtXgxtBjfdyxxQywxList(searchModel);
        if (mListTeach.size() < 1) {
            return AjaxResult.error("老师信息错误");
        }
        BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx = mListTeach.get(0);
//        //查询该老师下面的列表
//        UserLate searchUserLate = new UserLate();
//        searchUserLate.setShowTime(baseModel.getShowTime());
//        searchUserLate.setTeachId(bdXgxtXgxtBjfdyxxQywx.getFdyjzgh());
//
//        searchUserLate.setSearchValue("haveTeachStatus");
//        if (searchMessageModel.getTeachStatus() == -1) {
//            searchUserLate.setTeachStatus(-1); //默认选中未处理
//            searchUserLate.setSearchValue(null);
//        }
//        List<UserLate> noBackList = userLateServiceImpl.selectUserLateList(searchUserLate);
        int pageSize = 100;
        PageHelper.startPage(1, pageSize, "");
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("showTime", baseModel.getShowTime());
        searchMap.put("startshowTime",null);
        searchMap.put("endshowTime",null);
        searchMap.put("searchPassIsNull","1");
        searchMap.put("lastInorout","1"); //最后状态为进入
        searchMap.put("teachId", bdXgxtXgxtBjfdyxxQywx.getFdyjzgh());
        searchMap.put("searchPassTimeBig24",DateUtils.getBeforeDateStr("yyyy-MM-dd HH:mm:ss", baseModel.getSendTime()));  //当前时间的前24小时
        //24小时未出寝室列表
        List<EachDayModel> mList24NoOut = eachDayService.getList(searchMap);
        return AjaxResult.success(mList24NoOut);
    }


    /**
     * 未回归列表
     *
     * @param userLate
     * @return
     */
    @ApiOperation("4.1.1、晚归列表")
    @GetMapping("/latelist")
    public TableDataInfo latelist(UserLate userLate) {
        if (StrKit.isEmpty(userLate.getShowTime())) {
            userLate.setShowTime(DateUtils.getBeforeDateStr());
        }
        userLate.setLateStatus(2);
        startPage();
        List<UserLate> lateList = userLateServiceImpl.selectUserLateList(userLate);
        return getDataTable(lateList);
    }

    /**
     * 未回归列表
     *
     * @param userLate
     * @return
     */
    @ApiOperation("4.1.2、未归列表")
    @GetMapping("/nobacklist")
    public TableDataInfo nobacklist(UserLate userLate) {
        if (StrKit.isEmpty(userLate.getShowTime())) {
            userLate.setShowTime(DateUtils.getBeforeDateStr());
        }
        userLate.setLateStatus(0);
        startPage();
        List<UserLate> noBackList = userLateServiceImpl.selectUserLateList(userLate);

        return getDataTable(noBackList);
    }

    /**
     * 未回归列表
     *
     * @param userLate
     * @return
     */
    @ApiOperation("4.1.3、老师未处理列表")
    @GetMapping("/noteachstatuslist")
    public AjaxResult noteachstatuslist(UserLate userLate) {
        userLate.setSearchValue("haveTeachStatus");
        if (StrKit.isEmpty(userLate.getTeachStatus())) {
//            return AjaxResult.error("老师处理状态必选");
            userLate.setTeachStatus(-1); //默认选中未处理
        }
        if (userLate.getTeachStatus() == -1) {
            userLate.setSearchValue(null);
        }else {
            userLate.setTeachStatus(null);
        }

        if (StrKit.isEmpty(userLate.getShowTime())) {
            userLate.setShowTime(DateUtils.getBeforeDateStr());
        }
        startPage();
        List<UserLate> noBackList = userLateServiceImpl.selectUserLateList(userLate);

        return AjaxResult.success(getDataTable(noBackList));

    }

    /**
     * 获取学生晚归迟到记录详细信息
     */
    @ApiOperation("4.1.4、获取学生晚归迟到记录详细信息")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(userLateServiceImpl.selectUserLateById(id));
    }

    @Autowired
    EachDayService eachDayService;

    /**
     * 删除学生晚归迟到记录
     */
    @ApiOperation("4.1.5、修改学生晚归状态")
    @PostMapping("/editstatus")
    public AjaxResult editstatus(@RequestBody EditModel editModel) {
        String ids = editModel.getId();
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            UserLate userLate = userLateServiceImpl.selectUserLateById(Long.valueOf(id));
            if (userLate == null) {
                return AjaxResult.error("晚归记录不存在");
            }
            userLate.setId(Long.valueOf(id));
            userLate.setTeachStatus(editModel.getTeachStatus());
            userLate.setTeachTime(DateUtils.getTime());
            userLate.setLateStatus(editModel.getTeachStatus());
            userLateServiceImpl.updateUserLate(userLate);
            //修改当天的
            Long dayId = userLate.getDayId();
            EachDayModel eachDayModel = new EachDayModel();
            eachDayModel.setId(dayId);
            eachDayModel.setLateStatus(editModel.getTeachStatus() + "");
            eachDayService.edit(eachDayModel);
        }
        return AjaxResult.success();
    }

}

class SearchMessageModel {
    @ApiModelProperty("查询消息的字符串")
    private String name;

    @ApiModelProperty("消息类型")
    private int teachStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeachStatus() {
        return teachStatus;
    }

    public void setTeachStatus(int teachStatus) {
        this.teachStatus = teachStatus;
    }
}


class EditModel {
    @ApiModelProperty("编号id, 逗号隔开")
    private String id;

    @ApiModelProperty("老师处理状态，0 未归， 1已归 2 晚归")
    private int teachStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTeachStatus() {
        return teachStatus;
    }

    public void setTeachStatus(int teachStatus) {
        this.teachStatus = teachStatus;
    }
}