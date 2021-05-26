package com.ruoyi.dbbase.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dbbase.mapper.BdXgxtXgxtSscwhrzxxQywxMapper;
import com.ruoyi.dbbase.domain.BdXgxtXgxtSscwhrzxxQywx;
import com.ruoyi.dbbase.service.IBdXgxtXgxtSscwhrzxxQywxService;

/**
 * 宿舍床位和入住信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
@Service
public class BdXgxtXgxtSscwhrzxxQywxServiceImpl implements IBdXgxtXgxtSscwhrzxxQywxService 
{
    @Autowired
    private BdXgxtXgxtSscwhrzxxQywxMapper bdXgxtXgxtSscwhrzxxQywxMapper;

    /**
     * 查询宿舍床位和入住信息
     * 
     * @param xm 宿舍床位和入住信息ID
     * @return 宿舍床位和入住信息
     */
    @Override
    public BdXgxtXgxtSscwhrzxxQywx selectBdXgxtXgxtSscwhrzxxQywxById(String xh)
    {
        return bdXgxtXgxtSscwhrzxxQywxMapper.selectBdXgxtXgxtSscwhrzxxQywxById(xh);
    }

    /**
     * 查询宿舍床位和入住信息列表
     * 
     * @param bdXgxtXgxtSscwhrzxxQywx 宿舍床位和入住信息
     * @return 宿舍床位和入住信息
     */
    @Override
    public List<BdXgxtXgxtSscwhrzxxQywx> selectBdXgxtXgxtSscwhrzxxQywxList(BdXgxtXgxtSscwhrzxxQywx bdXgxtXgxtSscwhrzxxQywx)
    {
        return bdXgxtXgxtSscwhrzxxQywxMapper.selectBdXgxtXgxtSscwhrzxxQywxList(bdXgxtXgxtSscwhrzxxQywx);
    }

    /**
     * 新增宿舍床位和入住信息
     * 
     * @param bdXgxtXgxtSscwhrzxxQywx 宿舍床位和入住信息
     * @return 结果
     */
    @Override
    public int insertBdXgxtXgxtSscwhrzxxQywx(BdXgxtXgxtSscwhrzxxQywx bdXgxtXgxtSscwhrzxxQywx)
    {
        return bdXgxtXgxtSscwhrzxxQywxMapper.insertBdXgxtXgxtSscwhrzxxQywx(bdXgxtXgxtSscwhrzxxQywx);
    }

    /**
     * 修改宿舍床位和入住信息
     * 
     * @param bdXgxtXgxtSscwhrzxxQywx 宿舍床位和入住信息
     * @return 结果
     */
    @Override
    public int updateBdXgxtXgxtSscwhrzxxQywx(BdXgxtXgxtSscwhrzxxQywx bdXgxtXgxtSscwhrzxxQywx)
    {
        return bdXgxtXgxtSscwhrzxxQywxMapper.updateBdXgxtXgxtSscwhrzxxQywx(bdXgxtXgxtSscwhrzxxQywx);
    }

    /**
     * 批量删除宿舍床位和入住信息
     * 
     * @param xms 需要删除的宿舍床位和入住信息ID
     * @return 结果
     */
    @Override
    public int deleteBdXgxtXgxtSscwhrzxxQywxByIds(String[] xms)
    {
        return bdXgxtXgxtSscwhrzxxQywxMapper.deleteBdXgxtXgxtSscwhrzxxQywxByIds(xms);
    }

    /**
     * 删除宿舍床位和入住信息信息
     * 
     * @param xm 宿舍床位和入住信息ID
     * @return 结果
     */
    @Override
    public int deleteBdXgxtXgxtSscwhrzxxQywxById(String xm)
    {
        return bdXgxtXgxtSscwhrzxxQywxMapper.deleteBdXgxtXgxtSscwhrzxxQywxById(xm);
    }
    /**
     * 删除宿舍床位和入住信息信息
     *
     * @param xm 宿舍床位和入住信息ID
     * @return 结果
     */
    @Override
    public int deleteBdXgxtXgxtSscwhrzxxQywxByLocal(String local)
    {
        return bdXgxtXgxtSscwhrzxxQywxMapper.deleteBdXgxtXgxtSscwhrzxxQywxByLocal(local);
    }
}
