package com.ruoyi.person.Utils.loginUtil;

import com.alibaba.fastjson.JSON;
import com.ruoyi.person.Utils.CookieUtils;
import com.ruoyi.person.Utils.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 *  人脸系统登录 获取cookie
 *
 */
public class FaceGateLogin {

//    @Value("${fastgate.user}")
    private String user ="admin";
//    @Value("${fastgate.passwd}")
    private String passwd ="21232f297a57a5a743894a0e4a801fc3";
    @Autowired
    CookieUtils cookieUtils;
    /**
     *  获取cookie
     * @return
     * @throws Exception
     */
    public String faceGateLogin() throws Exception {
        ServerAddress serverAddress = new ServerAddress();
        String getSerAdd = serverAddress.getServerAddress();
        // 登录的地址
        String surl = getSerAdd + "/user/login";

        /**
         * 首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。比如： // Using
         * java.net.URL and //java.net.URLConnection
         */
        URL url = new URL(surl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        /**
         * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。
         * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：
         */
        connection.setDoOutput(true);
        connection.setDoInput(true);
        // Post 请求不能使用缓存
        connection.setUseCaches(false);
        //设置请求头
        connection.setRequestProperty("Content-type", "application/json");
        /**
         * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...
         */
        //其中的memberName和password也是阅读html代码得知的，即为表单中对应的参数名称
        Map map = new HashMap();
        map.put("Id", user);
        map.put("Pwd", passwd);
        String json = JSON.toJSONString(map);
        if (json != null) {
            byte[] writebytes = json.getBytes();
            // 设置文件长度
            connection.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
            OutputStream outwritestream = connection.getOutputStream();
            outwritestream.write(json.getBytes());
            outwritestream.flush();
            outwritestream.close();
        }
        // 取得cookie，相当于记录了身份，供下次访问时使用
        String cookieVal = connection.getHeaderField("Set-Cookie");
//        CookieUtils saveCookie = new CookieUtils();
//        cookieUtils.saveCookie(cookieVal);
        System.out.println("登录成功：" + cookieVal);
        return cookieVal;
    }
}
