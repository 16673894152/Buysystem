package com.lzr.control;

import com.lzr.service.ShopputService;
import com.lzr.vo.Shopput;
import com.lzr.vo.Shoptype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/shopput")
public class ShopputController {

    @Autowired
    ShopputService shopputService;

    @RequestMapping("/querydistilled.action")
    @ResponseBody
    public List<Shopput> queryDistilled() {
        return shopputService.queryDistilled();
    }

    @RequestMapping("/querylike.action")
    @ResponseBody
    public List<Shopput> queryLike(Shopput shopput) {
        System.out.println(shopput);
        return shopputService.queryLike(shopput);
    }
}
