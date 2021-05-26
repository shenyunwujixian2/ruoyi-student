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
import com.ruoyi.offline.domain.XgxtXgxtXsqjsqxxQywx;
import com.ruoyi.offline.service.IXgxtXgxtXsqjsqxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生请假申请信息Controller
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@RestController
@RequestMapping("/offline/studentLeave")
public class XgxtXgxtXsqjsqxxQywxController extends BaseController
{
    @Autowired
    private IXgxtXgxtXsqjsqxxQywxService xgxtXgxtXsqjsqxxQywxService;

    /**
     * 查询学生请假申请信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:studentLeave:list')")
    @GetMapping("/list")
    public TableDataInfo list(XgxtXgxtXsqjsqxxQywx xgxtXgxtXsqjsqxxQywx)
    {
        startPage();
        List<XgxtXgxtXsqjsqxxQywx> list = xgxtXgxtXsqjsqxxQywxService.selectXgxtXgxtXsqjsqxxQywxList(xgxtXgxtXsqjsqxxQywx);
        return getDataTable(list);
    }

    /**
     * 导出学生请假申请信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:studentLeave:export')")
    @Log(title = "学生请假申请信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(XgxtXgxtXsqjsqxxQywx xgxtXgxtXsqjsqxxQywx)
    {
        List<XgxtXgxtXsqjsqxxQywx> list = xgxtXgxtXsqjsqxxQywxService.selectXgxtXgxtXsqjsqxxQywxList(xgxtXgxtXsqjsqxxQywx);
        ExcelUtil<XgxtXgxtXsqjsqxxQywx> util = new ExcelUtil<XgxtXgxtXsqjsqxxQywx>(XgxtXgxtXsqjsqxxQywx.class);
        return util.exportExcel(list, "studentLeave");
    }

    /**
     * 获取学生请假申请信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('offline:studentLeave:query')")
    @GetMapping(value = "/{jssj}")
    public AjaxResult getInfo(@PathVariable("jssj") String jssj)
    {
        return AjaxResult.success(xgxtXgxtXsqjsqxxQywxService.selectXgxtXgxtXsqjsqxxQywxById(jssj));
    }

    /**
     * 新增学生请假申请信息
     */
    @PreAuthorize("@ss.hasPermi('offline:studentLeave:add')")
    @Log(title = "学生请假申请信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XgxtXgxtXsqjsqxxQywx xgxtXgxtXsqjsqxxQywx)
    {
        return toAjax(xgxtXgxtXsqjsqxxQywxService.insertXgxtXgxtXsqjsqxxQywx(xgxtXgxtXsqjsqxxQywx));
    }

    /**
     * 修改学生请假申请信息
     */
    @PreAuthorize("@ss.hasPermi('offline:studentLeave:edit')")
    @Log(title = "学生请假申请信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XgxtXgxtXsqjsqxxQywx xgxtXgxtXsqjsqxxQywx)
    {
        return toAjax(xgxtXgxtXsqjsqxxQywxService.updateXgxtXgxtXsqjsqxxQywx(xgxtXgxtXsqjsqxxQywx));
    }

    /**
     * 删除学生请假申请信息
     */
    @PreAuthorize("@ss.hasPermi('offline:studentLeave:remove')")
    @Log(title = "学生请假申请信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{jssjs}")
    public AjaxResult remove(@PathVariable String[] jssjs)
    {
        return toAjax(xgxtXgxtXsqjsqxxQywxService.deleteXgxtXgxtXsqjsqxxQywxByIds(jssjs));
    }
}
