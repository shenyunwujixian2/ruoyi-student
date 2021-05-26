package com.ruoyi.dbbase.service;

import java.util.List;
import com.ruoyi.dbbase.domain.BdXgxtXgxtBjfdyxxQywx;

/**
 * 学工班级辅导信息Service接口
 * 
 * @author xiaoafu
 * @date 2021-04-01
 */
public interface IBdXgxtXgxtBjfdyxxQywxService 
{
    /**
     * 查询学工班级辅导信息
     * 
     * @param bjxxbh 学工班级辅导信息ID
     * @return 学工班级辅导信息
     */
    public BdXgxtXgxtBjfdyxxQywx selectBdXgxtXgxtBjfdyxxQywxById(String bjxxbh);

    /**
     * 查询学工班级辅导信息列表
     * 
     * @param bdXgxtXgxtBjfdyxxQywx 学工班级辅导信息
     * @return 学工班级辅导信息集合
     */
    public List<BdXgxtXgxtBjfdyxxQywx> selectBdXgxtXgxtBjfdyxxQywxList(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx);

    /**
     * 新增学工班级辅导信息
     * 
     * @param bdXgxtXgxtBjfdyxxQywx 学工班级辅导信息
     * @return 结果
     */
    public int insertBdXgxtXgxtBjfdyxxQywx(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx);

    /**
     * 修改学工班级辅导信息
     * 
     * @param bdXgxtXgxtBjfdyxxQywx 学工班级辅导信息
     * @return 结果
     */
    public int updateBdXgxtXgxtBjfdyxxQywx(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx);

    /**
     * 批量删除学工班级辅导信息
     * 
     * @param bjxxbhs 需要删除的学工班级辅导信息ID
     * @return 结果
     */
    public int deleteBdXgxtXgxtBjfdyxxQywxByIds(String[] bjxxbhs);

    /**
     * 删除学工班级辅导信息信息
     * 
     * @param bjxxbh 学工班级辅导信息ID
     * @return 结果
     */
    public int deleteBdXgxtXgxtBjfdyxxQywxById(String bjxxbh);
    /**
     * 删除所有学工班级辅导信息信息
     *
     * @param bjxxbh 学工班级辅导信息ID
     * @return 结果
     */
    public int deleteBdXgxtXgxtBjfdyxxQywxByLocal(String local);
}
