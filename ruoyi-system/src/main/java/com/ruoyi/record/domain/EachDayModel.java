package com.ruoyi.record.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * 每天状态 sys_record_each_day
 * 
 * @author ruoyi
 */
@Data
@TableName("sys_record_each_day")
public class EachDayModel extends CommonModel<EachDayModel>
{

    @TableField("user_status")
    private String userStatus;

    @TableField("show_time")
    private String showTime;

    @TableField("out_time")
    private String outTime;

    @TableField("out_status")
    private String outStatus;

    @TableField("out_record_id")
    private String outRecordId;

    @TableField("in_time")
    private String inTime;

    @TableField("in_status")
    private String inStatus;

    @TableField("in_record_id")
    private String inRecordId;

    @TableField("late_status")
    private String lateStatus;

    @TableField("check_status")
    private String checkStatus;

    @TableField("check_time")
    private String checkTime;

    @TableField("last_str_inorout")
    private String lastStrInorout;
    //最后进出状态
    @TableField("last_inorout")
    private String lastInorout;
    //最后进出时间
    @TableField("last_inorout_time")
    private String lastInoroutTime;

    @TableField("xh")
    private String xh;

    @TableField("xm")
    private String xm;
    /**
     * 联系方式
     */
    @TableField("lxfs")
    private String lxfs;
    /**
     * 部门名称
     */
    @TableField("bmmc")
    private String bmmc;
    /**
     * 部门代码
     */
    @TableField("bmdm")
    private String bmdm;
    /**
     * 老师id
     */
    @TableField("teach_id")
    private String teachId;
    /**
     * 老师名字
     */
    @TableField("teach_name")
    private String teachName;

    @TableField("dwmc")
    private String dwmc;

    @TableField("dwdm")
    private String dwdm;
    //学科门类代码
    @TableField("xkmldm")
    private String xkmldm;
    //专业名称
    @TableField("zymc")
    private String zymc;
    //专业代码
    @TableField("zydm")
    private String zydm;
    //班级简称
    @TableField("bjjc")
    private String bjjc;
    //班级代码
    @TableField("bjdm")
    private String bjdm;
    //学生当前状态代码
    @TableField("xsdqztdm")
    private String xsdqztdm;

    //宿舍楼
    @TableField("sslh")
    private String sslh;
    //单元号
    @TableField("dy")
    private String dy;
    //宿舍号
    @TableField("shh")
    private String shh;
    //床位号
    @TableField("cwh")
    private String cwh;

    //查询开始时间
    @TableField(exist =  false)
    private String startshowTime;
    //查询结束时间
    @TableField(exist =  false)
    private String endshowTime;

}
