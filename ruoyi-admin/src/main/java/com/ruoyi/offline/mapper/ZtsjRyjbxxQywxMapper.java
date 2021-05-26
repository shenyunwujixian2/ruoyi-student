package com.ruoyi.offline.mapper;

import java.util.List;
import com.ruoyi.offline.domain.ZtsjRyjbxxQywx;

/**
 * 门禁中的用户信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
public interface ZtsjRyjbxxQywxMapper 
{
    /**
     * 查询门禁中的用户信息
     * 
     * @param zj 门禁中的用户信息ID
     * @return 门禁中的用户信息
     */
    public ZtsjRyjbxxQywx selectZtsjRyjbxxQywxById(String zj);

    /**
     * 查询门禁中的用户信息列表
     * 
     * @param ztsjRyjbxxQywx 门禁中的用户信息
     * @return 门禁中的用户信息集合
     */
    public List<ZtsjRyjbxxQywx> selectZtsjRyjbxxQywxList(ZtsjRyjbxxQywx ztsjRyjbxxQywx);

    /**
     * 新增门禁中的用户信息
     * 
     * @param ztsjRyjbxxQywx 门禁中的用户信息
     * @return 结果
     */
    public int insertZtsjRyjbxxQywx(ZtsjRyjbxxQywx ztsjRyjbxxQywx);

    /**
     * 修改门禁中的用户信息
     * 
     * @param ztsjRyjbxxQywx 门禁中的用户信息
     * @return 结果
     */
    public int updateZtsjRyjbxxQywx(ZtsjRyjbxxQywx ztsjRyjbxxQywx);

    /**
     * 删除门禁中的用户信息
     * 
     * @param zj 门禁中的用户信息ID
     * @return 结果
     */
    public int deleteZtsjRyjbxxQywxById(String zj);

    /**
     * 批量删除门禁中的用户信息
     * 
     * @param zjs 需要删除的数据ID
     * @return 结果
     */
    public int deleteZtsjRyjbxxQywxByIds(String[] zjs);
}
