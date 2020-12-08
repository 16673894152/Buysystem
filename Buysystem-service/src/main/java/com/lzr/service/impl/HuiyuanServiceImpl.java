package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.EmployMapping;
import com.lzr.dao.HuiyuanMapping;
import com.lzr.service.EmployService;
import com.lzr.service.HuiyuanService;
import com.lzr.vo.Employ;
import com.lzr.vo.Huiyuan;
import com.lzr.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuiyuanServiceImpl implements HuiyuanService {
     @Autowired
     HuiyuanMapping huiyuanMapping;

    @Override
    public List<Huiyuan> queryAll() {
        return huiyuanMapping.queryAll();
    }

    @Override
    public Huiyuan queryById(int id) {
        return huiyuanMapping.queryById(id);
    }

    @Override
    public List<Huiyuan> query(Huiyuan huiyuan) {
        return huiyuanMapping.query(huiyuan);
    }

    @Override
    public List<Huiyuan> queryLike(Huiyuan huiyuan) {
        return huiyuanMapping.queryLike(huiyuan);
    }

    @Override
    public int insert(Huiyuan huiyuan) {
        return huiyuanMapping.insert(huiyuan);
    }

    @Override
    public int updateById(Huiyuan huiyuan) {
        return huiyuanMapping.updateById(huiyuan);
    }

    @Override
    public int deleteById(int id) {
        return huiyuanMapping.deleteById(id);
    }
}
