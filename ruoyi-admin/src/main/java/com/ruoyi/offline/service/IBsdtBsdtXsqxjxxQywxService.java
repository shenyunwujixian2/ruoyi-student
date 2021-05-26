package com.ruoyi.offline.service;

import java.util.List;
import com.ruoyi.offline.domain.BsdtBsdtXsqxjxxQywx;

/**
 * 学生请假信息Service接口
 * 
 * @author xiaoafu
 * @date 2021-04-16
 */
public interface IBsdtBsdtXsqxjxxQywxService
{
    /**
     * 查询学生请假信息
     * 
     * @param xsqxjxxbh 学生请假信息ID
     * @return 学生请假信息
     */
    public BsdtBsdtXsqxjxxQywx selectBsdtBsdtXsqxjxxQywxById(String xsqxjxxbh);

    /**
     * 查询学生请假信息列表
     * 
     * @param bsdtBsdtXsqxjxxQywx 学生请假信息
     * @return 学生请假信息集合
     */
    public List<BsdtBsdtXsqxjxxQywx> selectBsdtBsdtXsqxjxxQywxList(BsdtBsdtXsqxjxxQywx bsdtBsdtXsqxjxxQywx);

    /**
     * 新增学生请假信息
     * 
     * @param bsdtBsdtXsqxjxxQywx 学生请假信息
     * @return 结果
     */
    public int insertBsdtBsdtXsqxjxxQywx(BsdtBsdtXsqxjxxQywx bsdtBsdtXsqxjxxQywx);

    /**
     * 修改学生请假信息
     * 
     * @param bsdtBsdtXsqxjxxQywx 学生请假信息
     * @return 结果
     */
    public int updateBsdtBsdtXsqxjxxQywx(BsdtBsdtXsqxjxxQywx bsdtBsdtXsqxjxxQywx);

    /**
     * 批量删除学生请假信息
     * 
     * @param xsqxjxxbhs 需要删除的学生请假信息ID
     * @return 结果
     */
    public int deleteBsdtBsdtXsqxjxxQywxByIds(String[] xsqxjxxbhs);

    /**
     * 删除学生请假信息信息
     * 
     * @param xsqxjxxbh 学生请假信息ID
     * @return 结果
     */
    public int deleteBsdtBsdtXsqxjxxQywxById(String xsqxjxxbh);
}
