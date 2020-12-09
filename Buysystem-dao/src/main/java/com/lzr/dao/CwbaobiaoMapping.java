package com.lzr.dao;

import com.lzr.vo.Cwbaobiao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface CwbaobiaoMapping {

  /**
   * 查询所有方法 
   */
  List<Cwbaobiao> queryAll();

  /**
   * 根据主键cwbbid(Cwbaobiao.cwbbid)查询单条数据方法 
   */
  Cwbaobiao queryById(int id);

  /**
   * 根据Cwbaobiao条件查询多条数据方法 
   */
  List<Cwbaobiao> query(Cwbaobiao cwbaobiao);

  /**
   * 根据Cwbaobiao条件模糊查询多条数据方法 
   */
  List<Cwbaobiao> queryLike(Cwbaobiao cwbaobiao);

  /**
   * 根据Cwbaobiao插入数据方法 
   */
  int insert(Cwbaobiao cwbaobiao);

  /**
   * 根据Cwbaobiao插入多条数据方法 
   */
  int inserts(@Param("cwbaobiaos") List<Cwbaobiao> cwbaobiaos);

  /**
   * 根据Cwbaobiao条件删除单条数据方法,从传入对象获取id 
   */
  int deleteById(int id);
}