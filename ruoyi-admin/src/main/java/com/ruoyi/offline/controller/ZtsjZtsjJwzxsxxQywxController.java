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
import com.ruoyi.offline.domain.ZtsjZtsjJwzxsxxQywx;
import com.ruoyi.offline.service.IZtsjZtsjJwzxsxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教务在校生信息Controller
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@RestController
@RequestMapping("/offline/studentDetailedInfo")
public class ZtsjZtsjJwzxsxxQywxController extends BaseController
{
    @Autowired
    private IZtsjZtsjJwzxsxxQywxService ztsjZtsjJwzxsxxQywxService;

    /**
     * 查询教务在校生信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:studentDetailedInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZtsjZtsjJwzxsxxQywx ztsjZtsjJwzxsxxQywx)
    {
        startPage();
        List<ZtsjZtsjJwzxsxxQywx> list = ztsjZtsjJwzxsxxQywxService.selectZtsjZtsjJwzxsxxQywxList(ztsjZtsjJwzxsxxQywx);
        return getDataTable(list);
    }

    /**
     * 导出教务在校生信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:studentDetailedInfo:export')")
    @Log(title = "教务在校生信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZtsjZtsjJwzxsxxQywx ztsjZtsjJwzxsxxQywx)
    {
        List<ZtsjZtsjJwzxsxxQywx> list = ztsjZtsjJwzxsxxQywxService.selectZtsjZtsjJwzxsxxQywxList(ztsjZtsjJwzxsxxQywx);
        ExcelUtil<ZtsjZtsjJwzxsxxQywx> util = new ExcelUtil<ZtsjZtsjJwzxsxxQywx>(ZtsjZtsjJwzxsxxQywx.class);
        return util.exportExcel(list, "studentDetailedInfo");
    }

    /**
     * 获取教务在校生信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('offline:studentDetailedInfo:query')")
    @GetMapping(value = "/{xm}")
    public AjaxResult getInfo(@PathVariable("xm") String xm)
    {
        return AjaxResult.success(ztsjZtsjJwzxsxxQywxService.selectZtsjZtsjJwzxsxxQywxById(xm));
    }

    /**
     * 新增教务在校生信息
     */
    @PreAuthorize("@ss.hasPermi('offline:studentDetailedInfo:add')")
    @Log(title = "教务在校生信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZtsjZtsjJwzxsxxQywx ztsjZtsjJwzxsxxQywx)
    {
        return toAjax(ztsjZtsjJwzxsxxQywxService.insertZtsjZtsjJwzxsxxQywx(ztsjZtsjJwzxsxxQywx));
    }

    /**
     * 修改教务在校生信息
     */
    @PreAuthorize("@ss.hasPermi('offline:studentDetailedInfo:edit')")
    @Log(title = "教务在校生信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZtsjZtsjJwzxsxxQywx ztsjZtsjJwzxsxxQywx)
    {
        return toAjax(ztsjZtsjJwzxsxxQywxService.updateZtsjZtsjJwzxsxxQywx(ztsjZtsjJwzxsxxQywx));
    }

    /**
     * 删除教务在校生信息
     */
    @PreAuthorize("@ss.hasPermi('offline:studentDetailedInfo:remove')")
    @Log(title = "教务在校生信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{xms}")
    public AjaxResult remove(@PathVariable String[] xms)
    {
        return toAjax(ztsjZtsjJwzxsxxQywxService.deleteZtsjZtsjJwzxsxxQywxByIds(xms));
    }
}
