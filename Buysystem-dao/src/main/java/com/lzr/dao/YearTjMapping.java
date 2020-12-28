package com.lzr.dao;
import com.lzr.vo.YearTj;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YearTjMapping {


  /**
   * 查询收入和支出方法数据
   */
  List<YearTj> queryShouru(YearTj yearTj);

  List<YearTj> queryZhichu(YearTj yearTj);

  List<YearTj> queryXiaoshou(YearTj yearTj);
}