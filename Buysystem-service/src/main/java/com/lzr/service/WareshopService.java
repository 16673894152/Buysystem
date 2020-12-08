package com.lzr.service;

import com.lzr.vo.PageVo;
import com.lzr.vo.RoleInfo;
import com.lzr.vo.Warehouse;
import com.lzr.vo.Wareshop;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WareshopService {
    /**
     * 查询所有方法
     */
    List<Wareshop> queryAll();

    /**
     * 根据主键wsshid(Wareshop.wsshid)查询单条数据方法
     */
    Wareshop queryById(int id);

    /**
     * 根据Wareshop条件查询多条数据方法
     */
    List<Wareshop> query(Wareshop wareshop);

    /**
     * 根据Wareshop条件模糊查询多条数据方法  分页查询
     */
    PageVo<Wareshop> queryLike(Wareshop wareshop, int page, int rows);

    /**
     * 根据Wareshop插入数据方法
     */
    int insert(Wareshop wareshop);


    /**
     * 根据Wareshop条件修改单条数据方法,从传入对象获取id
     */
    int updateById(Wareshop wareshop);

    /**
     * 根据Wareshop条件删除单条数据方法,从传入对象获取id
     */
    int deleteById(int id);
}