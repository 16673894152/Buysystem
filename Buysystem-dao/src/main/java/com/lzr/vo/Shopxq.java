package com.lzr.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  shopxq<br/>
 */ 
@JsonIgnoreProperties(value = "handler")
public class Shopxq implements Serializable {

	/**商品详情id*/
	private Integer shopxqid;
	/**商品id--商品信息表*/
	private Integer shopid;
	/**商品图片地址*/
	private String shopimg;

	public Shopxq() {
		super();
	}
	public Shopxq(Integer shopxqid,Integer shopid,String shopimg) {
		this.shopxqid = shopxqid;
		this.shopid = shopid;
		this.shopimg = shopimg;
	}
	/**设置"商品详情id"*/
	public void setShopxqid(Integer shopxqid){
		this.shopxqid = shopxqid;
	}
	/**获取"商品详情id"*/
	public Integer getShopxqid(){
		return shopxqid;
	}
	public void setShopid(Integer shopid){
		this.shopid = shopid;
	}
	public Integer getShopid(){
		return shopid;
	}
	/**设置"商品图片地址"*/
	public void setShopimg(String shopimg){
		this.shopimg = shopimg;
	}
	/**获取"商品图片地址"*/
	public String getShopimg(){
		return shopimg;
	}
	@Override
	public String toString() {
		return "shopxq[" + 
			"shopxqid = " + shopxqid +
			", shopid = " + shopid +
			", shopimg = " + shopimg + 
			"]";
	}
}

