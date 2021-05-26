package com.ruoyi.dbbase.mapper;

import java.util.List;
import com.ruoyi.dbbase.domain.BdBsdtBsdtXsqxjxxQywx;

/**
 * 本地学生请假信息Mapper接口
 * 
 * @author 学生请假表
 * @date 2021-04-16
 */
public interface BdBsdtBsdtXsqxjxxQywxMapper
{
    /**
     * 查询本地学生请假信息
     * 
     * @param xsqxjxxbh 本地学生请假信息ID
     * @return 本地学生请假信息
     */
    public BdBsdtBsdtXsqxjxxQywx selectBdBsdtBsdtXsqxjxxQywxById(String xsqxjxxbh);

    /**
     * 查询本地学生请假信息列表
     * 
     * @param bdBsdtBsdtXsqxjxxQywx 本地学生请假信息
     * @return 本地学生请假信息集合
     */
    public List<BdBsdtBsdtXsqxjxxQywx> selectBdBsdtBsdtXsqxjxxQywxList(BdBsdtBsdtXsqxjxxQywx bdBsdtBsdtXsqxjxxQywx);

    /**
     * 新增本地学生请假信息
     * 
     * @param bdBsdtBsdtXsqxjxxQywx 本地学生请假信息
     * @return 结果
     */
    public int insertBdBsdtBsdtXsqxjxxQywx(BdBsdtBsdtXsqxjxxQywx bdBsdtBsdtXsqxjxxQywx);

    /**
     * 修改本地学生请假信息
     * 
     * @param bdBsdtBsdtXsqxjxxQywx 本地学生请假信息
     * @return 结果
     */
    public int updateBdBsdtBsdtXsqxjxxQywx(BdBsdtBsdtXsqxjxxQywx bdBsdtBsdtXsqxjxxQywx);

    /**
     * 删除本地学生请假信息
     * 
     * @param xsqxjxxbh 本地学生请假信息ID
     * @return 结果
     */
    public int deleteBdBsdtBsdtXsqxjxxQywxById(String xsqxjxxbh);

    /**
     * 批量删除本地学生请假信息
     * 
     * @param xsqxjxxbhs 需要删除的数据ID
     * @return 结果
     */
    public int deleteBdBsdtBsdtXsqxjxxQywxByIds(String[] xsqxjxxbhs);
}
