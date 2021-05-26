package com.ruoyi.dbbase.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.dbbase.domain.BdZtsjZtsjJwzxsxxQywx;

/**
 * 教务在校生信息Service接口
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
public interface IBdZtsjZtsjJwzxsxxQywxService 
{
    /**
     * 查询教务在校生信息
     * 
     * @param xm 教务在校生信息ID
     * @return 教务在校生信息
     */
    public BdZtsjZtsjJwzxsxxQywx selectBdZtsjZtsjJwzxsxxQywxById(String xm);

    /**
     * 查询教务在校生信息列表
     * 
     * @param bdZtsjZtsjJwzxsxxQywx 教务在校生信息
     * @return 教务在校生信息集合
     */
    public List<BdZtsjZtsjJwzxsxxQywx> selectBdZtsjZtsjJwzxsxxQywxList(BdZtsjZtsjJwzxsxxQywx bdZtsjZtsjJwzxsxxQywx);

    /**
     * 新增教务在校生信息
     * 
     * @param bdZtsjZtsjJwzxsxxQywx 教务在校生信息
     * @return 结果
     */
    public int insertBdZtsjZtsjJwzxsxxQywx(BdZtsjZtsjJwzxsxxQywx bdZtsjZtsjJwzxsxxQywx);

    /**
     * 修改教务在校生信息
     * 
     * @param bdZtsjZtsjJwzxsxxQywx 教务在校生信息
     * @return 结果
     */
    public int updateBdZtsjZtsjJwzxsxxQywx(BdZtsjZtsjJwzxsxxQywx bdZtsjZtsjJwzxsxxQywx);

    /**
     * 批量删除教务在校生信息
     * 
     * @param xms 需要删除的教务在校生信息ID
     * @return 结果
     */
    public int deleteBdZtsjZtsjJwzxsxxQywxByIds(String[] xms);

    /**
     * 删除教务在校生信息信息
     * 
     * @param xm 教务在校生信息ID
     * @return 结果
     */
    public int deleteBdZtsjZtsjJwzxsxxQywxById(String xm);
    /**
     * 删除教务在校生信息信息
     *
     * @param xm 教务在校生信息ID
     * @return 结果
     */
    public int deleteBdZtsjZtsjJwzxsxxQywxByLocal(String local);

    /**
     * 获取列表
     * @param args 查询条件
     * @return
     */
    List<Map<String, Object>> getMapList(HashMap<String, Object> args);
}
