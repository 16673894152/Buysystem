package com.lzr.vo;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
* 表名 gouwuaddress
* */

@JsonIgnoreProperties(value = "handler")
public class Gouwuaddress {

    /*
    * 购物地址id
    * */
    private Integer addressid;

    /*
    * 用户
    * */
    private User userid;

    /*
    * 提货商户
    * */
    private User shid;

    /*
    * 购物地址备注
    * */
    private String beizhu;

    /*
    * 联系电话
    * */
    private String telephone;

    /*
    * 昵称（家/公司/学校）
    * */
    private String nicheng;

    public Gouwuaddress() {}

    public Gouwuaddress(Integer addressid, User userid, User shid, String beizhu, String telephone, String nicheng) {
        this.addressid = addressid;
        this.userid = userid;
        this.shid = shid;
        this.beizhu = beizhu;
        this.telephone = telephone;
        this.nicheng = nicheng;
    }

    @Override
    public String toString() {
        return "Gouwuaddress{" +
                "addressid=" + addressid +
                ", userid=" + userid +
                ", shid=" + shid +
                ", beizhu=" + beizhu +
                ", telephone='" + telephone + '\'' +
                ", nicheng='" + nicheng + '\'' +
                '}';
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public User getShid() {
        return shid;
    }

    public void setShid(User shid) {
        this.shid = shid;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNicheng() {
        return nicheng;
    }

    public void setNicheng(String nicheng) {
        this.nicheng = nicheng;
    }
}
