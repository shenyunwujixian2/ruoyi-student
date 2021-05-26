package com.ruoyi.dbbase.scheduled;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.dbbase.domain.BdZtsjZtsjJwzxsxxQywx;
import com.ruoyi.dbbase.service.impl.BdZtsjZtsjJwzxsxxQywxServiceImpl;
import com.ruoyi.offline.domain.ZtsjZtsjJwzxsxxQywx;
import com.ruoyi.offline.service.impl.ZtsjZtsjJwzxsxxQywxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 教务在线学生信息同步到本地  相关任务定时器类
 *
 * 用户存在重复的
 * SELECT XH,COUNT("XH") as s from ztsj_ztsj_jwzxsxx_qywx  GROUP BY `XH` ORDER BY s DESC
 */
@Component("jwzxsxxTask")
public class JwzxsxxTask {

    //教务在线学生信息
    @Autowired
    ZtsjZtsjJwzxsxxQywxServiceImpl ztsjZtsjJwzxsxxQywxServiceImpl;

    //教务在线学生信息
    @Autowired
    BdZtsjZtsjJwzxsxxQywxServiceImpl bdZtsjZtsjJwzxsxxQywxServiceImpl;


    //同步线程数量
    ExecutorService execZxxs = Executors.newFixedThreadPool(20);

    public void synchStudentInfoTask() {
        System.out.println("教务在线学生信息同步到本地，并且同步本地的电话====> ");
        getZxxsInfo();
    }

    /**
     * 将在校学生信息表同步过来
     */
    private void getZxxsInfo() {
        int pageSize = 1000;
        ZtsjZtsjJwzxsxxQywx ztsjZtsjJwzxsxxQywx = new ZtsjZtsjJwzxsxxQywx();
        PageHelper.startPage(1, pageSize, "");
        List<ZtsjZtsjJwzxsxxQywx> mlist = ztsjZtsjJwzxsxxQywxServiceImpl.selectZtsjZtsjJwzxsxxQywxList(ztsjZtsjJwzxsxxQywx);

        int totalPage = new PageInfo(mlist).getPages();
        //删除数据
        bdZtsjZtsjJwzxsxxQywxServiceImpl.deleteBdZtsjZtsjJwzxsxxQywxByLocal("0");
        for (int pageNum =1; pageNum <= totalPage; pageNum++){
            int finalPageNum = pageNum;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "xh asc");
                    List<ZtsjZtsjJwzxsxxQywx> mListPage = ztsjZtsjJwzxsxxQywxServiceImpl.selectZtsjZtsjJwzxsxxQywxList(ztsjZtsjJwzxsxxQywx);
                    for (ZtsjZtsjJwzxsxxQywx baseOne : mListPage) {
                        BdZtsjZtsjJwzxsxxQywx baseModel = new BdZtsjZtsjJwzxsxxQywx();
                        BeanUtils.copyProperties(baseOne,baseModel);

                        //通过班级代码 得到老师
                        addOrUpdateEachDayModel(baseModel);
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
    private void addOrUpdateEachDayModel(BdZtsjZtsjJwzxsxxQywx baseModel) {
        baseModel.setCreateTime(new Date());
        bdZtsjZtsjJwzxsxxQywxServiceImpl.insertBdZtsjZtsjJwzxsxxQywx(baseModel);
//        BdZtsjZtsjJwzxsxxQywx searchModel = new BdZtsjZtsjJwzxsxxQywx();
//        searchModel.setXh(baseModel.getXh());
//        PageHelper.startPage(1, 1, "");
//        List<BdZtsjZtsjJwzxsxxQywx> mlist = bdZtsjZtsjJwzxsxxQywxServiceImpl.selectBdZtsjZtsjJwzxsxxQywxList(searchModel);
//        if (null == mlist || mlist.size() < 1) {
//            baseModel.setCreateTime(new Date());
//            bdZtsjZtsjJwzxsxxQywxServiceImpl.insertBdZtsjZtsjJwzxsxxQywx(baseModel);
//            return;
//        }
//        baseModel.setUpdateTime(new Date());
//        bdZtsjZtsjJwzxsxxQywxServiceImpl.updateBdZtsjZtsjJwzxsxxQywx(baseModel);
    }

}
