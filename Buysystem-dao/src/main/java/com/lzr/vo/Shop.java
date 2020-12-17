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
	private String shopdanwei;
	/**商品图片*/
	private String shopimg;
	/**是否上架*/
	private Integer isdelete;
	private List<Shopxq>  shopxqs;
	private double minprice;
	private double maxprice;
	private int number;
	private int wareid;
	/*评价*/
	private List<Shoppingjia>  shoppingjias;
	public Shop() {
		super();
	}

	public Shop(Integer shopid, String shopname, Shoptype shoptyid, String shopmiaoshu, double shopprice, String shopdanwei, String shopimg, Integer isdelete, List<Shopxq> shopxqs, double minprice, double maxprice, int number, int wareid, List<Shoppingjia> shoppingjias) {
		this.shopid = shopid;
		this.shopname = shopname;
		this.shoptyid = shoptyid;
		this.shopmiaoshu = shopmiaoshu;
		this.shopprice = shopprice;
		this.shopdanwei = shopdanwei;
		this.shopimg = shopimg;
		this.isdelete = isdelete;
		this.shopxqs = shopxqs;
		this.minprice = minprice;
		this.maxprice = maxprice;
		this.number = number;
		this.wareid = wareid;
		this.shoppingjias = shoppingjias;
	}

	public int getWareid() {
		return wareid;
	}

	public void setWareid(int wareid) {
		this.wareid = wareid;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public String getShopdanwei() {
		return shopdanwei;
	}

	public void setShopdanwei(String shopdanwei) {
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

	public double getMinprice() {
		return minprice;
	}

	public void setMinprice(double minprice) {
		this.minprice = minprice;
	}

	public double getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(double maxprice) {
		this.maxprice = maxprice;
	}

	@Override
	public String toString() {
		return "Shop{" +
				"shopid=" + shopid +
				", shopname='" + shopname + '\'' +
				", shoptyid=" + shoptyid +
				", shopmiaoshu='" + shopmiaoshu + '\'' +
				", shopprice=" + shopprice +
				", shopdanwei='" + shopdanwei + '\'' +
				", shopimg='" + shopimg + '\'' +
				", isdelete=" + isdelete +
				", shopxqs=" + shopxqs +
				", minprice=" + minprice +
				", maxprice=" + maxprice +
				", number=" + number +
				", wareid=" + wareid +
				", shoppingjias=" + shoppingjias +
				'}';
	}
}

