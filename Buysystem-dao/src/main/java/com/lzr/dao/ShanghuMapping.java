package com.lzr.dao;

import com.lzr.vo.Shanghu;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface ShanghuMapping {

  /**
   * 查询所有方法 
   */
  List<Shanghu> queryAll();

  /**
   * 根据主键shid(Shanghu.shid)查询单条数据方法 
   */
  Shanghu queryById(int id);

  /**
   * 根据Shanghu条件查询多条数据方法 
   */
  List<Shanghu> query(Shanghu shanghu);

  /**
   * 根据Shanghu条件模糊查询多条数据方法 
   */
  List<Shanghu> queryLike(Shanghu shanghu);

  /**
   * 根据Shanghu插入数据方法 
   */
  int insert(Shanghu shanghu);
  /**
   * 根据Shanghu条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Shanghu shanghu);

  /**
   * 根据Shanghu条件删除单条数据方法,从传入对象获取id 
   */
  int deleteById(int id);
}