package com.lzr.service;

import com.lzr.vo.PageVo;
import com.lzr.vo.Shop;
import com.lzr.vo.Shoptype;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShoptypeService {

    /**
     * 查询所有方法
     */
    List<Shoptype> queryAll();

    /**
     * 根据主键shoptyid(Shoptype.shoptyid)查询单条数据方法
     */
    Shoptype queryById(int id);

    /**
     * 根据Shoptype条件查询多条数据方法
     */
    List<Shoptype> query(Shoptype shoptype);

    /**
     * 根据Shoptype条件模糊查询多条数据方法
     */
    List<Shoptype> queryLike(Shoptype shoptype);

    /**
     * 根据Shoptype插入数据方法
     */
    int insert(Shoptype shoptype);

    /**
     * 根据Shoptype条件修改单条数据方法,从传入对象获取id
     */
    int updateById(Shoptype shoptype);

    /**
     * 根据Shoptype条件删除单条数据方法,从传入对象获取id
     */
    int deleteById(int id);
}