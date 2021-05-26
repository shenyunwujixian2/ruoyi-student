package com.ruoyi.record.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.record.domain.EachDayModel;
import com.ruoyi.record.mapper.EachDayMapper;
import com.ruoyi.record.service.EachDayService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 参数配置 服务层实现
 * 
 * @author ruoyi
 */
@Service
public class EachDayServiceImpl extends ServiceImpl<EachDayMapper, EachDayModel> implements EachDayService {

    @Override
    public boolean add(EachDayModel baseModel) {
        boolean returnResult = false;
        baseModel.setCreateTime(new Date());
        Integer result = baseMapper.insert(baseModel);
        if(result>0){
            returnResult = true;
        }
        return returnResult;
    }

    @Override
    public boolean edit(EachDayModel baseModel) {
        boolean returnResult = false;
        Integer result = baseMapper.updateById(baseModel);
        if(result>0){
            returnResult = true;
        }
        return returnResult;
    }

    @Override
    public EachDayModel getModel(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    public EachDayModel getModelInfo(HashMap<String, Object> args) {
        return baseMapper.getModelInfo(args);
    }

    @Override
    public HashMap<String, Object> getMapInfo(HashMap<String, Object> args) {
        return baseMapper.getMapInfo(args);
    }

    @Override
    public List<EachDayModel> getList(HashMap<String, Object> map) {
        return baseMapper.getList(map);
    }

    @Override
    public List<Map<String, Object>> getMapList(HashMap<String, Object> map) {
        return baseMapper.getMapList(map);
    }

}
