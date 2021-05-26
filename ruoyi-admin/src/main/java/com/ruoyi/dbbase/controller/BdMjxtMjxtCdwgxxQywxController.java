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
import com.ruoyi.dbbase.domain.BdMjxtMjxtCdwgxxQywx;
import com.ruoyi.dbbase.service.IBdMjxtMjxtCdwgxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 迟到晚归信息Controller
 * 
 * @author yufu
 * @date 2021-04-01
 */
@RestController
@RequestMapping("/dbbase/table1")
public class BdMjxtMjxtCdwgxxQywxController extends BaseController
{
    @Autowired
    private IBdMjxtMjxtCdwgxxQywxService bdMjxtMjxtCdwgxxQywxService;

    /**
     * 查询迟到晚归信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table1:list')")
    @GetMapping("/list")
    public TableDataInfo list(BdMjxtMjxtCdwgxxQywx bdMjxtMjxtCdwgxxQywx)
    {
        startPage();
        List<BdMjxtMjxtCdwgxxQywx> list = bdMjxtMjxtCdwgxxQywxService.selectBdMjxtMjxtCdwgxxQywxList(bdMjxtMjxtCdwgxxQywx);
        return getDataTable(list);
    }

    /**
     * 导出迟到晚归信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table1:export')")
    @Log(title = "迟到晚归信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BdMjxtMjxtCdwgxxQywx bdMjxtMjxtCdwgxxQywx)
    {
        List<BdMjxtMjxtCdwgxxQywx> list = bdMjxtMjxtCdwgxxQywxService.selectBdMjxtMjxtCdwgxxQywxList(bdMjxtMjxtCdwgxxQywx);
        ExcelUtil<BdMjxtMjxtCdwgxxQywx> util = new ExcelUtil<BdMjxtMjxtCdwgxxQywx>(BdMjxtMjxtCdwgxxQywx.class);
        return util.exportExcel(list, "table1");
    }

    /**
     * 获取迟到晚归信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table1:query')")
    @GetMapping(value = "/{xm}")
    public AjaxResult getInfo(@PathVariable("xm") String xm)
    {
        return AjaxResult.success(bdMjxtMjxtCdwgxxQywxService.selectBdMjxtMjxtCdwgxxQywxById(xm));
    }

    /**
     * 新增迟到晚归信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table1:add')")
    @Log(title = "迟到晚归信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BdMjxtMjxtCdwgxxQywx bdMjxtMjxtCdwgxxQywx)
    {
        return toAjax(bdMjxtMjxtCdwgxxQywxService.insertBdMjxtMjxtCdwgxxQywx(bdMjxtMjxtCdwgxxQywx));
    }

    /**
     * 修改迟到晚归信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table1:edit')")
    @Log(title = "迟到晚归信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BdMjxtMjxtCdwgxxQywx bdMjxtMjxtCdwgxxQywx)
    {
        return toAjax(bdMjxtMjxtCdwgxxQywxService.updateBdMjxtMjxtCdwgxxQywx(bdMjxtMjxtCdwgxxQywx));
    }

    /**
     * 删除迟到晚归信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table1:remove')")
    @Log(title = "迟到晚归信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{xms}")
    public AjaxResult remove(@PathVariable String[] xms)
    {
        return toAjax(bdMjxtMjxtCdwgxxQywxService.deleteBdMjxtMjxtCdwgxxQywxByIds(xms));
    }
}
