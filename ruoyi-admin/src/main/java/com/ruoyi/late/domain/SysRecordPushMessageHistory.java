package com.ruoyi.late.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 业务--消息推送对象 sys_record_push_message_history
 * 
 * @author xiaoafu
 * @date 2021-04-03
 */
public class SysRecordPushMessageHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 年级名 */
    @Excel(name = "年级名")
    private String name;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** $column.columnComment */
    @Excel(name = "用户id")
    private String title;

    /** $column.columnComment */
    @Excel(name = "用户id")
    private String content;

    /** $column.columnComment */
    @Excel(name = "用户id")
    private String toUser;

    /** 发送状态 */
    @Excel(name = "发送状态")
    private String sendStatus;

    /** 发送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sendTime;

    /** 发送结果 */
    @Excel(name = "发送结果")
    private String sendResult;

    /** 消息类型 1学生 2老师 3校领导 4、24小时未出宿舍 5、48小时未出宿舍 */
    @Excel(name = "消息类型 1学生 2老师 3校领导 4、24小时未出宿舍 5、48小时未出宿舍")
    private String type;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 学号 */
    @Excel(name = "学号")
    private String xh;

    /** 展示时间 */
    @Excel(name = "展示时间")
    private String showTime;

    /** 链接地址 */
    @Excel(name = "url")
    private String url;

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
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setToUser(String toUser) 
    {
        this.toUser = toUser;
    }

    public String getToUser() 
    {
        return toUser;
    }
    public void setSendStatus(String sendStatus)
    {
        this.sendStatus = sendStatus;
    }

    public String getSendStatus()
    {
        return sendStatus;
    }
    public void setSendTime(Date sendTime) 
    {
        this.sendTime = sendTime;
    }

    public Date getSendTime() 
    {
        return sendTime;
    }
    public void setSendResult(String sendResult) 
    {
        this.sendResult = sendResult;
    }

    public String getSendResult() 
    {
        return sendResult;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setXh(String xh) 
    {
        this.xh = xh;
    }

    public String getXh() 
    {
        return xh;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
            .append("title", getTitle())
            .append("content", getContent())
            .append("toUser", getToUser())
            .append("sendStatus", getSendStatus())
            .append("sendTime", getSendTime())
            .append("sendResult", getSendResult())
            .append("type", getType())
            .append("phone", getPhone())
            .append("xh", getXh())
            .toString();
    }
}
