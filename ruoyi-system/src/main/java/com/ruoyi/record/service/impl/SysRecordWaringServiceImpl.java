package com.ruoyi.record.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.record.mapper.SysRecordWaringMapper;
import com.ruoyi.record.domain.SysRecordWaring;
import com.ruoyi.record.service.ISysRecordWaringService;

/**
 * 学生晚归次数告警信息Service业务层处理
 * 
 * @author xiaoafu
 * @date 2021-04-04
 */
@Service
public class SysRecordWaringServiceImpl implements ISysRecordWaringService 
{
    @Autowired
    private SysRecordWaringMapper sysRecordWaringMapper;

    /**
     * 查询学生晚归次数告警信息
     * 
     * @param id 学生晚归次数告警信息ID
     * @return 学生晚归次数告警信息
     */
    @Override
    public SysRecordWaring selectSysRecordWaringById(Long id)
    {
        return sysRecordWaringMapper.selectSysRecordWaringById(id);
    }

    /**
     * 查询学生晚归次数告警信息列表
     * 
     * @param sysRecordWaring 学生晚归次数告警信息
     * @return 学生晚归次数告警信息
     */
    @Override
    public List<SysRecordWaring> selectSysRecordWaringList(SysRecordWaring sysRecordWaring)
    {
        return sysRecordWaringMapper.selectSysRecordWaringList(sysRecordWaring);
    }

    /**
     * 新增学生晚归次数告警信息
     * 
     * @param sysRecordWaring 学生晚归次数告警信息
     * @return 结果
     */
    @Override
    public int insertSysRecordWaring(SysRecordWaring sysRecordWaring)
    {
        sysRecordWaring.setCreateTime(DateUtils.getNowDate());
        return sysRecordWaringMapper.insertSysRecordWaring(sysRecordWaring);
    }

    /**
     * 修改学生晚归次数告警信息
     * 
     * @param sysRecordWaring 学生晚归次数告警信息
     * @return 结果
     */
    @Override
    public int updateSysRecordWaring(SysRecordWaring sysRecordWaring)
    {
        sysRecordWaring.setUpdateTime(DateUtils.getNowDate());
        return sysRecordWaringMapper.updateSysRecordWaring(sysRecordWaring);
    }

    /**
     * 批量删除学生晚归次数告警信息
     * 
     * @param ids 需要删除的学生晚归次数告警信息ID
     * @return 结果
     */
    @Override
    public int deleteSysRecordWaringByIds(Long[] ids)
    {
        return sysRecordWaringMapper.deleteSysRecordWaringByIds(ids);
    }

    /**
     * 删除学生晚归次数告警信息信息
     * 
     * @param id 学生晚归次数告警信息ID
     * @return 结果
     */
    @Override
    public int deleteSysRecordWaringById(Long id)
    {
        return sysRecordWaringMapper.deleteSysRecordWaringById(id);
    }

    @Override
    public List<Map<String, Object>> getCount(HashMap<String, Object> map) {
        return sysRecordWaringMapper.getCount(map);
    }
}
