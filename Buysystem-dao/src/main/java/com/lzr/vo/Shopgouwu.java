package com.lzr.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  shopgouwu<br/>
 */ 
@JsonIgnoreProperties(value = "handler")
public class Shopgouwu implements Serializable {

	/**购物车id*/
	private Integer shopgwid;
	/**商品id--商品信息表*/
	private Shopput shopputid;
	/**用户id--用户信息表*/
	private User userid;
	/**数量*/
	private Integer number;
	/**商品金额*/
	private float price;

	public Shopgouwu() {
		super();
	}
	public Shopgouwu(Integer shopgwid,Shopput shopputid,User userid,Integer number,float price) {
		this.shopgwid = shopgwid;
		this.shopputid = shopputid;
		this.userid = userid;
		this.number = number;
		this.price = price;
	}
	/**设置"购物车id"*/
	public void setShopgwid(Integer shopgwid){
		this.shopgwid = shopgwid;
	}
	/**获取"购物车id"*/
	public Integer getShopgwid(){
		return shopgwid;
	}
	/**设置"商品id--商品信息表"*/
	public void setShopid(Shopput shopputid){
		this.shopputid = shopputid;
	}
	/**获取"商品id--商品信息表"*/
	public Shopput getShopid(){
		return shopputid;
	}
	public void setUserid(User userid){
		this.userid = userid;
	}
	public User getUserid(){
		return userid;
	}
	/**设置"数量"*/
	public void setNumber(Integer number){
		this.number = number;
	}
	/**获取"数量"*/
	public Integer getNumber(){
		return number;
	}
	/**设置"商品金额"*/
	public void setPrice(float price){
		this.price = price;
	}
	/**获取"商品金额"*/
	public float getPrice(){
		return price;
	}
	@Override
	public String toString() {
		return "shopgouwu[" + 
			"shopgwid = " + shopgwid + 
			", shopputid = " + shopputid +
			", userid = " + userid + 
			", number = " + number + 
			", price = " + price + 
			"]";
	}
}

