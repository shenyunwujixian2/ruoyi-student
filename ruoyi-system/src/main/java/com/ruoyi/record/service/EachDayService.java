package com.ruoyi.record.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.record.domain.EachDayModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 年级 服务层
 * 
 * @author ruoyi
 */
public interface EachDayService extends IService<EachDayModel>
{
    /**
     * 新增
     * @param model
     */
    boolean add(EachDayModel model);

    /**
     * 修改
     * @param model
     */
    boolean edit(EachDayModel model);

    /**
     * 获取模型实体
     * @param id
     * @return
     */
    EachDayModel getModel(String id);

    /**
     *  获取条件查询记录
     * @param args 查询条件
     * @return
     */
    EachDayModel getModelInfo(HashMap<String, Object> args);

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
    List<EachDayModel> getList(HashMap<String, Object> args);

    /**
     * 获取列表
     * @param args 查询条件
     * @return
     */
    List<Map<String, Object>> getMapList(HashMap<String, Object> args);

}
