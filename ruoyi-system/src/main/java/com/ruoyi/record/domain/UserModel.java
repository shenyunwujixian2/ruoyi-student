package com.ruoyi.record.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import lombok.Data;

/**
 * 年级表 sys_record_grades
 * 
 * @author ruoyi
 */
@Data
@TableName("sys_record_user")
public class UserModel extends CommonModel<UserModel>
{

    /** 参数名称 */
    @Excel(name = "参数名称")
    @TableField("namess")
    private String namess;

    @TableField("bluetooth_card")
    private String bluetoothCard;

    @TableField("qrcode")
    private String qrcode;

    @TableField("telephone")
    private String telephone;

    @TableField("address")
    private String address;

    @TableField("pic_num")
    private String picNum;

    @TableField("sex")
    private String sex;

    @TableField("feature")
    private String feature;

    @TableField("pic_zero")
    private String picZero;

    @TableField("spell")
    private String spell;

    @TableField("ic_card")
    private String icCard;

    @TableField("area_name")
    private String areaName;

    @TableField("department")
    private String department;

    @TableField("card_type")
    private String cardType;

    @TableField("id_card")
    private String idCard;

    @TableField("seqid")
    private String seqid;

    @TableField("status")
    private String status;

    @TableField("pic_one")
    private String picOne;

    @TableField("depart_code")
    private String departCode;

    @TableField("code")
    private String code;

    @TableField("register_time")
    private String registerTime;

    @TableField("pic_minus_one")
    private String picMinusOne;

    @TableField("edit_time")
    private String editTime;

    @TableField("area_code")
    private String areaCode;

    @TableField("is_user")
    private String isUser;

    @TableField("pic_two")
    private String picTwo;

    @TableField("user")
    private String user;

    @TableField("info")
    private String info;

}
