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
import com.ruoyi.dbbase.domain.BdZtsjZtsjJwzxsxxQywx;
import com.ruoyi.dbbase.service.IBdZtsjZtsjJwzxsxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教务在校生信息Controller
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
@RestController
@RequestMapping("/dbbase/table9")
public class BdZtsjZtsjJwzxsxxQywxController extends BaseController
{
    @Autowired
    private IBdZtsjZtsjJwzxsxxQywxService bdZtsjZtsjJwzxsxxQywxService;

    /**
     * 查询教务在校生信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table9:list')")
    @GetMapping("/list")
    public TableDataInfo list(BdZtsjZtsjJwzxsxxQywx bdZtsjZtsjJwzxsxxQywx)
    {
        startPage();
        List<BdZtsjZtsjJwzxsxxQywx> list = bdZtsjZtsjJwzxsxxQywxService.selectBdZtsjZtsjJwzxsxxQywxList(bdZtsjZtsjJwzxsxxQywx);
        return getDataTable(list);
    }

    /**
     * 导出教务在校生信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table9:export')")
    @Log(title = "教务在校生信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BdZtsjZtsjJwzxsxxQywx bdZtsjZtsjJwzxsxxQywx)
    {
        List<BdZtsjZtsjJwzxsxxQywx> list = bdZtsjZtsjJwzxsxxQywxService.selectBdZtsjZtsjJwzxsxxQywxList(bdZtsjZtsjJwzxsxxQywx);
        ExcelUtil<BdZtsjZtsjJwzxsxxQywx> util = new ExcelUtil<BdZtsjZtsjJwzxsxxQywx>(BdZtsjZtsjJwzxsxxQywx.class);
        return util.exportExcel(list, "table9");
    }

    /**
     * 获取教务在校生信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table9:query')")
    @GetMapping(value = "/{xm}")
    public AjaxResult getInfo(@PathVariable("xm") String xm)
    {
        return AjaxResult.success(bdZtsjZtsjJwzxsxxQywxService.selectBdZtsjZtsjJwzxsxxQywxById(xm));
    }

    /**
     * 新增教务在校生信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table9:add')")
    @Log(title = "教务在校生信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BdZtsjZtsjJwzxsxxQywx bdZtsjZtsjJwzxsxxQywx)
    {
        return toAjax(bdZtsjZtsjJwzxsxxQywxService.insertBdZtsjZtsjJwzxsxxQywx(bdZtsjZtsjJwzxsxxQywx));
    }

    /**
     * 修改教务在校生信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table9:edit')")
    @Log(title = "教务在校生信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BdZtsjZtsjJwzxsxxQywx bdZtsjZtsjJwzxsxxQywx)
    {
        return toAjax(bdZtsjZtsjJwzxsxxQywxService.updateBdZtsjZtsjJwzxsxxQywx(bdZtsjZtsjJwzxsxxQywx));
    }

    /**
     * 删除教务在校生信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table9:remove')")
    @Log(title = "教务在校生信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{xms}")
    public AjaxResult remove(@PathVariable String[] xms)
    {
        return toAjax(bdZtsjZtsjJwzxsxxQywxService.deleteBdZtsjZtsjJwzxsxxQywxByIds(xms));
    }
}
