package com.lzr.control;

import com.lzr.service.ShopputService;
import com.lzr.vo.*;
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

    /*后台查询上架商品数据展示*/
    @RequestMapping("/queryLikehoutai.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Shopput> queryLikehoutai(Shopput shopput,
                                           @RequestParam(value = "page", defaultValue = "1") int page,
                                           @RequestParam(value = "rows", defaultValue = "5") int rows) {
        return shopputService.queryLikehoutai(shopput, page, rows);
    }

    @RequestMapping("/delshopput.action")
    @ResponseBody
    @CrossOrigin
    public Map delshop(Shopput shopput) {
        shopput.setIsdelete(0);
        Map<String, String> map = new HashMap<String, String>();
        int num = shopputService.updateById(shopput);
        if (num > 0) {
            map.put("msg", "下架成功");
        } else {
            map.put("msg", "下架失败");
        }
        return map;
    }

    @RequestMapping("/addshopput.action")
    @CrossOrigin
    @ResponseBody
    public Map addshopput(String shopids, String shopputprice, String shopputzhekou) {
        Map<String, String> map = new HashMap<String, String>();
        String[] shopidss = shopids.split(",");
        String[] shopputpricess = shopputprice.split(",");
        String[] shopputzhekouss = shopputzhekou.split(",");
        int num = 1;
        /**************************************************/
        for (int i = 0; i <= shopidss.length - 1; i++) {
            Shopput shopput=new Shopput();
            Shop shop=new Shop();
            shop.setShopid(Integer.parseInt(shopidss[i]));
            shopput.setShopid(shop);
            shopput.setShopputprice(Double.valueOf(shopputpricess[i]));
            shopput.setShopzhe(Double.valueOf(shopputzhekouss[i]));
            shopput.setIsdelete(1);
             num = shopputService.insert(shopput);
        }
        if (1 > 0) {
            map.put("msg", "上架成功");
        } else {
            map.put("msg", "上架失败");
        }
        return map;
    }

    @RequestMapping("/editshopput.action")
    @CrossOrigin
    @ResponseBody
    public Map editshopput(Shopput shopput) {
        Map<String, String> map = new HashMap<String, String>();
        System.out.println("编辑或添加的商品" + shopput);
        int num = shopputService.updateById(shopput);
        if (num > 0) {
            map.put("msg", "修改成功");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }
}
