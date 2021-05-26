package com.ruoyi.web.scheduled;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.late.domain.SysRecordPushMessageHistory;
import com.ruoyi.late.service.impl.SysRecordPushMessageHistoryServiceImpl;
import com.ruoyi.utilswx.SendWeChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * 10点钟 给没有回寝室的同学推送消息  相关任务定时器类
 */
public class PushMessageCommon {

    //企业Id
    @Value("${wechat.showxwurl}")
    private   String showxwurl;

    @Autowired
    private SendWeChatMessage sendWeChatMessage;

    /**
     * 第一次推送  时间：22:00    推送对象：未进入宿舍学生
     *
     * @param token
     * @param userId
     */
    public void sendMessageCallBack(String token, String userId,String closeTime) {
        String message = "               温馨提示\n" +
                "各位同学：\n" +
                "根据《重庆城市管理职业学院学生宿舍管理规定》，学生宿舍作息时间为晚上"+closeTime+"关门，晚上关大门后回宿舍视为晚归，请尽快返回宿舍。";
        sendMessageCommon(token, userId, message, "1", DateUtils.dateTime());
    }
    /**
     * 22:30分 学生晚归
     *
     * @param token
     * @param userId
     */
    public void sendMessageStudentLateBack(String token, String userId) {
        String message = "           晚归违纪提示\n" +
                "同学：\n" +
//                "根据《重庆城市管理职业学院学生宿舍管理规定》，学生宿舍作息时间为晚上"+closeTime+"关门，"+closeTime+"未回寝视为晚归";
                "根据《重庆城市管理职业学院学生宿舍管理规定》，你已晚归违纪，请尽快返回寝室，同时请务必注意安全，并及时向辅导员老师反馈情况";
        sendMessageCommon(token, userId, message, "7", DateUtils.dateTime());
    }
    /**
     * 22:30分 学生晚归
     *
     * @param token
     * @param userId
     */
    public void sendMessageStudentNoBack(String token, String userId) {
        String message = "           夜不归寝违纪提示\n" +
                "同学：\n" +
//                "根据《重庆城市管理职业学院学生宿舍管理规定》，学生宿舍作息时间为晚上"+closeTime+"关门，"+closeTime+"未回寝视为晚归";
                "根据《重庆城市管理职业学院学生宿舍管理规定》，你已晚归违纪，请尽快返回寝室，同时请务必注意安全，并及时向辅导员老师反馈情况";
        sendMessageCommon(token, userId, message, "8", DateUtils.dateTime());
    }

    /**
     * 第二次推送  时间：22:30    推送对象：辅导员（将22:30还未按时返回宿舍的学生数据推送到辅导员处
     *
     * @param token
     * @param userId
     */
    public void sendMessageTeach(String token, String userId, String bjmc, String studentName) {
        String message = "辅导员老师，您好：\n" +
                "您所带学生" + bjmc + "班级，" + studentName + "同学，尚未返回宿舍，请核实学生晚归是否属实，如果属实请及时联系学生家长，做好学生教育管理工作，确保学生安全。";
        sendMessageCommon(token, userId, message, "2", DateUtils.dateTime());
    }

    /**
     * 第三次推送  时间00:00 推送对象：各二级学院分管学生工作（副）书记，将辅导员未处理晚归学生名单推送给书记，并将未返回宿舍学生名单认定为“夜不归寝”。
     *
     * @param token
     * @param userId
     */
    public void sendMessageTeachLeader(String token, String userId, String bjmc, String studentName) {
        String message = "二级学院书记，您好：\n" +
                "贵学院" + bjmc + "班级，" + studentName + "同学晚归，目前辅导员尚未核实处理，请敦促辅导员核实学生晚归是否属实，如果属实请及时联系学生家长，做好学生教育管理工作，确保学生安全。";
        sendMessageCommon(token, userId, message, "3", DateUtils.getBeforeDateStr());
    }

    /**
     * 4. 超过24小时未出宿舍   推送对象：辅导员
     *
     * @param token
     * @param userId
     */
    public void sendMessageTeachTwo(String token, String userId, String bjmc, String studentName) {
        String message = "辅导员老师，您好：\n" +
                "您所带学生" + bjmc + "班级，" + studentName + "，目前已24小时未离开宿舍，请关注学生情况。";
        sendMessageCommon(token, userId, message, "4", DateUtils.getBeforeDateStr());
    }

    /**
     * 超过48小时未出宿舍   推送对象：各二级学院分管学生工作（副）
     *
     * @param token
     * @param userId
     */
    public void sendMessageTeachLeaderTwo(String token, String userId, String bjmc, String studentName) {
        String message = "二级学院书记，您好：\n" +
                "贵学院" + bjmc + "班级，" + studentName + "，目前已48小时未离开宿舍，请敦促辅导员关注学生情况。";
        sendMessageCommon(token, userId, message, "5", DateUtils.getBeforeDateStr());
    }

    @Autowired
    SysRecordPushMessageHistoryServiceImpl sysRecordPushMessageHistoryServiceImpl;

    public void savePushHistory(String type, String userId, String content, String result, String showTime, String url) {
        savePushHistory(type, userId, content, result, showTime, url, "");
    }

    /**
     * 保存发送的推送信息
     *
     * @param type
     * @param phone
     * @param content
     * @param result
     * @param showTime
     * @param url
     * @param name
     */
    public void savePushHistory(String type, String phone, String content, String result, String showTime, String url, String name) {
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
        savePushHistory(type, phone, content, result, showTime, url, name,"");
    }

    /**
     * 保存发送的推送信息
     *
     * @param type
     * @param phone
     * @param content
     * @param result
     */
    public void savePushHistory(String type, String phone, String content, String result, String showTime, String url, String name, String dwdm) {
        try {
            SysRecordPushMessageHistory baseModel = new SysRecordPushMessageHistory();
            baseModel.setName(name);
            baseModel.setContent(content);
            baseModel.setPhone(phone);
            baseModel.setSendResult(result);
            baseModel.setType(type);
            if (!StrKit.isEmpty(result)) {
                JSONObject json = JSON.parseObject(result);
                baseModel.setSendStatus(json.get("errcode").toString());
            }
            baseModel.setCreateTime(new Date());
            baseModel.setSendTime(new Date());
            baseModel.setUrl(url);
            if (!StrKit.isEmpty(dwdm)) {
                baseModel.setToUser(dwdm);
            }
            baseModel.setShowTime(showTime);
            sysRecordPushMessageHistoryServiceImpl.insertSysRecordPushMessageHistory(baseModel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 发送 微信推送信息
     *
     * @param token
     * @param userId
     * @param message
     */
    public void sendMessageCommon(String token, String userId, String message, String type, String showTime) {
        //得到userId
//        String userId = sendWeChatMessage.getUserId(token, phone);
        //构造消息体
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"touser\":" + "\"" + userId + "\",");
        sb.append("\"msgtype\":" + "\"" + "text" + "\",");
        sb.append("\"agentid\":" + "\"" + sendWeChatMessage.getAgentIdToStudent() + "\",");
        sb.append("\"text\":" + "{");
        sb.append("\"content\":" + "\"" + message + "\"},");
        sb.append("\"safe\":\"0\"");
        sb.append("}");
        System.out.println("消息内容" + sb.toString());
        //发送消息
        String result = sendWeChatMessage.sendMessage(token, sb.toString());
        System.out.println("返送消息返回结果====》" + result);
        //保存发送记录
        savePushHistory(type, userId, message, result, showTime, "");
    }

    public void sendMessageToTeachTest(String token, String userId, String message) {
        //得到userId
//        String userId = sendWeChatMessage.getUserId(token, phone);
        //构造消息体
        StringBuffer sb = new StringBuffer();
        String content = "晚归人员\n" +
                "\n" +
                "姓名：   " + userId + "\n" +
                "时间：   " + DateUtils.getTime() + "\n" +
                "地点：   秋实园三舍\n" +
                "异常情况：晚归\n" +
                "备注：   请核实学生晚归是否属实，如果属实请及时联系学生家长，做好学生教育管理工作，确保学生安全\n" +
                "";
        sb.append("{");
        sb.append("\"touser\":" + "\"" + userId + "\",");
        sb.append("\"msgtype\":" + "\"" + "text" + "\",");
        sb.append("\"agentid\":" + "\"" + sendWeChatMessage.getAgentId() + "\",");
        sb.append("\"text\":" + "{");
        sb.append("\"content\":" + "\"" + content + "\"},");
        sb.append("\"safe\":\"0\"");
        sb.append("}");
        System.out.println("消息内容" + sb.toString());
        //发送消息
        String result = sendWeChatMessage.sendMessage(token, sb.toString());
        System.out.println("返送消息返回结果====》" + result);
    }

    /**
     * 发送消息给老师
     *
     * @param token
     * @param userId
     */
    public void sendMessageToTeach(String token, String userId, String showTime,String closeTime,String lateStr) {
        String name = IdUtils.simpleUUID();
        String url =  showxwurl +"/#/fdylist?name=" + name;
        //构造消息体
        StringBuffer sb = new StringBuffer();
        String description = "辅导员老师，您好\n" +
                " \n" +
                " \n" +
                "时间：   " + DateUtils.getTime() + "\n" +
                "您所带的班级有学生在"+closeTime+"尚未返回宿舍，请核实学生【"+lateStr+"】是否属实，如果属实请及时联系学生家长，做好学生教育管理工作，确保学生安全。\n";
        sb.append("{");
        sb.append("\"touser\":" + "\"" + userId + "\",");
        sb.append("\"msgtype\":" + "\"" + "textcard" + "\",");
        sb.append("\"agentid\":" + "\"" + sendWeChatMessage.getAgentId() + "\",");
        sb.append("\"textcard\":" + "{");
        sb.append("\"title\":" + "\"学生宿舍考勤异常通知" + "\",");
        sb.append("\"description\":" + "\"" + description + "\",");
        sb.append("\"url\":" + "\"" + url + "\",");
        sb.append("\"btntxt\":" + "\"更多");
        sb.append("}");
        sb.append("}");
        System.out.println("消息内容" + sb.toString());
        //发送消息

        String result = sendWeChatMessage.sendMessage(token, sb.toString());
        System.out.println("返送消息返回结果====》" + result);
        //修改老师发是消息记录
        savePushHistory("2", userId, sb.toString(), result, showTime, url, name);
    }

    /**
     * 发送消息给老师
     *
     * @param token
     * @param userId
     */
    public void sendMessageToTeachLeader(String token, String userId, String showTime, String dwdm) {
        String name = IdUtils.simpleUUID();
        String url = showxwurl + "/#/statisticsbjstatics?name=" + name;
        //构造消息体
        StringBuffer sb = new StringBuffer();
        String description = "二级学院书记，您好\n" +
                " \n" +
                " \n" +
                "时间：   " + DateUtils.getTime() + "\n" +
                "贵学院有学生晚归，目前辅导员尚未核实处理，请敦促辅导员核实学生晚归是否属实，如果属实请及时联系学生家长，做好学生教育管理工作，确保学生安全。\n";
        sb.append("{");
        sb.append("\"touser\":" + "\"" + userId + "\",");
        sb.append("\"msgtype\":" + "\"" + "textcard" + "\",");
        sb.append("\"agentid\":" + "\"" + sendWeChatMessage.getAgentId() + "\",");
        sb.append("\"textcard\":" + "{");
        sb.append("\"title\":" + "\"学生宿舍考勤异常通知" + "\",");
        sb.append("\"description\":" + "\"" + description + "\",");
        sb.append("\"url\":" + "\"" + url + "\",");
        sb.append("\"btntxt\":" + "\"更多");
        sb.append("}");
        sb.append("}");
        System.out.println("消息内容" + sb.toString());
        //发送消息
        String result = sendWeChatMessage.sendMessage(token, sb.toString());
        System.out.println("返送消息返回结果====》" + result);
        //修改老师发是消息记录
        savePushHistory("3", userId, sb.toString(), result, showTime, url, name,dwdm);
    }

    /**
     * 发送消息给老师
     *
     * @param token
     * @param userId
     */
    public void sendMessageToTeach24Hour(String token, String userId, String showTime) {
        String name = IdUtils.simpleUUID();
        String url = showxwurl +"/#/whqlist?name=" + name;
        //构造消息体
        StringBuffer sb = new StringBuffer();
        String description = "辅导员老师，您好\n" +
                " \n" +
                " \n" +
                "时间：   " + DateUtils.getTime() + "\n" +
                "您所带的班级目前有学生24小时未离开宿舍，请关注学生情况。\n";
        sb.append("{");
        sb.append("\"touser\":" + "\"" + userId + "\",");
        sb.append("\"msgtype\":" + "\"" + "textcard" + "\",");
        sb.append("\"agentid\":" + "\"" + sendWeChatMessage.getAgentId() + "\",");
        sb.append("\"textcard\":" + "{");
        sb.append("\"title\":" + "\"学生24小时未离开宿舍通知" + "\",");
        sb.append("\"description\":" + "\"" + description + "\",");
        sb.append("\"url\":" + "\"" + url + "\",");
        sb.append("\"btntxt\":" + "\"更多");
        sb.append("}");
        sb.append("}");
        System.out.println("消息内容" + sb.toString());
        //发送消息
        String result = sendWeChatMessage.sendMessage(token, sb.toString());
        System.out.println("返送消息返回结果====》" + result);
        //修改老师发是消息记录
        savePushHistory("4", userId, sb.toString(), result, showTime, url, name);
    }

}
