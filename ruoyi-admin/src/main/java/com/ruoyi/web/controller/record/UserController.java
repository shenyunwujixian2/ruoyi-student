package com.ruoyi.web.controller.record;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.record.domain.UserModel;
import com.ruoyi.record.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * 用户信息
 * 
 * @author ruoyi
 */
//@Api(tags="6、用户信息")
@RestController
@RequestMapping("/record/user")
public class UserController extends BaseController
{
    @Autowired
    private UserService userService;

    /**
     *
     * 获取用户列表
     */
//    @ApiOperation("获取用户列表")
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserModel baseModel)
    {
//        HashMap<String,Object> reqMap = new HashMap<>();
//        BeanUtils.copyProperties(baseModel,reqMap);
        HashMap<String,Object> reqMap = (HashMap<String, Object>) BeanUtils.convertBeanToMap(baseModel);
        startPage();
        List<UserModel> depts = userService.getList(reqMap);
        return getDataTable(depts);
    }

    /**
     * 新增打卡用户
     */
//    @ApiOperation("新增用户")
//    @ApiImplicitParam(name = "baseModel", value = "新增详细打卡记录信息", dataType = "UserModel")
    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @Log(title = "详细打卡记录信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@Validated @RequestBody UserModel baseModel)
    {
        baseModel.setCreateBy(SecurityUtils.getUsername());
        baseModel.setUserId(SecurityUtils.getLoginUser().getUser().getUserId().toString());
        return toAjax(userService.add(baseModel));
    }

    /**
     * 修改用户
     */
//    @ApiOperation("修改打卡用户")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="id",value="编号", required=true,paramType="query",dataType="Integer"),
//            @ApiImplicitParam(name="name",value="名称",required=true,paramType="query"),
//            @ApiImplicitParam(name="remark",value="备注",required=false, paramType="query")
//    })
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "详细打卡记录信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody UserModel baseModel)
    {
        if(StrKit.isEmpty(baseModel.getId())){
            return error("id能为空");
        }
        baseModel.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(userService.edit(baseModel));
    }


}
