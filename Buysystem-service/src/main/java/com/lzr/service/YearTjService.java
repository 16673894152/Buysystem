package com.lzr.service;

import com.lzr.vo.Cwbaobiao;
import com.lzr.vo.PageVo;
import com.lzr.vo.YearTj;
import org.springframework.stereotype.Repository;

import java.util.List;

//** custom import **//
  //在这里写你的自定义代码导入的包,每次生成.java文件都会保留这一段代码

//** /custom import **//

@Repository
public interface YearTjService {

  YearTj queryBaobiao(YearTj yearTj);

  YearTj queryXiaoshou(YearTj yearTj);

  YearTj queryShshrs(YearTj yearTj);
}