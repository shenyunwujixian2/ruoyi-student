package com.ruoyi.dbbase.service;

import java.util.List;
import com.ruoyi.dbbase.domain.BdXgxtXgxtSscwhrzxxQywx;

/**
 * 宿舍床位和入住信息Service接口
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
public interface IBdXgxtXgxtSscwhrzxxQywxService 
{
    /**
     * 查询宿舍床位和入住信息
     * 
     * @param xm 宿舍床位和入住信息ID
     * @return 宿舍床位和入住信息
     */
    public BdXgxtXgxtSscwhrzxxQywx selectBdXgxtXgxtSscwhrzxxQywxById(String xm);

    /**
     * 查询宿舍床位和入住信息列表
     * 
     * @param bdXgxtXgxtSscwhrzxxQywx 宿舍床位和入住信息
     * @return 宿舍床位和入住信息集合
     */
    public List<BdXgxtXgxtSscwhrzxxQywx> selectBdXgxtXgxtSscwhrzxxQywxList(BdXgxtXgxtSscwhrzxxQywx bdXgxtXgxtSscwhrzxxQywx);

    /**
     * 新增宿舍床位和入住信息
     * 
     * @param bdXgxtXgxtSscwhrzxxQywx 宿舍床位和入住信息
     * @return 结果
     */
    public int insertBdXgxtXgxtSscwhrzxxQywx(BdXgxtXgxtSscwhrzxxQywx bdXgxtXgxtSscwhrzxxQywx);

    /**
     * 修改宿舍床位和入住信息
     * 
     * @param bdXgxtXgxtSscwhrzxxQywx 宿舍床位和入住信息
     * @return 结果
     */
    public int updateBdXgxtXgxtSscwhrzxxQywx(BdXgxtXgxtSscwhrzxxQywx bdXgxtXgxtSscwhrzxxQywx);

    /**
     * 批量删除宿舍床位和入住信息
     * 
     * @param xms 需要删除的宿舍床位和入住信息ID
     * @return 结果
     */
    public int deleteBdXgxtXgxtSscwhrzxxQywxByIds(String[] xms);

    /**
     * 删除宿舍床位和入住信息信息
     * 
     * @param xm 宿舍床位和入住信息ID
     * @return 结果
     */
    public int deleteBdXgxtXgxtSscwhrzxxQywxById(String xm);

    /**
     * 删除宿舍床位和入住信息信息
     *
     * @param xm 宿舍床位和入住信息ID
     * @return 结果
     */
    public int deleteBdXgxtXgxtSscwhrzxxQywxByLocal(String local);
}
