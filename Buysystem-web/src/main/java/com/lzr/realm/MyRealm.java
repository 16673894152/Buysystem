package com.lzr.realm;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return null;
    }
//
//    @Autowired
//    EmployService employService;
//    @Autowired
//    MenuInfoService menuInfoService;
//    @Autowired
//    RoleInfoService roleInfoService;
    //授权
   // @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        AuthenticationToken token= (AuthenticationToken) principals.getPrimaryPrincipal();   //认证时，第一个参数传递的数据
//        System.out.println("授权时，取到的用户名："+token.getPrincipal());
//      //  System.out.println(loginName+"login");
//        if (!StringUtils.isEmpty((String) token.getPrincipal())) {
//            //用户id
//            String empid = SecurityUtils.getSubject().getSession().getAttribute("employ1").toString();
//            //所有菜单按钮
//            List<String> perms=menuInfoService.queryallmenus3(3, Integer.parseInt(empid));
//            //所有角色
//            List<RoleInfo> list=roleInfoService.queryallrolebyempid(Integer.parseInt(empid));
//            //根据用户名查询菜单code(菜单id)      userdao.xxxx()
//            List<String> roles = new ArrayList<String>();
//            for (RoleInfo r: list) {
//                roles.add(r.getRname());
//            }
//            System.out.println("角色:"+roles);
//            // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
//            SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
//            authorizationInfo.addRoles(roles);
//            authorizationInfo.addStringPermissions(perms);
//            return authorizationInfo;
//        }
//        return null;
//    }
//
//    //认证
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//
//
//        //通过token获取用户名
//        String username = (String) token.getPrincipal();
//        //密码
//        Employ employ = new Employ();
//        employ.setUsername(username);
//        //通过用户名去用户表查询当前用户数据(数据库里面当前用户名对应的密码)
//        List<Employ> employ1 = employService.query(employ);
//        //不为空   帐号存在
//        if (employ1.size() == 0) {
//            throw new UnknownAccountException("当前帐号不存在！！！");
//        }
//        Employ employ2 = employ1.get(0);
//        SimpleAuthenticationInfo authenticationInfo =
//                new SimpleAuthenticationInfo(token, employ2.getPassword(), ByteSource.Util.bytes(username), this.getName());
//        Session session = SecurityUtils.getSubject().getSession();
//        session.setAttribute("employ", employ2);
//        session.setAttribute("employ1", employ2.getEmpid());
//        return authenticationInfo;
//    }
}
