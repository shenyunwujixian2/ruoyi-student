package com.ruoyi.record.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.record.domain.SysRecordWaring;
import org.apache.ibatis.annotations.Param;

/**
 * 学生晚归次数告警信息Mapper接口
 * 
 * @author xiaoafu
 * @date 2021-04-04
 */
public interface SysRecordWaringMapper 
{
    /**
     * 查询学生晚归次数告警信息
     * 
     * @param id 学生晚归次数告警信息ID
     * @return 学生晚归次数告警信息
     */
    public SysRecordWaring selectSysRecordWaringById(Long id);

    /**
     * 查询学生晚归次数告警信息列表
     * 
     * @param sysRecordWaring 学生晚归次数告警信息
     * @return 学生晚归次数告警信息集合
     */
    public List<SysRecordWaring> selectSysRecordWaringList(SysRecordWaring sysRecordWaring);

    /**
     * 新增学生晚归次数告警信息
     * 
     * @param sysRecordWaring 学生晚归次数告警信息
     * @return 结果
     */
    public int insertSysRecordWaring(SysRecordWaring sysRecordWaring);

    /**
     * 修改学生晚归次数告警信息
     * 
     * @param sysRecordWaring 学生晚归次数告警信息
     * @return 结果
     */
    public int updateSysRecordWaring(SysRecordWaring sysRecordWaring);

    /**
     * 删除学生晚归次数告警信息
     * 
     * @param id 学生晚归次数告警信息ID
     * @return 结果
     */
    public int deleteSysRecordWaringById(Long id);

    /**
     * 批量删除学生晚归次数告警信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysRecordWaringByIds(Long[] ids);


    /**
     * 根据条件寻找列表
     *
     * @return
     */
    List<Map<String, Object>> getCount(@Param("param") HashMap<String, Object> map);
}
