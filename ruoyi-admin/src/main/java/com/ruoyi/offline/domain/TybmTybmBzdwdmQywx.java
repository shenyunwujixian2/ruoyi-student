package com.ruoyi.offline.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学校部门对象 tybm_tybm_bzdwdm_qywx
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
public class TybmTybmBzdwdmQywx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 上级部门代码 */
    @Excel(name = "上级部门代码")
    private String sjbmdm;

    /** 上级部门名称 */
    @Excel(name = "上级部门名称")
    private String sjbmmc;

    /** 单位代码 */
    @Excel(name = "单位代码")
    private String dwdm;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String dwmc;

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

    public void setSjbmdm(String sjbmdm) 
    {
        this.sjbmdm = sjbmdm;
    }

    public String getSjbmdm() 
    {
        return sjbmdm;
    }
    public void setSjbmmc(String sjbmmc) 
    {
        this.sjbmmc = sjbmmc;
    }

    public String getSjbmmc() 
    {
        return sjbmmc;
    }
    public void setDwdm(String dwdm) 
    {
        this.dwdm = dwdm;
    }

    public String getDwdm() 
    {
        return dwdm;
    }
    public void setDwmc(String dwmc) 
    {
        this.dwmc = dwmc;
    }

    public String getDwmc() 
    {
        return dwmc;
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
            .append("sjbmdm", getSjbmdm())
            .append("sjbmmc", getSjbmmc())
            .append("dwdm", getDwdm())
            .append("dwmc", getDwmc())
            .append("dcDcfieldaud", getDcDcfieldaud())
            .append("dcDcdatadate", getDcDcdatadate())
            .append("dcDctimestamp", getDcDctimestamp())
            .toString();
    }
}
