package com.lzr.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  shopput<br/>
 */ 
@JsonIgnoreProperties(value = "handler")
public class Shopput implements Serializable {

	/**商品上架id*/
	private Integer shopputid;
	/**商品id*/
	private Shop shopid;
	/**商品折扣*/
	private Double shopzhe;
	/**商品零售价*/
	private Double shopputprice;
	/**是否下架删除*/
	private Integer isdelete;

	public Shopput() {
		super();
	}
	public Shopput(Integer shopputid,Shop shopid,Double shopzhe,Double shopputprice,Integer isdelete) {
		this.shopputid = shopputid;
		this.shopid = shopid;
		this.shopzhe = shopzhe;
		this.shopputprice = shopputprice;
		this.isdelete = isdelete;
	}
	/**设置"商品上架id"*/
	public void setShopputid(Integer shopputid){
		this.shopputid = shopputid;
	}
	/**获取"商品上架id"*/
	public Integer getShopputid(){
		return shopputid;
	}
	public void setShopid(Shop shopid){
		this.shopid = shopid;
	}
	public Shop getShopid(){
		return shopid;
	}
	/**设置"商品折扣"*/
	public void setShopzhe(Double shopzhe){
		this.shopzhe = shopzhe;
	}
	/**获取"商品折扣"*/
	public Double getShopzhe(){
		return shopzhe;
	}
	/**设置"商品零售价"*/
	public void setShopputprice(Double shopputprice){
		this.shopputprice = shopputprice;
	}
	/**获取"商品零售价"*/
	public Double getShopputprice(){
		return shopputprice;
	}
	/**设置"是否下架删除"*/
	public void setIsdelete(Integer isdelete){
		this.isdelete = isdelete;
	}
	/**获取"是否下架删除"*/
	public Integer getIsdelete(){
		return isdelete;
	}
	@Override
	public String toString() {
		return "shopput[" + 
			"shopputid = " + shopputid + 
			", shopid = " + shopid + 
			", shopzhe = " + shopzhe + 
			", shopputprice = " + shopputprice + 
			", isdelete = " + isdelete + 
			"]";
	}
}

