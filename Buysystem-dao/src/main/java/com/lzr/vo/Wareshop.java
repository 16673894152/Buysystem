package com.lzr.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  wareshop<br/>
 */ 
@JsonIgnoreProperties(value = "handler")
public class Wareshop implements Serializable {

	/**仓库商品id*/
	private Integer wsshid;
	/**商品id---商品对象*/
	private Shop shopid;
	/**仓库id---仓库对象*/
	private Warehouse wareid;
	/**商品数量*/
	private Integer shopcount;
	/**是否删除*/
	private Integer isdelete;

	public Wareshop() {
		super();
	}
	public Wareshop(Integer wsshid,Shop shopid,Warehouse wareid,Integer shopcount,Integer isdelete) {
		this.wsshid = wsshid;
		this.shopid = shopid;
		this.wareid = wareid;
		this.shopcount = shopcount;
		this.isdelete = isdelete;
	}
	/**设置"仓库商品id"*/
	public void setWsshid(Integer wsshid){
		this.wsshid = wsshid;
	}
	/**获取"仓库商品id"*/
	public Integer getWsshid(){
		return wsshid;
	}
	public void setShopid(Shop shopid){
		this.shopid = shopid;
	}
	public Shop getShopid(){
		return shopid;
	}
	public void setWareid(Warehouse wareid){
		this.wareid = wareid;
	}
	public Warehouse getWareid(){
		return wareid;
	}
	/**设置"商品数量"*/
	public void setShopcount(Integer shopcount){
		this.shopcount = shopcount;
	}
	/**获取"商品数量"*/
	public Integer getShopcount(){
		return shopcount;
	}
	/**设置"是否删除"*/
	public void setIsdelete(Integer isdelete){
		this.isdelete = isdelete;
	}
	/**获取"是否删除"*/
	public Integer getIsdelete(){
		return isdelete;
	}
	@Override
	public String toString() {
		return "wareshop[" + 
			"wsshid = " + wsshid + 
			", shopid = " + shopid + 
			", wareid = " + wareid + 
			", shopcount = " + shopcount + 
			", isdelete = " + isdelete + 
			"]";
	}
}

