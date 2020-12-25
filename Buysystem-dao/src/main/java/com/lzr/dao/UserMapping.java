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
    User queryById(int userid);
    /**
     * 根据主键userid(User.userid)查询单条数据方法
     */
    User queryById1(int id);
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
    /*修改个人信息*/
    public  int getusername(User user);
    /*实名认证*/
    public int getupdata(User user);

    /**
     * 根据User条件模糊查询多条数据方法
     */
    List<User> queryLike1(User user);

    /**
     * 根据User条件修改单条数据方法,从传入对象获取id
     */
    int updateById1(User user);

    /**
     * 根据id修改商户冻结状态,从传入对象获取id
     */
    int updateIsdelete(User user);
    /*修改密码*/
    public int  xiugaimima(User user);

    /**
     * 根据id修改商户余额,从传入对象获取id
     */
    int tihuosr(User user);
    /**
     * 商户申请
     */
    int shshenqing(User user);

    /**
     * 查询所有未审核商户
     */
    List<User> queryshshenhe();

    /**
     * 商户审核拒绝,从传入对象获取id
     */
    int shjujue(User user);

    /**
     * 商户审核同意,从传入对象获取id
     */
    int shshty(User user);
}
