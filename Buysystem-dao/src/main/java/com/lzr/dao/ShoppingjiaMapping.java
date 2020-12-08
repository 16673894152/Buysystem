package com.lzr.dao;

import com.lzr.vo.Shoppingjia;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface ShoppingjiaMapping {

//** custom methods **//
  //在这里写你的自定义接口,每次生成.java文件都会保留这一段代码


//** /custom methods **//

  /**
   * 查询所有方法 
   */
  List<Shoppingjia> queryAll();

  /**
   * 根据主键shoppjid(Shoppingjia.shoppjid)查询单条数据方法 
   */
  Shoppingjia queryById(int id);

  /**
   * 根据Shoppingjia条件查询多条数据方法 
   */
  List<Shoppingjia> query(Shoppingjia shoppingjia);

  /**
   * 根据Shoppingjia条件模糊查询多条数据方法 
   */
  List<Shoppingjia> queryLike(Shoppingjia shoppingjia);

  /**
   * 根据Shoppingjia条件查询数据方法,限制显示条数,startIndex为开始索引,pageSize为显示条数 
   */
  List<Shoppingjia> queryLimit(@Param("Shoppingjia") Shoppingjia shoppingjia, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

  /**
   * 根据Shoppingjia条件模糊查询数据方法,限制显示条数,startIndex为开始索引,pageSize为显示条数 
   */
  List<Shoppingjia> queryLikeLimit(@Param("Shoppingjia") Shoppingjia shoppingjia, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

  /**
   * 根据Shoppingjia条件获取数据总条数方法 
   */
  int queryCount(Shoppingjia shoppingjia);

  /**
   * 根据Shoppingjia模糊查询数据总条数方法 
   */
  int queryLikeCount(Shoppingjia shoppingjia);

  /**
   * 根据Shoppingjia插入数据方法 
   */
  int insert(Shoppingjia shoppingjia);

  /**
   * 根据Shoppingjia插入多条数据方法 
   */
  int inserts(@Param("shoppingjias") List<Shoppingjia> shoppingjias);

  /**
   * 根据Shoppingjia条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Shoppingjia shoppingjia);

  /**
   * 根据SetValue条件修改多条数据方法,从传入对象Condition中获取修改的条件<br/>注意:如果Condition为空或Condition所有关键字段为空,则会修改该表所有数据 
   */
  int updates(@Param("SetValue") Shoppingjia setValue, @Param("Condition") Shoppingjia condition);

  /**
   * 根据Shoppingjia条件删除单条数据方法,从传入对象获取id 
   */
  int deleteById(int id);

  /**
   * 根据Shoppingjia条件删除多条数据方法,从传入对象获取删除条件<br/>注意:如果参数对象所有关键字段都为空值,则不会删除任何数据 
   */
  int deleteBy(Shoppingjia shoppingjia);

  /**
   * 根据Shoppingjia主键id批量删除多条数据方法 
   */
  int deletesById(@Param("shoppjids") List<Integer> shoppjids);
}