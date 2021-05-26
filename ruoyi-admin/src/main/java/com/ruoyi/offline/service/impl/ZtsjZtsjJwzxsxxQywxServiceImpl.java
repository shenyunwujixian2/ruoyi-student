package com.ruoyi.offline.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.offline.mapper.ZtsjZtsjJwzxsxxQywxMapper;
import com.ruoyi.offline.domain.ZtsjZtsjJwzxsxxQywx;
import com.ruoyi.offline.service.IZtsjZtsjJwzxsxxQywxService;

/**
 * 教务在校生信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class ZtsjZtsjJwzxsxxQywxServiceImpl implements IZtsjZtsjJwzxsxxQywxService 
{
    @Autowired
    private ZtsjZtsjJwzxsxxQywxMapper ztsjZtsjJwzxsxxQywxMapper;

    /**
     * 查询教务在校生信息
     * 
     * @param xm 教务在校生信息ID
     * @return 教务在校生信息
     */
    @Override
    public ZtsjZtsjJwzxsxxQywx selectZtsjZtsjJwzxsxxQywxById(String xm)
    {
        return ztsjZtsjJwzxsxxQywxMapper.selectZtsjZtsjJwzxsxxQywxById(xm);
    }

    /**
     * 查询教务在校生信息列表
     * 
     * @param ztsjZtsjJwzxsxxQywx 教务在校生信息
     * @return 教务在校生信息
     */
    @Override
    public List<ZtsjZtsjJwzxsxxQywx> selectZtsjZtsjJwzxsxxQywxList(ZtsjZtsjJwzxsxxQywx ztsjZtsjJwzxsxxQywx)
    {
        return ztsjZtsjJwzxsxxQywxMapper.selectZtsjZtsjJwzxsxxQywxList(ztsjZtsjJwzxsxxQywx);
    }

    /**
     * 新增教务在校生信息
     * 
     * @param ztsjZtsjJwzxsxxQywx 教务在校生信息
     * @return 结果
     */
    @Override
    public int insertZtsjZtsjJwzxsxxQywx(ZtsjZtsjJwzxsxxQywx ztsjZtsjJwzxsxxQywx)
    {
        return ztsjZtsjJwzxsxxQywxMapper.insertZtsjZtsjJwzxsxxQywx(ztsjZtsjJwzxsxxQywx);
    }

    /**
     * 修改教务在校生信息
     * 
     * @param ztsjZtsjJwzxsxxQywx 教务在校生信息
     * @return 结果
     */
    @Override
    public int updateZtsjZtsjJwzxsxxQywx(ZtsjZtsjJwzxsxxQywx ztsjZtsjJwzxsxxQywx)
    {
        return ztsjZtsjJwzxsxxQywxMapper.updateZtsjZtsjJwzxsxxQywx(ztsjZtsjJwzxsxxQywx);
    }

    /**
     * 批量删除教务在校生信息
     * 
     * @param xms 需要删除的教务在校生信息ID
     * @return 结果
     */
    @Override
    public int deleteZtsjZtsjJwzxsxxQywxByIds(String[] xms)
    {
        return ztsjZtsjJwzxsxxQywxMapper.deleteZtsjZtsjJwzxsxxQywxByIds(xms);
    }

    /**
     * 删除教务在校生信息信息
     * 
     * @param xm 教务在校生信息ID
     * @return 结果
     */
    @Override
    public int deleteZtsjZtsjJwzxsxxQywxById(String xm)
    {
        return ztsjZtsjJwzxsxxQywxMapper.deleteZtsjZtsjJwzxsxxQywxById(xm);
    }
}
