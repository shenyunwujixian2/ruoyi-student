package com.ruoyi.dbbase.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dbbase.mapper.BdXgxtXgxtXsqjsqxxQywxMapper;
import com.ruoyi.dbbase.domain.BdXgxtXgxtXsqjsqxxQywx;
import com.ruoyi.dbbase.service.IBdXgxtXgxtXsqjsqxxQywxService;

/**
 * 学生请假申请信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
@Service
public class BdXgxtXgxtXsqjsqxxQywxServiceImpl implements IBdXgxtXgxtXsqjsqxxQywxService 
{
    @Autowired
    private BdXgxtXgxtXsqjsqxxQywxMapper bdXgxtXgxtXsqjsqxxQywxMapper;

    /**
     * 查询学生请假申请信息
     * 
     * @param jssj 学生请假申请信息ID
     * @return 学生请假申请信息
     */
    @Override
    public BdXgxtXgxtXsqjsqxxQywx selectBdXgxtXgxtXsqjsqxxQywxById(String jssj)
    {
        return bdXgxtXgxtXsqjsqxxQywxMapper.selectBdXgxtXgxtXsqjsqxxQywxById(jssj);
    }

    /**
     * 查询学生请假申请信息列表
     * 
     * @param bdXgxtXgxtXsqjsqxxQywx 学生请假申请信息
     * @return 学生请假申请信息
     */
    @Override
    public List<BdXgxtXgxtXsqjsqxxQywx> selectBdXgxtXgxtXsqjsqxxQywxList(BdXgxtXgxtXsqjsqxxQywx bdXgxtXgxtXsqjsqxxQywx)
    {
        return bdXgxtXgxtXsqjsqxxQywxMapper.selectBdXgxtXgxtXsqjsqxxQywxList(bdXgxtXgxtXsqjsqxxQywx);
    }

    /**
     * 新增学生请假申请信息
     * 
     * @param bdXgxtXgxtXsqjsqxxQywx 学生请假申请信息
     * @return 结果
     */
    @Override
    public int insertBdXgxtXgxtXsqjsqxxQywx(BdXgxtXgxtXsqjsqxxQywx bdXgxtXgxtXsqjsqxxQywx)
    {
        return bdXgxtXgxtXsqjsqxxQywxMapper.insertBdXgxtXgxtXsqjsqxxQywx(bdXgxtXgxtXsqjsqxxQywx);
    }

    /**
     * 修改学生请假申请信息
     * 
     * @param bdXgxtXgxtXsqjsqxxQywx 学生请假申请信息
     * @return 结果
     */
    @Override
    public int updateBdXgxtXgxtXsqjsqxxQywx(BdXgxtXgxtXsqjsqxxQywx bdXgxtXgxtXsqjsqxxQywx)
    {
        return bdXgxtXgxtXsqjsqxxQywxMapper.updateBdXgxtXgxtXsqjsqxxQywx(bdXgxtXgxtXsqjsqxxQywx);
    }

    /**
     * 批量删除学生请假申请信息
     * 
     * @param jssjs 需要删除的学生请假申请信息ID
     * @return 结果
     */
    @Override
    public int deleteBdXgxtXgxtXsqjsqxxQywxByIds(String[] jssjs)
    {
        return bdXgxtXgxtXsqjsqxxQywxMapper.deleteBdXgxtXgxtXsqjsqxxQywxByIds(jssjs);
    }

    /**
     * 删除学生请假申请信息信息
     * 
     * @param jssj 学生请假申请信息ID
     * @return 结果
     */
    @Override
    public int deleteBdXgxtXgxtXsqjsqxxQywxById(String jssj)
    {
        return bdXgxtXgxtXsqjsqxxQywxMapper.deleteBdXgxtXgxtXsqjsqxxQywxById(jssj);
    }
}
