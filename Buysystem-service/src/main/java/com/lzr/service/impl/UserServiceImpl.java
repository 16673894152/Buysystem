package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.UserMapping;
import com.lzr.service.UserService;
import com.lzr.vo.PageVo;
import com.lzr.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
     @Autowired
     UserMapping userMapping;

    @Override
        public PageVo<User> queryAll(User user, int page, int rows) {
            PageVo<User> pageVo = new PageVo<>();
            //在需要分页的代码调用前 执行以下代码
            PageHelper.startPage(page, rows);
            //获取分页后 显示的数据集合
            pageVo.setRows(userMapping.queryAll(user));
            //获取总的记录数量ssou
        System.out.println("xfcvf"+userMapping.queryAll(user).size());
            pageVo.setTotal(userMapping.queryAll(user).size());

            return pageVo;

    }

    @Override
    public User queryById(int userid) {
        return userMapping.queryById(userid);
    }

    @Override
    public List<User> query(User user) {
        return userMapping.query(user);
    }

    @Override
    public int insert(User user) {
        return userMapping.insert(user);
    }

    @Override
    public int updateById(User user) {
        return userMapping.updateById(user);
    }

    @Override
    public int deleteById(int id) {
        return userMapping.deleteById(id);
    }

    @Override
    public PageVo<User> queryLike(User user, int page, int rows) {
        PageVo<User> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(userMapping.queryLike(user));
        //获取总的记录数量
        pageVo.setTotal(userMapping.queryLike(user).size());

        return pageVo;
    }

    @Override
    public User getall(User user) {
        return userMapping.getuser(user);
    }

    @Override
    public int getuser(User user) {
        return userMapping.getusername(user);
    }


    /*实名认证*/
    @Override
    public int getupdata(User user) {
        return userMapping.getupdata(user);
    }

    @Override
    public PageVo<User> queryLike1(User user, int page, int rows) {
        PageVo<User> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(userMapping.queryLike1(user));
        //获取总的记录数量ssou
        pageVo.setTotal(userMapping.queryLike1(user).size());

        return pageVo;
    }

    @Override
    public int updateById1(User user) {
        return userMapping.updateById1(user);
    }

    @Override
    public int updateIsdelete(User user) {
        return userMapping.updateIsdelete(user);
    }
    /*修改个人信息*/
    @Override
    public int getusername(User user) {
        return userMapping.getusername(user);
    }

    @Override
    public int xiugaimima(User user) {
        return userMapping.xiugaimima(user);
    }

    @Override
    public int tihuosr(User user) {
        return userMapping.tihuosr(user);
    }
    /*申请商户*/
    @Override
    public int shshenqing(User user) {
        user.setUsertype(2);
        user.setShstate(2);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置bai日期格式
        System.out.println(df.format(new Date()));
        // new Date()为获取当前系统时间
        Timestamp sDate =   Timestamp.valueOf(df.format(new Date()));
        user.setShzhucetime(sDate);
        return userMapping.shshenqing(user);
    }
}
