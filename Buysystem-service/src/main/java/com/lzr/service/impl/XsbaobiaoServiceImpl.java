package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.XsbaobiaoMapping;
import com.lzr.service.XsbaobiaoService;
import com.lzr.vo.PageVo;
import com.lzr.vo.Xsbaobiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XsbaobiaoServiceImpl implements XsbaobiaoService {
     @Autowired
     XsbaobiaoMapping xsbaobiaoMapping;


    @Override
    public List<Xsbaobiao> queryAll() {
        return xsbaobiaoMapping.queryAll();
    }

    @Override
    public Xsbaobiao queryById(int id) {
        return xsbaobiaoMapping.queryById(id);
    }

    @Override
    public List<Xsbaobiao> query(Xsbaobiao xsbaobiao) {
        return xsbaobiaoMapping.query(xsbaobiao);
    }

    @Override
    public PageVo<Xsbaobiao> queryLike(Xsbaobiao xsbaobiao, int page, int rows) {
        PageVo<Xsbaobiao> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(xsbaobiaoMapping.queryLike(xsbaobiao));
        //获取总的记录数量
        pageVo.setTotal(xsbaobiaoMapping.queryLike(xsbaobiao).size());

        return pageVo;
    }

    @Override
    public int insert(Xsbaobiao xsbaobiao) {
        return xsbaobiaoMapping.insert(xsbaobiao);
    }

    @Override
    public int deleteById(int id) {
        return xsbaobiaoMapping.deleteById(id);
    }
}
