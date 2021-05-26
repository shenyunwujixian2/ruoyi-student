package com.ruoyi.late.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class TeachLateNum implements Serializable {
    @Excel(name = "学院")
    private String dwmc;

    @Excel(name = "班级")
    private String bjmc;

    @Excel(name = "辅导员")
    private String fdy;

    @Excel(name = "晚归人数")
    private String lateNum;

    @Excel(name = "未归人数")
    private String noBackNum;

    @Excel(name = "黄牌警告")
    private String yellowWaringNum;

    @Excel(name = "红牌警告")
    private String redWaringNum;

    @Excel(name = "未处理")
    private String teachNoStatusNum;
}
