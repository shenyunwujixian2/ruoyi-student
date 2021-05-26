package com.ruoyi.record.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.record.domain.GradesModel;

/**
 * 年级 服务层
 * 
 * @author ruoyi
 */
public interface GradesService extends IService<GradesModel>
{
    /**
     * 新增
     * @param model
     */
    boolean add(GradesModel model);

    /**
     * 修改
     * @param model
     */
    boolean edit(GradesModel model);

    /**
     * 获取模型实体
     * @param id
     * @return
     */
    GradesModel getModel(String id);

    /**
     *  获取条件查询记录
     * @param args 查询条件
     * @return
     */
    GradesModel getModelInfo(HashMap<String, Object> args);

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
    List<GradesModel> getList(HashMap<String, Object> args);

    /**
     * 获取列表
     * @param args 查询条件
     * @return
     */
    List<Map<String, Object>> getMapList(HashMap<String, Object> args);

}
