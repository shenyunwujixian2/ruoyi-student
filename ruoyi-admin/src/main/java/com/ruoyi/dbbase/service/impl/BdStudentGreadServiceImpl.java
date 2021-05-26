package com.ruoyi.dbbase.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dbbase.mapper.BdStudentGreadMapper;
import com.ruoyi.dbbase.domain.BdStudentGread;
import com.ruoyi.dbbase.service.IBdStudentGreadService;

/**
 * 学校专业Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-02
 */
@Service
public class BdStudentGreadServiceImpl implements IBdStudentGreadService 
{
    @Autowired
    private BdStudentGreadMapper bdStudentGreadMapper;

    /**
     * 查询学校专业
     * 
     * @param id 学校专业ID
     * @return 学校专业
     */
    @Override
    public BdStudentGread selectBdStudentGreadById(Long id)
    {
        return bdStudentGreadMapper.selectBdStudentGreadById(id);
    }

    /**
     * 查询学校专业列表
     * 
     * @param bdStudentGread 学校专业
     * @return 学校专业
     */
    @Override
    public List<BdStudentGread> selectBdStudentGreadList(BdStudentGread bdStudentGread)
    {
        return bdStudentGreadMapper.selectBdStudentGreadList(bdStudentGread);
    }
    /**
     * 查询学校专业列表
     *
     * @param bdStudentGread 学校专业
     * @return 学校专业
     */
    @Override
    public List<BdStudentGread> selectBdStudentGreadGroupZyList(BdStudentGread bdStudentGread)
    {
        return bdStudentGreadMapper.selectBdStudentGreadGroupZyList(bdStudentGread);
    }

    /**
     * 新增学校专业
     * 
     * @param bdStudentGread 学校专业
     * @return 结果
     */
    @Override
    public int insertBdStudentGread(BdStudentGread bdStudentGread)
    {
        bdStudentGread.setCreateTime(DateUtils.getNowDate());
        return bdStudentGreadMapper.insertBdStudentGread(bdStudentGread);
    }

    /**
     * 修改学校专业
     * 
     * @param bdStudentGread 学校专业
     * @return 结果
     */
    @Override
    public int updateBdStudentGread(BdStudentGread bdStudentGread)
    {
        bdStudentGread.setUpdateTime(DateUtils.getNowDate());
        return bdStudentGreadMapper.updateBdStudentGread(bdStudentGread);
    }

    /**
     * 批量删除学校专业
     * 
     * @param ids 需要删除的学校专业ID
     * @return 结果
     */
    @Override
    public int deleteBdStudentGreadByIds(Long[] ids)
    {
        return bdStudentGreadMapper.deleteBdStudentGreadByIds(ids);
    }

    /**
     * 删除学校专业信息
     * 
     * @param id 学校专业ID
     * @return 结果
     */
    @Override
    public int deleteBdStudentGreadById(Long id)
    {
        return bdStudentGreadMapper.deleteBdStudentGreadById(id);
    }
}
