package com.ruoyi.utilswx;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.StringUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Data
@Component
public class SendWeChatMessage {
    //企业Id
    @Value("${wechat.corpid}")
    private   String corpid;
    //应用私钥
    @Value("${wechat.corpsecret}")
    private  String corpsecret;
    // 获取访问权限码（access_token）URL  GET请求
    @Value("${wechat.ACCESS_TOKEN_URL}")
    private   String ACCESS_TOKEN_URL ;
    // 发送消息URL POST请求
    @Value("${wechat.CREATE_SESSION_URL}")
    private   String CREATE_SESSION_URL;
    // 获取企业微信用户userid POST请求
    @Value("${wechat.GET_USER_ID}")
    private   String GET_USER_ID;

//    private String token;
    //应用ID
    @Value("${wechat.agentId}")
    private  String agentId;

    //应用私钥
    @Value("${wechat.corpsecretToStudent}")
    private  String corpsecretToStudent;
    //应用ID
    @Value("${wechat.agentIdToStudent}")
    private  String agentIdToStudent;
    //学生应用的token
//    private String tokenToStudent;

    @Autowired
    RedisCache redisCache;

    public String getToken(){
        //没有token就初始化
//        if(StringUtils.isBlank(token)){
//            initToken();
//        }
//        return token;
        String token = "";
        if (redisCache.getCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN") == null) {
            token = initToken();
            redisCache.setCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN", token, 20, TimeUnit.MINUTES);
        } else {
            token = redisCache.getCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN");
        }
        return token;
    }
    /**
     * 初始化token
     * @return
     */
    public String initToken(){
        RestTemplate restTemplate = new RestTemplate();
        String url = ACCESS_TOKEN_URL.replaceAll("CORPID",corpid).replaceAll("CORPSECRET", corpsecret );
        JSONObject jsonObject = restTemplate.getForObject(url, JSONObject.class);
        String tokenNew = jsonObject.getString("access_token");
        return tokenNew;
    }

    public String getTokenStudent(){
        //没有token就初始化
//        if(StringUtils.isBlank(tokenToStudent)){
//            initTokenToStudent();
//        }
//        return tokenToStudent;
        String tokenToStudent= "";
        if (redisCache.getCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN_TO_STUDENT") == null) {
//        SendWeChatMessage sendWeChatMessage = new SendWeChatMessage();
            tokenToStudent = initTokenToStudent();
            redisCache.setCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN_TO_STUDENT", tokenToStudent, 20, TimeUnit.MINUTES);
        } else {
            tokenToStudent = redisCache.getCacheObject("SEND_WE_CHAT_MESSAGE_TOKEN_TO_STUDENT");
        }
        return tokenToStudent;
    }
    /**
     * 初始化学生token
     * @return
     */
    public String initTokenToStudent(){
        RestTemplate restTemplate = new RestTemplate();
        String url = ACCESS_TOKEN_URL.replaceAll("CORPID",corpid).replaceAll("CORPSECRET", corpsecretToStudent );
        JSONObject jsonObject = restTemplate.getForObject(url, JSONObject.class);
        String tokenToStudent = jsonObject.getString("access_token");
        return tokenToStudent;
    }

    /**
     * 根据电话号码得到userId
     * @param token
     * @param employeePhone
     * @return
     */
    public String getUserId(String token,String employeePhone){
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"mobile\":" + "\"" + employeePhone + "\",");
        sb.append("}");
        String json = sb.toString();
        String result = "";
        String url = GET_USER_ID + token;
        try {
            HttpsURLConnection http = getHttp(url);
            OutputStream os = http.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            result = new String(jsonBytes, "UTF-8");
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        return jsonObject.getString("userid");
    }


    public HttpsURLConnection getHttp(String action) throws Exception {
        URL url = null;
        HttpsURLConnection http = null;
        try {
            url = new URL(action);
            http = (HttpsURLConnection)url.openConnection();
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            http.setDoOutput(true);
            http.setDoInput(true);
            //连接超时30秒
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
            //读取超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000");
            http.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return http;
    }


    public String sendMessage(String token,String json){
//        return "{\"errcode\":0,\"errmsg\":\"ok.这是我的测试. \",\"invaliduser\":\"\"}";
        //请求链接
        String action = CREATE_SESSION_URL + token;
        String result = "";
        try {
            HttpsURLConnection http = getHttp(action);
            OutputStream os = http.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            result = new String(jsonBytes, "UTF-8");
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return result;
    }
}