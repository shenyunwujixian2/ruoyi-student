package com.ruoyi.web.scheduled;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.late.service.impl.UserLateServiceImpl;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.domain.SysRecordWaring;
import com.ruoyi.record.service.impl.EachDayServiceImpl;
import com.ruoyi.record.service.impl.SysRecordWaringServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 将没有进出记录的人 最后一次进出记录去取上一次的进出记录
 *
 * @author xiaoafu  519602726@qq.com   2021-04-19 10:01:00
 */
@Component("refreshDayNoLastInTask")
public class RefreshDayNoLastInTask {

    //每天的信息
    @Resource
    EachDayServiceImpl eachDayServiceImpl;

    ExecutorService execDay = Executors.newFixedThreadPool(20);

    public void updateUserLastInOrOut() {
        System.out.println("将没有进出记录的人，最后一次进出记录刷新进去");
        getUserLastInOrOutIsNullList();
    }

    /**
     * 获取今天 还有进出记录的用户列表
     */
    private void getUserLastInOrOutIsNullList() {
        String showTime = DateUtils.getDate();
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("showTime", showTime);
        searchMap.put("searchPassIsNull", "1");
        // 获取今天还没有到数据的列表
        int pageSize = 500;
        PageHelper.startPage(1, pageSize, "");
        List<EachDayModel> mList = eachDayServiceImpl.getList(searchMap);

        int totalPage = new PageInfo(mList).getPages();
        for (int pageNum = 1; pageNum <= totalPage; pageNum++) {
            int finalPageNum = pageNum;
            Runnable run = new Runnable() {
                public void run() {
                    PageHelper.startPage(finalPageNum, pageSize, "");
                    List<EachDayModel> mListPage = eachDayServiceImpl.getList(searchMap);
                    for (EachDayModel baseOne : mListPage) {
                        EachDayModel baseModel = setEachDayModel(baseOne);
                        if(null != baseModel){
                            eachDayServiceImpl.edit(baseModel);
                        }
                    }
                }
            };
            //将线程放入池中进行执行
            execDay.execute(run);
        }
    }

    /**
     * 将最后一次进出状态 刷新到模型中
     * @param baseOne
     * @return
     */
    private EachDayModel setEachDayModel(EachDayModel baseOne){
        EachDayModel baseModel = new EachDayModel();
        BeanUtils.copyProperties(baseOne, baseModel);
        if(baseModel.getLastInorout() != null){
            return null;
        }
        //根据用户id 查询用户上一次 进出状态
        String xh = baseModel.getXh();
        if(StrKit.isEmpty(xh)){
            return  null;
        }
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("searchPassIsNotNull", "lastInoroutIsNotNull");
        searchMap.put("xh", xh);
        EachDayModel haveModel = eachDayServiceImpl.getModelInfo(searchMap);
        if(null ==haveModel){
            return null;
        }
        baseModel.setLastInorout(haveModel.getLastInorout());
        baseModel.setLastInoroutTime(haveModel.getLastInoroutTime());
        if(haveModel.getLastInorout().equals("1")){
            baseModel.setLastStrInorout(haveModel.getLastStrInorout());
        }

        return  baseModel;
    }

}
