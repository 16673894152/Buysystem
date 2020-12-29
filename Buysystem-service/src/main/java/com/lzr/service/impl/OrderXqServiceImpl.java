package com.lzr.service.impl;

import com.lzr.dao.OrderxqMapping;
import com.lzr.service.OrderXqService;
import com.lzr.vo.Orders;
import com.lzr.vo.Orderxq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderXqServiceImpl implements OrderXqService {

    @Autowired
    OrderxqMapping orderxqMapping;

    @Override
    public List<Orderxq> queryAll() {
        return null;
    }

    @Override
    public List<Orderxq> queryByorderid(int orderid) {
        return null;
    }

    @Override
    public Orderxq queryById(int id) {
        return null;
    }

    @Override
    public List<Orderxq> query(Orderxq orderxq) {
        return null;
    }

    @Override
    public List<Orderxq> queryLike(Orderxq orderxq) {
        return null;
    }

    @Override
    public int insert(Orderxq orderxq) {
        return orderxqMapping.insert(orderxq);
    }

    @Override
    public int updateById(Orderxq orderxq) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public List<Orderxq> xiangqing(Orders orders) {
        return null;
    }
}
