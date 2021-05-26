package com.ruoyi.record.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.record.domain.TeacherModel;
import java.util.List;

/**
 *
 * @author heqinze
 */
public interface TeacherService extends IService<TeacherModel> {

    //查单条
    TeacherModel  getOne();

    //查全部记录
    List<TeacherModel> getList(TeacherModel baseModel);
}
