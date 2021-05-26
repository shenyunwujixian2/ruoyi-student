package com.ruoyi.web.scheduled;

import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.utilswx.SendWeChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 用户打卡记录  相关任务定时器类
 */
@Component("pushMessageTask")
public class PushMessageTask extends PushMessageCommon{

    @Autowired
    RedisCache redisCache;
    @Autowired
    private SendWeChatMessage sendWeChatMessage;

    public void getUserInfoTask() {
        System.out.println("启动短信发送信息接口====> ");
        List<String> phoneList = new ArrayList<>();
        phoneList.add("13618364604");
//        phoneList.add("13452171412");
//        phoneList.add("18580992114");
        //初始化token
//        String token = sendWeChatMessage.getToken();
        String token = "";
        if (redisCache.getCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN") == null) {
            token = sendWeChatMessage.getToken();
            redisCache.setCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN", token, 20, TimeUnit.MINUTES);
        } else {
            token = redisCache.getCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN");
        }
        for (String phone : phoneList) {
//            sendMessageCallBack(token, phone);
//            sendMessageTeach(token, phone, "汽车A2002", "李好");
//            sendMessageTeachLeader(token, phone, "汽车A2002", "李好");
//            sendMessageTeachTwo(token, phone, "汽车A2002", "李好");
//            sendMessageTeachLeaderTwo(token, phone, "汽车A2002", "李好");
//            sendMessageToTeach(token, phone);
        }
    }

//    @Autowired
//    private SendWeChatMessage sendWeChatMessage;
//
//    /**
//     * 第一次推送  时间：22:00    推送对象：未进入宿舍学生
//     *
//     * @param token
//     * @param phone
//     */
//    public void sendMessageCallBack(String token, String phone) {
//        String message = "               温馨提示\n" +
//                "各位同学：\n" +
//                "根据《重庆城市管理职业学院学生宿舍管理规定》，学生宿舍作息时间为晚上22:30关门，晚上关大门后回宿舍视为晚归，请尽快返回宿舍。";
//        sendMessageCommon(token, phone, message, "1", DateUtils.dateTime());
//    }
//
//    /**
//     * 第二次推送  时间：22:30    推送对象：辅导员（将22:30还未按时返回宿舍的学生数据推送到辅导员处
//     *
//     * @param token
//     * @param phone
//     */
//    public void sendMessageTeach(String token, String phone, String bjmc, String studentName) {
//        String message = "辅导员老师，您好：\n" +
//                "您所带学生" + bjmc + "班级，" + studentName + "同学，22:30尚未返回宿舍，请核实学生晚归是否属实，如果属实请及时联系学生家长，做好学生教育管理工作，确保学生安全。";
//        sendMessageCommon(token, phone, message, "2", DateUtils.dateTime());
//    }
//
//    /**
//     * 第三次推送  时间00:00 推送对象：各二级学院分管学生工作（副）书记，将辅导员未处理晚归学生名单推送给书记，并将未返回宿舍学生名单认定为“夜不归寝”。
//     *
//     * @param token
//     * @param phone
//     */
//    public void sendMessageTeachLeader(String token, String phone, String bjmc, String studentName) {
//        String message = "二级学院书记，您好：\n" +
//                "贵学院" + bjmc + "班级，" + studentName + "同学晚归，目前辅导员尚未核实处理，请敦促辅导员核实学生晚归是否属实，如果属实请及时联系学生家长，做好学生教育管理工作，确保学生安全。";
//        sendMessageCommon(token, phone, message, "3", DateUtils.getBeforeDateStr());
//    }
//
//    /**
//     * 4. 超过24小时未出宿舍   推送对象：辅导员
//     *
//     * @param token
//     * @param phone
//     */
//    public void sendMessageTeachTwo(String token, String phone, String bjmc, String studentName) {
//        String message = "辅导员老师，您好：\n" +
//                "您所带学生" + bjmc + "班级，" + studentName + "，目前已24小时未离开宿舍，请关注学生情况。";
//        sendMessageCommon(token, phone, message, "4", DateUtils.getBeforeDateStr());
//    }
//
//    /**
//     * 超过48小时未出宿舍   推送对象：各二级学院分管学生工作（副）
//     *
//     * @param token
//     * @param phone
//     */
//    public void sendMessageTeachLeaderTwo(String token, String phone, String bjmc, String studentName) {
//        String message = "二级学院书记，您好：\n" +
//                "贵学院" + bjmc + "班级，" + studentName + "，目前已48小时未离开宿舍，请敦促辅导员关注学生情况。";
//        sendMessageCommon(token, phone, message, "5", DateUtils.getBeforeDateStr());
//    }
//
//    @Autowired
//    SysRecordPushMessageHistoryServiceImpl sysRecordPushMessageHistoryServiceImpl;
//
//    private void savePushHistory(String type, String phone, String content, String result, String showTime, String url) {
//        savePushHistory(type, phone, content, result, showTime, url,"");
//    }
//
//    /**
//     * 保存发送的推送信息
//     *
//     * @param type
//     * @param phone
//     * @param content
//     * @param result
//     */
//    private void savePushHistory(String type, String phone, String content, String result, String showTime, String url, String name) {
//        try {
//            SysRecordPushMessageHistory baseModel = new SysRecordPushMessageHistory();
//            baseModel.setName(name);
//            baseModel.setContent(content);
//            baseModel.setPhone(phone);
//            baseModel.setSendResult(result);
//            baseModel.setType(type);
//            if (!StrKit.isEmpty(result)) {
//                JSONObject json = JSON.parseObject(result);
//                baseModel.setSendStatus(json.get("errcode").toString());
//            }
//            baseModel.setCreateTime(new Date());
//            baseModel.setSendTime(new Date());
//            baseModel.setUrl(url);
//            baseModel.setShowTime(showTime);
//            sysRecordPushMessageHistoryServiceImpl.insertSysRecordPushMessageHistory(baseModel);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    /**
//     * 发送 微信推送信息
//     *
//     * @param token
//     * @param phone
//     * @param message
//     */
//    public void sendMessageCommon(String token, String phone, String message, String type, String showTime) {
//        //得到userId
//        String userId = sendWeChatMessage.getUserId(token, phone);
//        //构造消息体
//        StringBuffer sb = new StringBuffer();
//        sb.append("{");
//        sb.append("\"touser\":" + "\"" + userId + "\",");
//        sb.append("\"msgtype\":" + "\"" + "text" + "\",");
//        sb.append("\"agentid\":" + "\"" + sendWeChatMessage.getAgentId() + "\",");
//        sb.append("\"text\":" + "{");
//        sb.append("\"content\":" + "\"" + message + "\"},");
//        sb.append("\"safe\":\"0\"");
//        sb.append("}");
//        System.out.println("消息内容" + sb.toString());
//        //发送消息
//        String result = sendWeChatMessage.sendMessage(token, sb.toString());
//        System.out.println("返送消息返回结果====》" + result);
//        //保存发送记录
//        savePushHistory(type, phone, message, result, showTime, "");
//    }
//
//    public void sendMessageToTeachTest(String token, String phone, String message) {
//        //得到userId
//        String userId = sendWeChatMessage.getUserId(token, phone);
//        //构造消息体
//        StringBuffer sb = new StringBuffer();
////        String content = userId + "，" + message;
//        String content = userId + "，" + "您的考勤<a href='http://qywx.ckxx.tech'>点击查询学生归寝室明细</a>..我的班级情况.";
//        content = "晚归人员\n" +
//                "\n" +
//                "姓名：   " + userId + "\n" +
//                "时间：   " + DateUtils.getTime() + "\n" +
//                "地点：   秋实园三舍\n" +
//                "异常情况：晚归\n" +
//                "备注：   请核实学生晚归是否属实，如果属实请及时联系学生家长，做好学生教育管理工作，确保学生安全\n" +
//                "";
//        sb.append("{");
//        sb.append("\"touser\":" + "\"" + userId + "\",");
//        sb.append("\"msgtype\":" + "\"" + "text" + "\",");
//        sb.append("\"agentid\":" + "\"" + sendWeChatMessage.getAgentId() + "\",");
//        sb.append("\"text\":" + "{");
//        sb.append("\"content\":" + "\"" + content + "\"},");
//        sb.append("\"safe\":\"0\"");
//        sb.append("}");
//        System.out.println("消息内容" + sb.toString());
//        //发送消息
//        String result = sendWeChatMessage.sendMessage(token, sb.toString());
//        System.out.println("返送消息返回结果====》" + result);
//    }
//
//    /**
//     * 发送消息给老师
//     *
//     * @param token
//     * @param phone
//     */
//    public void sendMessageToTeach(String token, String phone, String studentName) {
//        //得到userId
//        String userId = sendWeChatMessage.getUserId(token, phone);
//        String address = "";
//        String name = IdUtils.simpleUUID();
//        String url = "http://139.9.157.201/open/show?name=" + name;
//        //构造消息体
//        StringBuffer sb = new StringBuffer();
//        String description = "晚归人员\n" +
//                " \n" +
//                " \n" +
//                "姓名：   " + studentName + "\n" +
//                "时间：   " + DateUtils.getTime() + "\n" +
//                "地点：   " + address + "\n" +
//                "异常情况：晚归\n" +
//                "备注：   请核实学生晚归是否属实，如果属实请及时联系学生家长，做好学生教育管理工作，确保学生安全\n";
//        sb.append("{");
//        sb.append("\"touser\":" + "\"" + userId + "\",");
//        sb.append("\"msgtype\":" + "\"" + "textcard" + "\",");
//        sb.append("\"agentid\":" + "\"" + sendWeChatMessage.getAgentId() + "\",");
//        sb.append("\"textcard\":" + "{");
//        sb.append("\"title\":" + "\"学生宿舍考勤异常通知" + "\",");
//        sb.append("\"description\":" + "\"" + description + "\",");
//        sb.append("\"url\":" + "\"" + url + "\",");
//        sb.append("\"btntxt\":" + "\"更多");
//        sb.append("}");
//        sb.append("}");
//        System.out.println("消息内容" + sb.toString());
//        //发送消息
//        String result = sendWeChatMessage.sendMessage(token, sb.toString());
//        System.out.println("返送消息返回结果====》" + result);
//        //修改老师发是消息记录
//        savePushHistory("2", phone, sb.toString(), result, DateUtils.dateTime(), url, name);
//    }

}
