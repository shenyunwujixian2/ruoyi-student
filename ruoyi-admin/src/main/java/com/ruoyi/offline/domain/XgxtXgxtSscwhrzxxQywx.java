package com.ruoyi.offline.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍床位和入住信息对象 xgxt_xgxt_sscwhrzxx_qywx
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
public class XgxtXgxtSscwhrzxxQywx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String dwmc;

    /** 性别 */
    @Excel(name = "性别")
    private String xb;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String zymc;

    /** 年级 */
    @Excel(name = "年级")
    private String nj;

    /** 学号 */
    @Excel(name = "学号")
    private String xh;

    /** 排序号 */
    @Excel(name = "排序号")
    private Long pxh;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String bjmc;

    /** 宿舍楼名称 */
    @Excel(name = "宿舍楼名称")
    private String sslmc;

    /** 宿舍楼信息编号 */
    @Excel(name = "宿舍楼信息编号")
    private String sslxxbh;

    /** 宿舍单元信息编号 */
    @Excel(name = "宿舍单元信息编号")
    private String ssdyxxbh;

    /** 房间特点 */
    @Excel(name = "房间特点")
    private String fjtd;

    /** 宿舍房间信息编号 */
    @Excel(name = "宿舍房间信息编号")
    private String ssfjxxbh;

    /** 宿舍名称 */
    @Excel(name = "宿舍名称")
    private String ssmc;

    /** 床位编号 */
    @Excel(name = "床位编号")
    private String cwbh;

    /** 是否舍长 */
    @Excel(name = "是否舍长")
    private String sfsz;

    /** 住宿标识 */
    @Excel(name = "住宿标识")
    private String zsbz;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private String cjsj;

    /** 单元名称 */
    @Excel(name = "单元名称")
    private String dymc;

    /** 自增主键 */
    @Excel(name = "自增主键")
    private String zzzj;

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
    public void setDwmc(String dwmc) 
    {
        this.dwmc = dwmc;
    }

    public String getDwmc() 
    {
        return dwmc;
    }
    public void setXb(String xb) 
    {
        this.xb = xb;
    }

    public String getXb() 
    {
        return xb;
    }
    public void setZymc(String zymc) 
    {
        this.zymc = zymc;
    }

    public String getZymc() 
    {
        return zymc;
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
    public void setPxh(Long pxh) 
    {
        this.pxh = pxh;
    }

    public Long getPxh() 
    {
        return pxh;
    }
    public void setBjmc(String bjmc) 
    {
        this.bjmc = bjmc;
    }

    public String getBjmc() 
    {
        return bjmc;
    }
    public void setSslmc(String sslmc) 
    {
        this.sslmc = sslmc;
    }

    public String getSslmc() 
    {
        return sslmc;
    }
    public void setSslxxbh(String sslxxbh) 
    {
        this.sslxxbh = sslxxbh;
    }

    public String getSslxxbh() 
    {
        return sslxxbh;
    }
    public void setSsdyxxbh(String ssdyxxbh) 
    {
        this.ssdyxxbh = ssdyxxbh;
    }

    public String getSsdyxxbh() 
    {
        return ssdyxxbh;
    }
    public void setFjtd(String fjtd) 
    {
        this.fjtd = fjtd;
    }

    public String getFjtd() 
    {
        return fjtd;
    }
    public void setSsfjxxbh(String ssfjxxbh) 
    {
        this.ssfjxxbh = ssfjxxbh;
    }

    public String getSsfjxxbh() 
    {
        return ssfjxxbh;
    }
    public void setSsmc(String ssmc) 
    {
        this.ssmc = ssmc;
    }

    public String getSsmc() 
    {
        return ssmc;
    }
    public void setCwbh(String cwbh) 
    {
        this.cwbh = cwbh;
    }

    public String getCwbh() 
    {
        return cwbh;
    }
    public void setSfsz(String sfsz) 
    {
        this.sfsz = sfsz;
    }

    public String getSfsz() 
    {
        return sfsz;
    }
    public void setZsbz(String zsbz) 
    {
        this.zsbz = zsbz;
    }

    public String getZsbz() 
    {
        return zsbz;
    }
    public void setCjsj(String cjsj) 
    {
        this.cjsj = cjsj;
    }

    public String getCjsj() 
    {
        return cjsj;
    }
    public void setDymc(String dymc) 
    {
        this.dymc = dymc;
    }

    public String getDymc() 
    {
        return dymc;
    }
    public void setZzzj(String zzzj) 
    {
        this.zzzj = zzzj;
    }

    public String getZzzj() 
    {
        return zzzj;
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
            .append("dwmc", getDwmc())
            .append("xb", getXb())
            .append("zymc", getZymc())
            .append("nj", getNj())
            .append("xh", getXh())
            .append("pxh", getPxh())
            .append("bjmc", getBjmc())
            .append("sslmc", getSslmc())
            .append("sslxxbh", getSslxxbh())
            .append("ssdyxxbh", getSsdyxxbh())
            .append("fjtd", getFjtd())
            .append("ssfjxxbh", getSsfjxxbh())
            .append("ssmc", getSsmc())
            .append("cwbh", getCwbh())
            .append("sfsz", getSfsz())
            .append("zsbz", getZsbz())
            .append("cjsj", getCjsj())
            .append("dymc", getDymc())
            .append("zzzj", getZzzj())
            .append("dcDcfieldaud", getDcDcfieldaud())
            .append("dcDcdatadate", getDcDcdatadate())
            .append("dcDctimestamp", getDcDctimestamp())
            .toString();
    }
}
