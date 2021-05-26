package com.ruoyi.record.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 业务--临时所有用户进出记录抓取对象 sys_record_each_tmp
 * 
 * @author xiaoafu
 * @date 2021-04-13
 */
public class RecordEachTmp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 年级名 */
    @Excel(name = "年级名")
    private String name;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 记录id */
    @Excel(name = "记录id")
    private String recordId;

    /** 进出状态值 1进 */
    @Excel(name = "进出状态值 1进")
    private String inorout;

    /** '进出描述' */
    @Excel(name = "'进出描述'")
    private String strInorout;

    /** 区域名称 */
    @Excel(name = "区域名称")
    private String areaName;

    /** 区域编码 */
    @Excel(name = "区域编码")
    private String areaCode;

    /** 人员类型 0黑名称 2陌生人 3员工 4访客 */
    @Excel(name = "人员类型 0黑名称 2陌生人 3员工 4访客")
    private String personType;

    /** $column.columnComment */
    @Excel(name = "人员类型 0黑名称 2陌生人 3员工 4访客")
    private String strPersonType;

    /** 门组编码，支持字母、数字和下划线 */
    @Excel(name = "门组编码，支持字母、数字和下划线")
    private String guardGroupCode;

    /** 门组名称 */
    @Excel(name = "门组名称")
    private String guardGroupName;

    /** 人员编号，支持字母、数字和下划线 */
    @Excel(name = "人员编号，支持字母、数字和下划线")
    private String personCode;

    /** 人员编号，支持字母、数字和下划线 */
    @Excel(name = "人员编号，支持字母、数字和下划线")
    private String personName;

    /** 通过时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "通过时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String passTime;

    /** $column.columnComment */
    @Excel(name = "通过时间")
    private String passTimeStr;

    /** 请求得到信息 */
    @Excel(name = "请求得到信息")
    private String info;

    /** 是否处理 0未处理 1 已处理 */
    @Excel(name = "是否处理 0未处理 1 已处理")
    private String checkStatus;

    /** 处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkTime;

    /** 部门编码 */
    @Excel(name = "部门编码")
    private String departmentCode;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String departmentName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() 
    {
        return sort;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setRecordId(String recordId) 
    {
        this.recordId = recordId;
    }

    public String getRecordId() 
    {
        return recordId;
    }
    public void setInorout(String inorout)
    {
        this.inorout = inorout;
    }

    public String getInorout()
    {
        return inorout;
    }
    public void setStrInorout(String strInorout) 
    {
        this.strInorout = strInorout;
    }

    public String getStrInorout() 
    {
        return strInorout;
    }
    public void setAreaName(String areaName) 
    {
        this.areaName = areaName;
    }

    public String getAreaName() 
    {
        return areaName;
    }
    public void setAreaCode(String areaCode) 
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode() 
    {
        return areaCode;
    }
    public void setPersonType(String personType) 
    {
        this.personType = personType;
    }

    public String getPersonType() 
    {
        return personType;
    }
    public void setStrPersonType(String strPersonType) 
    {
        this.strPersonType = strPersonType;
    }

    public String getStrPersonType() 
    {
        return strPersonType;
    }
    public void setGuardGroupCode(String guardGroupCode) 
    {
        this.guardGroupCode = guardGroupCode;
    }

    public String getGuardGroupCode() 
    {
        return guardGroupCode;
    }
    public void setGuardGroupName(String guardGroupName) 
    {
        this.guardGroupName = guardGroupName;
    }

    public String getGuardGroupName() 
    {
        return guardGroupName;
    }
    public void setPersonCode(String personCode) 
    {
        this.personCode = personCode;
    }

    public String getPersonCode() 
    {
        return personCode;
    }
    public void setPersonName(String personName) 
    {
        this.personName = personName;
    }

    public String getPersonName() 
    {
        return personName;
    }
    public void setPassTime(String passTime)
    {
        this.passTime = passTime;
    }

    public String getPassTime()
    {
        return passTime;
    }
    public void setPassTimeStr(String passTimeStr) 
    {
        this.passTimeStr = passTimeStr;
    }

    public String getPassTimeStr() 
    {
        return passTimeStr;
    }
    public void setInfo(String info) 
    {
        this.info = info;
    }

    public String getInfo() 
    {
        return info;
    }
    public void setCheckStatus(String checkStatus)
    {
        this.checkStatus = checkStatus;
    }

    public String getCheckStatus()
    {
        return checkStatus;
    }
    public void setCheckTime(Date checkTime) 
    {
        this.checkTime = checkTime;
    }

    public Date getCheckTime() 
    {
        return checkTime;
    }
    public void setDepartmentCode(String departmentCode) 
    {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentCode() 
    {
        return departmentCode;
    }
    public void setDepartmentName(String departmentName) 
    {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() 
    {
        return departmentName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("sort", getSort())
            .append("userId", getUserId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("recordId", getRecordId())
            .append("inorout", getInorout())
            .append("strInorout", getStrInorout())
            .append("areaName", getAreaName())
            .append("areaCode", getAreaCode())
            .append("personType", getPersonType())
            .append("strPersonType", getStrPersonType())
            .append("guardGroupCode", getGuardGroupCode())
            .append("guardGroupName", getGuardGroupName())
            .append("personCode", getPersonCode())
            .append("personName", getPersonName())
            .append("passTime", getPassTime())
            .append("passTimeStr", getPassTimeStr())
            .append("info", getInfo())
            .append("checkStatus", getCheckStatus())
            .append("checkTime", getCheckTime())
            .append("departmentCode", getDepartmentCode())
            .append("departmentName", getDepartmentName())
            .toString();
    }
}
