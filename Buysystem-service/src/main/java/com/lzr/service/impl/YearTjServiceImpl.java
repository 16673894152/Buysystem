package com.lzr.service.impl;


import com.lzr.dao.YearTjMapping;
import com.lzr.service.YearTjService;
import com.lzr.vo.YearTj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YearTjServiceImpl implements YearTjService {
    @Autowired
    YearTjMapping yearTjMapping;


    @Override
    public YearTj queryBaobiao(YearTj yearTj) {
        YearTj yearTj1 = new YearTj();
        List<YearTj> queryShouru = yearTjMapping.queryShouru(yearTj);
        List<YearTj> queryZhichu = yearTjMapping.queryZhichu(yearTj);
        yearTj1.setZhichus(queryZhichu);
        yearTj1.setShourus(queryShouru);
        return yearTj1;
    }

    @Override
    public YearTj queryXiaoshou(YearTj yearTj) {
        YearTj yearTj1 = new YearTj();
        List<YearTj> queryXiaoshou = yearTjMapping.queryXiaoshou(yearTj);
        yearTj1.setXiaoshous(queryXiaoshou);
        return yearTj1;
    }
}
