package com.ruoyi.web.controller.record;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.record.domain.EachInfoModel;
import com.ruoyi.record.domain.GradesModel;
import com.ruoyi.record.service.EachInfoService;
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

/**
 * 详细记录信息
 *
 * @author ruoyi
 */
@Api(tags="4-10、出入详细记录信息")
@RestController
@RequestMapping("/record/eachinfo")
public class EachInfoController extends BaseController
{
    @Autowired
    private EachInfoService eachInfoService;

    @Autowired
    private TokenService tokenService;

    /**
     *
     * 获取详细记录列表
     */
    @ApiOperation("4-10、获取打卡详细记录列表（传入personCode获取该用户）")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value="学生学号", required=true,paramType="query",dataType="String"),
        @ApiImplicitParam(name="dateStart",value="开始时间（年月日 ）",paramType="query"),
        @ApiImplicitParam(name="dateEnd",value="结束时间（年月日 ）", paramType="query")
    })
//    @PreAuthorize("@ss.hasPermi('system:eachinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(EachInfoModel baseModel)
    {
        HashMap<String,Object> reqMap = (HashMap<String, Object>) BeanUtils.convertBeanToMap(baseModel);
        startPage();
        List<EachInfoModel> mList = eachInfoService.getList(reqMap);
        return getDataTable(mList);
    }

    /**
     * 导出学生晚归迟到记录列表
     */
//    @ApiOperation("4月15日、到处详细出入记录")
//    @PreAuthorize("@ss.hasPermi('late:late:export')")
//    @Log(title = "学生晚归迟到记录", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
    public AjaxResult export(EachInfoModel baseModel) {
        HashMap<String,Object> reqMap = (HashMap<String, Object>) BeanUtils.convertBeanToMap(baseModel);
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        if(!roleIds.equals(100L)){
            reqMap.put("teachId", loginUser.getUsername());
        }
        String dwdm = "";
        if(roleIds.equals(110L)){
//            teachId = "";
            dwdm = loginUser.getUser().getRemark()+"";
        }

        startPage();
        List<EachInfoModel> mList = eachInfoService.getList(reqMap);
        ExcelUtil<EachInfoModel> util = new ExcelUtil<EachInfoModel>(EachInfoModel.class);
        return util.exportExcel(mList, "出入详细记录");
    }

    /**
     * 新增打卡详细记录
     */
//    @ApiOperation("新增详细记录")
//    @ApiImplicitParam(name = "baseModel", value = "新增详细打卡记录信息", dataType = "GradesModel")
    @PreAuthorize("@ss.hasPermi('system:eachinfo:add')")
    @Log(title = "详细打卡记录信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@Validated @RequestBody EachInfoModel baseModel)
    {
        baseModel.setCreateBy(SecurityUtils.getUsername());
        baseModel.setUserId(SecurityUtils.getLoginUser().getUser().getUserId().toString());
        return toAjax(eachInfoService.add(baseModel));
    }

    /**
     * 修改详细记录
     */
//    @ApiOperation("修改打卡详细记录")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="id",value="编号", required=true,paramType="query",dataType="Integer"),
//            @ApiImplicitParam(name="name",value="名称",required=true,paramType="query"),
//            @ApiImplicitParam(name="remark",value="备注",required=false, paramType="query")
//    })
    @PreAuthorize("@ss.hasPermi('system:eachinfo:edit')")
    @Log(title = "详细打卡记录信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody EachInfoModel baseModel)
    {
        if(StrKit.isEmpty(baseModel.getId())){
            return error("id能为空");
        }
        baseModel.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(eachInfoService.edit(baseModel));
    }


}
