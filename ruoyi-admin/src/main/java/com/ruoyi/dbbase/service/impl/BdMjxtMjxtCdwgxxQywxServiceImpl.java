package com.ruoyi.dbbase.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dbbase.mapper.BdMjxtMjxtCdwgxxQywxMapper;
import com.ruoyi.dbbase.domain.BdMjxtMjxtCdwgxxQywx;
import com.ruoyi.dbbase.service.IBdMjxtMjxtCdwgxxQywxService;

/**
 * 迟到晚归信息Service业务层处理
 * 
 * @author yufu
 * @date 2021-04-01
 */
@Service
public class BdMjxtMjxtCdwgxxQywxServiceImpl implements IBdMjxtMjxtCdwgxxQywxService 
{
    @Autowired
    private BdMjxtMjxtCdwgxxQywxMapper bdMjxtMjxtCdwgxxQywxMapper;

    /**
     * 查询迟到晚归信息
     * 
     * @param xm 迟到晚归信息ID
     * @return 迟到晚归信息
     */
    @Override
    public BdMjxtMjxtCdwgxxQywx selectBdMjxtMjxtCdwgxxQywxById(String xm)
    {
        return bdMjxtMjxtCdwgxxQywxMapper.selectBdMjxtMjxtCdwgxxQywxById(xm);
    }

    /**
     * 查询迟到晚归信息列表
     * 
     * @param bdMjxtMjxtCdwgxxQywx 迟到晚归信息
     * @return 迟到晚归信息
     */
    @Override
    public List<BdMjxtMjxtCdwgxxQywx> selectBdMjxtMjxtCdwgxxQywxList(BdMjxtMjxtCdwgxxQywx bdMjxtMjxtCdwgxxQywx)
    {
        return bdMjxtMjxtCdwgxxQywxMapper.selectBdMjxtMjxtCdwgxxQywxList(bdMjxtMjxtCdwgxxQywx);
    }

    /**
     * 新增迟到晚归信息
     * 
     * @param bdMjxtMjxtCdwgxxQywx 迟到晚归信息
     * @return 结果
     */
    @Override
    public int insertBdMjxtMjxtCdwgxxQywx(BdMjxtMjxtCdwgxxQywx bdMjxtMjxtCdwgxxQywx)
    {
        return bdMjxtMjxtCdwgxxQywxMapper.insertBdMjxtMjxtCdwgxxQywx(bdMjxtMjxtCdwgxxQywx);
    }

    /**
     * 修改迟到晚归信息
     * 
     * @param bdMjxtMjxtCdwgxxQywx 迟到晚归信息
     * @return 结果
     */
    @Override
    public int updateBdMjxtMjxtCdwgxxQywx(BdMjxtMjxtCdwgxxQywx bdMjxtMjxtCdwgxxQywx)
    {
        return bdMjxtMjxtCdwgxxQywxMapper.updateBdMjxtMjxtCdwgxxQywx(bdMjxtMjxtCdwgxxQywx);
    }

    /**
     * 批量删除迟到晚归信息
     * 
     * @param xms 需要删除的迟到晚归信息ID
     * @return 结果
     */
    @Override
    public int deleteBdMjxtMjxtCdwgxxQywxByIds(String[] xms)
    {
        return bdMjxtMjxtCdwgxxQywxMapper.deleteBdMjxtMjxtCdwgxxQywxByIds(xms);
    }

    /**
     * 删除迟到晚归信息信息
     * 
     * @param xm 迟到晚归信息ID
     * @return 结果
     */
    @Override
    public int deleteBdMjxtMjxtCdwgxxQywxById(String xm)
    {
        return bdMjxtMjxtCdwgxxQywxMapper.deleteBdMjxtMjxtCdwgxxQywxById(xm);
    }
}
