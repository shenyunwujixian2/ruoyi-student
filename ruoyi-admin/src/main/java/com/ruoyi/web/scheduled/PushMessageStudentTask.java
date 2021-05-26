package com.ruoyi.web.scheduled;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.service.impl.EachDayServiceImpl;
import com.ruoyi.utilswx.SendWeChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  10点钟 给没有回寝室的同学推送消息  相关任务定时器类
 */
@Component("pushMessageStudentTask")
public class PushMessageStudentTask extends PushMessageCommon{

    @Autowired
    RedisCache redisCache;
    //10点钟还未回校学会
    ExecutorService execNoBack = Executors.newFixedThreadPool(20);

    //发送信息
    @Autowired
    private SendWeChatMessage sendWeChatMessage;
    //每天的信息
    @Resource
    EachDayServiceImpl eachDayServiceImpl;

//    @PostConstruct
    public void testSendToStudent(){
        String tokenToStudent = "";
        tokenToStudent = sendWeChatMessage.getTokenStudent();
//        if (redisCache.getCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN_TO_STUDENT") == null) {
//            tokenToStudent = sendWeChatMessage.getTokenStudent();
//            redisCache.setCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN_TO_STUDENT", tokenToStudent, 20, TimeUnit.MINUTES);
//        } else {
//            tokenToStudent = redisCache.getCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN_TO_STUDENT");
//        }
        String userId =  "YuFu"; //测试阶段加上我们三个
        String closeTime = "22:30";
        sendMessageCallBack(tokenToStudent, userId, closeTime);
    }

    /**
     * 给学生发送回寝室信息
     * "MbSUZxOh08kymGTSIjZKlTJa2OXf7PEeuOMZIx1on2RH5cVwUxEDhO2k6yvV4z4AVR0XoffIYHYB5LvFQ99DVIwvgBhE_evnUL7Cj3W2ZMdnbakHpUsQ3920OIDiSrADU7Gb-8lWX0ws06St1fA2XvRKTSV5OVDeBq-2tzn3kgSTNGrkJoBlemySFGGkIp-zdYXKJdc_MIjdBSNngoI9bw"
     *
     */
    public void getSendBackCallTask() {
        String tokenToStudent = "";

        tokenToStudent = sendWeChatMessage.getTokenStudent();
        //得到10点钟 还离校的同学
        getTenNoBack(tokenToStudent,"1");

//        String userId =  "YuFu"; //测试阶段加上我们三个
//        String closeTime = "22:30";
//        sendMessageCallBack(tokenToStudent, userId, closeTime);
    }
    /**
     * 给学生发送回寝室信息
     */
    public void getSendBackCallZMTask() {
        String tokenToStudent = "";
        tokenToStudent = sendWeChatMessage.getTokenStudent();
//        if (redisCache.getCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN_TO_STUDENT") == null) {
//            tokenToStudent = sendWeChatMessage.getTokenStudent();
//            redisCache.setCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN_TO_STUDENT", tokenToStudent, 20, TimeUnit.MINUTES);
//        } else {
//            tokenToStudent = redisCache.getCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN_TO_STUDENT");
//        }
        //得到10：30点钟 还离校的同学
        getTenNoBack(tokenToStudent, "2");
    }


    /**
     * 发送消息招回
     * @param token
     */
    private void getTenNoBack(String token,String nowNotBackList) {
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("showTime", DateUtils.getDate());
        searchMap.put("nowNotBackList", nowNotBackList);  //当前没有回来的人  last_inorout =2 且 last_inorout_time 在早上到晚上10点间
        String closeTime = "22:30";
        if(nowNotBackList.equals("2")){
            closeTime = "23:00";
        }
//        //只有 某个老师的学生 消息推送
//        List<String> teachIdList=new ArrayList<>();
//        teachIdList.add("100064");
//        //List转String
//        String[] teachIdArr=teachIdList.toArray(new String[teachIdList.size()]);
//        searchMap.put("teachIdArr", teachIdArr);

        //晚归的列表
        int pageSize = 100;
        PageHelper.startPage(1, pageSize, "");
        List<EachDayModel> mList = eachDayServiceImpl.getList(searchMap);
        int totalPage = new PageInfo(mList).getPages();
        for (int pageNum = 1; pageNum <= totalPage; pageNum++) {
            int finalPageNum = pageNum;
            String finalCloseTime = closeTime;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "id asc");
                    List<EachDayModel> mListPage = eachDayServiceImpl.getList(searchMap);
                    String userId = "";
                    for (EachDayModel baseOne : mListPage) {
                        userId += baseOne.getXh()+"|" ;
                    }
                    userId = userId + "YuFu|ZhouTao|XiangJingCheng|"; //测试阶段加上我们三个
                    sendMessageCallBack(token, userId, finalCloseTime);
//                    try {
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            };
            //将线程放入池中进行执行
            execNoBack.execute(run);
        }
    }

}
