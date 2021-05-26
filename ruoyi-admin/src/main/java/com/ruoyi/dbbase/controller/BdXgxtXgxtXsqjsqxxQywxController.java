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
import com.ruoyi.dbbase.domain.BdXgxtXgxtXsqjsqxxQywx;
import com.ruoyi.dbbase.service.IBdXgxtXgxtXsqjsqxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生请假申请信息Controller
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
@RestController
@RequestMapping("/dbbase/table7")
public class BdXgxtXgxtXsqjsqxxQywxController extends BaseController
{
    @Autowired
    private IBdXgxtXgxtXsqjsqxxQywxService bdXgxtXgxtXsqjsqxxQywxService;

    /**
     * 查询学生请假申请信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table7:list')")
    @GetMapping("/list")
    public TableDataInfo list(BdXgxtXgxtXsqjsqxxQywx bdXgxtXgxtXsqjsqxxQywx)
    {
        startPage();
        List<BdXgxtXgxtXsqjsqxxQywx> list = bdXgxtXgxtXsqjsqxxQywxService.selectBdXgxtXgxtXsqjsqxxQywxList(bdXgxtXgxtXsqjsqxxQywx);
        return getDataTable(list);
    }

    /**
     * 导出学生请假申请信息列表
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table7:export')")
    @Log(title = "学生请假申请信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BdXgxtXgxtXsqjsqxxQywx bdXgxtXgxtXsqjsqxxQywx)
    {
        List<BdXgxtXgxtXsqjsqxxQywx> list = bdXgxtXgxtXsqjsqxxQywxService.selectBdXgxtXgxtXsqjsqxxQywxList(bdXgxtXgxtXsqjsqxxQywx);
        ExcelUtil<BdXgxtXgxtXsqjsqxxQywx> util = new ExcelUtil<BdXgxtXgxtXsqjsqxxQywx>(BdXgxtXgxtXsqjsqxxQywx.class);
        return util.exportExcel(list, "table7");
    }

    /**
     * 获取学生请假申请信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table7:query')")
    @GetMapping(value = "/{jssj}")
    public AjaxResult getInfo(@PathVariable("jssj") String jssj)
    {
        return AjaxResult.success(bdXgxtXgxtXsqjsqxxQywxService.selectBdXgxtXgxtXsqjsqxxQywxById(jssj));
    }

    /**
     * 新增学生请假申请信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table7:add')")
    @Log(title = "学生请假申请信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BdXgxtXgxtXsqjsqxxQywx bdXgxtXgxtXsqjsqxxQywx)
    {
        return toAjax(bdXgxtXgxtXsqjsqxxQywxService.insertBdXgxtXgxtXsqjsqxxQywx(bdXgxtXgxtXsqjsqxxQywx));
    }

    /**
     * 修改学生请假申请信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table7:edit')")
    @Log(title = "学生请假申请信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BdXgxtXgxtXsqjsqxxQywx bdXgxtXgxtXsqjsqxxQywx)
    {
        return toAjax(bdXgxtXgxtXsqjsqxxQywxService.updateBdXgxtXgxtXsqjsqxxQywx(bdXgxtXgxtXsqjsqxxQywx));
    }

    /**
     * 删除学生请假申请信息
     */
    @PreAuthorize("@ss.hasPermi('dbbase:table7:remove')")
    @Log(title = "学生请假申请信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{jssjs}")
    public AjaxResult remove(@PathVariable String[] jssjs)
    {
        return toAjax(bdXgxtXgxtXsqjsqxxQywxService.deleteBdXgxtXgxtXsqjsqxxQywxByIds(jssjs));
    }
}
