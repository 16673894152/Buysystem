package com.lzr.control;

import com.lzr.service.ShopService;
import com.lzr.vo.PageVo;
import com.lzr.vo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @RequestMapping("/editshop.action")
    @ResponseBody
    public Map editshop(Shop shop) {
        System.out.println(shop+"添加或编辑的商品"+shop);
        Map<String, String> map = new HashMap<String, String>();
        if(shop.getShopid()==null){//wareshop
            int num = shopService.insert(shop);
            if (num > 0) {
                map.put("msg", "添加成功");
            } else {
                map.put("msg", "添加失败");
            }
        }else if(shop.getShopid()!=null) {//修改
            int num = shopService.updateById(shop);
            if (num > 0) {
                map.put("msg", "修改成功");
            } else {
                map.put("msg", "修改失败");
            }
        }
        return map;
    }

    @RequestMapping("/delshop.action")
    @ResponseBody
    public Map delshop(Shop shop) {
        Shop shop1=new Shop();
        //测试
        shop1.setShopid(1);
        shop1.setIsdelete(0);

        Map<String, String> map = new HashMap<String, String>();
        int num = shopService.updateById(shop1);
        if (num > 0) {
            map.put("msg", "删除成功");
        } else {
            map.put("msg", "删除失败");
        }
        return map;
    }
    @RequestMapping("/querylike.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Shop> querylike(Shop shop,
                                       @RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "rows", defaultValue = "5") int rows) {
        System.out.println(shop);
        return shopService.queryLike(shop, page, rows);
    }
}
