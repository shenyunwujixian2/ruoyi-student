package com.ruoyi.offline.controller;

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
import com.ruoyi.offline.domain.MjxtMjxtMjryjcjlxxQywx;
import com.ruoyi.offline.service.IMjxtMjxtMjryjcjlxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 门禁人员进出记录信息Controller
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@RestController
@RequestMapping("/offline/accessInfo")
public class MjxtMjxtMjryjcjlxxQywxController extends BaseController
{
    @Autowired
    private IMjxtMjxtMjryjcjlxxQywxService mjxtMjxtMjryjcjlxxQywxService;

    /**
     * 查询门禁人员进出记录信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:accessInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(MjxtMjxtMjryjcjlxxQywx mjxtMjxtMjryjcjlxxQywx)
    {
        startPage();
        List<MjxtMjxtMjryjcjlxxQywx> list = mjxtMjxtMjryjcjlxxQywxService.selectMjxtMjxtMjryjcjlxxQywxList(mjxtMjxtMjryjcjlxxQywx);
        return getDataTable(list);
    }

    /**
     * 导出门禁人员进出记录信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:accessInfo:export')")
    @Log(title = "门禁人员进出记录信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MjxtMjxtMjryjcjlxxQywx mjxtMjxtMjryjcjlxxQywx)
    {
        List<MjxtMjxtMjryjcjlxxQywx> list = mjxtMjxtMjryjcjlxxQywxService.selectMjxtMjxtMjryjcjlxxQywxList(mjxtMjxtMjryjcjlxxQywx);
        ExcelUtil<MjxtMjxtMjryjcjlxxQywx> util = new ExcelUtil<MjxtMjxtMjryjcjlxxQywx>(MjxtMjxtMjryjcjlxxQywx.class);
        return util.exportExcel(list, "accessInfo");
    }

    /**
     * 获取门禁人员进出记录信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('offline:accessInfo:query')")
    @GetMapping(value = "/{zzzj}")
    public AjaxResult getInfo(@PathVariable("zzzj") Integer zzzj)
    {
        return AjaxResult.success(mjxtMjxtMjryjcjlxxQywxService.selectMjxtMjxtMjryjcjlxxQywxById(zzzj));
    }

    /**
     * 新增门禁人员进出记录信息
     */
    @PreAuthorize("@ss.hasPermi('offline:accessInfo:add')")
    @Log(title = "门禁人员进出记录信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MjxtMjxtMjryjcjlxxQywx mjxtMjxtMjryjcjlxxQywx)
    {
        return toAjax(mjxtMjxtMjryjcjlxxQywxService.insertMjxtMjxtMjryjcjlxxQywx(mjxtMjxtMjryjcjlxxQywx));
    }

    /**
     * 修改门禁人员进出记录信息
     */
    @PreAuthorize("@ss.hasPermi('offline:accessInfo:edit')")
    @Log(title = "门禁人员进出记录信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MjxtMjxtMjryjcjlxxQywx mjxtMjxtMjryjcjlxxQywx)
    {
        return toAjax(mjxtMjxtMjryjcjlxxQywxService.updateMjxtMjxtMjryjcjlxxQywx(mjxtMjxtMjryjcjlxxQywx));
    }

    /**
     * 删除门禁人员进出记录信息
     */
    @PreAuthorize("@ss.hasPermi('offline:accessInfo:remove')")
    @Log(title = "门禁人员进出记录信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{zzzjs}")
    public AjaxResult remove(@PathVariable Integer[] zzzjs)
    {
        return toAjax(mjxtMjxtMjryjcjlxxQywxService.deleteMjxtMjxtMjryjcjlxxQywxByIds(zzzjs));
    }
}
