package com.lzr.service;

import com.lzr.vo.Orders;
import com.lzr.vo.Orderxq;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderXqService {
    /**
     * 查询所有方法
     */
    List<Orderxq> queryAll();

    /**
     * 根据主键orderxqid(Orderxq.orderid)查询数据方法
     */
    List<Orderxq> queryByorderid(int orderid);
    /**
     * 根据主键orderxqid(Orderxq.orderxqid)查询单条数据方法
     */
    Orderxq queryById(int id);

    /**
     * 根据Orderxq条件查询多条数据方法
     */
    List<Orderxq> query(Orderxq orderxq);

    /**
     * 根据Orderxq条件模糊查询多条数据方法
     */
    List<Orderxq> queryLike(Orderxq orderxq);

    /**
     * 根据Orderxq插入数据方法
     */
    int insert(Orderxq orderxq);
    /**
     * 根据Orderxq条件修改单条数据方法,从传入对象获取id
     */
    int updateById(Orderxq orderxq);
    /**
     * 根据Orderxq条件删除单条数据方法,从传入对象获取id
     */
    int deleteById(int id);
    /*查看用户订单详情*/
    List<Orderxq> xiangqing(Orders orders);
}
