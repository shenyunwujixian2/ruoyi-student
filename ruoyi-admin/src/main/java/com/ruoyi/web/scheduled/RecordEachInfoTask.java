package com.ruoyi.web.scheduled;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.person.Bean.UniResult;
import com.ruoyi.person.Bean.queryBean.QueryAcessInfoBean;
import com.ruoyi.person.PeosonManger.AcessConn;
import com.ruoyi.person.Utils.loginUtil.FaceGateLogin;
import com.ruoyi.record.domain.RecordEachTmp;
import com.ruoyi.record.service.impl.RecordEachTmpServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 用户打卡记录  相关任务定时器类
 * <p>
 * UPDATE sys_record_each_info SET check_status=0 WHERE pass_time BETWEEN "2021-03-28 00:00:00" and "2021-03-28 23:59:59"
 */
@Component("recordEachInfoTask")
public class RecordEachInfoTask {

    /**
     * {
     * "data":{
     * "page":1,
     * "size":4,
     * "data":[
     * {
     * "RecordId":184,
     * "Inorout":1,
     * "StrInorout":"进",
     * "AreaName":"宇视科技园",
     * "AreaCode":"area",
     * "GuardGroupName":"test",
     * "GuardGroupCode":"28454ae9-1819-40c8-b79d-11c8e91da8d4",
     * "PersonType":0,
     * "StrPersonType":"陌生人",
     * "PersonCode":"-",
     * "PersonName":"-",
     * "PassTime":1521189697782,
     * "DeviceCode":"ipc43",
     * "DeviceName":"ipc43",
     * "PlaceName":null,
     * "PlaceCode":null,
     * "UpdatePersonName":null,
     * "UpdatePersonCode":null,
     * "RecordDate":null,
     * "RecordTime":null,
     * "DepartmentName":null,
     * "DepartmentCode":null,
     * "Num":null,
     * "Temperature":36.8,
     * "PicturePaths":[
     * {
     * "seqid":368,
     * "picturePath":"http://172.20.0.45:9999/2018/03/16/16/184_face_2.jpg",
     * "recordId":null,
     * "passTime":null,
     * "imageIndex":null,
     * "faceId":null,
     * "imageurl":null,
     * "imageType":null,
     * "imageFormat":null,
     * "imagedata":null
     * }
     * ],
     * "PersonPicturePaths":[
     * <p>
     * ],
     * "MatchedFaceId":null,
     * "StrPic1":null,
     * "StrPic2":null
     * }
     * ],
     * "totalcount":38
     * },
     * "ErrCode":200,
     * "ErrMsg":"success"
     * }
     */
//    @Autowired
//    EachInfoServiceImpl eachInfoServiceImpl;
    @Autowired
    RecordEachTmpServiceImpl recordEachTmpServiceImpl;

    //    @Value(value = "${task.time.beforemintues}")
//    private int beforeMintues;
    //多线程
    ExecutorService exec = Executors.newFixedThreadPool(20);
    @Autowired
    RedisCache redisCache;

    //    @Scheduled(cron = "0 0/1 * * * ?")
//    @PostConstruct
    public void getRecordEachInfoTaskTest() {
        Calendar beforeTime = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        beforeTime.add(Calendar.MINUTE, -20);// 20分钟之前的时间
        Date beforeD = beforeTime.getTime();
        String startTime = simpleDateFormat.format(beforeD);
        String endTime = simpleDateFormat.format(new Date());
        System.out.println("startTime====> " + startTime);
        System.out.println("endTime====> " + endTime);
    }

    public static void main(String[] arg) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, -23);// 前一天
        Date beforeDay = calendar.getTime();
        String beforeDayStr = DateUtils.parseDateToStr("yyyy/MM/dd", beforeDay);
        String startTime = beforeDayStr + " 00:00:00";
        String endTime = beforeDayStr + " 23:59:59";
        System.out.println("startTime====> " + startTime);
        System.out.println("endTime====> " + endTime);

        Date passTime = DateUtils.dateTime("yyyy-MM-dd HH:mm:ss", "2021-03-28 11:49:42");
        String passTimeStr = DateUtils.parseDateToStr("yyyy-MM-dd", passTime);
        System.out.println("转后的通过日期===》" + passTimeStr);
    }

    /**
     * 获取今天的全部
     */
    public void getRecordEachInfoAllTask() {
        String startTime = DateUtils.datePath() + " 00:00:00";
        String endTime = DateUtils.datePath() + " 23:59:59";
        getRecordEachInfoTaskCommon(startTime, endTime);
    }

    /**
     * 获取昨天的全部
     */
    public void getRecordEachInfoBeforeAllTask() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, -23);// 昨天之前的时间
        Date beforeDay = calendar.getTime();
        String beforeDayStr = DateUtils.parseDateToStr("yyyy/MM/dd", beforeDay);
        String startTime = beforeDayStr + " 00:00:00";
        String endTime = beforeDayStr + " 23:59:59";
        getRecordEachInfoTaskCommon(startTime, endTime);
    }

    /**
     * 自定义某天的数据
     *
     * @param today
     */
    public void getRecordEachInfoAllTask(String today) {
        String startTime = today + " 00:00:00";
        String endTime = today + " 23:59:59";
        getRecordEachInfoTaskCommon(startTime, endTime);
    }

    /**
     * 每 15分钟请求一次
     */
    public void getRecordEachInfoTask() {
        Calendar beforeTime = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        beforeTime.add(Calendar.MINUTE, -13);// 13分钟之前的时间
        Date beforeD = beforeTime.getTime();
        String startTime = simpleDateFormat.format(beforeD);

        Calendar afterTime = Calendar.getInstance();
        afterTime.add(Calendar.MINUTE, -1);// 2分钟之前的时间
        Date afterD = afterTime.getTime();
        String endTimeStr = simpleDateFormat.format(afterD);
//        String endTimeStr = simpleDateFormat.format(new Date());
        getRecordEachInfoTaskCommon(startTime, endTimeStr);
    }

    /**
     *
     */
    public void getRecordEachInfoTaskCommon(String startTime, String endTime) {
        int page = 1;
        int pageSize = 500;
        int totalPage = 1;

//        Calendar beforeTime = Calendar.getInstance();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        beforeTime.add(Calendar.MINUTE, -20);// 5分钟之前的时间
//        Date beforeD = beforeTime.getTime();
//        String startTime = simpleDateFormat.format(beforeD);
//
//        String endTime = simpleDateFormat.format(new Date());
        System.out.println("startTime====> " + startTime);
        System.out.println("endTime====> " + endTime);
        System.out.println("启动用户打卡同步接口====> ");
        String cookieVal = "";
        try {
            //先登录 获取cookie
            if (redisCache.getCacheObject("COOKIE_GET_USER_ACESS_CONN") == null) {
                FaceGateLogin faceGateLogin = new FaceGateLogin();
                cookieVal = faceGateLogin.faceGateLogin();
                redisCache.setCacheObject("COOKIE_GET_USER_ACESS_CONN", cookieVal, 30, TimeUnit.MINUTES);
            } else {
                cookieVal = redisCache.getCacheObject("COOKIE_GET_USER_ACESS_CONN");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        UniResult uniResult = getEachInfoListInfo(startTime, endTime, 1, pageSize, cookieVal);
        if (uniResult == null || uniResult.getData() == null) {
            System.out.println("请求的结果没有可以出====> ");
            return;
        }
        JSONObject jsonObject = JSONObject.fromObject(uniResult.getData());
        int totalCount = Integer.valueOf(jsonObject.get("totalcount").toString());
        totalPage = (int) Math.ceil((double) totalCount / pageSize);
        System.out.println("总的线程数量==》" + totalPage);
        for (int pageNum = 1; pageNum <= totalPage; pageNum++) {
            int finalPageNum = pageNum;
            String finalCookieVal = cookieVal;
            System.out.println("线程的====》" + finalPageNum);
            Runnable run = new Runnable() {
                public void run() {
                    System.out.println("线程的1111====》" + finalPageNum);
                    UniResult uniResultOne = getEachInfoListInfo(startTime, endTime, finalPageNum, pageSize, finalCookieVal);
                    JSONObject jsonOne = JSONObject.fromObject(uniResultOne.getData());
                    String strArr = jsonOne.get("data").toString();
                    JSONArray jsonArr = JSONArray.parseArray(strArr);
                    for (int i = 0; i < jsonArr.size(); i++) {
                        String strOne = jsonArr.get(i).toString();
                        //解析单条
                        RecordEachTmp baseModel = getEachInfoModel(strOne);
                        //解析数据保存
                        addOrUpdateDisasterWarningModel(baseModel);
                    }

                }
            };
            //将线程放入池中进行执行
            exec.execute(run);
        }
    }

    /**
     * 添加或则修改
     */
    private void addOrUpdateDisasterWarningModel(RecordEachTmp baseModel) {
        try{
            baseModel.setCreateTime(new Date());
            recordEachTmpServiceImpl.insertRecordEachTmp(baseModel);
        }catch (Exception e){

        }

//        HashMap<String, Object> searchMap = new HashMap<>();
//        searchMap.put("recordId", baseModel.getRecordId());
//        EachInfoModel haveModel = eachInfoServiceImpl.getModelInfo(searchMap);
//
//        if (haveModel == null) {
//            baseModel.setCreateTime(new Date());
//            eachInfoServiceImpl.add(baseModel);
//        }
//        else {
//            baseModel.setId(haveModel.getId());
//            baseModel.setUpdateTime(new Date());
//            eachInfoServiceImpl.updateById(baseModel);
//        }
    }

    /**
     * "RecordId":184,
     * "Inorout":1,
     * "StrInorout":"进",
     * "AreaName":"宇视科技园",
     * "AreaCode":"area",
     * "GuardGroupName":"test",
     * "GuardGroupCode":"28454ae9-1819-40c8-b79d-11c8e91da8d4",
     * "PersonType":0,
     * "StrPersonType":"陌生人",
     * "PersonCode":"-",
     * "PersonName":"-",
     * "PassTime":1521189697782,
     * "DeviceCode":"ipc43",
     * "DeviceName":"ipc43",
     * "PlaceName":null,
     * "PlaceCode":null,
     * "UpdatePersonName":null,
     * "UpdatePersonCode":null,
     * "RecordDate":null,
     * "RecordTime":null,
     * "DepartmentName":null,
     * "DepartmentCode":null,
     * "Num":null,
     * "Temperature":36.8,
     * "PicturePaths":[
     * {
     * "seqid":368,
     * "picturePath":"http://172.20.0.45:9999/2018/03/16/16/184_face_2.jpg",
     * "recordId":null,
     * "passTime":null,
     * "imageIndex":null,
     * "faceId":null,
     * "imageurl":null,
     * "imageType":null,
     * "imageFormat":null,
     * "imagedata":null
     * }
     * ],
     * "PersonPicturePaths":[
     * <p>
     * ],
     * "MatchedFaceId":null,
     * "StrPic1":null,
     * "StrPic2":null
     * }
     * 生成单条数据
     *
     * @param str
     * @return
     */
    private RecordEachTmp getEachInfoModel(String str) {
        JSONObject jsonObject = JSONObject.fromObject(str);
        RecordEachTmp baseModel = new RecordEachTmp();
//        baseModel.setInfo(str);  //为了数据库的大小 不正式就不保存该字段
        if (!StrKit.isEmpty(jsonObject.get("RecordId"))) {
            baseModel.setRecordId(jsonObject.get("RecordId").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("Inorout"))) {
            baseModel.setInorout(jsonObject.get("Inorout").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("StrInorout"))) {
            baseModel.setStrInorout(jsonObject.get("StrInorout").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("AreaName"))) {
            baseModel.setAreaName(jsonObject.get("AreaName").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("AreaCode"))) {
            baseModel.setAreaCode(jsonObject.get("AreaCode").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("GuardGroupName"))) {
            baseModel.setGuardGroupName(jsonObject.get("GuardGroupName").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("GuardGroupCode"))) {
            baseModel.setGuardGroupCode(jsonObject.get("GuardGroupCode").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("PersonType"))) {
            baseModel.setPersonType(jsonObject.get("PersonType").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("StrPersonType"))) {
            baseModel.setStrPersonType(jsonObject.get("StrPersonType").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("PersonCode"))) {
            baseModel.setPersonCode(jsonObject.get("PersonCode").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("PersonName"))) {
            baseModel.setPersonName(jsonObject.get("PersonName").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("DepartmentCode"))) {
            baseModel.setDepartmentCode(jsonObject.get("DepartmentCode").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("DepartmentName"))) {
            baseModel.setDepartmentName(jsonObject.get("DepartmentName").toString());
        }
        if (!StrKit.isEmpty(jsonObject.get("PassTime"))) {
            baseModel.setPassTimeStr(jsonObject.get("PassTime").toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sd = sdf.format(Long.valueOf(jsonObject.get("PassTime").toString()));
            baseModel.setPassTime(sd);
        }
        return baseModel;
    }

    @Autowired
    AcessConn acessConn;

    /**
     * 获取用户信息接口
     */
    private UniResult getEachInfoListInfo(String startTime, String endTime, int page, int pageSize, String cookieVal) {
//        AcessConn acessConn = new AcessConn();//出入记录相关接口
        UniResult uniResult = new UniResult();//返回实体类的接受对象
//        String strOne = "{\"data\":{\"page\":1,\"size\":4,\"data\":[{\"RecordId\":184,\"Inorout\":1,\"StrInorout\":\"出\",\"AreaName\":\"宇视科技园\",\"AreaCode\":\"area\",\"GuardGroupName\":\"test\",\"GuardGroupCode\":\"28454ae9-1819-40c8-b79d-11c8e91da8d4\",\"PersonType\":0,\"StrPersonType\":\"陌生人\",\"PersonCode\":\"-\",\"PersonName\":\"-\",\"PassTime\":1521189697782,\"DeviceCode\":\"ipc43\",\"DeviceName\":\"ipc43\",\"PlaceName\":null,\"PlaceCode\":null,\"UpdatePersonName\":null,\"UpdatePersonCode\":null,\"RecordDate\":null,\"RecordTime\":null,\"DepartmentName\":null,\"DepartmentCode\":null,\"Num\":null,\"Temperature\":36.8,\"PicturePaths\":[{\"seqid\":368,\"picturePath\":\"http://172.20.0.45:9999/2018/03/16/16/184_face_2.jpg\",\"recordId\":null,\"passTime\":null,\"imageIndex\":null,\"faceId\":null,\"imageurl\":null,\"imageType\":null,\"imageFormat\":null,\"imagedata\":null}],\"PersonPicturePaths\":[],\"MatchedFaceId\":null,\"StrPic1\":null,\"StrPic2\":null},{\"RecordId\":185,\"Inorout\":1,\"StrInorout\":\"进\",\"AreaName\":\"宇视科技园\",\"AreaCode\":\"area\",\"GuardGroupName\":\"test\",\"GuardGroupCode\":\"28454ae9-1819-40c8-b79d-11c8e91da8d4\",\"PersonType\":0,\"StrPersonType\":\"陌生人\",\"PersonCode\":\"-\",\"PersonName\":\"-\",\"PassTime\":1521189697782,\"DeviceCode\":\"ipc43\",\"DeviceName\":\"ipc43\",\"PlaceName\":null,\"PlaceCode\":null,\"UpdatePersonName\":null,\"UpdatePersonCode\":null,\"RecordDate\":null,\"RecordTime\":null,\"DepartmentName\":null,\"DepartmentCode\":null,\"Num\":null,\"Temperature\":36.8,\"PicturePaths\":[{\"seqid\":368,\"picturePath\":\"http://172.20.0.45:9999/2018/03/16/16/184_face_2.jpg\",\"recordId\":null,\"passTime\":null,\"imageIndex\":null,\"faceId\":null,\"imageurl\":null,\"imageType\":null,\"imageFormat\":null,\"imagedata\":null}],\"PersonPicturePaths\":[],\"MatchedFaceId\":null,\"StrPic1\":null,\"StrPic2\":null},{\"RecordId\":186,\"Inorout\":1,\"StrInorout\":\"进\",\"AreaName\":\"宇视科技园\",\"AreaCode\":\"area\",\"GuardGroupName\":\"test\",\"GuardGroupCode\":\"28454ae9-1819-40c8-b79d-11c8e91da8d4\",\"PersonType\":0,\"StrPersonType\":\"陌生人\",\"PersonCode\":\"-\",\"PersonName\":\"-\",\"PassTime\":1521189697782,\"DeviceCode\":\"ipc43\",\"DeviceName\":\"ipc43\",\"PlaceName\":null,\"PlaceCode\":null,\"UpdatePersonName\":null,\"UpdatePersonCode\":null,\"RecordDate\":null,\"RecordTime\":null,\"DepartmentName\":null,\"DepartmentCode\":null,\"Num\":null,\"Temperature\":36.8,\"PicturePaths\":[{\"seqid\":368,\"picturePath\":\"http://172.20.0.45:9999/2018/03/16/16/184_face_2.jpg\",\"recordId\":null,\"passTime\":null,\"imageIndex\":null,\"faceId\":null,\"imageurl\":null,\"imageType\":null,\"imageFormat\":null,\"imagedata\":null}],\"PersonPicturePaths\":[],\"MatchedFaceId\":null,\"StrPic1\":null,\"StrPic2\":null}],\"totalcount\":38},\"ErrCode\":200,\"ErrMsg\":\"success\"}";
        //获取结果 String 类型字符串转化为UniResult结果集
//        String strOne = "{\"ErrCode\":1010,\"ErrMsg\":\"lose load status\"}";
//        StringToBean stringToBean = new StringToBean();
//        uniResult = stringToBean.stringToUniResult(strOne);
        /**
         * 登录
         * 先读取server.properties 获取服务器地址
         * 将获取的cookie 存到配置文件里
         * 调用其他接口时 将cookie 注入
         */
        try {
            /**
             * 查询出入记录 例子
             */
            QueryAcessInfoBean queryAcessInfoBean = new QueryAcessInfoBean();
            queryAcessInfoBean.setStartTime(startTime);
            queryAcessInfoBean.setEndTime(endTime);
            queryAcessInfoBean.setPage(page + "");
            queryAcessInfoBean.setSize(pageSize + "");
            queryAcessInfoBean.setPersonType("3");
            //获取结果 String 类型字符串
            uniResult = acessConn.QueryAcessInfo(queryAcessInfoBean, cookieVal);

            System.out.println(uniResult.getErrCode());
            System.out.println(uniResult.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uniResult;
    }

}
