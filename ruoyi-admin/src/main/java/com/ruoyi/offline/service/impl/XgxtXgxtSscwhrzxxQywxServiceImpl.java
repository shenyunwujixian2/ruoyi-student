package com.ruoyi.offline.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.offline.mapper.XgxtXgxtSscwhrzxxQywxMapper;
import com.ruoyi.offline.domain.XgxtXgxtSscwhrzxxQywx;
import com.ruoyi.offline.service.IXgxtXgxtSscwhrzxxQywxService;

/**
 * 宿舍床位和入住信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class XgxtXgxtSscwhrzxxQywxServiceImpl implements IXgxtXgxtSscwhrzxxQywxService 
{
    @Autowired
    private XgxtXgxtSscwhrzxxQywxMapper xgxtXgxtSscwhrzxxQywxMapper;

    /**
     * 查询宿舍床位和入住信息
     * 
     * @param xm 宿舍床位和入住信息ID
     * @return 宿舍床位和入住信息
     */
    @Override
    public XgxtXgxtSscwhrzxxQywx selectXgxtXgxtSscwhrzxxQywxById(String xm)
    {
        return xgxtXgxtSscwhrzxxQywxMapper.selectXgxtXgxtSscwhrzxxQywxById(xm);
    }

    /**
     * 查询宿舍床位和入住信息列表
     * 
     * @param xgxtXgxtSscwhrzxxQywx 宿舍床位和入住信息
     * @return 宿舍床位和入住信息
     */
    @Override
    public List<XgxtXgxtSscwhrzxxQywx> selectXgxtXgxtSscwhrzxxQywxList(XgxtXgxtSscwhrzxxQywx xgxtXgxtSscwhrzxxQywx)
    {
        return xgxtXgxtSscwhrzxxQywxMapper.selectXgxtXgxtSscwhrzxxQywxList(xgxtXgxtSscwhrzxxQywx);
    }

    /**
     * 新增宿舍床位和入住信息
     * 
     * @param xgxtXgxtSscwhrzxxQywx 宿舍床位和入住信息
     * @return 结果
     */
    @Override
    public int insertXgxtXgxtSscwhrzxxQywx(XgxtXgxtSscwhrzxxQywx xgxtXgxtSscwhrzxxQywx)
    {
        return xgxtXgxtSscwhrzxxQywxMapper.insertXgxtXgxtSscwhrzxxQywx(xgxtXgxtSscwhrzxxQywx);
    }

    /**
     * 修改宿舍床位和入住信息
     * 
     * @param xgxtXgxtSscwhrzxxQywx 宿舍床位和入住信息
     * @return 结果
     */
    @Override
    public int updateXgxtXgxtSscwhrzxxQywx(XgxtXgxtSscwhrzxxQywx xgxtXgxtSscwhrzxxQywx)
    {
        return xgxtXgxtSscwhrzxxQywxMapper.updateXgxtXgxtSscwhrzxxQywx(xgxtXgxtSscwhrzxxQywx);
    }

    /**
     * 批量删除宿舍床位和入住信息
     * 
     * @param xms 需要删除的宿舍床位和入住信息ID
     * @return 结果
     */
    @Override
    public int deleteXgxtXgxtSscwhrzxxQywxByIds(String[] xms)
    {
        return xgxtXgxtSscwhrzxxQywxMapper.deleteXgxtXgxtSscwhrzxxQywxByIds(xms);
    }

    /**
     * 删除宿舍床位和入住信息信息
     * 
     * @param xm 宿舍床位和入住信息ID
     * @return 结果
     */
    @Override
    public int deleteXgxtXgxtSscwhrzxxQywxById(String xm)
    {
        return xgxtXgxtSscwhrzxxQywxMapper.deleteXgxtXgxtSscwhrzxxQywxById(xm);
    }
}
