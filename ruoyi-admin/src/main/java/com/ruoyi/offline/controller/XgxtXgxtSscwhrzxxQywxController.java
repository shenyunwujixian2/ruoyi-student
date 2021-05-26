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
import com.ruoyi.offline.domain.XgxtXgxtSscwhrzxxQywx;
import com.ruoyi.offline.service.IXgxtXgxtSscwhrzxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍床位和入住信息Controller
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@RestController
@RequestMapping("/offline/roombed")
public class XgxtXgxtSscwhrzxxQywxController extends BaseController
{
    @Autowired
    private IXgxtXgxtSscwhrzxxQywxService xgxtXgxtSscwhrzxxQywxService;

    /**
     * 查询宿舍床位和入住信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:roombed:list')")
    @GetMapping("/list")
    public TableDataInfo list(XgxtXgxtSscwhrzxxQywx xgxtXgxtSscwhrzxxQywx)
    {
        startPage();
        List<XgxtXgxtSscwhrzxxQywx> list = xgxtXgxtSscwhrzxxQywxService.selectXgxtXgxtSscwhrzxxQywxList(xgxtXgxtSscwhrzxxQywx);
        return getDataTable(list);
    }

    /**
     * 导出宿舍床位和入住信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:roombed:export')")
    @Log(title = "宿舍床位和入住信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(XgxtXgxtSscwhrzxxQywx xgxtXgxtSscwhrzxxQywx)
    {
        List<XgxtXgxtSscwhrzxxQywx> list = xgxtXgxtSscwhrzxxQywxService.selectXgxtXgxtSscwhrzxxQywxList(xgxtXgxtSscwhrzxxQywx);
        ExcelUtil<XgxtXgxtSscwhrzxxQywx> util = new ExcelUtil<XgxtXgxtSscwhrzxxQywx>(XgxtXgxtSscwhrzxxQywx.class);
        return util.exportExcel(list, "roombed");
    }

    /**
     * 获取宿舍床位和入住信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('offline:roombed:query')")
    @GetMapping(value = "/{xm}")
    public AjaxResult getInfo(@PathVariable("xm") String xm)
    {
        return AjaxResult.success(xgxtXgxtSscwhrzxxQywxService.selectXgxtXgxtSscwhrzxxQywxById(xm));
    }

    /**
     * 新增宿舍床位和入住信息
     */
    @PreAuthorize("@ss.hasPermi('offline:roombed:add')")
    @Log(title = "宿舍床位和入住信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XgxtXgxtSscwhrzxxQywx xgxtXgxtSscwhrzxxQywx)
    {
        return toAjax(xgxtXgxtSscwhrzxxQywxService.insertXgxtXgxtSscwhrzxxQywx(xgxtXgxtSscwhrzxxQywx));
    }

    /**
     * 修改宿舍床位和入住信息
     */
    @PreAuthorize("@ss.hasPermi('offline:roombed:edit')")
    @Log(title = "宿舍床位和入住信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XgxtXgxtSscwhrzxxQywx xgxtXgxtSscwhrzxxQywx)
    {
        return toAjax(xgxtXgxtSscwhrzxxQywxService.updateXgxtXgxtSscwhrzxxQywx(xgxtXgxtSscwhrzxxQywx));
    }

    /**
     * 删除宿舍床位和入住信息
     */
    @PreAuthorize("@ss.hasPermi('offline:roombed:remove')")
    @Log(title = "宿舍床位和入住信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{xms}")
    public AjaxResult remove(@PathVariable String[] xms)
    {
        return toAjax(xgxtXgxtSscwhrzxxQywxService.deleteXgxtXgxtSscwhrzxxQywxByIds(xms));
    }
}
