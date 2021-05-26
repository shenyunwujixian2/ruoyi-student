package com.ruoyi.record.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.record.domain.PushMessageModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 年级 服务层
 * 
 * @author ruoyi
 */
public interface PushMessageService extends IService<PushMessageModel>
{
    /**
     * 新增
     * @param model
     */
    boolean add(PushMessageModel model);

    /**
     * 修改
     * @param model
     */
    boolean edit(PushMessageModel model);

    /**
     * 获取模型实体
     * @param id
     * @return
     */
    PushMessageModel getModel(String id);

    /**
     *  获取条件查询记录
     * @param args 查询条件
     * @return
     */
    PushMessageModel getModelInfo(HashMap<String, Object> args);

    /**
     *  获取条件查询记录
     * @param args 查询条件
     * @return
     */
    HashMap<String, Object> getMapInfo(HashMap<String, Object> args);

    /**
     * 获取列表
     * @param args 查询条件
     * @return
     */
    List<PushMessageModel> getList(HashMap<String, Object> args);

    /**
     * 获取列表
     * @param args 查询条件
     * @return
     */
    List<Map<String, Object>> getMapList(HashMap<String, Object> args);

}
