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
  User queryById(int userid);

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
    public  User getall(User user);
    public int  getuser(User user);
  /*实名认证*/
  public int getupdata(User user);

  /**
   * 根据Employ条件模糊查询多条数据方法  分页查询
   */
  PageVo<User> queryLike1(User user, int page, int rows);

  /**
   * 根据User条件修改单条数据方法,从传入对象获取id
   */
  int updateById1(User user);

  /**
   * 根据Id修改商户冻结状态,从传入对象获取id
   */
  int updateshstate(User user);
  /*修改个人信息*/
  public int getusername(User user);
  public int xiugaimima(User user);
  int shshenqing(User user);

  /**
   * 根据Id修改商户余额,从传入对象获取id
   */
  int tihuosr(User user);

  /**
   * 查询所有未审核商户
   */
  PageVo<User> queryshshenhe(int page, int rows);

  /**
   * 商户审核拒绝,从传入对象获取id
   */
  int shjujue(User user);

  /**
   * 商户审核拒绝,从传入对象获取id
   */
  int shshty(User user);

  /**
   * 提现,从传入对象获取id
   */
  int qdtx(User user);

}