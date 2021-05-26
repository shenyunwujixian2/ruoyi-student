package com.ruoyi.dbbase.mapper;

import java.util.List;
import com.ruoyi.dbbase.domain.BdRsxxRsxtZgjzgxxsjQywx;

/**
 * 在岗教职工线下数据Mapper接口
 * 
 * @author xiaoafu
 * @date 2021-04-01
 */
public interface BdRsxxRsxtZgjzgxxsjQywxMapper 
{
    /**
     * 查询在岗教职工线下数据
     * 
     * @param jzgh 在岗教职工线下数据ID
     * @return 在岗教职工线下数据
     */
    public BdRsxxRsxtZgjzgxxsjQywx selectBdRsxxRsxtZgjzgxxsjQywxById(String jzgh);

    /**
     * 查询在岗教职工线下数据列表
     * 
     * @param bdRsxxRsxtZgjzgxxsjQywx 在岗教职工线下数据
     * @return 在岗教职工线下数据集合
     */
    public List<BdRsxxRsxtZgjzgxxsjQywx> selectBdRsxxRsxtZgjzgxxsjQywxList(BdRsxxRsxtZgjzgxxsjQywx bdRsxxRsxtZgjzgxxsjQywx);

    /**
     * 新增在岗教职工线下数据
     * 
     * @param bdRsxxRsxtZgjzgxxsjQywx 在岗教职工线下数据
     * @return 结果
     */
    public int insertBdRsxxRsxtZgjzgxxsjQywx(BdRsxxRsxtZgjzgxxsjQywx bdRsxxRsxtZgjzgxxsjQywx);

    /**
     * 修改在岗教职工线下数据
     * 
     * @param bdRsxxRsxtZgjzgxxsjQywx 在岗教职工线下数据
     * @return 结果
     */
    public int updateBdRsxxRsxtZgjzgxxsjQywx(BdRsxxRsxtZgjzgxxsjQywx bdRsxxRsxtZgjzgxxsjQywx);

    /**
     * 删除在岗教职工线下数据
     * 
     * @param jzgh 在岗教职工线下数据ID
     * @return 结果
     */
    public int deleteBdRsxxRsxtZgjzgxxsjQywxById(String jzgh);

    /**
     * 批量删除在岗教职工线下数据
     * 
     * @param jzghs 需要删除的数据ID
     * @return 结果
     */
    public int deleteBdRsxxRsxtZgjzgxxsjQywxByIds(String[] jzghs);
}
