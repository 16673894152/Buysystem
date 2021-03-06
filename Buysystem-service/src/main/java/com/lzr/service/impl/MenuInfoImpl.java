package com.lzr.service.impl;

import com.lzr.dao.MenuInfoMapping;
import com.lzr.dao.RolemenuInfoMapping;
import com.lzr.service.MenuInfoService;
import com.lzr.vo.MenuInfo;
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

    /*根据节点和用户id查询菜单*/
    @Override
    public List<MenuInfo> queryallmenus(int nodetype, int empid) {
        //查询所有的父菜单  父节点为0  菜单类型为1
        List<MenuInfo> menus = menuInfoMapping.querymenuBypidandnodeType(0, 1, empid);
        System.out.println("父菜单"+menus);

        //将所有的父菜单的子菜单查询出来，绑定好
        for (MenuInfo menu : menus) {
            //查询所有的父菜单子菜单
            List<MenuInfo> childsmenu = menuInfoMapping.querymenuBypidandnodeType(menu.getId(), 2, empid);
            //打印子菜单数量
            System.out.println(childsmenu.size());
            //进行绑定
            menu.setChildMenu(childsmenu);

            //判断如果节点等于3
            if (nodetype == 3) {
                for (MenuInfo menu2 : childsmenu) {
                    //查出节点等于3的菜单
                    List<MenuInfo> childsmenu2 = menuInfoMapping.querymenuBypidandnodeType(menu2.getId(), 3, empid);
                    //进行绑定
                    menu2.setChildMenu(childsmenu2);
                }
            }

        }
        return menus;
    }

    //查询出该员工拥有的按钮
    @Override
    public List<String> queryallmenus3(int nodetype, int empid) {
        return menuInfoMapping.querymenuBypidandnodeType3(nodetype, empid);
    }
    //查出该角色拥有的菜单
    @Override
    public List<MenuInfo> queryallmenubyrid(int nodetype, int rid) {
        List<Integer> list = new ArrayList<Integer>();

        if (rid != 0) {
            //查看该角色拥有的菜单数量
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
    public MenuInfo queryById(int id) {
        return menuInfoMapping.queryById(id);
    }

    @Override
    public List<MenuInfo> querymenuall(int nodetype,String username) {
        //查询所有的父菜单  父节点为0  菜单类型为1
        List<MenuInfo> menus = menuInfoMapping.querymenuall(0, 1, username);
        //System.out.println("父菜单"+menus);

        //将所有的父菜单的子菜单查询出来，绑定好
        for (MenuInfo menu : menus) {

            //查询所有的父菜单子菜单
            List<MenuInfo> childsmenu = menuInfoMapping.querymenuall(menu.getId(), 2, username);

            //打印子菜单数量
            //  System.out.println(childsmenu.size());
            //进行绑定
            menu.setChildMenu(childsmenu);

            //判断如果节点等于3
            if (nodetype == 3) {
                for (MenuInfo menu2 : childsmenu) {
                    //查出节点等于3的菜单
                    List<MenuInfo> childsmenu2 = menuInfoMapping.querymenuall(menu2.getId(), 3, username);
                    //进行绑定
                    menu2.setChildMenu(childsmenu2);
                }
            }

        }
        return menus;
    }
/*根据角色名查询菜单*/
    @Override
    public List<MenuInfo> xianshishouquan(int rid,int nodetype) {
        //查询所有的父菜单  父节点为0  菜单类型为1
        List<MenuInfo> menus = menuInfoMapping.queryridjuese(rid,1,0);
        //System.out.println("父菜单"+menus);

        //将所有的父菜单的子菜单查询出来，绑定好
        for (MenuInfo menu : menus) {
            menu.setLabel(menu.getName());
            //查询所有的父菜单子菜单s
            List<MenuInfo> childsmenu = menuInfoMapping.queryridjuese(rid,2,menu.getId() );
            for (MenuInfo menuss : childsmenu) {
                //打印子菜单数量
                //  System.out.println(childsmenu.size());
                //进行绑定
                menuss.setLabel(menuss.getName());
            }
            menu.setChildren(childsmenu);
            //判断如果节点等于3
            if (nodetype == 3) {
                for (MenuInfo menu2 : childsmenu) {
                    menu2.setLabel(menu2.getName());
                    //查出节点等于3的菜单
                    List<MenuInfo> childsmenu2 = menuInfoMapping.queryridjuese(rid,3, menu2.getId());
                    //进行绑定
                    menu2.setChildMenu(childsmenu2);
                }
            }

        }
        return menus;
    }

    /*根据用户名查询菜单*/
    @Override
    public List<MenuInfo> querymenuallquanxian(int nodetype, String username) {
        //查询所有的父菜单  父节点为0  菜单类型为1
        List<MenuInfo> menus = menuInfoMapping.querymenuall(0, 1, username);
        //System.out.println("父菜单"+menus);

        //将所有的父菜单的子菜单查询出来，绑定好
        for (MenuInfo menu : menus) {
                menu.setLabel(menu.getName());
            //查询所有的父菜单子菜单s
            List<MenuInfo> childsmenu = menuInfoMapping.querymenuall(menu.getId(), 2, username);
            for (MenuInfo menuss : childsmenu) {
                //打印子菜单数量
                //  System.out.println(childsmenu.size());
                //进行绑定
                menuss.setLabel(menuss.getName());
            }
            menu.setChildren(childsmenu);
            //判断如果节点等于3
            if (nodetype == 3) {
                for (MenuInfo menu2 : childsmenu) {
                    menu2.setLabel(menu2.getName());
                    //查出节点等于3的菜单
                    List<MenuInfo> childsmenu2 = menuInfoMapping.querymenuall(menu2.getId(), 3, username);
                    //进行绑定
                    menu2.setChildMenu(childsmenu2);
                }
            }

        }
        return menus;
    }
    /*将角色id和菜单id加入角色菜单表*/
    @Override
    public int addmenujue(int rid, String mids) {
        String[] id = mids.split(",");
        int num = 0;
        //System.out.println("rid"+rid);
        menuInfoMapping.deletemenujue(rid);
        //System.out.println("1111");
        for (int i = 0; i < id.length; i++) {
            //System.out.println("menuid"+Integer.parseInt(id[i]));
            num = menuInfoMapping.addmenujue(rid, Integer.parseInt(id[i]));
        }
        return num;
    }



}
