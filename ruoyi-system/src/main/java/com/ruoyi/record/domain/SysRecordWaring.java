package com.ruoyi.record.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生晚归次数告警信息对象 sys_record_waring
 * 
 * @author xiaoafu
 * @date 2021-04-04
 */
public class SysRecordWaring extends BaseEntity
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

    /** 学号 */
    @Excel(name = "学号")
    private String xh;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 第一次违规时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "第一次违规时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fastTime;

    /** $column.columnComment */
    @Excel(name = "第一次违规时间")
    private Long num;

    /** 老师id */
    @Excel(name = "老师id")
    private String teachId;

    /** 老师名称 */
    @Excel(name = "老师名称")
    private String teachName;

    /** 老师id */
    @Excel(name = "老师id")
    private String lateId;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String bmmc;

    /** 部门代码 */
    @Excel(name = "部门代码")
    private String bmdm;

    /** 联系方 */
    @Excel(name = "联系方")
    private String lxfs;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String zymc;

    /** 专业代码 */
    @Excel(name = "专业代码")
    private String zydm;

    /** 班级简称 */
    @Excel(name = "班级简称")
    private String bjjc;

    /** 班级代码 */
    @Excel(name = "班级代码")
    private String bjdm;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String dwmc;

    /** 单位代码 */
    @Excel(name = "单位代码")
    private String dwdm;

    @Excel(name = "晚归次数")
    private String lateNum;

    @Excel(name = "未归次数")
    private String noBackNum;

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
    public void setXh(String xh) 
    {
        this.xh = xh;
    }

    public String getXh() 
    {
        return xh;
    }
    public void setXm(String xm) 
    {
        this.xm = xm;
    }

    public String getXm() 
    {
        return xm;
    }
    public void setFastTime(Date fastTime) 
    {
        this.fastTime = fastTime;
    }

    public Date getFastTime() 
    {
        return fastTime;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }
    public void setTeachId(String teachId) 
    {
        this.teachId = teachId;
    }

    public String getTeachId() 
    {
        return teachId;
    }
    public void setTeachName(String teachName) 
    {
        this.teachName = teachName;
    }

    public String getTeachName() 
    {
        return teachName;
    }
    public void setLateId(String lateId) 
    {
        this.lateId = lateId;
    }

    public String getLateId() 
    {
        return lateId;
    }
    public void setBmmc(String bmmc) 
    {
        this.bmmc = bmmc;
    }

    public String getBmmc() 
    {
        return bmmc;
    }
    public void setBmdm(String bmdm) 
    {
        this.bmdm = bmdm;
    }

    public String getBmdm() 
    {
        return bmdm;
    }
    public void setLxfs(String lxfs) 
    {
        this.lxfs = lxfs;
    }

    public String getLxfs() 
    {
        return lxfs;
    }
    public void setZymc(String zymc) 
    {
        this.zymc = zymc;
    }

    public String getZymc() 
    {
        return zymc;
    }
    public void setZydm(String zydm) 
    {
        this.zydm = zydm;
    }

    public String getZydm() 
    {
        return zydm;
    }
    public void setBjjc(String bjjc) 
    {
        this.bjjc = bjjc;
    }

    public String getBjjc() 
    {
        return bjjc;
    }
    public void setBjdm(String bjdm) 
    {
        this.bjdm = bjdm;
    }

    public String getBjdm() 
    {
        return bjdm;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getDwdm() {
        return dwdm;
    }

    public void setDwdm(String dwdm) {
        this.dwdm = dwdm;
    }

    public String getLateNum() {
        return lateNum;
    }

    public void setLateNum(String lateNum) {
        this.lateNum = lateNum;
    }

    public String getNoBackNum() {
        return noBackNum;
    }

    public void setNoBackNum(String noBackNum) {
        this.noBackNum = noBackNum;
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
            .append("xh", getXh())
            .append("xm", getXm())
            .append("fastTime", getFastTime())
            .append("num", getNum())
            .append("teachId", getTeachId())
            .append("teachName", getTeachName())
            .append("lateId", getLateId())
            .append("bmmc", getBmmc())
            .append("bmdm", getBmdm())
            .append("lxfs", getLxfs())
            .append("zymc", getZymc())
            .append("zydm", getZydm())
            .append("bjjc", getBjjc())
            .append("bjdm", getBjdm())
            .append("dwmc", getDwmc())
            .append("dwdm", getDwdm())
            .toString();
    }
}
