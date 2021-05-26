package com.ruoyi.dbbase.scheduled;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.dbbase.domain.BdZtsjRyjbxxQywx;
import com.ruoyi.dbbase.service.impl.BdZtsjRyjbxxQywxServiceImpl;
import com.ruoyi.offline.domain.ZtsjRyjbxxQywx;
import com.ruoyi.offline.service.impl.ZtsjRyjbxxQywxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  本地门禁中的用户信息  相关任务定时器类
 *
 *
 */
@Component("zyjobxxTask")
public class ZyjobxxTask {

    //门禁中的学生信息
    @Autowired
    ZtsjRyjbxxQywxServiceImpl ztsjRyjbxxQywxServiceImpl;
    //本地门禁中的学生信息
    @Autowired
    BdZtsjRyjbxxQywxServiceImpl bdZtsjRyjbxxQywxServiceImpl;
    //同步线程数量
    ExecutorService execZxxs = Executors.newFixedThreadPool(20);

    public void synchZyjobxxInfoTask() {
        System.out.println("本地门禁中的用户信息====> ");
        getZxxsInfo();
    }

    /**
     * 将在校学生信息表同步过来
     */
    private void getZxxsInfo() {
        int pageSize = 1000;
        ZtsjRyjbxxQywx ztsjRyjbxxQywx = new ZtsjRyjbxxQywx();
        PageHelper.startPage(1, pageSize, "");
        List<ZtsjRyjbxxQywx> mlist = ztsjRyjbxxQywxServiceImpl.selectZtsjRyjbxxQywxList(ztsjRyjbxxQywx);

        int totalPage = new PageInfo(mlist).getPages();
        //删除数据
        bdZtsjRyjbxxQywxServiceImpl.deleteBdZtsjRyjbxxQywxByLocal("0");
        for (int pageNum =1; pageNum <= totalPage; pageNum++){
            int finalPageNum = pageNum;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "XGH asc");
                    List<ZtsjRyjbxxQywx> mListPage = ztsjRyjbxxQywxServiceImpl.selectZtsjRyjbxxQywxList(ztsjRyjbxxQywx);
                    for (ZtsjRyjbxxQywx baseOne : mListPage) {
                        BdZtsjRyjbxxQywx baseModel = new BdZtsjRyjbxxQywx();
                        BeanUtils.copyProperties(baseOne,baseModel);

                        //通过班级代码 得到老师
                        addOrUpdateModel(baseModel);
                    }
                }
            };
            //将线程放入池中进行执行
            execZxxs.execute(run);
        }
    }

    /**
     * 添加或者修改  本地门禁中的用户信息
     */
    private void addOrUpdateModel(BdZtsjRyjbxxQywx baseModel) {
        baseModel.setCreateTime(new Date());
        bdZtsjRyjbxxQywxServiceImpl.insertBdZtsjRyjbxxQywx(baseModel);
//        BdZtsjRyjbxxQywx searchModel = new BdZtsjRyjbxxQywx();
//        searchModel.setXh(baseModel.getXh());
//        PageHelper.startPage(1, 1, "");
//        List<BdZtsjRyjbxxQywx> mlist = bdZtsjRyjbxxQywxServiceImpl.selectBdZtsjRyjbxxQywxList(searchModel);
//        if (null == mlist || mlist.size() < 1) {
//            baseModel.setCreateTime(new Date());
//            bdZtsjRyjbxxQywxServiceImpl.insertBdZtsjRyjbxxQywx(baseModel);
//            return;
//        }
//        baseModel.setUpdateTime(new Date());
//        bdZtsjRyjbxxQywxServiceImpl.updateBdZtsjRyjbxxQywx(baseModel);
    }

}
