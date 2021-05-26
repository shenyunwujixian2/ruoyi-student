package com.ruoyi.person.PeosonManger;

import com.alibaba.fastjson.JSON;
import com.ruoyi.person.Bean.PersonRecord;
import com.ruoyi.person.Bean.UniResult;
import com.ruoyi.person.Bean.queryBean.QueryPeopleInfoBean;
import com.ruoyi.person.Utils.CookieUtils;
import com.ruoyi.person.Utils.ServerAddress;
import com.ruoyi.person.Utils.StringToBean;
import com.ruoyi.person.Utils.personUtils.UploadFormFilePost;
import com.ruoyi.person.Utils.personUtils.UploadFormFilePut;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by sW4716 on 2018/3/4.
 */
public class PersonConn {

    /**
     * 通过id查询人员信息详情
     *
     * @return 人员基本信息
     */
    public UniResult queryPersonInfo(int seqid) throws Exception {
        //获取地址
        ServerAddress serverAddress = new ServerAddress();
        String sAdd = serverAddress.getServerAddress();
        String sUrl = sAdd + "/person/" + seqid;//10是人员的ID
        //重新打开一个连接
        URL url = new URL(sUrl);
        HttpURLConnection resumeConnection = (HttpURLConnection) url
                .openConnection();
        //引入cookie
        CookieUtils cookieUtils = new CookieUtils();
        String cookieVal = cookieUtils.getCookie();
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
        //获取结果 String 类型字符串转化为UniResult结果集
        StringToBean stringToBean=new StringToBean();
        UniResult uniResult= stringToBean.stringToUniResult(total);
        return  uniResult;
    }

    /**
     * 删除
     *
     * @return "ErrMsg":"success"
     */
    public UniResult deletePersonInfo(String code) throws Exception {
        //获取地址
        ServerAddress serverAddress = new ServerAddress();
        String sAdd = serverAddress.getServerAddress();
        String sUrl = sAdd + "/person/";
        //重新打开一个连接
        URL url = new URL(sUrl);
        HttpURLConnection resumeConnection = (HttpURLConnection) url
                .openConnection();
        resumeConnection.setRequestMethod("DELETE");
        resumeConnection.setDoOutput(true);
        resumeConnection.setDoInput(true);
        // Post 请求不能使用缓存
        resumeConnection.setUseCaches(false);
        //设置请求头
        resumeConnection.setRequestProperty("Content-type", "application/json");
        //引入cookie
        CookieUtils cookieUtils = new CookieUtils();
        String cookieVal = cookieUtils.getCookie();
        if (cookieVal != null) {
            //发送cookie信息上去，以表明自己的身份，否则会被认为没有权限
            resumeConnection.setRequestProperty("Cookie", cookieVal);
        }
        //删除传入的编号
        String code_arr[] = new String[]{code};
        String json = JSON.toJSONString(code_arr);
        if (json != null) {
            byte[] writebytes = json.getBytes();
            // 设置文件长度
            resumeConnection.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
            OutputStream outwritestream = resumeConnection.getOutputStream();
            outwritestream.write(json.getBytes());
            outwritestream.flush();
            outwritestream.close();
        }
        resumeConnection.connect();
        InputStream urlStream = resumeConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(urlStream));
        String ss = null;
        String total = "";
        while ((ss = bufferedReader.readLine()) != null) {
            total += ss;
        }
        bufferedReader.close();
        //获取结果 String 类型字符串转化为UniResult结果集
        StringToBean stringToBean=new StringToBean();
        UniResult uniResult= stringToBean.stringToUniResult(total);
        return  uniResult;
    }

    /**
     * 新增
     *
     * @return "ErrMsg":"success"
     */
    public UniResult addpersonInfo(PersonRecord personRecord) throws Exception {
        //获取地址
        ServerAddress serverAddress = new ServerAddress();
        String sAdd = serverAddress.getServerAddress();
        String sUrl = sAdd + "/person/";
        //字段集
        Map<String, String> fieldMap = new HashMap<String, String>();
        //表单字段映射
        fieldMap.put("Name", personRecord.getName());
        fieldMap.put("Code", personRecord.getCode());
        fieldMap.put("Depart", personRecord.getDepart());
        fieldMap.put("RoleIds", personRecord.getRoleIds().toString());
        //文件集
        Map<String, String> filesMap = new HashMap<String, String>();
        //要上传的文件 文件的地址映射 这里上传的是图片 只限6张
        List<String> filepath = personRecord.getFilepath();
        Iterator iterator = filepath.iterator();
        while (iterator.hasNext()) {
            filesMap.put("file", (String) iterator.next());
        }
        //引入cookie
        CookieUtils cookieUtils = new CookieUtils();
        String cookieVal = cookieUtils.getCookie();
        //调用模拟form 上传的方法
        UploadFormFilePost uploadFormFile = new UploadFormFilePost();
        String result = uploadFormFile.uploadFormFile(sUrl, fieldMap, filesMap, cookieVal);
        //获取结果 String 类型字符串转化为UniResult结果集
        StringToBean stringToBean=new StringToBean();
        UniResult uniResult= stringToBean.stringToUniResult(result);
        return  uniResult;
    }

    /**
     * 新增
     *
     * @return "ErrMsg":"success"
     */
    public UniResult updatapersonInfo(PersonRecord personRecord) throws Exception {
        //获取地址
        ServerAddress serverAddress = new ServerAddress();
        String sAdd = serverAddress.getServerAddress();
        String sUrl = sAdd + "/person/";
        //字段集
        Map<String, String> fieldMap = new HashMap<String, String>();
        //表单字段映射
        fieldMap.put("Name", personRecord.getName());
        fieldMap.put("Code", personRecord.getCode());
        fieldMap.put("Depart", personRecord.getDepart());
        fieldMap.put("Seqid", personRecord.getSeqid().toString());
        fieldMap.put("RoleIds", personRecord.getRoleIds().toString());
        List<String> imageListArr = personRecord.getImageList();
        fieldMap.put("ImageList", imageListArr.toString());
        //文件集
        Map<String, String> filesMap = new HashMap<String, String>();
        //要上传的文件 文件的地址映射 这里上传的是图片 只限6张
        List<String> filepath = personRecord.getFilepath();
        Iterator iterator = filepath.iterator();
        while (iterator.hasNext()) {
            filesMap.put("file", (String) iterator.next());
        }
        //引入cookie
        CookieUtils cookieUtils = new CookieUtils();
        String cookieVal = cookieUtils.getCookie();
        //调用模拟form 上传的方法
        UploadFormFilePut uploadFormFile = new UploadFormFilePut();
        String result = uploadFormFile.uploadFormFile(sUrl, fieldMap, filesMap, cookieVal);
        //获取结果 String 类型字符串转化为UniResult结果集
        StringToBean stringToBean=new StringToBean();
        UniResult uniResult= stringToBean.stringToUniResult(result);
        return  uniResult;
    }

    /**
     * 分页查询信息 +模糊查询
     *
     * @return 人员基本信息
     */
    public UniResult  QueryPersonInfo(QueryPeopleInfoBean queryPeopleInfoBean) throws Exception {
        //获取地址
        ServerAddress serverAddress = new ServerAddress();
        String sAdd = serverAddress.getServerAddress();
        Map<String, String> map = new HashMap<String, String>();
        map.put("departCode", queryPeopleInfoBean.getDepartCode());
        map.put("pageSize", queryPeopleInfoBean.getPageSize());
        map.put("pageNum", queryPeopleInfoBean.getPageNumber());
        map.put("keyWord", queryPeopleInfoBean.getKeyWord());
        map.put("featureNum", queryPeopleInfoBean.getFeatureNum());
        // 将Map转换为JSONArray数据  查询条件
        String json = JSON.toJSONString(map);
       String sUrl = sAdd + "/persons" + "?conditionParam=" + json;

        //重新打开一个连接
        URL url = new URL(sUrl);

        HttpURLConnection resumeConnection = (HttpURLConnection)url.openConnection();
        //引入cookie
        CookieUtils cookieUtils = new CookieUtils();
        String cookieVal = cookieUtils.getCookie();
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlStream));
        String ss = null;
        String total = "";
        while ((ss = bufferedReader.readLine()) != null) {
            total += ss;
        }
        bufferedReader.close();
        //获取结果 String 类型字符串转化为UniResult结果集
        StringToBean stringToBean=new StringToBean();
        UniResult uniResult= stringToBean.stringToUniResult(total);
        return  uniResult;
    }
}
