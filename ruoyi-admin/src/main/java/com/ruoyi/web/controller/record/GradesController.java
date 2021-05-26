package com.ruoyi.web.controller.record;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.record.domain.GradesModel;
import com.ruoyi.record.service.GradesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 年级信息
 * 
 * @author ruoyi
 */
//@Api(tags="5、年级信息")
@RestController
@RequestMapping("/record/grades")
public class GradesController extends BaseController
{
    @Autowired
    private GradesService gradesService;

    /**
     *
     *
     * 获取年级列表
     */
//    @ApiOperation("获取年级列表")
    @PreAuthorize("@ss.hasPermi('system:grades:list')")
    @GetMapping("/list")
    public TableDataInfo list(GradesModel baseModel)
    {
        HashMap<String,Object> reqMap = (HashMap<String, Object>) BeanUtils.convertBeanToMap(baseModel);
        startPage();
        List<GradesModel> depts = gradesService.getList(reqMap);
        return getDataTable(depts);
    }

    /**
     * 新增年级
     */
//    @ApiOperation("新增年级")
//    @ApiImplicitParam(name = "baseModel", value = "新增年级信息", dataType = "GradesModel")
    @PreAuthorize("@ss.hasPermi('system:grades:add')")
    @Log(title = "年级信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@Validated @RequestBody GradesModel baseModel)
    {
        baseModel.setCreateBy(SecurityUtils.getUsername());
        baseModel.setUserId(SecurityUtils.getLoginUser().getUser().getUserId().toString());
        return toAjax(gradesService.add(baseModel));
    }

    /**
     * 修改年级
     */
//    @ApiOperation("修改年级")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="id",value="编号", required=true,paramType="query",dataType="Integer"),
//            @ApiImplicitParam(name="name",value="名称",required=true,paramType="query"),
//            @ApiImplicitParam(name="remark",value="备注",required=false, paramType="query")
//    })
    @PreAuthorize("@ss.hasPermi('system:grades:edit')")
    @Log(title = "年级信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody GradesModel baseModel)
    {
        if(StrKit.isEmpty(baseModel.getId())){
            return error("id能为空");
        }
        baseModel.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(gradesService.edit(baseModel));
    }


}
