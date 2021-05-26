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
import com.ruoyi.offline.domain.ZtsjRyjbxxQywx;
import com.ruoyi.offline.service.IZtsjRyjbxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 门禁中的用户信息Controller
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@RestController
@RequestMapping("/offline/accessUser")
public class ZtsjRyjbxxQywxController extends BaseController
{
    @Autowired
    private IZtsjRyjbxxQywxService ztsjRyjbxxQywxService;

    /**
     * 查询门禁中的用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:accessUser:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZtsjRyjbxxQywx ztsjRyjbxxQywx)
    {
        startPage();
        List<ZtsjRyjbxxQywx> list = ztsjRyjbxxQywxService.selectZtsjRyjbxxQywxList(ztsjRyjbxxQywx);
        return getDataTable(list);
    }

    /**
     * 导出门禁中的用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:accessUser:export')")
    @Log(title = "门禁中的用户信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZtsjRyjbxxQywx ztsjRyjbxxQywx)
    {
        List<ZtsjRyjbxxQywx> list = ztsjRyjbxxQywxService.selectZtsjRyjbxxQywxList(ztsjRyjbxxQywx);
        ExcelUtil<ZtsjRyjbxxQywx> util = new ExcelUtil<ZtsjRyjbxxQywx>(ZtsjRyjbxxQywx.class);
        return util.exportExcel(list, "accessUser");
    }

    /**
     * 获取门禁中的用户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('offline:accessUser:query')")
    @GetMapping(value = "/{zj}")
    public AjaxResult getInfo(@PathVariable("zj") String zj)
    {
        return AjaxResult.success(ztsjRyjbxxQywxService.selectZtsjRyjbxxQywxById(zj));
    }

    /**
     * 新增门禁中的用户信息
     */
    @PreAuthorize("@ss.hasPermi('offline:accessUser:add')")
    @Log(title = "门禁中的用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZtsjRyjbxxQywx ztsjRyjbxxQywx)
    {
        return toAjax(ztsjRyjbxxQywxService.insertZtsjRyjbxxQywx(ztsjRyjbxxQywx));
    }

    /**
     * 修改门禁中的用户信息
     */
    @PreAuthorize("@ss.hasPermi('offline:accessUser:edit')")
    @Log(title = "门禁中的用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZtsjRyjbxxQywx ztsjRyjbxxQywx)
    {
        return toAjax(ztsjRyjbxxQywxService.updateZtsjRyjbxxQywx(ztsjRyjbxxQywx));
    }

    /**
     * 删除门禁中的用户信息
     */
    @PreAuthorize("@ss.hasPermi('offline:accessUser:remove')")
    @Log(title = "门禁中的用户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{zjs}")
    public AjaxResult remove(@PathVariable String[] zjs)
    {
        return toAjax(ztsjRyjbxxQywxService.deleteZtsjRyjbxxQywxByIds(zjs));
    }
}
