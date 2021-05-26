package com.ruoyi.web.controller.record;

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
import com.ruoyi.record.domain.RecordEachTmp;
import com.ruoyi.record.service.IRecordEachTmpService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 业务--临时所有用户进出记录抓取Controller
 * 
 * @author xiaoafu
 * @date 2021-04-13
 */
@RestController
@RequestMapping("/record/echotmp")
public class RecordEachTmpController extends BaseController
{
    @Autowired
    private IRecordEachTmpService recordEachTmpService;

    /**
     * 查询业务--临时所有用户进出记录抓取列表
     */
    @PreAuthorize("@ss.hasPermi('record:echotmp:list')")
    @GetMapping("/list")
    public TableDataInfo list(RecordEachTmp recordEachTmp)
    {
        startPage();
        List<RecordEachTmp> list = recordEachTmpService.selectRecordEachTmpList(recordEachTmp);
        return getDataTable(list);
    }

    /**
     * 导出业务--临时所有用户进出记录抓取列表
     */
    @PreAuthorize("@ss.hasPermi('record:echotmp:export')")
    @Log(title = "业务--临时所有用户进出记录抓取", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RecordEachTmp recordEachTmp)
    {
        List<RecordEachTmp> list = recordEachTmpService.selectRecordEachTmpList(recordEachTmp);
        ExcelUtil<RecordEachTmp> util = new ExcelUtil<RecordEachTmp>(RecordEachTmp.class);
        return util.exportExcel(list, "echotmp");
    }

    /**
     * 获取业务--临时所有用户进出记录抓取详细信息
     */
    @PreAuthorize("@ss.hasPermi('record:echotmp:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(recordEachTmpService.selectRecordEachTmpById(id));
    }

    /**
     * 新增业务--临时所有用户进出记录抓取
     */
    @PreAuthorize("@ss.hasPermi('record:echotmp:add')")
    @Log(title = "业务--临时所有用户进出记录抓取", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RecordEachTmp recordEachTmp)
    {
        return toAjax(recordEachTmpService.insertRecordEachTmp(recordEachTmp));
    }

    /**
     * 修改业务--临时所有用户进出记录抓取
     */
    @PreAuthorize("@ss.hasPermi('record:echotmp:edit')")
    @Log(title = "业务--临时所有用户进出记录抓取", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RecordEachTmp recordEachTmp)
    {
        return toAjax(recordEachTmpService.updateRecordEachTmp(recordEachTmp));
    }

    /**
     * 删除业务--临时所有用户进出记录抓取
     */
    @PreAuthorize("@ss.hasPermi('record:echotmp:remove')")
    @Log(title = "业务--临时所有用户进出记录抓取", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(recordEachTmpService.deleteRecordEachTmpByIds(ids));
    }
}
