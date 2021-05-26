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
import com.ruoyi.dbbase.domain.BdBsdtBsdtXsqxjxxQywx;
import com.ruoyi.dbbase.service.IBdBsdtBsdtXsqxjxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 本地学生请假信息Controller
 * 
 * @author 学生请假表
 * @date 2021-04-16
 */
@RestController
@RequestMapping("/dbbase/xsqxjxx")
public class BdBsdtBsdtXsqxjxxQywxController extends BaseController
{
    @Autowired
    private IBdBsdtBsdtXsqxjxxQywxService bdBsdtBsdtXsqxjxxQywxService;

    /**
     * 查询本地学生请假信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:xsqxjxx:list')")
    @GetMapping("/list")
    public TableDataInfo list(BdBsdtBsdtXsqxjxxQywx bdBsdtBsdtXsqxjxxQywx)
    {
        startPage();
        List<BdBsdtBsdtXsqxjxxQywx> list = bdBsdtBsdtXsqxjxxQywxService.selectBdBsdtBsdtXsqxjxxQywxList(bdBsdtBsdtXsqxjxxQywx);
        return getDataTable(list);
    }

    /**
     * 导出本地学生请假信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:xsqxjxx:export')")
    @Log(title = "本地学生请假信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BdBsdtBsdtXsqxjxxQywx bdBsdtBsdtXsqxjxxQywx)
    {
        List<BdBsdtBsdtXsqxjxxQywx> list = bdBsdtBsdtXsqxjxxQywxService.selectBdBsdtBsdtXsqxjxxQywxList(bdBsdtBsdtXsqxjxxQywx);
        ExcelUtil<BdBsdtBsdtXsqxjxxQywx> util = new ExcelUtil<BdBsdtBsdtXsqxjxxQywx>(BdBsdtBsdtXsqxjxxQywx.class);
        return util.exportExcel(list, "xsqxjxx");
    }

    /**
     * 获取本地学生请假信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:xsqxjxx:query')")
    @GetMapping(value = "/{xsqxjxxbh}")
    public AjaxResult getInfo(@PathVariable("xsqxjxxbh") String xsqxjxxbh)
    {
        return AjaxResult.success(bdBsdtBsdtXsqxjxxQywxService.selectBdBsdtBsdtXsqxjxxQywxById(xsqxjxxbh));
    }

    /**
     * 新增本地学生请假信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:xsqxjxx:add')")
    @Log(title = "本地学生请假信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BdBsdtBsdtXsqxjxxQywx bdBsdtBsdtXsqxjxxQywx)
    {
        return toAjax(bdBsdtBsdtXsqxjxxQywxService.insertBdBsdtBsdtXsqxjxxQywx(bdBsdtBsdtXsqxjxxQywx));
    }

    /**
     * 修改本地学生请假信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:xsqxjxx:edit')")
    @Log(title = "本地学生请假信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BdBsdtBsdtXsqxjxxQywx bdBsdtBsdtXsqxjxxQywx)
    {
        return toAjax(bdBsdtBsdtXsqxjxxQywxService.updateBdBsdtBsdtXsqxjxxQywx(bdBsdtBsdtXsqxjxxQywx));
    }

    /**
     * 删除本地学生请假信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:xsqxjxx:remove')")
    @Log(title = "本地学生请假信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{xsqxjxxbhs}")
    public AjaxResult remove(@PathVariable String[] xsqxjxxbhs)
    {
        return toAjax(bdBsdtBsdtXsqxjxxQywxService.deleteBdBsdtBsdtXsqxjxxQywxByIds(xsqxjxxbhs));
    }
}
