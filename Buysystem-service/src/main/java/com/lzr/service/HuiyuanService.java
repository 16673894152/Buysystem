package com.lzr.service;

import com.lzr.vo.Employ;
import com.lzr.vo.Huiyuan;
import com.lzr.vo.PageVo;
import org.springframework.stereotype.Repository;

import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface HuiyuanService {
  /**
   * 查询所有方法
   */
  List<Huiyuan> queryAll();

  /**
   * 根据主键hyid(Huiyuan.hyid)查询单条数据方法
   */
  Huiyuan queryById(int id);

  /**
   * 根据Huiyuan条件查询多条数据方法
   */
  List<Huiyuan> query(Huiyuan huiyuan);

  /**
   * 根据Huiyuan条件模糊查询多条数据方法
   */
  List<Huiyuan> queryLike(Huiyuan huiyuan);

  /**
   * 根据Huiyuan插入数据方法
   */
  int insert(Huiyuan huiyuan);

  /**
   * 根据Huiyuan条件修改单条数据方法,从传入对象获取id
   */
  int updateById(Huiyuan huiyuan);

  /**
   * 根据Huiyuan条件删除单条数据方法,从传入对象获取id
   */
  int deleteById(int id);
}