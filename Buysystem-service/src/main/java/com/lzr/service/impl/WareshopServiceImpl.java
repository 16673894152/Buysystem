package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.EmployMapping;
import com.lzr.dao.WareshopMapping;
import com.lzr.service.EmployService;
import com.lzr.service.WareshopService;
import com.lzr.vo.Employ;
import com.lzr.vo.PageVo;
import com.lzr.vo.Wareshop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WareshopServiceImpl implements WareshopService {
     @Autowired
     WareshopMapping wareshopMapping;

    @Override
    public List<Wareshop> queryAll() {
        return wareshopMapping.queryAll();
    }

    @Override
    public Wareshop queryById(int id) {
        return wareshopMapping.queryById(id);
    }

    @Override
    public List<Wareshop> query(Wareshop wareshop) {
        return wareshopMapping.query(wareshop);
    }

    @Override
    public PageVo<Wareshop> queryLike(Wareshop wareshop, int page, int rows) {
        PageVo<Wareshop> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(wareshopMapping.queryLike(wareshop));
        //获取总的记录数量
        pageVo.setTotal(wareshopMapping.queryLike(wareshop).size());

        return pageVo;
    }

    @Override
    public int insert(Wareshop wareshop) {
        return wareshopMapping.insert(wareshop);
    }

    @Override
    public int updateById(Wareshop wareshop) {
        return wareshopMapping.updateById(wareshop);
    }

    @Override
    public int deleteById(int id) {
        return wareshopMapping.deleteById(id);
    }
}
