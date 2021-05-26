package com.ruoyi.offline.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.offline.mapper.ZtsjRyjbxxQywxMapper;
import com.ruoyi.offline.domain.ZtsjRyjbxxQywx;
import com.ruoyi.offline.service.IZtsjRyjbxxQywxService;

/**
 * 门禁中的用户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class ZtsjRyjbxxQywxServiceImpl implements IZtsjRyjbxxQywxService 
{
    @Autowired
    private ZtsjRyjbxxQywxMapper ztsjRyjbxxQywxMapper;

    /**
     * 查询门禁中的用户信息
     * 
     * @param zj 门禁中的用户信息ID
     * @return 门禁中的用户信息
     */
    @Override
    public ZtsjRyjbxxQywx selectZtsjRyjbxxQywxById(String zj)
    {
        return ztsjRyjbxxQywxMapper.selectZtsjRyjbxxQywxById(zj);
    }

    /**
     * 查询门禁中的用户信息列表
     * 
     * @param ztsjRyjbxxQywx 门禁中的用户信息
     * @return 门禁中的用户信息
     */
    @Override
    public List<ZtsjRyjbxxQywx> selectZtsjRyjbxxQywxList(ZtsjRyjbxxQywx ztsjRyjbxxQywx)
    {
        return ztsjRyjbxxQywxMapper.selectZtsjRyjbxxQywxList(ztsjRyjbxxQywx);
    }

    /**
     * 新增门禁中的用户信息
     * 
     * @param ztsjRyjbxxQywx 门禁中的用户信息
     * @return 结果
     */
    @Override
    public int insertZtsjRyjbxxQywx(ZtsjRyjbxxQywx ztsjRyjbxxQywx)
    {
        return ztsjRyjbxxQywxMapper.insertZtsjRyjbxxQywx(ztsjRyjbxxQywx);
    }

    /**
     * 修改门禁中的用户信息
     * 
     * @param ztsjRyjbxxQywx 门禁中的用户信息
     * @return 结果
     */
    @Override
    public int updateZtsjRyjbxxQywx(ZtsjRyjbxxQywx ztsjRyjbxxQywx)
    {
        return ztsjRyjbxxQywxMapper.updateZtsjRyjbxxQywx(ztsjRyjbxxQywx);
    }

    /**
     * 批量删除门禁中的用户信息
     * 
     * @param zjs 需要删除的门禁中的用户信息ID
     * @return 结果
     */
    @Override
    public int deleteZtsjRyjbxxQywxByIds(String[] zjs)
    {
        return ztsjRyjbxxQywxMapper.deleteZtsjRyjbxxQywxByIds(zjs);
    }

    /**
     * 删除门禁中的用户信息信息
     * 
     * @param zj 门禁中的用户信息ID
     * @return 结果
     */
    @Override
    public int deleteZtsjRyjbxxQywxById(String zj)
    {
        return ztsjRyjbxxQywxMapper.deleteZtsjRyjbxxQywxById(zj);
    }
}
