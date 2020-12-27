package com.lzr.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuInfo {
	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 菜单编码
	 */
	private String menuCode;

	/**
	 * 父节点
	 */
	private Integer parentId;

	/**
	 * 节点类型，1文件夹，2页面，3按钮
	 */
	private Integer nodeType;

	/**
	 * 图标地址
	 */
	private String iconurl;

	/**
	 * 排序号
	 */
	private Integer sort;

	/**
	 * 页面对应的地址
	 */
	private String linkurl;

	/**
	 * 层次
	 */
	private Integer level;

	/**
	 * 树id的路径 整个层次上的路径id，逗号分隔，想要找父节点特别快
	 */
	private String path;

	/**
	 * 子菜单集合
	 */
	private  String lable;
	List<MenuInfo> childMenu;
	private boolean checked;
	public int isdelete;
	public boolean disabled;
	List<MenuInfo> children;
	private String label;
	public boolean isChecked() {
		return checked;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	public MenuInfo(Integer id, String name, String menuCode, Integer parentId, Integer nodeType, String iconurl, Integer sort, String linkurl, Integer level, String path, String lable, List<MenuInfo> childMenu, boolean checked, int isdelete, boolean disabled, List<MenuInfo> children, String label) {
		this.id = id;
		this.name = name;
		this.menuCode = menuCode;
		this.parentId = parentId;
		this.nodeType = nodeType;
		this.iconurl = iconurl;
		this.sort = sort;
		this.linkurl = linkurl;
		this.level = level;
		this.path = path;
		this.lable = lable;
		this.childMenu = childMenu;
		this.checked = checked;
		this.isdelete = isdelete;
		this.disabled = disabled;
		this.children = children;
		this.label = label;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public List<MenuInfo> getChildren() {
		return children;
	}

	public void setChildren(List<MenuInfo> children) {
		this.children = children;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public MenuInfo() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getNodeType() {
		return nodeType;
	}

	public void setNodeType(Integer nodeType) {
		this.nodeType = nodeType;
	}

	public String getIconurl() {
		return iconurl;
	}

	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getLinkurl() {
		return linkurl;
	}

	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<MenuInfo> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<MenuInfo> childMenu) {
		this.childMenu = childMenu;
	}

	@Override
	public String toString() {
		return "MenuInfo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", menuCode='" + menuCode + '\'' +
				", parentId=" + parentId +
				", nodeType=" + nodeType +
				", iconurl='" + iconurl + '\'' +
				", sort=" + sort +
				", linkurl='" + linkurl + '\'' +
				", level=" + level +
				", path='" + path + '\'' +
				", childMenu=" + childMenu +
				", checked=" + checked +
				", isdelete=" + isdelete +
				", disabled=" + disabled +
				", children=" + children +
				", label='" + label + '\'' +
				'}';
	}
}
