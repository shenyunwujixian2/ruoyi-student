package com.ruoyi.person.Bean.queryBean;

/**
 * Created by sW4716 on 2018/3/7.
 */
public class QueryPeopleInfoBean {
    /**
     * 部门编号（必填）总部门iccsid
     */
    private String departCode;
    /**
     *页码
     */
    private String pageNumber;
    /**
     *模糊查询关键字
     */
    private String keyWord;
    /**
     *特征值提取的状态
     */
    private String featureNum;
    /**
     *分页的大小
     */
    private String pageSize;

    public String getDepartCode() {
        return departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getFeatureNum() {
        return featureNum;
    }

    public void setFeatureNum(String featureNum) {
        this.featureNum = featureNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
