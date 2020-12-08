package com.lzr.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

import java.util.List;

/**
 * 表名 :  shoptype<br/>
 */ 
@JsonIgnoreProperties(value = "handler")
public class Shoptype implements Serializable {

	/**商品类型id*/
	private Integer shoptyid;
	/**类型名*/
	private String shoptyname;
	/**类型备注*/
	private String shopremart;

	public Shoptype() {
		super();
	}
	public Shoptype(Integer shoptyid,String shoptyname,String shopremart) {
		this.shoptyid = shoptyid;
		this.shoptyname = shoptyname;
		this.shopremart = shopremart;
	}

	/**设置"商品类型id"*/
	public void setShoptyid(Integer shoptyid){
		this.shoptyid = shoptyid;
	}
	/**获取"商品类型id"*/
	public Integer getShoptyid(){
		return shoptyid;
	}
	/**设置"类型名"*/
	public void setShoptyname(String shoptyname){
		this.shoptyname = shoptyname;
	}
	/**获取"类型名"*/
	public String getShoptyname(){
		return shoptyname;
	}
	/**设置"类型备注"*/
	public void setShopremart(String shopremart){
		this.shopremart = shopremart;
	}
	/**获取"类型备注"*/
	public String getShopremart(){
		return shopremart;
	}
	@Override
	public String toString() {
		return "shoptype[" + 
			"shoptyid = " + shoptyid + 
			", shoptyname = " + shoptyname + 
			", shopremart = " + shopremart +
			"]";
	}
}

