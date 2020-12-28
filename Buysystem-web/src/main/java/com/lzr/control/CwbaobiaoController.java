package com.lzr.control;

import com.lzr.service.CkbaobiaoService;
import com.lzr.service.CwbaobiaoService;
import com.lzr.service.TongjiService;
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
@RequestMapping("/cwbaobiao")
public class CwbaobiaoController {

    @Autowired
    CwbaobiaoService cwbaobiaoService;
    @Autowired
    YearTjService yearTjService;
    @Autowired
    TongjiService tongjiService;


    @RequestMapping("/querycwbaobiao1.action")
    @CrossOrigin
    @ResponseBody
    public YearTj queryckbaobiao2(YearTj yearTj) {
        return yearTjService.queryBaobiao(yearTj);
    }
    @RequestMapping("/querycwbaobiao2.action")
    @CrossOrigin
    @ResponseBody
    public List<Tongji> querycwbaobiao2(Tongji tongji) {
        List<Tongji> tongjis = tongjiService.querycwbaobiao2(tongji);
        return tongjis;
    }
    @RequestMapping("/querycwbaobiao3.action")
    @CrossOrigin
    @ResponseBody
    public PageVo<Cwbaobiao> querycwbaobiao3(Cwbaobiao cwbaobiao,
                                             @RequestParam(value = "page", defaultValue = "1") int page,
                                             @RequestParam(value = "rows", defaultValue = "5") int rows) {
        return cwbaobiaoService.querycwbaobiao3(cwbaobiao, page, rows);
    }
}