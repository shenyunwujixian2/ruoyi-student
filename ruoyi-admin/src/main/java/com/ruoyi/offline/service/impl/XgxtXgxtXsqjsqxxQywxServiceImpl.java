package com.ruoyi.offline.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.offline.mapper.XgxtXgxtXsqjsqxxQywxMapper;
import com.ruoyi.offline.domain.XgxtXgxtXsqjsqxxQywx;
import com.ruoyi.offline.service.IXgxtXgxtXsqjsqxxQywxService;

/**
 * 学生请假申请信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class XgxtXgxtXsqjsqxxQywxServiceImpl implements IXgxtXgxtXsqjsqxxQywxService 
{
    @Autowired
    private XgxtXgxtXsqjsqxxQywxMapper xgxtXgxtXsqjsqxxQywxMapper;

    /**
     * 查询学生请假申请信息
     * 
     * @param jssj 学生请假申请信息ID
     * @return 学生请假申请信息
     */
    @Override
    public XgxtXgxtXsqjsqxxQywx selectXgxtXgxtXsqjsqxxQywxById(String jssj)
    {
        return xgxtXgxtXsqjsqxxQywxMapper.selectXgxtXgxtXsqjsqxxQywxById(jssj);
    }

    /**
     * 查询学生请假申请信息列表
     * 
     * @param xgxtXgxtXsqjsqxxQywx 学生请假申请信息
     * @return 学生请假申请信息
     */
    @Override
    public List<XgxtXgxtXsqjsqxxQywx> selectXgxtXgxtXsqjsqxxQywxList(XgxtXgxtXsqjsqxxQywx xgxtXgxtXsqjsqxxQywx)
    {
        return xgxtXgxtXsqjsqxxQywxMapper.selectXgxtXgxtXsqjsqxxQywxList(xgxtXgxtXsqjsqxxQywx);
    }

    /**
     * 新增学生请假申请信息
     * 
     * @param xgxtXgxtXsqjsqxxQywx 学生请假申请信息
     * @return 结果
     */
    @Override
    public int insertXgxtXgxtXsqjsqxxQywx(XgxtXgxtXsqjsqxxQywx xgxtXgxtXsqjsqxxQywx)
    {
        return xgxtXgxtXsqjsqxxQywxMapper.insertXgxtXgxtXsqjsqxxQywx(xgxtXgxtXsqjsqxxQywx);
    }

    /**
     * 修改学生请假申请信息
     * 
     * @param xgxtXgxtXsqjsqxxQywx 学生请假申请信息
     * @return 结果
     */
    @Override
    public int updateXgxtXgxtXsqjsqxxQywx(XgxtXgxtXsqjsqxxQywx xgxtXgxtXsqjsqxxQywx)
    {
        return xgxtXgxtXsqjsqxxQywxMapper.updateXgxtXgxtXsqjsqxxQywx(xgxtXgxtXsqjsqxxQywx);
    }

    /**
     * 批量删除学生请假申请信息
     * 
     * @param jssjs 需要删除的学生请假申请信息ID
     * @return 结果
     */
    @Override
    public int deleteXgxtXgxtXsqjsqxxQywxByIds(String[] jssjs)
    {
        return xgxtXgxtXsqjsqxxQywxMapper.deleteXgxtXgxtXsqjsqxxQywxByIds(jssjs);
    }

    /**
     * 删除学生请假申请信息信息
     * 
     * @param jssj 学生请假申请信息ID
     * @return 结果
     */
    @Override
    public int deleteXgxtXgxtXsqjsqxxQywxById(String jssj)
    {
        return xgxtXgxtXsqjsqxxQywxMapper.deleteXgxtXgxtXsqjsqxxQywxById(jssj);
    }
}
