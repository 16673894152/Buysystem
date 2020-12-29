package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.OrdersMapping;
import com.lzr.dao.WarehouseMapping;
import com.lzr.service.OrdersService;
import com.lzr.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersMapping ordersMapping;
    @Autowired
    WarehouseMapping warehouseMapping;
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

    @Override
    public PageVo<Orders> queryLike1(Orders orders, int page, int rows) {
        PageVo<Orders> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(ordersMapping.queryLike1(orders));
        //获取总的记录数量
        pageVo.setTotal(ordersMapping.queryLike1(orders).size());

        return pageVo;
    }

    @Override
    public PageVo<Orders> queryLikept1(Orders orders, int page, int rows) {
        PageVo<Orders> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(ordersMapping.queryLikept1(orders));
        //获取总的记录数量
        pageVo.setTotal(ordersMapping.queryLikept1(orders).size());
        for (Orders orders1 :pageVo.getRows()) {
            for (Orderxq orderxq :orders1.getOrderxqs()) {
                Wareshop wareshop=new Wareshop();
                wareshop.setShopid(orderxq.getShopid());
                wareshop.setShopcount(orderxq.getOrderxqcount());
                orderxq.setWarehouses(warehouseMapping.querywaresbyshopid(wareshop));
            }
        }
        return pageVo;
    }

    @Override
    public int updateshouhuo(Orders orders) {
        return ordersMapping.updateshouhuo(orders);
    }

    @Override
    public int updatetihuo(Orders orders) {
        return ordersMapping.updatetihuo(orders);
    }

    @Override
    public List<Orderxq> xiangqing(Orders orders) {
        return null;
    }

    @Override
    public int updatebydingdanbiaohao(Orders orders) {
        return ordersMapping.updatebydingdanbiaohao(orders);
    }

    @Override
    public PageVo<Orders> queryLikept(Orders orders, int page, int rows) {
        PageVo<Orders> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(ordersMapping.queryLikept(orders));
        //获取总的记录数量
        pageVo.setTotal(ordersMapping.queryLikept(orders).size());
        for (Orders orders1 :pageVo.getRows()) {
            for (Orderxq orderxq :orders1.getOrderxqs()) {
                Wareshop wareshop=new Wareshop();
                wareshop.setShopid(orderxq.getShopid());
                wareshop.setShopcount(orderxq.getOrderxqcount());
                orderxq.setWarehouses(warehouseMapping.querywaresbyshopid(wareshop));
            }
        }
        return pageVo;
    }

    @Override
    public int updateById(Orders orders) {
        return ordersMapping.updateById(orders);
    }
}
