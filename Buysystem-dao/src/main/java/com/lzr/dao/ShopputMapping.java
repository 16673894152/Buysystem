package com.lzr.dao;

import com.lzr.vo.Shopput;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface ShopputMapping {

  /**
   * 查询所有方法 
   */
  List<Shopput> queryAll();

  /**
   * 根据主键shopputid(Shopput.shopputid)查询单条数据方法 
   */
  Shopput queryById(int id);

  /**
   * 根据Shopput条件查询多条数据方法 
   */
  List<Shopput> query(Shopput shopput);

  /**
   * 根据Shopput条件模糊查询多条数据方法 
   */
  List<Shopput> queryLike(Shopput shopput);

  /**
   * 根据Shopput插入数据方法 
   */
  int insert(Shopput shopput);


  /**
   * 根据Shopput条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Shopput shopput);


  /**
   * 根据Shopput条件删除单条数据方法,从传入对象获取id 
   */
  int deleteById(int id);



}