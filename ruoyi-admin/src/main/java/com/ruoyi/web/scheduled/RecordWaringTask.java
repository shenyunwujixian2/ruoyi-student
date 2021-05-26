package com.ruoyi.web.scheduled;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.late.service.impl.UserLateServiceImpl;
import com.ruoyi.record.domain.SysRecordWaring;
import com.ruoyi.record.service.impl.SysRecordWaringServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 将学生迟到的记录刷到 警告信息表中
 *
 * @author xiaoafu  519602726@qq.com   2021-04-04 17:04:32
 */
@Component("recordWaringTask")
public class RecordWaringTask {

    //每天晚归信息
    @Autowired
    UserLateServiceImpl userLateServiceImpl;
    // 晚归信息警告列表
    @Autowired
    SysRecordWaringServiceImpl sysRecordWaringServiceImpl;


    ExecutorService execLate = Executors.newFixedThreadPool(20);

    public void addInfoToWaring() {
        System.out.println("执行处理用户晚归记录");
        getEachInfoList();
    }

    /**
     * 获取处理用户的进出记录
     */
    private void getEachInfoList() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, -23);// 前一天
        Date beforeDay = calendar.getTime();
        String beforeDayStr = DateUtils.parseDateToStr("yyyy-MM-dd", beforeDay);
//        beforeDayStr = "2021-03-28";
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("groupByFieldName", "xh");
        searchMap.put("lateStatusArr", "0,2");
        searchMap.put("teachStatusArr", "0,2");
        //晚归的列表
        int pageSize = 500;
        PageHelper.startPage(1, pageSize, "");
        List<Map<String, Object>> mList = userLateServiceImpl.getWaringList(searchMap);

        int totalPage = new PageInfo(mList).getPages();
        for (int pageNum = 1; pageNum <= totalPage; pageNum++) {
            int finalPageNum = pageNum;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "");
                    List<Map<String, Object>> mListPage = userLateServiceImpl.getWaringList(searchMap);
                    for (Map<String, Object> baseMap : mListPage) {
                        SysRecordWaring oneModel = setSysRecordWaringModel(baseMap);
                        //设置晚归和未归数量
                        oneModel = addLateNumAndNoBackNum(oneModel);

                        addOrupdateSysRecordWaring(oneModel);
                    }
                }
            };
            //将线程放入池中进行执行
            execLate.execute(run);
        }
    }

    private SysRecordWaring addLateNumAndNoBackNum(SysRecordWaring oneModel){
        if (StrKit.isEmpty(oneModel.getXh())){
            return oneModel;
        }

        //根据用户id 获取晚归数量
        HashMap<String,Object> searchMapLate = new HashMap<>();
        searchMapLate.put("xh", oneModel.getXh());
        searchMapLate.put("lateStatus", "2");
        searchMapLate.put("teachStatus", "2");
        Map<String,Object> countByHashMap = userLateServiceImpl.getCountByHashMap(searchMapLate);
        if(null != countByHashMap){
            oneModel.setLateNum(countByHashMap.get("num").toString());
        }
        HashMap<String,Object> searchMapNoBackNum = new HashMap<>();
        searchMapNoBackNum.put("xh", oneModel.getXh());
        searchMapNoBackNum.put("lateStatus", "0");
        searchMapNoBackNum.put("teachStatus", "0");
        Map<String,Object> countNoBackNumMap = userLateServiceImpl.getCountByHashMap(searchMapNoBackNum);
        if(null != countNoBackNumMap){
            oneModel.setNoBackNum(countNoBackNumMap.get("num").toString());
        }
        return oneModel;
    }

    /**
     * 更新内容
     *
     * @param baseModel
     */
    private boolean addOrupdateSysRecordWaring(SysRecordWaring baseModel) {
        if (StrKit.isEmpty(baseModel.getXh())){
           return  false;
        }
        //查询是否存在
        SysRecordWaring searchModel = new SysRecordWaring();
        searchModel.setXh(baseModel.getXh());
        List<SysRecordWaring> mlist = sysRecordWaringServiceImpl.selectSysRecordWaringList(searchModel);

        SysRecordWaring haveModel = null;
        if (mlist.size() > 0) {
            haveModel = mlist.get(0);
        }
        int edNum;
        if (haveModel == null) {
            baseModel.setCreateTime(new Date());
            if(baseModel.getNum()>=3){
                baseModel.setFastTime(new Date());
            }
            edNum = sysRecordWaringServiceImpl.insertSysRecordWaring(baseModel);
        } else {
            baseModel.setId(haveModel.getId());
            baseModel.setUpdateTime(new Date());
            if(baseModel.getNum()>=3 && StrKit.isEmpty(haveModel.getFastTime())){
                baseModel.setFastTime(new Date());
            }
            edNum = sysRecordWaringServiceImpl.updateSysRecordWaring(baseModel);
        }
        return edNum == 0 ? false : true;
    }

    /**
     * 复制来
     *
     * @param baseMap
     * @return
     */
    private SysRecordWaring setSysRecordWaringModel(Map<String, Object> baseMap) {
        SysRecordWaring baseModel = new SysRecordWaring();
        BeanUtils.copyProperties(baseMap, baseModel);
        baseModel.setId(null);
        baseModel.setCreateTime(null);
        baseModel.setUpdateTime(null);
        if(!StrKit.isEmpty(baseMap.get("num"))){
            baseModel.setNum(Long.valueOf(baseMap.get("num").toString()));
//            if(Long.valueOf(baseMap.get("num").toString())>=3){
//                baseModel.setFastTime(new Date());
//            }
        }
        if(!StrKit.isEmpty(baseMap.get("xh"))){
            baseModel.setXh(baseMap.get("xh").toString());
        }
        if(!StrKit.isEmpty(baseMap.get("xm"))){
            baseModel.setXm(baseMap.get("xm").toString());
        }
        if(!StrKit.isEmpty(baseMap.get("teachId"))){
            baseModel.setTeachId(baseMap.get("teachId").toString());
        }
        if(!StrKit.isEmpty(baseMap.get("teachName"))){
            baseModel.setTeachName(baseMap.get("teachName").toString());
        }
        if(!StrKit.isEmpty(baseMap.get("bmmc"))){
            baseModel.setBmmc(baseMap.get("bmmc").toString());
        }
        if(!StrKit.isEmpty(baseMap.get("bmdm"))){
            baseModel.setBmdm(baseMap.get("bmdm").toString());
        }
        if(!StrKit.isEmpty(baseMap.get("lxfs"))){
            baseModel.setLxfs(baseMap.get("lxfs").toString());
        }
        if(!StrKit.isEmpty(baseMap.get("zymc"))){
            baseModel.setZymc(baseMap.get("zymc").toString());
        }
        if(!StrKit.isEmpty(baseMap.get("zydm"))){
            baseModel.setZydm(baseMap.get("zydm").toString());
        }
        if(!StrKit.isEmpty(baseMap.get("bjjc"))){
            baseModel.setBjjc(baseMap.get("bjjc").toString());
        }
        if(!StrKit.isEmpty(baseMap.get("bjdm"))){
            baseModel.setBjdm(baseMap.get("bjdm").toString());
        }
        if(!StrKit.isEmpty(baseMap.get("dwmc"))){
            baseModel.setDwmc(baseMap.get("dwmc").toString());
        }
        if(!StrKit.isEmpty(baseMap.get("dwdm"))){
            baseModel.setDwdm(baseMap.get("dwdm").toString());
        }
        return baseModel;
    }

}
