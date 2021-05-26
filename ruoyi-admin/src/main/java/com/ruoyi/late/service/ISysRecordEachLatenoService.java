package com.ruoyi.late.service;

import java.util.List;
import com.ruoyi.late.domain.SysRecordEachLateno;

/**
 * 10点未处理数据Service接口
 * 
 * @author xiaoafu
 * @date 2021-04-29
 */
public interface ISysRecordEachLatenoService 
{
    /**
     * 查询10点未处理数据
     * 
     * @param id 10点未处理数据ID
     * @return 10点未处理数据
     */
    public SysRecordEachLateno selectSysRecordEachLatenoById(Long id);
    /**
     * 查询10点未处理数据
     *
     * @param id 10点未处理数据ID
     * @return 10点未处理数据
     */
    public SysRecordEachLateno selectSysRecordEachLatenoByLateId(Long lateId);

    /**
     * 查询10点未处理数据列表
     * 
     * @param sysRecordEachLateno 10点未处理数据
     * @return 10点未处理数据集合
     */
    public List<SysRecordEachLateno> selectSysRecordEachLatenoList(SysRecordEachLateno sysRecordEachLateno);

    /**
     * 新增10点未处理数据
     * 
     * @param sysRecordEachLateno 10点未处理数据
     * @return 结果
     */
    public int insertSysRecordEachLateno(SysRecordEachLateno sysRecordEachLateno);

    /**
     * 修改10点未处理数据
     * 
     * @param sysRecordEachLateno 10点未处理数据
     * @return 结果
     */
    public int updateSysRecordEachLateno(SysRecordEachLateno sysRecordEachLateno);

    /**
     * 批量删除10点未处理数据
     * 
     * @param ids 需要删除的10点未处理数据ID
     * @return 结果
     */
    public int deleteSysRecordEachLatenoByIds(Long[] ids);

    /**
     * 删除10点未处理数据信息
     * 
     * @param id 10点未处理数据ID
     * @return 结果
     */
    public int deleteSysRecordEachLatenoById(Long id);
}
