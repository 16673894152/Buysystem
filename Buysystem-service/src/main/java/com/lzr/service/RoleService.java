package com.lzr.service;

import com.lzr.vo.PageVo;
import com.lzr.vo.RoleInfo;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleService {

    /**
     * 根据RoleInfo条件模糊查询多条数据方法  分页查询
     */
    PageVo<RoleInfo> queryLike(RoleInfo roleInfo, int page, int rows);

    /**
     * 查询所有方法
     */
    List<RoleInfo> queryAll();

    /**
     * 根据主键rid查询单条数据方法
     */
    RoleInfo queryById(int id);

    /**
     * 根据RoleInfo条件查询多条数据方法
     */
    List<RoleInfo> query(RoleInfo roleinfo);

    /**
     * 根据RoleInfo插入数据方法
     */
    int insert(RoleInfo roleinfo);

    /**
     * 根据RoleInfo条件修改单条数据方法,从传入对象获取id
     */
    int updateById(RoleInfo roleinfo);
}