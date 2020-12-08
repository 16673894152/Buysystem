package com.lzr.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 表名 :  ckbaobiao<br/>
 */
@JsonIgnoreProperties(value = "handler")
public class Ckbaobiao implements Serializable {

    /**
     * 仓库报表id
     */
    private Integer ckbbid;
    /**
     * 商品id--商品信息表
     */
    private Shop shopid;
    /**
     * 仓库id--仓库信息表
     */
    private Warehouse wareid;
    /**
     * 进出数量
     */
    private Integer count;
    /**
     * 进出类型 1出货 2入货
     */
    private Integer type;
    /**
     * 时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp time;

    public Ckbaobiao() {
        super();
    }

    public Ckbaobiao(Integer ckbbid, Shop shopid, Warehouse wareid, Integer count, Integer type, Timestamp time) {
        this.ckbbid = ckbbid;
        this.shopid = shopid;
        this.wareid = wareid;
        this.count = count;
        this.type = type;
        this.time = time;
    }

    /**
     * 设置"仓库报表id"
     */
    public void setCkbbid(Integer ckbbid) {
        this.ckbbid = ckbbid;
    }

    /**
     * 获取"仓库报表id"
     */
    public Integer getCkbbid() {
        return ckbbid;
    }

    public void setShopid(Shop shopid) {
        this.shopid = shopid;
    }

    public Shop getShopid() {
        return shopid;
    }

    public void setWareid(Warehouse wareid) {
        this.wareid = wareid;
    }

    public Warehouse getWareid() {
        return wareid;
    }

    /**
     * 设置"进出数量"
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取"进出数量"
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置"进出类型 1出货 2入货"
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取"进出类型 1出货 2入货"
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置"时间"
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * 获取"时间"
     */
    public Timestamp getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "ckbaobiao[" +
                "ckbbid = " + ckbbid +
                ", shopid = " + shopid +
                ", wareid = " + wareid +
                ", count = " + count +
                ", type = " + type +
                ", time = " + time +
                "]";
    }
}

