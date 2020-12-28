package com.lzr.service.impl;
import com.lzr.dao.TongjiMapping;
import com.lzr.service.TongjiService;
import com.lzr.vo.Tongji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TongjiServiceImpl implements TongjiService {

    @Autowired
    TongjiMapping tongjiMapping;

    @Override
    public List<Tongji> querybaobiao1(Tongji tongji) {
        return tongjiMapping.querybaobiao1(tongji);
    }

    @Override
    public List<Tongji> querycwbaobiao2(Tongji tongji) {
        return tongjiMapping.querycwbaobiao2(tongji);
    }

    @Override
    public List<Tongji> queryxsbaobiao2(Tongji tongji) {
        return tongjiMapping.queryxsbaobiao2(tongji);
    }
}