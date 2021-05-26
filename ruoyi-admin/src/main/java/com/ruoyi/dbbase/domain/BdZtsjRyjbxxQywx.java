package com.ruoyi.dbbase.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 门禁中的用户信息对象 bd_ztsj_ryjbxx_qywx
 * 
 * @author ruoyi
 * @date 2021-04-01
 */
public class BdZtsjRyjbxxQywx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String lxdh;

    /** 身份证件号 */
    @Excel(name = "身份证件号")
    private String sfzjh;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String bmmc;

    /** 部门代码 */
    @Excel(name = "部门代码")
    private String bmdm;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String zymc;

    /** 专业代码 */
    @Excel(name = "专业代码")
    private String zydm;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String bjmc;

    /** 班级代码 */
    @Excel(name = "班级代码")
    private String bjdm;

    /** 是否在校 */
    @Excel(name = "是否在校")
    private String sfzx;

    /** 人员类别 */
    @Excel(name = "人员类别")
    private String rylb;

    /** 性别 */
    @Excel(name = "性别")
    private String xb;

    /** 主键 */
    private String zj;

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

    /** 学工号 */
    @Excel(name = "学工号")
    private String xgh;

    /** 考生号 */
    @Excel(name = "考生号")
    private String ksh;
    /** 本地标识 */
    @Excel(name = "本地标识")
    private String local;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setXm(String xm)
    {
        this.xm = xm;
    }

    public String getXm() 
    {
        return xm;
    }
    public void setLxdh(String lxdh) 
    {
        this.lxdh = lxdh;
    }

    public String getLxdh() 
    {
        return lxdh;
    }
    public void setSfzjh(String sfzjh) 
    {
        this.sfzjh = sfzjh;
    }

    public String getSfzjh() 
    {
        return sfzjh;
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
    public void setBjmc(String bjmc) 
    {
        this.bjmc = bjmc;
    }

    public String getBjmc() 
    {
        return bjmc;
    }
    public void setBjdm(String bjdm) 
    {
        this.bjdm = bjdm;
    }

    public String getBjdm() 
    {
        return bjdm;
    }
    public void setSfzx(String sfzx) 
    {
        this.sfzx = sfzx;
    }

    public String getSfzx() 
    {
        return sfzx;
    }
    public void setRylb(String rylb) 
    {
        this.rylb = rylb;
    }

    public String getRylb() 
    {
        return rylb;
    }
    public void setXb(String xb) 
    {
        this.xb = xb;
    }

    public String getXb() 
    {
        return xb;
    }
    public void setZj(String zj) 
    {
        this.zj = zj;
    }

    public String getZj() 
    {
        return zj;
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
    public void setXgh(String xgh) 
    {
        this.xgh = xgh;
    }

    public String getXgh() 
    {
        return xgh;
    }
    public void setKsh(String ksh) 
    {
        this.ksh = ksh;
    }

    public String getKsh() 
    {
        return ksh;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("xm", getXm())
            .append("lxdh", getLxdh())
            .append("sfzjh", getSfzjh())
            .append("bmmc", getBmmc())
            .append("bmdm", getBmdm())
            .append("zymc", getZymc())
            .append("zydm", getZydm())
            .append("bjmc", getBjmc())
            .append("bjdm", getBjdm())
            .append("sfzx", getSfzx())
            .append("rylb", getRylb())
            .append("xb", getXb())
            .append("zj", getZj())
            .append("dcDcfieldaud", getDcDcfieldaud())
            .append("dcDcdatadate", getDcDcdatadate())
            .append("dcDctimestamp", getDcDctimestamp())
            .append("xgh", getXgh())
            .append("ksh", getKsh())
            .toString();
    }
}
