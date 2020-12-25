package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.ShopgouwuMapping;
import com.lzr.service.ShopgouwuService;
import com.lzr.vo.PageVo;
import com.lzr.vo.Shopgouwu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopgouwuServiceImpl implements ShopgouwuService {
     @Autowired
     ShopgouwuMapping shopgouwuMapping;


    @Override
    public PageVo<Shopgouwu> queryLike(Shopgouwu shopgouwu, int page, int rows) {
        PageVo<Shopgouwu> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(shopgouwuMapping.queryLike(shopgouwu));
        //获取总的记录数量
        pageVo.setTotal(shopgouwuMapping.queryLike(shopgouwu).size());

        return pageVo;
    }

    @Override
    public List<Shopgouwu> queryAll() {
        return shopgouwuMapping.queryAll();
    }

    @Override
    public List<Shopgouwu> queryByuserid(int userid) {
        return shopgouwuMapping.queryByuserid(userid);
    }

    @Override
    public Shopgouwu queryById(int id) {
        return shopgouwuMapping.queryById(id);
    }

    @Override
    public List<Shopgouwu> query(Shopgouwu shopgouwu) {
        return shopgouwuMapping.query(shopgouwu);
    }

    @Override
    public int insert(Shopgouwu shopgouwu) {
        return shopgouwuMapping.insert(shopgouwu);
    }

    @Override
    public int updateById(Shopgouwu shopgouwu) {
        return shopgouwuMapping.updateById(shopgouwu);
    }

    @Override
    public int deleteById(int id) {
        return shopgouwuMapping.deleteById(id);
    }

    @Override
    public int downNumerById(Shopgouwu shopgouwu) {
        return shopgouwuMapping.downNumerById(shopgouwu);
    }

    @Override
    public int upNumerById(Shopgouwu shopgouwu) {
        return shopgouwuMapping.upNumerById(shopgouwu);
    }
}
