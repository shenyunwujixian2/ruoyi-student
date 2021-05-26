package com.ruoyi.dbbase.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dbbase.mapper.BdBsdtBsdtXsqxjxxQywxMapper;
import com.ruoyi.dbbase.domain.BdBsdtBsdtXsqxjxxQywx;
import com.ruoyi.dbbase.service.IBdBsdtBsdtXsqxjxxQywxService;

/**
 * 本地学生请假信息Service业务层处理
 * 
 * @author 学生请假表
 * @date 2021-04-16
 */
@Service
public class BdBsdtBsdtXsqxjxxQywxServiceImpl implements IBdBsdtBsdtXsqxjxxQywxService
{
    @Autowired
    private BdBsdtBsdtXsqxjxxQywxMapper bdBsdtBsdtXsqxjxxQywxMapper;

    /**
     * 查询本地学生请假信息
     * 
     * @param xsqxjxxbh 本地学生请假信息ID
     * @return 本地学生请假信息
     */
    @Override
    public BdBsdtBsdtXsqxjxxQywx selectBdBsdtBsdtXsqxjxxQywxById(String xsqxjxxbh)
    {
        return bdBsdtBsdtXsqxjxxQywxMapper.selectBdBsdtBsdtXsqxjxxQywxById(xsqxjxxbh);
    }

    /**
     * 查询本地学生请假信息列表
     * 
     * @param bdBsdtBsdtXsqxjxxQywx 本地学生请假信息
     * @return 本地学生请假信息
     */
    @Override
    public List<BdBsdtBsdtXsqxjxxQywx> selectBdBsdtBsdtXsqxjxxQywxList(BdBsdtBsdtXsqxjxxQywx bdBsdtBsdtXsqxjxxQywx)
    {
        return bdBsdtBsdtXsqxjxxQywxMapper.selectBdBsdtBsdtXsqxjxxQywxList(bdBsdtBsdtXsqxjxxQywx);
    }

    /**
     * 新增本地学生请假信息
     * 
     * @param bdBsdtBsdtXsqxjxxQywx 本地学生请假信息
     * @return 结果
     */
    @Override
    public int insertBdBsdtBsdtXsqxjxxQywx(BdBsdtBsdtXsqxjxxQywx bdBsdtBsdtXsqxjxxQywx)
    {
        return bdBsdtBsdtXsqxjxxQywxMapper.insertBdBsdtBsdtXsqxjxxQywx(bdBsdtBsdtXsqxjxxQywx);
    }

    /**
     * 修改本地学生请假信息
     * 
     * @param bdBsdtBsdtXsqxjxxQywx 本地学生请假信息
     * @return 结果
     */
    @Override
    public int updateBdBsdtBsdtXsqxjxxQywx(BdBsdtBsdtXsqxjxxQywx bdBsdtBsdtXsqxjxxQywx)
    {
        return bdBsdtBsdtXsqxjxxQywxMapper.updateBdBsdtBsdtXsqxjxxQywx(bdBsdtBsdtXsqxjxxQywx);
    }

    /**
     * 批量删除本地学生请假信息
     * 
     * @param xsqxjxxbhs 需要删除的本地学生请假信息ID
     * @return 结果
     */
    @Override
    public int deleteBdBsdtBsdtXsqxjxxQywxByIds(String[] xsqxjxxbhs)
    {
        return bdBsdtBsdtXsqxjxxQywxMapper.deleteBdBsdtBsdtXsqxjxxQywxByIds(xsqxjxxbhs);
    }

    /**
     * 删除本地学生请假信息信息
     * 
     * @param xsqxjxxbh 本地学生请假信息ID
     * @return 结果
     */
    @Override
    public int deleteBdBsdtBsdtXsqxjxxQywxById(String xsqxjxxbh)
    {
        return bdBsdtBsdtXsqxjxxQywxMapper.deleteBdBsdtBsdtXsqxjxxQywxById(xsqxjxxbh);
    }
}
