package com.lzr.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  menu_info<br/>
 */ 
@JsonIgnoreProperties(value = "handler")
public class MenuInfo implements Serializable {

	/**主键id*/
	private Integer id;
	/**菜单名称*/
	private String name;
	/**菜单编码*/
	private String menucode;
	/**父id*/
	private Integer parentid;
	/**节点类型 1：文件夹  2：页面  3：按钮*/
	private Integer nodetype;
	/**图标地址*/
	private String iconurl;
	/**排序号*/
	private Integer sort;
	/**页面对应的地址*/
	private String linkurl;
	/**层次*/
	private Integer level;
	/**树id的路径,整个层次上的路径id，逗号分隔，快速找到父节点*/
	private String path;
	/**是否删除   0：未删除  1：已删除*/
	private Integer isdelete;

	public MenuInfo() {
		super();
	}
	public MenuInfo(Integer id,String name,String menucode,Integer parentid,Integer nodetype,String iconurl,Integer sort,String linkurl,Integer level,String path,Integer isdelete) {
		this.id = id;
		this.name = name;
		this.menucode = menucode;
		this.parentid = parentid;
		this.nodetype = nodetype;
		this.iconurl = iconurl;
		this.sort = sort;
		this.linkurl = linkurl;
		this.level = level;
		this.path = path;
		this.isdelete = isdelete;
	}
	/**设置"主键id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"主键id"*/
	public Integer getId(){
		return id;
	}
	/**设置"菜单名称"*/
	public void setName(String name){
		this.name = name;
	}
	/**获取"菜单名称"*/
	public String getName(){
		return name;
	}
	/**设置"菜单编码"*/
	public void setMenucode(String menucode){
		this.menucode = menucode;
	}
	/**获取"菜单编码"*/
	public String getMenucode(){
		return menucode;
	}
	/**设置"父id"*/
	public void setParentid(Integer parentid){
		this.parentid = parentid;
	}
	/**获取"父id"*/
	public Integer getParentid(){
		return parentid;
	}
	/**设置"节点类型 1：文件夹  2：页面  3：按钮"*/
	public void setNodetype(Integer nodetype){
		this.nodetype = nodetype;
	}
	/**获取"节点类型 1：文件夹  2：页面  3：按钮"*/
	public Integer getNodetype(){
		return nodetype;
	}
	/**设置"图标地址"*/
	public void setIconurl(String iconurl){
		this.iconurl = iconurl;
	}
	/**获取"图标地址"*/
	public String getIconurl(){
		return iconurl;
	}
	/**设置"排序号"*/
	public void setSort(Integer sort){
		this.sort = sort;
	}
	/**获取"排序号"*/
	public Integer getSort(){
		return sort;
	}
	/**设置"页面对应的地址"*/
	public void setLinkurl(String linkurl){
		this.linkurl = linkurl;
	}
	/**获取"页面对应的地址"*/
	public String getLinkurl(){
		return linkurl;
	}
	/**设置"层次"*/
	public void setLevel(Integer level){
		this.level = level;
	}
	/**获取"层次"*/
	public Integer getLevel(){
		return level;
	}
	/**设置"树id的路径,整个层次上的路径id，逗号分隔，快速找到父节点"*/
	public void setPath(String path){
		this.path = path;
	}
	/**获取"树id的路径,整个层次上的路径id，逗号分隔，快速找到父节点"*/
	public String getPath(){
		return path;
	}
	/**设置"是否删除   0：未删除  1：已删除"*/
	public void setIsdelete(Integer isdelete){
		this.isdelete = isdelete;
	}
	/**获取"是否删除   0：未删除  1：已删除"*/
	public Integer getIsdelete(){
		return isdelete;
	}
	@Override
	public String toString() {
		return "menu_info[" + 
			"id = " + id + 
			", name = " + name + 
			", menucode = " + menucode + 
			", parentid = " + parentid + 
			", nodetype = " + nodetype + 
			", iconurl = " + iconurl + 
			", sort = " + sort + 
			", linkurl = " + linkurl + 
			", level = " + level + 
			", path = " + path + 
			", isdelete = " + isdelete + 
			"]";
	}
}

