package com.ruoyi.dbbase.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dbbase.mapper.BdStudentInSchoolMapper;
import com.ruoyi.dbbase.domain.BdStudentInSchool;
import com.ruoyi.dbbase.service.IBdStudentInSchoolService;

/**
 * 学校入住学生（要使用）Service业务层处理
 * 
 * @author xiaoafu
 * @date 2021-04-07
 */
@Service
public class BdStudentInSchoolServiceImpl implements IBdStudentInSchoolService 
{
    @Autowired
    private BdStudentInSchoolMapper bdStudentInSchoolMapper;

    /**
     * 查询学校入住学生（要使用）
     * 
     * @param xh 学校入住学生（要使用）ID
     * @return 学校入住学生（要使用）
     */
    @Override
    public BdStudentInSchool selectBdStudentInSchoolById(String xh)
    {
        return bdStudentInSchoolMapper.selectBdStudentInSchoolById(xh);
    }

    /**
     * 查询学校入住学生（要使用）列表
     * 
     * @param bdStudentInSchool 学校入住学生（要使用）
     * @return 学校入住学生（要使用）
     */
    @Override
    public List<BdStudentInSchool> selectBdStudentInSchoolList(BdStudentInSchool bdStudentInSchool)
    {
        return bdStudentInSchoolMapper.selectBdStudentInSchoolList(bdStudentInSchool);
    }

    /**
     * 新增学校入住学生（要使用）
     * 
     * @param bdStudentInSchool 学校入住学生（要使用）
     * @return 结果
     */
    @Override
    public int insertBdStudentInSchool(BdStudentInSchool bdStudentInSchool)
    {
        return bdStudentInSchoolMapper.insertBdStudentInSchool(bdStudentInSchool);
    }

    /**
     * 修改学校入住学生（要使用）
     * 
     * @param bdStudentInSchool 学校入住学生（要使用）
     * @return 结果
     */
    @Override
    public int updateBdStudentInSchool(BdStudentInSchool bdStudentInSchool)
    {
        return bdStudentInSchoolMapper.updateBdStudentInSchool(bdStudentInSchool);
    }

    /**
     * 批量删除学校入住学生（要使用）
     * 
     * @param xhs 需要删除的学校入住学生（要使用）ID
     * @return 结果
     */
    @Override
    public int deleteBdStudentInSchoolByIds(String[] xhs)
    {
        return bdStudentInSchoolMapper.deleteBdStudentInSchoolByIds(xhs);
    }

    /**
     * 删除学校入住学生（要使用）信息
     * 
     * @param xh 学校入住学生（要使用）ID
     * @return 结果
     */
    @Override
    public int deleteBdStudentInSchoolById(String xh)
    {
        return bdStudentInSchoolMapper.deleteBdStudentInSchoolById(xh);
    }
}
