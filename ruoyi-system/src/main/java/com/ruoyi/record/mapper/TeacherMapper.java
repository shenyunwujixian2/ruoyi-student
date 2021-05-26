package com.ruoyi.record.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.record.domain.TeacherModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author heqinze
 */
@Repository
public interface TeacherMapper  extends BaseMapper<TeacherModel> {


    List<TeacherModel> getList(TeacherModel teacherModel);

}
