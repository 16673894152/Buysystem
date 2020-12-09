package com.lzr.control;


import com.lzr.service.UserService;
import com.lzr.vo.PageVo;
import com.lzr.vo.User;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/edituser.action")
    @ResponseBody
    public Map updateUser(User user) {
        System.out.println(user+"添加或编辑的用户");
        Map<String, String> map = new HashMap<String, String>();
        if(user.getUserid()==null){//添加
            //加密
            Md5Hash md5Hash= new Md5Hash(user.getUserpass(),user.getUsername(),5);
            System.out.println("加密后的密码："+md5Hash.toString());
            user.setUserpass(md5Hash.toString());
            int num = userService.insert(user);
            if (num > 0) {
                map.put("msg", "添加成功");
            } else {
                map.put("msg", "添加失败");
            }
        }else if(user.getUserid()!=null) {//修改
            int num = userService.updateById(user);
            if (num > 0) {
                map.put("msg", "修改成功");
            } else {
                map.put("msg", "修改失败");
            }
        }
        return map;
    }

    @RequestMapping("/deluser.action")
    @ResponseBody
    public Map deluser(User user) {
        User user1=new User();
        user1.setUserid(1);
        user1.setIsdelete(0);
        Map<String, String> map = new HashMap<String, String>();
            int num = userService.updateById(user1);
            if (num > 0) {
                map.put("msg", "删除成功");
            } else {
                map.put("msg", "删除失败");
            }
        return map;
    }
    @RequestMapping("/querylike.action")
    @ResponseBody
    public PageVo<User> querylike(User user,
                                  @RequestParam(value = "page", defaultValue = "1") int page,
                                  @RequestParam(value = "rows", defaultValue = "5") int rows) {
        User user1=new User();
        return userService.queryLike(user1, page, rows);
    }
}
