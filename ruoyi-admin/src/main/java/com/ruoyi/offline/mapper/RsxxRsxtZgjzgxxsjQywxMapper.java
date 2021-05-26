package com.ruoyi.offline.mapper;

import java.util.List;
import com.ruoyi.offline.domain.RsxxRsxtZgjzgxxsjQywx;

/**
 * 在岗教职工线下数据Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
public interface RsxxRsxtZgjzgxxsjQywxMapper 
{
    /**
     * 查询在岗教职工线下数据
     * 
     * @param jzgh 在岗教职工线下数据ID
     * @return 在岗教职工线下数据
     */
    public RsxxRsxtZgjzgxxsjQywx selectRsxxRsxtZgjzgxxsjQywxById(String jzgh);

    /**
     * 查询在岗教职工线下数据列表
     * 
     * @param rsxxRsxtZgjzgxxsjQywx 在岗教职工线下数据
     * @return 在岗教职工线下数据集合
     */
    public List<RsxxRsxtZgjzgxxsjQywx> selectRsxxRsxtZgjzgxxsjQywxList(RsxxRsxtZgjzgxxsjQywx rsxxRsxtZgjzgxxsjQywx);

    /**
     * 新增在岗教职工线下数据
     * 
     * @param rsxxRsxtZgjzgxxsjQywx 在岗教职工线下数据
     * @return 结果
     */
    public int insertRsxxRsxtZgjzgxxsjQywx(RsxxRsxtZgjzgxxsjQywx rsxxRsxtZgjzgxxsjQywx);

    /**
     * 修改在岗教职工线下数据
     * 
     * @param rsxxRsxtZgjzgxxsjQywx 在岗教职工线下数据
     * @return 结果
     */
    public int updateRsxxRsxtZgjzgxxsjQywx(RsxxRsxtZgjzgxxsjQywx rsxxRsxtZgjzgxxsjQywx);

    /**
     * 删除在岗教职工线下数据
     * 
     * @param jzgh 在岗教职工线下数据ID
     * @return 结果
     */
    public int deleteRsxxRsxtZgjzgxxsjQywxById(String jzgh);

    /**
     * 批量删除在岗教职工线下数据
     * 
     * @param jzghs 需要删除的数据ID
     * @return 结果
     */
    public int deleteRsxxRsxtZgjzgxxsjQywxByIds(String[] jzghs);
}
