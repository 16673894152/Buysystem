package com.lzr.dao;

import com.lzr.vo.EmployroleInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface EmployroleInfoMapping {

//** custom methods **//
  //在这里写你的自定义接口,每次生成.java文件都会保留这一段代码


//** /custom methods **//

  /**
   * 查询所有方法 
   */
  List<EmployroleInfo> queryAll();

  /**
   * 根据主键id(EmployroleInfo.id)查询单条数据方法 
   */
  EmployroleInfo queryById(int id);

  /**
   * 根据EmployroleInfo条件查询多条数据方法 
   */
  List<EmployroleInfo> query(EmployroleInfo employroleinfo);

  /**
   * 根据EmployroleInfo条件模糊查询多条数据方法 
   */
  List<EmployroleInfo> queryLike(EmployroleInfo employroleinfo);

  /**
   * 根据EmployroleInfo插入数据方法 
   */
  int insert(EmployroleInfo employroleinfo);

  /**
   * 根据EmployroleInfo条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(EmployroleInfo employroleinfo);

  /**
   * 根据EmployroleInfo条件删除单条数据方法,从传入对象获取id 
   */
  int deleteByempid(int empid);
}