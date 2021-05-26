package com.ruoyi.dbbase.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dbbase.mapper.BdMjxtMjxtMjryjcjlxxQywxMapper;
import com.ruoyi.dbbase.domain.BdMjxtMjxtMjryjcjlxxQywx;
import com.ruoyi.dbbase.service.IBdMjxtMjxtMjryjcjlxxQywxService;

/**
 * 门禁人员进出记录信息Service业务层处理
 * 
 * @author xiaoafu
 * @date 2021-04-01
 */
@Service
public class BdMjxtMjxtMjryjcjlxxQywxServiceImpl implements IBdMjxtMjxtMjryjcjlxxQywxService 
{
    @Autowired
    private BdMjxtMjxtMjryjcjlxxQywxMapper bdMjxtMjxtMjryjcjlxxQywxMapper;

    /**
     * 查询门禁人员进出记录信息
     * 
     * @param zzzj 门禁人员进出记录信息ID
     * @return 门禁人员进出记录信息
     */
    @Override
    public BdMjxtMjxtMjryjcjlxxQywx selectBdMjxtMjxtMjryjcjlxxQywxById(Integer zzzj)
    {
        return bdMjxtMjxtMjryjcjlxxQywxMapper.selectBdMjxtMjxtMjryjcjlxxQywxById(zzzj);
    }

    /**
     * 查询门禁人员进出记录信息列表
     * 
     * @param bdMjxtMjxtMjryjcjlxxQywx 门禁人员进出记录信息
     * @return 门禁人员进出记录信息
     */
    @Override
    public List<BdMjxtMjxtMjryjcjlxxQywx> selectBdMjxtMjxtMjryjcjlxxQywxList(BdMjxtMjxtMjryjcjlxxQywx bdMjxtMjxtMjryjcjlxxQywx)
    {
        return bdMjxtMjxtMjryjcjlxxQywxMapper.selectBdMjxtMjxtMjryjcjlxxQywxList(bdMjxtMjxtMjryjcjlxxQywx);
    }

    /**
     * 新增门禁人员进出记录信息
     * 
     * @param bdMjxtMjxtMjryjcjlxxQywx 门禁人员进出记录信息
     * @return 结果
     */
    @Override
    public int insertBdMjxtMjxtMjryjcjlxxQywx(BdMjxtMjxtMjryjcjlxxQywx bdMjxtMjxtMjryjcjlxxQywx)
    {
        return bdMjxtMjxtMjryjcjlxxQywxMapper.insertBdMjxtMjxtMjryjcjlxxQywx(bdMjxtMjxtMjryjcjlxxQywx);
    }

    /**
     * 修改门禁人员进出记录信息
     * 
     * @param bdMjxtMjxtMjryjcjlxxQywx 门禁人员进出记录信息
     * @return 结果
     */
    @Override
    public int updateBdMjxtMjxtMjryjcjlxxQywx(BdMjxtMjxtMjryjcjlxxQywx bdMjxtMjxtMjryjcjlxxQywx)
    {
        return bdMjxtMjxtMjryjcjlxxQywxMapper.updateBdMjxtMjxtMjryjcjlxxQywx(bdMjxtMjxtMjryjcjlxxQywx);
    }

    /**
     * 批量删除门禁人员进出记录信息
     * 
     * @param zzzjs 需要删除的门禁人员进出记录信息ID
     * @return 结果
     */
    @Override
    public int deleteBdMjxtMjxtMjryjcjlxxQywxByIds(Integer[] zzzjs)
    {
        return bdMjxtMjxtMjryjcjlxxQywxMapper.deleteBdMjxtMjxtMjryjcjlxxQywxByIds(zzzjs);
    }

    /**
     * 删除门禁人员进出记录信息信息
     * 
     * @param zzzj 门禁人员进出记录信息ID
     * @return 结果
     */
    @Override
    public int deleteBdMjxtMjxtMjryjcjlxxQywxById(Integer zzzj)
    {
        return bdMjxtMjxtMjryjcjlxxQywxMapper.deleteBdMjxtMjxtMjryjcjlxxQywxById(zzzj);
    }
}
