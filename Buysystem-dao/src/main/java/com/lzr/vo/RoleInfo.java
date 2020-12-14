package com.lzr.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

import java.util.List;

/**
 * 表名 :  role_info<br/>
 */ 
@JsonIgnoreProperties(value = "handler")
public class RoleInfo implements Serializable {

	/**角色id*/
	private Integer rid;
	/**角色名称*/
	private String rname;
	/**角色备注*/
	private String rremart;
	/**角色状态*/
	private Integer rstate;
	private int count;
	private List<Employ> employList;
	public RoleInfo() {
		super();
	}

	public RoleInfo(Integer rid, String rname, String rremart, Integer rstate, int count, List<Employ> employList) {
		this.rid = rid;
		this.rname = rname;
		this.rremart = rremart;
		this.rstate = rstate;
		this.count = count;
		this.employList = employList;
	}

	/**设置"角色id"*/
	public void setRid(Integer rid){
		this.rid = rid;
	}
	/**获取"角色id"*/
	public Integer getRid(){
		return rid;
	}
	/**设置"角色名称"*/
	public void setRname(String rname){
		this.rname = rname;
	}
	/**获取"角色名称"*/
	public String getRname(){
		return rname;
	}
	/**设置"角色备注"*/
	public void setRremart(String rremart){
		this.rremart = rremart;
	}
	/**获取"角色备注"*/
	public String getRremart(){
		return rremart;
	}
	/**设置"角色状态"*/
	public void setRstate(Integer rstate){
		this.rstate = rstate;
	}
	/**获取"角色状态"*/
	public Integer getRstate(){
		return rstate;
	}

	public List<Employ> getEmployList() {
		return employList;
	}

	public void setEmployList(List<Employ> employList) {
		this.employList = employList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "RoleInfo{" +
				"rid=" + rid +
				", rname='" + rname + '\'' +
				", rremart='" + rremart + '\'' +
				", rstate=" + rstate +
				", count=" + count +
				", employList=" + employList +
				'}';
	}
}

