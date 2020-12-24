package com.lzr.service;

import com.lzr.vo.Orders;
import com.lzr.vo.Orderxq;
import com.lzr.vo.PageVo;
import com.lzr.vo.RoleInfo;

import java.util.List;

public interface OrdersService {
    /*用户查询所有*/
    PageVo<Orders> queryLike(Orders orders, int page, int rows);
    PageVo<Orders> queryLikept(Orders orders, int page, int rows);
    int updateById(Orders orders);
    PageVo<Orders> queryLike1(Orders orders, int page, int rows);
    PageVo<Orders> queryLikept1(Orders orders, int page, int rows);
    //商户收货修改订单状态
    int updateshouhuo(Orders orders);
    //商户提货修改订单状态
    int updatetihuo(Orders orders);
    List<Orderxq> xiangqing(Orders orders);

}
