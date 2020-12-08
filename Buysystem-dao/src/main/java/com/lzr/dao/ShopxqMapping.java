package com.lzr.dao;

import com.lzr.vo.Shopxq;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShopxqMapping {
  /**
   * 查询所有方法 
   */
  List<Shopxq> queryAll();

  /**
   * 根据主键shopxqid(Shopxq.shopxqid)查询单条数据方法 
   */
  Shopxq queryById(int id);

  /**
   * 根据shopid查询商品详情
   */
  List<Shopxq> queryByshopid(int shopid);

  /**
   * 根据Shopxq插入数据方法 
   */
  int insert(Shopxq shopxq);

  /**
   * 根据Shopxq条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Shopxq shopxq);


  /**
   * 根据Shopxq条件删除单条数据方法,从传入对象获取id 
   */
  int deleteById(int shopid);
}