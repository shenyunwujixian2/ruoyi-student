package com.ruoyi.late.service;

import java.util.List;
import com.ruoyi.late.domain.SysRecordPushMessageHistory;

/**
 * 业务--消息推送Service接口
 * 
 * @author xiaoafu
 * @date 2021-04-03
 */
public interface ISysRecordPushMessageHistoryService 
{
    /**
     * 查询业务--消息推送
     * 
     * @param id 业务--消息推送ID
     * @return 业务--消息推送
     */
    public SysRecordPushMessageHistory selectSysRecordPushMessageHistoryById(Long id);

    /**
     * 查询业务--消息推送列表
     * 
     * @param sysRecordPushMessageHistory 业务--消息推送
     * @return 业务--消息推送集合
     */
    public List<SysRecordPushMessageHistory> selectSysRecordPushMessageHistoryList(SysRecordPushMessageHistory sysRecordPushMessageHistory);

    /**
     * 新增业务--消息推送
     * 
     * @param sysRecordPushMessageHistory 业务--消息推送
     * @return 结果
     */
    public int insertSysRecordPushMessageHistory(SysRecordPushMessageHistory sysRecordPushMessageHistory);

    /**
     * 修改业务--消息推送
     * 
     * @param sysRecordPushMessageHistory 业务--消息推送
     * @return 结果
     */
    public int updateSysRecordPushMessageHistory(SysRecordPushMessageHistory sysRecordPushMessageHistory);

    /**
     * 批量删除业务--消息推送
     * 
     * @param ids 需要删除的业务--消息推送ID
     * @return 结果
     */
    public int deleteSysRecordPushMessageHistoryByIds(Long[] ids);

    /**
     * 删除业务--消息推送信息
     * 
     * @param id 业务--消息推送ID
     * @return 结果
     */
    public int deleteSysRecordPushMessageHistoryById(Long id);
}
