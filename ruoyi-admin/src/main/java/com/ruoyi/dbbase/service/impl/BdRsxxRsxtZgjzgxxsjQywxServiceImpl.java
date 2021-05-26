package com.ruoyi.dbbase.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dbbase.mapper.BdRsxxRsxtZgjzgxxsjQywxMapper;
import com.ruoyi.dbbase.domain.BdRsxxRsxtZgjzgxxsjQywx;
import com.ruoyi.dbbase.service.IBdRsxxRsxtZgjzgxxsjQywxService;

/**
 * 在岗教职工线下数据Service业务层处理
 * 
 * @author xiaoafu
 * @date 2021-04-01
 */
@Service
public class BdRsxxRsxtZgjzgxxsjQywxServiceImpl implements IBdRsxxRsxtZgjzgxxsjQywxService 
{
    @Autowired
    private BdRsxxRsxtZgjzgxxsjQywxMapper bdRsxxRsxtZgjzgxxsjQywxMapper;

    /**
     * 查询在岗教职工线下数据
     * 
     * @param jzgh 在岗教职工线下数据ID
     * @return 在岗教职工线下数据
     */
    @Override
    public BdRsxxRsxtZgjzgxxsjQywx selectBdRsxxRsxtZgjzgxxsjQywxById(String jzgh)
    {
        return bdRsxxRsxtZgjzgxxsjQywxMapper.selectBdRsxxRsxtZgjzgxxsjQywxById(jzgh);
    }

    /**
     * 查询在岗教职工线下数据列表
     * 
     * @param bdRsxxRsxtZgjzgxxsjQywx 在岗教职工线下数据
     * @return 在岗教职工线下数据
     */
    @Override
    public List<BdRsxxRsxtZgjzgxxsjQywx> selectBdRsxxRsxtZgjzgxxsjQywxList(BdRsxxRsxtZgjzgxxsjQywx bdRsxxRsxtZgjzgxxsjQywx)
    {
        return bdRsxxRsxtZgjzgxxsjQywxMapper.selectBdRsxxRsxtZgjzgxxsjQywxList(bdRsxxRsxtZgjzgxxsjQywx);
    }

    /**
     * 新增在岗教职工线下数据
     * 
     * @param bdRsxxRsxtZgjzgxxsjQywx 在岗教职工线下数据
     * @return 结果
     */
    @Override
    public int insertBdRsxxRsxtZgjzgxxsjQywx(BdRsxxRsxtZgjzgxxsjQywx bdRsxxRsxtZgjzgxxsjQywx)
    {
        return bdRsxxRsxtZgjzgxxsjQywxMapper.insertBdRsxxRsxtZgjzgxxsjQywx(bdRsxxRsxtZgjzgxxsjQywx);
    }

    /**
     * 修改在岗教职工线下数据
     * 
     * @param bdRsxxRsxtZgjzgxxsjQywx 在岗教职工线下数据
     * @return 结果
     */
    @Override
    public int updateBdRsxxRsxtZgjzgxxsjQywx(BdRsxxRsxtZgjzgxxsjQywx bdRsxxRsxtZgjzgxxsjQywx)
    {
        return bdRsxxRsxtZgjzgxxsjQywxMapper.updateBdRsxxRsxtZgjzgxxsjQywx(bdRsxxRsxtZgjzgxxsjQywx);
    }

    /**
     * 批量删除在岗教职工线下数据
     * 
     * @param jzghs 需要删除的在岗教职工线下数据ID
     * @return 结果
     */
    @Override
    public int deleteBdRsxxRsxtZgjzgxxsjQywxByIds(String[] jzghs)
    {
        return bdRsxxRsxtZgjzgxxsjQywxMapper.deleteBdRsxxRsxtZgjzgxxsjQywxByIds(jzghs);
    }

    /**
     * 删除在岗教职工线下数据信息
     * 
     * @param jzgh 在岗教职工线下数据ID
     * @return 结果
     */
    @Override
    public int deleteBdRsxxRsxtZgjzgxxsjQywxById(String jzgh)
    {
        return bdRsxxRsxtZgjzgxxsjQywxMapper.deleteBdRsxxRsxtZgjzgxxsjQywxById(jzgh);
    }
}
