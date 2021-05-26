package com.ruoyi.late.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.late.mapper.SysRecordEachLatenoMapper;
import com.ruoyi.late.domain.SysRecordEachLateno;
import com.ruoyi.late.service.ISysRecordEachLatenoService;

/**
 * 10点未处理数据Service业务层处理
 * 
 * @author xiaoafu
 * @date 2021-04-29
 */
@Service
public class SysRecordEachLatenoServiceImpl implements ISysRecordEachLatenoService 
{
    @Autowired
    private SysRecordEachLatenoMapper sysRecordEachLatenoMapper;

    /**
     * 查询10点未处理数据
     * 
     * @param id 10点未处理数据ID
     * @return 10点未处理数据
     */
    @Override
    public SysRecordEachLateno selectSysRecordEachLatenoById(Long id)
    {
        return sysRecordEachLatenoMapper.selectSysRecordEachLatenoById(id);
    }
    /**
     * 查询10点未处理数据
     *
     * @param id 10点未处理数据ID
     * @return 10点未处理数据
     */
    @Override
    public SysRecordEachLateno selectSysRecordEachLatenoByLateId(Long lateId)
    {
        return sysRecordEachLatenoMapper.selectSysRecordEachLatenoByLateId(lateId);
    }

    /**
     * 查询10点未处理数据列表
     * 
     * @param sysRecordEachLateno 10点未处理数据
     * @return 10点未处理数据
     */
    @Override
    public List<SysRecordEachLateno> selectSysRecordEachLatenoList(SysRecordEachLateno sysRecordEachLateno)
    {
        return sysRecordEachLatenoMapper.selectSysRecordEachLatenoList(sysRecordEachLateno);
    }

    /**
     * 新增10点未处理数据
     * 
     * @param sysRecordEachLateno 10点未处理数据
     * @return 结果
     */
    @Override
    public int insertSysRecordEachLateno(SysRecordEachLateno sysRecordEachLateno)
    {
        sysRecordEachLateno.setCreateTime(DateUtils.getNowDate());
        return sysRecordEachLatenoMapper.insertSysRecordEachLateno(sysRecordEachLateno);
    }

    /**
     * 修改10点未处理数据
     * 
     * @param sysRecordEachLateno 10点未处理数据
     * @return 结果
     */
    @Override
    public int updateSysRecordEachLateno(SysRecordEachLateno sysRecordEachLateno)
    {
        sysRecordEachLateno.setUpdateTime(DateUtils.getNowDate());
        return sysRecordEachLatenoMapper.updateSysRecordEachLateno(sysRecordEachLateno);
    }

    /**
     * 批量删除10点未处理数据
     * 
     * @param ids 需要删除的10点未处理数据ID
     * @return 结果
     */
    @Override
    public int deleteSysRecordEachLatenoByIds(Long[] ids)
    {
        return sysRecordEachLatenoMapper.deleteSysRecordEachLatenoByIds(ids);
    }

    /**
     * 删除10点未处理数据信息
     * 
     * @param id 10点未处理数据ID
     * @return 结果
     */
    @Override
    public int deleteSysRecordEachLatenoById(Long id)
    {
        return sysRecordEachLatenoMapper.deleteSysRecordEachLatenoById(id);
    }
}
