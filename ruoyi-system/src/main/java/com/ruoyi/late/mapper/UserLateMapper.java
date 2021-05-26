package com.ruoyi.late.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.late.domain.UserLate;
import org.apache.ibatis.annotations.Param;

/**
 * 学生晚归迟到记录Mapper接口
 *
 * @author 小阿福
 * @date 2021-03-24
 */
public interface UserLateMapper 
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
     * 删除学生晚归迟到记录
     * 
     * @param id 学生晚归迟到记录ID
     * @return 结果
     */
    public int deleteUserLateById(Long id);
    /**
     * 删除学生晚归迟到记录
     *
     * @param id 学生晚归迟到记录ID
     * @return 结果
     */
    public int deleteUserLateNoBackList(String showTime);

    /**
     * 批量删除学生晚归迟到记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserLateByIds(Long[] ids);

    /**
     * 获取数量
     * @param param
     * @return
     */
    Map<String, Object> getCountByHashMap(@Param("param") HashMap<String,Object> param);
    /**
     * 获取列表
     * @param param
     * @return
     */
    List<Map<String, Object>> getList(@Param("param") HashMap<String,Object> param);
    /**
     * 获取满足被警告的列表
     * @param param
     * @return
     */
    List<Map<String, Object>> getWaringList(@Param("param") HashMap<String,Object> param);
    /**
     * 按学院获取
     * @param param
     * @return
     */
    List<Map<String, Object>> getByGreadList(@Param("param") HashMap<String,Object> param);
}
