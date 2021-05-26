package com.ruoyi.offline.service;

import java.util.List;
import com.ruoyi.offline.domain.ZtsjZtsjJwzxsxxQywx;

/**
 * 教务在校生信息Service接口
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
public interface IZtsjZtsjJwzxsxxQywxService 
{
    /**
     * 查询教务在校生信息
     * 
     * @param xm 教务在校生信息ID
     * @return 教务在校生信息
     */
    public ZtsjZtsjJwzxsxxQywx selectZtsjZtsjJwzxsxxQywxById(String xm);

    /**
     * 查询教务在校生信息列表
     * 
     * @param ztsjZtsjJwzxsxxQywx 教务在校生信息
     * @return 教务在校生信息集合
     */
    public List<ZtsjZtsjJwzxsxxQywx> selectZtsjZtsjJwzxsxxQywxList(ZtsjZtsjJwzxsxxQywx ztsjZtsjJwzxsxxQywx);

    /**
     * 新增教务在校生信息
     * 
     * @param ztsjZtsjJwzxsxxQywx 教务在校生信息
     * @return 结果
     */
    public int insertZtsjZtsjJwzxsxxQywx(ZtsjZtsjJwzxsxxQywx ztsjZtsjJwzxsxxQywx);

    /**
     * 修改教务在校生信息
     * 
     * @param ztsjZtsjJwzxsxxQywx 教务在校生信息
     * @return 结果
     */
    public int updateZtsjZtsjJwzxsxxQywx(ZtsjZtsjJwzxsxxQywx ztsjZtsjJwzxsxxQywx);

    /**
     * 批量删除教务在校生信息
     * 
     * @param xms 需要删除的教务在校生信息ID
     * @return 结果
     */
    public int deleteZtsjZtsjJwzxsxxQywxByIds(String[] xms);

    /**
     * 删除教务在校生信息信息
     * 
     * @param xm 教务在校生信息ID
     * @return 结果
     */
    public int deleteZtsjZtsjJwzxsxxQywxById(String xm);
}
