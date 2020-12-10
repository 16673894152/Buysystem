package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.MenuInfoMapping;
import com.lzr.dao.RolemenuInfoMapping;
import com.lzr.service.MenuInfoService;
import com.lzr.vo.MenuInfo;
import com.lzr.vo.PageVo;
import com.lzr.vo.RoleInfo;
import com.lzr.vo.RolemenuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuInfoImpl implements MenuInfoService {
    @Autowired
    MenuInfoMapping menuInfoMapping;
    @Autowired
    RolemenuInfoMapping rolemenuInfoMapping;
    @Override
    public List<MenuInfo> queryallmenus(int nodetype, int empid) {
        //查询所有的父菜单  父节点为0  菜单类型为1
        List<MenuInfo> menus = menuInfoMapping.querymenuBypidandnodeType(0, 1, empid);

        //将所有的父菜单的子菜单查询出来，绑定好
        for (MenuInfo menu : menus) {
            List<MenuInfo> childsmenu = menuInfoMapping.querymenuBypidandnodeType(menu.getId(), 2, empid);
            menu.setChildMenu(childsmenu);

            if (nodetype == 3) {
                for (MenuInfo menu2 : childsmenu) {
                    List<MenuInfo> childsmenu2 = menuInfoMapping.querymenuBypidandnodeType(menu2.getId(), 3, empid);
                    menu2.setChildMenu(childsmenu2);
                }
            }
        }

        return menus;
    }

    @Override
    public List<String> queryallmenus3(int nodetype, int empid) {
        return menuInfoMapping.querymenuBypidandnodeType3(nodetype, empid);
    }

    @Override
    public List<MenuInfo> queryallmenubyrid(int nodetype, int rid) {
        List<Integer> list = new ArrayList<Integer>();
        //2020-10-12修改
        if (rid != 0) {
            list = menuInfoMapping.querymenuidbyrid(rid);
        }
        //查询所有的父菜单  父节点为0  菜单类型为1
        List<MenuInfo> menus = menuInfoMapping.querymenuBypidandnodeType1(0, 1);
        //将所有的父菜单的子菜单查询出来，绑定好
        for (MenuInfo menu : menus) {
            List<MenuInfo> childsmenu = menuInfoMapping.querymenuBypidandnodeType1(menu.getId(), 2);
            menu.setChildMenu(childsmenu);
            //一级节点 选择状态设置 2020-10-12修改
            if (list.contains(menu.getId())) {
                menu.setChecked(true);
            }
            for (MenuInfo menu2 : childsmenu) {
                List<MenuInfo> childsmenu2 = menuInfoMapping.querymenuBypidandnodeType1(menu2.getId(), 3);

                //二级节点 选择状态设置 2020-10-12修改
                if (list.contains(menu2.getId())) {
                    menu2.setChecked(true);
                }

                if (nodetype == 3) {
                    menu2.setChildMenu(childsmenu2);

                    for (MenuInfo menu3 : childsmenu2) {
                        //三级节点 选择状态设置 2020-10-12修改
                        if (list.contains(menu3.getId())) {
                            menu3.setChecked(true);
                        }
                    }
                }
            }
        }


        return menus;
    }

    @Override
    public int shouquan(int rid, String[] mids) {
        RolemenuInfo rolemenuInfo=new RolemenuInfo();
        RoleInfo roleInfo=new RoleInfo();
        roleInfo.setRid(rid);
        rolemenuInfo.setRid(roleInfo);
        int num=rolemenuInfoMapping.deleteBy(rolemenuInfo);
        int nums=0;
        for(int i=0;i<mids.length;i++){
            nums+=rolemenuInfoMapping.insert(rid,Integer.parseInt(mids[i]));
        }
        return nums;
    }

    @Override
    public PageVo<MenuInfo> queryLikeLimit(int page, int rows, MenuInfo menuInfo) {
        PageVo<MenuInfo> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(menuInfoMapping.queryLike(menuInfo));
        //获取总的记录数量
        pageVo.setTotal(menuInfoMapping.queryLike(menuInfo).size());
        return pageVo;
    }

    @Override
    public MenuInfo queryById(int id) {
        return menuInfoMapping.queryById(id);
    }

}
