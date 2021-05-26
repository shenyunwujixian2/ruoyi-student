package com.ruoyi.dbbase.service;

import java.util.List;
import com.ruoyi.dbbase.domain.BdStudentGread;

/**
 * 学校专业Service接口
 * 
 * @author ruoyi
 * @date 2021-04-02
 */
public interface IBdStudentGreadService 
{
    /**
     * 查询学校专业
     * 
     * @param id 学校专业ID
     * @return 学校专业
     */
    public BdStudentGread selectBdStudentGreadById(Long id);

    /**
     * 查询学校专业列表
     * 
     * @param bdStudentGread 学校专业
     * @return 学校专业集合
     */
    public List<BdStudentGread> selectBdStudentGreadList(BdStudentGread bdStudentGread);
    /**
     * 查询学校专业列表
     *
     * @param bdStudentGread 学校专业
     * @return 学校专业集合
     */
    public List<BdStudentGread> selectBdStudentGreadGroupZyList(BdStudentGread bdStudentGread);

    /**
     * 新增学校专业
     * 
     * @param bdStudentGread 学校专业
     * @return 结果
     */
    public int insertBdStudentGread(BdStudentGread bdStudentGread);

    /**
     * 修改学校专业
     * 
     * @param bdStudentGread 学校专业
     * @return 结果
     */
    public int updateBdStudentGread(BdStudentGread bdStudentGread);

    /**
     * 批量删除学校专业
     * 
     * @param ids 需要删除的学校专业ID
     * @return 结果
     */
    public int deleteBdStudentGreadByIds(Long[] ids);

    /**
     * 删除学校专业信息
     * 
     * @param id 学校专业ID
     * @return 结果
     */
    public int deleteBdStudentGreadById(Long id);
}
