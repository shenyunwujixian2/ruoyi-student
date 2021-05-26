package com.ruoyi.late.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.late.mapper.SysRecordPushMessageHistoryMapper;
import com.ruoyi.late.domain.SysRecordPushMessageHistory;
import com.ruoyi.late.service.ISysRecordPushMessageHistoryService;

/**
 * 业务--消息推送Service业务层处理
 * 
 * @author xiaoafu
 * @date 2021-04-03
 */
@Service
public class SysRecordPushMessageHistoryServiceImpl implements ISysRecordPushMessageHistoryService 
{
    @Autowired
    private SysRecordPushMessageHistoryMapper sysRecordPushMessageHistoryMapper;

    /**
     * 查询业务--消息推送
     * 
     * @param id 业务--消息推送ID
     * @return 业务--消息推送
     */
    @Override
    public SysRecordPushMessageHistory selectSysRecordPushMessageHistoryById(Long id)
    {
        return sysRecordPushMessageHistoryMapper.selectSysRecordPushMessageHistoryById(id);
    }

    /**
     * 查询业务--消息推送列表
     * 
     * @param sysRecordPushMessageHistory 业务--消息推送
     * @return 业务--消息推送
     */
    @Override
    public List<SysRecordPushMessageHistory> selectSysRecordPushMessageHistoryList(SysRecordPushMessageHistory sysRecordPushMessageHistory)
    {
        return sysRecordPushMessageHistoryMapper.selectSysRecordPushMessageHistoryList(sysRecordPushMessageHistory);
    }

    /**
     * 新增业务--消息推送
     * 
     * @param sysRecordPushMessageHistory 业务--消息推送
     * @return 结果
     */
    @Override
    public int insertSysRecordPushMessageHistory(SysRecordPushMessageHistory sysRecordPushMessageHistory)
    {
        sysRecordPushMessageHistory.setCreateTime(DateUtils.getNowDate());
        return sysRecordPushMessageHistoryMapper.insertSysRecordPushMessageHistory(sysRecordPushMessageHistory);
    }

    /**
     * 修改业务--消息推送
     * 
     * @param sysRecordPushMessageHistory 业务--消息推送
     * @return 结果
     */
    @Override
    public int updateSysRecordPushMessageHistory(SysRecordPushMessageHistory sysRecordPushMessageHistory)
    {
        sysRecordPushMessageHistory.setUpdateTime(DateUtils.getNowDate());
        return sysRecordPushMessageHistoryMapper.updateSysRecordPushMessageHistory(sysRecordPushMessageHistory);
    }

    /**
     * 批量删除业务--消息推送
     * 
     * @param ids 需要删除的业务--消息推送ID
     * @return 结果
     */
    @Override
    public int deleteSysRecordPushMessageHistoryByIds(Long[] ids)
    {
        return sysRecordPushMessageHistoryMapper.deleteSysRecordPushMessageHistoryByIds(ids);
    }

    /**
     * 删除业务--消息推送信息
     * 
     * @param id 业务--消息推送ID
     * @return 结果
     */
    @Override
    public int deleteSysRecordPushMessageHistoryById(Long id)
    {
        return sysRecordPushMessageHistoryMapper.deleteSysRecordPushMessageHistoryById(id);
    }
}
