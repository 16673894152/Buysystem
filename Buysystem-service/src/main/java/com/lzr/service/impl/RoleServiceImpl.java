package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.EmployMapping;
import com.lzr.dao.RoleInfoMapping;
import com.lzr.service.EmployService;
import com.lzr.service.RoleService;
import com.lzr.vo.Employ;
import com.lzr.vo.PageVo;
import com.lzr.vo.RoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
     @Autowired
     RoleInfoMapping roleInfoMapping;

    @Override
    public PageVo<RoleInfo> queryLike(RoleInfo roleInfo, int page, int rows) {
        PageVo<RoleInfo> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(roleInfoMapping.queryLike(roleInfo));
        //获取总的记录数量
        pageVo.setTotal(roleInfoMapping.queryLike(roleInfo).size());
        return pageVo;
    }

    @Override
    public List<RoleInfo> queryAll() {
        return roleInfoMapping.queryAll();
    }

    @Override
    public RoleInfo queryById(int id) {
        return roleInfoMapping.queryById(id);
    }

    @Override
    public List<RoleInfo> query(RoleInfo roleinfo) {
        return roleInfoMapping.query(roleinfo);
    }

    @Override
    public int insert(RoleInfo roleinfo) {
        return roleInfoMapping.insert(roleinfo);
    }

    @Override
    public int updateById(RoleInfo roleinfo) {
        return 0;
    }

}
