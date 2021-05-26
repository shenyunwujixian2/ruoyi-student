package com.ruoyi.record.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.record.domain.UserModel;
import com.ruoyi.record.mapper.UserMapper;
import com.ruoyi.record.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, UserModel> implements UserService {

    @Override
    public boolean add(UserModel baseModel) {
        boolean returnResult = false;
        baseModel.setCreateTime(new Date());
        Integer result = baseMapper.insert(baseModel);
        if(result>0){
            returnResult = true;
        }
        return returnResult;
    }

    @Override
    public boolean edit(UserModel baseModel) {
        boolean returnResult = false;
        Integer result = baseMapper.updateById(baseModel);
        if(result>0){
            returnResult = true;
        }
        return returnResult;
    }

    @Override
    public UserModel getModel(String id) {
        return null;
    }

    @Override
    public UserModel getModelInfo(HashMap<String, Object> args) {
        return null;
    }

    @Override
    public HashMap<String, Object> getMapInfo(HashMap<String, Object> args) {
        return null;
    }

    @Override
    public List<UserModel> getList(HashMap<String, Object> map) {
        return baseMapper.getList(map);
    }

    @Override
    public List<Map<String, Object>> getMapList(HashMap<String, Object> map) {
        return baseMapper.getMapList(map);
    }

}
