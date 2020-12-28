package com.lzr.service;

import com.lzr.vo.Tongji;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TongjiService {
  List<Tongji> querybaobiao1(Tongji tongji);
  List<Tongji> querycwbaobiao2(Tongji tongji);
  List<Tongji> queryxsbaobiao2(Tongji tongji);
}