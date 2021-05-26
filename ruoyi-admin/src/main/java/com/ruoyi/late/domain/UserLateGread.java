package com.ruoyi.late.domain;

import com.ruoyi.common.annotation.Excel;

import java.io.Serializable;

public class UserLateGread implements Serializable {
    @Excel(name = "二级学院")
    private String dwmc;

    @Excel(name = "班级")
    private String bjjc;

    @Excel(name = "学号")
    private String xh;

    @Excel(name = "姓名")
    private String xm;

    @Excel(name = "违纪类型", readConverterExp = "0=未归,1=已归,2=晚归,4=请假,5=其他")
    private Integer lateStatus;

    @Excel(name = "辅导员处理结结果", readConverterExp = "-1未处理,0=未归,1=确认已归,2=晚归,4=请假,5=其他")
    private Integer teachStatus;

    @Excel(name = "辅导员")
    private String teachName;

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getBjjc() {
        return bjjc;
    }

    public void setBjjc(String bjjc) {
        this.bjjc = bjjc;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    public Integer getLateStatus() {
        return lateStatus;
    }

    public void setLateStatus(Integer lateStatus) {
        this.lateStatus = lateStatus;
    }

    public Integer getTeachStatus() {
        return teachStatus;
    }

    public void setTeachStatus(Integer teachStatus) {
        this.teachStatus = teachStatus;
    }
}
