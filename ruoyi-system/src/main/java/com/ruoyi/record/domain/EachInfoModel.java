package com.ruoyi.record.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.util.Date;


/**
 * 年级表 sys_record_grades
 * 
 * @author ruoyi
 */
@Data
@TableName("sys_record_each_info")
public class EachInfoModel extends CommonModel<EachInfoModel>
{

    @Excel(name = "记录id")
    @TableField("record_id")
    private String recordId;

    @TableField("inorout")
    private String inorout;

    @Excel(name = "方向")
    @TableField("str_inorout")
    private String strInorout;

    @Excel(name = "区域名")
    @TableField("area_name")
    private String areaName;

    @Excel(name = "编码")
    @TableField("area_code")
    private String areaCode;

    @TableField("person_type")
    private String personType;

    @TableField("str_person_type")
    private String strPersonType;

    @TableField("guard_group_code")
    private String guardGroupCode;

    @Excel(name = "宿舍")
    @TableField("guard_group_name")
    private String guardGroupName;

    @Excel(name = "学号")
    @TableField("person_code")
    private String personCode;

    @Excel(name = "姓名")
    @TableField("person_name")
    private String personName;

    @Excel(name = "通过时间")
    @TableField("pass_time")
    private String passTime;


    @TableField("pass_time_str")
    private String passTimeStr;

    @TableField("info")
    private String info;

    @TableField("check_status")
    private String checkStatus;

    @TableField("check_time")
    private Date checkTime;
    /**
     * 部门编码
     */
    @Excel(name = "部门编码")
    @TableField("department_code")
    private String departmentCode;
    /**
     * 部门名称
     */
    @Excel(name = "部门名称")
    @TableField("department_name")
    private String departmentName;
    /**
     *  查询开始时间
     */
    @TableField(exist = false)
    private String dateStart;
    /**
     * 查询结束时间
     */
    @TableField(exist = false)
    private String dateEnd;
}
