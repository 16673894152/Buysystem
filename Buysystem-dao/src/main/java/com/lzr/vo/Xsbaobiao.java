package com.lzr.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 表名 :  xsbaobiao<br/>
 */
@JsonIgnoreProperties(value = "handler")
public class Xsbaobiao implements Serializable {

    /**
     * 销售报表id
     */
    private Integer xsbbid;
    /**
     * 商品id--商品信息表
     */
    private Shop shopid;
    /**
     * 销售数量
     */
    private Integer count;
    /**
     * 销售金额
     */
    private Double money;
    /**
     * 销售类型 1卖出 2退货
     */
    private Integer type;
    /**
     * 销售时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp time;
    /*前台查询时间字段名*/
    private String querytime;
    /*前台查询类型字段名*/
    private int querytype;
    public Xsbaobiao() {
        super();
    }

    public Xsbaobiao(Integer xsbbid, Shop shopid, Integer count, Double money, Integer type, Timestamp time, String querytime, int querytype) {
        this.xsbbid = xsbbid;
        this.shopid = shopid;
        this.count = count;
        this.money = money;
        this.type = type;
        this.time = time;
        this.querytime = querytime;
        this.querytype = querytype;
    }

    @Override
    public String toString() {
        return "Xsbaobiao{" +
                "xsbbid=" + xsbbid +
                ", shopid=" + shopid +
                ", count=" + count +
                ", money=" + money +
                ", type=" + type +
                ", time=" + time +
                ", querytime='" + querytime + '\'' +
                ", querytype=" + querytype +
                '}';
    }

    public int getQuerytype() {
        return querytype;
    }

    public void setQuerytype(int querytype) {
        this.querytype = querytype;
    }

    /**
     * 设置"销售报表id"
     */
    public void setXsbbid(Integer xsbbid) {
        this.xsbbid = xsbbid;
    }

    /**
     * 获取"销售报表id"
     */
    public Integer getXsbbid() {
        return xsbbid;
    }

    public void setShopid(Shop shopid) {
        this.shopid = shopid;
    }

    public Shop getShopid() {
        return shopid;
    }

    /**
     * 设置"销售数量"
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取"销售数量"
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置"销售金额"
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * 获取"销售金额"
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 设置"销售类型 1卖出 2退货"
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取"销售类型 1卖出 2退货"
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置"销售时间"
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * 获取"销售时间"
     */
    public Timestamp getTime() {
        return time;
    }

    public String getQuerytime() {
        return querytime;
    }

    public void setQuerytime(String querytime) {
        this.querytime = querytime;
    }

}

