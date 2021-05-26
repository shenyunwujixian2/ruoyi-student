package com.ruoyi.offline.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教务在校生信息对象 ztsj_ztsj_jwzxsxx_qywx
 * 
 * @author ruoyi
 * @date 2021-03-26
 */
public class ZtsjZtsjJwzxsxxQywx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 出生日期 */
    @Excel(name = "出生日期")
    private String csrq;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String lxfs;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String dzyx;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private String yzbm;

    /** 删除标识 */
    @Excel(name = "删除标识")
    private String scbz;

    /** 创建人姓名 */
    @Excel(name = "创建人姓名")
    private String cjrxm;

    /** 身份证件号 */
    @Excel(name = "身份证件号")
    private String sfzjh;

    /** 修改时间 */
    @Excel(name = "修改时间")
    private String xgsj;

    /** 性别 */
    @Excel(name = "性别")
    private String xb;

    /** 性别代码 */
    @Excel(name = "性别代码")
    private String xbdm;

    /** 血型码 */
    @Excel(name = "血型码")
    private String xxm;

    /** 血型 */
    @Excel(name = "血型")
    private String xx;

    /** 国家地区代码 */
    @Excel(name = "国家地区代码")
    private String gjdqdm;

    /** 国别 */
    @Excel(name = "国别")
    private String gb;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String jg;

    /** 民族 */
    @Excel(name = "民族")
    private String mz;

    /** 民族代码 */
    @Excel(name = "民族代码")
    private String mzdm;

    /** 姓名拼音 */
    @Excel(name = "姓名拼音")
    private String xmpy;

    /** 婚姻状况代码 */
    @Excel(name = "婚姻状况代码")
    private String hyzkdm;

    /** 出生地代码 */
    @Excel(name = "出生地代码")
    private String csddm;

    /** 身份证件有效期 */
    @Excel(name = "身份证件有效期")
    private String sfzjyxq;

    /** 曾用名 */
    @Excel(name = "曾用名")
    private String cym;

    /** 健康状况代码 */
    @Excel(name = "健康状况代码")
    private String jkzkdm;

    /** 火车到站 */
    @Excel(name = "火车到站")
    private String hcdz;

    /** 毕业中学 */
    @Excel(name = "毕业中学")
    private String byzx;

    /** 身份证类型代码 */
    @Excel(name = "身份证类型代码")
    private String sfzlxdm;

    /** 证件类型 */
    @Excel(name = "证件类型")
    private String zjlx;

    /** 生源地 */
    @Excel(name = "生源地")
    private String syd;

    /** 录取号 */
    @Excel(name = "录取号")
    private String lqh;

    /** 通讯地址 */
    @Excel(name = "通讯地址")
    private String txdz;

    /** 准考证号 */
    @Excel(name = "准考证号")
    private String zkzh;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String zzmm;

    /** 政治面貌代码 */
    @Excel(name = "政治面貌代码")
    private String zzmmdm;

    /** 特长 */
    @Excel(name = "特长")
    private String tc;

    /** 招生季度 */
    @Excel(name = "招生季度")
    private String zsjd;

    /** 考生类别代码 */
    @Excel(name = "考生类别代码")
    private String kslbdm;

    /** 照片 */
    @Excel(name = "照片")
    private String zp;

    /** 入学成绩 */
    @Excel(name = "入学成绩")
    private String rxcj;

    /** 学号 */
    @Excel(name = "学号")
    private String xh;

    /** 修改人 */
    @Excel(name = "修改人")
    private String xgr;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private String cjsj;

    /** 培养层次名称 */
    @Excel(name = "培养层次名称")
    private String pyccmc;

    /** 培养层次代码 */
    @Excel(name = "培养层次代码")
    private String pyccdm;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String dwmc;

    /** 单位代码 */
    @Excel(name = "单位代码")
    private String dwdm;

    /** 学科门类代码 */
    @Excel(name = "学科门类代码")
    private String xkmldm;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String zymc;

    /** 专业代码 */
    @Excel(name = "专业代码")
    private String zydm;

    /** 班级简称 */
    @Excel(name = "班级简称")
    private String bjjc;

    /** 班级代码 */
    @Excel(name = "班级代码")
    private String bjdm;

    /** 入学年份 */
    @Excel(name = "入学年份")
    private String rxnf;

    /** 是否在校 */
    @Excel(name = "是否在校")
    private String sfzx;

    /** 最长修读年限 */
    @Excel(name = "最长修读年限")
    private String zcxdnx;

    /** 培养方式代码 */
    @Excel(name = "培养方式代码")
    private String pyfsdm;

    /** 学生当前状态代码 */
    @Excel(name = "学生当前状态代码")
    private String xsdqztdm;

    /** 专业方向名称 */
    @Excel(name = "专业方向名称")
    private String zyfxmc;

    /** 考生号 */
    @Excel(name = "考生号")
    private String ksh;

    /** 毕业专业 */
    @Excel(name = "毕业专业")
    private String byzy;

    /** 学生类别代码 */
    @Excel(name = "学生类别代码")
    private String xslbdm;

    /** 学生类别 */
    @Excel(name = "学生类别")
    private String xslb;

    /** 学籍状态代码 */
    @Excel(name = "学籍状态代码")
    private String xjztdm;

    /** 学籍状态名称 */
    @Excel(name = "学籍状态名称")
    private String xjztmc;

    /** 当前年级 */
    @Excel(name = "当前年级")
    private String dqnj;

    /** 入学日期 */
    @Excel(name = "入学日期")
    private String rxrq;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String lxdh;

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
    public void setCsrq(String csrq) 
    {
        this.csrq = csrq;
    }

    public String getCsrq() 
    {
        return csrq;
    }
    public void setLxfs(String lxfs) 
    {
        this.lxfs = lxfs;
    }

    public String getLxfs() 
    {
        return lxfs;
    }
    public void setDzyx(String dzyx) 
    {
        this.dzyx = dzyx;
    }

    public String getDzyx() 
    {
        return dzyx;
    }
    public void setYzbm(String yzbm) 
    {
        this.yzbm = yzbm;
    }

    public String getYzbm() 
    {
        return yzbm;
    }
    public void setScbz(String scbz) 
    {
        this.scbz = scbz;
    }

    public String getScbz() 
    {
        return scbz;
    }
    public void setCjrxm(String cjrxm) 
    {
        this.cjrxm = cjrxm;
    }

    public String getCjrxm() 
    {
        return cjrxm;
    }
    public void setSfzjh(String sfzjh) 
    {
        this.sfzjh = sfzjh;
    }

    public String getSfzjh() 
    {
        return sfzjh;
    }
    public void setXgsj(String xgsj) 
    {
        this.xgsj = xgsj;
    }

    public String getXgsj() 
    {
        return xgsj;
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
    public void setXxm(String xxm) 
    {
        this.xxm = xxm;
    }

    public String getXxm() 
    {
        return xxm;
    }
    public void setXx(String xx) 
    {
        this.xx = xx;
    }

    public String getXx() 
    {
        return xx;
    }
    public void setGjdqdm(String gjdqdm) 
    {
        this.gjdqdm = gjdqdm;
    }

    public String getGjdqdm() 
    {
        return gjdqdm;
    }
    public void setGb(String gb) 
    {
        this.gb = gb;
    }

    public String getGb() 
    {
        return gb;
    }
    public void setJg(String jg) 
    {
        this.jg = jg;
    }

    public String getJg() 
    {
        return jg;
    }
    public void setMz(String mz) 
    {
        this.mz = mz;
    }

    public String getMz() 
    {
        return mz;
    }
    public void setMzdm(String mzdm) 
    {
        this.mzdm = mzdm;
    }

    public String getMzdm() 
    {
        return mzdm;
    }
    public void setXmpy(String xmpy) 
    {
        this.xmpy = xmpy;
    }

    public String getXmpy() 
    {
        return xmpy;
    }
    public void setHyzkdm(String hyzkdm) 
    {
        this.hyzkdm = hyzkdm;
    }

    public String getHyzkdm() 
    {
        return hyzkdm;
    }
    public void setCsddm(String csddm) 
    {
        this.csddm = csddm;
    }

    public String getCsddm() 
    {
        return csddm;
    }
    public void setSfzjyxq(String sfzjyxq) 
    {
        this.sfzjyxq = sfzjyxq;
    }

    public String getSfzjyxq() 
    {
        return sfzjyxq;
    }
    public void setCym(String cym) 
    {
        this.cym = cym;
    }

    public String getCym() 
    {
        return cym;
    }
    public void setJkzkdm(String jkzkdm) 
    {
        this.jkzkdm = jkzkdm;
    }

    public String getJkzkdm() 
    {
        return jkzkdm;
    }
    public void setHcdz(String hcdz) 
    {
        this.hcdz = hcdz;
    }

    public String getHcdz() 
    {
        return hcdz;
    }
    public void setByzx(String byzx) 
    {
        this.byzx = byzx;
    }

    public String getByzx() 
    {
        return byzx;
    }
    public void setSfzlxdm(String sfzlxdm) 
    {
        this.sfzlxdm = sfzlxdm;
    }

    public String getSfzlxdm() 
    {
        return sfzlxdm;
    }
    public void setZjlx(String zjlx) 
    {
        this.zjlx = zjlx;
    }

    public String getZjlx() 
    {
        return zjlx;
    }
    public void setSyd(String syd) 
    {
        this.syd = syd;
    }

    public String getSyd() 
    {
        return syd;
    }
    public void setLqh(String lqh) 
    {
        this.lqh = lqh;
    }

    public String getLqh() 
    {
        return lqh;
    }
    public void setTxdz(String txdz) 
    {
        this.txdz = txdz;
    }

    public String getTxdz() 
    {
        return txdz;
    }
    public void setZkzh(String zkzh) 
    {
        this.zkzh = zkzh;
    }

    public String getZkzh() 
    {
        return zkzh;
    }
    public void setZzmm(String zzmm) 
    {
        this.zzmm = zzmm;
    }

    public String getZzmm() 
    {
        return zzmm;
    }
    public void setZzmmdm(String zzmmdm) 
    {
        this.zzmmdm = zzmmdm;
    }

    public String getZzmmdm() 
    {
        return zzmmdm;
    }
    public void setTc(String tc) 
    {
        this.tc = tc;
    }

    public String getTc() 
    {
        return tc;
    }
    public void setZsjd(String zsjd) 
    {
        this.zsjd = zsjd;
    }

    public String getZsjd() 
    {
        return zsjd;
    }
    public void setKslbdm(String kslbdm) 
    {
        this.kslbdm = kslbdm;
    }

    public String getKslbdm() 
    {
        return kslbdm;
    }
    public void setZp(String zp) 
    {
        this.zp = zp;
    }

    public String getZp() 
    {
        return zp;
    }
    public void setRxcj(String rxcj) 
    {
        this.rxcj = rxcj;
    }

    public String getRxcj() 
    {
        return rxcj;
    }
    public void setXh(String xh) 
    {
        this.xh = xh;
    }

    public String getXh() 
    {
        return xh;
    }
    public void setXgr(String xgr) 
    {
        this.xgr = xgr;
    }

    public String getXgr() 
    {
        return xgr;
    }
    public void setCjsj(String cjsj) 
    {
        this.cjsj = cjsj;
    }

    public String getCjsj() 
    {
        return cjsj;
    }
    public void setPyccmc(String pyccmc) 
    {
        this.pyccmc = pyccmc;
    }

    public String getPyccmc() 
    {
        return pyccmc;
    }
    public void setPyccdm(String pyccdm) 
    {
        this.pyccdm = pyccdm;
    }

    public String getPyccdm() 
    {
        return pyccdm;
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
    public void setXkmldm(String xkmldm) 
    {
        this.xkmldm = xkmldm;
    }

    public String getXkmldm() 
    {
        return xkmldm;
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
    public void setBjjc(String bjjc) 
    {
        this.bjjc = bjjc;
    }

    public String getBjjc() 
    {
        return bjjc;
    }
    public void setBjdm(String bjdm) 
    {
        this.bjdm = bjdm;
    }

    public String getBjdm() 
    {
        return bjdm;
    }
    public void setRxnf(String rxnf) 
    {
        this.rxnf = rxnf;
    }

    public String getRxnf() 
    {
        return rxnf;
    }
    public void setSfzx(String sfzx) 
    {
        this.sfzx = sfzx;
    }

    public String getSfzx() 
    {
        return sfzx;
    }
    public void setZcxdnx(String zcxdnx) 
    {
        this.zcxdnx = zcxdnx;
    }

    public String getZcxdnx() 
    {
        return zcxdnx;
    }
    public void setPyfsdm(String pyfsdm) 
    {
        this.pyfsdm = pyfsdm;
    }

    public String getPyfsdm() 
    {
        return pyfsdm;
    }
    public void setXsdqztdm(String xsdqztdm) 
    {
        this.xsdqztdm = xsdqztdm;
    }

    public String getXsdqztdm() 
    {
        return xsdqztdm;
    }
    public void setZyfxmc(String zyfxmc) 
    {
        this.zyfxmc = zyfxmc;
    }

    public String getZyfxmc() 
    {
        return zyfxmc;
    }
    public void setKsh(String ksh) 
    {
        this.ksh = ksh;
    }

    public String getKsh() 
    {
        return ksh;
    }
    public void setByzy(String byzy) 
    {
        this.byzy = byzy;
    }

    public String getByzy() 
    {
        return byzy;
    }
    public void setXslbdm(String xslbdm) 
    {
        this.xslbdm = xslbdm;
    }

    public String getXslbdm() 
    {
        return xslbdm;
    }
    public void setXslb(String xslb) 
    {
        this.xslb = xslb;
    }

    public String getXslb() 
    {
        return xslb;
    }
    public void setXjztdm(String xjztdm) 
    {
        this.xjztdm = xjztdm;
    }

    public String getXjztdm() 
    {
        return xjztdm;
    }
    public void setXjztmc(String xjztmc) 
    {
        this.xjztmc = xjztmc;
    }

    public String getXjztmc() 
    {
        return xjztmc;
    }
    public void setDqnj(String dqnj) 
    {
        this.dqnj = dqnj;
    }

    public String getDqnj() 
    {
        return dqnj;
    }
    public void setRxrq(String rxrq) 
    {
        this.rxrq = rxrq;
    }

    public String getRxrq() 
    {
        return rxrq;
    }
    public void setLxdh(String lxdh) 
    {
        this.lxdh = lxdh;
    }

    public String getLxdh() 
    {
        return lxdh;
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
            .append("csrq", getCsrq())
            .append("lxfs", getLxfs())
            .append("dzyx", getDzyx())
            .append("yzbm", getYzbm())
            .append("scbz", getScbz())
            .append("cjrxm", getCjrxm())
            .append("sfzjh", getSfzjh())
            .append("xgsj", getXgsj())
            .append("xb", getXb())
            .append("xbdm", getXbdm())
            .append("xxm", getXxm())
            .append("xx", getXx())
            .append("gjdqdm", getGjdqdm())
            .append("gb", getGb())
            .append("jg", getJg())
            .append("mz", getMz())
            .append("mzdm", getMzdm())
            .append("xmpy", getXmpy())
            .append("hyzkdm", getHyzkdm())
            .append("csddm", getCsddm())
            .append("sfzjyxq", getSfzjyxq())
            .append("cym", getCym())
            .append("jkzkdm", getJkzkdm())
            .append("hcdz", getHcdz())
            .append("byzx", getByzx())
            .append("sfzlxdm", getSfzlxdm())
            .append("zjlx", getZjlx())
            .append("syd", getSyd())
            .append("lqh", getLqh())
            .append("txdz", getTxdz())
            .append("zkzh", getZkzh())
            .append("zzmm", getZzmm())
            .append("zzmmdm", getZzmmdm())
            .append("tc", getTc())
            .append("zsjd", getZsjd())
            .append("kslbdm", getKslbdm())
            .append("zp", getZp())
            .append("rxcj", getRxcj())
            .append("xh", getXh())
            .append("xgr", getXgr())
            .append("cjsj", getCjsj())
            .append("pyccmc", getPyccmc())
            .append("pyccdm", getPyccdm())
            .append("dwmc", getDwmc())
            .append("dwdm", getDwdm())
            .append("xkmldm", getXkmldm())
            .append("zymc", getZymc())
            .append("zydm", getZydm())
            .append("bjjc", getBjjc())
            .append("bjdm", getBjdm())
            .append("rxnf", getRxnf())
            .append("sfzx", getSfzx())
            .append("zcxdnx", getZcxdnx())
            .append("pyfsdm", getPyfsdm())
            .append("xsdqztdm", getXsdqztdm())
            .append("zyfxmc", getZyfxmc())
            .append("ksh", getKsh())
            .append("byzy", getByzy())
            .append("xslbdm", getXslbdm())
            .append("xslb", getXslb())
            .append("xjztdm", getXjztdm())
            .append("xjztmc", getXjztmc())
            .append("dqnj", getDqnj())
            .append("rxrq", getRxrq())
            .append("lxdh", getLxdh())
            .append("dcDcfieldaud", getDcDcfieldaud())
            .append("dcDcdatadate", getDcDcdatadate())
            .append("dcDctimestamp", getDcDctimestamp())
            .toString();
    }
}
