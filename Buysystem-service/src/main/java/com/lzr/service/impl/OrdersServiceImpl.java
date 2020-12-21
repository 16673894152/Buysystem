package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.OrdersMapping;
import com.lzr.service.OrdersService;
import com.lzr.vo.Orders;
import com.lzr.vo.PageVo;
import com.lzr.vo.Shopgouwu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersMapping ordersMapping;
    @Override
    public PageVo<Orders> queryLike(Orders orders, int page, int rows) {
        PageVo<Orders> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(ordersMapping.getdingdanall(orders));
        //获取总的记录数量
        pageVo.setTotal(ordersMapping.getdingdanall(orders).size());

        return pageVo;
    }
}
