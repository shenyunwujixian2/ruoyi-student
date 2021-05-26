package com.ruoyi.person.Bean.queryBean;

/**
 * Created by sW4716 on 2018/3/7.
 */
public class QueryAcessInfoBean {
    /**
     * 结束时间
     */
    private String endTime;
    /**
     *开始时间
     */
    private String startTime;
    /**
     *页码
     */
    private  String page;
    /**
     *每页大小
     */
    private  String size;

    /**
     *
     */
    private String personType;
    /**
     * 人员编码
     */
    private String personCode;
    /**
     * 进出方向
     */
    private String inOrOut;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(String inOrOut) {
        this.inOrOut = inOrOut;
    }
}
