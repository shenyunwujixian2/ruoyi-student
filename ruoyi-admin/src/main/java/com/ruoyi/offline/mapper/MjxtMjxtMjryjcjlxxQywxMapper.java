package com.ruoyi.offline.mapper;

import java.util.List;
import com.ruoyi.offline.domain.MjxtMjxtMjryjcjlxxQywx;

/**
 * 门禁人员进出记录信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
public interface MjxtMjxtMjryjcjlxxQywxMapper 
{
    /**
     * 查询门禁人员进出记录信息
     * 
     * @param zzzj 门禁人员进出记录信息ID
     * @return 门禁人员进出记录信息
     */
    public MjxtMjxtMjryjcjlxxQywx selectMjxtMjxtMjryjcjlxxQywxById(Integer zzzj);

    /**
     * 查询门禁人员进出记录信息列表
     * 
     * @param mjxtMjxtMjryjcjlxxQywx 门禁人员进出记录信息
     * @return 门禁人员进出记录信息集合
     */
    public List<MjxtMjxtMjryjcjlxxQywx> selectMjxtMjxtMjryjcjlxxQywxList(MjxtMjxtMjryjcjlxxQywx mjxtMjxtMjryjcjlxxQywx);

    /**
     * 新增门禁人员进出记录信息
     * 
     * @param mjxtMjxtMjryjcjlxxQywx 门禁人员进出记录信息
     * @return 结果
     */
    public int insertMjxtMjxtMjryjcjlxxQywx(MjxtMjxtMjryjcjlxxQywx mjxtMjxtMjryjcjlxxQywx);

    /**
     * 修改门禁人员进出记录信息
     * 
     * @param mjxtMjxtMjryjcjlxxQywx 门禁人员进出记录信息
     * @return 结果
     */
    public int updateMjxtMjxtMjryjcjlxxQywx(MjxtMjxtMjryjcjlxxQywx mjxtMjxtMjryjcjlxxQywx);

    /**
     * 删除门禁人员进出记录信息
     * 
     * @param zzzj 门禁人员进出记录信息ID
     * @return 结果
     */
    public int deleteMjxtMjxtMjryjcjlxxQywxById(Integer zzzj);

    /**
     * 批量删除门禁人员进出记录信息
     * 
     * @param zzzjs 需要删除的数据ID
     * @return 结果
     */
    public int deleteMjxtMjxtMjryjcjlxxQywxByIds(Integer[] zzzjs);
}
