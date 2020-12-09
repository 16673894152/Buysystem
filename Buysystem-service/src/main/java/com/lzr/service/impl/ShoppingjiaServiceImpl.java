package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.ShoppingjiaMapping;
import com.lzr.service.ShoppingjiaService;
import com.lzr.vo.PageVo;
import com.lzr.vo.Shoppingjia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingjiaServiceImpl implements ShoppingjiaService {
     @Autowired
    ShoppingjiaMapping shoppingjiaMapping;


    @Override
    public PageVo<Shoppingjia> queryLike(Shoppingjia shoppingjia, int page, int rows) {
        PageVo<Shoppingjia> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(shoppingjiaMapping.queryLike(shoppingjia));
        //获取总的记录数量
        pageVo.setTotal(shoppingjiaMapping.queryLike(shoppingjia).size());

        return pageVo;
    }

    @Override
    public List<Shoppingjia> queryAll() {
        return shoppingjiaMapping.queryAll();
    }

    @Override
    public Shoppingjia queryById(int id) {
        return shoppingjiaMapping.queryById(id);
    }

    @Override
    public List<Shoppingjia> queryByuserid(int userid) {
        return shoppingjiaMapping.queryByuserid(userid);
    }

    @Override
    public List<Shoppingjia> queryByshopid(int shopid) {
        return shoppingjiaMapping.queryByshopid(shopid);
    }

    @Override
    public List<Shoppingjia> query(Shoppingjia shoppingjia) {
        return shoppingjiaMapping.query(shoppingjia);
    }

    @Override
    public int insert(Shoppingjia shoppingjia) {
        return shoppingjiaMapping.insert(shoppingjia);
    }

    @Override
    public int updateById(Shoppingjia shoppingjia) {
        return shoppingjiaMapping.updateById(shoppingjia);
    }

    @Override
    public int deleteById(int id) {
        return shoppingjiaMapping.deleteById(id);
    }
}
