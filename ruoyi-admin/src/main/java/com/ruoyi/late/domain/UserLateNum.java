package com.ruoyi.late.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserLateNum implements Serializable {
    @Excel(name = "二级学院")
    private String dwmc;

    @Excel(name = "班级")
    private String bjjc;

    @Excel(name = "学号")
    private String xh;

    @Excel(name = "姓名")
    private String xm;

    @Excel(name = "辅导员")
    private String teachName;

    @Excel(name = "晚归次数")
    private String lateNum;

//    @Excel(name = "晚归未处理次数")
    private String lateNumNoStatus;

//    @Excel(name = "所有晚归次数")
    private String allLateNum;

    @Excel(name = "未归次数")
    private String noBackNum;

//    @Excel(name = "未归未处理次数")
    private String noBackNumNoStatus;

//    @Excel(name = "所有未归次数")
    private String allNoBackNum;

    @Excel(name = "未处理次数")
    private String allNoTeachStatus;

    @Excel(name = "黄牌警告")
    private String yellowWaringNum;

    @Excel(name = "红牌警告")
    private String redWaringNum;


    @Excel(name = "警告处分")
    private String jgcfNum;

    @Excel(name = "严重警告处分")
    private String yzjgNum;

    @Excel(name = "记过处分")
    private String jgChuFenNum;

    @Excel(name = "留校察看处分")
    private String lxckNum;

}
