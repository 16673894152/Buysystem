package com.lzr.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  shoppingjia<br/>
 */ 
@JsonIgnoreProperties(value = "handler")
public class Shoppingjia implements Serializable {

	/**商品评价id*/
	private Integer shoppjid;
	/**商品id--商品信息表*/
	private Shop shopid;
	/**用户id--用户信息表*/
	private User userid;
	/**评价内容*/
	private String content;
	/**评价星级*/
	private Integer xing;

	public Shoppingjia() {
		super();
	}
	public Shoppingjia(Integer shoppjid,Shop shopid,User userid,String content,Integer xing) {
		this.shoppjid = shoppjid;
		this.shopid = shopid;
		this.userid = userid;
		this.content = content;
		this.xing = xing;
	}
	/**设置"商品评价id"*/
	public void setShoppjid(Integer shoppjid){
		this.shoppjid = shoppjid;
	}
	/**获取"商品评价id"*/
	public Integer getShoppjid(){
		return shoppjid;
	}
	public void setShopid(Shop shopid){
		this.shopid = shopid;
	}
	public Shop getShopid(){
		return shopid;
	}
	public void setUserid(User userid){
		this.userid = userid;
	}
	public User getUserid(){
		return userid;
	}
	/**设置"评价内容"*/
	public void setContent(String content){
		this.content = content;
	}
	/**获取"评价内容"*/
	public String getContent(){
		return content;
	}
	/**设置"评价星级"*/
	public void setXing(Integer xing){
		this.xing = xing;
	}
	/**获取"评价星级"*/
	public Integer getXing(){
		return xing;
	}
	@Override
	public String toString() {
		return "shoppingjia[" + 
			"shoppjid = " + shoppjid + 
			", shopid = " + shopid + 
			", userid = " + userid + 
			", content = " + content + 
			", xing = " + xing + 
			"]";
	}
}

