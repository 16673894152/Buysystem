package com.lzr.service;

import com.lzr.vo.Orders;
import com.lzr.vo.PageVo;
import com.lzr.vo.RoleInfo;

public interface OrdersService {
    /*用户查询所有*/
    PageVo<Orders> queryLike(Orders orders, int page, int rows);
    PageVo<Orders> queryLikept(Orders orders, int page, int rows);
    int updateById(Orders orders);
}
