package com.ruoyi.web.scheduled;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.dbbase.domain.*;
import com.ruoyi.dbbase.service.impl.*;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.service.impl.EachDayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用户信息同步接  相关任务定时器类
 * <p>
 * 用户存在重复的
 * SELECT XH,COUNT("XH") as s from ztsj_ztsj_jwzxsxx_qywx  GROUP BY `XH` ORDER BY s DESC
 */
@Component("userTask")
public class UserTask {

    //教务在线学生信息
    @Autowired
    BdZtsjZtsjJwzxsxxQywxServiceImpl bdZtsjZtsjJwzxsxxQywxServiceImpl;

    //学生每日进出记录统计
    @Autowired
    EachDayServiceImpl eachDayServiceImpl;

    //同步线程数量
    ExecutorService execUser = Executors.newFixedThreadPool(20);

    public void getUserInfoTask() {
        System.out.println("启动用户信息同步接口====> ");
        getUserListInfo();
    }

    /**
     * 获取用户信息接口
     */
    private void getUserListInfo() {
        int pageSize = 1000;
        BdZtsjZtsjJwzxsxxQywx bdZtsjZtsjJwzxsxxQywx = new BdZtsjZtsjJwzxsxxQywx();
        PageHelper.startPage(1, pageSize, "");
        List<BdZtsjZtsjJwzxsxxQywx> mlist = bdZtsjZtsjJwzxsxxQywxServiceImpl.selectBdZtsjZtsjJwzxsxxQywxList(bdZtsjZtsjJwzxsxxQywx);

        int totalPage = new PageInfo(mlist).getPages();

        for (int pageNum = 1; pageNum <= totalPage; pageNum++) {
            int finalPageNum = pageNum;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "xh asc");
                    List<BdZtsjZtsjJwzxsxxQywx> mListPage = bdZtsjZtsjJwzxsxxQywxServiceImpl.selectBdZtsjZtsjJwzxsxxQywxList(bdZtsjZtsjJwzxsxxQywx);
                    for (BdZtsjZtsjJwzxsxxQywx baseOne : mListPage) {
                        EachDayModel baseModel = new EachDayModel();
                        baseModel.setShowTime(DateUtils.getDate());
//                        baseModel.setShowTime("2021-03-28");
                        baseModel.setXh(baseOne.getXh());
                        baseModel.setXm(baseOne.getXm());
                        baseModel.setLxfs(baseOne.getLxfs());
                        baseModel.setDwmc(baseOne.getDwmc());
                        baseModel.setDwdm(baseOne.getDwdm());
                        baseModel.setBmdm(baseOne.getZydm());
                        baseModel.setBmmc(baseOne.getZymc());
                        baseModel.setXkmldm(baseOne.getXkmldm());
                        baseModel.setZymc(baseOne.getZymc());
                        baseModel.setZydm(baseOne.getZydm());
                        baseModel.setBjjc(baseOne.getBjjc());
                        baseModel.setBjdm(baseOne.getBjdm()); //班级代码
                        baseModel.setXsdqztdm(baseOne.getXsdqztdm()); //班级代码
                        baseModel = addTeachInfo(baseModel);
//                        baseModel = addUserPhoneInfo(baseModel);
                        //查询用户是否为住宿学生

                        // 是在校学生 才加入当日统计列表
                        baseModel =  bindStudentHouseInSchoole(baseModel);
//                        if(isUserInSchoole(baseModel)){
//                            addOrUpdateEachDayModel(baseModel);
//                        }
                        // 是在校学生 有宿舍号 才加入当日统计列表
                        if(baseModel !=null && !StrKit.isEmpty(baseModel.getShh())){
                            addOrUpdateEachDayModel(baseModel);
                        }
                    }
                }
            };
            //将线程放入池中进行执行
            execUser.execute(run);
        }
    }

    @Autowired
    private BdXgxtXgxtBjfdyxxQywxServiceImpl bdXgxtXgxtBjfdyxxQywxServiceImpl;

    //添加辅导员信息
    private EachDayModel addTeachInfo(EachDayModel baseModel) {
        try {
            if (!StrKit.isEmpty(baseModel.getBjdm())) {
                BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx = new BdXgxtXgxtBjfdyxxQywx();
                bdXgxtXgxtBjfdyxxQywx.setBjdm(baseModel.getBjdm());
                List<BdXgxtXgxtBjfdyxxQywx> mlist = bdXgxtXgxtBjfdyxxQywxServiceImpl.selectBdXgxtXgxtBjfdyxxQywxList(bdXgxtXgxtBjfdyxxQywx);
                BdXgxtXgxtBjfdyxxQywx oneModel = mlist.get(0);
                if (oneModel != null) {
                    baseModel.setTeachId(oneModel.getFdyjzgh()); // 辅导员id
                    baseModel.setTeachName(oneModel.getFdy());  //辅导员名称
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return baseModel;
    }


    @Autowired
    private BdStudentInSchoolServiceImpl bdStudentInSchoolServiceImpl;
//    /**
//     * 判断学生是否为住校学生
//     * @param baseModel
//     * @return
//     */
//    private boolean isUserInSchoole(EachDayModel baseModel) {
//        try {
//            if (!StrKit.isEmpty(baseModel.getXh())) {
//                BdStudentInSchool oneModel = bdStudentInSchoolServiceImpl.selectBdStudentInSchoolById(baseModel.getXh());
//                if (oneModel != null) {
//                    return true;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//        return false;
//    }

    @Autowired
    BdXgxtXgxtSscwhrzxxQywxServiceImpl bdXgxtXgxtSscwhrzxxQywxServiceImpl;
    /**
     * 绑定宿舍号
     * @param baseModel
     * @return
     */
    private EachDayModel bindStudentHouseInSchoole(EachDayModel baseModel) {
//        try {
//            if (!StrKit.isEmpty(baseModel.getXh())) {
//                BdStudentInSchool oneModel = bdStudentInSchoolServiceImpl.selectBdStudentInSchoolById(baseModel.getXh());
//                if (oneModel != null) {
////                    return baseModel;
//                    baseModel.setSslh(oneModel.getSslh());
//                    baseModel.setDy(oneModel.getDy());
//                    baseModel.setShh(oneModel.getShh());
//                    baseModel.setCwh(oneModel.getCwh());
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
        try {
            if (!StrKit.isEmpty(baseModel.getXh())) {
                BdXgxtXgxtSscwhrzxxQywx oneModel = bdXgxtXgxtSscwhrzxxQywxServiceImpl.selectBdXgxtXgxtSscwhrzxxQywxById(baseModel.getXh());
                if (oneModel != null) {
                    baseModel.setSslh(oneModel.getSslmc());  //宿舍楼名称
                    baseModel.setDy(oneModel.getDymc());   //单元名称
                    baseModel.setShh(oneModel.getSsmc()); //宿舍名称
                    baseModel.setCwh(oneModel.getCwbh()); //床位编号
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return baseModel;
    }

    @Autowired
    private BdZtsjRyjbxxQywxServiceImpl bdZtsjRyjbxxQywxServiceImpl;

    //添加辅导员信息
    private EachDayModel addUserPhoneInfo(EachDayModel baseModel) {
        try {
            if (StrKit.isEmpty(baseModel.getLxfs()) && !StrKit.isEmpty(baseModel.getXh())) {
//                if (!StrKit.isEmpty(baseModel.getXh())) {
                    BdZtsjRyjbxxQywx searchModel = new BdZtsjRyjbxxQywx();
                    searchModel.setXgh(baseModel.getXh());
                    List<BdZtsjRyjbxxQywx> mlist = bdZtsjRyjbxxQywxServiceImpl.selectBdZtsjRyjbxxQywxList(searchModel);
                    if (mlist.size() < 1) {
                        return baseModel;
                    }
                    BdZtsjRyjbxxQywx oneModel = mlist.get(0);
                    if (oneModel != null) {
                        baseModel.setLxfs(oneModel.getLxdh()); //设置联系电话
                    }
//                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return baseModel;
    }


    /**
     * 添加或者修改
     */
    private void addOrUpdateEachDayModel(EachDayModel baseModel) {
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("xh", baseModel.getXh());
        searchMap.put("showTime", DateUtils.getDate());
//        searchMap.put("showTime", "2021-03-28");
        EachDayModel haveModel = eachDayServiceImpl.getModelInfo(searchMap);
        if (haveModel == null) {
            baseModel.setCreateTime(new Date());
            eachDayServiceImpl.add(baseModel);
        } else {
            baseModel.setId(haveModel.getId());
            baseModel.setUpdateTime(new Date());
            eachDayServiceImpl.updateById(baseModel);
        }
    }


}
