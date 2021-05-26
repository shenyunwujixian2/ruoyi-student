package com.ruoyi.person.PeosonManger;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.person.Bean.UniResult;
import com.ruoyi.person.Bean.queryBean.QueryAcessInfoBean;
import com.ruoyi.person.Utils.ServerAddress;
import com.ruoyi.person.Utils.StringToBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sW4716 on 2018/3/7.
 */
@Component
public class AcessConn {

    @Autowired
    RedisCache redisCache;
    /**
     * 分页查询信息 +模糊查询
     *
     * @return 人员基本信息
     */
    public UniResult QueryAcessInfo(QueryAcessInfoBean queryAcessInfoBean,String cookieVal) throws Exception {
        //获取地址
        ServerAddress serverAddress = new ServerAddress();
        String sAdd = serverAddress.getServerAddress();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startTime", queryAcessInfoBean.getStartTime().toString());
        map.put("endTime", queryAcessInfoBean.getEndTime().toString());
        map.put("page", queryAcessInfoBean.getPage());
        map.put("size", queryAcessInfoBean.getSize());
        if(!StrKit.isEmpty(queryAcessInfoBean.getPersonType())){
            map.put("personType", queryAcessInfoBean.getPersonType());
        }
        if(!StrKit.isEmpty(queryAcessInfoBean.getPersonCode())){
            map.put("personCode", queryAcessInfoBean.getPersonCode());
        }
        if(!StrKit.isEmpty(queryAcessInfoBean.getInOrOut())){
            map.put("inOrOut", queryAcessInfoBean.getInOrOut());
        }
        // 将Map转换为JSONArray数据  查询条件
        String json = JSON.toJSONString(map);
        json = URLEncoder.encode(json,"gb2312");
        json = json.replaceAll("%3A", ":").replaceAll("%2C",",");
        System.out.println("编码的字符串==>"+json);
        String sUrl = sAdd + "accessRecords" + "?conditionParam=" + json;
        //重新打开一个连接
        URL url = new URL(sUrl);
        HttpURLConnection resumeConnection = (HttpURLConnection) url.openConnection();
        //设置请求头
        resumeConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        resumeConnection.setRequestProperty("Accept", "application/json");
        //请求的方法
        resumeConnection.setRequestMethod("GET");
        if (cookieVal != null) {
            //发送cookie信息上去，以表明自己的身份，否则会被认为没有权限
            resumeConnection.setRequestProperty("Cookie", cookieVal);
        }
        resumeConnection.connect();
        //获取返回体
        InputStream urlStream = resumeConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(urlStream));
        String ss = null;
        String total = "";
        while ((ss = bufferedReader.readLine()) != null) {
            total += ss;
        }
        bufferedReader.close();
        System.out.println("得到的数据信息====》"+total);
        //获取结果 String 类型字符串转化为UniResult结果集
        StringToBean stringToBean = new StringToBean();
        UniResult uniResult = stringToBean.stringToUniResult(total);
        return uniResult;
    }

}
