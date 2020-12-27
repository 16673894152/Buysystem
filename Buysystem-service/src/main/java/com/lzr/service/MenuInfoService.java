package com.lzr.service;

import com.lzr.vo.MenuInfo;
import com.lzr.vo.PageVo;
import org.springframework.stereotype.Repository;

import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface MenuInfoService {
    public List<MenuInfo> queryallmenus(int nodetype, int empid);

    public List<String> queryallmenus3(int nodetype, int empid);

    public List<MenuInfo> queryallmenubyrid(int nodetype, int rid);

    //授权
    public int shouquan(int rid, String[] mids);

    MenuInfo queryById(int id);

    public List<MenuInfo> xianshishouquan(int rid,int nodetype);
    /*根据用户名查询拥有的菜单*/
    public List<MenuInfo> querymenuall(int nodetype, String username);
    /*根据用户名查询拥有的菜单,获取权限*/
    public List<MenuInfo> querymenuallquanxian(int nodetype, String username);
    /*将角色id和菜单id加入角色菜单表*/
    public int addmenujue(int rid, String mids);
}