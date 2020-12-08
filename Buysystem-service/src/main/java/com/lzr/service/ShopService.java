package com.lzr.service;

import com.lzr.vo.PageVo;
import com.lzr.vo.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShopService {
    /**
     * 根据Shop条件模糊查询多条数据方法  分页查询
     */
    PageVo<Shop> queryLike(Shop shop, int page, int rows);
    /**
     * 查询所有方法
     */
    List<Shop> queryAll();

    /**
     * 根据主键id(Shopid)查询单条数据方法
     */
    Shop queryById(int shop);

    /**
     * 根据Shop条件查询多条数据方法
     */
    List<Shop> query(Shop shop);

    /**
     * 根据Shop插入数据方法
     */
    int insert(Shop shop);

    /**
     * 根据Shop条件修改单条数据方法,从传入对象获取id
     */
    int updateById(Shop shop);

    /**
     * 根据Shop条件删除单条数据方法,从传入对象获取id
     */
    int deleteById(int id);
}