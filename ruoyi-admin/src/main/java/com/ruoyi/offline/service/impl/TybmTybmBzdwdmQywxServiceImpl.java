package com.ruoyi.offline.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.offline.mapper.TybmTybmBzdwdmQywxMapper;
import com.ruoyi.offline.domain.TybmTybmBzdwdmQywx;
import com.ruoyi.offline.service.ITybmTybmBzdwdmQywxService;

/**
 * 学校部门Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class TybmTybmBzdwdmQywxServiceImpl implements ITybmTybmBzdwdmQywxService 
{
    @Autowired
    private TybmTybmBzdwdmQywxMapper tybmTybmBzdwdmQywxMapper;

    /**
     * 查询学校部门
     * 
     * @param sjbmdm 学校部门ID
     * @return 学校部门
     */
    @Override
    public TybmTybmBzdwdmQywx selectTybmTybmBzdwdmQywxById(String sjbmdm)
    {
        return tybmTybmBzdwdmQywxMapper.selectTybmTybmBzdwdmQywxById(sjbmdm);
    }

    /**
     * 查询学校部门列表
     * 
     * @param tybmTybmBzdwdmQywx 学校部门
     * @return 学校部门
     */
    @Override
    public List<TybmTybmBzdwdmQywx> selectTybmTybmBzdwdmQywxList(TybmTybmBzdwdmQywx tybmTybmBzdwdmQywx)
    {
        return tybmTybmBzdwdmQywxMapper.selectTybmTybmBzdwdmQywxList(tybmTybmBzdwdmQywx);
    }

    /**
     * 新增学校部门
     * 
     * @param tybmTybmBzdwdmQywx 学校部门
     * @return 结果
     */
    @Override
    public int insertTybmTybmBzdwdmQywx(TybmTybmBzdwdmQywx tybmTybmBzdwdmQywx)
    {
        return tybmTybmBzdwdmQywxMapper.insertTybmTybmBzdwdmQywx(tybmTybmBzdwdmQywx);
    }

    /**
     * 修改学校部门
     * 
     * @param tybmTybmBzdwdmQywx 学校部门
     * @return 结果
     */
    @Override
    public int updateTybmTybmBzdwdmQywx(TybmTybmBzdwdmQywx tybmTybmBzdwdmQywx)
    {
        return tybmTybmBzdwdmQywxMapper.updateTybmTybmBzdwdmQywx(tybmTybmBzdwdmQywx);
    }

    /**
     * 批量删除学校部门
     * 
     * @param sjbmdms 需要删除的学校部门ID
     * @return 结果
     */
    @Override
    public int deleteTybmTybmBzdwdmQywxByIds(String[] sjbmdms)
    {
        return tybmTybmBzdwdmQywxMapper.deleteTybmTybmBzdwdmQywxByIds(sjbmdms);
    }

    /**
     * 删除学校部门信息
     * 
     * @param sjbmdm 学校部门ID
     * @return 结果
     */
    @Override
    public int deleteTybmTybmBzdwdmQywxById(String sjbmdm)
    {
        return tybmTybmBzdwdmQywxMapper.deleteTybmTybmBzdwdmQywxById(sjbmdm);
    }
}
