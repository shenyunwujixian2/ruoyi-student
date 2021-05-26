package com.ruoyi.dbbase.service;

import java.util.List;
import com.ruoyi.dbbase.domain.BdXgxtXgxtXsqjsqxxQywx;

/**
 * 学生请假申请信息Service接口
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
public interface IBdXgxtXgxtXsqjsqxxQywxService 
{
    /**
     * 查询学生请假申请信息
     * 
     * @param jssj 学生请假申请信息ID
     * @return 学生请假申请信息
     */
    public BdXgxtXgxtXsqjsqxxQywx selectBdXgxtXgxtXsqjsqxxQywxById(String jssj);

    /**
     * 查询学生请假申请信息列表
     * 
     * @param bdXgxtXgxtXsqjsqxxQywx 学生请假申请信息
     * @return 学生请假申请信息集合
     */
    public List<BdXgxtXgxtXsqjsqxxQywx> selectBdXgxtXgxtXsqjsqxxQywxList(BdXgxtXgxtXsqjsqxxQywx bdXgxtXgxtXsqjsqxxQywx);

    /**
     * 新增学生请假申请信息
     * 
     * @param bdXgxtXgxtXsqjsqxxQywx 学生请假申请信息
     * @return 结果
     */
    public int insertBdXgxtXgxtXsqjsqxxQywx(BdXgxtXgxtXsqjsqxxQywx bdXgxtXgxtXsqjsqxxQywx);

    /**
     * 修改学生请假申请信息
     * 
     * @param bdXgxtXgxtXsqjsqxxQywx 学生请假申请信息
     * @return 结果
     */
    public int updateBdXgxtXgxtXsqjsqxxQywx(BdXgxtXgxtXsqjsqxxQywx bdXgxtXgxtXsqjsqxxQywx);

    /**
     * 批量删除学生请假申请信息
     * 
     * @param jssjs 需要删除的学生请假申请信息ID
     * @return 结果
     */
    public int deleteBdXgxtXgxtXsqjsqxxQywxByIds(String[] jssjs);

    /**
     * 删除学生请假申请信息信息
     * 
     * @param jssj 学生请假申请信息ID
     * @return 结果
     */
    public int deleteBdXgxtXgxtXsqjsqxxQywxById(String jssj);
}
