package com.ruoyi.dbbase.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dbbase.mapper.BdZtsjRyjbxxQywxMapper;
import com.ruoyi.dbbase.domain.BdZtsjRyjbxxQywx;
import com.ruoyi.dbbase.service.IBdZtsjRyjbxxQywxService;

/**
 * 门禁中的用户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
@Service
public class BdZtsjRyjbxxQywxServiceImpl implements IBdZtsjRyjbxxQywxService 
{
    @Autowired
    private BdZtsjRyjbxxQywxMapper bdZtsjRyjbxxQywxMapper;

    /**
     * 查询门禁中的用户信息
     * 
     * @param zj 门禁中的用户信息ID
     * @return 门禁中的用户信息
     */
    @Override
    public BdZtsjRyjbxxQywx selectBdZtsjRyjbxxQywxById(String zj)
    {
        return bdZtsjRyjbxxQywxMapper.selectBdZtsjRyjbxxQywxById(zj);
    }

    /**
     * 查询门禁中的用户信息列表
     * 
     * @param bdZtsjRyjbxxQywx 门禁中的用户信息
     * @return 门禁中的用户信息
     */
    @Override
    public List<BdZtsjRyjbxxQywx> selectBdZtsjRyjbxxQywxList(BdZtsjRyjbxxQywx bdZtsjRyjbxxQywx)
    {
        return bdZtsjRyjbxxQywxMapper.selectBdZtsjRyjbxxQywxList(bdZtsjRyjbxxQywx);
    }

    /**
     * 新增门禁中的用户信息
     * 
     * @param bdZtsjRyjbxxQywx 门禁中的用户信息
     * @return 结果
     */
    @Override
    public int insertBdZtsjRyjbxxQywx(BdZtsjRyjbxxQywx bdZtsjRyjbxxQywx)
    {
        return bdZtsjRyjbxxQywxMapper.insertBdZtsjRyjbxxQywx(bdZtsjRyjbxxQywx);
    }

    /**
     * 修改门禁中的用户信息
     * 
     * @param bdZtsjRyjbxxQywx 门禁中的用户信息
     * @return 结果
     */
    @Override
    public int updateBdZtsjRyjbxxQywx(BdZtsjRyjbxxQywx bdZtsjRyjbxxQywx)
    {
        return bdZtsjRyjbxxQywxMapper.updateBdZtsjRyjbxxQywx(bdZtsjRyjbxxQywx);
    }

    /**
     * 批量删除门禁中的用户信息
     * 
     * @param zjs 需要删除的门禁中的用户信息ID
     * @return 结果
     */
    @Override
    public int deleteBdZtsjRyjbxxQywxByIds(String[] zjs)
    {
        return bdZtsjRyjbxxQywxMapper.deleteBdZtsjRyjbxxQywxByIds(zjs);
    }

    /**
     * 删除教务在校生信息信息
     *
     * @param xm 教务在校生信息ID
     * @return 结果
     */
    @Override
    public int deleteBdZtsjRyjbxxQywxByLocal(String local)
    {
        return bdZtsjRyjbxxQywxMapper.deleteBdZtsjRyjbxxQywxByLocal(local);
    }

    /**
     * 删除门禁中的用户信息信息
     * 
     * @param zj 门禁中的用户信息ID
     * @return 结果
     */
    @Override
    public int deleteBdZtsjRyjbxxQywxById(String zj)
    {
        return bdZtsjRyjbxxQywxMapper.deleteBdZtsjRyjbxxQywxById(zj);
    }
}
