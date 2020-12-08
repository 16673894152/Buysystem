package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.ShopMapping;
import com.lzr.dao.ShopxqMapping;
import com.lzr.service.ShopService;
import com.lzr.service.ShopxqService;
import com.lzr.vo.Employ;
import com.lzr.vo.PageVo;
import com.lzr.vo.Shop;
import com.lzr.vo.Shopxq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
     @Autowired
     ShopMapping shopMapping;

    @Override
    public PageVo<Shop> queryLike(Shop shop, int page, int rows) {
        PageVo<Shop> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(shopMapping.queryLike(shop));
        //获取总的记录数量
        pageVo.setTotal(shopMapping.queryLike(shop).size());
        return pageVo;
    }

    @Override
    public List<Shop> queryAll() {
        return shopMapping.queryAll();
    }

    @Override
    public Shop queryById(int id) {
        return shopMapping.queryById(id);
    }

    @Override
    public List<Shop> query(Shop shop) {
        return shopMapping.query(shop);
    }

    @Override
    public int insert(Shop shop) {
        return shopMapping.insert(shop);
    }

    @Override
    public int updateById(Shop shop) {
        return shopMapping.updateById(shop);
    }

    @Override
    public int deleteById(int id) {
        return shopMapping.deleteById(id);
    }
}
