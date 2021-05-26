package com.ruoyi.late.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 业务--学生晚归迟到记录对象 sys_record_each_late
 *
 * @author ruoyi
 * @date 2021-04-02
 */
@TableName("sys_record_each_late")
public class UserLate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 年级名 */
//    @Excel(name = "年级名")
    private String name;

    /** 排序 */
//    @Excel(name = "排序")
    private Integer sort;

    /** 用户id */
//    @Excel(name = "用户id")
    private Long userId;

    /** 展示时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "展示时间")
    private String showTime;

    /** 回寝室状态  0未归 1晚归  2晚归 4请假 5其他 */
    @Excel(name = "回寝室状态", readConverterExp = "0=未归,1=已归,2=晚归,4=请假,5=其他")
    private Integer lateStatus;

    /** 那一天的记录id */
//    @Excel(name = "那一天的记录id")
    private Long dayId;

    /** 出校时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @Excel(name = "出校时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private String outTime;

    /** 出寝时间 */
//    @Excel(name = "出寝id")
    private String outRecordId;

    /** 回寝时间 */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "回寝时间")
    private String inTime;

    /** 回寝记录id */
//    @Excel(name = "回寝记录id")
    private String inRecordId;

    /** 老师处理回寝室状态-1未处理 0未归 1已归  2晚归 4请假 5其他  */
    @Excel(name = "老师处理回寝室状态 ", readConverterExp = "-1=未处理,0=未归,1=已归,2=晚归,4=请假,5=其他")
    private Integer teachStatus;

    /** 老师处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "老师处理时间")
    private String teachTime;

    /** 老师id */
    @Excel(name = "老师id")
    private String teachId;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String bmmc;

    /** 部门代码 */
    @Excel(name = "部门代码")
    private String bmdm;

    /** 学号 */
    @Excel(name = "学号")
    private String xh;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 联系方 */
    @Excel(name = "联系方")
    private String lxfs;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String dwmc;

    /** 单位代码 */
//    @Excel(name = "单位代码")
    private String dwdm;

    /** 学科门类代码 */
//    @Excel(name = "学科门类代码")
    private String xkmldm;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String zymc;

    /** 专业代码 */
//    @Excel(name = "专业代码")
    private String zydm;

    /** 班级简称 */
    @Excel(name = "班级简称")
    private String bjjc;

    /** 班级代码 */
    @Excel(name = "班级代码")
    private String bjdm;

    /** 学生当前状态代码 */
//    @Excel(name = "学生当前状态代码")
    private String xsdqztdm;

    /** 老师名字 */
    @Excel(name = "老师名字")
    private String teachName;

    /** 最后进出状态 */
//    @Excel(name = "最后进出状态")
    private String lastInorout;

    /** 最后的进出名称 */
    @Excel(name = "最后的进出名称")
    private String lastStrInorout;

    /** 最后进出时间 */
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @Excel(name = "最后进出时间")
    private String lastInoroutTime;

    //宿舍楼
    @Excel(name = "宿舍楼号")
    private String sslh;
    //单元号
    @Excel(name = "单元")
    private String dy;
    //宿舍号
    @Excel(name = "宿舍号")
    private String shh;
    //床位号
    @Excel(name = "床位")
    private String cwh;

    //最开始默认回寝室状态 0未归 1已归  2晚归
    @Excel(name = "初始状态", readConverterExp = "-1=未处理,0=未归,1=已归,2=晚归,4=请假,5=其他")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSslh() {
        return sslh;
    }

    public void setSslh(String sslh) {
        this.sslh = sslh;
    }

    public String getDy() {
        return dy;
    }

    public void setDy(String dy) {
        this.dy = dy;
    }

    public String getShh() {
        return shh;
    }

    public void setShh(String shh) {
        this.shh = shh;
    }

    public String getCwh() {
        return cwh;
    }

    public void setCwh(String cwh) {
        this.cwh = cwh;
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
    public void setShowTime(String showTime)
    {
        this.showTime = showTime;
    }

    public String getShowTime()
    {
        return showTime;
    }
    public void setLateStatus(Integer lateStatus)
    {
        this.lateStatus = lateStatus;
    }

    public Integer getLateStatus()
    {
        return lateStatus;
    }
    public void setDayId(Long dayId)
    {
        this.dayId = dayId;
    }

    public Long getDayId()
    {
        return dayId;
    }
    public void setOutTime(String outTime)
    {
        this.outTime = outTime;
    }

    public String getOutTime()
    {
        return outTime;
    }
    public void setOutRecordId(String outRecordId)
    {
        this.outRecordId = outRecordId;
    }

    public String getOutRecordId()
    {
        return outRecordId;
    }
    public void setInTime(String inTime)
    {
        this.inTime = inTime;
    }

    public String getInTime()
    {
        return inTime;
    }
    public void setInRecordId(String inRecordId)
    {
        this.inRecordId = inRecordId;
    }

    public String getInRecordId()
    {
        return inRecordId;
    }
    public void setTeachStatus(Integer teachStatus)
    {
        this.teachStatus = teachStatus;
    }

    public Integer getTeachStatus()
    {
        return teachStatus;
    }
    public void setTeachTime(String teachTime)
    {
        this.teachTime = teachTime;
    }

    public String getTeachTime()
    {
        return teachTime;
    }
    public void setTeachId(String teachId)
    {
        this.teachId = teachId;
    }

    public String getTeachId()
    {
        return teachId;
    }
    public void setBmmc(String bmmc)
    {
        this.bmmc = bmmc;
    }

    public String getBmmc()
    {
        return bmmc;
    }
    public void setBmdm(String bmdm)
    {
        this.bmdm = bmdm;
    }

    public String getBmdm()
    {
        return bmdm;
    }
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
    public void setLxfs(String lxfs)
    {
        this.lxfs = lxfs;
    }

    public String getLxfs()
    {
        return lxfs;
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
    public void setXkmldm(String xkmldm)
    {
        this.xkmldm = xkmldm;
    }

    public String getXkmldm()
    {
        return xkmldm;
    }
    public void setZymc(String zymc)
    {
        this.zymc = zymc;
    }

    public String getZymc()
    {
        return zymc;
    }
    public void setZydm(String zydm)
    {
        this.zydm = zydm;
    }

    public String getZydm()
    {
        return zydm;
    }
    public void setBjjc(String bjjc)
    {
        this.bjjc = bjjc;
    }

    public String getBjjc()
    {
        return bjjc;
    }
    public void setBjdm(String bjdm)
    {
        this.bjdm = bjdm;
    }

    public String getBjdm()
    {
        return bjdm;
    }
    public void setXsdqztdm(String xsdqztdm)
    {
        this.xsdqztdm = xsdqztdm;
    }

    public String getXsdqztdm()
    {
        return xsdqztdm;
    }
    public void setTeachName(String teachName)
    {
        this.teachName = teachName;
    }

    public String getTeachName()
    {
        return teachName;
    }
    public void setLastInorout(String lastInorout)
    {
        this.lastInorout = lastInorout;
    }

    public String getLastInorout()
    {
        return lastInorout;
    }
    public void setLastStrInorout(String lastStrInorout)
    {
        this.lastStrInorout = lastStrInorout;
    }

    public String getLastStrInorout()
    {
        return lastStrInorout;
    }
    public void setLastInoroutTime(String lastInoroutTime)
    {
        this.lastInoroutTime = lastInoroutTime;
    }

    public String getLastInoroutTime()
    {
        return lastInoroutTime;
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
                .append("showTime", getShowTime())
                .append("lateStatus", getLateStatus())
                .append("dayId", getDayId())
                .append("outTime", getOutTime())
                .append("outRecordId", getOutRecordId())
                .append("inTime", getInTime())
                .append("inRecordId", getInRecordId())
                .append("teachStatus", getTeachStatus())
                .append("teachTime", getTeachTime())
                .append("teachId", getTeachId())
                .append("bmmc", getBmmc())
                .append("bmdm", getBmdm())
                .append("xh", getXh())
                .append("xm", getXm())
                .append("lxfs", getLxfs())
                .append("dwmc", getDwmc())
                .append("dwdm", getDwdm())
                .append("xkmldm", getXkmldm())
                .append("zymc", getZymc())
                .append("zydm", getZydm())
                .append("bjjc", getBjjc())
                .append("bjdm", getBjdm())
                .append("xsdqztdm", getXsdqztdm())
                .append("teachName", getTeachName())
                .append("lastInorout", getLastInorout())
                .append("lastStrInorout", getLastStrInorout())
                .append("lastInoroutTime", getLastInoroutTime())
                .toString();
    }
}