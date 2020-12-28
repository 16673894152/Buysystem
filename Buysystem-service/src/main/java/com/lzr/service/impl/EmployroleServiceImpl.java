package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.CkbaobiaoMapping;
import com.lzr.dao.EmployroleInfoMapping;
import com.lzr.service.CkbaobiaoService;
import com.lzr.service.EmployroleService;
import com.lzr.vo.Ckbaobiao;
import com.lzr.vo.EmployroleInfo;
import com.lzr.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployroleServiceImpl implements EmployroleService {
    @Autowired
    EmployroleInfoMapping employroleInfoM;

    @Override
    public int insert(EmployroleInfo employroleInfo) {
        return employroleInfoM.insert(employroleInfo);
    }

    @Override
    public int deleteByempid(int empid) {
        return employroleInfoM.deleteByempid(empid);
    }
}
