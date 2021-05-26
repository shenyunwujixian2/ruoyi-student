package com.ruoyi.utilswx;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Test {
    @Autowired
    private SendWeChatMessage sendWeChatMessage;

    public void sendMessage(){
        //初始化token
        String token=sendWeChatMessage.getToken();
        List<String> phoneList=new ArrayList<>(2);
//        phoneList.add("15573967198");
        phoneList.add("13618364604");
        phoneList.add("");
        for(String phone : phoneList){
            //得到userId
            String userId=sendWeChatMessage.getUserId(token,phone);
            //构造消息体
            StringBuffer sb = new StringBuffer();
            String content=userId+"，你好";
            sb.append("{");
            sb.append("\"touser\":" + "\"" + userId + "\",");
            sb.append("\"msgtype\":" + "\"" + "text" + "\",");
            sb.append("\"agentid\":" + "\"" + sendWeChatMessage.getAgentId() + "\",");
            sb.append("\"text\":" + "{");
            sb.append("\"content\":" + "\"" + content + "\"},");
            sb.append("\"safe\":\"0\"");
            sb.append("}");
            //发送消息
            String sendBoolen = sendWeChatMessage.sendMessage(token,sb.toString());
            System.out.println("发送状态===》"+sendBoolen);
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.sendMessage();
    }
}
