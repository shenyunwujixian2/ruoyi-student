package com.ruoyi.web.controller.record;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.record.domain.PushMessageModel;
import com.ruoyi.record.service.PushMessageService;
import com.ruoyi.utilswx.SendWeChatMessage;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 消息推送信息
 *
 * @author ruoyi
 */
@Api(tags="7、消息推送信息")
@RestController
@RequestMapping("/record/pushmessage")
public class PushMessageController extends BaseController
{
    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private SendWeChatMessage sendWeChatMessage;

    @Autowired
    RedisCache redisCache;
    /**
     *
     * 获取消息推送列表
     */
//    @ApiOperation("获取打卡消息推送列表")
    @PreAuthorize("@ss.hasPermi('system:pushmessage:list')")
    @GetMapping("/list")
    public TableDataInfo list(PushMessageModel baseModel)
    {
//        HashMap<String,Object> reqMap = new HashMap<>();
//        BeanUtils.copyProperties(baseModel,reqMap);
        HashMap<String,Object> reqMap = (HashMap<String, Object>) BeanUtils.convertBeanToMap(baseModel);
        startPage();
        List<PushMessageModel> depts = pushMessageService.getList(reqMap);
        return getDataTable(depts);
    }

    @ApiOperation("发送推送消息")
//    @PreAuthorize("@ss.hasPermi('system:pushmessage:send')")
    @PostMapping("/send")
    public AjaxResult send(@RequestBody PushModel pushModel)
    {
        //初始化token
//        String token = sendWeChatMessage.getToken();
        String token = "";
        if(redisCache.getCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN")==null){
             token = sendWeChatMessage.getToken();
            redisCache.setCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN", token, 30, TimeUnit.MINUTES);
        }else {
             token = redisCache.getCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN");
        }

        if(StrKit.isEmpty(pushModel.getPhone())){
            return AjaxResult.error("手机号不能为空");
        }
        String phone = pushModel.getPhone();

        if(StrKit.isEmpty(pushModel.getType())){
            return AjaxResult.error("消息类型不能为空");
        }
        String type = pushModel.getType();
        switch (type){
            case "1":
                sendMessageCallBack(token, phone);
                break;
            case "2":
                sendMessageTeach(token, phone,"汽车A2002");
                break;
            case "3":
                sendMessageTeachLeader(token, phone,"汽车A2002");
                break;
            case "4":
                sendMessageTeachTwo(token, phone,"汽车A2002","李翔");
                break;
            case "5":
                sendMessageTeachLeaderTwo(token, phone,"汽车A2002","李翔");
                break;
        }
        return AjaxResult.success();
    }


    /**
     * 第一次推送  时间：22:00    推送对象：未进入宿舍学生
     * @param token
     * @param phone
     */
    public void sendMessageCallBack(String token, String phone) {
        String message  = "              温馨提示\n" +
                "各位同学：\n" +
                "根据《重庆城市管理职业学院学生宿舍管理规定》，学生宿舍作息时间为晚上22:30关门，晚上关大门后回宿舍视为晚归，请尽快返回宿舍。";
        sendMessageCommon(token,phone,message);
    }
    /**
     * 第二次推送  时间：22:30    推送对象：辅导员（将22:30还未按时返回宿舍的学生数据推送到辅导员处
     * @param token
     * @param phone
     */
    public void sendMessageTeach(String token, String phone,String bjmc) {
        String message  = "辅导员老师，您好：\n" +
                "您所带学生"+bjmc+"班级，22:30尚未返回宿舍，请核实学生晚归是否属实，如果属实请及时联系学生家长，做好学生教育管理工作，确保学生安全。";
        sendCommonMessageToTeach(token,phone, message,"http://qywx.ckxx.tech/#/teacherlist");
    }
    /**
     * 第三次推送  时间00:00 推送对象：各二级学院分管学生工作（副）书记，将辅导员未处理晚归学生名单推送给书记，并将未返回宿舍学生名单认定为“夜不归寝”。
     * @param token
     * @param phone
     */
    public void sendMessageTeachLeader(String token, String phone,String bjmc) {
        String message  = "二级学院书记，您好：\n" +
                "贵学院"+bjmc+"班级，同学晚归，目前辅导员尚未核实处理，请敦促辅导员核实学生晚归是否属实，如果属实请及时联系学生家长，做好学生教育管理工作，确保学生安全。";
        sendCommonMessageToTeach(token,phone,message,"http://qywx.ckxx.tech/#/querydaydayStatistics");
    }
    /**
     * 4. 超过24小时未出宿舍   推送对象：辅导员
     * @param token
     * @param phone
     */
    public void sendMessageTeachTwo(String token, String phone,String bjmc, String studentName) {
        String message  = "辅导员老师，您好：\n" +
                "您所带学生"+bjmc+"班级，"+studentName+"，目前已24小时未离开宿舍，请关注学生情况。";
        sendCommonMessageToTeach(token,phone,message,"http://qywx.ckxx.tech/#/teacherlist");
    }
    /**
     * 超过48小时未出宿舍   推送对象：各二级学院分管学生工作（副）
     * @param token
     * @param phone
     */
    public void sendMessageTeachLeaderTwo(String token, String phone,String bjmc, String studentName) {
        String message  = "二级学院书记，您好：\n" +
                "贵学院"+bjmc+"班级，"+studentName+"，目前已48小时未离开宿舍，请敦促辅导员关注学生情况。";
        sendCommonMessageToTeach(token,phone,message,"http://qywx.ckxx.tech/#/querydaydayStatistics");
    }

    /**
     * 发送 微信推送信息
     *
     * @param token
     * @param phone
     * @param message
     */
    public void sendMessageCommon(String token, String phone, String message) {
        //得到userId
        String userId = sendWeChatMessage.getUserId(token, phone);
        if(StrKit.isEmpty(userId)){
            return;
        }
        //构造消息体
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"touser\":" + "\"" + userId + "\",");
        sb.append("\"msgtype\":" + "\"" + "text" + "\",");
        sb.append("\"agentid\":" + "\"" + sendWeChatMessage.getAgentId() + "\",");
        sb.append("\"text\":" + "{");
        sb.append("\"content\":" + "\"" + message + "\"},");
        sb.append("\"safe\":\"0\"");
        sb.append("}");
        System.out.println("消息内容"+sb.toString());
        //发送消息
        sendWeChatMessage.sendMessage(token, sb.toString());
    }

    /**
     * 发送消息给老师
     * @param token
     * @param phone
     */
    public void sendCommonMessageToTeach(String token, String phone,String content, String url ) {
        //得到userId
        String userId = sendWeChatMessage.getUserId(token, phone);
        if(StrKit.isEmpty(userId)){
            return;
        }
//        String address = "宁静园二舍";
//        String url = "http://139.9.157.201";
//        String description = "晚归人员\n" +
//                " \n" +
//                " \n" +
//                "姓名：   "+ studentName+"\n" +
//                "时间：   "+ DateUtils.getTime() +"\n" +
//                "地点：   "+ address +"\n" +
//                "异常情况：晚归\n" +
//                "备注：   请核实学生晚归是否属实，如果属实请及时联系学生家长，做好学生教育管理工作，确保学生安全\n" +
//                "";
        //构造消息体
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"touser\":" + "\"" + userId + "\",");
        sb.append("\"msgtype\":" + "\"" + "textcard" + "\",");
        sb.append("\"agentid\":" + "\"" + sendWeChatMessage.getAgentId() + "\",");
        sb.append("\"textcard\":" + "{");
        sb.append("\"title\":" +"\"学生宿舍考勤异常通知"+ "\",");
        sb.append("\"description\":" + "\"" + content + "\",");
        sb.append("\"url\":" +"\""+ url+ "\",");
        sb.append("\"btntxt\":" +"\"更多");
        sb.append("}");
        sb.append("}");
        System.out.println("消息内容"+sb.toString());
        //发送消息
        sendWeChatMessage.sendMessage(token, sb.toString());
    }


}

class PushModel {
    @ApiModelProperty("电话号")
    private String phone;

    @ApiModelProperty("消息类型")
    private String type;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}