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
import com.ruoyi.offline.domain.BsdtBsdtXsqxjxxQywx;
import com.ruoyi.offline.service.IBsdtBsdtXsqxjxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生请假信息Controller
 * 
 * @author xiaoafu
 * @date 2021-04-16
 */
@RestController
@RequestMapping("/offline/xsqxjxx")
public class BsdtBsdtXsqxjxxQywxController extends BaseController
{
    @Autowired
    private IBsdtBsdtXsqxjxxQywxService bsdtBsdtXsqxjxxQywxService;

    /**
     * 查询学生请假信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:xsqxjxx:list')")
    @GetMapping("/list")
    public TableDataInfo list(BsdtBsdtXsqxjxxQywx bsdtBsdtXsqxjxxQywx)
    {
        startPage();
        List<BsdtBsdtXsqxjxxQywx> list = bsdtBsdtXsqxjxxQywxService.selectBsdtBsdtXsqxjxxQywxList(bsdtBsdtXsqxjxxQywx);
        return getDataTable(list);
    }

    /**
     * 导出学生请假信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:xsqxjxx:export')")
    @Log(title = "学生请假信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BsdtBsdtXsqxjxxQywx bsdtBsdtXsqxjxxQywx)
    {
        List<BsdtBsdtXsqxjxxQywx> list = bsdtBsdtXsqxjxxQywxService.selectBsdtBsdtXsqxjxxQywxList(bsdtBsdtXsqxjxxQywx);
        ExcelUtil<BsdtBsdtXsqxjxxQywx> util = new ExcelUtil<BsdtBsdtXsqxjxxQywx>(BsdtBsdtXsqxjxxQywx.class);
        return util.exportExcel(list, "xsqxjxx");
    }

    /**
     * 获取学生请假信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('offline:xsqxjxx:query')")
    @GetMapping(value = "/{xsqxjxxbh}")
    public AjaxResult getInfo(@PathVariable("xsqxjxxbh") String xsqxjxxbh)
    {
        return AjaxResult.success(bsdtBsdtXsqxjxxQywxService.selectBsdtBsdtXsqxjxxQywxById(xsqxjxxbh));
    }

    /**
     * 新增学生请假信息
     */
    @PreAuthorize("@ss.hasPermi('offline:xsqxjxx:add')")
    @Log(title = "学生请假信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BsdtBsdtXsqxjxxQywx bsdtBsdtXsqxjxxQywx)
    {
        return toAjax(bsdtBsdtXsqxjxxQywxService.insertBsdtBsdtXsqxjxxQywx(bsdtBsdtXsqxjxxQywx));
    }

    /**
     * 修改学生请假信息
     */
    @PreAuthorize("@ss.hasPermi('offline:xsqxjxx:edit')")
    @Log(title = "学生请假信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BsdtBsdtXsqxjxxQywx bsdtBsdtXsqxjxxQywx)
    {
        return toAjax(bsdtBsdtXsqxjxxQywxService.updateBsdtBsdtXsqxjxxQywx(bsdtBsdtXsqxjxxQywx));
    }

    /**
     * 删除学生请假信息
     */
    @PreAuthorize("@ss.hasPermi('offline:xsqxjxx:remove')")
    @Log(title = "学生请假信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{xsqxjxxbhs}")
    public AjaxResult remove(@PathVariable String[] xsqxjxxbhs)
    {
        return toAjax(bsdtBsdtXsqxjxxQywxService.deleteBsdtBsdtXsqxjxxQywxByIds(xsqxjxxbhs));
    }
}
