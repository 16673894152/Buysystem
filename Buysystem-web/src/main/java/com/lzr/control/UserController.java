package com.lzr.control;



import com.lzr.service.UserService;
import com.lzr.vo.PageVo;
import com.lzr.vo.User;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;
    /*用户登录*/
    @RequestMapping("/login.action")
    @ResponseBody
    public Map login(User user) {
        System.out.println(user+"user");
        Map<String, String> map = new HashMap<String, String>();
        Md5Hash md5Hash = new Md5Hash(user.getUserpass(), user.getUsername(), 5);
        User user1 = new User();
        System.out.println("密码"+md5Hash.toString());
        user.setUserpass(md5Hash.toString());
        user1.setUsername(user.getUsername());
        //判断账号是否存在
        List<User> userList = userService.query(user1);
        //判断账号密码是否正确
        List<User> userList1 = userService.query(user);
        if (userList.size() == 0) {
            map.put("msg", "账号不存在,请重新输入");
            map.put("code", "0");
        } else if (userList1.size() == 0) {
            map.put("msg", "密码错误,请重新输入");
            map.put("code", "0");
        } else {
            map.put("username", userList1.get(0).getUsername());
            System.out.println("用户名" + userList1.get(0).getUsername());
            map.put("msg", "登录成功,欢迎你:"+user.getUsername());
            map.put("code", "1");
        }
        return map;
    }
    /****************************************   用户 ******************************************************************/
    //注册用户
    @RequestMapping("/adduser.action")
    @ResponseBody
    public Map adduser(User user) {
        /*用户注册时只需要传输用户名  密码即可*/
        /*System.out.println(user + "添加或编辑的用户");*/
        Map<String, String> map = new HashMap<String, String>();
        if (user.getUserid() == null) {//添加
            //加密
            Md5Hash md5Hash = new Md5Hash(user.getUserpass(), user.getUsername(), 5);
         /*   System.out.println("加密后的密码：" + md5Hash.toString());*/
            user.setUserpass(md5Hash.toString());
            int num = userService.insert(user);
            if (num > 0) {
                map.put("msg", "注册成功");
            } else {
                map.put("msg", "注册失败");
            }
        }
        return map;
    }

    /*用户修改验证或者实名认证*/
    @RequestMapping("/edituser.action")
    @ResponseBody
    public Map updateUser(User user) {
        /*用户修改只需修改传输    密码userpass 手机号usernumber  用户头像:userimg   性别:sex 即可*/
        Map<String, String> map = new HashMap<String, String>();
        System.out.println(user + "编辑的用户");
        int num = userService.getuser(user);
        if (num > 0) {
            map.put("msg", "修改成功");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }

    /*永久删除用户*/
    @RequestMapping("/dropuser.action")
    @ResponseBody
    @CrossOrigin
    public Map deluser(int userid) {
        Map<String, String> map = new HashMap<String, String>();
        int num = userService.deleteById(userid);
        if (num > 0) {
            map.put("msg", "1");
        } else {
            map.put("msg", "0");
        }
        return map;
    }

    /*删除用户---修改状态*/
    @RequestMapping("/deluser.action")
    @ResponseBody
    @CrossOrigin
    public Map delusers(User user) {
        System.out.println(user.getUserid());
        user.setIsdelete(0);
        Map<String, String> map = new HashMap<String, String>();
        int num = userService.updateById(user);
        System.out.println(num);
        if (num > 0) {
            map.put("msg", "1");
        } else {
            map.put("msg", "0");
        }
        return map;
    }
    /*模糊查询查看用户列表信息*/
    @RequestMapping("/querylike.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<User> querall(User user,
                              @RequestParam(value = "page",defaultValue ="1") int page,
                              @RequestParam(value = "rows",defaultValue = "5") int rows){
        User user1=new User();
        System.out.println(userService.queryAll(user,page,rows));
        return userService.queryAll(user,page,rows);

    }
    /*根据用户名查询用户*/
    @RequestMapping("/queryuser.action")
    @ResponseBody
    @CrossOrigin
    public User queryadmin(User user){
        System.out.println(user.getUsername());
        User user1=userService.getall(user);
       System.out.println(user1);
        //System.out.println("222");
        return userService.getall(user1);

    }
    /*实名认证*/
    @RequestMapping("/updatayonghu.action")
    @ResponseBody
    @CrossOrigin
    public int  getupdata(User user){
        System.out.println(user.getUsername());
        int num =userService.getupdata(user);

        return userService.getupdata(user);

    }
    /****************************************   商户 ******************************************************************/
    //注测商户  先登录用户再注册 或者输入用户名
    @RequestMapping("/zhuceshanghu.action")
    @ResponseBody
    @CrossOrigin
    public Map zhuceshanghu(User user) {
      /*  用户需要添加的字段名:* 用户名username 密码userpass 手机号usernumber 身份证号码:usercard 用户头像:userimg  性别:男 会员:1  用户类型usertype 1
        商户地址为空shaddress  商户余额 shmoney:0 商户申请状态 shstate 商户回复shstatehuifu 空 */

        /*商户认证时 需要传输 商户地址  即可*/
        System.out.println(user + "注册商户的用户");
        Map<String, String> map = new HashMap<String, String>();
        user.setShstate(2);
        //拿到当前注册商户的当前时间
        Date date = new Date();
        Timestamp nousedate = new Timestamp(date.getTime());
        user.setShzhucetime(nousedate);

        int num = userService.insert(user);
        if (num > 0) {
            map.put("msg", "申请成功");
        } else {
            map.put("msg", "申请失败");
        }
        return map;
    }
    /*模糊查询查看商户列表信息*/
    @RequestMapping("/querylike1.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<User> querylike1(User user,
                                   @RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "rows", defaultValue = "5") int rows) {
        //已审核
        user.setShstate(3);
        //商户
        user.setUsertype(2);
        System.out.println(user+"条件");
        return userService.queryLike(user, page, rows);
    }

    @RequestMapping("/login2.action")
    @ResponseBody
    @CrossOrigin
    public Map login2(User user) {
        System.out.println(user+"user");
        Map<String, String> map = new HashMap<String, String>();
        Md5Hash md5Hash = new Md5Hash(user.getUserpass(), user.getUsername(), 5);
        User user1 = new User();
        System.out.println("密码"+md5Hash.toString());
        user.setUserpass(md5Hash.toString());
        user1.setUsername(user.getUsername());
        //判断账号是否存在
        List<User> userList = userService.query(user1);
        //判断账号密码是否正确
        List<User> userList1 = userService.query(user);
        if (userList.size() == 0) {
            map.put("msg", "账号不存在,请重新输入");
            map.put("code", "0");
        } else if (userList1.size() == 0) {
            map.put("msg", "密码错误,请重新输入");
            map.put("code", "0");
        } else if (userList.get(0).getUsertype()!=2) {
            map.put("msg", "该用户不是商户");
            map.put("code", "0");
        } else if (userList.get(0).getShstate()==5) {
            map.put("msg", "该商户被冻结");
            map.put("code", "0");
        } else {
            map.put("shname",userList1.get(0).getUsername());
            map.put("id", userList1.get(0).getUserid().toString());
            map.put("msg", "登录成功,欢迎你:"+user.getUsername());
            map.put("code", "1");
        }
        return map;
    }

    @RequestMapping("/Shanghugrwh.action")
    @ResponseBody
    @CrossOrigin
    public User querById(int shid) {
        return userService.queryById(shid);
    }

    //用户修改
    @RequestMapping("/edituser1.action")
    @ResponseBody
    public Map updateUser1(User user) {
        Map<String, String> map = new HashMap<String, String>();
        System.out.println(user + "修改的用户");
        Md5Hash md5Hash = new Md5Hash(user.getUserpass(), user.getUsername(), 5);
        user.setUserpass(md5Hash.toString());
        int num = userService.updateById(user);
        if (num > 0) {
            map.put("msg", "修改成功");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }

    /*模糊查询查看商户列表信息*/
    @RequestMapping("/querylike2.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<User> querylike2(User user,
                                   @RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "rows", defaultValue = "5") int rows) {
        System.out.println(user+"条件");
        return userService.queryLike1(user,page,rows);
    }

    //商户修改
    @RequestMapping("/editsh.action")
    @ResponseBody
    public Map updateSh(User user) {
        Map<String, String> map = new HashMap<String, String>();
        System.out.println(user + "修改的商户");
        int num = userService.updateById(user);
        if (num > 0) {
            map.put("msg", "修改成功");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }

    //商户修改
    @RequestMapping("/shdj.action")
    @ResponseBody
    public Map updateIsdelete(User user) {
        Map<String, String> map = new HashMap<String, String>();
        if(user.getIsdelete()==1){
            user.setIsdelete(0);
        }else{
            user.setIsdelete(1);
        }
        int num = userService.updateIsdelete(user);
        if (num > 0) {
            map.put("msg", "成功");
        } else {
            map.put("msg", "失败");
        }
        return map;
    }


}
