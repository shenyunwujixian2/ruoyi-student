package com.ruoyi.offline.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.offline.domain.XgxtXgxtBjfdyxxQywx;
import org.apache.ibatis.annotations.Param;

/**
 * 学工班级辅导信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
public interface XgxtXgxtBjfdyxxQywxMapper 
{
    /**
     * 查询学工班级辅导信息
     * 
     * @param bjxxbh 学工班级辅导信息ID
     * @return 学工班级辅导信息
     */
    public XgxtXgxtBjfdyxxQywx selectXgxtXgxtBjfdyxxQywxById(String bjxxbh);

    /**
     * 查询学工班级辅导信息列表
     * 
     * @param xgxtXgxtBjfdyxxQywx 学工班级辅导信息
     * @return 学工班级辅导信息集合
     */
    public List<XgxtXgxtBjfdyxxQywx> selectXgxtXgxtBjfdyxxQywxList(XgxtXgxtBjfdyxxQywx xgxtXgxtBjfdyxxQywx);

    /**
     * 新增学工班级辅导信息
     * 
     * @param xgxtXgxtBjfdyxxQywx 学工班级辅导信息
     * @return 结果
     */
    public int insertXgxtXgxtBjfdyxxQywx(XgxtXgxtBjfdyxxQywx xgxtXgxtBjfdyxxQywx);

    /**
     * 修改学工班级辅导信息
     * 
     * @param xgxtXgxtBjfdyxxQywx 学工班级辅导信息
     * @return 结果
     */
    public int updateXgxtXgxtBjfdyxxQywx(XgxtXgxtBjfdyxxQywx xgxtXgxtBjfdyxxQywx);

    /**
     * 删除学工班级辅导信息
     * 
     * @param bjxxbh 学工班级辅导信息ID
     * @return 结果
     */
    public int deleteXgxtXgxtBjfdyxxQywxById(String bjxxbh);

    /**
     * 批量删除学工班级辅导信息
     * 
     * @param bjxxbhs 需要删除的数据ID
     * @return 结果
     */
    public int deleteXgxtXgxtBjfdyxxQywxByIds(String[] bjxxbhs);

    /**
     * 获取列表
     * @param map
     * @return
     */
    List<Map<String, Object>> getMapList(@Param("param") HashMap<String, Object> map);
}
