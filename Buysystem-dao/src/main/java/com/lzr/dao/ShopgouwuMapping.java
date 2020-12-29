package com.lzr.dao;

import com.lzr.vo.Shopgouwu;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ShopgouwuMapping {

  /**
   * 查询所有方法 
   */
  List<Shopgouwu> queryAll();

  /**
   * 根据主键shopgwid(Shopgouwu.userid)查询单条数据方法
   */
  List<Shopgouwu> queryByuserid(int userid);

  /**
   * 根据主键shopgwid(Shopgouwu.shopgwid)查询单条数据方法 
   */
  Shopgouwu queryById(int id);

  /**
   * 根据Shopgouwu条件查询多条数据方法 
   */
  List<Shopgouwu> query(Shopgouwu shopgouwu);

  /**
   * 根据Shopgouwu条件模糊查询多条数据方法 
   */
  List<Shopgouwu> queryLike(Shopgouwu shopgouwu);

  /**
   * 根据Shopgouwu插入数据方法 
   */
  int insert(Shopgouwu shopgouwu);

  /**
   * 根据Shopgouwu条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Shopgouwu shopgouwu);

  /**
   * 根据Shopgouwu条件删除单条数据方法,从传入对象获取id 
   */
  int deleteById(int id);

  /*
  * 减少商品数量,从传入对象获取id
   * */
  int downNumerById(Shopgouwu shopgouwu);

  /*
   * 添加商品数量,从传入对象获取id
   * */
  int upNumerById(Shopgouwu shopgouwu);
  /*
   * 根据userid该购物车的商品
   * */
  int deleteByUserId(int userid);
}