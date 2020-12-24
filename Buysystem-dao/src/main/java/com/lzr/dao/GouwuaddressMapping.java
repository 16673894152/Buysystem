package com.lzr.dao;

import com.lzr.vo.Ckbaobiao;
import com.lzr.vo.Gouwuaddress;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GouwuaddressMapping {


  /**
   * 根据主键addressid(addressid.addressid)查询单条数据方法
   */
  List<Gouwuaddress> queryById(int id);

  /**
   * 根据Gouwuaddres插入数据方法
   */
  int insert(Gouwuaddress gouwuaddress);

  /**
   * 根据Ckbaobiao条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Gouwuaddress gouwuaddress);

  /**
   * 根据Ckbaobiao条件删除单条数据方法,从传入对象获取id 
   */
  int deleteById(int id);

}