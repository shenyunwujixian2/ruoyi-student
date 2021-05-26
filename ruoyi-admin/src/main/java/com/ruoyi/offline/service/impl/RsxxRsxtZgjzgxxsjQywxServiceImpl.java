package com.ruoyi.offline.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.offline.mapper.RsxxRsxtZgjzgxxsjQywxMapper;
import com.ruoyi.offline.domain.RsxxRsxtZgjzgxxsjQywx;
import com.ruoyi.offline.service.IRsxxRsxtZgjzgxxsjQywxService;

/**
 * 在岗教职工线下数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class RsxxRsxtZgjzgxxsjQywxServiceImpl implements IRsxxRsxtZgjzgxxsjQywxService 
{
    @Autowired
    private RsxxRsxtZgjzgxxsjQywxMapper rsxxRsxtZgjzgxxsjQywxMapper;

    /**
     * 查询在岗教职工线下数据
     * 
     * @param jzgh 在岗教职工线下数据ID
     * @return 在岗教职工线下数据
     */
    @Override
    public RsxxRsxtZgjzgxxsjQywx selectRsxxRsxtZgjzgxxsjQywxById(String jzgh)
    {
        return rsxxRsxtZgjzgxxsjQywxMapper.selectRsxxRsxtZgjzgxxsjQywxById(jzgh);
    }

    /**
     * 查询在岗教职工线下数据列表
     * 
     * @param rsxxRsxtZgjzgxxsjQywx 在岗教职工线下数据
     * @return 在岗教职工线下数据
     */
    @Override
    public List<RsxxRsxtZgjzgxxsjQywx> selectRsxxRsxtZgjzgxxsjQywxList(RsxxRsxtZgjzgxxsjQywx rsxxRsxtZgjzgxxsjQywx)
    {
        return rsxxRsxtZgjzgxxsjQywxMapper.selectRsxxRsxtZgjzgxxsjQywxList(rsxxRsxtZgjzgxxsjQywx);
    }

    /**
     * 新增在岗教职工线下数据
     * 
     * @param rsxxRsxtZgjzgxxsjQywx 在岗教职工线下数据
     * @return 结果
     */
    @Override
    public int insertRsxxRsxtZgjzgxxsjQywx(RsxxRsxtZgjzgxxsjQywx rsxxRsxtZgjzgxxsjQywx)
    {
        return rsxxRsxtZgjzgxxsjQywxMapper.insertRsxxRsxtZgjzgxxsjQywx(rsxxRsxtZgjzgxxsjQywx);
    }

    /**
     * 修改在岗教职工线下数据
     * 
     * @param rsxxRsxtZgjzgxxsjQywx 在岗教职工线下数据
     * @return 结果
     */
    @Override
    public int updateRsxxRsxtZgjzgxxsjQywx(RsxxRsxtZgjzgxxsjQywx rsxxRsxtZgjzgxxsjQywx)
    {
        return rsxxRsxtZgjzgxxsjQywxMapper.updateRsxxRsxtZgjzgxxsjQywx(rsxxRsxtZgjzgxxsjQywx);
    }

    /**
     * 批量删除在岗教职工线下数据
     * 
     * @param jzghs 需要删除的在岗教职工线下数据ID
     * @return 结果
     */
    @Override
    public int deleteRsxxRsxtZgjzgxxsjQywxByIds(String[] jzghs)
    {
        return rsxxRsxtZgjzgxxsjQywxMapper.deleteRsxxRsxtZgjzgxxsjQywxByIds(jzghs);
    }

    /**
     * 删除在岗教职工线下数据信息
     * 
     * @param jzgh 在岗教职工线下数据ID
     * @return 结果
     */
    @Override
    public int deleteRsxxRsxtZgjzgxxsjQywxById(String jzgh)
    {
        return rsxxRsxtZgjzgxxsjQywxMapper.deleteRsxxRsxtZgjzgxxsjQywxById(jzgh);
    }
}
