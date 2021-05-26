package com.ruoyi.dbbase.scheduled;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.dbbase.domain.BdStudentGread;
import com.ruoyi.dbbase.domain.BdXgxtXgxtBjfdyxxQywx;
import com.ruoyi.dbbase.service.IBdStudentGreadService;
import com.ruoyi.dbbase.service.impl.BdXgxtXgxtBjfdyxxQywxServiceImpl;
import com.ruoyi.offline.service.impl.XgxtXgxtBjfdyxxQywxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 辅导员信息同步 新增电话号码  相关任务定时器类
 * <p>
 *   查询出辅导员列表，包含学工系统的电话号码
 *   SELECT b.lxdh,a.* FROM xgxt_xgxt_bjfdyxx_qywx as a LEFT JOIN ztsj_ryjbxx_qywx b on a.FDYJZGH = b.XGH where a.FDYJZGH in(SELECT xgh FROM ztsj_ryjbxx_qywx)
 */
@Component("teachInfoTask")
public class TeachInfoTask {

    //班级辅导员
    @Autowired
    XgxtXgxtBjfdyxxQywxServiceImpl xgxtXgxtBjfdyxxQywxServiceImpl;
    //班级辅导员
    @Autowired
    BdXgxtXgxtBjfdyxxQywxServiceImpl bdXgxtXgxtBjfdyxxQywxServiceImpl;

    /**
     * 同步老师信息
     */
    public void synchTeachInfoTask() {
        System.out.println("启动辅导员信息同步，并且将门禁中的电话信息也加入表中====> ");
        getTeachInfo();
    }

    /**
     * 将在辅导员信息表同步过来
     */
    private void getTeachInfo() {
        HashMap<String, Object> searchMap = new HashMap<>();
        List<Map<String, Object>> mList = xgxtXgxtBjfdyxxQywxServiceImpl.getMapList(searchMap);
        if (null == mList) {
            return;
        }
        //删除数据
        bdXgxtXgxtBjfdyxxQywxServiceImpl.deleteBdXgxtXgxtBjfdyxxQywxByLocal("0");
        for (Map<String, Object> oneMap : mList) {
            BdXgxtXgxtBjfdyxxQywx baseModel = getBdXgxtXgxtBjfdyxxQywxModel(oneMap);
            addOrUpdateModel(baseModel);
        }
    }

    private BdXgxtXgxtBjfdyxxQywx getBdXgxtXgxtBjfdyxxQywxModel(Map<String, Object> oneMap) {
        BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx = new BdXgxtXgxtBjfdyxxQywx();
        if (!StrKit.isEmpty(oneMap.get("lxdh"))) {
            bdXgxtXgxtBjfdyxxQywx.setLxdh(oneMap.get("lxdh").toString());
        }
        if (!StrKit.isEmpty(oneMap.get("bjxxbh"))) {
            bdXgxtXgxtBjfdyxxQywx.setBjxxbh(oneMap.get("bjxxbh").toString());
        }
        if (!StrKit.isEmpty(oneMap.get("bjdm"))) {
            bdXgxtXgxtBjfdyxxQywx.setBjdm(oneMap.get("bjdm").toString());
        }
        if (!StrKit.isEmpty(oneMap.get("bjmc"))) {
            bdXgxtXgxtBjfdyxxQywx.setBjmc(oneMap.get("bjmc").toString());
        }
        if (!StrKit.isEmpty(oneMap.get("fdy"))) {
            bdXgxtXgxtBjfdyxxQywx.setFdy(oneMap.get("fdy").toString());
        }
        if (!StrKit.isEmpty(oneMap.get("fdyjzgh"))) {
            bdXgxtXgxtBjfdyxxQywx.setFdyjzgh(oneMap.get("fdyjzgh").toString());
        }
        if (!StrKit.isEmpty(oneMap.get("dcDcfieldaud"))) {
            bdXgxtXgxtBjfdyxxQywx.setDcDcfieldaud(oneMap.get("dcDcfieldaud").toString());
        }
        if (!StrKit.isEmpty(oneMap.get("dcDcdatadate"))) {
            bdXgxtXgxtBjfdyxxQywx.setDcDcdatadate(oneMap.get("dcDcdatadate").toString());
        }
        if (!StrKit.isEmpty(oneMap.get("dcDctimestamp"))) {
            bdXgxtXgxtBjfdyxxQywx.setDcDctimestamp(DateUtils.parseDate(oneMap.get("dcDctimestamp").toString()));
        }
        bdXgxtXgxtBjfdyxxQywx = addDqnjAndQwmc(bdXgxtXgxtBjfdyxxQywx);
        return bdXgxtXgxtBjfdyxxQywx;
    }

    //教务在校生信息
    @Autowired
    private IBdStudentGreadService iBdStudentGreadService;

    private BdXgxtXgxtBjfdyxxQywx addDqnjAndQwmc(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx){
        //得到年级和单位名称
        BdStudentGread searchBdStudentGread = new BdStudentGread();
        searchBdStudentGread.setBjdm(bdXgxtXgxtBjfdyxxQywx.getBjdm());
        List<BdStudentGread> mlistBdStudentGread = iBdStudentGreadService.selectBdStudentGreadList(searchBdStudentGread);
        BdStudentGread bdStudentGread = null;
        if(mlistBdStudentGread.size()>0){
            bdStudentGread = mlistBdStudentGread.get(0);
        }
        if(bdStudentGread != null){
            bdXgxtXgxtBjfdyxxQywx.setDqnj(bdStudentGread.getDqnj());
            bdXgxtXgxtBjfdyxxQywx.setDwmc(bdStudentGread.getDwmc());
        }
        return bdXgxtXgxtBjfdyxxQywx;
    }

    /**
     * 添加或者修改
     */
    private void addOrUpdateModel(BdXgxtXgxtBjfdyxxQywx baseModel) {
        baseModel.setCreateTime(new Date());
        bdXgxtXgxtBjfdyxxQywxServiceImpl.insertBdXgxtXgxtBjfdyxxQywx(baseModel);
    }
}
