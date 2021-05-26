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
 * 给领导发送学院学生未归消息  相关任务定时器类
 */
@Component("pushMessageTeachLeaderTask")
public class PushMessageTeachLeaderTask extends PushMessageCommon {

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
     * 早上6点半给 二院领导 发送未归寝列表
     */
    public void getSendNoBackInSixTask() {
        String token = "";
        token = sendWeChatMessage.getToken();
        //6点给老师发信息
        getTeachLeaderList(token, DateUtils.getBeforeDateStr());
    }

    /**
     * 给老师发送未回寝室信息
     *
     * @param token
     */
//    private void getTenNoBack(String token, String showTime) {
//        //晚归的列表
//        int pageSize = 100;
//        PageHelper.startPage(1, pageSize, "");
//        HashMap<String, Object> searchMap = new HashMap<>();
//        searchMap.put("teachStatus", -1);
//        searchMap.put("showTime", showTime);
//        searchMap.put("groupByFieldName", "teach_id");
//        List<Map<String, Object>> mList = userLateService.getList(searchMap);
//        int totalPage = new PageInfo(mList).getPages();
//        for (int pageNum = 1; pageNum <= totalPage; pageNum++) {
//            int finalPageNum = pageNum;
//            Runnable run = new Runnable() {
//                public void run() {
//                    PageHelper.startPage(finalPageNum, pageSize, "id asc");
//                    List<Map<String, Object>> mListLateTeach = userLateService.getList(searchMap);
//                    for (Map<String, Object> oneMap : mListLateTeach) {
//                        if (!StrKit.isEmpty(oneMap.get("teachId"))) {
//                            String userId = oneMap.get("teachId").toString();
//                            userId = userId+"|YuFu|ZhouTao|XiangJingCheng";  //测试阶段 也发给我们三个
//                            sendMessageToTeachLeader(token, userId, showTime);
//                        }
//                    }
//
//                }
//            };
//            //将线程放入池中进行执行
//            execLateBack.execute(run);
//        }
//    }
    private void getTeachLeaderList(String token, String showTime) {
        List<HashMap<String, Object>> mListTeachLeader = new ArrayList<>();
        HashMap<String, Object> teachMap1 = setOneMap("050507|100339", "陶军屹|曹楠", "01","民政与社会治理学院");
        mListTeachLeader.add(teachMap1);

        HashMap<String, Object> teachMap2 = setOneMap("010208|060104", "唐鸿铃|高瑞娟", "03","商学院");
        mListTeachLeader.add(teachMap2);

        HashMap<String, Object> teachMap3 = setOneMap("04020|100196", "董勇|王科辉", "04","大数据与信息产业学院");
        mListTeachLeader.add(teachMap3);

        HashMap<String, Object> teachMap4 = setOneMap("030412|100063", "谢朝晖|谭杰倪", "07","财经学院");
        mListTeachLeader.add(teachMap4);

        HashMap<String, Object> teachMap5 = setOneMap("040217|100065", "郑兵|牟莉", "10","智慧康养学院");
        mListTeachLeader.add(teachMap5);

        HashMap<String, Object> teachMap6 = setOneMap("800021|100073", "苟兴功|胡月", "11", "文化与旅游学院");
        mListTeachLeader.add(teachMap6);

        HashMap<String, Object> teachMap7 = setOneMap("040225|040259", "余光琳|黄博", "13", "智能工程学院");
        mListTeachLeader.add(teachMap7);

        for (HashMap<String, Object> baseMap : mListTeachLeader) {
            if (!StrKit.isEmpty(baseMap.get("teachId"))) {
                String userId = baseMap.get("teachId").toString();
//                userId = userId + "|YuFu|ZhouTao|XiangJingCheng";  //测试阶段 也发给我们三个
                //查询该单位代码下是否有未归数据 大于的才发信息
                String dwdm ="";
                if(!StrKit.isEmpty(baseMap.get("dwdm"))){
                    dwdm = baseMap.get("dwdm").toString();
                }
                sendMessageToTeachLeader(token, userId, showTime, dwdm);
            }
        }
    }

    /**
     * 设置 二院领导信息
     *
     * @param teachId
     * @param teachName
     * @param dwdm
     * @param dwmc
     * @return
     */
    private HashMap<String, Object> setOneMap(String teachId, String teachName, String dwdm,String dwmc) {
        HashMap<String, Object> oneMap = new HashMap<>();
        oneMap.put("teachId", teachId);
        oneMap.put("teachName", teachName);
        oneMap.put("dwdm", dwdm);
        oneMap.put("dwmc", dwmc);
        return oneMap;
    }
}
