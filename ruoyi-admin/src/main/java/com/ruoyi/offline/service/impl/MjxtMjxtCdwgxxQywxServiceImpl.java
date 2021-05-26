package com.ruoyi.offline.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.offline.mapper.MjxtMjxtCdwgxxQywxMapper;
import com.ruoyi.offline.domain.MjxtMjxtCdwgxxQywx;
import com.ruoyi.offline.service.IMjxtMjxtCdwgxxQywxService;

/**
 * 迟到晚归信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class MjxtMjxtCdwgxxQywxServiceImpl implements IMjxtMjxtCdwgxxQywxService 
{
    @Autowired
    private MjxtMjxtCdwgxxQywxMapper mjxtMjxtCdwgxxQywxMapper;

    /**
     * 查询迟到晚归信息
     * 
     * @param xm 迟到晚归信息ID
     * @return 迟到晚归信息
     */
    @Override
    public MjxtMjxtCdwgxxQywx selectMjxtMjxtCdwgxxQywxById(String xm)
    {
        return mjxtMjxtCdwgxxQywxMapper.selectMjxtMjxtCdwgxxQywxById(xm);
    }

    /**
     * 查询迟到晚归信息列表
     * 
     * @param mjxtMjxtCdwgxxQywx 迟到晚归信息
     * @return 迟到晚归信息
     */
    @Override
    public List<MjxtMjxtCdwgxxQywx> selectMjxtMjxtCdwgxxQywxList(MjxtMjxtCdwgxxQywx mjxtMjxtCdwgxxQywx)
    {
        return mjxtMjxtCdwgxxQywxMapper.selectMjxtMjxtCdwgxxQywxList(mjxtMjxtCdwgxxQywx);
    }

    /**
     * 新增迟到晚归信息
     * 
     * @param mjxtMjxtCdwgxxQywx 迟到晚归信息
     * @return 结果
     */
    @Override
    public int insertMjxtMjxtCdwgxxQywx(MjxtMjxtCdwgxxQywx mjxtMjxtCdwgxxQywx)
    {
        return mjxtMjxtCdwgxxQywxMapper.insertMjxtMjxtCdwgxxQywx(mjxtMjxtCdwgxxQywx);
    }

    /**
     * 修改迟到晚归信息
     * 
     * @param mjxtMjxtCdwgxxQywx 迟到晚归信息
     * @return 结果
     */
    @Override
    public int updateMjxtMjxtCdwgxxQywx(MjxtMjxtCdwgxxQywx mjxtMjxtCdwgxxQywx)
    {
        return mjxtMjxtCdwgxxQywxMapper.updateMjxtMjxtCdwgxxQywx(mjxtMjxtCdwgxxQywx);
    }

    /**
     * 批量删除迟到晚归信息
     * 
     * @param xms 需要删除的迟到晚归信息ID
     * @return 结果
     */
    @Override
    public int deleteMjxtMjxtCdwgxxQywxByIds(String[] xms)
    {
        return mjxtMjxtCdwgxxQywxMapper.deleteMjxtMjxtCdwgxxQywxByIds(xms);
    }

    /**
     * 删除迟到晚归信息信息
     * 
     * @param xm 迟到晚归信息ID
     * @return 结果
     */
    @Override
    public int deleteMjxtMjxtCdwgxxQywxById(String xm)
    {
        return mjxtMjxtCdwgxxQywxMapper.deleteMjxtMjxtCdwgxxQywxById(xm);
    }
}
