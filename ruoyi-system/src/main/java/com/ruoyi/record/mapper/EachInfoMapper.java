package com.ruoyi.record.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.record.domain.EachInfoModel;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 参数配置 数据层
 * 
 * @author ruoyi
 */
public interface EachInfoMapper extends BaseMapper<EachInfoModel>
{
    /**
     * 根据条件 获取单条信息
     *
     * @param map
     * @return
     */
    Map<String, Object> getMapInfo(@Param("param") HashMap<String, Object> map);
    /**
     * 根据条件寻找列表
     *
     * @return
     */
    List<Map<String, Object>> getMapList(@Param("param") HashMap<String, Object> map);

    /**
     * 分页展示
     *
     * @param page
     * @param map
     * @return
     */
    List<EachInfoModel> getList(@Param("param") HashMap<String, Object> map);

    /**
     *  获取单条
     * @param map
     * @return
     */
    EachInfoModel getModelInfo(@Param("param") HashMap<String, Object> map);
}
