package com.lzr.control;

import com.lzr.service.EmployService;
import com.lzr.service.RoleService;
import com.lzr.vo.Employ;
import com.lzr.vo.PageVo;
import com.lzr.vo.RoleInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("/editrole.action")
    @ResponseBody
    @CrossOrigin
    public Map updaterole(RoleInfo roleInfo) {
        System.out.println(roleInfo+"添加或编辑的角色");
        Map<String, String> map = new HashMap<String, String>();
        if(roleInfo.getRid()==null){//添加
            roleInfo.setRstate(1);
            int num = roleService.insert(roleInfo);
            if (num > 0) {
                map.put("msg", "添加成功");
            } else {
                map.put("msg", "添加失败");
            }
        }else if(roleInfo.getRid()!=null) {//修改
            int num = roleService.updateById(roleInfo);
            if (num > 0) {
                map.put("msg", "修改成功");
            } else {
                map.put("msg", "修改失败");
            }
        }
        return map;
    }

    @RequestMapping("/delrole.action")
    @ResponseBody
    @CrossOrigin
    public Map delrole(RoleInfo roleInfo) {
        roleInfo.setRstate(0);
        System.out.println(roleInfo+"删除角色");
        Map<String, String> map = new HashMap<String, String>();
            int num = roleService.updateById(roleInfo);
        System.out.println(num+"删除行影响");
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
    public PageVo<RoleInfo> querylike(RoleInfo roleInfo,
                                   @RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "rows", defaultValue = "5") int rows) {
        return roleService.queryLike(roleInfo, page, rows);
    }
}
