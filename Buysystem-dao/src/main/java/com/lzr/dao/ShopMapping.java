package com.lzr.dao;

import com.lzr.vo.Shop;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface ShopMapping {

  /**
   * 查询所有方法 
   */
  List<Shop> queryAll();
  List<Shop> queryAllshangjia(Shop shop);
  /**
   * 根据主键id(Shop.null)查询单条数据方法 
   */
  Shop queryById(int id);

  /**
   * 根据Shop条件查询多条数据方法 
   */
  List<Shop> query(Shop shop);

  /**
   * 根据Shop条件模糊查询多条数据方法 
   */
  List<Shop> queryLike(Shop shop);

  /**
   * 根据Shop插入数据方法 
   */
  int insert(Shop shop);

  /**
   * 根据Shop条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Shop shop);


  /**
   * 根据Shop条件删除单条数据方法,从传入对象获取id 
   */
  int deleteById(int id);

}