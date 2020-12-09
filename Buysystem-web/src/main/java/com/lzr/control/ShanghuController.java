package com.lzr.control;

import com.lzr.service.EmployService;
import com.lzr.service.ShanghuService;
import com.lzr.vo.Employ;
import com.lzr.vo.PageVo;
import com.lzr.vo.Shanghu;
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
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/shanghu")
public class ShanghuController {

    @Autowired
    ShanghuService shanghuService;

    @RequestMapping("/editshanghu.action")
    @ResponseBody
    public Map updateEmploy(Shanghu shanghu) {
        System.out.println(shanghu+"添加或编辑的员工"+shanghu);
        Map<String, String> map = new HashMap<String, String>();
        if(shanghu.getShid()==null){//添加
            //加密
            Md5Hash md5Hash= new Md5Hash(shanghu.getShpass(),shanghu.getShnumber(),5);
            System.out.println("加密后的密码："+md5Hash.toString());
            shanghu.setShpass(md5Hash.toString());
            int num = shanghuService.insert(shanghu);
            if (num > 0) {
                map.put("msg", "添加成功");
            } else {
                map.put("msg", "添加失败");
            }
        }else if(shanghu.getShid()!=null) {//修改
            int num = shanghuService.updateById(shanghu);
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
    public Map delemploy(Shanghu shanghu) {
        Shanghu shanghu1=new Shanghu();
        shanghu1.setShid(1);
        shanghu1.setShstate(0);
        Map<String, String> map = new HashMap<String, String>();
            int num = shanghuService.updateById(shanghu1);
            if (num > 0) {
                map.put("msg", "删除成功");
            } else {
                map.put("msg", "删除失败");
            }
        return map;
    }

    @RequestMapping("/querylike.action")
    @ResponseBody
    public PageVo<Shanghu> querylike(Shanghu shanghu,
                                   @RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "rows", defaultValue = "5") int rows) {
        Shanghu shanghu1=new Shanghu();
        return shanghuService.queryLike(shanghu1, page, rows);
    }
}
