package com.lzr.service;

import com.lzr.vo.EmployroleInfo;
import com.lzr.vo.PageVo;
import com.lzr.vo.RoleInfo;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployroleService {
    int insert(EmployroleInfo employroleInfo);
    int deleteByempid(int empid);
}