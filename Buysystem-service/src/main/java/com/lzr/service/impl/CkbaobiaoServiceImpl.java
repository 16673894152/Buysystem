package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.CkbaobiaoMapping;
import com.lzr.dao.TongjiMapping;
import com.lzr.service.CkbaobiaoService;
import com.lzr.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CkbaobiaoServiceImpl implements CkbaobiaoService {
     @Autowired
     CkbaobiaoMapping ckbaobiaoMapping;
     @Autowired
    TongjiMapping tongjiMapping;

    @Override
    public List<Ckbaobiao> queryAll() {
        return ckbaobiaoMapping.queryAll();
    }

    @Override
    public Ckbaobiao queryById(int id) {
        return ckbaobiaoMapping.queryById(id);
    }

    @Override
    public List<Ckbaobiao> query(Ckbaobiao ckbaobiao) {
        return ckbaobiaoMapping.query(ckbaobiao);
    }

    @Override
    public PageVo<Ckbaobiao> queryLike(Ckbaobiao ckbaobiao, int page, int rows) {
        PageVo<Ckbaobiao> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(ckbaobiaoMapping.queryLike(ckbaobiao));
        //获取总的记录数量
        pageVo.setTotal(ckbaobiaoMapping.queryLike(ckbaobiao).size());

        return pageVo;
    }

    @Override
    public int insert(Ckbaobiao ckbaobiao) {
        return ckbaobiaoMapping.insert(ckbaobiao);
    }

    @Override
    public int deleteById(int id) {
        return ckbaobiaoMapping.deleteById(id);
    }
    @Override
    public PageVo<Ckbaobiao> querybaobiao2(Ckbaobiao ckbaobiao, int page, int rows) {
        PageVo<Ckbaobiao> pageVo=new PageVo<>();
        List<Ckbaobiao> employList=ckbaobiaoMapping.querybaobiao2(ckbaobiao);
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(ckbaobiaoMapping.querybaobiao2(ckbaobiao));
        //获取总的记录数量
        pageVo.setTotal(ckbaobiaoMapping.querybaobiao2(ckbaobiao).size());

        return pageVo;
    }
}