package com.ruoyi.offline.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 迟到晚归信息对象 mjxt_mjxt_cdwgxx_qywx
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
public class MjxtMjxtCdwgxxQywx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 用户代码 */
    @Excel(name = "用户代码")
    private String yhdm;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String dwmc;

    /** 单位代码 */
    @Excel(name = "单位代码")
    private String dwdm;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String bjmc;

    /** 班级代码 */
    @Excel(name = "班级代码")
    private String bjdm;

    /** 宿舍楼名称 */
    @Excel(name = "宿舍楼名称")
    private String sslmc;

    /** 宿舍号码 */
    @Excel(name = "宿舍号码")
    private String sshm;

    /** 未归寝天数 */
    @Excel(name = "未归寝天数")
    private String wgqts;

    /** 未归寝或晚归日期 */
    @Excel(name = "未归寝或晚归日期")
    private String wgqhwgrq;

    /** 离开日期 */
    @Excel(name = "离开日期")
    private String lkrq;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String lxdh;

    /** 统计类型 */
    @Excel(name = "统计类型")
    private String tjlx;

    /** 标志位 */
    @Excel(name = "标志位")
    private String bzw;

    /** 区域编号 */
    @Excel(name = "区域编号")
    private String qybh;

    /** 自增主键 */
    @Excel(name = "自增主键")
    private Integer zzzj;

    /** 更新日期 */
    @Excel(name = "更新日期")
    private String gxrq;

    /** 状态标识 */
    @Excel(name = "状态标识")
    private String ztbz;

    /** 统计子类型 */
    @Excel(name = "统计子类型")
    private String tjzlx;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String rwmc;

    /** 统计时段 */
    @Excel(name = "统计时段")
    private String tjsd;

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

    public void setXm(String xm) 
    {
        this.xm = xm;
    }

    public String getXm() 
    {
        return xm;
    }
    public void setYhdm(String yhdm) 
    {
        this.yhdm = yhdm;
    }

    public String getYhdm() 
    {
        return yhdm;
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
    public void setSslmc(String sslmc) 
    {
        this.sslmc = sslmc;
    }

    public String getSslmc() 
    {
        return sslmc;
    }
    public void setSshm(String sshm) 
    {
        this.sshm = sshm;
    }

    public String getSshm() 
    {
        return sshm;
    }
    public void setWgqts(String wgqts) 
    {
        this.wgqts = wgqts;
    }

    public String getWgqts() 
    {
        return wgqts;
    }
    public void setWgqhwgrq(String wgqhwgrq) 
    {
        this.wgqhwgrq = wgqhwgrq;
    }

    public String getWgqhwgrq() 
    {
        return wgqhwgrq;
    }
    public void setLkrq(String lkrq) 
    {
        this.lkrq = lkrq;
    }

    public String getLkrq() 
    {
        return lkrq;
    }
    public void setLxdh(String lxdh) 
    {
        this.lxdh = lxdh;
    }

    public String getLxdh() 
    {
        return lxdh;
    }
    public void setTjlx(String tjlx) 
    {
        this.tjlx = tjlx;
    }

    public String getTjlx() 
    {
        return tjlx;
    }
    public void setBzw(String bzw) 
    {
        this.bzw = bzw;
    }

    public String getBzw() 
    {
        return bzw;
    }
    public void setQybh(String qybh) 
    {
        this.qybh = qybh;
    }

    public String getQybh() 
    {
        return qybh;
    }
    public void setZzzj(Integer zzzj) 
    {
        this.zzzj = zzzj;
    }

    public Integer getZzzj() 
    {
        return zzzj;
    }
    public void setGxrq(String gxrq) 
    {
        this.gxrq = gxrq;
    }

    public String getGxrq() 
    {
        return gxrq;
    }
    public void setZtbz(String ztbz) 
    {
        this.ztbz = ztbz;
    }

    public String getZtbz() 
    {
        return ztbz;
    }
    public void setTjzlx(String tjzlx) 
    {
        this.tjzlx = tjzlx;
    }

    public String getTjzlx() 
    {
        return tjzlx;
    }
    public void setRwmc(String rwmc) 
    {
        this.rwmc = rwmc;
    }

    public String getRwmc() 
    {
        return rwmc;
    }
    public void setTjsd(String tjsd) 
    {
        this.tjsd = tjsd;
    }

    public String getTjsd() 
    {
        return tjsd;
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
            .append("xm", getXm())
            .append("yhdm", getYhdm())
            .append("dwmc", getDwmc())
            .append("dwdm", getDwdm())
            .append("bjmc", getBjmc())
            .append("bjdm", getBjdm())
            .append("sslmc", getSslmc())
            .append("sshm", getSshm())
            .append("wgqts", getWgqts())
            .append("wgqhwgrq", getWgqhwgrq())
            .append("lkrq", getLkrq())
            .append("lxdh", getLxdh())
            .append("tjlx", getTjlx())
            .append("bzw", getBzw())
            .append("qybh", getQybh())
            .append("zzzj", getZzzj())
            .append("gxrq", getGxrq())
            .append("ztbz", getZtbz())
            .append("tjzlx", getTjzlx())
            .append("rwmc", getRwmc())
            .append("tjsd", getTjsd())
            .append("dcDcfieldaud", getDcDcfieldaud())
            .append("dcDcdatadate", getDcDcdatadate())
            .append("dcDctimestamp", getDcDctimestamp())
            .toString();
    }
}
