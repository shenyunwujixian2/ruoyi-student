package com.ruoyi.person.Utils;



import java.util.Map;

/**
 * Created by sW4716 on 2018/3/7.
 */
public class ServerAddress {
    /**
     * 获取配置文件里的地址 方便修改
     * @return
     */
    public String getServerAddress() {
        //读取配置文件信息 获取服务器地址
        PropertiesUtils propertiesUtil=new PropertiesUtils();
        String configPath=System.getProperty("user.dir") + "/config/server.properties";
        Map configMap= propertiesUtil.readProperties(configPath);
        String serverAddress= (String) configMap.get("serverAddress");
        return serverAddress;
    }
}
