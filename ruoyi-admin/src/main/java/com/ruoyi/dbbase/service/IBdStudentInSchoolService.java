package com.ruoyi.dbbase.service;

import java.util.List;
import com.ruoyi.dbbase.domain.BdStudentInSchool;

/**
 * 学校入住学生（要使用）Service接口
 * 
 * @author xiaoafu
 * @date 2021-04-07
 */
public interface IBdStudentInSchoolService 
{
    /**
     * 查询学校入住学生（要使用）
     * 
     * @param xh 学校入住学生（要使用）ID
     * @return 学校入住学生（要使用）
     */
    public BdStudentInSchool selectBdStudentInSchoolById(String xh);

    /**
     * 查询学校入住学生（要使用）列表
     * 
     * @param bdStudentInSchool 学校入住学生（要使用）
     * @return 学校入住学生（要使用）集合
     */
    public List<BdStudentInSchool> selectBdStudentInSchoolList(BdStudentInSchool bdStudentInSchool);

    /**
     * 新增学校入住学生（要使用）
     * 
     * @param bdStudentInSchool 学校入住学生（要使用）
     * @return 结果
     */
    public int insertBdStudentInSchool(BdStudentInSchool bdStudentInSchool);

    /**
     * 修改学校入住学生（要使用）
     * 
     * @param bdStudentInSchool 学校入住学生（要使用）
     * @return 结果
     */
    public int updateBdStudentInSchool(BdStudentInSchool bdStudentInSchool);

    /**
     * 批量删除学校入住学生（要使用）
     * 
     * @param xhs 需要删除的学校入住学生（要使用）ID
     * @return 结果
     */
    public int deleteBdStudentInSchoolByIds(String[] xhs);

    /**
     * 删除学校入住学生（要使用）信息
     * 
     * @param xh 学校入住学生（要使用）ID
     * @return 结果
     */
    public int deleteBdStudentInSchoolById(String xh);
}
