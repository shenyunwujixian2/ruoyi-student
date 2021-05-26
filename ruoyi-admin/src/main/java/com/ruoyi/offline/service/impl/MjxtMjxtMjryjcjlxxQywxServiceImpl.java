package com.ruoyi.offline.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.offline.mapper.MjxtMjxtMjryjcjlxxQywxMapper;
import com.ruoyi.offline.domain.MjxtMjxtMjryjcjlxxQywx;
import com.ruoyi.offline.service.IMjxtMjxtMjryjcjlxxQywxService;

/**
 * 门禁人员进出记录信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class MjxtMjxtMjryjcjlxxQywxServiceImpl implements IMjxtMjxtMjryjcjlxxQywxService 
{
    @Autowired
    private MjxtMjxtMjryjcjlxxQywxMapper mjxtMjxtMjryjcjlxxQywxMapper;

    /**
     * 查询门禁人员进出记录信息
     * 
     * @param zzzj 门禁人员进出记录信息ID
     * @return 门禁人员进出记录信息
     */
    @Override
    public MjxtMjxtMjryjcjlxxQywx selectMjxtMjxtMjryjcjlxxQywxById(Integer zzzj)
    {
        return mjxtMjxtMjryjcjlxxQywxMapper.selectMjxtMjxtMjryjcjlxxQywxById(zzzj);
    }

    /**
     * 查询门禁人员进出记录信息列表
     * 
     * @param mjxtMjxtMjryjcjlxxQywx 门禁人员进出记录信息
     * @return 门禁人员进出记录信息
     */
    @Override
    public List<MjxtMjxtMjryjcjlxxQywx> selectMjxtMjxtMjryjcjlxxQywxList(MjxtMjxtMjryjcjlxxQywx mjxtMjxtMjryjcjlxxQywx)
    {
        return mjxtMjxtMjryjcjlxxQywxMapper.selectMjxtMjxtMjryjcjlxxQywxList(mjxtMjxtMjryjcjlxxQywx);
    }

    /**
     * 新增门禁人员进出记录信息
     * 
     * @param mjxtMjxtMjryjcjlxxQywx 门禁人员进出记录信息
     * @return 结果
     */
    @Override
    public int insertMjxtMjxtMjryjcjlxxQywx(MjxtMjxtMjryjcjlxxQywx mjxtMjxtMjryjcjlxxQywx)
    {
        return mjxtMjxtMjryjcjlxxQywxMapper.insertMjxtMjxtMjryjcjlxxQywx(mjxtMjxtMjryjcjlxxQywx);
    }

    /**
     * 修改门禁人员进出记录信息
     * 
     * @param mjxtMjxtMjryjcjlxxQywx 门禁人员进出记录信息
     * @return 结果
     */
    @Override
    public int updateMjxtMjxtMjryjcjlxxQywx(MjxtMjxtMjryjcjlxxQywx mjxtMjxtMjryjcjlxxQywx)
    {
        return mjxtMjxtMjryjcjlxxQywxMapper.updateMjxtMjxtMjryjcjlxxQywx(mjxtMjxtMjryjcjlxxQywx);
    }

    /**
     * 批量删除门禁人员进出记录信息
     * 
     * @param zzzjs 需要删除的门禁人员进出记录信息ID
     * @return 结果
     */
    @Override
    public int deleteMjxtMjxtMjryjcjlxxQywxByIds(Integer[] zzzjs)
    {
        return mjxtMjxtMjryjcjlxxQywxMapper.deleteMjxtMjxtMjryjcjlxxQywxByIds(zzzjs);
    }

    /**
     * 删除门禁人员进出记录信息信息
     * 
     * @param zzzj 门禁人员进出记录信息ID
     * @return 结果
     */
    @Override
    public int deleteMjxtMjxtMjryjcjlxxQywxById(Integer zzzj)
    {
        return mjxtMjxtMjryjcjlxxQywxMapper.deleteMjxtMjxtMjryjcjlxxQywxById(zzzj);
    }
}
