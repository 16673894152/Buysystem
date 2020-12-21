package com.lzr.control;

import com.lzr.service.ShopService;
import com.lzr.utils.FileUpLoadUtil;
import com.lzr.vo.Message;
import com.lzr.vo.PageVo;
import com.lzr.vo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @RequestMapping("/editshop.action")
    @CrossOrigin
    @ResponseBody
    public Map editshop(Shop shop) {
        Map<String, String> map = new HashMap<String, String>();
        System.out.println(
                "编辑或添加的商品"+shop
        );
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
    @CrossOrigin
    public Map delshop(Shop shop) {
        System.out.println(shop+"删除shop");
        shop.setIsdelete(0);
        Map<String, String> map = new HashMap<String, String>();
        int num = shopService.updateById(shop);
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
        shop.setMinprice(0);
        shop.setMaxprice(10000);
        return shopService.queryLike(shop, page, rows);
    }
}
