package com.lzr.service;

import com.lzr.vo.Ckbaobiao;
import com.lzr.vo.PageVo;
import org.springframework.stereotype.Repository;

import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface CkbaobiaoService {

  /**
   * 查询所有方法
   */
  List<Ckbaobiao> queryAll();

  /**
   * 根据主键xsbbid(Xsbaobiao.xsbbid)查询单条数据方法
   */
  Ckbaobiao queryById(int id);

  /**
   * 根据Xsbaobiao条件查询多条数据方法
   */
  List<Ckbaobiao> query(Ckbaobiao ckbaobiao);

  /**
   * 根据Xsbaobiao条件模糊查询多条数据方法
   */
  PageVo<Ckbaobiao> queryLike(Ckbaobiao ckbaobiao, int page, int rows);


  /**
   * 根据Xsbaobiao插入数据方法
   */
  int insert(Ckbaobiao ckbaobiao);

  /**
   * 根据Xsbaobiao条件删除单条数据方法,从传入对象获取id
   */
  int deleteById(int id);



}