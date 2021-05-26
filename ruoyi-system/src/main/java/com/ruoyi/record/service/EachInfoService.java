package com.ruoyi.record.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.record.domain.EachInfoModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 年级 服务层
 * 
 * @author ruoyi
 */
public interface EachInfoService extends IService<EachInfoModel>
{
    /**
     * 新增
     * @param model
     */
    boolean add(EachInfoModel model);

    /**
     * 修改
     * @param model
     */
    boolean edit(EachInfoModel model);

    /**
     * 获取模型实体
     * @param id
     * @return
     */
    EachInfoModel getModel(String id);

    /**
     *  获取条件查询记录
     * @param args 查询条件
     * @return
     */
    EachInfoModel getModelInfo(HashMap<String, Object> args);

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
    List<EachInfoModel> getList(HashMap<String, Object> args);

    /**
     * 获取列表
     * @param args 查询条件
     * @return
     */
    List<Map<String, Object>> getMapList(HashMap<String, Object> args);

}
