package com.ruoyi.web.controller.record;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StrKit;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.service.EachDayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 每日记录信息
 *
 * @author ruoyi
 */
@Api(tags="3、每日出入记录信息")
@RestController
@RequestMapping("/record/eachday")
public class EachDayController extends BaseController
{
    @Autowired
    private EachDayService eachDayService;
    @Autowired
    private TokenService tokenService;
    /**
     *
     *
     * 获取每日记录列表
     */
    @ApiOperation("4-10、获取每日记录列表")
//    @PreAuthorize("@ss.hasPermi('system:eachday:list')")
    @GetMapping("/list")
    public TableDataInfo list(EachDayModel baseModel)
    {
        HashMap<String,Object> reqMap = (HashMap<String, Object>) BeanUtils.convertBeanToMap(baseModel);
        startPage();
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        if(!roleIds.equals(100L)){
            reqMap.put("teachId",loginUser.getUsername());
        }
        String dwdm = "";
        if(roleIds.equals(110L)){
            dwdm = loginUser.getUser().getRemark()+"";
            reqMap.put("teachId", null);
            reqMap.put("dwdm", dwdm);
        }

        List<EachDayModel> mList = eachDayService.getList(reqMap);
        return getDataTable(mList);
    }

    /**
     * 获取每日未产生记录列表
     */
    @ApiOperation("4-16、获取每日未产生记录列表")
//    @PreAuthorize("@ss.hasPermi('system:eachday:list')")
    @GetMapping("/listnopass")
    public TableDataInfo listnopass(EachDayModel baseModel)
    {
        if(StrKit.isEmpty(baseModel.getShowTime())){
            TableDataInfo rspData = new TableDataInfo();
            rspData.setCode(HttpStatus.ERROR);
            rspData.setMsg("查询时间不能空");
            return rspData;
        }
        HashMap<String,Object> reqMap = (HashMap<String, Object>) BeanUtils.convertBeanToMap(baseModel);
        startPage();
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        if(!roleIds.equals(100L)){
            reqMap.put("teachId",loginUser.getUsername());
        }
        String dwdm = "";
        if(roleIds.equals(110L)){
            dwdm = loginUser.getUser().getRemark()+"";
            reqMap.put("teachId", null);
            reqMap.put("dwdm", dwdm);
        }
        reqMap.put("startshowTime",null);
        reqMap.put("endshowTime",null);
        reqMap.put("searchPassIsNull","1");
        List<EachDayModel> mList = eachDayService.getList(reqMap);
        return getDataTable(mList);
    }

    /**
     * 获取每日进入寝室超过24小时
     */
    @ApiOperation("4-19、获取每日进入寝室超过24小时未出")
//    @PreAuthorize("@ss.hasPermi('system:eachday:list')")
    @GetMapping("/listnooutmore24")
    public TableDataInfo listnooutmore24(EachDayModel baseModel)
    {
        if(StrKit.isEmpty(baseModel.getShowTime())){
            TableDataInfo rspData = new TableDataInfo();
            rspData.setCode(HttpStatus.ERROR);
            rspData.setMsg("查询时间不能空");
            return rspData;
        }
        HashMap<String,Object> reqMap = (HashMap<String, Object>) BeanUtils.convertBeanToMap(baseModel);
        startPage();
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        if(!roleIds.equals(100L)){
            reqMap.put("teachId",loginUser.getUsername());
        }
        String dwdm = "";
        if(roleIds.equals(110L)){
            dwdm = loginUser.getUser().getRemark()+"";
            reqMap.put("teachId", null);
            reqMap.put("dwdm", dwdm);
        }
        reqMap.put("startshowTime",null);
        reqMap.put("endshowTime",null);
        reqMap.put("searchPassIsNull","1");
        reqMap.put("lastInorout","1"); //最后状态为进入
        reqMap.put("searchPassTimeBig24",DateUtils.getBeforeDateStr("yyyy-MM-dd HH:mm:ss", new Date()));  //当前时间的前24小时
        List<EachDayModel> mList = eachDayService.getList(reqMap);
        return getDataTable(mList);
    }

    /**
     * 新增每日记录
     */
//    @ApiOperation("新增每日记录")
//    @ApiImplicitParam(name = "baseModel", value = "新增每日记录信息", dataType = "GradesModel")
    @PreAuthorize("@ss.hasPermi('system:eachday:add')")
    @Log(title = "每日记录信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@Validated @RequestBody EachDayModel baseModel)
    {
        baseModel.setCreateBy(SecurityUtils.getUsername());
        baseModel.setUserId(SecurityUtils.getLoginUser().getUser().getUserId().toString());
        return toAjax(eachDayService.add(baseModel));
    }

    /**
     * 修改每日记录
     */
//    @ApiOperation("修改每日记录")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="id",value="编号", required=true,paramType="query"),
//            @ApiImplicitParam(name="name",value="名称",required=true,paramType="query"),
//            @ApiImplicitParam(name="remark",value="备注",required=false, paramType="query",dataType="Integer")
//    })
    @PreAuthorize("@ss.hasPermi('system:eachday:edit')")
    @Log(title = "每日记录信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody EachDayModel baseModel)
    {
        if(StrKit.isEmpty(baseModel.getId())){
            return error("id能为空");
        }
        baseModel.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(eachDayService.edit(baseModel));
    }


}
