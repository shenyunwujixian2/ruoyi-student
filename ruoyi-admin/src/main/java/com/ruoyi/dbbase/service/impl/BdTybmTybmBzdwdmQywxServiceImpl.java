package com.ruoyi.dbbase.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dbbase.mapper.BdTybmTybmBzdwdmQywxMapper;
import com.ruoyi.dbbase.domain.BdTybmTybmBzdwdmQywx;
import com.ruoyi.dbbase.service.IBdTybmTybmBzdwdmQywxService;

/**
 * 学校部门Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
@Service
public class BdTybmTybmBzdwdmQywxServiceImpl implements IBdTybmTybmBzdwdmQywxService 
{
    @Autowired
    private BdTybmTybmBzdwdmQywxMapper bdTybmTybmBzdwdmQywxMapper;

    /**
     * 查询学校部门
     * 
     * @param sjbmdm 学校部门ID
     * @return 学校部门
     */
    @Override
    public BdTybmTybmBzdwdmQywx selectBdTybmTybmBzdwdmQywxById(String sjbmdm)
    {
        return bdTybmTybmBzdwdmQywxMapper.selectBdTybmTybmBzdwdmQywxById(sjbmdm);
    }

    /**
     * 查询学校部门列表
     * 
     * @param bdTybmTybmBzdwdmQywx 学校部门
     * @return 学校部门
     */
    @Override
    public List<BdTybmTybmBzdwdmQywx> selectBdTybmTybmBzdwdmQywxList(BdTybmTybmBzdwdmQywx bdTybmTybmBzdwdmQywx)
    {
        return bdTybmTybmBzdwdmQywxMapper.selectBdTybmTybmBzdwdmQywxList(bdTybmTybmBzdwdmQywx);
    }

    /**
     * 新增学校部门
     * 
     * @param bdTybmTybmBzdwdmQywx 学校部门
     * @return 结果
     */
    @Override
    public int insertBdTybmTybmBzdwdmQywx(BdTybmTybmBzdwdmQywx bdTybmTybmBzdwdmQywx)
    {
        return bdTybmTybmBzdwdmQywxMapper.insertBdTybmTybmBzdwdmQywx(bdTybmTybmBzdwdmQywx);
    }

    /**
     * 修改学校部门
     * 
     * @param bdTybmTybmBzdwdmQywx 学校部门
     * @return 结果
     */
    @Override
    public int updateBdTybmTybmBzdwdmQywx(BdTybmTybmBzdwdmQywx bdTybmTybmBzdwdmQywx)
    {
        return bdTybmTybmBzdwdmQywxMapper.updateBdTybmTybmBzdwdmQywx(bdTybmTybmBzdwdmQywx);
    }

    /**
     * 批量删除学校部门
     * 
     * @param sjbmdms 需要删除的学校部门ID
     * @return 结果
     */
    @Override
    public int deleteBdTybmTybmBzdwdmQywxByIds(String[] sjbmdms)
    {
        return bdTybmTybmBzdwdmQywxMapper.deleteBdTybmTybmBzdwdmQywxByIds(sjbmdms);
    }

    /**
     * 删除学校部门信息
     * 
     * @param sjbmdm 学校部门ID
     * @return 结果
     */
    @Override
    public int deleteBdTybmTybmBzdwdmQywxById(String sjbmdm)
    {
        return bdTybmTybmBzdwdmQywxMapper.deleteBdTybmTybmBzdwdmQywxById(sjbmdm);
    }
}
