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
import com.ruoyi.dbbase.domain.BdRsxxRsxtZgjzgxxsjQywx;
import com.ruoyi.dbbase.service.IBdRsxxRsxtZgjzgxxsjQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 在岗教职工线下数据Controller
 * 
 * @author xiaoafu
 * @date 2021-04-01
 */
@RestController
@RequestMapping("/dbbase/table3")
public class BdRsxxRsxtZgjzgxxsjQywxController extends BaseController
{
    @Autowired
    private IBdRsxxRsxtZgjzgxxsjQywxService bdRsxxRsxtZgjzgxxsjQywxService;

    /**
     * 查询在岗教职工线下数据列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table3:list')")
    @GetMapping("/list")
    public TableDataInfo list(BdRsxxRsxtZgjzgxxsjQywx bdRsxxRsxtZgjzgxxsjQywx)
    {
        startPage();
        List<BdRsxxRsxtZgjzgxxsjQywx> list = bdRsxxRsxtZgjzgxxsjQywxService.selectBdRsxxRsxtZgjzgxxsjQywxList(bdRsxxRsxtZgjzgxxsjQywx);
        return getDataTable(list);
    }

    /**
     * 导出在岗教职工线下数据列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table3:export')")
    @Log(title = "在岗教职工线下数据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BdRsxxRsxtZgjzgxxsjQywx bdRsxxRsxtZgjzgxxsjQywx)
    {
        List<BdRsxxRsxtZgjzgxxsjQywx> list = bdRsxxRsxtZgjzgxxsjQywxService.selectBdRsxxRsxtZgjzgxxsjQywxList(bdRsxxRsxtZgjzgxxsjQywx);
        ExcelUtil<BdRsxxRsxtZgjzgxxsjQywx> util = new ExcelUtil<BdRsxxRsxtZgjzgxxsjQywx>(BdRsxxRsxtZgjzgxxsjQywx.class);
        return util.exportExcel(list, "table3");
    }

    /**
     * 获取在岗教职工线下数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table3:query')")
    @GetMapping(value = "/{jzgh}")
    public AjaxResult getInfo(@PathVariable("jzgh") String jzgh)
    {
        return AjaxResult.success(bdRsxxRsxtZgjzgxxsjQywxService.selectBdRsxxRsxtZgjzgxxsjQywxById(jzgh));
    }

    /**
     * 新增在岗教职工线下数据
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table3:add')")
    @Log(title = "在岗教职工线下数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BdRsxxRsxtZgjzgxxsjQywx bdRsxxRsxtZgjzgxxsjQywx)
    {
        return toAjax(bdRsxxRsxtZgjzgxxsjQywxService.insertBdRsxxRsxtZgjzgxxsjQywx(bdRsxxRsxtZgjzgxxsjQywx));
    }

    /**
     * 修改在岗教职工线下数据
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table3:edit')")
    @Log(title = "在岗教职工线下数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BdRsxxRsxtZgjzgxxsjQywx bdRsxxRsxtZgjzgxxsjQywx)
    {
        return toAjax(bdRsxxRsxtZgjzgxxsjQywxService.updateBdRsxxRsxtZgjzgxxsjQywx(bdRsxxRsxtZgjzgxxsjQywx));
    }

    /**
     * 删除在岗教职工线下数据
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table3:remove')")
    @Log(title = "在岗教职工线下数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{jzghs}")
    public AjaxResult remove(@PathVariable String[] jzghs)
    {
        return toAjax(bdRsxxRsxtZgjzgxxsjQywxService.deleteBdRsxxRsxtZgjzgxxsjQywxByIds(jzghs));
    }
}
