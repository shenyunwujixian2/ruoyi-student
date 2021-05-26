package com.ruoyi.dbbase.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学校入住学生（要使用）对象 bd_student_in_school
 * 
 * @author xiaoafu
 * @date 2021-04-07
 */
public class BdStudentInSchool extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学号 */
    @Excel(name = "学号")
    private String xh;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 性别 */
    @Excel(name = "性别")
    private String xb;

    /** 学院名称 */
    @Excel(name = "学院名称")
    private String xymc;

    /** 专业 */
    @Excel(name = "专业")
    private String zymc;

    /** 班级 */
    @Excel(name = "班级")
    private String bjmc;

    /** 当前年级 */
    @Excel(name = "当前年级")
    private String dqnj;

    /** 辅导员 */
    @Excel(name = "辅导员")
    private String teachName;

    /** 宿舍楼 */
    @Excel(name = "宿舍楼")
    private String sslh;

    /** 单元号 */
    @Excel(name = "单元号")
    private String dy;

    /** 宿舍号 */
    @Excel(name = "宿舍号")
    private String shh;

    /** 床位号 */
    @Excel(name = "床位号")
    private String cwh;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String lxfs;

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
    public void setXb(String xb) 
    {
        this.xb = xb;
    }

    public String getXb() 
    {
        return xb;
    }
    public void setXymc(String xymc) 
    {
        this.xymc = xymc;
    }

    public String getXymc() 
    {
        return xymc;
    }
    public void setZymc(String zymc) 
    {
        this.zymc = zymc;
    }

    public String getZymc() 
    {
        return zymc;
    }
    public void setBjmc(String bjmc) 
    {
        this.bjmc = bjmc;
    }

    public String getBjmc() 
    {
        return bjmc;
    }
    public void setDqnj(String dqnj) 
    {
        this.dqnj = dqnj;
    }

    public String getDqnj() 
    {
        return dqnj;
    }
    public void setTeachName(String teachName) 
    {
        this.teachName = teachName;
    }

    public String getTeachName() 
    {
        return teachName;
    }

    public String getSslh() {
        return sslh;
    }

    public void setSslh(String sslh) {
        this.sslh = sslh;
    }

    public void setDy(String dy)
    {
        this.dy = dy;
    }

    public String getDy() 
    {
        return dy;
    }
    public void setShh(String shh) 
    {
        this.shh = shh;
    }

    public String getShh() 
    {
        return shh;
    }
    public void setCwh(String cwh) 
    {
        this.cwh = cwh;
    }

    public String getCwh() 
    {
        return cwh;
    }
    public void setLxfs(String lxfs) 
    {
        this.lxfs = lxfs;
    }

    public String getLxfs() 
    {
        return lxfs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("xh", getXh())
            .append("xm", getXm())
            .append("xb", getXb())
            .append("xymc", getXymc())
            .append("zymc", getZymc())
            .append("bjmc", getBjmc())
            .append("dqnj", getDqnj())
            .append("teachName", getTeachName())
            .append("sslh", getSslh())
            .append("dy", getDy())
            .append("shh", getShh())
            .append("cwh", getCwh())
            .append("lxfs", getLxfs())
            .toString();
    }
}
