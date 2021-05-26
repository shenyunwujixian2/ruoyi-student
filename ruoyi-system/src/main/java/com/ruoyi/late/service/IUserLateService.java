package com.ruoyi.late.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.late.domain.UserLate;

/**
 * 学生晚归迟到记录Service接口
 * 
 * @author 小阿福
 * @date 2021-03-24
 */
public interface IUserLateService 
{
    /**
     * 查询学生晚归迟到记录
     * 
     * @param id 学生晚归迟到记录ID
     * @return 学生晚归迟到记录
     */
    public UserLate selectUserLateById(Long id);

    /**
     * 查询学生晚归迟到记录列表
     * 
     * @param userLate 学生晚归迟到记录
     * @return 学生晚归迟到记录集合
     */
    public List<UserLate> selectUserLateList(UserLate userLate);

    /**
     * 新增学生晚归迟到记录
     * 
     * @param userLate 学生晚归迟到记录
     * @return 结果
     */
    public int insertUserLate(UserLate userLate);

    /**
     * 修改学生晚归迟到记录
     * 
     * @param userLate 学生晚归迟到记录
     * @return 结果
     */
    public int updateUserLate(UserLate userLate);

    /**
     * 批量删除学生晚归迟到记录
     * 
     * @param ids 需要删除的学生晚归迟到记录ID
     * @return 结果
     */
    public int deleteUserLateByIds(Long[] ids);

    /**
     * 删除学生晚归迟到记录信息
     * 
     * @param id 学生晚归迟到记录ID
     * @return 结果
     */
    public int deleteUserLateById(Long id);
    /**
     * 删除学生晚归迟到记录信息
     *
     * @param id 学生晚归迟到记录ID
     * @return 结果
     */
    public int deleteUserLateNoBackList(String showTime);

    /**
     * 按条件统计
     * @param param
     * @return
     */
    Map<String, Object> getCountByHashMap(HashMap<String,Object> param);
    /**
     * 按条件查询列表
     * @param param
     * @return
     */
    List<Map<String, Object>> getList(HashMap<String,Object> param);
    /**
     *  获取满足被警告的学生列表
     * @param param
     * @return
     */
    List<Map<String, Object>> getWaringList(HashMap<String,Object> param);

    /**
     * 按学院获取
     * @param param
     * @return
     */
    List<Map<String, Object>> getByGreadList(HashMap<String,Object> param);
}
