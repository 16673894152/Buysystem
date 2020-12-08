package com.lzr.dao;

import com.lzr.vo.Orderxq;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface OrderxqMapping {

//** custom methods **//
  //在这里写你的自定义接口,每次生成.java文件都会保留这一段代码


//** /custom methods **//

  /**
   * 查询所有方法 
   */
  List<Orderxq> queryAll();

  /**
   * 根据主键orderxqid(Orderxq.orderxqid)查询单条数据方法 
   */
  Orderxq queryById(int id);

  /**
   * 根据Orderxq条件查询多条数据方法 
   */
  List<Orderxq> query(Orderxq orderxq);

  /**
   * 根据Orderxq条件模糊查询多条数据方法 
   */
  List<Orderxq> queryLike(Orderxq orderxq);

  /**
   * 根据Orderxq条件查询数据方法,限制显示条数,startIndex为开始索引,pageSize为显示条数 
   */
  List<Orderxq> queryLimit(@Param("Orderxq") Orderxq orderxq, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

  /**
   * 根据Orderxq条件模糊查询数据方法,限制显示条数,startIndex为开始索引,pageSize为显示条数 
   */
  List<Orderxq> queryLikeLimit(@Param("Orderxq") Orderxq orderxq, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

  /**
   * 根据Orderxq条件获取数据总条数方法 
   */
  int queryCount(Orderxq orderxq);

  /**
   * 根据Orderxq模糊查询数据总条数方法 
   */
  int queryLikeCount(Orderxq orderxq);

  /**
   * 根据Orderxq插入数据方法 
   */
  int insert(Orderxq orderxq);

  /**
   * 根据Orderxq插入多条数据方法 
   */
  int inserts(@Param("orderxqs") List<Orderxq> orderxqs);

  /**
   * 根据Orderxq条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Orderxq orderxq);

  /**
   * 根据SetValue条件修改多条数据方法,从传入对象Condition中获取修改的条件<br/>注意:如果Condition为空或Condition所有关键字段为空,则会修改该表所有数据 
   */
  int updates(@Param("SetValue") Orderxq setValue, @Param("Condition") Orderxq condition);

  /**
   * 根据Orderxq条件删除单条数据方法,从传入对象获取id 
   */
  int deleteById(int id);

  /**
   * 根据Orderxq条件删除多条数据方法,从传入对象获取删除条件<br/>注意:如果参数对象所有关键字段都为空值,则不会删除任何数据 
   */
  int deleteBy(Orderxq orderxq);

  /**
   * 根据Orderxq主键id批量删除多条数据方法 
   */
  int deletesById(@Param("orderxqids") List<Integer> orderxqids);
}