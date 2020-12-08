package com.lzr.control;

import com.lzr.service.EmployService;
import com.lzr.vo.Employ;
import com.lzr.vo.PageVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    @ResponseBody
    public Map login(HttpServletRequest request, Employ employ, @RequestParam(value = "rememberme",defaultValue = "false")boolean rememberme) {
        //组装token
        UsernamePasswordToken token = new
                UsernamePasswordToken(employ.getUsername(), employ.getPassword());
        System.out.println(rememberme+"记住");
        token.setRememberMe(rememberme);
        Subject subject = SecurityUtils.getSubject();
        Map<String, String> map = new HashMap<String, String>();
        try {
            //认证
            subject.login(token);
           //如果验证成功跳转页面传参
            map.put("msg", "" + employ.getUsername() + "");
            map.put("code", "1");
            return map;
        } catch (IncorrectCredentialsException e) {
            System.out.println("当前认证失败：密码不正确！");
            map.put("msg", "密码错误,请重新输入");
            map.put("code", "0");
            return map;
        }catch (UnknownAccountException e){
            System.out.println("当前认证失败：帐号不存在！");
            map.put("msg", "账号不存在,请重新输入");
            map.put("code", "0");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("当前认证失败：未知异常！");
            map.put("msg", "未知异常");
            map.put("code", "0");
            return map;
        }
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
