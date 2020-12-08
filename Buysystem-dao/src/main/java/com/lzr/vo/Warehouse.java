package com.lzr.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

import java.util.List;

/**
 * 表名 :  warehouse<br/>
 */ 
@JsonIgnoreProperties(value = "handler")
public class Warehouse implements Serializable {

	/**仓库id*/
	private Integer wareid;
	/**仓库名称*/
	private String warename;
	/**仓库备注*/
	private String wareremark;
	/**仓库最大容量*/
	private String warecount;
	/**仓库负责人--员工对象*/
	private Employ empid;
	/**仓库地址*/
	private String wareaddress;
	/**精度*/
	private Integer jingdu;
	/**纬度*/
	private Integer weidu;
	/**是否删除*/
	private Integer isdelete;

	public Warehouse() {
		super();
	}
	public Warehouse(Integer wareid,String warename,String wareremark,String warecount,Employ empid,String wareaddress,Integer jingdu,Integer weidu,Integer isdelete) {
		this.wareid = wareid;
		this.warename = warename;
		this.wareremark = wareremark;
		this.warecount = warecount;
		this.empid = empid;
		this.wareaddress = wareaddress;
		this.jingdu = jingdu;
		this.weidu = weidu;
		this.isdelete = isdelete;
	}
	/**设置"仓库id"*/
	public void setWareid(Integer wareid){
		this.wareid = wareid;
	}
	/**获取"仓库id"*/
	public Integer getWareid(){
		return wareid;
	}
	/**设置"仓库名称"*/
	public void setWarename(String warename){
		this.warename = warename;
	}
	/**获取"仓库名称"*/
	public String getWarename(){
		return warename;
	}
	/**设置"仓库备注"*/
	public void setWareremark(String wareremark){
		this.wareremark = wareremark;
	}
	/**获取"仓库备注"*/
	public String getWareremark(){
		return wareremark;
	}
	/**设置"仓库最大容量"*/
	public void setWarecount(String warecount){
		this.warecount = warecount;
	}
	/**获取"仓库最大容量"*/
	public String getWarecount(){
		return warecount;
	}
	public void setEmpid(Employ empid){
		this.empid = empid;
	}
	public Employ getEmpid(){
		return empid;
	}
	/**设置"仓库地址"*/
	public void setWareaddress(String wareaddress){
		this.wareaddress = wareaddress;
	}
	/**获取"仓库地址"*/
	public String getWareaddress(){
		return wareaddress;
	}
	/**设置"精度"*/
	public void setJingdu(Integer jingdu){
		this.jingdu = jingdu;
	}
	/**获取"精度"*/
	public Integer getJingdu(){
		return jingdu;
	}
	/**设置"纬度"*/
	public void setWeidu(Integer weidu){
		this.weidu = weidu;
	}
	/**获取"纬度"*/
	public Integer getWeidu(){
		return weidu;
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
		return "warehouse[" + 
			"wareid = " + wareid + 
			", warename = " + warename + 
			", wareremark = " + wareremark + 
			", warecount = " + warecount + 
			", empid = " + empid + 
			", wareaddress = " + wareaddress + 
			", jingdu = " + jingdu + 
			", weidu = " + weidu + 
			", isdelete = " + isdelete +
			"]";
	}
}

