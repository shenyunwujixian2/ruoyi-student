package com.ruoyi.dbbase.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dbbase.mapper.BdXgxtXgxtBjfdyxxQywxMapper;
import com.ruoyi.dbbase.domain.BdXgxtXgxtBjfdyxxQywx;
import com.ruoyi.dbbase.service.IBdXgxtXgxtBjfdyxxQywxService;

/**
 * 学工班级辅导信息Service业务层处理
 * 
 * @author xiaoafu
 * @date 2021-04-01
 */
@Service
public class BdXgxtXgxtBjfdyxxQywxServiceImpl implements IBdXgxtXgxtBjfdyxxQywxService 
{
    @Autowired
    private BdXgxtXgxtBjfdyxxQywxMapper bdXgxtXgxtBjfdyxxQywxMapper;

    /**
     * 查询学工班级辅导信息
     * 
     * @param bjxxbh 学工班级辅导信息ID
     * @return 学工班级辅导信息
     */
    @Override
    public BdXgxtXgxtBjfdyxxQywx selectBdXgxtXgxtBjfdyxxQywxById(String bjxxbh)
    {
        return bdXgxtXgxtBjfdyxxQywxMapper.selectBdXgxtXgxtBjfdyxxQywxById(bjxxbh);
    }

    /**
     * 查询学工班级辅导信息列表
     * 
     * @param bdXgxtXgxtBjfdyxxQywx 学工班级辅导信息
     * @return 学工班级辅导信息
     */
    @Override
    public List<BdXgxtXgxtBjfdyxxQywx> selectBdXgxtXgxtBjfdyxxQywxList(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx)
    {
        return bdXgxtXgxtBjfdyxxQywxMapper.selectBdXgxtXgxtBjfdyxxQywxList(bdXgxtXgxtBjfdyxxQywx);
    }

    /**
     * 新增学工班级辅导信息
     * 
     * @param bdXgxtXgxtBjfdyxxQywx 学工班级辅导信息
     * @return 结果
     */
    @Override
    public int insertBdXgxtXgxtBjfdyxxQywx(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx)
    {
        return bdXgxtXgxtBjfdyxxQywxMapper.insertBdXgxtXgxtBjfdyxxQywx(bdXgxtXgxtBjfdyxxQywx);
    }

    /**
     * 修改学工班级辅导信息
     * 
     * @param bdXgxtXgxtBjfdyxxQywx 学工班级辅导信息
     * @return 结果
     */
    @Override
    public int updateBdXgxtXgxtBjfdyxxQywx(BdXgxtXgxtBjfdyxxQywx bdXgxtXgxtBjfdyxxQywx)
    {
        return bdXgxtXgxtBjfdyxxQywxMapper.updateBdXgxtXgxtBjfdyxxQywx(bdXgxtXgxtBjfdyxxQywx);
    }

    /**
     * 批量删除学工班级辅导信息
     * 
     * @param bjxxbhs 需要删除的学工班级辅导信息ID
     * @return 结果
     */
    @Override
    public int deleteBdXgxtXgxtBjfdyxxQywxByIds(String[] bjxxbhs)
    {
        return bdXgxtXgxtBjfdyxxQywxMapper.deleteBdXgxtXgxtBjfdyxxQywxByIds(bjxxbhs);
    }

    /**
     * 删除学工班级辅导信息信息
     * 
     * @param bjxxbh 学工班级辅导信息ID
     * @return 结果
     */
    @Override
    public int deleteBdXgxtXgxtBjfdyxxQywxById(String bjxxbh)
    {
        return bdXgxtXgxtBjfdyxxQywxMapper.deleteBdXgxtXgxtBjfdyxxQywxById(bjxxbh);
    }
    /**
     * 删除学工班级辅导信息信息
     *
     * @param bjxxbh 学工班级辅导信息ID
     * @return 结果
     */
    @Override
    public int deleteBdXgxtXgxtBjfdyxxQywxByLocal(String bjxxbh)
    {
        return bdXgxtXgxtBjfdyxxQywxMapper.deleteBdXgxtXgxtBjfdyxxQywxByLocal(bjxxbh);
    }
}
