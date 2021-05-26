package com.ruoyi.offline.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 门禁人员进出记录信息对象 mjxt_mjxt_mjryjcjlxx_qywx
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
public class MjxtMjxtMjryjcjlxxQywx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    @Excel(name = "自增主键")
    private Integer zzzj;

    /** 用户代码 */
    @Excel(name = "用户代码")
    private String yhdm;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 设备代码 */
    @Excel(name = "设备代码")
    private String sbdm;

    /** 日期 */
    @Excel(name = "日期")
    private String rq;

    /** 发生时间 */
    @Excel(name = "发生时间")
    private String fssj;

    /** 经过时间 */
    @Excel(name = "经过时间")
    private String jgsj;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbmc;

    /** 区域编号 */
    @Excel(name = "区域编号")
    private String qybh;

    /** 域名称 */
    @Excel(name = "域名称")
    private String ymc;

    /** 门组名称 */
    @Excel(name = "门组名称")
    private String mzmc;

    /** 门组编号 */
    @Excel(name = "门组编号")
    private String mzbh;

    /** 相机编号 */
    @Excel(name = "相机编号")
    private String xjbh;

    /** 卡口名称 */
    @Excel(name = "卡口名称")
    private String kkmc;

    /** 照片数量 */
    @Excel(name = "照片数量")
    private String zpsl;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String sblx;

    /** 进出标志 */
    @Excel(name = "进出标志")
    private String jcbz;

    /** 出入人员类型 */
    @Excel(name = "出入人员类型")
    private String crrylx;

    /** 照片编号 */
    @Excel(name = "照片编号")
    private String zpbh;

    /** 更新日期 */
    @Excel(name = "更新日期")
    private String gxrq;

    /** 采集信息数目 */
    @Excel(name = "采集信息数目")
    private String cjxxsm;

    /** 版本 */
    @Excel(name = "版本")
    private String bb;

    /** 记录数目 */
    @Excel(name = "记录数目")
    private String jlsm;

    /** 库数目 */
    @Excel(name = "库数目")
    private String ksm;

    /** IP地址 */
    @Excel(name = "IP地址")
    private String ipdz;

    /** 库编号 */
    @Excel(name = "库编号")
    private String kbh;

    /** 状态标识 */
    @Excel(name = "状态标识")
    private String ztbz;

    /** 相似度 */
    @Excel(name = "相似度")
    private String xsd;

    /** 记录类型 */
    @Excel(name = "记录类型")
    private String jllx;

    /** 记录时效类型 */
    @Excel(name = "记录时效类型")
    private String jlsxlx;

    /** 性别 */
    @Excel(name = "性别")
    private String xb;

    /** 红外记录 */
    @Excel(name = "红外记录")
    private String hwjl;

    /** 人脸质量 */
    @Excel(name = "人脸质量")
    private String rlzl;

    /** 核验模式 */
    @Excel(name = "核验模式")
    private String hyms;

    /** 身份证件号 */
    @Excel(name = "身份证件号")
    private String sfzjh;

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

    public void setZzzj(Integer zzzj) 
    {
        this.zzzj = zzzj;
    }

    public Integer getZzzj() 
    {
        return zzzj;
    }
    public void setYhdm(String yhdm) 
    {
        this.yhdm = yhdm;
    }

    public String getYhdm() 
    {
        return yhdm;
    }
    public void setXm(String xm) 
    {
        this.xm = xm;
    }

    public String getXm() 
    {
        return xm;
    }
    public void setSbdm(String sbdm) 
    {
        this.sbdm = sbdm;
    }

    public String getSbdm() 
    {
        return sbdm;
    }
    public void setRq(String rq) 
    {
        this.rq = rq;
    }

    public String getRq() 
    {
        return rq;
    }
    public void setFssj(String fssj) 
    {
        this.fssj = fssj;
    }

    public String getFssj() 
    {
        return fssj;
    }
    public void setJgsj(String jgsj) 
    {
        this.jgsj = jgsj;
    }

    public String getJgsj() 
    {
        return jgsj;
    }
    public void setSbmc(String sbmc) 
    {
        this.sbmc = sbmc;
    }

    public String getSbmc() 
    {
        return sbmc;
    }
    public void setQybh(String qybh) 
    {
        this.qybh = qybh;
    }

    public String getQybh() 
    {
        return qybh;
    }
    public void setYmc(String ymc) 
    {
        this.ymc = ymc;
    }

    public String getYmc() 
    {
        return ymc;
    }
    public void setMzmc(String mzmc) 
    {
        this.mzmc = mzmc;
    }

    public String getMzmc() 
    {
        return mzmc;
    }
    public void setMzbh(String mzbh) 
    {
        this.mzbh = mzbh;
    }

    public String getMzbh() 
    {
        return mzbh;
    }
    public void setXjbh(String xjbh) 
    {
        this.xjbh = xjbh;
    }

    public String getXjbh() 
    {
        return xjbh;
    }
    public void setKkmc(String kkmc) 
    {
        this.kkmc = kkmc;
    }

    public String getKkmc() 
    {
        return kkmc;
    }
    public void setZpsl(String zpsl) 
    {
        this.zpsl = zpsl;
    }

    public String getZpsl() 
    {
        return zpsl;
    }
    public void setSblx(String sblx) 
    {
        this.sblx = sblx;
    }

    public String getSblx() 
    {
        return sblx;
    }
    public void setJcbz(String jcbz) 
    {
        this.jcbz = jcbz;
    }

    public String getJcbz() 
    {
        return jcbz;
    }
    public void setCrrylx(String crrylx) 
    {
        this.crrylx = crrylx;
    }

    public String getCrrylx() 
    {
        return crrylx;
    }
    public void setZpbh(String zpbh) 
    {
        this.zpbh = zpbh;
    }

    public String getZpbh() 
    {
        return zpbh;
    }
    public void setGxrq(String gxrq) 
    {
        this.gxrq = gxrq;
    }

    public String getGxrq() 
    {
        return gxrq;
    }
    public void setCjxxsm(String cjxxsm) 
    {
        this.cjxxsm = cjxxsm;
    }

    public String getCjxxsm() 
    {
        return cjxxsm;
    }
    public void setBb(String bb) 
    {
        this.bb = bb;
    }

    public String getBb() 
    {
        return bb;
    }
    public void setJlsm(String jlsm) 
    {
        this.jlsm = jlsm;
    }

    public String getJlsm() 
    {
        return jlsm;
    }
    public void setKsm(String ksm) 
    {
        this.ksm = ksm;
    }

    public String getKsm() 
    {
        return ksm;
    }
    public void setIpdz(String ipdz) 
    {
        this.ipdz = ipdz;
    }

    public String getIpdz() 
    {
        return ipdz;
    }
    public void setKbh(String kbh) 
    {
        this.kbh = kbh;
    }

    public String getKbh() 
    {
        return kbh;
    }
    public void setZtbz(String ztbz) 
    {
        this.ztbz = ztbz;
    }

    public String getZtbz() 
    {
        return ztbz;
    }
    public void setXsd(String xsd) 
    {
        this.xsd = xsd;
    }

    public String getXsd() 
    {
        return xsd;
    }
    public void setJllx(String jllx) 
    {
        this.jllx = jllx;
    }

    public String getJllx() 
    {
        return jllx;
    }
    public void setJlsxlx(String jlsxlx) 
    {
        this.jlsxlx = jlsxlx;
    }

    public String getJlsxlx() 
    {
        return jlsxlx;
    }
    public void setXb(String xb) 
    {
        this.xb = xb;
    }

    public String getXb() 
    {
        return xb;
    }
    public void setHwjl(String hwjl) 
    {
        this.hwjl = hwjl;
    }

    public String getHwjl() 
    {
        return hwjl;
    }
    public void setRlzl(String rlzl) 
    {
        this.rlzl = rlzl;
    }

    public String getRlzl() 
    {
        return rlzl;
    }
    public void setHyms(String hyms) 
    {
        this.hyms = hyms;
    }

    public String getHyms() 
    {
        return hyms;
    }
    public void setSfzjh(String sfzjh) 
    {
        this.sfzjh = sfzjh;
    }

    public String getSfzjh() 
    {
        return sfzjh;
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
            .append("zzzj", getZzzj())
            .append("yhdm", getYhdm())
            .append("xm", getXm())
            .append("sbdm", getSbdm())
            .append("rq", getRq())
            .append("fssj", getFssj())
            .append("jgsj", getJgsj())
            .append("sbmc", getSbmc())
            .append("qybh", getQybh())
            .append("ymc", getYmc())
            .append("mzmc", getMzmc())
            .append("mzbh", getMzbh())
            .append("xjbh", getXjbh())
            .append("kkmc", getKkmc())
            .append("zpsl", getZpsl())
            .append("sblx", getSblx())
            .append("jcbz", getJcbz())
            .append("crrylx", getCrrylx())
            .append("zpbh", getZpbh())
            .append("gxrq", getGxrq())
            .append("cjxxsm", getCjxxsm())
            .append("bb", getBb())
            .append("jlsm", getJlsm())
            .append("ksm", getKsm())
            .append("ipdz", getIpdz())
            .append("kbh", getKbh())
            .append("ztbz", getZtbz())
            .append("xsd", getXsd())
            .append("jllx", getJllx())
            .append("jlsxlx", getJlsxlx())
            .append("xb", getXb())
            .append("hwjl", getHwjl())
            .append("rlzl", getRlzl())
            .append("hyms", getHyms())
            .append("sfzjh", getSfzjh())
            .append("dcDcfieldaud", getDcDcfieldaud())
            .append("dcDcdatadate", getDcDcdatadate())
            .append("dcDctimestamp", getDcDctimestamp())
            .toString();
    }
}
