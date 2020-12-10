package com.lzr.dao;

import com.lzr.vo.RolemenuInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface RolemenuInfoMapping {

  /**
   * 查询所有方法 
   */
  List<RolemenuInfo> queryAll();

  /**
   * 根据主键mrid(RolemenuInfo.mrid)查询单条数据方法 
   */
  RolemenuInfo queryById(int id);

  /**
   * 根据RolemenuInfo条件查询多条数据方法 
   */
  List<RolemenuInfo> query(RolemenuInfo rolemenuinfo);

  /**
   * 根据RolemenuInfo条件模糊查询多条数据方法 
   */
  List<RolemenuInfo> queryLike(RolemenuInfo rolemenuinfo);

  /**
   * 根据RolemenuInfo插入数据方法 
   */
  int insert(@Param("rid") int rid, @Param("mid") int mid);
  /**
   * 根据RolemenuInfo条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(RolemenuInfo rolemenuinfo);

  /**
   * 根据RolemenuInfo条件删除单条数据方法,从传入对象获取id 
   */
  int deleteById(int id);

  /**
   * 根据RolemenuInfo条件删除多条数据方法,从传入对象获取删除条件<br/>注意:如果参数对象所有关键字段都为空值,则不会删除任何数据
   */
  int deleteBy(RolemenuInfo rolemenuinfo);

}