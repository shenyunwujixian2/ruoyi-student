package com.ruoyi.dbbase.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.record.domain.GradesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dbbase.mapper.BdZtsjZtsjJwzxsxxQywxMapper;
import com.ruoyi.dbbase.domain.BdZtsjZtsjJwzxsxxQywx;
import com.ruoyi.dbbase.service.IBdZtsjZtsjJwzxsxxQywxService;

/**
 * 教务在校生信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
@Service
public class BdZtsjZtsjJwzxsxxQywxServiceImpl implements IBdZtsjZtsjJwzxsxxQywxService 
{
    @Autowired
    private BdZtsjZtsjJwzxsxxQywxMapper bdZtsjZtsjJwzxsxxQywxMapper;

    /**
     * 查询教务在校生信息
     * 
     * @param xm 教务在校生信息ID
     * @return 教务在校生信息
     */
    @Override
    public BdZtsjZtsjJwzxsxxQywx selectBdZtsjZtsjJwzxsxxQywxById(String xm)
    {
        return bdZtsjZtsjJwzxsxxQywxMapper.selectBdZtsjZtsjJwzxsxxQywxById(xm);
    }

    /**
     * 查询教务在校生信息列表
     * 
     * @param bdZtsjZtsjJwzxsxxQywx 教务在校生信息
     * @return 教务在校生信息
     */
    @Override
    public List<BdZtsjZtsjJwzxsxxQywx> selectBdZtsjZtsjJwzxsxxQywxList(BdZtsjZtsjJwzxsxxQywx bdZtsjZtsjJwzxsxxQywx)
    {
        return bdZtsjZtsjJwzxsxxQywxMapper.selectBdZtsjZtsjJwzxsxxQywxList(bdZtsjZtsjJwzxsxxQywx);
    }

    /**
     * 新增教务在校生信息
     * 
     * @param bdZtsjZtsjJwzxsxxQywx 教务在校生信息
     * @return 结果
     */
    @Override
    public int insertBdZtsjZtsjJwzxsxxQywx(BdZtsjZtsjJwzxsxxQywx bdZtsjZtsjJwzxsxxQywx)
    {
        return bdZtsjZtsjJwzxsxxQywxMapper.insertBdZtsjZtsjJwzxsxxQywx(bdZtsjZtsjJwzxsxxQywx);
    }

    /**
     * 修改教务在校生信息
     * 
     * @param bdZtsjZtsjJwzxsxxQywx 教务在校生信息
     * @return 结果
     */
    @Override
    public int updateBdZtsjZtsjJwzxsxxQywx(BdZtsjZtsjJwzxsxxQywx bdZtsjZtsjJwzxsxxQywx)
    {
        return bdZtsjZtsjJwzxsxxQywxMapper.updateBdZtsjZtsjJwzxsxxQywx(bdZtsjZtsjJwzxsxxQywx);
    }

    /**
     * 批量删除教务在校生信息
     * 
     * @param xms 需要删除的教务在校生信息ID
     * @return 结果
     */
    @Override
    public int deleteBdZtsjZtsjJwzxsxxQywxByIds(String[] xms)
    {
        return bdZtsjZtsjJwzxsxxQywxMapper.deleteBdZtsjZtsjJwzxsxxQywxByIds(xms);
    }

    /**
     * 删除教务在校生信息信息
     * 
     * @param xm 教务在校生信息ID
     * @return 结果
     */
    @Override
    public int deleteBdZtsjZtsjJwzxsxxQywxById(String xm)
    {
        return bdZtsjZtsjJwzxsxxQywxMapper.deleteBdZtsjZtsjJwzxsxxQywxById(xm);
    }
    /**
     * 删除教务在校生信息信息
     *
     * @param xm 教务在校生信息ID
     * @return 结果
     */
    @Override
    public int deleteBdZtsjZtsjJwzxsxxQywxByLocal(String local)
    {
        return bdZtsjZtsjJwzxsxxQywxMapper.deleteBdZtsjZtsjJwzxsxxQywxByLocal(local);
    }

    @Override
    public List<Map<String, Object>> getMapList(HashMap<String, Object> map) {
        return bdZtsjZtsjJwzxsxxQywxMapper.getMapList(map);
    }

}
