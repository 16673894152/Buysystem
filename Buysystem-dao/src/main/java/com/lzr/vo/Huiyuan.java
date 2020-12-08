package com.lzr.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

import java.util.List;

/**
 * 表名 :  huiyuan<br/>
 */ 
@JsonIgnoreProperties(value = "handler")
public class Huiyuan implements Serializable {

	/**会员id*/
	private Integer hyid;
	/**会员名*/
	private String hyname;
	/**会员折扣*/
	private Double hyzhekou;
	/**是否删除*/
	private Double isdelete;

	public Huiyuan() {
		super();
	}
	public Huiyuan(Integer hyid,String hyname,Double hyzhekou,Double isdelete) {
		this.hyid = hyid;
		this.hyname = hyname;
		this.hyzhekou = hyzhekou;
		this.isdelete = isdelete;
	}
	/**设置"会员id"*/
	public void setHyid(Integer hyid){
		this.hyid = hyid;
	}
	/**获取"会员id"*/
	public Integer getHyid(){
		return hyid;
	}
	/**设置"会员名"*/
	public void setHyname(String hyname){
		this.hyname = hyname;
	}
	/**获取"会员名"*/
	public String getHyname(){
		return hyname;
	}
	/**设置"会员折扣"*/
	public void setHyzhekou(Double hyzhekou){
		this.hyzhekou = hyzhekou;
	}
	/**获取"会员折扣"*/
	public Double getHyzhekou(){
		return hyzhekou;
	}
	/**设置"是否删除"*/
	public void setIsdelete(Double isdelete){
		this.isdelete = isdelete;
	}
	/**获取"是否删除"*/
	public Double getIsdelete(){
		return isdelete;
	}
	@Override
	public String toString() {
		return "huiyuan[" + 
			"hyid = " + hyid + 
			", hyname = " + hyname + 
			", hyzhekou = " + hyzhekou + 
			", isdelete = " + isdelete +
			"]";
	}
}

