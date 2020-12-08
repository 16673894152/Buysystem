package com.lzr.dao;

import com.lzr.vo.Warehouse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface WarehouseMapping {

  /**
   * 查询所有方法 
   */
  List<Warehouse> queryAll();

  /**
   * 根据主键wareid(Warehouse.wareid)查询单条数据方法 
   */
  Warehouse queryById(int id);

  /**
   * 根据Warehouse条件查询多条数据方法 
   */
  List<Warehouse> query(Warehouse warehouse);

  /**
   * 根据Warehouse条件模糊查询多条数据方法 
   */
  List<Warehouse> queryLike(Warehouse warehouse);


  /**
   * 根据Warehouse插入数据方法 
   */
  int insert(Warehouse warehouse);

  /**
   * 根据Warehouse条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Warehouse warehouse);

  /**
   * 根据Warehouse条件删除单条数据方法,从传入对象获取id 
   */
  int deleteById(int id);
}