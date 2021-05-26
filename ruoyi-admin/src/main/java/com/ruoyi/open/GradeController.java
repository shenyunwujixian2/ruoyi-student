package com.ruoyi.open;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.dbbase.domain.BdStudentGread;
import com.ruoyi.dbbase.service.IBdStudentGreadService;
import com.ruoyi.dbbase.service.IBdXgxtXgxtBjfdyxxQywxService;
import com.ruoyi.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  老师同消息查看内容
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@Api(tags="4.1、学校专业信息")
@RestController
@RequestMapping("/open/grade")
public class GradeController extends BaseController
{
    @Autowired
    private IBdStudentGreadService bdStudentGreadService;
    /**
     * 查询学校专业列表
     */
//    @PreAuthorize("@ss.hasPermi('dbbase:gread:listgread')")
    @ApiOperation("4.1.1、学校学院列表")
    @GetMapping("/listgread")
    public TableDataInfo listgread(BdStudentGread bdStudentGread)
    {
        startPage();
        bdStudentGread.setSearchValue("`dwdm`");
        List<BdStudentGread> list = bdStudentGreadService.selectBdStudentGreadGroupZyList(bdStudentGread);
        return getDataTable(list);
    }

    /**
     * 查询学校专业列表
     */
    @ApiOperation("4.1.2、学校的所有年级")
//    @PreAuthorize("@ss.hasPermi('dbbase:gread:list')")
    @GetMapping("/list")
    public TableDataInfo list(BdStudentGread bdStudentGread)
    {
        startPage();
        List<BdStudentGread> list = bdStudentGreadService.selectBdStudentGreadList(bdStudentGread);
        return getDataTable(list);
    }


    @Autowired
    private IBdXgxtXgxtBjfdyxxQywxService bdXgxtXgxtBjfdyxxQywxService;

    @Autowired
    private ISysUserService userService;

//    /**
//     * 批量插入老师信息
//     */
//    @ApiOperation("批量插入老师信息")
////    @PreAuthorize("@ss.hasPermi('system:user:add')")
//    @Log(title = "用户管理", businessType = BusinessType.INSERT)
//    @GetMapping("/insertByTeach")
//    public AjaxResult insertByTeach()
//    {
//        //得到老师列表
//        BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx = new BdXgxtXgxtBjfdyxxQywx();
//        bdXgxtXgxtBjfdyxxQywx.setSearchValue("groupByJZGH");
////        PageHelper.startPage(1,2,"");
//        List<BdXgxtXgxtBjfdyxxQywx> list = bdXgxtXgxtBjfdyxxQywxService.selectBdXgxtXgxtBjfdyxxQywxList(bdXgxtXgxtBjfdyxxQywx);
//        SysUser baseModel = new  SysUser();
//        for (BdXgxtXgxtBjfdyxxQywx oneModel :list){
//            baseModel.setUserName(oneModel.getFdyjzgh());
//            baseModel.setNickName(oneModel.getFdy());
//            baseModel.setPhonenumber(oneModel.getLxdh());
//            baseModel.setPassword(SecurityUtils.encryptPassword("123456"));
//            baseModel.setUserId(0L);
//            userService.insertUser(baseModel);
//        }
////        user.setCreateBy(SecurityUtils.getUsername());
//        return AjaxResult.success("导入成功");
//    }

}
