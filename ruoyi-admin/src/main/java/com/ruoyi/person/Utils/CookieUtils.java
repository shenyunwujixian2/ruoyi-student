package com.ruoyi.person.Utils;

import com.ruoyi.common.core.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by sW4716 on 2018/3/7.
 */
public class CookieUtils {


    @Autowired
    private RedisCache redisCache;

    /**
     * 登录后将 cookie 保存下来
     *
     * @param getCookie
     */
    public void saveCookie(String getCookie) {
//        PropertiesUtils propertiesUtil=new PropertiesUtils();
//        String configPath=System.getProperty("user.dir") + "/config/server.properties";
//        PropertiesUtils propertiesUtils=new PropertiesUtils();
//        propertiesUtils.writeProperties(configPath,"cookie",getCookie);

        //保存到redis中
        redisCache.setCacheObject("COOKIE_GET_USER_ACESS_CONN", getCookie, 30, TimeUnit.MINUTES);
    }

    /**
     * 其他接口直接从配置文件里读取 此cookie值  每次登录后  更新cookie
     *
     * @return
     */
    public String getCookie() {
//        PropertiesUtils propertiesUtil=new PropertiesUtils();
//        String configPath=System.getProperty("user.dir") + "/config/server.properties";
//        Map configMap= propertiesUtil.readProperties(configPath);
//        String cookie= (String) configMap.get("cookie");
//        return  cookie;

        String cookie = "";
        try {
            if (null == redisCache.getCacheObject("COOKIE_GET_USER_ACESS_CONN")) {
                return "";
            }
            cookie = redisCache.getCacheObject("COOKIE_GET_USER_ACESS_CONN");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return cookie;
    }
}
