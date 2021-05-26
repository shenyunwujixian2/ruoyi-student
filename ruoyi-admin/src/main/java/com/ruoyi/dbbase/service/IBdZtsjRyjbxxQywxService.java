package com.ruoyi.dbbase.service;

import java.util.List;
import com.ruoyi.dbbase.domain.BdZtsjRyjbxxQywx;

/**
 * 门禁中的用户信息Service接口
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
public interface IBdZtsjRyjbxxQywxService 
{
    /**
     * 查询门禁中的用户信息
     * 
     * @param zj 门禁中的用户信息ID
     * @return 门禁中的用户信息
     */
    public BdZtsjRyjbxxQywx selectBdZtsjRyjbxxQywxById(String zj);

    /**
     * 查询门禁中的用户信息列表
     * 
     * @param bdZtsjRyjbxxQywx 门禁中的用户信息
     * @return 门禁中的用户信息集合
     */
    public List<BdZtsjRyjbxxQywx> selectBdZtsjRyjbxxQywxList(BdZtsjRyjbxxQywx bdZtsjRyjbxxQywx);

    /**
     * 新增门禁中的用户信息
     * 
     * @param bdZtsjRyjbxxQywx 门禁中的用户信息
     * @return 结果
     */
    public int insertBdZtsjRyjbxxQywx(BdZtsjRyjbxxQywx bdZtsjRyjbxxQywx);

    /**
     * 修改门禁中的用户信息
     * 
     * @param bdZtsjRyjbxxQywx 门禁中的用户信息
     * @return 结果
     */
    public int updateBdZtsjRyjbxxQywx(BdZtsjRyjbxxQywx bdZtsjRyjbxxQywx);

    /**
     * 批量删除门禁中的用户信息
     * 
     * @param zjs 需要删除的门禁中的用户信息ID
     * @return 结果
     */
    public int deleteBdZtsjRyjbxxQywxByIds(String[] zjs);

    /**
     * 删除门禁中的用户信息信息
     * 
     * @param zj 门禁中的用户信息ID
     * @return 结果
     */
    public int deleteBdZtsjRyjbxxQywxById(String zj);
    /**
     * 删除门禁中的用户信息信息
     *
     * @param zj 门禁中的用户信息ID
     * @return 结果
     */
    public int deleteBdZtsjRyjbxxQywxByLocal(String zj);
}
