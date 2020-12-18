package com.lzr.dao;

import com.lzr.vo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapping {
    /**
     * 查询所有方法
     */
    List<User> queryAll(User user);

    /**
     * 根据主键userid(User.userid)查询单条数据方法
     */
    User queryById(int id);

    /**
     * 根据User条件查询多条数据方法
     */
    List<User> query(User user);

    /**
     * 根据User条件模糊查询多条数据方法
     */
    List<User> queryLike(User user);

    /**
     * 根据User插入数据方法
     */
    int insert(User user);

    /**
     * 根据User条件修改单条数据方法,从传入对象获取id
     */
    int updateById(User user);

    /**
     * 根据User条件删除单条数据方法,从传入对象获取id
     */
    int deleteById(int id);
    public  User getuser(User user);

    public  int getusername(User user);
}