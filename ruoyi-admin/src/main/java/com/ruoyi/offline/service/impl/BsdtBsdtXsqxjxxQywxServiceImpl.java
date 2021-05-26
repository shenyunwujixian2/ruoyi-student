package com.ruoyi.offline.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.offline.mapper.BsdtBsdtXsqxjxxQywxMapper;
import com.ruoyi.offline.domain.BsdtBsdtXsqxjxxQywx;
import com.ruoyi.offline.service.IBsdtBsdtXsqxjxxQywxService;

/**
 * 学生请假信息Service业务层处理
 * 
 * @author xiaoafu
 * @date 2021-04-16
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class BsdtBsdtXsqxjxxQywxServiceImpl implements IBsdtBsdtXsqxjxxQywxService
{
    @Autowired
    private BsdtBsdtXsqxjxxQywxMapper bsdtBsdtXsqxjxxQywxMapper;

    /**
     * 查询学生请假信息
     * 
     * @param xsqxjxxbh 学生请假信息ID
     * @return 学生请假信息
     */
    @Override
    public BsdtBsdtXsqxjxxQywx selectBsdtBsdtXsqxjxxQywxById(String xsqxjxxbh)
    {
        return bsdtBsdtXsqxjxxQywxMapper.selectBsdtBsdtXsqxjxxQywxById(xsqxjxxbh);
    }

    /**
     * 查询学生请假信息列表
     * 
     * @param bsdtBsdtXsqxjxxQywx 学生请假信息
     * @return 学生请假信息
     */
    @Override
    public List<BsdtBsdtXsqxjxxQywx> selectBsdtBsdtXsqxjxxQywxList(BsdtBsdtXsqxjxxQywx bsdtBsdtXsqxjxxQywx)
    {
        return bsdtBsdtXsqxjxxQywxMapper.selectBsdtBsdtXsqxjxxQywxList(bsdtBsdtXsqxjxxQywx);
    }

    /**
     * 新增学生请假信息
     * 
     * @param bsdtBsdtXsqxjxxQywx 学生请假信息
     * @return 结果
     */
    @Override
    public int insertBsdtBsdtXsqxjxxQywx(BsdtBsdtXsqxjxxQywx bsdtBsdtXsqxjxxQywx)
    {
        return bsdtBsdtXsqxjxxQywxMapper.insertBsdtBsdtXsqxjxxQywx(bsdtBsdtXsqxjxxQywx);
    }

    /**
     * 修改学生请假信息
     * 
     * @param bsdtBsdtXsqxjxxQywx 学生请假信息
     * @return 结果
     */
    @Override
    public int updateBsdtBsdtXsqxjxxQywx(BsdtBsdtXsqxjxxQywx bsdtBsdtXsqxjxxQywx)
    {
        return bsdtBsdtXsqxjxxQywxMapper.updateBsdtBsdtXsqxjxxQywx(bsdtBsdtXsqxjxxQywx);
    }

    /**
     * 批量删除学生请假信息
     * 
     * @param xsqxjxxbhs 需要删除的学生请假信息ID
     * @return 结果
     */
    @Override
    public int deleteBsdtBsdtXsqxjxxQywxByIds(String[] xsqxjxxbhs)
    {
        return bsdtBsdtXsqxjxxQywxMapper.deleteBsdtBsdtXsqxjxxQywxByIds(xsqxjxxbhs);
    }

    /**
     * 删除学生请假信息信息
     * 
     * @param xsqxjxxbh 学生请假信息ID
     * @return 结果
     */
    @Override
    public int deleteBsdtBsdtXsqxjxxQywxById(String xsqxjxxbh)
    {
        return bsdtBsdtXsqxjxxQywxMapper.deleteBsdtBsdtXsqxjxxQywxById(xsqxjxxbh);
    }
}
