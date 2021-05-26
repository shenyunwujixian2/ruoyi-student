package com.ruoyi.dbbase.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学工班级辅导信息对象 bd_xgxt_xgxt_bjfdyxx_qywx
 * 
 * @author xiaoafu
 * @date 2021-04-01
 */
public class BdXgxtXgxtBjfdyxxQywx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 班级信息编号 */
    @Excel(name = "班级信息编号")
    private String bjxxbh;

    /** 班级代码 */
    @Excel(name = "班级代码")
    private String bjdm;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String bjmc;

    /** 辅导员 */
    @Excel(name = "辅导员")
    private String fdy;

    /** 辅导员教职工号 */
    @Excel(name = "辅导员教职工号")
    private String fdyjzgh;

    /** AUD标识 */
    @Excel(name = "AUD标识")
    private String dcDcfieldaud;

    /** 数据日期 */
    @Excel(name = "数据日期")
    private String dcDcdatadate;

    /** 联系电话 */
    @Excel(name = "lxdh")
    private String lxdh;

    /** 本地标识 */
    @Excel(name = "local")
    private String local;

    /** 时间戳 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间戳", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dcDctimestamp;

    private String showTime;

    /** 当前年级 */
    @Excel(name = "dqnj")
    private String dqnj;

    /** 单位名称 */
    @Excel(name = "dwmc")
    private String dwmc;

    public String getDqnj() {
        return dqnj;
    }

    public void setDqnj(String dqnj) {
        this.dqnj = dqnj;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public void setBjxxbh(String bjxxbh)
    {
        this.bjxxbh = bjxxbh;
    }

    public String getBjxxbh() 
    {
        return bjxxbh;
    }
    public void setBjdm(String bjdm) 
    {
        this.bjdm = bjdm;
    }

    public String getBjdm() 
    {
        return bjdm;
    }
    public void setBjmc(String bjmc) 
    {
        this.bjmc = bjmc;
    }

    public String getBjmc() 
    {
        return bjmc;
    }
    public void setFdy(String fdy) 
    {
        this.fdy = fdy;
    }

    public String getFdy() 
    {
        return fdy;
    }
    public void setFdyjzgh(String fdyjzgh) 
    {
        this.fdyjzgh = fdyjzgh;
    }

    public String getFdyjzgh() 
    {
        return fdyjzgh;
    }
    public void setDcDcfieldaud(String dcDcfieldaud) 
    {
        this.dcDcfieldaud = dcDcfieldaud;
    }

    public String getDcDcfieldaud() 
    {
        return dcDcfieldaud;
    }
    public void setDcDcdatadate(String dcDcdatadate) 
    {
        this.dcDcdatadate = dcDcdatadate;
    }

    public String getDcDcdatadate() 
    {
        return dcDcdatadate;
    }
    public void setDcDctimestamp(Date dcDctimestamp) 
    {
        this.dcDctimestamp = dcDctimestamp;
    }

    public Date getDcDctimestamp() 
    {
        return dcDctimestamp;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bjxxbh", getBjxxbh())
            .append("bjdm", getBjdm())
            .append("bjmc", getBjmc())
            .append("fdy", getFdy())
            .append("fdyjzgh", getFdyjzgh())
            .append("dcDcfieldaud", getDcDcfieldaud())
            .append("dcDcdatadate", getDcDcdatadate())
            .append("dcDctimestamp", getDcDctimestamp())
            .toString();
    }
}
