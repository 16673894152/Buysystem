package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.ShopputMapping;
import com.lzr.service.ShopputService;
import com.lzr.vo.PageVo;
import com.lzr.vo.Shopput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopputServiceImpl implements ShopputService {
     @Autowired
     ShopputMapping shopputMapping;

    @Override
    public List<Shopput> queryAll() {
        return shopputMapping.queryAll();
    }

    @Override
    public List<Shopput> queryDistilled() {
        return shopputMapping.queryDistilled();
    }

    @Override
    public List<Shopput> queryLike(Shopput shopput) {
        return shopputMapping.queryLike(shopput);
    }

    @Override
    public Shopput queryById(int id) {
        return shopputMapping.queryById(id);
    }

    @Override
    public List<Shopput> query(Shopput shopput) {
        return shopputMapping.query(shopput);
    }

    @Override
    public int insert(Shopput shopput) {
        return shopputMapping.insert(shopput);
    }

    @Override
    public int updateById(Shopput shopput) {
        return shopputMapping.updateById(shopput);
    }

    @Override
    public int deleteById(int id) {
        return shopputMapping.deleteById(id);
    }

    @Override
    public PageVo<Shopput> queryLike(Shopput shopput, int page, int rows) {
        PageVo<Shopput> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(shopputMapping.queryLike(shopput));
        //获取总的记录数量
        pageVo.setTotal(shopputMapping.queryLike(shopput).size());

        return pageVo;
    }
}
