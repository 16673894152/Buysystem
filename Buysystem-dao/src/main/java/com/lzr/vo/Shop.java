package com.lzr.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

import java.util.List;

/**
 * 表名 :  shop<br/>
 */ 
@JsonIgnoreProperties(value = "handler")
public class Shop implements Serializable {

	/**商品id*/
	private Integer shopid;
	/**商品名*/
	private String shopname;
	/**商品类型--类型对象*/
	private Shoptype shoptyid;
	/**商品描述*/
	private String shopmiaoshu;
	/**商品价格*/
	private double shopprice;
	/**商品单位*/
	private double shopdanwei;
	/**商品图片*/
	private String shopimg;
	/**是否上架*/
	private Integer isdelete;
	private List<Shopxq>  shopxqs;
	/*评价*/
	private List<Shoppingjia>  shoppingjias;
	public Shop() {
		super();
	}

	public Shop(Integer shopid, String shopname, Shoptype shoptyid, String shopmiaoshu, double shopprice, double shopdanwei, String shopimg, Integer isdelete, List<Shopxq> shopxqs, List<Shoppingjia> shoppingjias) {
		this.shopid = shopid;
		this.shopname = shopname;
		this.shoptyid = shoptyid;
		this.shopmiaoshu = shopmiaoshu;
		this.shopprice = shopprice;
		this.shopdanwei = shopdanwei;
		this.shopimg = shopimg;
		this.isdelete = isdelete;
		this.shopxqs = shopxqs;
		this.shoppingjias = shoppingjias;
	}

	public List<Shoppingjia> getShoppingjias() {
		return shoppingjias;
	}

	public void setShoppingjias(List<Shoppingjia> shoppingjias) {
		this.shoppingjias = shoppingjias;
	}

	public List<Shopxq> getShopxqs() {
		return shopxqs;
	}

	public void setShopxqs(List<Shopxq> shopxqs) {
		this.shopxqs = shopxqs;
	}

	/**设置"商品id"*/
	public void setShopid(Integer shopid){
		this.shopid = shopid;
	}
	/**获取"商品id"*/
	public Integer getShopid(){
		return shopid;
	}
	/**设置"商品名"*/
	public void setShopname(String shopname){
		this.shopname = shopname;
	}
	/**获取"商品名"*/
	public String getShopname(){
		return shopname;
	}
	public void setShoptyid(Shoptype shoptyid){
		this.shoptyid = shoptyid;
	}
	public Shoptype getShoptyid(){
		return shoptyid;
	}
	/**设置"商品描述"*/
	public void setShopmiaoshu(String shopmiaoshu){
		this.shopmiaoshu = shopmiaoshu;
	}
	/**获取"商品描述"*/
	public String getShopmiaoshu(){
		return shopmiaoshu;
	}

	public double getShopprice() {
		return shopprice;
	}

	public void setShopprice(double shopprice) {
		this.shopprice = shopprice;
	}

	public double getShopdanwei() {
		return shopdanwei;
	}

	public void setShopdanwei(double shopdanwei) {
		this.shopdanwei = shopdanwei;
	}

	/**设置"商品图片"*/
	public void setShopimg(String shopimg){
		this.shopimg = shopimg;
	}
	/**获取"商品图片"*/
	public String getShopimg(){
		return shopimg;
	}
	/**设置"是否上架"*/
	public void setIsdelete(Integer isdelete){
		this.isdelete = isdelete;
	}
	/**获取"是否上架"*/
	public Integer getIsdelete(){
		return isdelete;
	}

	@Override
	public String toString() {
		return "Shop{" +
				"shopid=" + shopid +
				", shopname='" + shopname + '\'' +
				", shoptyid=" + shoptyid +
				", shopmiaoshu='" + shopmiaoshu + '\'' +
				", shopprice=" + shopprice +
				", shopdanwei=" + shopdanwei +
				", shopimg='" + shopimg + '\'' +
				", isdelete=" + isdelete +
				", shopxqs=" + shopxqs +
				", shoppingjias=" + shoppingjias +
				'}';
	}
}

