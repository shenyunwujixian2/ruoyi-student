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
import com.ruoyi.offline.domain.MjxtMjxtCdwgxxQywx;
import com.ruoyi.offline.service.IMjxtMjxtCdwgxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 迟到晚归信息Controller
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@RestController
@RequestMapping("/offline/lateBackInfo")
public class MjxtMjxtCdwgxxQywxController extends BaseController
{
    @Autowired
    private IMjxtMjxtCdwgxxQywxService mjxtMjxtCdwgxxQywxService;

    /**
     * 查询迟到晚归信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:lateBackInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(MjxtMjxtCdwgxxQywx mjxtMjxtCdwgxxQywx)
    {
        startPage();
        List<MjxtMjxtCdwgxxQywx> list = mjxtMjxtCdwgxxQywxService.selectMjxtMjxtCdwgxxQywxList(mjxtMjxtCdwgxxQywx);
        return getDataTable(list);
    }

    /**
     * 导出迟到晚归信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:lateBackInfo:export')")
    @Log(title = "迟到晚归信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MjxtMjxtCdwgxxQywx mjxtMjxtCdwgxxQywx)
    {
        List<MjxtMjxtCdwgxxQywx> list = mjxtMjxtCdwgxxQywxService.selectMjxtMjxtCdwgxxQywxList(mjxtMjxtCdwgxxQywx);
        ExcelUtil<MjxtMjxtCdwgxxQywx> util = new ExcelUtil<MjxtMjxtCdwgxxQywx>(MjxtMjxtCdwgxxQywx.class);
        return util.exportExcel(list, "lateBackInfo");
    }

    /**
     * 获取迟到晚归信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('offline:lateBackInfo:query')")
    @GetMapping(value = "/{xm}")
    public AjaxResult getInfo(@PathVariable("xm") String xm)
    {
        return AjaxResult.success(mjxtMjxtCdwgxxQywxService.selectMjxtMjxtCdwgxxQywxById(xm));
    }

    /**
     * 新增迟到晚归信息
     */
    @PreAuthorize("@ss.hasPermi('offline:lateBackInfo:add')")
    @Log(title = "迟到晚归信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MjxtMjxtCdwgxxQywx mjxtMjxtCdwgxxQywx)
    {
        return toAjax(mjxtMjxtCdwgxxQywxService.insertMjxtMjxtCdwgxxQywx(mjxtMjxtCdwgxxQywx));
    }

    /**
     * 修改迟到晚归信息
     */
    @PreAuthorize("@ss.hasPermi('offline:lateBackInfo:edit')")
    @Log(title = "迟到晚归信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MjxtMjxtCdwgxxQywx mjxtMjxtCdwgxxQywx)
    {
        return toAjax(mjxtMjxtCdwgxxQywxService.updateMjxtMjxtCdwgxxQywx(mjxtMjxtCdwgxxQywx));
    }

    /**
     * 删除迟到晚归信息
     */
    @PreAuthorize("@ss.hasPermi('offline:lateBackInfo:remove')")
    @Log(title = "迟到晚归信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{xms}")
    public AjaxResult remove(@PathVariable String[] xms)
    {
        return toAjax(mjxtMjxtCdwgxxQywxService.deleteMjxtMjxtCdwgxxQywxByIds(xms));
    }
}
