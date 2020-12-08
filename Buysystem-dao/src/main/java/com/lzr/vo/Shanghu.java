package com.lzr.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import java.util.List;

/**
 * 表名 :  shanghu<br/>
 */
@JsonIgnoreProperties(value = "handler")
public class Shanghu implements Serializable {

    /**
     * 商户id
     */
    private Integer shid;
    /**
     * 商户注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp shzhucetime;
    /**
     * 商户名
     */
    private String shname;
    /**
     * 商户手机号
     */
    private String shnumber;
    /**
     * 商户密码
     */
    private String shpass;
    /**
     * 商户余额
     */
    private String shmoney;
    /**
     * 商户身份证号码
     */
    private String shcard;
    /**
     * 商户头像
     */
    private String shimg;
    /**
     * 商户地址
     */
    private String shaddress;
    /**
     * 商户审核状态
     */
    private Integer shstate;
    /**
     * 是否冻结
     */
    private Integer isdelete;
    private List<Orders> orderss;

    public Shanghu() {
        super();
    }

    public Shanghu(Integer shid, Timestamp shzhucetime, String shname, String shnumber, String shpass, String shmoney, String shcard, String shimg, String shaddress, Integer shstate, Integer isdelete) {
        this.shid = shid;
        this.shzhucetime = shzhucetime;
        this.shname = shname;
        this.shnumber = shnumber;
        this.shpass = shpass;
        this.shmoney = shmoney;
        this.shcard = shcard;
        this.shimg = shimg;
        this.shaddress = shaddress;
        this.shstate = shstate;
        this.isdelete = isdelete;
    }

    public Shanghu(Integer shid, Timestamp shzhucetime, String shname, String shnumber, String shpass, String shmoney, String shcard, String shimg, String shaddress, Integer shstate, Integer isdelete, List<Orders> orderss) {
        this.shid = shid;
        this.shzhucetime = shzhucetime;
        this.shname = shname;
        this.shnumber = shnumber;
        this.shpass = shpass;
        this.shmoney = shmoney;
        this.shcard = shcard;
        this.shimg = shimg;
        this.shaddress = shaddress;
        this.shstate = shstate;
        this.isdelete = isdelete;
        this.orderss = orderss;
    }

    /**
     * 设置"商户id"
     */
    public void setShid(Integer shid) {
        this.shid = shid;
    }

    /**
     * 获取"商户id"
     */
    public Integer getShid() {
        return shid;
    }

    /**
     * 设置"商户注册时间"
     */
    public void setShzhucetime(Timestamp shzhucetime) {
        this.shzhucetime = shzhucetime;
    }

    /**
     * 获取"商户注册时间"
     */
    public Timestamp getShzhucetime() {
        return shzhucetime;
    }

    /**
     * 设置"商户名"
     */
    public void setShname(String shname) {
        this.shname = shname;
    }

    /**
     * 获取"商户名"
     */
    public String getShname() {
        return shname;
    }

    /**
     * 设置"商户手机号"
     */
    public void setShnumber(String shnumber) {
        this.shnumber = shnumber;
    }

    /**
     * 获取"商户手机号"
     */
    public String getShnumber() {
        return shnumber;
    }

    /**
     * 设置"商户密码"
     */
    public void setShpass(String shpass) {
        this.shpass = shpass;
    }

    /**
     * 获取"商户密码"
     */
    public String getShpass() {
        return shpass;
    }

    /**
     * 设置"商户余额"
     */
    public void setShmoney(String shmoney) {
        this.shmoney = shmoney;
    }

    /**
     * 获取"商户余额"
     */
    public String getShmoney() {
        return shmoney;
    }

    /**
     * 设置"商户身份证号码"
     */
    public void setShcard(String shcard) {
        this.shcard = shcard;
    }

    /**
     * 获取"商户身份证号码"
     */
    public String getShcard() {
        return shcard;
    }

    /**
     * 设置"商户头像"
     */
    public void setShimg(String shimg) {
        this.shimg = shimg;
    }

    /**
     * 获取"商户头像"
     */
    public String getShimg() {
        return shimg;
    }

    /**
     * 设置"商户地址"
     */
    public void setShaddress(String shaddress) {
        this.shaddress = shaddress;
    }

    /**
     * 获取"商户地址"
     */
    public String getShaddress() {
        return shaddress;
    }

    /**
     * 设置"商户审核状态"
     */
    public void setShstate(Integer shstate) {
        this.shstate = shstate;
    }

    /**
     * 获取"商户审核状态"
     */
    public Integer getShstate() {
        return shstate;
    }

    /**
     * 设置"是否冻结"
     */
    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    /**
     * 获取"是否冻结"
     */
    public Integer getIsdelete() {
        return isdelete;
    }

    public void setOrderss(List<Orders> orderss) {
        this.orderss = orderss;
    }

    public List<Orders> getOrderss() {
        return orderss;
    }

    @Override
    public String toString() {
        return "shanghu[" +
                "shid = " + shid +
                ", shzhucetime = " + shzhucetime +
                ", shname = " + shname +
                ", shnumber = " + shnumber +
                ", shpass = " + shpass +
                ", shmoney = " + shmoney +
                ", shcard = " + shcard +
                ", shimg = " + shimg +
                ", shaddress = " + shaddress +
                ", shstate = " + shstate +
                ", isdelete = " + isdelete +
                ", orderss = " + orderss +
                "]";
    }
}

