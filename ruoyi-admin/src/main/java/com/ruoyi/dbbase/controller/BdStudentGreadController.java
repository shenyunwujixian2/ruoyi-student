package com.ruoyi.dbbase.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.dbbase.domain.BdStudentGread;
import com.ruoyi.dbbase.service.IBdStudentGreadService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学校专业Controller
 * 
 * @author ruoyi
 * @date 2021-04-02
 */
@RestController
@RequestMapping("/dbbase/gread")
public class BdStudentGreadController extends BaseController
{
    @Autowired
    private IBdStudentGreadService bdStudentGreadService;
    /**
     * 查询学校专业列表
     */
//    @PreAuthorize("@ss.hasPermi('dbbase:gread:listgread')")
    @GetMapping("/listgread")
    public TableDataInfo listgread(BdStudentGread bdStudentGread)
    {
        startPage();
        List<BdStudentGread> list = bdStudentGreadService.selectBdStudentGreadGroupZyList(bdStudentGread);
        return getDataTable(list);
    }

    /**
     * 查询学校专业列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:gread:list')")
    @GetMapping("/list")
    public TableDataInfo list(BdStudentGread bdStudentGread)
    {
        startPage();
        List<BdStudentGread> list = bdStudentGreadService.selectBdStudentGreadList(bdStudentGread);
        return getDataTable(list);
    }

    /**
     * 导出学校专业列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:gread:export')")
    @Log(title = "学校专业", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BdStudentGread bdStudentGread)
    {
        List<BdStudentGread> list = bdStudentGreadService.selectBdStudentGreadList(bdStudentGread);
        ExcelUtil<BdStudentGread> util = new ExcelUtil<BdStudentGread>(BdStudentGread.class);
        return util.exportExcel(list, "gread");
    }

    /**
     * 获取学校专业详细信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:gread:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(bdStudentGreadService.selectBdStudentGreadById(id));
    }

    /**
     * 新增学校专业
     */
    @PreAuthorize("@ss.hasPermi('dbbase:gread:add')")
    @Log(title = "学校专业", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BdStudentGread bdStudentGread)
    {
        return toAjax(bdStudentGreadService.insertBdStudentGread(bdStudentGread));
    }

    /**
     * 修改学校专业
     */
    @PreAuthorize("@ss.hasPermi('dbbase:gread:edit')")
    @Log(title = "学校专业", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BdStudentGread bdStudentGread)
    {
        return toAjax(bdStudentGreadService.updateBdStudentGread(bdStudentGread));
    }

    /**
     * 删除学校专业
     */
    @PreAuthorize("@ss.hasPermi('dbbase:gread:remove')")
    @Log(title = "学校专业", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bdStudentGreadService.deleteBdStudentGreadByIds(ids));
    }
}
