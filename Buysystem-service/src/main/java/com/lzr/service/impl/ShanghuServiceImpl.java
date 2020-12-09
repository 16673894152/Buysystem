package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.ShanghuMapping;
import com.lzr.service.ShanghuService;
import com.lzr.vo.PageVo;
import com.lzr.vo.Shanghu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShanghuServiceImpl implements ShanghuService {
     @Autowired
     ShanghuMapping shanghuMapping;

    @Override
    public List<Shanghu> queryAll() {
        return shanghuMapping.queryAll();
    }

    @Override
    public Shanghu queryById(int id) {
        return shanghuMapping.queryById(id);
    }

    @Override
    public List<Shanghu> query(Shanghu shanghu) {
        return shanghuMapping.query(shanghu);
    }

    @Override
    public PageVo<Shanghu> queryLike(Shanghu shanghu, int page, int rows) {
        PageVo<Shanghu> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(shanghuMapping.queryLike(shanghu));
        //获取总的记录数量
        pageVo.setTotal(shanghuMapping.queryLike(shanghu).size());

        return pageVo;
    }
    @Override
    public int insert(Shanghu shanghu) {
        return shanghuMapping.insert(shanghu);
    }

    @Override
    public int updateById(Shanghu shanghu) {
        return shanghuMapping.updateById(shanghu);
    }

    @Override
    public int deleteById(int id) {
        return shanghuMapping.deleteById(id);
    }
}
