package com.ruoyi.web.scheduled;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.person.Bean.UniResult;
import com.ruoyi.person.Bean.queryBean.QueryAcessInfoBean;
import com.ruoyi.person.PeosonManger.AcessConn;
import com.ruoyi.person.Utils.loginUtil.FaceGateLogin;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.domain.RecordEachTmp;
import com.ruoyi.record.service.impl.EachDayServiceImpl;
import com.ruoyi.record.service.impl.RecordEachTmpServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 通过id 查询用户的进出记录
 */
@Component("recordEachDayBeforeTask")
public class RecordEachDayBeforeTask {

    @Autowired
    RecordEachTmpServiceImpl recordEachTmpServiceImpl;
    //每天的信息
    @Resource
    EachDayServiceImpl eachDayServiceImpl;
    //多线程
    ExecutorService execDayBefore = Executors.newFixedThreadPool(20);

    @Autowired
    RedisCache redisCache;

    public void getRecordDayLoseTask() {
        String showTime = DateUtils.getDate();
        String startTime = DateUtils.datePath() + " 00:00:00";
        String endTime = DateUtils.datePath() + " 23:59:59";
        String cookieVal = "";
        try {
            //先登录 获取cookie
            if (redisCache.getCacheObject("COOKIE_GET_USER_ACESS_CONN") == null) {
                FaceGateLogin faceGateLogin = new FaceGateLogin();
                cookieVal = faceGateLogin.faceGateLogin();
                redisCache.setCacheObject("COOKIE_GET_USER_ACESS_CONN", cookieVal, 30, TimeUnit.MINUTES);
            } else {
                cookieVal = redisCache.getCacheObject("COOKIE_GET_USER_ACESS_CONN");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        getRecordEachInfoTaskCommon(startTime, endTime, "1003200243", cookieVal);
        getUserLateList(cookieVal, showTime, startTime, endTime);
    }

    /**
     * 获取 需要处理的列表
     *
     * @param showTime
     */
    private void getUserLateList(String cookieVal, String showTime, String startTime, String endTime) {
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("showTime", showTime);
        searchMap.put("lateBackList", "1");
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
                        String passTime = getRecordEachInfoTaskCommon(startTime, endTime, baseOne.getXh(), cookieVal);
                        //比对passTime 和最后一次记录的时间
                        updateDayLastTime(baseOne, passTime);
                    }
                }
            };
            //将线程放入池中进行执行
            execDayBefore.execute(run);
        }
    }

    /**
     * 根据通过时间 和dayId 刷新
     *
     * @param baseModel
     * @param passTime
     */
    private void updateDayLastTime(EachDayModel baseModel, String passTime) {
        try {
            SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //如果 没有最后一次进出记录 写入最后一次
            if (StrKit.isEmpty(baseModel.getLastInoroutTime())) {
                baseModel.setLastInorout("1");
                baseModel.setLastStrInorout("进");
                baseModel.setLastInoroutTime(passTime);
                baseModel.setUpdateTime(new Date());
            } else {
                //如果有进出记录 判断 本次进出记录是否大于 上一次的进出记录  大于才保存到表中
//                SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long timeOld = sdfTime.parse(baseModel.getLastInoroutTime()).getTime();
                long timeNew = sdfTime.parse(passTime).getTime();
                if(timeNew <=timeOld){
                    return;
                }
                baseModel.setLastInorout("1");
                baseModel.setLastStrInorout("进");
                baseModel.setLastInoroutTime(passTime);
                baseModel.setUpdateTime(new Date());
            }
            eachDayServiceImpl.edit(baseModel);
        } catch (Exception e) {

        }

    }


    /**
     *
     */
    public String getRecordEachInfoTaskCommon(String startTime, String endTime, String personCode, String cookieVal) {
        String passTime = "";
        try {
            int pageSize = 1;
            UniResult uniResult = getEachInfoListInfo(startTime, endTime, 1, pageSize, personCode, cookieVal);
            if (uniResult == null || uniResult.getData() == null) {
                System.out.println("请求的结果没有可以出====> ");
                return passTime;
            }
            JSONObject jsonOne = JSONObject.fromObject(uniResult.getData());
            String strArr = jsonOne.get("data").toString();
            JSONArray jsonArr = JSONArray.parseArray(strArr);
            for (int i = 0; i < jsonArr.size(); i++) {
                String strOne = jsonArr.get(i).toString();
                System.out.println("得到的单条结果============>" + strOne);
                //解析单条
                RecordEachTmp baseModel = getEachInfoModel(strOne);
                passTime = baseModel.getPassTime();
                //解析数据保存
                addOrUpdateRecordEachTmpModel(baseModel);
            }
        } catch (Exception e) {

        }
        return passTime;
    }

    /**
     * 添加或则修改
     */
    private void addOrUpdateRecordEachTmpModel(RecordEachTmp baseModel) {
        try {
            baseModel.setCreateTime(new Date());
            recordEachTmpServiceImpl.insertRecordEachTmp(baseModel);
        } catch (Exception e) {

        }
    }

    private RecordEachTmp getEachInfoModel(String str) {
        JSONObject jsonObject = JSONObject.fromObject(str);
        RecordEachTmp baseModel = new RecordEachTmp();
        if (!StrKit.isEmpty(jsonObject.get("RecordId"))) {
            baseModel.setRecordId(jsonObject.get("RecordId").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("Inorout"))) {
            baseModel.setInorout(jsonObject.get("Inorout").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("StrInorout"))) {
            baseModel.setStrInorout(jsonObject.get("StrInorout").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("AreaName"))) {
            baseModel.setAreaName(jsonObject.get("AreaName").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("AreaCode"))) {
            baseModel.setAreaCode(jsonObject.get("AreaCode").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("GuardGroupName"))) {
            baseModel.setGuardGroupName(jsonObject.get("GuardGroupName").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("GuardGroupCode"))) {
            baseModel.setGuardGroupCode(jsonObject.get("GuardGroupCode").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("PersonType"))) {
            baseModel.setPersonType(jsonObject.get("PersonType").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("StrPersonType"))) {
            baseModel.setStrPersonType(jsonObject.get("StrPersonType").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("PersonCode"))) {
            baseModel.setPersonCode(jsonObject.get("PersonCode").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("PersonName"))) {
            baseModel.setPersonName(jsonObject.get("PersonName").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("DepartmentCode"))) {
            baseModel.setDepartmentCode(jsonObject.get("DepartmentCode").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("DepartmentName"))) {
            baseModel.setDepartmentName(jsonObject.get("DepartmentName").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("PassTime"))) {
            baseModel.setPassTimeStr(jsonObject.get("PassTime").toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sd = sdf.format(Long.valueOf(jsonObject.get("PassTime").toString()));
            baseModel.setPassTime(sd);
        }
        return baseModel;
    }


    @Autowired
    AcessConn acessConn;

    /**
     * 获取用户信息接口
     */
    private UniResult getEachInfoListInfo(String startTime, String endTime, int page, int pageSize, String personCode, String cookieVal) {
        UniResult uniResult = new UniResult();//返回实体类的接受对象
        try {
            /**
             * 查询出入记录 例子
             */
            QueryAcessInfoBean queryAcessInfoBean = new QueryAcessInfoBean();
            queryAcessInfoBean.setStartTime(startTime);
            queryAcessInfoBean.setEndTime(endTime);
            queryAcessInfoBean.setPage(page + "");
            queryAcessInfoBean.setSize(pageSize + "");
            queryAcessInfoBean.setPersonType("3");
            queryAcessInfoBean.setPersonCode(personCode);
            //进出方向：进 1，出 2 ，全选不
            queryAcessInfoBean.setInOrOut("1");
            //获取结果 String 类型字符串
            uniResult = acessConn.QueryAcessInfo(queryAcessInfoBean, cookieVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uniResult;
    }

}
