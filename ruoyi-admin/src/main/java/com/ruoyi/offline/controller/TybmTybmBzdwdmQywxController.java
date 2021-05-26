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
import com.ruoyi.offline.domain.TybmTybmBzdwdmQywx;
import com.ruoyi.offline.service.ITybmTybmBzdwdmQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学校部门Controller
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@RestController
@RequestMapping("/offline/depart")
public class TybmTybmBzdwdmQywxController extends BaseController
{
    @Autowired
    private ITybmTybmBzdwdmQywxService tybmTybmBzdwdmQywxService;

    /**
     * 查询学校部门列表
     */
    @PreAuthorize("@ss.hasPermi('offline:depart:list')")
    @GetMapping("/list")
    public TableDataInfo list(TybmTybmBzdwdmQywx tybmTybmBzdwdmQywx)
    {
        startPage();
        List<TybmTybmBzdwdmQywx> list = tybmTybmBzdwdmQywxService.selectTybmTybmBzdwdmQywxList(tybmTybmBzdwdmQywx);
        return getDataTable(list);
    }

    /**
     * 导出学校部门列表
     */
    @PreAuthorize("@ss.hasPermi('offline:depart:export')")
    @Log(title = "学校部门", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TybmTybmBzdwdmQywx tybmTybmBzdwdmQywx)
    {
        List<TybmTybmBzdwdmQywx> list = tybmTybmBzdwdmQywxService.selectTybmTybmBzdwdmQywxList(tybmTybmBzdwdmQywx);
        ExcelUtil<TybmTybmBzdwdmQywx> util = new ExcelUtil<TybmTybmBzdwdmQywx>(TybmTybmBzdwdmQywx.class);
        return util.exportExcel(list, "depart");
    }

    /**
     * 获取学校部门详细信息
     */
    @PreAuthorize("@ss.hasPermi('offline:depart:query')")
    @GetMapping(value = "/{sjbmdm}")
    public AjaxResult getInfo(@PathVariable("sjbmdm") String sjbmdm)
    {
        return AjaxResult.success(tybmTybmBzdwdmQywxService.selectTybmTybmBzdwdmQywxById(sjbmdm));
    }

    /**
     * 新增学校部门
     */
    @PreAuthorize("@ss.hasPermi('offline:depart:add')")
    @Log(title = "学校部门", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TybmTybmBzdwdmQywx tybmTybmBzdwdmQywx)
    {
        return toAjax(tybmTybmBzdwdmQywxService.insertTybmTybmBzdwdmQywx(tybmTybmBzdwdmQywx));
    }

    /**
     * 修改学校部门
     */
    @PreAuthorize("@ss.hasPermi('offline:depart:edit')")
    @Log(title = "学校部门", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TybmTybmBzdwdmQywx tybmTybmBzdwdmQywx)
    {
        return toAjax(tybmTybmBzdwdmQywxService.updateTybmTybmBzdwdmQywx(tybmTybmBzdwdmQywx));
    }

    /**
     * 删除学校部门
     */
    @PreAuthorize("@ss.hasPermi('offline:depart:remove')")
    @Log(title = "学校部门", businessType = BusinessType.DELETE)
	@DeleteMapping("/{sjbmdms}")
    public AjaxResult remove(@PathVariable String[] sjbmdms)
    {
        return toAjax(tybmTybmBzdwdmQywxService.deleteTybmTybmBzdwdmQywxByIds(sjbmdms));
    }
}
