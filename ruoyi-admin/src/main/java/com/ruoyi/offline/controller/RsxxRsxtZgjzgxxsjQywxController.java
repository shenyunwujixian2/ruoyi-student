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
import com.ruoyi.offline.domain.RsxxRsxtZgjzgxxsjQywx;
import com.ruoyi.offline.service.IRsxxRsxtZgjzgxxsjQywxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 在岗教职工线下数据Controller
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
//@Api(tags="11.1、在岗教职工线下数据信息")
@RestController
@RequestMapping("/offline/teachInfo")
public class RsxxRsxtZgjzgxxsjQywxController extends BaseController
{
    @Autowired
    private IRsxxRsxtZgjzgxxsjQywxService rsxxRsxtZgjzgxxsjQywxService;

    /**
     * 查询在岗教职工线下数据列表
     */
//    @ApiOperation("在岗教职工线下数据列表")
    @PreAuthorize("@ss.hasPermi('offline:teachInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(RsxxRsxtZgjzgxxsjQywx rsxxRsxtZgjzgxxsjQywx)
    {
        startPage();
        List<RsxxRsxtZgjzgxxsjQywx> list = rsxxRsxtZgjzgxxsjQywxService.selectRsxxRsxtZgjzgxxsjQywxList(rsxxRsxtZgjzgxxsjQywx);
        return getDataTable(list);
    }

    /**
     * 导出在岗教职工线下数据列表
     */
    @PreAuthorize("@ss.hasPermi('offline:teachInfo:export')")
    @Log(title = "在岗教职工线下数据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RsxxRsxtZgjzgxxsjQywx rsxxRsxtZgjzgxxsjQywx)
    {
        List<RsxxRsxtZgjzgxxsjQywx> list = rsxxRsxtZgjzgxxsjQywxService.selectRsxxRsxtZgjzgxxsjQywxList(rsxxRsxtZgjzgxxsjQywx);
        ExcelUtil<RsxxRsxtZgjzgxxsjQywx> util = new ExcelUtil<RsxxRsxtZgjzgxxsjQywx>(RsxxRsxtZgjzgxxsjQywx.class);
        return util.exportExcel(list, "teachInfo");
    }

    /**
     * 获取在岗教职工线下数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('offline:teachInfo:query')")
    @GetMapping(value = "/{jzgh}")
    public AjaxResult getInfo(@PathVariable("jzgh") String jzgh)
    {
        return AjaxResult.success(rsxxRsxtZgjzgxxsjQywxService.selectRsxxRsxtZgjzgxxsjQywxById(jzgh));
    }

    /**
     * 新增在岗教职工线下数据
     */
    @PreAuthorize("@ss.hasPermi('offline:teachInfo:add')")
    @Log(title = "在岗教职工线下数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RsxxRsxtZgjzgxxsjQywx rsxxRsxtZgjzgxxsjQywx)
    {
        return toAjax(rsxxRsxtZgjzgxxsjQywxService.insertRsxxRsxtZgjzgxxsjQywx(rsxxRsxtZgjzgxxsjQywx));
    }

    /**
     * 修改在岗教职工线下数据
     */
    @PreAuthorize("@ss.hasPermi('offline:teachInfo:edit')")
    @Log(title = "在岗教职工线下数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RsxxRsxtZgjzgxxsjQywx rsxxRsxtZgjzgxxsjQywx)
    {
        return toAjax(rsxxRsxtZgjzgxxsjQywxService.updateRsxxRsxtZgjzgxxsjQywx(rsxxRsxtZgjzgxxsjQywx));
    }

    /**
     * 删除在岗教职工线下数据
     */
    @PreAuthorize("@ss.hasPermi('offline:teachInfo:remove')")
    @Log(title = "在岗教职工线下数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{jzghs}")
    public AjaxResult remove(@PathVariable String[] jzghs)
    {
        return toAjax(rsxxRsxtZgjzgxxsjQywxService.deleteRsxxRsxtZgjzgxxsjQywxByIds(jzghs));
    }
}
