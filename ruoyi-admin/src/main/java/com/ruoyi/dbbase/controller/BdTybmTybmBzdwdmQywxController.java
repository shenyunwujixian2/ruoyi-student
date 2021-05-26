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
import com.ruoyi.dbbase.domain.BdTybmTybmBzdwdmQywx;
import com.ruoyi.dbbase.service.IBdTybmTybmBzdwdmQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学校部门Controller
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
@RestController
@RequestMapping("/dbbase/table4")
public class BdTybmTybmBzdwdmQywxController extends BaseController
{
    @Autowired
    private IBdTybmTybmBzdwdmQywxService bdTybmTybmBzdwdmQywxService;

    /**
     * 查询学校部门列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table4:list')")
    @GetMapping("/list")
    public TableDataInfo list(BdTybmTybmBzdwdmQywx bdTybmTybmBzdwdmQywx)
    {
        startPage();
        List<BdTybmTybmBzdwdmQywx> list = bdTybmTybmBzdwdmQywxService.selectBdTybmTybmBzdwdmQywxList(bdTybmTybmBzdwdmQywx);
        return getDataTable(list);
    }

    /**
     * 导出学校部门列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table4:export')")
    @Log(title = "学校部门", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BdTybmTybmBzdwdmQywx bdTybmTybmBzdwdmQywx)
    {
        List<BdTybmTybmBzdwdmQywx> list = bdTybmTybmBzdwdmQywxService.selectBdTybmTybmBzdwdmQywxList(bdTybmTybmBzdwdmQywx);
        ExcelUtil<BdTybmTybmBzdwdmQywx> util = new ExcelUtil<BdTybmTybmBzdwdmQywx>(BdTybmTybmBzdwdmQywx.class);
        return util.exportExcel(list, "table4");
    }

    /**
     * 获取学校部门详细信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table4:query')")
    @GetMapping(value = "/{sjbmdm}")
    public AjaxResult getInfo(@PathVariable("sjbmdm") String sjbmdm)
    {
        return AjaxResult.success(bdTybmTybmBzdwdmQywxService.selectBdTybmTybmBzdwdmQywxById(sjbmdm));
    }

    /**
     * 新增学校部门
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table4:add')")
    @Log(title = "学校部门", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BdTybmTybmBzdwdmQywx bdTybmTybmBzdwdmQywx)
    {
        return toAjax(bdTybmTybmBzdwdmQywxService.insertBdTybmTybmBzdwdmQywx(bdTybmTybmBzdwdmQywx));
    }

    /**
     * 修改学校部门
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table4:edit')")
    @Log(title = "学校部门", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BdTybmTybmBzdwdmQywx bdTybmTybmBzdwdmQywx)
    {
        return toAjax(bdTybmTybmBzdwdmQywxService.updateBdTybmTybmBzdwdmQywx(bdTybmTybmBzdwdmQywx));
    }

    /**
     * 删除学校部门
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table4:remove')")
    @Log(title = "学校部门", businessType = BusinessType.DELETE)
	@DeleteMapping("/{sjbmdms}")
    public AjaxResult remove(@PathVariable String[] sjbmdms)
    {
        return toAjax(bdTybmTybmBzdwdmQywxService.deleteBdTybmTybmBzdwdmQywxByIds(sjbmdms));
    }
}
