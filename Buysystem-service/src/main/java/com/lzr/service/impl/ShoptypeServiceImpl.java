package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.ShoptypeMapping;
import com.lzr.service.ShoptypeService;
import com.lzr.vo.PageVo;
import com.lzr.vo.Shop;
import com.lzr.vo.Shoptype;
import com.lzr.vo.Warehouse;
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
    public PageVo<Shoptype> queryLike(Shoptype shoptype, int page, int rows) {
        PageVo<Shoptype> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(shoptypeMapping.queryLike(shoptype));
        //获取总的记录数量
        pageVo.setTotal(shoptypeMapping.queryLike(shoptype).size());
        /**/
        List<Shoptype> list=shoptypeMapping.querycount();
        for (Shoptype shoptype1: pageVo.getRows()){
            for(Shoptype shoptype2:list){
                if(shoptype1.getShoptyid() == shoptype2.getShoptyid()){
                    shoptype1.setCount(shoptype2.getCount());
                }
            }
        }
        return pageVo;
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
