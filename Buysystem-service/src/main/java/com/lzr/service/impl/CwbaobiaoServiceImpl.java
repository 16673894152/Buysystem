package com.lzr.service.impl;



import com.github.pagehelper.PageHelper;
import com.lzr.dao.CwbaobiaoMapping;
import com.lzr.service.CwbaobiaoService;
import com.lzr.vo.Cwbaobiao;
import com.lzr.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CwbaobiaoServiceImpl implements CwbaobiaoService {
     @Autowired
     CwbaobiaoMapping cwbaobiaoMapping;


    @Override
    public List<Cwbaobiao> queryAll() {
        return cwbaobiaoMapping.queryAll();
    }

    @Override
    public Cwbaobiao queryById(int id) {
        return cwbaobiaoMapping.queryById(id);
    }

    @Override
    public List<Cwbaobiao> query(Cwbaobiao cwbaobiao) {
        return cwbaobiaoMapping.query(cwbaobiao);
    }

    @Override
    public PageVo<Cwbaobiao> queryLike(Cwbaobiao cwbaobiao, int page, int rows) {
        PageVo<Cwbaobiao> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(cwbaobiaoMapping.queryLike(cwbaobiao));
        //获取总的记录数量
        pageVo.setTotal(cwbaobiaoMapping.queryLike(cwbaobiao).size());

        return pageVo;
    }

    @Override
    public int insert(Cwbaobiao cwbaobiao) {
        return cwbaobiaoMapping.insert(cwbaobiao);
    }

    @Override
    public int deleteById(int id) {
        return cwbaobiaoMapping.deleteById(id);
    }
}
