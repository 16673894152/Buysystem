package com.lzr.dao;

import com.lzr.vo.Tongji;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TongjiMapping {
  List<Tongji> querybaobiao1(Tongji tongji);
  List<Tongji> querycwbaobiao2(Tongji tongji);
  List<Tongji> queryxsbaobiao2(Tongji tongji);
}