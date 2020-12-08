package com.lzr.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 表名 :  cwbaobiao<br/>
 */
@JsonIgnoreProperties(value = "handler")
public class Cwbaobiao implements Serializable {

    /**
     * 财务报表id
     */
    private Integer cwbbid;
    /**
     * 财务支出方或支入方
     */
    private String cwname;
    /**
     * 金额
     */
    private Double money;
    /**
     * 财务类型 1支出2支入
     */
    private Integer type;
    /**
     * 财务支出时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp time;

    public Cwbaobiao() {
        super();
    }

    public Cwbaobiao(Integer cwbbid, String cwname, Double money, Integer type, Timestamp time) {
        this.cwbbid = cwbbid;
        this.cwname = cwname;
        this.money = money;
        this.type = type;
        this.time = time;
    }

    /**
     * 设置"财务报表id"
     */
    public void setCwbbid(Integer cwbbid) {
        this.cwbbid = cwbbid;
    }

    /**
     * 获取"财务报表id"
     */
    public Integer getCwbbid() {
        return cwbbid;
    }

    /**
     * 设置"财务支出方或支入方"
     */
    public void setCwname(String cwname) {
        this.cwname = cwname;
    }

    /**
     * 获取"财务支出方或支入方"
     */
    public String getCwname() {
        return cwname;
    }

    /**
     * 设置"金额"
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * 获取"金额"
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 设置"财务类型 1支出2支入"
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取"财务类型 1支出2支入"
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置"财务支出时间"
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * 获取"财务支出时间"
     */
    public Timestamp getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "cwbaobiao[" +
                "cwbbid = " + cwbbid +
                ", cwname = " + cwname +
                ", money = " + money +
                ", type = " + type +
                ", time = " + time +
                "]";
    }
}

