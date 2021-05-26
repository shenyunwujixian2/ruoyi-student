package com.ruoyi.web.scheduled;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.dbbase.domain.BdBsdtBsdtXsqxjxxQywx;
import com.ruoyi.dbbase.service.impl.BdBsdtBsdtXsqxjxxQywxServiceImpl;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.service.impl.EachDayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用户信息同步接  相关任务定时器类
 * <p>
 * 用户存在重复的
 * SELECT XH,COUNT("XH") as s from ztsj_ztsj_jwzxsxx_qywx  GROUP BY `XH` ORDER BY s DESC
 */
@Component("studentQingJiaTask")
public class StudentQingJiaTask {

    //教务在线学生信息
    @Autowired
    BdBsdtBsdtXsqxjxxQywxServiceImpl bdBsdtBsdtXsqxjxxQywxServiceImpl;

    //学生每日进出记录统计
    @Autowired
    EachDayServiceImpl eachDayServiceImpl;

    //同步线程数量
    ExecutorService execUser = Executors.newFixedThreadPool(20);

    public void getUserQingJiaTask() {
        System.out.println("将用户请假信息刷新到用户进出状态中====> ");
        getUserListInfo();
    }

    /**
     * 获取用户信息接口
     */
    private void getUserListInfo() {
        int pageSize = 1000;

        PageHelper.startPage(1, pageSize, "");
        BdBsdtBsdtXsqxjxxQywx bdBsdtBsdtXsqxjxxQywx = new BdBsdtBsdtXsqxjxxQywx();
        String showTime = DateUtils.getDate();
        bdBsdtBsdtXsqxjxxQywx.setStartshowTime(showTime); //开始时间
        bdBsdtBsdtXsqxjxxQywx.setEndshowTime(showTime); //结束时间
//        bdBsdtBsdtXsqxjxxQywx.setCheckStatus(0);
        List<BdBsdtBsdtXsqxjxxQywx> mlist = bdBsdtBsdtXsqxjxxQywxServiceImpl.selectBdBsdtBsdtXsqxjxxQywxList(bdBsdtBsdtXsqxjxxQywx);

        int totalPage = new PageInfo(mlist).getPages();

        for (int pageNum = 1; pageNum <= totalPage; pageNum++) {
            int finalPageNum = pageNum;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "XH asc");
                    List<BdBsdtBsdtXsqxjxxQywx> mListPage = bdBsdtBsdtXsqxjxxQywxServiceImpl.selectBdBsdtBsdtXsqxjxxQywxList(bdBsdtBsdtXsqxjxxQywx);
                    for (BdBsdtBsdtXsqxjxxQywx baseOne : mListPage) {
                        if(null!= baseOne.getSfls() && baseOne.getSfls().equals("否")){
                            boolean changeStatus = addOrUpdateEachDayModel(baseOne.getXh(),showTime); //根据学号 刷新今天状态
                            if(changeStatus){
                                baseOne.setCheckStatus(1);
                            }else {
                                baseOne.setCheckStatus(2);
                            }
                            baseOne.setCheckTime(new Date());
                            bdBsdtBsdtXsqxjxxQywxServiceImpl.updateBdBsdtBsdtXsqxjxxQywx(baseOne);
                        }
                    }
                }
            };
            //将线程放入池中进行执行
            execUser.execute(run);
        }
    }
    /**
     * 添加或者修改
     */
    private boolean addOrUpdateEachDayModel(String xh, String showTime) {
        if(StrKit.isEmpty(xh)){
            return false;
        }
        boolean changeStatus =false;
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("xh", xh);
        searchMap.put("showTime", showTime);
        EachDayModel haveModel = eachDayServiceImpl.getModelInfo(searchMap);
        if(null != haveModel){
            if(haveModel.getLateStatus().equals("0")){
                haveModel.setLateStatus("4"); //状态设置为4
            }
            changeStatus = eachDayServiceImpl.updateById(haveModel);
        }
        return changeStatus;
    }


}
