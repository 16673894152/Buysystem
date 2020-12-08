package com.lzr.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  orderxq<br/>
 */ 
@JsonIgnoreProperties(value = "handler")
public class Orderxq implements Serializable {

	/**订单详情id*/
	private Integer orderxqid;
	/**商品id--商品信息表*/
	private Shop shopid;
	/**订单id--订单信息表*/
	private Orders orderid;
	/**订单数量*/
	private Integer orderxqcount;
	/**订单总金额*/
	private Double orderxqmoney;

	public Orderxq() {
		super();
	}
	public Orderxq(Integer orderxqid,Shop shopid,Orders orderid,Integer orderxqcount,Double orderxqmoney) {
		this.orderxqid = orderxqid;
		this.shopid = shopid;
		this.orderid = orderid;
		this.orderxqcount = orderxqcount;
		this.orderxqmoney = orderxqmoney;
	}
	/**设置"订单详情id"*/
	public void setOrderxqid(Integer orderxqid){
		this.orderxqid = orderxqid;
	}
	/**获取"订单详情id"*/
	public Integer getOrderxqid(){
		return orderxqid;
	}
	public void setShopid(Shop shopid){
		this.shopid = shopid;
	}
	public Shop getShopid(){
		return shopid;
	}
	public void setOrderid(Orders orderid){
		this.orderid = orderid;
	}
	public Orders getOrderid(){
		return orderid;
	}
	/**设置"订单数量"*/
	public void setOrderxqcount(Integer orderxqcount){
		this.orderxqcount = orderxqcount;
	}
	/**获取"订单数量"*/
	public Integer getOrderxqcount(){
		return orderxqcount;
	}
	/**设置"订单总金额"*/
	public void setOrderxqmoney(Double orderxqmoney){
		this.orderxqmoney = orderxqmoney;
	}
	/**获取"订单总金额"*/
	public Double getOrderxqmoney(){
		return orderxqmoney;
	}
	@Override
	public String toString() {
		return "orderxq[" + 
			"orderxqid = " + orderxqid + 
			", shopid = " + shopid + 
			", orderid = " + orderid + 
			", orderxqcount = " + orderxqcount + 
			", orderxqmoney = " + orderxqmoney + 
			"]";
	}
}

