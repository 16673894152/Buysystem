package com.lzr.control;

import com.lzr.service.ShopxqService;
import com.lzr.vo.Shopxq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shopxq")
public class ShopxqController {


    @Autowired
    ShopxqService shopxqService;

    @RequestMapping("/editshopxq.action")
    @ResponseBody
    public Map editshopxq(Shopxq shopxq) {
        System.out.println(shopxq+"添加或编辑的商品详情"+shopxq);
        Map<String, String> map = new HashMap<String, String>();
        if(shopxq.getShopxqid()==null){//wareshop
            int num = shopxqService.insert(shopxq);
            if (num > 0) {
                map.put("msg", "添加成功");
            } else {
                map.put("msg", "添加失败");
            }
        }else if(shopxq.getShopxqid()!=null) {//修改
            int num = shopxqService.updateById(shopxq);
            if (num > 0) {
                map.put("msg", "修改成功");
            } else {
                map.put("msg", "修改失败");
            }
        }
        return map;
    }

    @RequestMapping("/delshopxq.action")
    @ResponseBody
    public Map delshopxq(int shopid) {
        shopid=1;

        Map<String, String> map = new HashMap<String, String>();
        int num = shopxqService.deleteById(shopid);
        if (num > 0) {
            map.put("msg", "删除成功");
        } else {
            map.put("msg", "删除失败");
        }
        return map;
    }

    @RequestMapping("/queryall.action")
    @ResponseBody
    public List<Shopxq> queryall() {
        return shopxqService.queryAll();
    }

}