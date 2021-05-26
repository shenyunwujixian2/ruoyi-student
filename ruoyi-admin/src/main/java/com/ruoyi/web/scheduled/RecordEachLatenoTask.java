package com.ruoyi.web.scheduled;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.late.domain.SysRecordEachLateno;
import com.ruoyi.late.domain.UserLate;
import com.ruoyi.late.service.ISysRecordEachLatenoService;
import com.ruoyi.late.service.IUserLateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 将学生迟到的记录刷到晚归记录表中
 *
 * @author xiaoafu  519602726@qq.com   2021-03-31 16:06:46
 */
@Component("recordEachLatenoTask")
public class RecordEachLatenoTask {

    //用户晚归
    @Autowired
    IUserLateService iUserLateService;
    //未处理模型
    @Autowired
    ISysRecordEachLatenoService iSysRecordEachLatenoService;

    ExecutorService execLateno = Executors.newFixedThreadPool(20);

    public void saveLateToLateno() {
        System.out.println("没有处理的信息同步到未处理表====> ");
        getLateList();
    }

    /**
     * 将在校学生信息表同步过来
     */
    private void getLateList() {
        int pageSize = 1000;
        UserLate userLate = new UserLate();
        String showTime = DateUtils.getBeforeDateStr();
        userLate.setShowTime(showTime);
        userLate.setTeachStatus(-1);
        PageHelper.startPage(1, pageSize, "");
        List<UserLate> mlist = iUserLateService.selectUserLateList(userLate);

        int totalPage = new PageInfo(mlist).getPages();
        for (int pageNum =1; pageNum <= totalPage; pageNum++){
            int finalPageNum = pageNum;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "xh asc");
                    List<UserLate> mListPage = iUserLateService.selectUserLateList(userLate);
                    for (UserLate baseOne : mListPage) {
                        SysRecordEachLateno baseModel = new SysRecordEachLateno();
                        BeanUtils.copyProperties(baseOne,baseModel);
                        baseModel.setLateId(baseOne.getId());
                        baseModel.setId(null);
                        //同步请假信息到本地
                        addOrUpdateLatenoModel(baseModel);
                    }
                }
            };
            //将线程放入池中进行执行
            execLateno.execute(run);
        }
    }

    /**
     * 添加或者修改
     */
    private void addOrUpdateLatenoModel(SysRecordEachLateno baseModel) {
        SysRecordEachLateno haveModel = iSysRecordEachLatenoService.selectSysRecordEachLatenoByLateId(baseModel.getLateId());
        if (haveModel == null) {
            baseModel.setCreateTime(new Date());
            iSysRecordEachLatenoService.insertSysRecordEachLateno(baseModel);
        }
    }

}
