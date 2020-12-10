package com.lzr.control;

import com.lzr.service.EmployService;
import com.lzr.vo.Employ;
import com.lzr.vo.PageVo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employ")
public class EmployController {

    @Autowired
    EmployService employService;

    @RequestMapping("/login.action")
    @CrossOrigin
    @ResponseBody
    public Map login( Employ employ) {
        Map<String, String> map = new HashMap<String, String>();
        System.out.println(employ);
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
            map.put("msg", "登录成功,欢迎你,"+employ.getUsername()+"");
            map.put("code", "1");
        }
            return map;
    }

    @RequestMapping("/editemploy.action")
    @ResponseBody
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
    public Map delemploy(Employ employ) {
        Employ employ1=new Employ();
        employ1.setEmpid(1);
        employ1.setEmpstate(0);
        Map<String, String> map = new HashMap<String, String>();
            int num = employService.updateById(employ1);
            if (num > 0) {
                map.put("msg", "删除成功");
            } else {
                map.put("msg", "删除失败");
            }
        return map;
    }
    @RequestMapping("/querylike.action")
    @ResponseBody
    public PageVo<Employ> querylike(Employ employ,
                                   @RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "rows", defaultValue = "5") int rows) {
        Employ employ1=new Employ();
        return employService.queryLike(employ1, page, rows);
    }
}
