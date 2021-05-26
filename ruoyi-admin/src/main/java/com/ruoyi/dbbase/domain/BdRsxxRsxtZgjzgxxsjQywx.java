package com.ruoyi.dbbase.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 在岗教职工线下数据对象 bd_rsxx_rsxt_zgjzgxxsj_qywx
 * 
 * @author xiaoafu
 * @date 2021-04-01
 */
public class BdRsxxRsxtZgjzgxxsjQywx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教职工号 */
    @Excel(name = "教职工号")
    private String jzgh;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String dwmc;

    /** 出生日期 */
    @Excel(name = "出生日期")
    private String csrq;

    /** 性别 */
    @Excel(name = "性别")
    private String xb;

    /** 性别代码 */
    @Excel(name = "性别代码")
    private String xbdm;

    /** 身份证件号 */
    @Excel(name = "身份证件号")
    private String sfzjh;

    /** 民族 */
    @Excel(name = "民族")
    private String mz;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String jg;

    /** 年龄 */
    @Excel(name = "年龄")
    private String nl;

    /** 在岗状态 */
    @Excel(name = "在岗状态")
    private String zgzt;

    /** 人员类别 */
    @Excel(name = "人员类别")
    private String rylb;

    /** 职位名称 */
    @Excel(name = "职位名称")
    private String zwmc;

    /** 编制类别名称 */
    @Excel(name = "编制类别名称")
    private String bzlbmc;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String gwmc;

    /** AUD标识 */
    @Excel(name = "AUD标识")
    private String dcDcfieldaud;

    /** 数据日期 */
    @Excel(name = "数据日期")
    private String dcDcdatadate;

    /** 时间戳 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间戳", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dcDctimestamp;

    public void setJzgh(String jzgh) 
    {
        this.jzgh = jzgh;
    }

    public String getJzgh() 
    {
        return jzgh;
    }
    public void setXm(String xm) 
    {
        this.xm = xm;
    }

    public String getXm() 
    {
        return xm;
    }
    public void setDwmc(String dwmc) 
    {
        this.dwmc = dwmc;
    }

    public String getDwmc() 
    {
        return dwmc;
    }
    public void setCsrq(String csrq) 
    {
        this.csrq = csrq;
    }

    public String getCsrq() 
    {
        return csrq;
    }
    public void setXb(String xb) 
    {
        this.xb = xb;
    }

    public String getXb() 
    {
        return xb;
    }
    public void setXbdm(String xbdm) 
    {
        this.xbdm = xbdm;
    }

    public String getXbdm() 
    {
        return xbdm;
    }
    public void setSfzjh(String sfzjh) 
    {
        this.sfzjh = sfzjh;
    }

    public String getSfzjh() 
    {
        return sfzjh;
    }
    public void setMz(String mz) 
    {
        this.mz = mz;
    }

    public String getMz() 
    {
        return mz;
    }
    public void setJg(String jg) 
    {
        this.jg = jg;
    }

    public String getJg() 
    {
        return jg;
    }
    public void setNl(String nl) 
    {
        this.nl = nl;
    }

    public String getNl() 
    {
        return nl;
    }
    public void setZgzt(String zgzt) 
    {
        this.zgzt = zgzt;
    }

    public String getZgzt() 
    {
        return zgzt;
    }
    public void setRylb(String rylb) 
    {
        this.rylb = rylb;
    }

    public String getRylb() 
    {
        return rylb;
    }
    public void setZwmc(String zwmc) 
    {
        this.zwmc = zwmc;
    }

    public String getZwmc() 
    {
        return zwmc;
    }
    public void setBzlbmc(String bzlbmc) 
    {
        this.bzlbmc = bzlbmc;
    }

    public String getBzlbmc() 
    {
        return bzlbmc;
    }
    public void setGwmc(String gwmc) 
    {
        this.gwmc = gwmc;
    }

    public String getGwmc() 
    {
        return gwmc;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("jzgh", getJzgh())
            .append("xm", getXm())
            .append("dwmc", getDwmc())
            .append("csrq", getCsrq())
            .append("xb", getXb())
            .append("xbdm", getXbdm())
            .append("sfzjh", getSfzjh())
            .append("mz", getMz())
            .append("jg", getJg())
            .append("nl", getNl())
            .append("zgzt", getZgzt())
            .append("rylb", getRylb())
            .append("zwmc", getZwmc())
            .append("bzlbmc", getBzlbmc())
            .append("gwmc", getGwmc())
            .append("dcDcfieldaud", getDcDcfieldaud())
            .append("dcDcdatadate", getDcDcdatadate())
            .append("dcDctimestamp", getDcDctimestamp())
            .toString();
    }
}
