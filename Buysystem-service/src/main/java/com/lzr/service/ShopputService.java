package com.lzr.service;

import com.lzr.vo.PageVo;
import com.lzr.vo.Shopput;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShopputService {

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


  /**
   * 根据Employ条件模糊查询多条数据方法  分页查询
   */
  PageVo<Shopput> queryLike(Shopput shopput, int page, int rows);

}