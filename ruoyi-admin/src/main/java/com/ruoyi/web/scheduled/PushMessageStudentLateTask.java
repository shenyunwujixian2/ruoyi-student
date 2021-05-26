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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 10点钟 给没有回寝室的同学推送消息  相关任务定时器类
 */
@Component("pushMessageStudentLateTask")
public class PushMessageStudentLateTask extends PushMessageCommon {

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
     * 周日到周四22:38 给发送学生晚归提示
     */
    public void getSendLateBackTask() {
        String token = "";
        token = sendWeChatMessage.getTokenStudent();
        //22:30分 给学生发送晚归
        getTenLateBack(token, DateUtils.getDate());
    }

    /**
     * 周末23点给学生发送晚归提示
     */
    public void getSendLateBackZmTask() {
        String token = "";
        token = sendWeChatMessage.getTokenStudent();
        //23点给学生发信息
        getTenLateBack(token, DateUtils.getDate());
    }

    /**
     * 早上6点 给学生发送 未归寝列表
     */
    public void getSendNoBackInSixTask() {
        String token = "";
        token = sendWeChatMessage.getTokenStudent();
        //6点给老师发信息
        getTenNoBack(token, DateUtils.getBeforeDateStr());
    }

    /**
     * 给学生发送未回寝室信息
     *
     * @param token
     */
    private void getTenLateBack(String token, String showTime) {
        //晚归的列表
        int pageSize = 100;
        PageHelper.startPage(1, pageSize, "");
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("showTime", showTime);
        searchMap.put("groupByFieldName", "xh");
        List<Map<String, Object>> mList = userLateService.getList(searchMap);
        int totalPage = new PageInfo(mList).getPages();
        for (int pageNum = 1; pageNum <= totalPage; pageNum++) {
            int finalPageNum = pageNum;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "id asc");
                    List<Map<String, Object>> mListLateTeach = userLateService.getList(searchMap);
                    String userId = "";
                    for (Map<String, Object> oneMap : mListLateTeach) {
                        if (!StrKit.isEmpty(oneMap.get("xh"))) {
                            userId += oneMap.get("xh").toString()+"|";
                            System.out.println(oneMap.get("xh").toString());
                        }
                    }
                    userId = userId + "YuFu|ZhouTao|XiangJingCheng";  //测试阶段 也发给我们三个
                    sendMessageStudentLateBack(token, userId);
                }
            };
            //将线程放入池中进行执行
            execLateBack.execute(run);
        }
    }

    /**
     * 给学生发送未回寝室信息
     *
     * @param token
     */
    private void getTenNoBack(String token, String showTime) {
        //晚归的列表
        int pageSize = 100;
        PageHelper.startPage(1, pageSize, "");
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("showTime", showTime);
        searchMap.put("status", "0");
        searchMap.put("teachStatus", "-1");
        searchMap.put("groupByFieldName", "xh");
        List<Map<String, Object>> mList = userLateService.getList(searchMap);
        int totalPage = new PageInfo(mList).getPages();
        for (int pageNum = 1; pageNum <= totalPage; pageNum++) {
            int finalPageNum = pageNum;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "id asc");
                    List<Map<String, Object>> mListLateTeach = userLateService.getList(searchMap);
                    String userId = "";
                    for (Map<String, Object> oneMap : mListLateTeach) {
                        if (!StrKit.isEmpty(oneMap.get("xh"))) {
                            userId += oneMap.get("xh").toString() + "|";
                        }
                    }
                    userId = userId + "YuFu|ZhouTao|XiangJingCheng";  //测试阶段 也发给我们三个
                    sendMessageStudentNoBack(token, userId);
                }
            };
            //将线程放入池中进行执行
            execLateBack.execute(run);
        }
    }

}
