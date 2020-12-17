package com.lzr.control;

import com.lzr.service.MenuInfoService;
import com.lzr.vo.Employ;
import com.lzr.vo.MenuInfo;
import com.lzr.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;

    //查询出所有的菜单信息(菜单显示用，有层级关系)  菜单首页
    @RequestMapping("/queryallmenus.action")
    @ResponseBody
    @CrossOrigin
    public List<MenuInfo> queryallmenus(HttpServletRequest request){
        /*查出该用户拥有的菜单按钮*/
        List<String> list=menuInfoService.queryallmenus3(3,1);
        System.out.println(list);
        request.getSession().setAttribute("menulist",list);

        //返回所有的菜单
        return  menuInfoService.queryallmenus(2,1);
    }


    //查出角色拥有的菜单
    @RequestMapping("/queryallmenus2.action")
    @ResponseBody
    @CrossOrigin
    public List<MenuInfo> queryallmenus2(Integer rid){
       // System.out.println(rid+"rid:");
        System.out.println(menuInfoService.queryallmenubyrid(3,1));
        return  menuInfoService.queryallmenubyrid(3,1);
    }


    //进行授权
    @RequestMapping(value = "/auth.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String authSave(HttpServletRequest request,
            @RequestParam(value = "menuids",defaultValue = "")String mids,
            @RequestParam(value = "roleid",defaultValue = "0")  int roleid,int empid){
        String[] str1=mids.split(",");

        List<String> list=menuInfoService.queryallmenus3(3,empid);
        request.getSession().removeAttribute("menulist");
        request.getSession().setAttribute("menulist",list);
        System.out.println("empid"+empid);
        int num=menuInfoService.shouquan(roleid,str1);
        if(num>0){
            return "授权成功";
        }else {
            return "授权失败";
        }
    }

    @RequestMapping("/querymenuid.action")
    @ResponseBody
    @CrossOrigin
    public MenuInfo queryMenu(MenuInfo menuInfo) {
        MenuInfo list=menuInfoService.queryById(menuInfo.getId());
        return list;
    }

    //查出角色拥有的菜单
    @RequestMapping("/queryallmenus3.action")
    @ResponseBody
    @CrossOrigin
    public List<MenuInfo> queryallmenus3(int rid){
        System.out.println(rid);
        return  menuInfoService.xianshishouquan(rid);
    }


    //查询出所有的菜单信息(菜单显示用，有层级关系)  菜单首页
    @RequestMapping("/queryall.action")
    @ResponseBody
    @CrossOrigin
    public List<MenuInfo> queryalls(Employ employ){
        /*查出该用户拥有的菜单按钮*/
        //System.out.println("username"+employ.getUsername());
        //List<String> list=menuInfoService.querymenuall(3,employ.getUsername());
        //System.out.println(list);
        //request.getSession().setAttribute("menulist",list);

        //返回所有的菜单
        return  menuInfoService.querymenuall(2,employ.getUsername());
    }
}
