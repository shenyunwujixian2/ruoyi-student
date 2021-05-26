package com.ruoyi.record.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *
 * @author heqinze
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_record_each_info")
public class TeacherModel {


    @TableField("pass_time")
    private Date pass_time;

    @TableField("person_name")
    private String person_name;

    @TableField("area_name")
    private String area_name;

    @TableField("guard_group_name")
    private String guard_group_name;

    @TableField("str_inorout")
    private String str_inorout;

    /** 开始时间 */
    private String startshowTime;
    /**
     *  结束时间
     */
    private String  endshowTime;



//全部字段
//    @TableField("id")
//    private int id;
//
//    @TableField("name")
//    private String name;
//
//    @TableField("sort")
//    private int sort;
//
//    @TableField("user_id")
//    private int user_id;
//
//    @TableField("create_by")
//    private String create_by;
//
//    @TableField("create_time")
//    private Date create_time;
//
//    @TableField("update_by")
//    private String update_by;
//
//    @TableField("update_time")
//    private Date update_time ;
//
//    @TableField("remark")
//    private String remark;
//
//    @TableField("record_id")
//    private String record_id;
//
//    @TableField("inorout")
//    private int inorout ;
//
//    @TableField("str_inorout")
//    private String str_inorout;
//
//    @TableField("area_name")
//    private String area_name;
//
//    @TableField("area_code")
//    private String area_code;
//
//    @TableField("person_type")
//    private String person_type;
//
//    @TableField("str_person_type")
//    private String str_person_type;
//
//    @TableField("guard_group_code")
//    private String guard_group_code;
//
//    @TableField("guard_group_name")
//    private String guard_group_name;
//
//    @TableField("person_code")
//    private String person_code;
//
//    @TableField("person_name")
//    private String person_name;
//
//    @TableField("pass_time")
//    private Date pass_time ;
//
//    @TableField("pass_time_str")
//    private String pass_time_str;
//
//    @TableField("info")
//    private String info;
//
//    @TableField("check_status")
//    private int check_status ;
//
//    @TableField("check_time")
//    private Date check_time ;
//
//    @TableField("department_code")
//    private String department_code;
//
//    @TableField("department_name")
//    private String department_name;




}
