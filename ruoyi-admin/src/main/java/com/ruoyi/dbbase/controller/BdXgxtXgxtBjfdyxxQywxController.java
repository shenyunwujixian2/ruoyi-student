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
import com.ruoyi.dbbase.domain.BdXgxtXgxtBjfdyxxQywx;
import com.ruoyi.dbbase.service.IBdXgxtXgxtBjfdyxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学工班级辅导信息Controller
 * 
 * @author xiaoafu
 * @date 2021-04-01
 */
@RestController
@RequestMapping("/dbbase/table5")
public class BdXgxtXgxtBjfdyxxQywxController extends BaseController
{
    @Autowired
    private IBdXgxtXgxtBjfdyxxQywxService bdXgxtXgxtBjfdyxxQywxService;

    /**
     * 查询学工班级辅导信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table5:list')")
    @GetMapping("/list")
    public TableDataInfo list(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx)
    {
        startPage();
        List<BdXgxtXgxtBjfdyxxQywx> list = bdXgxtXgxtBjfdyxxQywxService.selectBdXgxtXgxtBjfdyxxQywxList(bdXgxtXgxtBjfdyxxQywx);
        return getDataTable(list);
    }

    /**
     * 导出学工班级辅导信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table5:export')")
    @Log(title = "学工班级辅导信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx)
    {
        List<BdXgxtXgxtBjfdyxxQywx> list = bdXgxtXgxtBjfdyxxQywxService.selectBdXgxtXgxtBjfdyxxQywxList(bdXgxtXgxtBjfdyxxQywx);
        ExcelUtil<BdXgxtXgxtBjfdyxxQywx> util = new ExcelUtil<BdXgxtXgxtBjfdyxxQywx>(BdXgxtXgxtBjfdyxxQywx.class);
        return util.exportExcel(list, "table5");
    }

    /**
     * 获取学工班级辅导信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table5:query')")
    @GetMapping(value = "/{bjxxbh}")
    public AjaxResult getInfo(@PathVariable("bjxxbh") String bjxxbh)
    {
        return AjaxResult.success(bdXgxtXgxtBjfdyxxQywxService.selectBdXgxtXgxtBjfdyxxQywxById(bjxxbh));
    }

    /**
     * 新增学工班级辅导信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table5:add')")
    @Log(title = "学工班级辅导信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx)
    {
        return toAjax(bdXgxtXgxtBjfdyxxQywxService.insertBdXgxtXgxtBjfdyxxQywx(bdXgxtXgxtBjfdyxxQywx));
    }

    /**
     * 修改学工班级辅导信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table5:edit')")
    @Log(title = "学工班级辅导信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx)
    {
        return toAjax(bdXgxtXgxtBjfdyxxQywxService.updateBdXgxtXgxtBjfdyxxQywx(bdXgxtXgxtBjfdyxxQywx));
    }

    /**
     * 删除学工班级辅导信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table5:remove')")
    @Log(title = "学工班级辅导信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{bjxxbhs}")
    public AjaxResult remove(@PathVariable String[] bjxxbhs)
    {
        return toAjax(bdXgxtXgxtBjfdyxxQywxService.deleteBdXgxtXgxtBjfdyxxQywxByIds(bjxxbhs));
    }
}
