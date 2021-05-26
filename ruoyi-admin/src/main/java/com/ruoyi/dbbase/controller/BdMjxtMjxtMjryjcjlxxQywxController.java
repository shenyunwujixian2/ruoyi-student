package com.ruoyi.dbbase.controller;

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
import com.ruoyi.dbbase.domain.BdMjxtMjxtMjryjcjlxxQywx;
import com.ruoyi.dbbase.service.IBdMjxtMjxtMjryjcjlxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 门禁人员进出记录信息Controller
 * 
 * @author xiaoafu
 * @date 2021-04-01
 */
@RestController
@RequestMapping("/dbbase/table2")
public class BdMjxtMjxtMjryjcjlxxQywxController extends BaseController
{
    @Autowired
    private IBdMjxtMjxtMjryjcjlxxQywxService bdMjxtMjxtMjryjcjlxxQywxService;

    /**
     * 查询门禁人员进出记录信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table2:list')")
    @GetMapping("/list")
    public TableDataInfo list(BdMjxtMjxtMjryjcjlxxQywx bdMjxtMjxtMjryjcjlxxQywx)
    {
        startPage();
        List<BdMjxtMjxtMjryjcjlxxQywx> list = bdMjxtMjxtMjryjcjlxxQywxService.selectBdMjxtMjxtMjryjcjlxxQywxList(bdMjxtMjxtMjryjcjlxxQywx);
        return getDataTable(list);
    }

    /**
     * 导出门禁人员进出记录信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table2:export')")
    @Log(title = "门禁人员进出记录信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BdMjxtMjxtMjryjcjlxxQywx bdMjxtMjxtMjryjcjlxxQywx)
    {
        List<BdMjxtMjxtMjryjcjlxxQywx> list = bdMjxtMjxtMjryjcjlxxQywxService.selectBdMjxtMjxtMjryjcjlxxQywxList(bdMjxtMjxtMjryjcjlxxQywx);
        ExcelUtil<BdMjxtMjxtMjryjcjlxxQywx> util = new ExcelUtil<BdMjxtMjxtMjryjcjlxxQywx>(BdMjxtMjxtMjryjcjlxxQywx.class);
        return util.exportExcel(list, "table2");
    }

    /**
     * 获取门禁人员进出记录信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table2:query')")
    @GetMapping(value = "/{zzzj}")
    public AjaxResult getInfo(@PathVariable("zzzj") Integer zzzj)
    {
        return AjaxResult.success(bdMjxtMjxtMjryjcjlxxQywxService.selectBdMjxtMjxtMjryjcjlxxQywxById(zzzj));
    }

    /**
     * 新增门禁人员进出记录信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table2:add')")
    @Log(title = "门禁人员进出记录信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BdMjxtMjxtMjryjcjlxxQywx bdMjxtMjxtMjryjcjlxxQywx)
    {
        return toAjax(bdMjxtMjxtMjryjcjlxxQywxService.insertBdMjxtMjxtMjryjcjlxxQywx(bdMjxtMjxtMjryjcjlxxQywx));
    }

    /**
     * 修改门禁人员进出记录信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table2:edit')")
    @Log(title = "门禁人员进出记录信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BdMjxtMjxtMjryjcjlxxQywx bdMjxtMjxtMjryjcjlxxQywx)
    {
        return toAjax(bdMjxtMjxtMjryjcjlxxQywxService.updateBdMjxtMjxtMjryjcjlxxQywx(bdMjxtMjxtMjryjcjlxxQywx));
    }

    /**
     * 删除门禁人员进出记录信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table2:remove')")
    @Log(title = "门禁人员进出记录信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{zzzjs}")
    public AjaxResult remove(@PathVariable Integer[] zzzjs)
    {
        return toAjax(bdMjxtMjxtMjryjcjlxxQywxService.deleteBdMjxtMjxtMjryjcjlxxQywxByIds(zzzjs));
    }
}
