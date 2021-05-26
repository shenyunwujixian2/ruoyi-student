package com.ruoyi.dbbase.scheduled;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.dbbase.domain.BdStudentGread;
import com.ruoyi.dbbase.service.impl.BdStudentGreadServiceImpl;
import com.ruoyi.dbbase.service.impl.BdZtsjZtsjJwzxsxxQywxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学校年级同步  相关任务定时器类
 * <p>
 * 按照分组 查询所有的年级信息
 * SELECT DQNJ,DWMC,DWDM, BJDM,BJJC ,count(*) from ztsj_ztsj_jwzxsxx_qywx GROUP BY DQNJ,DWMC, BJJC
 */
@Component("gradeTask")
public class GradeTask {

    //教务在线学生信息
    @Autowired
    BdZtsjZtsjJwzxsxxQywxServiceImpl bdZtsjZtsjJwzxsxxQywxServiceImpl;
    //年级信息
    @Autowired
    BdStudentGreadServiceImpl bdStudentGreadServiceImpl;

    public void synchGradeInfoTask() {
        System.out.println("启动学校年班同步====> ");
        getGradeInfo();
    }

    /**
     * 将在校学生信息表同步过来
     */
    private void getGradeInfo() {
        HashMap<String, Object> searchMap = new HashMap<>();
        List<Map<String, Object>> mList = bdZtsjZtsjJwzxsxxQywxServiceImpl.getMapList(searchMap);
        if (null == mList) {
            return;
        }
        for (Map<String, Object> oneMap : mList) {
            BdStudentGread baseModel = getBdStudentGreadModel(oneMap);
            addOrUpdateEachDayModel(baseModel);
        }
    }

    private BdStudentGread getBdStudentGreadModel(Map<String, Object> oneMap) {
        BdStudentGread bdStudentGread = new BdStudentGread();
        if (!StrKit.isEmpty(oneMap.get("dqnj"))) {
            bdStudentGread.setDqnj(oneMap.get("dqnj").toString());
        }
        if (!StrKit.isEmpty(oneMap.get("dwmc"))) {
            bdStudentGread.setDwmc(oneMap.get("dwmc").toString());
        }
        if (!StrKit.isEmpty(oneMap.get("dwdm"))) {
            bdStudentGread.setDwdm(oneMap.get("dwdm").toString());
        }
        if (!StrKit.isEmpty(oneMap.get("bjdm"))) {
            bdStudentGread.setBjdm(oneMap.get("bjdm").toString());
        }
        if (!StrKit.isEmpty(oneMap.get("bjjc"))) {
            bdStudentGread.setBjjc(oneMap.get("bjjc").toString());
        }
        if (!StrKit.isEmpty(oneMap.get("zydm"))) {
            bdStudentGread.setZydm(oneMap.get("zydm").toString());
        }
        if (!StrKit.isEmpty(oneMap.get("zymc"))) {
            bdStudentGread.setZymc(oneMap.get("zymc").toString());
        }
        if (!StrKit.isEmpty(oneMap.get("studentNum"))) {
            bdStudentGread.setStudentNum(Long.valueOf(oneMap.get("studentNum").toString()));
        }

        return bdStudentGread;
    }

    /**
     * 添加或者修改
     */
    private void addOrUpdateEachDayModel(BdStudentGread baseModel) {
        BdStudentGread searchModel = new BdStudentGread();
        searchModel.setDqnj(baseModel.getDqnj());
        searchModel.setDwdm(baseModel.getDwdm());
        searchModel.setBjdm(baseModel.getBjdm());
        PageHelper.startPage(1, 1, "");
        List<BdStudentGread> mlist = bdStudentGreadServiceImpl.selectBdStudentGreadList(searchModel);
        if (null == mlist || mlist.size() < 1) {
            baseModel.setCreateTime(new Date());
            bdStudentGreadServiceImpl.insertBdStudentGread(baseModel);
            return;
        }
        BdStudentGread haveModel = mlist.get(0);
        baseModel.setId(haveModel.getId());
        baseModel.setUpdateTime(new Date());
        bdStudentGreadServiceImpl.updateBdStudentGread(baseModel);
    }
}
