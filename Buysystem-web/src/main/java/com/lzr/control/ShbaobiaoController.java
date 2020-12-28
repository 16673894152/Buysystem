package com.lzr.control;

import com.lzr.service.TongjiService;
import com.lzr.service.XsbaobiaoService;
import com.lzr.service.YearTjService;
import com.lzr.vo.YearTj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/shbaobiao")
public class ShbaobiaoController {

    @Autowired
    YearTjService yearTjService;

    @RequestMapping("/queryshbaobiao.action")
    @CrossOrigin
    @ResponseBody
    public YearTj queryxsbaobiao1(YearTj yearTj) {
        System.out.println(yearTj+"商户统计条件");
        return yearTjService.queryShshrs(yearTj);
    }
}