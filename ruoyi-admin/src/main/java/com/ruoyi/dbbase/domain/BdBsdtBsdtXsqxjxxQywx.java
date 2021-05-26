package com.ruoyi.dbbase.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 本地学生请假信息对象 bd_bsdt_bsdt_xsqxjxx_qywx
 *
 * @author ruoyi
 * @date 2021-04-17
 */
public class BdBsdtBsdtXsqxjxxQywx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 所在城市 */
    @Excel(name = "所在城市")
    private String szcs;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String jssj;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String kssj;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String zymc;

    /** 班级 */
    @Excel(name = "班级")
    private String bj;

    /** 年级 */
    @Excel(name = "年级")
    private String nj;

    /** 学号 */
    @Excel(name = "学号")
    private String xh;

    /** 请假类型 */
    @Excel(name = "请假类型")
    private String qjlx;

    /** 寝室号 */
    @Excel(name = "寝室号")
    private String qsh;

    /** 历史记录 */
    @Excel(name = "历史记录")
    private String lsjl;

    /** 请假天数 */
    @Excel(name = "请假天数")
    private String qjts;

    /** 目的地地址 */
    @Excel(name = "目的地地址")
    private String mdddz;

    /** 学院 */
    @Excel(name = "学院")
    private String xy;

    /** 所在省份 */
    @Excel(name = "所在省份")
    private String szsf;

    /** 交通工具一 */
    @Excel(name = "交通工具一")
    private String jtgjy;

    /** 交通工具 */
    @Excel(name = "交通工具")
    private String jtgj;

    /** 学生请销假信息编号 */
    private String xsqxjxxbh;

    /** 所在区县 */
    @Excel(name = "所在区县")
    private String szqx;

    /** 计划交通 */
    @Excel(name = "计划交通")
    private String jhjt;

    /** 计划交通一 */
    @Excel(name = "计划交通一")
    private String jhjty;

    /** 证明材料附件 */
    @Excel(name = "证明材料附件")
    private String zmclfj;

    /** 家长联系电话 */
    @Excel(name = "家长联系电话")
    private String jzlxdh;

    /** 复学时间 */
    @Excel(name = "复学时间")
    private String fxsj;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String lxdh;

    /** 请假事由 */
    @Excel(name = "请假事由")
    private String qjsy;

    /** 是否留宿 */
    @Excel(name = "是否留宿")
    private String sfls;

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

    /** 是否处理 0未处理 1 已处理 */
    @Excel(name = "是否处理 0未处理 1 已处理")
    private Integer checkStatus;

    /** 处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkTime;

    public void setXm(String xm)
    {
        this.xm = xm;
    }

    public String getXm()
    {
        return xm;
    }
    public void setSzcs(String szcs)
    {
        this.szcs = szcs;
    }

    public String getSzcs()
    {
        return szcs;
    }
    public void setJssj(String jssj)
    {
        this.jssj = jssj;
    }

    public String getJssj()
    {
        return jssj;
    }
    public void setKssj(String kssj)
    {
        this.kssj = kssj;
    }

    public String getKssj()
    {
        return kssj;
    }
    public void setZymc(String zymc)
    {
        this.zymc = zymc;
    }

    public String getZymc()
    {
        return zymc;
    }
    public void setBj(String bj)
    {
        this.bj = bj;
    }

    public String getBj()
    {
        return bj;
    }
    public void setNj(String nj)
    {
        this.nj = nj;
    }

    public String getNj()
    {
        return nj;
    }
    public void setXh(String xh)
    {
        this.xh = xh;
    }

    public String getXh()
    {
        return xh;
    }
    public void setQjlx(String qjlx)
    {
        this.qjlx = qjlx;
    }

    public String getQjlx()
    {
        return qjlx;
    }
    public void setQsh(String qsh)
    {
        this.qsh = qsh;
    }

    public String getQsh()
    {
        return qsh;
    }
    public void setLsjl(String lsjl)
    {
        this.lsjl = lsjl;
    }

    public String getLsjl()
    {
        return lsjl;
    }
    public void setQjts(String qjts)
    {
        this.qjts = qjts;
    }

    public String getQjts()
    {
        return qjts;
    }
    public void setMdddz(String mdddz)
    {
        this.mdddz = mdddz;
    }

    public String getMdddz()
    {
        return mdddz;
    }
    public void setXy(String xy)
    {
        this.xy = xy;
    }

    public String getXy()
    {
        return xy;
    }
    public void setSzsf(String szsf)
    {
        this.szsf = szsf;
    }

    public String getSzsf()
    {
        return szsf;
    }
    public void setJtgjy(String jtgjy)
    {
        this.jtgjy = jtgjy;
    }

    public String getJtgjy()
    {
        return jtgjy;
    }
    public void setJtgj(String jtgj)
    {
        this.jtgj = jtgj;
    }

    public String getJtgj()
    {
        return jtgj;
    }
    public void setXsqxjxxbh(String xsqxjxxbh)
    {
        this.xsqxjxxbh = xsqxjxxbh;
    }

    public String getXsqxjxxbh()
    {
        return xsqxjxxbh;
    }
    public void setSzqx(String szqx)
    {
        this.szqx = szqx;
    }

    public String getSzqx()
    {
        return szqx;
    }
    public void setJhjt(String jhjt)
    {
        this.jhjt = jhjt;
    }

    public String getJhjt()
    {
        return jhjt;
    }
    public void setJhjty(String jhjty)
    {
        this.jhjty = jhjty;
    }

    public String getJhjty()
    {
        return jhjty;
    }
    public void setZmclfj(String zmclfj)
    {
        this.zmclfj = zmclfj;
    }

    public String getZmclfj()
    {
        return zmclfj;
    }
    public void setJzlxdh(String jzlxdh)
    {
        this.jzlxdh = jzlxdh;
    }

    public String getJzlxdh()
    {
        return jzlxdh;
    }
    public void setFxsj(String fxsj)
    {
        this.fxsj = fxsj;
    }

    public String getFxsj()
    {
        return fxsj;
    }
    public void setLxdh(String lxdh)
    {
        this.lxdh = lxdh;
    }

    public String getLxdh()
    {
        return lxdh;
    }
    public void setQjsy(String qjsy)
    {
        this.qjsy = qjsy;
    }

    public String getQjsy()
    {
        return qjsy;
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
    public void setCheckStatus(Integer checkStatus)
    {
        this.checkStatus = checkStatus;
    }

    public Integer getCheckStatus()
    {
        return checkStatus;
    }
    public void setCheckTime(Date checkTime)
    {
        this.checkTime = checkTime;
    }

    public Date getCheckTime()
    {
        return checkTime;
    }

    public String getSfls() {
        return sfls;
    }

    public void setSfls(String sfls) {
        this.sfls = sfls;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("xm", getXm())
                .append("szcs", getSzcs())
                .append("jssj", getJssj())
                .append("kssj", getKssj())
                .append("zymc", getZymc())
                .append("bj", getBj())
                .append("nj", getNj())
                .append("xh", getXh())
                .append("qjlx", getQjlx())
                .append("qsh", getQsh())
                .append("lsjl", getLsjl())
                .append("qjts", getQjts())
                .append("mdddz", getMdddz())
                .append("xy", getXy())
                .append("szsf", getSzsf())
                .append("jtgjy", getJtgjy())
                .append("jtgj", getJtgj())
                .append("xsqxjxxbh", getXsqxjxxbh())
                .append("szqx", getSzqx())
                .append("jhjt", getJhjt())
                .append("jhjty", getJhjty())
                .append("zmclfj", getZmclfj())
                .append("jzlxdh", getJzlxdh())
                .append("fxsj", getFxsj())
                .append("lxdh", getLxdh())
                .append("qjsy", getQjsy())
                .append("dcDcfieldaud", getDcDcfieldaud())
                .append("dcDcdatadate", getDcDcdatadate())
                .append("dcDctimestamp", getDcDctimestamp())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("checkStatus", getCheckStatus())
                .append("checkTime", getCheckTime())
                .toString();
    }
}