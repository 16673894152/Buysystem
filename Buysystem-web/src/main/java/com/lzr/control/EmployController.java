package com.lzr.control;

import com.lzr.service.EmployService;
import com.lzr.service.EmployroleService;
import com.lzr.vo.*;

import org.apache.shiro.crypto.hash.Md5Hash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employ")
public class EmployController {

    @Autowired
    EmployService employService;
    @Autowired
    EmployroleService employroleService;
    @RequestMapping("/login.action")
    @CrossOrigin
    @ResponseBody
    public Map login( Employ employ) {
        Map<String, String> map = new HashMap<String, String>();
        Md5Hash md5Hash= new Md5Hash(employ.getPassword(),employ.getUsername(),5);
        employ.setPassword(md5Hash.toString());
        Employ employ1=new Employ();
        employ1.setUsername(employ.getUsername());
        //判断账号是否存在
        List<Employ> employList=employService.query(employ1);
        //判断账号密码是否正确
        List<Employ> employList1=employService.query(employ);
        if(employList.size()==0){
            map.put("msg", "账号不存在,请重新输入");
            map.put("code", "0");
        }else if(employList1.size()==0){
            map.put("msg", "密码错误,请重新输入");
            map.put("code", "0");
        }else {
            map.put("employ",employList1.get(0).getUsername());
            System.out.println("用户名"+employList1.get(0).getUsername());
            map.put("msg", "登录成功,欢迎你:");
            //System.out.println(employ1.getUsername());
            map.put("code", "1");
        }
            return map;
    }

    @RequestMapping("/editemploy.action")
    @ResponseBody
    @CrossOrigin
    public Map updateEmploy(Employ employ) {
        System.out.println(employ+"添加或编辑的员工"+employ);
        Map<String, String> map = new HashMap<String, String>();
        if(employ.getEmpid()==null){//添加
            //加密
            Md5Hash md5Hash= new Md5Hash(employ.getPassword(),employ.getUsername(),5);
            System.out.println("加密后的密码："+md5Hash.toString());
            employ.setPassword(md5Hash.toString());
            int num = employService.insert(employ);
            if (num > 0) {
                map.put("msg", "添加成功");
            } else {
                map.put("msg", "添加失败");
            }
        }else if(employ.getEmpid()!=null) {//修改
            Md5Hash md5Hash= new Md5Hash(employ.getPassword(),employ.getUsername(),5);
            employ.setPassword(md5Hash.toString());
            int num = employService.updateById(employ);
            if (num > 0) {
                map.put("msg", "修改成功");
            } else {
                map.put("msg", "修改失败");
            }
        }
        return map;
    }

    @RequestMapping("/delemploy.action")
    @ResponseBody
    @CrossOrigin
    public Map delemploy(int empid) {
        Employ employ=new Employ();
        employ.setEmpid(empid);
        employ.setEmpstate(0);
        Map<String, String> map = new HashMap<String, String>();
            int num = employService.updateById(employ);
            if (num > 0) {
                map.put("msg", "删除成功");
            } else {
                map.put("msg", "删除失败");
            }
        return map;
    }
    @RequestMapping("/querylike.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Employ> querylike(Employ employ,
                                   @RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "rows", defaultValue = "5") int rows) {
        return employService.queryLike(employ, page, rows);
    }
    @RequestMapping("/queryall.action")
    @ResponseBody
    @CrossOrigin
    public List<Employ> queryall() {
        return employService.queryAll();
    }

    @RequestMapping("/employshouquan.action")
    @ResponseBody
    @CrossOrigin
    public Map employshouquan(int empid,String rids) {
        Employ employ=new Employ();
        String[] ridss = rids.split(",");
        List<Integer> ridsss = new ArrayList<>();
        int num = 0;
        for (int i = 0; i <= ridss.length - 1; i++) {
            ridsss.add(Integer.parseInt(ridss[i]));
        }
        /*删除原来的角色*/
         num=employroleService.deleteByempid(empid);
        /*添加新的角色*/
        EmployroleInfo employroleInfo=new EmployroleInfo();
        Employ employ1=new Employ();employ1.setEmpid(empid);
        for (int i=0;i<ridsss.size();i++){
            System.out.println(ridsss.get(i));
            employroleInfo.setEmpid(employ1);
            RoleInfo roleInfo=new RoleInfo();
            roleInfo.setRid(ridsss.get(i));
            employroleInfo.setRid(roleInfo);
            System.out.println(employroleInfo+"员工角色");
            int numss=employroleService.insert(employroleInfo);
        }
        Map<String, String> map = new HashMap<String, String>();
        if (num > 0) {
            map.put("msg", "授权成功");
        } else {
            map.put("msg", "授权失败");
        }
        return map;
    }

    /*模糊查询查看用户列表信息*/
    @RequestMapping("/query.action")
    @ResponseBody
    @CrossOrigin
    public List<Employ> querall(Employ employ){
        System.out.println(employ);
        return employService.query(employ);
    }
}