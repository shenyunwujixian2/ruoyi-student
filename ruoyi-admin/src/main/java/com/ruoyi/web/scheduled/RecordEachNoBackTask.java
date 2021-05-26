package com.ruoyi.web.scheduled;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.late.domain.UserLate;
import com.ruoyi.late.service.impl.UserLateServiceImpl;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.service.impl.EachDayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 将学生未归的写入表中
 *
 * @author xiaoafu  519602726@qq.com   2021-04-04 11:33:49
 */
@Component("recordEachNoBackTask")
public class RecordEachNoBackTask {
    //每天的信息
    @Resource
    EachDayServiceImpl eachDayServiceImpl;


    ExecutorService execLate = Executors.newFixedThreadPool(20);

    /**
     * 未归
     */
    public void addInfoToLate() {
//        System.out.println("执行处理用户未归记录列表");
//        String showTime = DateUtils.getBeforeDateStr();
//        getEachInfoList(showTime, "1");
        String showTime = DateUtils.getBeforeDateStr();
//        String showTime = DateUtils.getDate();
        Date showDate = DateUtils.dateTime("yyyy-MM-dd", showTime);
        String week = DateUtils.getWeekOfDate(showDate);
        //删除已归的列表
        deleteAll(showTime);
        switch (week) {
            case "SUN":
            case "MON":
            case "TUE":
            case "WED":
            case "THU":
                //周日到周4
                getEachInfoList(showTime, "1", "0");
                break;
            case "FRI":
            case "SAT":
                //周五到周六
                getEachInfoList(showTime, "2", "0");
                break;
        }
    }
    /**
     * 周末昨天未归
     */
    public void addInfoToLateZm() {
        System.out.println("执行周年用户未归记录列表");
        String showTime = DateUtils.getBeforeDateStr();
        getEachInfoList(showTime, "2", "0");
//        String showTime = DateUtils.getBeforeDateStr();
//        Date showDate = DateUtils.dateTime("yyyy-MM-dd", showTime);
//        String week = DateUtils.getWeekOfDate(showDate);
//        switch (week) {
//            case "SUN":
//            case "MON":
//            case "TUE":
//            case "WED":
//            case "THU":
//                //周日到周4
//                getEachInfoList(showTime, "1");
//                break;
//            case "FRI":
//            case "SAT":
//                //周五到周六
//                getEachInfoList(showTime, "2");
//                break;
//        }
    }

    /**
     * 生成今天未归
     */
    public void addInfoToLateToday() {
        System.out.println("执行处理用户未归记录列表");
        String showTime = DateUtils.getDate();
        getEachInfoList(showTime, "1", "2");
    }
    /**
     * 周末 生成今天
     */
    public void addInfoToLateTodayZm() {
        System.out.println("执行处理用户未归记录列表");
        String showTime = DateUtils.getDate();
        getEachInfoList(showTime, "2","2");
    }

    /**
     * 获取处理用户的进出记录
     */
    private void getEachInfoList(String showTime, String nowNotBackList, String lateStatus) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.HOUR_OF_DAY, -24);// 前一天
//        Date beforeDay = calendar.getTime();
//        String beforeDayStr = DateUtils.parseDateToStr("yyyy-MM-dd", beforeDay);
//        beforeDayStr = "2021-03-28";
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("showTime", showTime);
        switch (nowNotBackList){
            case "1":
                searchMap.put("nowNotBackList", nowNotBackList);  //当前没有回来的人  last_inorout =2 且 last_inorout_time 在早上到晚上10点间
                break;
            case "2":
                searchMap.put("nowNotBackListZm", nowNotBackList);  //当前没有回来的人 周末没有回来的人
                break;
        }

        //先清空表

        //晚归的列表
        int pageSize = 500;
        PageHelper.startPage(1, pageSize, "");
        List<EachDayModel> mList = eachDayServiceImpl.getList(searchMap);

        int totalPage = new PageInfo(mList).getPages();
        for (int pageNum = 1; pageNum <= totalPage; pageNum++) {
            int finalPageNum = pageNum;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "id asc");
                    List<EachDayModel> mListPage = eachDayServiceImpl.getList(searchMap);
                    for (EachDayModel baseOne : mListPage) {
                        boolean upday = false;
                        upday = updateUserEachLate(baseOne, lateStatus);
                        updateEachDayInfo(baseOne, upday);
                    }
                }
            };
            //将线程放入池中进行执行
            execLate.execute(run);
        }
    }

    /**
     * 删除迟到表中的 今日老师未处理的未归记录
     */
    private void deleteAll(String showTime){
        userLateServiceImpl.deleteUserLateNoBackList(showTime);
    }
    /**
     * 修改状态
     *
     * @param baseOne
     */
    private void updateEachDayInfo(EachDayModel baseOne, boolean upday) {
        if (upday) {
            baseOne.setCheckStatus("1");
        } else {
            baseOne.setCheckStatus("2");
        }
        baseOne.setLateStatus("1");
        boolean edDay = eachDayServiceImpl.edit(baseOne);
    }

    @Autowired
    UserLateServiceImpl userLateServiceImpl;

    /**
     * 更新内容
     *
     * @param baseOne
     */
    private boolean updateUserEachLate(EachDayModel baseOne, String lateStatus) {
        String xh = baseOne.getXh();
        //根据序号查询
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("xh", xh);
        //通过时间
        searchMap.put("showTime", baseOne.getShowTime());
        UserLate searchModel = new UserLate();
        searchModel.setXh(xh);
        searchModel.setShowTime(baseOne.getShowTime());
        PageHelper.startPage(1, 1, "id desc");
        List<UserLate> mlist = userLateServiceImpl.selectUserLateList(searchModel);
        UserLate baseModel = setUserLateModel(baseOne, lateStatus);
        UserLate haveModel = null;
        if (mlist.size() > 0) {
            haveModel = mlist.get(0);
        }
        int edNum;
        if (haveModel == null) {
            baseModel.setCreateTime(new Date());
            edNum = userLateServiceImpl.insertUserLate(baseModel);
        } else {
            baseModel.setId(haveModel.getId());
            baseModel.setUpdateTime(new Date());
            //老师处理的
            if(haveModel.getTeachStatus()!=null && haveModel.getTeachStatus() != -1){
                baseModel.setLateStatus(null); //不去改状态
                baseModel.setStatus(null); //不去改状态
            }
            edNum = userLateServiceImpl.updateUserLate(baseModel);
        }
        return edNum == 0 ? false : true;
    }

    /**
     * 复制来
     *
     * @param baseOne
     * @return
     */
    private UserLate setUserLateModel(EachDayModel baseOne, String lateStatus) {
        UserLate baseModel = new UserLate();
        BeanUtils.copyProperties(baseOne, baseModel);
        baseModel.setId(null);
        baseModel.setDayId(baseOne.getId());
        baseModel.setCreateTime(null);
        baseModel.setUpdateTime(null);
        //设置 未归标识
//        baseModel.setLateStatus(0);
        baseModel.setLateStatus(Integer.valueOf(lateStatus));
        baseModel.setStatus(Integer.valueOf(lateStatus));
        return baseModel;
    }

}
