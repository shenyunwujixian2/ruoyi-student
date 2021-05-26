package com.ruoyi.web.scheduled;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.domain.EachInfoModel;
import com.ruoyi.record.domain.RecordEachTmp;
import com.ruoyi.record.service.impl.EachDayServiceImpl;
import com.ruoyi.record.service.impl.EachInfoServiceImpl;
import com.ruoyi.record.service.impl.RecordEachTmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 学生通过的记录 刷新到每天的最后一次
 *
 * @author xiaoafu  519602726@qq.com   2021-03-23 10:14:17
 */
@Component("studentTask")
public class StudentTask {
    //每天的信息
    @Resource
    EachDayServiceImpl eachDayServiceImpl;

    //出入门禁信息
    @Autowired
    EachInfoServiceImpl eachInfoServiceImpl;

    //出入门禁信息 临时信息
    @Autowired
    RecordEachTmpServiceImpl recordEachTmpServiceImpl;
    ExecutorService execDay = Executors.newFixedThreadPool(20);

    public void getStudentInfo() {
        System.out.println("执行将用户进出每条记录刷新到学生表的数据中去");
        getEachInfoList();
    }

    /**
     * 获取处理用户的进出记录
     */
    private void getEachInfoList() {
//        HashMap<String, Object> searchMap = new HashMap<>();
//        searchMap.put("checkStatus", "0");
        int pageSize = 500;
        PageHelper.startPage(1, pageSize, "pass_time asc");
        RecordEachTmp searchModel = new RecordEachTmp();
        searchModel.setCheckStatus("0");
        List<RecordEachTmp> mList = recordEachTmpServiceImpl.selectRecordEachTmpList(searchModel);

        int totalPage = new PageInfo(mList).getPages();
        for (int pageNum = 1; pageNum <= totalPage; pageNum++) {

            int finalPageNum = pageNum;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "pass_time asc");
                    List<RecordEachTmp> mListPage = recordEachTmpServiceImpl.selectRecordEachTmpList(searchModel);
                    for (RecordEachTmp baseOne : mListPage) {
                        boolean upday = false;
                        if (!baseOne.getPersonType().equals("2")) {
                            upday = updateUserEachDay(baseOne);
                        }
                        addUserEachInfoAndDel(baseOne, upday);
                    }
                }
            };
            //将线程放入池中进行执行
            execDay.execute(run);
        }
    }


    /**
     * 添加进info表 并删除
     * @param baseOne
     * @param upday
     */
    private void addUserEachInfoAndDel(RecordEachTmp baseOne, boolean upday) {
        if (upday) {
            baseOne.setCheckStatus("1");
        } else {
            baseOne.setCheckStatus("2");
        }
        baseOne.setCheckTime(new Date());
        EachInfoModel baseModel = new EachInfoModel();
        BeanUtils.copyProperties(baseOne, baseModel);

        // 没有数据 才新增进 数据
//        HashMap<String, Object> searchMap = new HashMap<>();
//        searchMap.put("recordId", baseModel.getRecordId());
//        EachInfoModel haveModel = eachInfoServiceImpl.getModelInfo(searchMap);
//        if (haveModel == null) {
//            baseModel.setCreateTime(new Date());
//            eachInfoServiceImpl.add(baseModel);
//        }
//        else {
//            baseModel.setId(haveModel.getId());
//            baseModel.setUpdateTime(new Date());
//            eachInfoServiceImpl.updateById(baseModel);
//        }
        try {
            eachInfoServiceImpl.add(baseModel);
        }catch (Exception e){

        }
        //根据id 删除
        recordEachTmpServiceImpl.deleteRecordEachTmpById(baseOne.getId());
    }


    /**
     * 更新内容
     *
     * @param baseOne
     */
    private boolean updateUserEachDay(RecordEachTmp baseOne) {
        String xh = baseOne.getPersonCode();
        //根据序号查询
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("xh", xh);
        //通过时间
        Date passTime = DateUtils.dateTime("yyyy-MM-dd HH:mm:ss", baseOne.getPassTime());
        //通过时间  在今天 22点到第二天凌晨6点之间的
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(passTime);
        calendar.add(Calendar.HOUR_OF_DAY, -6);// 昨天之前的时间
        Date beforeDay = calendar.getTime();
        String showTime = DateUtils.parseDateToStr("yyyy-MM-dd", beforeDay);

//        String passTimeStr = DateUtils.parseDateToStr("yyyy-MM-dd", passTime);
//        System.out.println("转后的通过日期===》"+passTimeStr);
        searchMap.put("showTime", showTime);
        EachDayModel baseModel = eachDayServiceImpl.getModelInfo(searchMap);
        if (baseModel == null) {
            return false;
        }
        try {
//            int nowHour = Integer.valueOf(DateUtils.getHour(0));
            Calendar cale = Calendar.getInstance();
            cale.setTime(passTime);
            SimpleDateFormat sdfHour = new SimpleDateFormat("HH");
            String hourStr = sdfHour.format(cale.getTimeInMillis());
            int nowHour = Integer.valueOf(hourStr);
            SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //将数据存入模型中   进
            if (baseOne.getInorout().equals("1")) {
                if (baseModel.getInStatus().equals("0") || (nowHour <= 21 && nowHour >= 6)) {
//                    baseModel.setInStatus("1");
//                    baseModel.setInRecordId(baseOne.getRecordId());
//                    baseModel.setInTime(baseOne.getPassTime());
                    //如果 没有最后一次进出记录 写入最后一次
                    if (StrKit.isEmpty(baseModel.getInTime())) {
                        baseModel.setInStatus("1");
                        baseModel.setInRecordId(baseOne.getRecordId());
                        baseModel.setInTime(baseOne.getPassTime());
                    } else {
                        //如果有进出记录 判断 本次进出记录是否大于 上一次的进出记录  大于才保存到表中
                        long timeOld = sdfTime.parse(baseModel.getInTime()).getTime();
                        long timeNew = sdfTime.parse(baseOne.getPassTime()).getTime();
                        if(timeNew <=timeOld){
                            return false;
                        }
                        baseModel.setInStatus("1");
                        baseModel.setInRecordId(baseOne.getRecordId());
                        baseModel.setInTime(baseOne.getPassTime());
                    }
                }
            }
            // 出
            if (baseOne.getInorout().equals("2")) {
                if (baseModel.getOutStatus().equals("0") || (nowHour <= 21 && nowHour >= 6)) {
//                    baseModel.setOutStatus("1");
//                    baseModel.setOutRecordId(baseOne.getRecordId());
//                    baseModel.setOutTime(baseOne.getPassTime());
                    //如果 没有最后一次进出记录 写入最后一次
                    if (StrKit.isEmpty(baseModel.getOutTime())) {
                        baseModel.setOutStatus("1");
                        baseModel.setOutRecordId(baseOne.getRecordId());
                        baseModel.setOutTime(baseOne.getPassTime());
                    } else {
                        //如果有进出记录 判断 本次进出记录是否大于 上一次的进出记录  大于才保存到表中
//                        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        long timeOld = sdfTime.parse(baseModel.getOutTime()).getTime();
                        long timeNew = sdfTime.parse(baseOne.getPassTime()).getTime();
                        if(timeNew <=timeOld){
                            return false;
                        }
                        baseModel.setOutStatus("1");
                        baseModel.setOutRecordId(baseOne.getRecordId());
                        baseModel.setOutTime(baseOne.getPassTime());
                    }
                }
            }
            //如果 没有最后一次进出记录 写入最后一次
            if (StrKit.isEmpty(baseModel.getLastInoroutTime())) {
                baseModel.setLastInorout(baseOne.getInorout());
                baseModel.setLastStrInorout(baseOne.getStrInorout());
                baseModel.setLastInoroutTime(baseOne.getPassTime());
            } else {
                //如果有进出记录 判断 本次进出记录是否大于 上一次的进出记录  大于才保存到表中
//                SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long timeOld = sdfTime.parse(baseModel.getLastInoroutTime()).getTime();
                long timeNew = sdfTime.parse(baseOne.getPassTime()).getTime();
                if(timeNew <=timeOld){
                    return false;
                }
                baseModel.setLastInorout(baseOne.getInorout());
                baseModel.setLastStrInorout(baseOne.getStrInorout());
                baseModel.setLastInoroutTime(baseOne.getPassTime());
            }
            baseModel.setUpdateTime(new Date());
            boolean edDay = eachDayServiceImpl.edit(baseModel);
            return edDay;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
