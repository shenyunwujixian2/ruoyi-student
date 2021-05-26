package com.ruoyi.record.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.record.domain.TeacherModel;
import com.ruoyi.record.mapper.TeacherMapper;
import com.ruoyi.record.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author heqinze
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, TeacherModel>implements TeacherService {


    @Override
    //辅导员当天进出记录
    public List<TeacherModel> getList(TeacherModel baseModel) {
//        QueryWrapper<TeacherModel> wrapper = new QueryWrapper<>();
//        //当天0点
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        Date time = calendar.getTime();
//        wrapper.eq("check_status",2).ne("person_code",'-').ge("pass_time",time);

        List<TeacherModel> teacherModels = baseMapper.getList(baseModel);
        return teacherModels;
    }

    @Override
    public TeacherModel getOne() {
        QueryWrapper<TeacherModel> wrapper = new QueryWrapper<>();
        wrapper.eq("id",1);
        TeacherModel teacherModel = baseMapper.selectOne(wrapper);
        return teacherModel;
    }
}
