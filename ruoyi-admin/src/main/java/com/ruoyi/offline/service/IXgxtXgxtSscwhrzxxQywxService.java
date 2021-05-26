package com.ruoyi.offline.service;

import java.util.List;
import com.ruoyi.offline.domain.XgxtXgxtSscwhrzxxQywx;

/**
 * 宿舍床位和入住信息Service接口
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
public interface IXgxtXgxtSscwhrzxxQywxService 
{
    /**
     * 查询宿舍床位和入住信息
     * 
     * @param xm 宿舍床位和入住信息ID
     * @return 宿舍床位和入住信息
     */
    public XgxtXgxtSscwhrzxxQywx selectXgxtXgxtSscwhrzxxQywxById(String xm);

    /**
     * 查询宿舍床位和入住信息列表
     * 
     * @param xgxtXgxtSscwhrzxxQywx 宿舍床位和入住信息
     * @return 宿舍床位和入住信息集合
     */
    public List<XgxtXgxtSscwhrzxxQywx> selectXgxtXgxtSscwhrzxxQywxList(XgxtXgxtSscwhrzxxQywx xgxtXgxtSscwhrzxxQywx);

    /**
     * 新增宿舍床位和入住信息
     * 
     * @param xgxtXgxtSscwhrzxxQywx 宿舍床位和入住信息
     * @return 结果
     */
    public int insertXgxtXgxtSscwhrzxxQywx(XgxtXgxtSscwhrzxxQywx xgxtXgxtSscwhrzxxQywx);

    /**
     * 修改宿舍床位和入住信息
     * 
     * @param xgxtXgxtSscwhrzxxQywx 宿舍床位和入住信息
     * @return 结果
     */
    public int updateXgxtXgxtSscwhrzxxQywx(XgxtXgxtSscwhrzxxQywx xgxtXgxtSscwhrzxxQywx);

    /**
     * 批量删除宿舍床位和入住信息
     * 
     * @param xms 需要删除的宿舍床位和入住信息ID
     * @return 结果
     */
    public int deleteXgxtXgxtSscwhrzxxQywxByIds(String[] xms);

    /**
     * 删除宿舍床位和入住信息信息
     * 
     * @param xm 宿舍床位和入住信息ID
     * @return 结果
     */
    public int deleteXgxtXgxtSscwhrzxxQywxById(String xm);
}
