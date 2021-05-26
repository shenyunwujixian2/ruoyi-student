package com.ruoyi.dbbase.scheduled;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.dbbase.domain.BdBsdtBsdtXsqxjxxQywx;
import com.ruoyi.dbbase.service.impl.BdBsdtBsdtXsqxjxxQywxServiceImpl;
import com.ruoyi.offline.domain.BsdtBsdtXsqxjxxQywx;
import com.ruoyi.offline.service.impl.BsdtBsdtXsqxjxxQywxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  学生请假信息 同步到本地  相关任务定时器类
 *
 * 用户存在重复的
 * SELECT XH,COUNT("XH") as s from ztsj_ztsj_jwzxsxx_qywx  GROUP BY `XH` ORDER BY s DESC
 */
@Component("xsqxjxxTask")
public class XsqxjxxTask {

    //本地学生请假信息
    @Autowired
    BsdtBsdtXsqxjxxQywxServiceImpl bsdtBsdtXsqxjxxQywxServiceImpl;

    //网上学生请假信息
    @Autowired
    BdBsdtBsdtXsqxjxxQywxServiceImpl bdBsdtBsdtXsqxjxxQywxServiceImpl;


    //同步线程数量
    ExecutorService execZxxs = Executors.newFixedThreadPool(20);

    public void synchStudentQjTask() {
        System.out.println("学生请假信息同步到本地====> ");
        getZxxsInfo();
    }

    /**
     * 将在校学生信息表同步过来
     */
    private void getZxxsInfo() {
        int pageSize = 1000;
        BsdtBsdtXsqxjxxQywx bsdtBsdtXsqxjxxQywx = new BsdtBsdtXsqxjxxQywx();
        String showTime = DateUtils.getDate();
//        bsdtBsdtXsqxjxxQywx.setStartshowTime(DateUtils.getBeforeDateStr()); //开始时间
//        bsdtBsdtXsqxjxxQywx.setEndshowTime(DateUtils.getDate()); //结束时间

        PageHelper.startPage(1, pageSize, "");
        List<BsdtBsdtXsqxjxxQywx> mlist = bsdtBsdtXsqxjxxQywxServiceImpl.selectBsdtBsdtXsqxjxxQywxList(bsdtBsdtXsqxjxxQywx);

        int totalPage = new PageInfo(mlist).getPages();
        for (int pageNum =1; pageNum <= totalPage; pageNum++){
            int finalPageNum = pageNum;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "XH asc");
                    List<BsdtBsdtXsqxjxxQywx> mListPage = bsdtBsdtXsqxjxxQywxServiceImpl.selectBsdtBsdtXsqxjxxQywxList(bsdtBsdtXsqxjxxQywx);
                    for (BsdtBsdtXsqxjxxQywx baseOne : mListPage) {
                        BdBsdtBsdtXsqxjxxQywx baseModel = new BdBsdtBsdtXsqxjxxQywx();
                        BeanUtils.copyProperties(baseOne,baseModel);
                        //同步请假信息到本地
                        addOrUpdateXsqxjxxModel(baseModel);
                    }
                }
            };
            //将线程放入池中进行执行
            execZxxs.execute(run);
        }
    }

    /**
     * 添加或者修改
     */
    private void addOrUpdateXsqxjxxModel(BdBsdtBsdtXsqxjxxQywx baseModel) {
        BdBsdtBsdtXsqxjxxQywx haveModel = bdBsdtBsdtXsqxjxxQywxServiceImpl.selectBdBsdtBsdtXsqxjxxQywxById(baseModel.getXsqxjxxbh());
        if (haveModel == null) {
            baseModel.setCreateTime(new Date());
            bdBsdtBsdtXsqxjxxQywxServiceImpl.insertBdBsdtBsdtXsqxjxxQywx(baseModel);
        }
    }

}
