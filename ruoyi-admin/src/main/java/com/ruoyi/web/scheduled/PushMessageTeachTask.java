package com.ruoyi.web.scheduled;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.late.service.IUserLateService;
import com.ruoyi.utilswx.SendWeChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 10点钟 给没有回寝室的同学推送消息  相关任务定时器类
 */
@Component("pushMessageTeachTask")
public class PushMessageTeachTask extends PushMessageCommon {

    @Autowired
    RedisCache redisCache;
    //10:30点钟还未回校学会
    ExecutorService execLateBack = Executors.newFixedThreadPool(20);

    //发送信息
    @Autowired
    private SendWeChatMessage sendWeChatMessage;
    //学生晚归信息
    @Autowired
    private IUserLateService userLateService;

    /**
     * 周日到周四22:35 给老师发送学生未归
     */
    public void getSendNoBackTask() {
        String token = "";
        token = sendWeChatMessage.getToken();

        //得到10点钟 还离校的同学
        getTenNoBack(token,"1",DateUtils.getDate());
    }
    /**
     * 周末23点给老师发送学生未归
     */
    public void getSendNoBackZmTask() {
        String token = "";
        token = sendWeChatMessage.getToken();
        //23点给老师发信息
        getTenNoBack(token,"2",DateUtils.getDate());
    }

    /**
     * 早上6点给拉老师发送未归寝列表
     */
    public void getSendNoBackInSixTask() {
        String token = "";
        token = sendWeChatMessage.getToken();
        //6点给老师发信息
        getTenNoBack(token,"3",DateUtils.getBeforeDateStr());
    }
    /**
     * 给老师发送未回寝室信息
     *
     * @param token
     */
    private void getTenNoBack(String token, String type, String showTime) {
//        String userId = "YuFu|ZhouTao|XiangJingCheng|";
//        sendMessageToTeach(token, userId);
        //晚归的列表
        int pageSize = 100;
        PageHelper.startPage(1, pageSize, "");
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("teachStatus", -1);
        searchMap.put("showTime", showTime);
        searchMap.put("groupByFieldName", "teach_id");
        String closeTime = "22:30";
        String lateStr = "晚归";
        switch (type){
            case "1":
                closeTime = "22:30";
                lateStr = "晚归";
                break;
            case "2":
                closeTime = "23:00";
                lateStr = "晚归";
                break;
            case "3":
                closeTime = "6:00";
                lateStr = "未归";
                break;
        }
//        //只有 某个老师接收消息推送
//        List<String> teachIdList=new ArrayList<>();
//        teachIdList.add("100064");
//        //List转String
//        String[] teachIdArr=teachIdList.toArray(new String[teachIdList.size()]);
//        searchMap.put("teachIdArr", teachIdArr);

        List<Map<String, Object>> mList = userLateService.getList(searchMap);
        int totalPage = new PageInfo(mList).getPages();
        for (int pageNum = 1; pageNum <= totalPage; pageNum++) {
            int finalPageNum = pageNum;
            String finalCloseTime = closeTime;
            String finalLateStr = lateStr;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "id asc");
                    List<Map<String, Object>> mListLateTeach = userLateService.getList(searchMap);
                    for (Map<String, Object> oneMap : mListLateTeach) {
                        if (!StrKit.isEmpty(oneMap.get("teachId"))) {
                            String userId = oneMap.get("teachId").toString();
                            userId = userId+"|YuFu|ZhouTao|XiangJingCheng";  //测试阶段 也发给我们三个
                            sendMessageToTeach(token, userId, showTime, finalCloseTime, finalLateStr);
//                            try {
//                                Thread.sleep(500);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                        }
                    }

                }
            };
            //将线程放入池中进行执行
            execLateBack.execute(run);
        }
    }

}
