package com.lzr.dao;

import com.lzr.vo.MenuInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//** custom import **//
//在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface MenuInfoMapping {

//** custom methods **//
  //在这里写你的自定义接口,每次生成.java文件都会保留这一段代码


//** /custom methods **//

  /**
   * 查询所有方法
   */
  public List<MenuInfo> querymenuBypidandnodeType(@Param("pid") int pid, @Param("nodeType") int nodeType, @Param("empid") int empid);
  public List<String> querymenuBypidandnodeType3(@Param("nodeType") int nodeType, @Param("empid") int empid);

  public List<MenuInfo> querymenuBypidandnodeType1(@Param("pid") int pid, @Param("nodeType") int nodeType);


  /**   2020-10-12修改
   * 根据角色id查询当前可操作的菜单
   * @param rid  角色id
   * @return
   */
  public List<Integer> querymenuidbyrid(int rid);

  /**
   * 根据主键id(MenuInfo.id)查询单条数据方法
   */
  MenuInfo queryById(int id);

  /**
   * 根据MenuInfo条件模糊查询多条数据方法
   */
  List<MenuInfo> queryLike(MenuInfo menuinfo);

  /**
   * 根据MenuInfo条件修改单条数据方法,从传入对象获取id
   */
  int updateById(MenuInfo menuinfo);

}
