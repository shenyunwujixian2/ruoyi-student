package com.ruoyi.dbbase.mapper;

import java.util.List;
import com.ruoyi.dbbase.domain.BdMjxtMjxtCdwgxxQywx;

/**
 * 迟到晚归信息Mapper接口
 * 
 * @author yufu
 * @date 2021-04-01
 */
public interface BdMjxtMjxtCdwgxxQywxMapper 
{
    /**
     * 查询迟到晚归信息
     * 
     * @param xm 迟到晚归信息ID
     * @return 迟到晚归信息
     */
    public BdMjxtMjxtCdwgxxQywx selectBdMjxtMjxtCdwgxxQywxById(String xm);

    /**
     * 查询迟到晚归信息列表
     * 
     * @param bdMjxtMjxtCdwgxxQywx 迟到晚归信息
     * @return 迟到晚归信息集合
     */
    public List<BdMjxtMjxtCdwgxxQywx> selectBdMjxtMjxtCdwgxxQywxList(BdMjxtMjxtCdwgxxQywx bdMjxtMjxtCdwgxxQywx);

    /**
     * 新增迟到晚归信息
     * 
     * @param bdMjxtMjxtCdwgxxQywx 迟到晚归信息
     * @return 结果
     */
    public int insertBdMjxtMjxtCdwgxxQywx(BdMjxtMjxtCdwgxxQywx bdMjxtMjxtCdwgxxQywx);

    /**
     * 修改迟到晚归信息
     * 
     * @param bdMjxtMjxtCdwgxxQywx 迟到晚归信息
     * @return 结果
     */
    public int updateBdMjxtMjxtCdwgxxQywx(BdMjxtMjxtCdwgxxQywx bdMjxtMjxtCdwgxxQywx);

    /**
     * 删除迟到晚归信息
     * 
     * @param xm 迟到晚归信息ID
     * @return 结果
     */
    public int deleteBdMjxtMjxtCdwgxxQywxById(String xm);

    /**
     * 批量删除迟到晚归信息
     * 
     * @param xms 需要删除的数据ID
     * @return 结果
     */
    public int deleteBdMjxtMjxtCdwgxxQywxByIds(String[] xms);
}
