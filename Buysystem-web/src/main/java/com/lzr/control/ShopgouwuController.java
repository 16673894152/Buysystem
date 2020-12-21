package com.lzr.control;


import com.lzr.service.ShopgouwuService;
import com.lzr.vo.PageVo;
import com.lzr.vo.Shopgouwu;
import com.lzr.vo.Shopput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/shopcard")
public class ShopgouwuController {

    @Autowired
    ShopgouwuService shopgouwuService;

    @RequestMapping("/queryByuserid.action")
    @ResponseBody
    public List<Shopgouwu> queryByuserid(int userid) {
        System.out.println(userid);
        return shopgouwuService.queryByuserid(userid);
    }

    @RequestMapping("/querylike.action")
    @ResponseBody
    public PageVo<Shopgouwu> queryLike(Shopgouwu shopgouwu,
                                       @RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "rows", defaultValue = "5") int rows) {
        System.out.println(shopgouwu);
        return  shopgouwuService.queryLike(shopgouwu,page,rows);
    }

}
