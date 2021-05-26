package com.ruoyi.dbbase.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学校专业对象 bd_student_gread
 * 
 * @author ruoyi
 * @date 2021-04-02
 */
public class BdStudentGread extends BaseEntity
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

    /** 当前年级 */
    @Excel(name = "当前年级")
    private String dqnj;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String dwmc;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String dwdm;

    /** 班级代码 */
    @Excel(name = "班级代码")
    private String bjdm;

    /** 班级简称 */
    @Excel(name = "班级简称")
    private String bjjc;

    /** 学生数量 */
    @Excel(name = "学生数量")
    private Long studentNum;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String zymc;

    /** 专业代码 */
    @Excel(name = "专业代码")
    private String zydm;

    public String getZymc() {
        return zymc;
    }

    public void setZymc(String zymc) {
        this.zymc = zymc;
    }

    public String getZydm() {
        return zydm;
    }

    public void setZydm(String zydm) {
        this.zydm = zydm;
    }

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
    public void setDqnj(String dqnj) 
    {
        this.dqnj = dqnj;
    }

    public String getDqnj() 
    {
        return dqnj;
    }
    public void setDwmc(String dwmc) 
    {
        this.dwmc = dwmc;
    }

    public String getDwmc() 
    {
        return dwmc;
    }
    public void setDwdm(String dwdm) 
    {
        this.dwdm = dwdm;
    }

    public String getDwdm() 
    {
        return dwdm;
    }
    public void setBjdm(String bjdm) 
    {
        this.bjdm = bjdm;
    }

    public String getBjdm() 
    {
        return bjdm;
    }
    public void setBjjc(String bjjc) 
    {
        this.bjjc = bjjc;
    }

    public String getBjjc() 
    {
        return bjjc;
    }
    public void setStudentNum(Long studentNum) 
    {
        this.studentNum = studentNum;
    }

    public Long getStudentNum() 
    {
        return studentNum;
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
            .append("dqnj", getDqnj())
            .append("dwmc", getDwmc())
            .append("dwdm", getDwdm())
            .append("bjdm", getBjdm())
            .append("bjjc", getBjjc())
            .append("studentNum", getStudentNum())
            .toString();
    }
}
