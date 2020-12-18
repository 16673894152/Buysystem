package com.lzr.service;
import com.lzr.vo.PageVo;
import com.lzr.vo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface UserService {
  /**
   * 查询所有方法
   */
  public PageVo<User> queryAll(User user, int page, int rows);

  /**
   * 根据主键userid(User.userid)查询单条数据方法
   */
  User queryById(int id);

  /**
   * 根据User条件查询多条数据方法
   */
  List<User> query(User user);

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
  /**
   * 根据Employ条件模糊查询多条数据方法  分页查询
   */
  PageVo<User> queryLike(User user, int page, int rows);
  /*根据用户名查询用户*/
    public  User GETALL(User user);
    public int  getuser(User user);
}