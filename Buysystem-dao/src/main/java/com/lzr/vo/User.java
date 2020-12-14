package com.lzr.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import java.util.List;

/**
 * 表名 :  user<br/>
 */
@JsonIgnoreProperties(value = "handler")
public class User implements Serializable {

    /**
     * 用户id
     */
    private Integer userid;
    /**
     * 用户注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp zhucetime;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String userpass;
    /**
     * 用户手机号
     */
    private String usernumber;
    /**
     * 身份证号码
     */
    private String usercard;
    /**
     * 用户头像
     */
    private String userimg;
    /**
     * 会员id
     */
    private Huiyuan hyid;
    /**
     * 是否冻结
     */
    private Integer isdelete;
    private List<Orders> orderss;
    private List<Shopgouwu> shopgouwus;
    private List<Shoppingjia> shoppingjias;


    private String name;
    private int sex;

    public User() {
        super();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public User(Integer userid, Timestamp zhucetime, String username, String userpass, String usernumber, String usercard, String userimg, Huiyuan hyid, Integer isdelete, List<Orders> orderss, List<Shopgouwu> shopgouwus, List<Shoppingjia> shoppingjias, String name, int sex) {
        this.userid = userid;
        this.zhucetime = zhucetime;
        this.username = username;
        this.userpass = userpass;
        this.usernumber = usernumber;
        this.usercard = usercard;
        this.userimg = userimg;
        this.hyid = hyid;
        this.isdelete = isdelete;
        this.orderss = orderss;
        this.shopgouwus = shopgouwus;
        this.shoppingjias = shoppingjias;
        this.name = name;
        this.sex = sex;
    }

    /**
     * 设置"用户id"
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取"用户id"
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置"用户注册时间"
     */
    public void setZhucetime(Timestamp zhucetime) {
        this.zhucetime = zhucetime;
    }

    /**
     * 获取"用户注册时间"
     */
    public Timestamp getZhucetime() {
        return zhucetime;
    }

    /**
     * 设置"用户名"
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取"用户名"
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置"用户密码"
     */
    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    /**
     * 获取"用户密码"
     */
    public String getUserpass() {
        return userpass;
    }

    /**
     * 设置"用户手机号"
     */
    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    /**
     * 获取"用户手机号"
     */
    public String getUsernumber() {
        return usernumber;
    }

    /**
     * 设置"身份证号码"
     */
    public void setUsercard(String usercard) {
        this.usercard = usercard;
    }

    /**
     * 获取"身份证号码"
     */
    public String getUsercard() {
        return usercard;
    }

    /**
     * 设置"用户头像"
     */
    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    /**
     * 获取"用户头像"
     */
    public String getUserimg() {
        return userimg;
    }

    public void setHyid(Huiyuan hyid) {
        this.hyid = hyid;
    }

    public Huiyuan getHyid() {
        return hyid;
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

    public void setShopgouwus(List<Shopgouwu> shopgouwus) {
        this.shopgouwus = shopgouwus;
    }

    public List<Shopgouwu> getShopgouwus() {
        return shopgouwus;
    }

    public void setShoppingjias(List<Shoppingjia> shoppingjias) {
        this.shoppingjias = shoppingjias;
    }

    public List<Shoppingjia> getShoppingjias() {
        return shoppingjias;
    }

    @Override
    public String toString() {
        return "user[" +
                "userid = " + userid +
                ", zhucetime = " + zhucetime +
                ", username = " + username +
                ", userpass = " + userpass +
                ", usernumber = " + usernumber +
                ", usercard = " + usercard +
                ", userimg = " + userimg +
                ", hyid = " + hyid +
                ", isdelete = " + isdelete +
                ", orderss = " + orderss +
                ", shopgouwus = " + shopgouwus +
                ", shoppingjias = " + shoppingjias +
                "]";
    }
}

