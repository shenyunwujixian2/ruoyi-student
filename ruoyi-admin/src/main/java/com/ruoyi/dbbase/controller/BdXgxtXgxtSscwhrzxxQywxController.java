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
import com.ruoyi.dbbase.domain.BdXgxtXgxtSscwhrzxxQywx;
import com.ruoyi.dbbase.service.IBdXgxtXgxtSscwhrzxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍床位和入住信息Controller
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
@RestController
@RequestMapping("/dbbase/table6")
public class BdXgxtXgxtSscwhrzxxQywxController extends BaseController
{
    @Autowired
    private IBdXgxtXgxtSscwhrzxxQywxService bdXgxtXgxtSscwhrzxxQywxService;

    /**
     * 查询宿舍床位和入住信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table6:list')")
    @GetMapping("/list")
    public TableDataInfo list(BdXgxtXgxtSscwhrzxxQywx bdXgxtXgxtSscwhrzxxQywx)
    {
        startPage();
        List<BdXgxtXgxtSscwhrzxxQywx> list = bdXgxtXgxtSscwhrzxxQywxService.selectBdXgxtXgxtSscwhrzxxQywxList(bdXgxtXgxtSscwhrzxxQywx);
        return getDataTable(list);
    }

    /**
     * 导出宿舍床位和入住信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table6:export')")
    @Log(title = "宿舍床位和入住信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BdXgxtXgxtSscwhrzxxQywx bdXgxtXgxtSscwhrzxxQywx)
    {
        List<BdXgxtXgxtSscwhrzxxQywx> list = bdXgxtXgxtSscwhrzxxQywxService.selectBdXgxtXgxtSscwhrzxxQywxList(bdXgxtXgxtSscwhrzxxQywx);
        ExcelUtil<BdXgxtXgxtSscwhrzxxQywx> util = new ExcelUtil<BdXgxtXgxtSscwhrzxxQywx>(BdXgxtXgxtSscwhrzxxQywx.class);
        return util.exportExcel(list, "table6");
    }

    /**
     * 获取宿舍床位和入住信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table6:query')")
    @GetMapping(value = "/{xm}")
    public AjaxResult getInfo(@PathVariable("xm") String xm)
    {
        return AjaxResult.success(bdXgxtXgxtSscwhrzxxQywxService.selectBdXgxtXgxtSscwhrzxxQywxById(xm));
    }

    /**
     * 新增宿舍床位和入住信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table6:add')")
    @Log(title = "宿舍床位和入住信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BdXgxtXgxtSscwhrzxxQywx bdXgxtXgxtSscwhrzxxQywx)
    {
        return toAjax(bdXgxtXgxtSscwhrzxxQywxService.insertBdXgxtXgxtSscwhrzxxQywx(bdXgxtXgxtSscwhrzxxQywx));
    }

    /**
     * 修改宿舍床位和入住信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table6:edit')")
    @Log(title = "宿舍床位和入住信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BdXgxtXgxtSscwhrzxxQywx bdXgxtXgxtSscwhrzxxQywx)
    {
        return toAjax(bdXgxtXgxtSscwhrzxxQywxService.updateBdXgxtXgxtSscwhrzxxQywx(bdXgxtXgxtSscwhrzxxQywx));
    }

    /**
     * 删除宿舍床位和入住信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table6:remove')")
    @Log(title = "宿舍床位和入住信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{xms}")
    public AjaxResult remove(@PathVariable String[] xms)
    {
        return toAjax(bdXgxtXgxtSscwhrzxxQywxService.deleteBdXgxtXgxtSscwhrzxxQywxByIds(xms));
    }
}
