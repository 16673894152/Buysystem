package com.lzr.service.impl;

import com.lzr.dao.ShoptypeMapping;
import com.lzr.service.ShoptypeService;
import com.lzr.vo.Shoptype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoptypeServiceImpl implements ShoptypeService {
     @Autowired
     ShoptypeMapping shoptypeMapping;

    @Override
    public List<Shoptype> queryAll() {
        return shoptypeMapping.queryAll();
    }

    @Override
    public Shoptype queryById(int id) {
        return shoptypeMapping.queryById(id);
    }

    @Override
    public List<Shoptype> query(Shoptype shoptype) {
        return shoptypeMapping.query(shoptype);
    }

    @Override
    public List<Shoptype> queryLike(Shoptype shoptype) {
        return shoptypeMapping.queryLike(shoptype);
    }

    @Override
    public int insert(Shoptype shoptype) {
        return shoptypeMapping.insert(shoptype);
    }

    @Override
    public int updateById(Shoptype shoptype) {
        return shoptypeMapping.updateById(shoptype);
    }

    @Override
    public int deleteById(int id) {
        return shoptypeMapping.deleteById(id);
    }
}
