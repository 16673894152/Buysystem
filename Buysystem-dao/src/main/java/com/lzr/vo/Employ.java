package com.lzr.vo;

 import java.sql.Date;
 import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

 import java.util.Arrays;
 import java.util.List;

/**
 * 表名 :  employ<br/>
 */ 
@JsonIgnoreProperties(value = "handler")
public class Employ implements Serializable {

	/**员工id*/
	private Integer empid;
	/**员工名称*/
	private String empname;
	/**员工性别*/
	private Integer empsex;
	/**员工手机号*/
	private String empnumber;
	/**员工住址*/
	private String empaddress;
	/**员工身份证*/
	private String empcard;
	/**员工创建时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date empstarttime;
	/**员工状态*/
	private Integer empstate;
	/**员工备注*/
	private String empremark;
	/**用户名*/
	private String username;
	/**密码*/
	private String password;
	/**员工人脸*/
	private Byte[] img;
	/*角色对象*/
	private List<RoleInfo> rolelist;
 	public Employ() {
		super();
	}

	public Employ(Integer empid, String empname, Integer empsex, String empnumber, String empaddress, String empcard, Date empstarttime, Integer empstate, String empremark, String username, String password, Byte[] img, List<RoleInfo> rolelist) {
		this.empid = empid;
		this.empname = empname;
		this.empsex = empsex;
		this.empnumber = empnumber;
		this.empaddress = empaddress;
		this.empcard = empcard;
		this.empstarttime = empstarttime;
		this.empstate = empstate;
		this.empremark = empremark;
		this.username = username;
		this.password = password;
		this.img = img;
		this.rolelist = rolelist;
	}

	/**设置"员工id"*/
	public void setEmpid(Integer empid){
		this.empid = empid;
	}
	/**获取"员工id"*/
	public Integer getEmpid(){
		return empid;
	}
	/**设置"员工名称"*/
	public void setEmpname(String empname){
		this.empname = empname;
	}
	/**获取"员工名称"*/
	public String getEmpname(){
		return empname;
	}
	/**设置"员工性别"*/
	public void setEmpsex(Integer empsex){
		this.empsex = empsex;
	}
	/**获取"员工性别"*/
	public Integer getEmpsex(){
		return empsex;
	}
	/**设置"员工手机号"*/
	public void setEmpnumber(String empnumber){
		this.empnumber = empnumber;
	}
	/**获取"员工手机号"*/
	public String getEmpnumber(){
		return empnumber;
	}
	/**设置"员工住址"*/
	public void setEmpaddress(String empaddress){
		this.empaddress = empaddress;
	}
	/**获取"员工住址"*/
	public String getEmpaddress(){
		return empaddress;
	}
	/**设置"员工身份证"*/
	public void setEmpcard(String empcard){
		this.empcard = empcard;
	}
	/**获取"员工身份证"*/
	public String getEmpcard(){
		return empcard;
	}
	/**设置"员工创建时间"*/
	public void setEmpstarttime(Date empstarttime){
		this.empstarttime = empstarttime;
	}
	/**获取"员工创建时间"*/
	public Date getEmpstarttime(){
		return empstarttime;
	}
	/**设置"员工状态"*/
	public void setEmpstate(Integer empstate){
		this.empstate = empstate;
	}
	/**获取"员工状态"*/
	public Integer getEmpstate(){
		return empstate;
	}
	/**设置"员工备注"*/
	public void setEmpremark(String empremark){
		this.empremark = empremark;
	}
	/**获取"员工备注"*/
	public String getEmpremark(){
		return empremark;
	}
	/**设置"用户名"*/
	public void setUsername(String username){
		this.username = username;
	}
	/**获取"用户名"*/
	public String getUsername(){
		return username;
	}
	/**设置"密码"*/
	public void setPassword(String password){
		this.password = password;
	}
	/**获取"密码"*/
	public String getPassword(){
		return password;
	}
	/**设置"员工人脸"*/
	public void setImg(Byte[] img){
		this.img = img;
	}
	/**获取"员工人脸"*/
	public Byte[] getImg(){
		return img;
	}

	public List<RoleInfo> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<RoleInfo> rolelist) {
		this.rolelist = rolelist;
	}

	@Override
	public String toString() {
		return "Employ{" +
				"empid=" + empid +
				", empname='" + empname + '\'' +
				", empsex=" + empsex +
				", empnumber='" + empnumber + '\'' +
				", empaddress='" + empaddress + '\'' +
				", empcard='" + empcard + '\'' +
				", empstarttime=" + empstarttime +
				", empstate=" + empstate +
				", empremark='" + empremark + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", img=" + Arrays.toString(img) +
				", rolelist=" + rolelist +
				'}';
	}
}

