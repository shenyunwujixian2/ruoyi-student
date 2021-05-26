package com.ruoyi.record.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.record.domain.GradesModel;
import com.ruoyi.record.mapper.GradesMapper;
import com.ruoyi.record.service.GradesService;
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
public class GradesServiceImpl  extends ServiceImpl<GradesMapper, GradesModel> implements GradesService {

    @Override
    public boolean add(GradesModel baseModel) {
        boolean returnResult = false;
        baseModel.setCreateTime(new Date());
        Integer result = baseMapper.insert(baseModel);
        if(result>0){
            returnResult = true;
        }
        return returnResult;
    }

    @Override
    public boolean edit(GradesModel baseModel) {
        boolean returnResult = false;
        Integer result = baseMapper.updateById(baseModel);
        if(result>0){
            returnResult = true;
        }
        return returnResult;
    }

    @Override
    public GradesModel getModel(String id) {
        return null;
    }

    @Override
    public GradesModel getModelInfo(HashMap<String, Object> args) {
        return null;
    }

    @Override
    public HashMap<String, Object> getMapInfo(HashMap<String, Object> args) {
        return null;
    }

    @Override
    public List<GradesModel> getList(HashMap<String, Object> map) {
        return baseMapper.getList(map);
    }

    @Override
    public List<Map<String, Object>> getMapList(HashMap<String, Object> map) {
        return baseMapper.getMapList(map);
    }

}
