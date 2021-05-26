package com.ruoyi.dbbase.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生请假申请信息对象 bd_xgxt_xgxt_xsqjsqxx_qywx
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
public class BdXgxtXgxtXsqjsqxxQywx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String jssj;

    /** 学号 */
    @Excel(name = "学号")
    private String xh;

    /** 请假节次 */
    @Excel(name = "请假节次")
    private String qjjc;

    /** 销假时间 */
    @Excel(name = "销假时间")
    private String xjsj;

    /** 审批状态 */
    @Excel(name = "审批状态")
    private String spzt;

    /** 家长联系电话 */
    @Excel(name = "家长联系电话")
    private String jzlxdh;

    /** 宿舍号码 */
    @Excel(name = "宿舍号码")
    private String sshm;

    /** 销假状态 */
    @Excel(name = "销假状态")
    private String xjzt;

    /** 学生请假申请信息编号 */
    @Excel(name = "学生请假申请信息编号")
    private String xsqjsqxxbh;

    /** 附件 */
    @Excel(name = "附件")
    private String fj;

    /** 内容 */
    @Excel(name = "内容")
    private String nr;

    /** 销假经度 */
    @Excel(name = "销假经度")
    private BigDecimal xjjd;

    /** 销假纬度 */
    @Excel(name = "销假纬度")
    private BigDecimal xjwd;

    /** 家长姓名 */
    @Excel(name = "家长姓名")
    private String jzxm;

    /** 销假地址 */
    @Excel(name = "销假地址")
    private String xjdz;

    /** 请假类型 */
    @Excel(name = "请假类型")
    private String qjlx;

    /** 宿舍楼名称 */
    @Excel(name = "宿舍楼名称")
    private String sslmc;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private String cjsj;

    /** 起始时间 */
    @Excel(name = "起始时间")
    private String qssj;

    /** 年份 */
    @Excel(name = "年份")
    private String nf;

    /** 请假课程 */
    @Excel(name = "请假课程")
    private String qjkc;

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

    public void setJssj(String jssj) 
    {
        this.jssj = jssj;
    }

    public String getJssj() 
    {
        return jssj;
    }
    public void setXh(String xh) 
    {
        this.xh = xh;
    }

    public String getXh() 
    {
        return xh;
    }
    public void setQjjc(String qjjc) 
    {
        this.qjjc = qjjc;
    }

    public String getQjjc() 
    {
        return qjjc;
    }
    public void setXjsj(String xjsj) 
    {
        this.xjsj = xjsj;
    }

    public String getXjsj() 
    {
        return xjsj;
    }
    public void setSpzt(String spzt) 
    {
        this.spzt = spzt;
    }

    public String getSpzt() 
    {
        return spzt;
    }
    public void setJzlxdh(String jzlxdh) 
    {
        this.jzlxdh = jzlxdh;
    }

    public String getJzlxdh() 
    {
        return jzlxdh;
    }
    public void setSshm(String sshm) 
    {
        this.sshm = sshm;
    }

    public String getSshm() 
    {
        return sshm;
    }
    public void setXjzt(String xjzt) 
    {
        this.xjzt = xjzt;
    }

    public String getXjzt() 
    {
        return xjzt;
    }
    public void setXsqjsqxxbh(String xsqjsqxxbh) 
    {
        this.xsqjsqxxbh = xsqjsqxxbh;
    }

    public String getXsqjsqxxbh() 
    {
        return xsqjsqxxbh;
    }
    public void setFj(String fj) 
    {
        this.fj = fj;
    }

    public String getFj() 
    {
        return fj;
    }
    public void setNr(String nr) 
    {
        this.nr = nr;
    }

    public String getNr() 
    {
        return nr;
    }
    public void setXjjd(BigDecimal xjjd) 
    {
        this.xjjd = xjjd;
    }

    public BigDecimal getXjjd() 
    {
        return xjjd;
    }
    public void setXjwd(BigDecimal xjwd) 
    {
        this.xjwd = xjwd;
    }

    public BigDecimal getXjwd() 
    {
        return xjwd;
    }
    public void setJzxm(String jzxm) 
    {
        this.jzxm = jzxm;
    }

    public String getJzxm() 
    {
        return jzxm;
    }
    public void setXjdz(String xjdz) 
    {
        this.xjdz = xjdz;
    }

    public String getXjdz() 
    {
        return xjdz;
    }
    public void setQjlx(String qjlx) 
    {
        this.qjlx = qjlx;
    }

    public String getQjlx() 
    {
        return qjlx;
    }
    public void setSslmc(String sslmc) 
    {
        this.sslmc = sslmc;
    }

    public String getSslmc() 
    {
        return sslmc;
    }
    public void setCjsj(String cjsj) 
    {
        this.cjsj = cjsj;
    }

    public String getCjsj() 
    {
        return cjsj;
    }
    public void setQssj(String qssj) 
    {
        this.qssj = qssj;
    }

    public String getQssj() 
    {
        return qssj;
    }
    public void setNf(String nf) 
    {
        this.nf = nf;
    }

    public String getNf() 
    {
        return nf;
    }
    public void setQjkc(String qjkc) 
    {
        this.qjkc = qjkc;
    }

    public String getQjkc() 
    {
        return qjkc;
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
            .append("jssj", getJssj())
            .append("xh", getXh())
            .append("qjjc", getQjjc())
            .append("xjsj", getXjsj())
            .append("spzt", getSpzt())
            .append("jzlxdh", getJzlxdh())
            .append("sshm", getSshm())
            .append("xjzt", getXjzt())
            .append("xsqjsqxxbh", getXsqjsqxxbh())
            .append("fj", getFj())
            .append("nr", getNr())
            .append("xjjd", getXjjd())
            .append("xjwd", getXjwd())
            .append("jzxm", getJzxm())
            .append("xjdz", getXjdz())
            .append("qjlx", getQjlx())
            .append("sslmc", getSslmc())
            .append("cjsj", getCjsj())
            .append("qssj", getQssj())
            .append("nf", getNf())
            .append("qjkc", getQjkc())
            .append("dcDcfieldaud", getDcDcfieldaud())
            .append("dcDcdatadate", getDcDcdatadate())
            .append("dcDctimestamp", getDcDctimestamp())
            .toString();
    }
}
