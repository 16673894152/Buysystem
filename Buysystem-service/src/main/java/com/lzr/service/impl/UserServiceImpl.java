package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.UserMapping;
import com.lzr.service.UserService;
import com.lzr.vo.PageVo;
import com.lzr.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            pageVo.setRows(userMapping.queryLike(user));
            //获取总的记录数量ssou
        System.out.println(userMapping.queryLike(user).size());
            pageVo.setTotal(userMapping.queryLike(user).size());

            return pageVo;

    }

    @Override
    public User queryById(int id) {
        return userMapping.queryById(id);
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
}
