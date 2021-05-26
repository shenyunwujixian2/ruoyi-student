package com.ruoyi.record.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * 年级表 sys_record_grades
 * 
 * @author ruoyi
 */
@Data
@TableName("sys_record_grades")
public class PushMessageModel extends CommonModel<PushMessageModel>
{

    @TableField("title")
    private String title;

    @TableField("content")
    private String content;

    @TableField("to_user")
    private String toUser;

    @TableField("send_status")
    private String sendStatus;

    @TableField("send_time")
    private String sendTime;

    @TableField("send_result")
    private String sendResult;


}
