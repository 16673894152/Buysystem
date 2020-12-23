package com.lzr.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import java.util.List;

/**
 * 表名 :  orders<br/>
 */
@JsonIgnoreProperties(value = "handler")
public class Orders implements Serializable {

    /**
     * 订单id
     */
    private Integer orderid;
    /**
     * 用户id---用户信息  外键
     */
    private User userid;
    /**
     * 商户id--提货人等信息 外键
     */
    private User shid;
    /**
     * 订单总数量
     */
    private Integer ordercount;
    /**
     * 订单总金额
     */
    private Double ordermoney;
    /**
     * 订单编号
     */
    private String orderbianhao;
    /**
     * 订单创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp ordertime;
    /**
     * 收货人姓名
     */
    private String consigneename;
    /**
     * 收货人联系方式
     */
    private String consigneenumber;
    /**
     * 收获人地址
     */
    private String consigneeaddress;
    /**
     * 状态
     */
    private Integer orderstate;
    /**
     * 是否删除
     */
    private Integer isdelete;
    /**
     * 商户收入
     */
    private Double shshouru;
    /**
     * 商户收入
     */
    private Double youhuiprice;
    private List<Orderxq> orderxqs;

    public Orders() {
        super();
    }

    public Orders(Integer orderid, User userid, User shid, Integer ordercount, Double ordermoney, String orderbianhao, Timestamp ordertime, String consigneename, String consigneenumber, String consigneeaddress, Integer orderstate, Integer isdelete, Double shshouru, Double youhuiprice, List<Orderxq> orderxqs) {
        this.orderid = orderid;
        this.userid = userid;
        this.shid = shid;
        this.ordercount = ordercount;
        this.ordermoney = ordermoney;
        this.orderbianhao = orderbianhao;
        this.ordertime = ordertime;
        this.consigneename = consigneename;
        this.consigneenumber = consigneenumber;
        this.consigneeaddress = consigneeaddress;
        this.orderstate = orderstate;
        this.isdelete = isdelete;
        this.shshouru = shshouru;
        this.youhuiprice = youhuiprice;
        this.orderxqs = orderxqs;
    }

    /**
     * 设置"订单id"
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    /**
     * 获取"订单id"
     */
    public Integer getOrderid() {
        return orderid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public User getUserid() {
        return userid;
    }

    public void setShid(User shid) {
        this.shid = shid;
    }

    public User getShid() {
        return shid;
    }

    /**
     * 设置"订单总数量"
     */
    public void setOrdercount(Integer ordercount) {
        this.ordercount = ordercount;
    }

    /**
     * 获取"订单总数量"
     */
    public Integer getOrdercount() {
        return ordercount;
    }

    /**
     * 设置"订单总金额"
     */
    public void setOrdermoney(Double ordermoney) {
        this.ordermoney = ordermoney;
    }

    /**
     * 获取"订单总金额"
     */
    public Double getOrdermoney() {
        return ordermoney;
    }

    /**
     * 设置"订单编号"
     */
    public void setOrderbianhao(String orderbianhao) {
        this.orderbianhao = orderbianhao;
    }

    /**
     * 获取"订单编号"
     */
    public String getOrderbianhao() {
        return orderbianhao;
    }

    /**
     * 设置"订单创建时间"
     */
    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    /**
     * 获取"订单创建时间"
     */
    public Timestamp getOrdertime() {
        return ordertime;
    }

    /**
     * 设置"收货人姓名"
     */
    public void setConsigneename(String consigneename) {
        this.consigneename = consigneename;
    }

    /**
     * 获取"收货人姓名"
     */
    public String getConsigneename() {
        return consigneename;
    }

    /**
     * 设置"收货人联系方式"
     */
    public void setConsigneenumber(String consigneenumber) {
        this.consigneenumber = consigneenumber;
    }

    /**
     * 获取"收货人联系方式"
     */
    public String getConsigneenumber() {
        return consigneenumber;
    }

    /**
     * 设置"收获人地址"
     */
    public void setConsigneeaddress(String consigneeaddress) {
        this.consigneeaddress = consigneeaddress;
    }

    /**
     * 获取"收获人地址"
     */
    public String getConsigneeaddress() {
        return consigneeaddress;
    }

    /**
     * 设置"状态"
     */
    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }

    /**
     * 获取"状态"
     */
    public Integer getOrderstate() {
        return orderstate;
    }

    /**
     * 设置"是否删除"
     */
    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    /**
     * 获取"是否删除"
     */
    public Integer getIsdelete() {
        return isdelete;
    }

    /**
     * 设置"商户收入"
     */
    public void setShshouru(Double shshouru) {
        this.shshouru = shshouru;
    }

    /**
     * 获取"商户收入"
     */
    public Double getShshouru() {
        return shshouru;
    }

    public void setOrderxqs(List<Orderxq> orderxqs) {
        this.orderxqs = orderxqs;
    }

    public List<Orderxq> getOrderxqs() {
        return orderxqs;
    }

    public Double getYouhuiprice() {
        return youhuiprice;
    }

    public void setYouhuiprice(Double youhuiprice) {
        this.youhuiprice = youhuiprice;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderid=" + orderid +
                ", userid=" + userid +
                ", shid=" + shid +
                ", ordercount=" + ordercount +
                ", ordermoney=" + ordermoney +
                ", orderbianhao='" + orderbianhao + '\'' +
                ", ordertime=" + ordertime +
                ", consigneename='" + consigneename + '\'' +
                ", consigneenumber='" + consigneenumber + '\'' +
                ", consigneeaddress='" + consigneeaddress + '\'' +
                ", orderstate=" + orderstate +
                ", isdelete=" + isdelete +
                ", shshouru=" + shshouru +
                ", youhuiprice=" + youhuiprice +
                ", orderxqs=" + orderxqs +
                '}';
    }
}

