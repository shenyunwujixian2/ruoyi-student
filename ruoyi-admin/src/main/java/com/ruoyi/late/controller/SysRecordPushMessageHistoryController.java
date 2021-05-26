package com.ruoyi.late.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.late.domain.SysRecordPushMessageHistory;
import com.ruoyi.late.service.ISysRecordPushMessageHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 业务--消息推送历史记录Controller
 * 
 * @author xiaoafu
 * @date 2021-04-03
 */
@RestController
@RequestMapping("/late/history")
public class SysRecordPushMessageHistoryController extends BaseController
{
    @Autowired
    private ISysRecordPushMessageHistoryService sysRecordPushMessageHistoryService;

    /**
     * 查询业务--消息推送列表
     */
    @PreAuthorize("@ss.hasPermi('late:history:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysRecordPushMessageHistory sysRecordPushMessageHistory)
    {
        startPage();
        List<SysRecordPushMessageHistory> list = sysRecordPushMessageHistoryService.selectSysRecordPushMessageHistoryList(sysRecordPushMessageHistory);
        return getDataTable(list);
    }

    /**
     * 导出业务--消息推送列表
     */
    @PreAuthorize("@ss.hasPermi('late:history:export')")
    @Log(title = "业务--消息推送", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysRecordPushMessageHistory sysRecordPushMessageHistory)
    {
        List<SysRecordPushMessageHistory> list = sysRecordPushMessageHistoryService.selectSysRecordPushMessageHistoryList(sysRecordPushMessageHistory);
        ExcelUtil<SysRecordPushMessageHistory> util = new ExcelUtil<SysRecordPushMessageHistory>(SysRecordPushMessageHistory.class);
        return util.exportExcel(list, "history");
    }

    /**
     * 获取业务--消息推送详细信息
     */
    @PreAuthorize("@ss.hasPermi('late:history:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysRecordPushMessageHistoryService.selectSysRecordPushMessageHistoryById(id));
    }

    /**
     * 新增业务--消息推送
     */
    @PreAuthorize("@ss.hasPermi('late:history:add')")
    @Log(title = "业务--消息推送", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRecordPushMessageHistory sysRecordPushMessageHistory)
    {
        return toAjax(sysRecordPushMessageHistoryService.insertSysRecordPushMessageHistory(sysRecordPushMessageHistory));
    }

    /**
     * 修改业务--消息推送
     */
    @PreAuthorize("@ss.hasPermi('late:history:edit')")
    @Log(title = "业务--消息推送", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRecordPushMessageHistory sysRecordPushMessageHistory)
    {
        return toAjax(sysRecordPushMessageHistoryService.updateSysRecordPushMessageHistory(sysRecordPushMessageHistory));
    }

    /**
     * 删除业务--消息推送
     */
    @PreAuthorize("@ss.hasPermi('late:history:remove')")
    @Log(title = "业务--消息推送", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysRecordPushMessageHistoryService.deleteSysRecordPushMessageHistoryByIds(ids));
    }
}
