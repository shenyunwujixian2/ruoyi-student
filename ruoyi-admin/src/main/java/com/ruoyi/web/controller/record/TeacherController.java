package com.ruoyi.web.controller.record;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;

import com.ruoyi.record.domain.TeacherModel;
import com.ruoyi.record.service.impl.TeacherServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags="4-15、辅导员进出记录")
@RestController
@RequestMapping("/record/teacher")
public class TeacherController extends BaseController{

    @Autowired
    private TeacherServiceImpl teacherService;
    
    //辅导员进出记录
    @ApiOperation("4月15日、辅导员进出记录（秦思沁）")
    @GetMapping("/crlist")
    public TableDataInfo getList(TeacherModel baseModel){

        startPage();

        List<TeacherModel> list = teacherService.getList(baseModel);

        return getDataTable(list);
    }



}
