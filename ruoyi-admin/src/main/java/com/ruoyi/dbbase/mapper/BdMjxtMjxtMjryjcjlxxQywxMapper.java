package com.ruoyi.dbbase.mapper;

import java.util.List;
import com.ruoyi.dbbase.domain.BdMjxtMjxtMjryjcjlxxQywx;

/**
 * 门禁人员进出记录信息Mapper接口
 * 
 * @author xiaoafu
 * @date 2021-04-01
 */
public interface BdMjxtMjxtMjryjcjlxxQywxMapper 
{
    /**
     * 查询门禁人员进出记录信息
     * 
     * @param zzzj 门禁人员进出记录信息ID
     * @return 门禁人员进出记录信息
     */
    public BdMjxtMjxtMjryjcjlxxQywx selectBdMjxtMjxtMjryjcjlxxQywxById(Integer zzzj);

    /**
     * 查询门禁人员进出记录信息列表
     * 
     * @param bdMjxtMjxtMjryjcjlxxQywx 门禁人员进出记录信息
     * @return 门禁人员进出记录信息集合
     */
    public List<BdMjxtMjxtMjryjcjlxxQywx> selectBdMjxtMjxtMjryjcjlxxQywxList(BdMjxtMjxtMjryjcjlxxQywx bdMjxtMjxtMjryjcjlxxQywx);

    /**
     * 新增门禁人员进出记录信息
     * 
     * @param bdMjxtMjxtMjryjcjlxxQywx 门禁人员进出记录信息
     * @return 结果
     */
    public int insertBdMjxtMjxtMjryjcjlxxQywx(BdMjxtMjxtMjryjcjlxxQywx bdMjxtMjxtMjryjcjlxxQywx);

    /**
     * 修改门禁人员进出记录信息
     * 
     * @param bdMjxtMjxtMjryjcjlxxQywx 门禁人员进出记录信息
     * @return 结果
     */
    public int updateBdMjxtMjxtMjryjcjlxxQywx(BdMjxtMjxtMjryjcjlxxQywx bdMjxtMjxtMjryjcjlxxQywx);

    /**
     * 删除门禁人员进出记录信息
     * 
     * @param zzzj 门禁人员进出记录信息ID
     * @return 结果
     */
    public int deleteBdMjxtMjxtMjryjcjlxxQywxById(Integer zzzj);

    /**
     * 批量删除门禁人员进出记录信息
     * 
     * @param zzzjs 需要删除的数据ID
     * @return 结果
     */
    public int deleteBdMjxtMjxtMjryjcjlxxQywxByIds(Integer[] zzzjs);
}
