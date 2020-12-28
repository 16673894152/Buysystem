package com.lzr.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;
import java.util.List;
@JsonIgnoreProperties(value = "handler")
public class User {

    private Integer userid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp zhucetime;
    private String username;
    private Integer sex;
    private String userpass;
    private String usernumber;
    private String usercard;
    private String userimg;
    private Huiyuan hyid;
    private Integer usertype;
    private String shaddress;
    private double shmoney;
    private Integer shstate;
    private String shstatehuifu;
    private Integer isdelete;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp shzhucetime;
    private String name;
    private List<Orders> userorderss;
    private List<Shopgouwu> shopgouwus;
    private List<Shoppingjia> shoppingjias;
    private List<Orders> shhuorderss;
    //商户负责人
    private String shname;
    //商户门店名
    private String storename;
    //商户联系方式
    private String storenumber;
    //用户收货地址
    private String useraddress;
    //商户银行卡号
    private String shyhcard;
    public User() {
    }

    public User(Integer userid, Timestamp zhucetime, String username, Integer sex, String userpass, String usernumber, String usercard, String userimg, Huiyuan hyid, Integer usertype, String shaddress, double shmoney, Integer shstate, String shstatehuifu, Integer isdelete, Timestamp shzhucetime, String name, List<Orders> userorderss, List<Shopgouwu> shopgouwus, List<Shoppingjia> shoppingjias, List<Orders> shhuorderss, String shname, String storename, String storenumber, String useraddress, String shyhcard) {
        this.userid = userid;
        this.zhucetime = zhucetime;
        this.username = username;
        this.sex = sex;
        this.userpass = userpass;
        this.usernumber = usernumber;
        this.usercard = usercard;
        this.userimg = userimg;
        this.hyid = hyid;
        this.usertype = usertype;
        this.shaddress = shaddress;
        this.shmoney = shmoney;
        this.shstate = shstate;
        this.shstatehuifu = shstatehuifu;
        this.isdelete = isdelete;
        this.shzhucetime = shzhucetime;
        this.name = name;
        this.userorderss = userorderss;
        this.shopgouwus = shopgouwus;
        this.shoppingjias = shoppingjias;
        this.shhuorderss = shhuorderss;
        this.shname = shname;
        this.storename = storename;
        this.storenumber = storenumber;
        this.useraddress = useraddress;
        this.shyhcard = shyhcard;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Timestamp getZhucetime() {
        return zhucetime;
    }

    public void setZhucetime(Timestamp zhucetime) {
        this.zhucetime = zhucetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    public String getUsercard() {
        return usercard;
    }

    public void setUsercard(String usercard) {
        this.usercard = usercard;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public Huiyuan getHyid() {
        return hyid;
    }

    public void setHyid(Huiyuan hyid) {
        this.hyid = hyid;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getShaddress() {
        return shaddress;
    }

    public void setShaddress(String shaddress) {
        this.shaddress = shaddress;
    }

    public double getShmoney() {
        return shmoney;
    }

    public void setShmoney(double shmoney) {
        this.shmoney = shmoney;
    }

    public Integer getShstate() {
        return shstate;
    }

    public void setShstate(Integer shstate) {
        this.shstate = shstate;
    }

    public String getShstatehuifu() {
        return shstatehuifu;
    }

    public void setShstatehuifu(String shstatehuifu) {
        this.shstatehuifu = shstatehuifu;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Timestamp getShzhucetime() {
        return shzhucetime;
    }

    public void setShzhucetime(Timestamp shzhucetime) {
        this.shzhucetime = shzhucetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Orders> getUserorderss() {
        return userorderss;
    }

    public void setUserorderss(List<Orders> userorderss) {
        this.userorderss = userorderss;
    }

    public List<Shopgouwu> getShopgouwus() {
        return shopgouwus;
    }

    public void setShopgouwus(List<Shopgouwu> shopgouwus) {
        this.shopgouwus = shopgouwus;
    }

    public List<Shoppingjia> getShoppingjias() {
        return shoppingjias;
    }

    public void setShoppingjias(List<Shoppingjia> shoppingjias) {
        this.shoppingjias = shoppingjias;
    }

    public List<Orders> getShhuorderss() {
        return shhuorderss;
    }

    public void setShhuorderss(List<Orders> shhuorderss) {
        this.shhuorderss = shhuorderss;
    }

    public String getShname() {
        return shname;
    }

    public void setShname(String shname) {
        this.shname = shname;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getStorenumber() {
        return storenumber;
    }

    public void setStorenumber(String storenumber) {
        this.storenumber = storenumber;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getShyhcard() {
        return shyhcard;
    }

    public void setShyhcard(String shyhcard) {
        this.shyhcard = shyhcard;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", zhucetime=" + zhucetime +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", userpass='" + userpass + '\'' +
                ", usernumber='" + usernumber + '\'' +
                ", usercard='" + usercard + '\'' +
                ", userimg='" + userimg + '\'' +
                ", hyid=" + hyid +
                ", usertype=" + usertype +
                ", shaddress='" + shaddress + '\'' +
                ", shmoney=" + shmoney +
                ", shstate=" + shstate +
                ", shstatehuifu='" + shstatehuifu + '\'' +
                ", isdelete=" + isdelete +
                ", shzhucetime=" + shzhucetime +
                ", name='" + name + '\'' +
                ", userorderss=" + userorderss +
                ", shopgouwus=" + shopgouwus +
                ", shoppingjias=" + shoppingjias +
                ", shhuorderss=" + shhuorderss +
                ", shname='" + shname + '\'' +
                ", storename='" + storename + '\'' +
                ", storenumber='" + storenumber + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", shyhcard='" + shyhcard + '\'' +
                '}';
    }
}
