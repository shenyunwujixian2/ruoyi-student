package com.ruoyi.dbbase.scheduled;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.dbbase.domain.BdXgxtXgxtSscwhrzxxQywx;
import com.ruoyi.dbbase.service.impl.BdXgxtXgxtSscwhrzxxQywxServiceImpl;
import com.ruoyi.offline.domain.XgxtXgxtSscwhrzxxQywx;
import com.ruoyi.offline.service.impl.XgxtXgxtSscwhrzxxQywxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 学生床位住宿表  相关任务定时器类
 *
 *
 */
@Component("sscwhrzxxTask")
public class SscwhrzxxTask {

    //门禁中的学生信息
    @Autowired
    XgxtXgxtSscwhrzxxQywxServiceImpl xgxtXgxtSscwhrzxxQywxServiceImpl;
    //本地门禁中的学生信息
    @Autowired
    BdXgxtXgxtSscwhrzxxQywxServiceImpl bdXgxtXgxtSscwhrzxxQywxServiceImpl;
    //同步线程数量
    ExecutorService execZxxs = Executors.newFixedThreadPool(20);

//    @PostConstruct
    public void synchSscwhrzxxInfoTask() {
        System.out.println("学生床位住宿表同步====> ");
        getZxxsInfo();
    }

    /**
     * 将在校学生信息表同步过来
     */
    private void getZxxsInfo() {
        int pageSize = 1000;
        XgxtXgxtSscwhrzxxQywx xgxtXgxtSscwhrzxxQywx = new XgxtXgxtSscwhrzxxQywx();
        PageHelper.startPage(1, pageSize, "");
        List<XgxtXgxtSscwhrzxxQywx> mlist = xgxtXgxtSscwhrzxxQywxServiceImpl.selectXgxtXgxtSscwhrzxxQywxList(xgxtXgxtSscwhrzxxQywx);

        int totalPage = new PageInfo(mlist).getPages();
        //删除数据
        bdXgxtXgxtSscwhrzxxQywxServiceImpl.deleteBdXgxtXgxtSscwhrzxxQywxByLocal("0");
        for (int pageNum =1; pageNum <= totalPage; pageNum++){
            int finalPageNum = pageNum;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "XH asc");
                    List<XgxtXgxtSscwhrzxxQywx> mListPage = xgxtXgxtSscwhrzxxQywxServiceImpl.selectXgxtXgxtSscwhrzxxQywxList(xgxtXgxtSscwhrzxxQywx);
                    for (XgxtXgxtSscwhrzxxQywx baseOne : mListPage) {
                        BdXgxtXgxtSscwhrzxxQywx baseModel = new BdXgxtXgxtSscwhrzxxQywx();
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
    private void addOrUpdateModel(BdXgxtXgxtSscwhrzxxQywx baseModel) {
        baseModel.setCreateTime(new Date());
        bdXgxtXgxtSscwhrzxxQywxServiceImpl.insertBdXgxtXgxtSscwhrzxxQywx(baseModel);
//        BdXgxtXgxtSscwhrzxxQywx searchModel = new BdXgxtXgxtSscwhrzxxQywx();
//        searchModel.setXh(baseModel.getXh());
//        PageHelper.startPage(1, 1, "");
//        List<BdXgxtXgxtSscwhrzxxQywx> mlist = bdXgxtXgxtSscwhrzxxQywxServiceImpl.selectBdXgxtXgxtSscwhrzxxQywxList(searchModel);
//        if (null == mlist || mlist.size() < 1) {
//            baseModel.setCreateTime(new Date());
//            bdXgxtXgxtSscwhrzxxQywxServiceImpl.insertBdXgxtXgxtSscwhrzxxQywx(baseModel);
//            return;
//        }
//        baseModel.setUpdateTime(new Date());
//        bdXgxtXgxtSscwhrzxxQywxServiceImpl.updateBdXgxtXgxtSscwhrzxxQywx(baseModel);
    }

}
