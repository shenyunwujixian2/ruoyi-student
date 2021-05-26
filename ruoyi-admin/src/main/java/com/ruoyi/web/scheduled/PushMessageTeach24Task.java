package com.ruoyi.web.scheduled;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.service.EachDayService;
import com.ruoyi.utilswx.SendWeChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 给老师发送 24小时没有出寝室的同学  相关任务定时器类
 */
@Component("pushMessageTeach24Task")
public class PushMessageTeach24Task extends PushMessageCommon {

    //
    ExecutorService execDay24 = Executors.newFixedThreadPool(20);

    //发送信息
    @Autowired
    private SendWeChatMessage sendWeChatMessage;
    //学生晚归信息
    @Autowired
    private EachDayService eachDayService;

    /**
     * 周日到周四22:35 给老师发送学生未归
     */
//    @PostConstruct
    public void getSendNoBackTask() {
        String token = "";
        token = sendWeChatMessage.getToken();
        //得到10点钟 还离校的同学
        get24HourNoOut(token,DateUtils.getDate());
    }

    /**
     * 给老师发送未回寝室信息
     *
     * @param token
     */
    private void get24HourNoOut(String token, String showTime) {
//        String userId = "YuFu";
//        sendMessageToTeach24Hour(token,userId, showTime);
//        return;
        //晚归的列表
        int pageSize = 100;
        PageHelper.startPage(1, pageSize, "");
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("showTime", showTime);
        searchMap.put("startshowTime",null);
        searchMap.put("endshowTime",null);
        searchMap.put("searchPassIsNull","1");
        searchMap.put("lastInorout","1"); //最后状态为进入
        searchMap.put("groupByField", "teach_id");
        searchMap.put("searchPassTimeBig24",DateUtils.getBeforeDateStr("yyyy-MM-dd HH:mm:ss", new Date()));  //当前时间的前24小时

        List<EachDayModel> mList = eachDayService.getList(searchMap);
        int totalPage = new PageInfo(mList).getPages();
        for (int pageNum = 1; pageNum <= totalPage; pageNum++) {
            int finalPageNum = pageNum;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "id asc");
                    List<EachDayModel> mListLateTeach = eachDayService.getList(searchMap);
                    for (EachDayModel oneModel : mListLateTeach) {
                        if (!StrKit.isEmpty(oneModel.getTeachId())) {
                            String userId = oneModel.getTeachId();
                            userId = userId+"|YuFu|ZhouTao|XiangJingCheng";  //测试阶段 也发给我们三个
                            sendMessageToTeach24Hour(token,userId, showTime);
                        }
                    }

                }
            };
            //将线程放入池中进行执行
            execDay24.execute(run);
        }
    }

}
