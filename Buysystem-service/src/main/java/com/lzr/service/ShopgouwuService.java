package com.lzr.service;

import com.lzr.vo.PageVo;
import com.lzr.vo.Shopgouwu;
import org.springframework.stereotype.Repository;

import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface ShopgouwuService {

  /**
   * 根据Employ条件模糊查询多条数据方法  分页查询
   */
  PageVo<Shopgouwu> queryLike(Shopgouwu shopgouwu, int page, int rows);


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
}