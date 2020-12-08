package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.EmployMapping;
import com.lzr.service.EmployService;
import com.lzr.vo.Employ;
import com.lzr.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements EmployService {
     @Autowired
     EmployMapping employMapping;

    @Override
    public List<Employ> queryAll() {
        return employMapping.queryAll();
    }

    @Override
    public Employ queryById(int id) {
        return employMapping.queryById(id);
    }

    @Override
    public List<Employ> query(Employ employ) {
        return employMapping.query(employ);
    }

    @Override
    public PageVo<Employ> queryLike(Employ employ, int page, int rows) {
        PageVo<Employ> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(employMapping.queryLike(employ));
        //获取总的记录数量
        pageVo.setTotal(employMapping.queryLike(employ).size());

        return pageVo;
    }
    @Override
    public int insert(Employ employ) {
        return employMapping.insert(employ);
    }

    @Override
    public int updateById(Employ employ) {
        return employMapping.updateById(employ);
    }
}
