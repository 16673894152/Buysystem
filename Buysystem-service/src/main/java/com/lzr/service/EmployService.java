package com.lzr.service;

import com.lzr.vo.Employ;
import com.lzr.vo.PageVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface EmployService {
  /**
   * 查询所有方法
   */
  List<Employ> queryAll();

  /**
   * 根据主键empid(Employ.empid)查询单条数据方法
   */
  Employ queryById(int id);

  /**
   * 根据Employ条件查询多条数据方法
   */
  List<Employ> query(Employ employ);

  /**
   * 根据Employ条件模糊查询多条数据方法  分页查询
   */
  PageVo<Employ> queryLike(Employ employ,int page, int rows);
  /**
   * 根据Employ插入数据方法
   */
  int insert(Employ employ);
  /**
   * 根据Employ条件修改单条数据方法,从传入对象获取id
   */
  int updateById(Employ employ);

}