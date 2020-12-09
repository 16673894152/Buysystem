package com.lzr.dao;

import com.lzr.vo.Ckbaobiao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CkbaobiaoMapping {


  /**
   * 查询所有方法 
   */
  List<Ckbaobiao> queryAll();

  /**
   * 根据主键ckbbid(Ckbaobiao.ckbbid)查询单条数据方法 
   */
  Ckbaobiao queryById(int id);

  /**
   * 根据Ckbaobiao条件查询多条数据方法 
   */
  List<Ckbaobiao> query(Ckbaobiao ckbaobiao);

  /**
   * 根据Ckbaobiao条件模糊查询多条数据方法 
   */
  List<Ckbaobiao> queryLike(Ckbaobiao ckbaobiao);

  /**
   * 根据Ckbaobiao插入数据方法 
   */
  int insert(Ckbaobiao ckbaobiao);


  /**
   * 根据Ckbaobiao条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Ckbaobiao ckbaobiao);

  /**
   * 根据Ckbaobiao条件删除单条数据方法,从传入对象获取id 
   */
  int deleteById(int id);

}