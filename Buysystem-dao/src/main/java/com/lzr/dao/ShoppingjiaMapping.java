package com.lzr.dao;

import com.lzr.vo.Shoppingjia;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface ShoppingjiaMapping {
  /**
   * 查询所有方法 
   */
  List<Shoppingjia> queryAll();

  /**
   * 根据主键shoppjid(Shoppingjia.shoppjid)查询单条数据方法 
   */
  Shoppingjia queryById(int id);

  /**
   * 根据主键shoppjid(Shoppingjia.userid)查询单条数据方法
   */
  List<Shoppingjia> queryByuserid(int userid);

  /**
   * 根据主键shoppjid(Shoppingjia.shopid)查询单条数据方法
   */
  List<Shoppingjia> queryByshopid(int shopid);
  /**
   * 根据Shoppingjia条件查询多条数据方法 
   */
  List<Shoppingjia> query(Shoppingjia shoppingjia);

  /**
   * 根据Shoppingjia条件模糊查询多条数据方法 
   */
  List<Shoppingjia> queryLike(Shoppingjia shoppingjia);

  /**
   * 根据Shoppingjia插入数据方法 
   */
  int insert(Shoppingjia shoppingjia);

  /**
   * 根据Shoppingjia条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Shoppingjia shoppingjia);

  /**
   * 根据Shoppingjia条件删除单条数据方法,从传入对象获取id 
   */
  int deleteById(int id);

}