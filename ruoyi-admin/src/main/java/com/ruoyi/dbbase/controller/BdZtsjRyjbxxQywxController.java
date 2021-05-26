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
import com.ruoyi.dbbase.domain.BdZtsjRyjbxxQywx;
import com.ruoyi.dbbase.service.IBdZtsjRyjbxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 门禁中的用户信息Controller
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
@RestController
@RequestMapping("/dbbase/table8")
public class BdZtsjRyjbxxQywxController extends BaseController
{
    @Autowired
    private IBdZtsjRyjbxxQywxService bdZtsjRyjbxxQywxService;

    /**
     * 查询门禁中的用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table8:list')")
    @GetMapping("/list")
    public TableDataInfo list(BdZtsjRyjbxxQywx bdZtsjRyjbxxQywx)
    {
        startPage();
        List<BdZtsjRyjbxxQywx> list = bdZtsjRyjbxxQywxService.selectBdZtsjRyjbxxQywxList(bdZtsjRyjbxxQywx);
        return getDataTable(list);
    }

    /**
     * 导出门禁中的用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table8:export')")
    @Log(title = "门禁中的用户信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BdZtsjRyjbxxQywx bdZtsjRyjbxxQywx)
    {
        List<BdZtsjRyjbxxQywx> list = bdZtsjRyjbxxQywxService.selectBdZtsjRyjbxxQywxList(bdZtsjRyjbxxQywx);
        ExcelUtil<BdZtsjRyjbxxQywx> util = new ExcelUtil<BdZtsjRyjbxxQywx>(BdZtsjRyjbxxQywx.class);
        return util.exportExcel(list, "table8");
    }

    /**
     * 获取门禁中的用户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table8:query')")
    @GetMapping(value = "/{zj}")
    public AjaxResult getInfo(@PathVariable("zj") String zj)
    {
        return AjaxResult.success(bdZtsjRyjbxxQywxService.selectBdZtsjRyjbxxQywxById(zj));
    }

    /**
     * 新增门禁中的用户信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table8:add')")
    @Log(title = "门禁中的用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BdZtsjRyjbxxQywx bdZtsjRyjbxxQywx)
    {
        return toAjax(bdZtsjRyjbxxQywxService.insertBdZtsjRyjbxxQywx(bdZtsjRyjbxxQywx));
    }

    /**
     * 修改门禁中的用户信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table8:edit')")
    @Log(title = "门禁中的用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BdZtsjRyjbxxQywx bdZtsjRyjbxxQywx)
    {
        return toAjax(bdZtsjRyjbxxQywxService.updateBdZtsjRyjbxxQywx(bdZtsjRyjbxxQywx));
    }

    /**
     * 删除门禁中的用户信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table8:remove')")
    @Log(title = "门禁中的用户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{zjs}")
    public AjaxResult remove(@PathVariable String[] zjs)
    {
        return toAjax(bdZtsjRyjbxxQywxService.deleteBdZtsjRyjbxxQywxByIds(zjs));
    }
}
