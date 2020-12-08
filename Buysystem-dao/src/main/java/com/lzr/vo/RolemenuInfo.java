package com.lzr.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 表名 :  rolemenu_info<br/>
 */ 
@JsonIgnoreProperties(value = "handler")
public class RolemenuInfo implements Serializable {

	/**角色菜单id*/
	private Integer mrid;
	/**角色对象*/
	private RoleInfo rid;
	/**菜单对象*/
	private MenuInfo mid;

	public RolemenuInfo() {
		super();
	}
	public RolemenuInfo(Integer mrid, RoleInfo rid, MenuInfo mid) {
		this.mrid = mrid;
		this.rid = rid;
		this.mid = mid;
	}
	/**设置"角色菜单id"*/
	public void setMrid(Integer mrid){
		this.mrid = mrid;
	}
	/**获取"角色菜单id"*/
	public Integer getMrid(){
		return mrid;
	}
	public void setRid(RoleInfo rid){
		this.rid = rid;
	}
	public RoleInfo getRid(){
		return rid;
	}
	public void setMid(MenuInfo mid){
		this.mid = mid;
	}
	public MenuInfo getMid(){
		return mid;
	}
	@Override
	public String toString() {
		return "rolemenu_info[" + 
			"mrid = " + mrid + 
			", rid = " + rid + 
			", mid = " + mid + 
			"]";
	}
}

