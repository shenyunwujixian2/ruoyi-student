package com.ruoyi.dbbase.mapper;

import java.util.List;
import com.ruoyi.dbbase.domain.BdTybmTybmBzdwdmQywx;

/**
 * 学校部门Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
public interface BdTybmTybmBzdwdmQywxMapper 
{
    /**
     * 查询学校部门
     * 
     * @param sjbmdm 学校部门ID
     * @return 学校部门
     */
    public BdTybmTybmBzdwdmQywx selectBdTybmTybmBzdwdmQywxById(String sjbmdm);

    /**
     * 查询学校部门列表
     * 
     * @param bdTybmTybmBzdwdmQywx 学校部门
     * @return 学校部门集合
     */
    public List<BdTybmTybmBzdwdmQywx> selectBdTybmTybmBzdwdmQywxList(BdTybmTybmBzdwdmQywx bdTybmTybmBzdwdmQywx);

    /**
     * 新增学校部门
     * 
     * @param bdTybmTybmBzdwdmQywx 学校部门
     * @return 结果
     */
    public int insertBdTybmTybmBzdwdmQywx(BdTybmTybmBzdwdmQywx bdTybmTybmBzdwdmQywx);

    /**
     * 修改学校部门
     * 
     * @param bdTybmTybmBzdwdmQywx 学校部门
     * @return 结果
     */
    public int updateBdTybmTybmBzdwdmQywx(BdTybmTybmBzdwdmQywx bdTybmTybmBzdwdmQywx);

    /**
     * 删除学校部门
     * 
     * @param sjbmdm 学校部门ID
     * @return 结果
     */
    public int deleteBdTybmTybmBzdwdmQywxById(String sjbmdm);

    /**
     * 批量删除学校部门
     * 
     * @param sjbmdms 需要删除的数据ID
     * @return 结果
     */
    public int deleteBdTybmTybmBzdwdmQywxByIds(String[] sjbmdms);
}
