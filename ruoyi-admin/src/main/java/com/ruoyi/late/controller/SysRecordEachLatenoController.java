package com.ruoyi.late.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.late.domain.SysRecordEachLateno;
import com.ruoyi.late.service.ISysRecordEachLatenoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 10点未处理数据Controller
 * 
 * @author xiaoafu
 * @date 2021-04-29
 */
@Api(tags="4月29日、查看过期未处理的数据")
@RestController
@RequestMapping("/late/lateno")
public class SysRecordEachLatenoController extends BaseController
{
    @Autowired
    private ISysRecordEachLatenoService sysRecordEachLatenoService;

    /**
     * 查询10点未处理数据列表
     */
    @ApiOperation("4月29日、查看过期未处理的数据")
    @GetMapping("/list")
    public TableDataInfo list(SysRecordEachLateno sysRecordEachLateno)
    {
        startPage();
        List<SysRecordEachLateno> list = sysRecordEachLatenoService.selectSysRecordEachLatenoList(sysRecordEachLateno);
        return getDataTable(list);
    }

    /**
     * 导出10点未处理数据列表
     */
    @PreAuthorize("@ss.hasPermi('late:lateno:export')")
    @Log(title = "10点未处理数据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysRecordEachLateno sysRecordEachLateno)
    {
        List<SysRecordEachLateno> list = sysRecordEachLatenoService.selectSysRecordEachLatenoList(sysRecordEachLateno);
        ExcelUtil<SysRecordEachLateno> util = new ExcelUtil<SysRecordEachLateno>(SysRecordEachLateno.class);
        return util.exportExcel(list, "lateno");
    }

    /**
     * 获取10点未处理数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('late:lateno:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysRecordEachLatenoService.selectSysRecordEachLatenoById(id));
    }

    /**
     * 新增10点未处理数据
     */
    @PreAuthorize("@ss.hasPermi('late:lateno:add')")
    @Log(title = "10点未处理数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRecordEachLateno sysRecordEachLateno)
    {
        return toAjax(sysRecordEachLatenoService.insertSysRecordEachLateno(sysRecordEachLateno));
    }

    /**
     * 修改10点未处理数据
     */
    @PreAuthorize("@ss.hasPermi('late:lateno:edit')")
    @Log(title = "10点未处理数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRecordEachLateno sysRecordEachLateno)
    {
        return toAjax(sysRecordEachLatenoService.updateSysRecordEachLateno(sysRecordEachLateno));
    }

    /**
     * 删除10点未处理数据
     */
    @PreAuthorize("@ss.hasPermi('late:lateno:remove')")
    @Log(title = "10点未处理数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysRecordEachLatenoService.deleteSysRecordEachLatenoByIds(ids));
    }
}
