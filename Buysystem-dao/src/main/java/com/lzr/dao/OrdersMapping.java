package com.lzr.dao;

import com.lzr.vo.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface OrdersMapping {

  /**
   * 查询所有方法 
   */
  List<Orders> queryAll();

  /**
   * 根据主键orderid(Orders.orderid)查询单条数据方法
   */
  Orders queryById(int id);
  /**
   * 根据主键orderid(Orders.userid)查询单用户拥有的订单
   */
  List<Orders> queryByuserid(int userid);
  /**
   * 根据主键orderid(Orders.shid)查询单用户拥有的订单
   */
  List<Orders> queryByshid(int shid);
  /**
   * 根据Orders条件查询多条数据方法 
   */
  List<Orders> query(Orders orders);

  /**
   * 根据Orders条件模糊查询多条数据方法 
   */
  List<Orders> queryLike(Orders orders);

  /**
   * 根据Orders插入数据方法 
   */
  int insert(Orders orders);

  /**
   * 根据Orders条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Orders orders);

  /**
   * 根据Orders条件删除单条数据方法,从传入对象获取id 
   */
  int deleteById(int id);
  /*用户查询订单*/
  List<Orders> getdingdanall(Orders orders);
}