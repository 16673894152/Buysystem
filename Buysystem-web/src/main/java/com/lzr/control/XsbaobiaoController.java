package com.lzr.control;

import com.lzr.service.CwbaobiaoService;
import com.lzr.service.TongjiService;
import com.lzr.service.XsbaobiaoService;
import com.lzr.service.YearTjService;
import com.lzr.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/xsbaobiao")
public class XsbaobiaoController {

    @Autowired
    YearTjService yearTjService;
    @Autowired
    TongjiService tongjiService;
    @Autowired
    XsbaobiaoService xsbaobiaoService;


    @RequestMapping("/queryxsbaobiao1.action")
    @CrossOrigin
    @ResponseBody
    public YearTj queryxsbaobiao1(YearTj yearTj) {
        return yearTjService.queryXiaoshou(yearTj);
    }

    @RequestMapping("/queryxsbaobiao2.action")
    @CrossOrigin
    @ResponseBody
    public List<Tongji> querycwbaobiao2(Tongji tongji) {
        List<Tongji> tongjis = tongjiService.queryxsbaobiao2(tongji);
        for (Tongji tongji1 : tongjis) {
            tongji1.setNames(tongji1.getNames());
        }
        return tongjis;
    }
    @RequestMapping("/queryxsbaobiao3.action")
    @CrossOrigin
    @ResponseBody
    public PageVo<Xsbaobiao> querycwbaobiao3(Xsbaobiao xsbaobiao,
                                             @RequestParam(value = "page", defaultValue = "1") int page,
                                             @RequestParam(value = "rows", defaultValue = "5") int rows) {
        return xsbaobiaoService.queryxsbaobiao3(xsbaobiao, page, rows);
    }
}