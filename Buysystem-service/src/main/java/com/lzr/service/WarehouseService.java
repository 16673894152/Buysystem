package com.lzr.service;

import com.lzr.vo.PageVo;
import com.lzr.vo.RoleInfo;
import com.lzr.vo.Warehouse;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WarehouseService {

    /**
     * 根据RoleInfo条件模糊查询多条数据方法  分页查询
     */
    PageVo<Warehouse> queryLike(Warehouse warehouse, int page, int rows);


    /**
     * 查询所有方法
     */
    List<Warehouse> queryAll();

    /**
     * 根据主键wareid(Warehouse.wareid)查询单条数据方法
     */
    Warehouse queryById(int id);

    /**
     * 根据Warehouse条件查询多条数据方法
     */
    /**
     * 根据Warehouse插入数据方法
     */
    int insert(Warehouse warehouse);

    /**
     * 根据Warehouse条件修改单条数据方法,从传入对象获取id
     */
    int updateById(Warehouse warehouse);

    /**
     * 根据Warehouse条件删除单条数据方法,从传入对象获取id
     */
    int deleteById(int id);
}