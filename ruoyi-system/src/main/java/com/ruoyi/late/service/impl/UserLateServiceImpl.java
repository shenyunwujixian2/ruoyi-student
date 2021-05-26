package com.ruoyi.late.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.late.mapper.UserLateMapper;
import com.ruoyi.late.domain.UserLate;
import com.ruoyi.late.service.IUserLateService;

/**
 * 学生晚归迟到记录Service业务层处理
 * 
 * @author 小阿福
 * @date 2021-03-24
 */
@Service
public class UserLateServiceImpl implements IUserLateService
{
    @Autowired
    private UserLateMapper userLateMapper;

    /**
     * 查询学生晚归迟到记录
     * 
     * @param id 学生晚归迟到记录ID
     * @return 学生晚归迟到记录
     */
    @Override
    public UserLate selectUserLateById(Long id)
    {
        return userLateMapper.selectUserLateById(id);
    }

    /**
     * 查询学生晚归迟到记录列表
     * 
     * @param userLate 学生晚归迟到记录
     * @return 学生晚归迟到记录
     */
    @Override
    public List<UserLate> selectUserLateList(UserLate userLate)
    {
        return userLateMapper.selectUserLateList(userLate);
    }

    /**
     * 新增学生晚归迟到记录
     * 
     * @param userLate 学生晚归迟到记录
     * @return 结果
     */
    @Override
    public int insertUserLate(UserLate userLate)
    {
        userLate.setCreateTime(DateUtils.getNowDate());
        return userLateMapper.insertUserLate(userLate);
    }

    /**
     * 修改学生晚归迟到记录
     * 
     * @param userLate 学生晚归迟到记录
     * @return 结果
     */
    @Override
    public int updateUserLate(UserLate userLate)
    {
        userLate.setUpdateTime(DateUtils.getNowDate());
        return userLateMapper.updateUserLate(userLate);
    }

    /**
     * 批量删除学生晚归迟到记录
     * 
     * @param ids 需要删除的学生晚归迟到记录ID
     * @return 结果
     */
    @Override
    public int deleteUserLateByIds(Long[] ids)
    {
        return userLateMapper.deleteUserLateByIds(ids);
    }

    /**
     * 删除学生晚归迟到记录信息
     * 
     * @param id 学生晚归迟到记录ID
     * @return 结果
     */
    @Override
    public int deleteUserLateById(Long id)
    {
        return userLateMapper.deleteUserLateById(id);
    }
    /**
     * 删除学生晚归迟到记录信息
     *
     * @param id 学生晚归迟到记录ID
     * @return 结果
     */
    @Override
    public int deleteUserLateNoBackList(String showTime)
    {
        return userLateMapper.deleteUserLateNoBackList(showTime);
    }

    @Override
    public Map<String, Object> getCountByHashMap(HashMap<String, Object> param) {
        return userLateMapper.getCountByHashMap(param);
    }

    @Override
    public List<Map<String, Object>> getList(HashMap<String, Object> param) {
        return userLateMapper.getList(param);
    }

    /**
     * 获取满足被警告的列表
     * @param param
     * @return
     */
    @Override
    public List<Map<String, Object>> getWaringList(HashMap<String, Object> param) {
        return userLateMapper.getWaringList(param);
    }
    /**
     * 获取满足被警告的列表
     * @param param
     * @return
     */
    @Override
    public List<Map<String, Object>> getByGreadList(HashMap<String, Object> param) {
        return userLateMapper.getByGreadList(param);
    }


}
