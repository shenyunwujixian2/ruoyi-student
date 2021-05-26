package com.ruoyi.offline.mapper;

import java.util.List;
import com.ruoyi.offline.domain.XgxtXgxtXsqjsqxxQywx;

/**
 * 学生请假申请信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
public interface XgxtXgxtXsqjsqxxQywxMapper 
{
    /**
     * 查询学生请假申请信息
     * 
     * @param jssj 学生请假申请信息ID
     * @return 学生请假申请信息
     */
    public XgxtXgxtXsqjsqxxQywx selectXgxtXgxtXsqjsqxxQywxById(String jssj);

    /**
     * 查询学生请假申请信息列表
     * 
     * @param xgxtXgxtXsqjsqxxQywx 学生请假申请信息
     * @return 学生请假申请信息集合
     */
    public List<XgxtXgxtXsqjsqxxQywx> selectXgxtXgxtXsqjsqxxQywxList(XgxtXgxtXsqjsqxxQywx xgxtXgxtXsqjsqxxQywx);

    /**
     * 新增学生请假申请信息
     * 
     * @param xgxtXgxtXsqjsqxxQywx 学生请假申请信息
     * @return 结果
     */
    public int insertXgxtXgxtXsqjsqxxQywx(XgxtXgxtXsqjsqxxQywx xgxtXgxtXsqjsqxxQywx);

    /**
     * 修改学生请假申请信息
     * 
     * @param xgxtXgxtXsqjsqxxQywx 学生请假申请信息
     * @return 结果
     */
    public int updateXgxtXgxtXsqjsqxxQywx(XgxtXgxtXsqjsqxxQywx xgxtXgxtXsqjsqxxQywx);

    /**
     * 删除学生请假申请信息
     * 
     * @param jssj 学生请假申请信息ID
     * @return 结果
     */
    public int deleteXgxtXgxtXsqjsqxxQywxById(String jssj);

    /**
     * 批量删除学生请假申请信息
     * 
     * @param jssjs 需要删除的数据ID
     * @return 结果
     */
    public int deleteXgxtXgxtXsqjsqxxQywxByIds(String[] jssjs);
}
