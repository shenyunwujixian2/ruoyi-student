package com.ruoyi.record.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.record.domain.EachInfoModel;
import com.ruoyi.record.mapper.EachInfoMapper;
import com.ruoyi.record.service.EachInfoService;
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
public class EachInfoServiceImpl extends ServiceImpl<EachInfoMapper, EachInfoModel> implements EachInfoService {

    @Override
    public boolean add(EachInfoModel baseModel) {
        boolean returnResult = false;
        baseModel.setCreateTime(new Date());
        Integer result = baseMapper.insert(baseModel);
        if(result>0){
            returnResult = true;
        }
        return returnResult;
    }

    @Override
    public boolean edit(EachInfoModel baseModel) {
        boolean returnResult = false;
        Integer result = baseMapper.updateById(baseModel);
        if(result>0){
            returnResult = true;
        }
        return returnResult;
    }

    @Override
    public EachInfoModel getModel(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    public EachInfoModel getModelInfo(HashMap<String, Object> args) {
        return baseMapper.getModelInfo(args);
    }

    @Override
    public HashMap<String, Object> getMapInfo(HashMap<String, Object> args) {
        return null;
    }

    @Override
    public List<EachInfoModel> getList(HashMap<String, Object> map) {
        return baseMapper.getList(map);
    }

    @Override
    public List<Map<String, Object>> getMapList(HashMap<String, Object> map) {
        return baseMapper.getMapList(map);
    }

}
