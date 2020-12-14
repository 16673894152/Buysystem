package com.lzr.dao;

import com.lzr.vo.Wareshop;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface WareshopMapping {
  /**
   * 查询所有方法 
   */
  List<Wareshop> queryAll();

  /**
   * 根据wareid查看 商品及商品数量
   * @param wareid
   * @return
   */
  List<Wareshop> queryByWareid(int wareid);
  /**
   * 根据主键wsshid(Wareshop.wsshid)查询单条数据方法 
   */
  Wareshop queryById(int id);

  /**
   * 根据Wareshop条件查询多条数据方法 
   */
  List<Wareshop> query(Wareshop wareshop);

  /**
   * 根据Wareshop条件模糊查询多条数据方法 
   */
  List<Wareshop> queryLike(Wareshop wareshop);

  /**
   * 根据Wareshop插入数据方法 
   */
  int insert(Wareshop wareshop);

  /**
   * 根据Wareshop插入多条数据方法 
   */
  int inserts(@Param("wareshops") List<Wareshop> wareshops);

  /**
   * 根据Wareshop条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Wareshop wareshop);

  /**
   * 根据Wareshop条件删除单条数据方法,从传入对象获取id 
   */
  int deleteById(int id);

}