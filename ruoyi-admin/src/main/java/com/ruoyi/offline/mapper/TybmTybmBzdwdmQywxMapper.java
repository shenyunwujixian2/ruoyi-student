package com.ruoyi.offline.mapper;

import java.util.List;
import com.ruoyi.offline.domain.TybmTybmBzdwdmQywx;

/**
 * 学校部门Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
public interface TybmTybmBzdwdmQywxMapper 
{
    /**
     * 查询学校部门
     * 
     * @param sjbmdm 学校部门ID
     * @return 学校部门
     */
    public TybmTybmBzdwdmQywx selectTybmTybmBzdwdmQywxById(String sjbmdm);

    /**
     * 查询学校部门列表
     * 
     * @param tybmTybmBzdwdmQywx 学校部门
     * @return 学校部门集合
     */
    public List<TybmTybmBzdwdmQywx> selectTybmTybmBzdwdmQywxList(TybmTybmBzdwdmQywx tybmTybmBzdwdmQywx);

    /**
     * 新增学校部门
     * 
     * @param tybmTybmBzdwdmQywx 学校部门
     * @return 结果
     */
    public int insertTybmTybmBzdwdmQywx(TybmTybmBzdwdmQywx tybmTybmBzdwdmQywx);

    /**
     * 修改学校部门
     * 
     * @param tybmTybmBzdwdmQywx 学校部门
     * @return 结果
     */
    public int updateTybmTybmBzdwdmQywx(TybmTybmBzdwdmQywx tybmTybmBzdwdmQywx);

    /**
     * 删除学校部门
     * 
     * @param sjbmdm 学校部门ID
     * @return 结果
     */
    public int deleteTybmTybmBzdwdmQywxById(String sjbmdm);

    /**
     * 批量删除学校部门
     * 
     * @param sjbmdms 需要删除的数据ID
     * @return 结果
     */
    public int deleteTybmTybmBzdwdmQywxByIds(String[] sjbmdms);
}
