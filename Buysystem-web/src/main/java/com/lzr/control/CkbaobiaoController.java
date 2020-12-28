package com.lzr.control;

import com.lzr.service.CkbaobiaoService;
import com.lzr.service.EmployService;
import com.lzr.service.EmployroleService;
import com.lzr.service.TongjiService;
import com.lzr.vo.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ckbaobiao")
public class CkbaobiaoController {

    @Autowired
    CkbaobiaoService ckbaobiaoService;
    @Autowired
    TongjiService tongjiService;

    @RequestMapping("/queryckbaobiao2.action")
    @CrossOrigin
    @ResponseBody
    public PageVo<Ckbaobiao> queryckbaobiao2(Ckbaobiao ckbaobiao,
                                             @RequestParam(value = "page", defaultValue = "1") int page,
                                             @RequestParam(value = "rows", defaultValue = "5") int rows) {
        return ckbaobiaoService.querybaobiao2(ckbaobiao, page, rows);
    }

    @RequestMapping("/queryckbaobiao1.action")
    @CrossOrigin
    @ResponseBody
    public List<Tongji> queryckbaobiao1(Tongji tongji) {
        List<Tongji> tongjis = tongjiService.querybaobiao1(tongji);
        for (Tongji tongji1 : tongjis) {
            tongji1.setNames(tongji1.getNames());
        }
        return tongjis;
    }
}