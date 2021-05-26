package com.ruoyi.offline.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.offline.mapper.XgxtXgxtBjfdyxxQywxMapper;
import com.ruoyi.offline.domain.XgxtXgxtBjfdyxxQywx;
import com.ruoyi.offline.service.IXgxtXgxtBjfdyxxQywxService;

/**
 * 学工班级辅导信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class XgxtXgxtBjfdyxxQywxServiceImpl implements IXgxtXgxtBjfdyxxQywxService 
{
    @Autowired
    private XgxtXgxtBjfdyxxQywxMapper xgxtXgxtBjfdyxxQywxMapper;

    /**
     * 查询学工班级辅导信息
     * 
     * @param bjxxbh 学工班级辅导信息ID
     * @return 学工班级辅导信息
     */
    @Override
    public XgxtXgxtBjfdyxxQywx selectXgxtXgxtBjfdyxxQywxById(String bjxxbh)
    {
        return xgxtXgxtBjfdyxxQywxMapper.selectXgxtXgxtBjfdyxxQywxById(bjxxbh);
    }

    /**
     * 查询学工班级辅导信息列表
     * 
     * @param xgxtXgxtBjfdyxxQywx 学工班级辅导信息
     * @return 学工班级辅导信息
     */
    @Override
    public List<XgxtXgxtBjfdyxxQywx> selectXgxtXgxtBjfdyxxQywxList(XgxtXgxtBjfdyxxQywx xgxtXgxtBjfdyxxQywx)
    {
        return xgxtXgxtBjfdyxxQywxMapper.selectXgxtXgxtBjfdyxxQywxList(xgxtXgxtBjfdyxxQywx);
    }

    /**
     * 新增学工班级辅导信息
     * 
     * @param xgxtXgxtBjfdyxxQywx 学工班级辅导信息
     * @return 结果
     */
    @Override
    public int insertXgxtXgxtBjfdyxxQywx(XgxtXgxtBjfdyxxQywx xgxtXgxtBjfdyxxQywx)
    {
        return xgxtXgxtBjfdyxxQywxMapper.insertXgxtXgxtBjfdyxxQywx(xgxtXgxtBjfdyxxQywx);
    }

    /**
     * 修改学工班级辅导信息
     * 
     * @param xgxtXgxtBjfdyxxQywx 学工班级辅导信息
     * @return 结果
     */
    @Override
    public int updateXgxtXgxtBjfdyxxQywx(XgxtXgxtBjfdyxxQywx xgxtXgxtBjfdyxxQywx)
    {
        return xgxtXgxtBjfdyxxQywxMapper.updateXgxtXgxtBjfdyxxQywx(xgxtXgxtBjfdyxxQywx);
    }

    /**
     * 批量删除学工班级辅导信息
     * 
     * @param bjxxbhs 需要删除的学工班级辅导信息ID
     * @return 结果
     */
    @Override
    public int deleteXgxtXgxtBjfdyxxQywxByIds(String[] bjxxbhs)
    {
        return xgxtXgxtBjfdyxxQywxMapper.deleteXgxtXgxtBjfdyxxQywxByIds(bjxxbhs);
    }

    /**
     * 删除学工班级辅导信息信息
     * 
     * @param bjxxbh 学工班级辅导信息ID
     * @return 结果
     */
    @Override
    public int deleteXgxtXgxtBjfdyxxQywxById(String bjxxbh)
    {
        return xgxtXgxtBjfdyxxQywxMapper.deleteXgxtXgxtBjfdyxxQywxById(bjxxbh);
    }

    @Override
    public List<Map<String, Object>> getMapList(HashMap<String, Object> map) {
        return xgxtXgxtBjfdyxxQywxMapper.getMapList(map);
    }
}
