package com.ruoyi.offline.controller;

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
import com.ruoyi.offline.domain.XgxtXgxtBjfdyxxQywx;
import com.ruoyi.offline.service.IXgxtXgxtBjfdyxxQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学工班级辅导信息Controller
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@RestController
@RequestMapping("/offline/teachFdyInfo")
public class XgxtXgxtBjfdyxxQywxController extends BaseController
{
    @Autowired
    private IXgxtXgxtBjfdyxxQywxService xgxtXgxtBjfdyxxQywxService;

    /**
     * 查询学工班级辅导信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:teachInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(XgxtXgxtBjfdyxxQywx xgxtXgxtBjfdyxxQywx)
    {
        startPage();
        List<XgxtXgxtBjfdyxxQywx> list = xgxtXgxtBjfdyxxQywxService.selectXgxtXgxtBjfdyxxQywxList(xgxtXgxtBjfdyxxQywx);
        return getDataTable(list);
    }


    /**
     * 导出学工班级辅导信息列表
     */
    @PreAuthorize("@ss.hasPermi('offline:teachInfo:export')")
    @Log(title = "学工班级辅导信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(XgxtXgxtBjfdyxxQywx xgxtXgxtBjfdyxxQywx)
    {
        List<XgxtXgxtBjfdyxxQywx> list = xgxtXgxtBjfdyxxQywxService.selectXgxtXgxtBjfdyxxQywxList(xgxtXgxtBjfdyxxQywx);
        ExcelUtil<XgxtXgxtBjfdyxxQywx> util = new ExcelUtil<XgxtXgxtBjfdyxxQywx>(XgxtXgxtBjfdyxxQywx.class);
        return util.exportExcel(list, "teachInfo");
    }

    /**
     * 获取学工班级辅导信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('offline:teachInfo:query')")
    @GetMapping(value = "/{bjxxbh}")
    public AjaxResult getInfo(@PathVariable("bjxxbh") String bjxxbh)
    {
        return AjaxResult.success(xgxtXgxtBjfdyxxQywxService.selectXgxtXgxtBjfdyxxQywxById(bjxxbh));
    }

    /**
     * 新增学工班级辅导信息
     */
    @PreAuthorize("@ss.hasPermi('offline:teachInfo:add')")
    @Log(title = "学工班级辅导信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XgxtXgxtBjfdyxxQywx xgxtXgxtBjfdyxxQywx)
    {
        return toAjax(xgxtXgxtBjfdyxxQywxService.insertXgxtXgxtBjfdyxxQywx(xgxtXgxtBjfdyxxQywx));
    }

    /**
     * 修改学工班级辅导信息
     */
    @PreAuthorize("@ss.hasPermi('offline:teachInfo:edit')")
    @Log(title = "学工班级辅导信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XgxtXgxtBjfdyxxQywx xgxtXgxtBjfdyxxQywx)
    {
        return toAjax(xgxtXgxtBjfdyxxQywxService.updateXgxtXgxtBjfdyxxQywx(xgxtXgxtBjfdyxxQywx));
    }

    /**
     * 删除学工班级辅导信息
     */
    @PreAuthorize("@ss.hasPermi('offline:teachInfo:remove')")
    @Log(title = "学工班级辅导信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{bjxxbhs}")
    public AjaxResult remove(@PathVariable String[] bjxxbhs)
    {
        return toAjax(xgxtXgxtBjfdyxxQywxService.deleteXgxtXgxtBjfdyxxQywxByIds(bjxxbhs));
    }
}
