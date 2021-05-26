package com.ruoyi.record.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.record.mapper.RecordEachTmpMapper;
import com.ruoyi.record.domain.RecordEachTmp;
import com.ruoyi.record.service.IRecordEachTmpService;

/**
 * 业务--临时所有用户进出记录抓取Service业务层处理
 * 
 * @author xiaoafu
 * @date 2021-04-13
 */
@Service
public class RecordEachTmpServiceImpl implements IRecordEachTmpService 
{
    @Autowired
    private RecordEachTmpMapper recordEachTmpMapper;

    /**
     * 查询业务--临时所有用户进出记录抓取
     * 
     * @param id 业务--临时所有用户进出记录抓取ID
     * @return 业务--临时所有用户进出记录抓取
     */
    @Override
    public RecordEachTmp selectRecordEachTmpById(Long id)
    {
        return recordEachTmpMapper.selectRecordEachTmpById(id);
    }

    /**
     * 查询业务--临时所有用户进出记录抓取列表
     * 
     * @param recordEachTmp 业务--临时所有用户进出记录抓取
     * @return 业务--临时所有用户进出记录抓取
     */
    @Override
    public List<RecordEachTmp> selectRecordEachTmpList(RecordEachTmp recordEachTmp)
    {
        return recordEachTmpMapper.selectRecordEachTmpList(recordEachTmp);
    }

    /**
     * 新增业务--临时所有用户进出记录抓取
     * 
     * @param recordEachTmp 业务--临时所有用户进出记录抓取
     * @return 结果
     */
    @Override
    public int insertRecordEachTmp(RecordEachTmp recordEachTmp)
    {
        recordEachTmp.setCreateTime(DateUtils.getNowDate());
        return recordEachTmpMapper.insertRecordEachTmp(recordEachTmp);
    }

    /**
     * 修改业务--临时所有用户进出记录抓取
     * 
     * @param recordEachTmp 业务--临时所有用户进出记录抓取
     * @return 结果
     */
    @Override
    public int updateRecordEachTmp(RecordEachTmp recordEachTmp)
    {
        recordEachTmp.setUpdateTime(DateUtils.getNowDate());
        return recordEachTmpMapper.updateRecordEachTmp(recordEachTmp);
    }

    /**
     * 批量删除业务--临时所有用户进出记录抓取
     * 
     * @param ids 需要删除的业务--临时所有用户进出记录抓取ID
     * @return 结果
     */
    @Override
    public int deleteRecordEachTmpByIds(Long[] ids)
    {
        return recordEachTmpMapper.deleteRecordEachTmpByIds(ids);
    }

    /**
     * 删除业务--临时所有用户进出记录抓取信息
     * 
     * @param id 业务--临时所有用户进出记录抓取ID
     * @return 结果
     */
    @Override
    public int deleteRecordEachTmpById(Long id)
    {
        return recordEachTmpMapper.deleteRecordEachTmpById(id);
    }
}
