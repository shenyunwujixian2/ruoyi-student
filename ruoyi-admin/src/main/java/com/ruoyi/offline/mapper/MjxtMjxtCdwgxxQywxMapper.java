package com.ruoyi.offline.mapper;

import java.util.List;
import com.ruoyi.offline.domain.MjxtMjxtCdwgxxQywx;

/**
 * 迟到晚归信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
public interface MjxtMjxtCdwgxxQywxMapper 
{
    /**
     * 查询迟到晚归信息
     * 
     * @param xm 迟到晚归信息ID
     * @return 迟到晚归信息
     */
    public MjxtMjxtCdwgxxQywx selectMjxtMjxtCdwgxxQywxById(String xm);

    /**
     * 查询迟到晚归信息列表
     * 
     * @param mjxtMjxtCdwgxxQywx 迟到晚归信息
     * @return 迟到晚归信息集合
     */
    public List<MjxtMjxtCdwgxxQywx> selectMjxtMjxtCdwgxxQywxList(MjxtMjxtCdwgxxQywx mjxtMjxtCdwgxxQywx);

    /**
     * 新增迟到晚归信息
     * 
     * @param mjxtMjxtCdwgxxQywx 迟到晚归信息
     * @return 结果
     */
    public int insertMjxtMjxtCdwgxxQywx(MjxtMjxtCdwgxxQywx mjxtMjxtCdwgxxQywx);

    /**
     * 修改迟到晚归信息
     * 
     * @param mjxtMjxtCdwgxxQywx 迟到晚归信息
     * @return 结果
     */
    public int updateMjxtMjxtCdwgxxQywx(MjxtMjxtCdwgxxQywx mjxtMjxtCdwgxxQywx);

    /**
     * 删除迟到晚归信息
     * 
     * @param xm 迟到晚归信息ID
     * @return 结果
     */
    public int deleteMjxtMjxtCdwgxxQywxById(String xm);

    /**
     * 批量删除迟到晚归信息
     * 
     * @param xms 需要删除的数据ID
     * @return 结果
     */
    public int deleteMjxtMjxtCdwgxxQywxByIds(String[] xms);
}
