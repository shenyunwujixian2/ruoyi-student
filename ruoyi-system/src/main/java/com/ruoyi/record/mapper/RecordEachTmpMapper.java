package com.ruoyi.record.mapper;

import java.util.List;
import com.ruoyi.record.domain.RecordEachTmp;

/**
 * 业务--临时所有用户进出记录抓取Mapper接口
 * 
 * @author xiaoafu
 * @date 2021-04-13
 */
public interface RecordEachTmpMapper 
{
    /**
     * 查询业务--临时所有用户进出记录抓取
     * 
     * @param id 业务--临时所有用户进出记录抓取ID
     * @return 业务--临时所有用户进出记录抓取
     */
    public RecordEachTmp selectRecordEachTmpById(Long id);

    /**
     * 查询业务--临时所有用户进出记录抓取列表
     * 
     * @param recordEachTmp 业务--临时所有用户进出记录抓取
     * @return 业务--临时所有用户进出记录抓取集合
     */
    public List<RecordEachTmp> selectRecordEachTmpList(RecordEachTmp recordEachTmp);

    /**
     * 新增业务--临时所有用户进出记录抓取
     * 
     * @param recordEachTmp 业务--临时所有用户进出记录抓取
     * @return 结果
     */
    public int insertRecordEachTmp(RecordEachTmp recordEachTmp);

    /**
     * 修改业务--临时所有用户进出记录抓取
     * 
     * @param recordEachTmp 业务--临时所有用户进出记录抓取
     * @return 结果
     */
    public int updateRecordEachTmp(RecordEachTmp recordEachTmp);

    /**
     * 删除业务--临时所有用户进出记录抓取
     * 
     * @param id 业务--临时所有用户进出记录抓取ID
     * @return 结果
     */
    public int deleteRecordEachTmpById(Long id);

    /**
     * 批量删除业务--临时所有用户进出记录抓取
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecordEachTmpByIds(Long[] ids);
}
