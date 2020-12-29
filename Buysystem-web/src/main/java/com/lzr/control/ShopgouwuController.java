package com.lzr.control;


import com.lzr.service.ShopgouwuService;
import com.lzr.vo.PageVo;
import com.lzr.vo.Shop;
import com.lzr.vo.Shopgouwu;
import com.lzr.vo.Shopput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/shopcard")
public class ShopgouwuController {

    @Autowired
    ShopgouwuService shopgouwuService;

    /*
    * 根据用户id查看购物车详情
    * */
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

    /*
    * 购物车添加商品
    * */
    @RequestMapping("/addshopgouwu.action")
    @ResponseBody
    @CrossOrigin
    public Map addShopgouwu(Shopgouwu shopgouwu){
        Map<String,String> map =new HashMap<String,String>();
        System.out.println(shopgouwu);
        int num = shopgouwuService.insert(shopgouwu);
        if (num > 0) {
            map.put("msg", "加入购物车");
            return map;
        } else {
            map.put("msg", "加入失败");
            return map;
        }
    }

    @RequestMapping("/editshopgouwu.action")
    @ResponseBody
    @CrossOrigin
    public Map editShopgouwu(Shopgouwu shopgouwu){
        Map<String,String> map =new HashMap<String,String>();
        System.out.println(shopgouwu);
        int num = shopgouwuService.updateById(shopgouwu);
        if (num > 0) {
            map.put("msg", "修改购物车");
            return map;
        } else {
            map.put("msg", "修改失败");
            return map;
        }
    }

    @RequestMapping("/query.action")
    @ResponseBody
    @CrossOrigin
    public List<Shopgouwu> query(Shopgouwu shopgouwu) {
        Map<String,Integer> map =new HashMap<String,Integer>();
        List<Shopgouwu> shopgouwu1 = shopgouwuService.query(shopgouwu);
        System.out.println(shopgouwu1);
        System.out.println("shopgouwu1.size() = " + shopgouwu1.size());


        map.put("size",shopgouwu1.size());
       // map.put("shopgwid",shopgouwu1[0].getShopgwid);
        return shopgouwu1;

    }

    /*
     * 购物车添加商品
     * */
    @RequestMapping("/upNumer.action")
    @ResponseBody
    @CrossOrigin
    public Map upNumerById(Shopgouwu shopgouwu){
        Map<String,String> map =new HashMap<String,String>();
        System.out.println(shopgouwu);
        int num = shopgouwuService.upNumerById(shopgouwu);
        if (num > 0) {
            map.put("msg", "添加成功");
            return map;
        } else {
            map.put("msg", "加入失败");
            return map;
        }
    }

    /*
     * 购物车添加商品
     * */

    @RequestMapping("/downNumer.action")
    @ResponseBody
    @CrossOrigin
    public Map downNumerById(Shopgouwu shopgouwu){
        Map<String,String> map =new HashMap<String,String>();
        System.out.println(shopgouwu);
        int num = shopgouwuService.downNumerById(shopgouwu);
        if (num > 0) {
            map.put("msg", "删除成功");
            return map;
        } else {
            map.put("msg", "加入失败");
            return map;
        }
    }
    /*
     * 用户提交订单后删除购物车
     * 根据userid删除购物车里面的订单
     * 提交订单时调用deleteByUserId(userid)方法即可
     * */

    @RequestMapping("/deletebyuserid.action")
    @ResponseBody
    @CrossOrigin
    public Map deletebyuserid(int userid){
        Map<String,String> map =new HashMap<String,String>();
        System.out.println(userid+"删除id");
        int num = shopgouwuService.deleteByUserId(userid);
        if (num > 0) {
            map.put("msg", "删除成功");
            return map;
        } else {
            map.put("msg", "加入失败");
            return map;
        }
    }
    /*
    * 删除购物车商品
    * */
    @RequestMapping("/delById.action")
    @ResponseBody
    @CrossOrigin
    public Map deleteById(Integer id){
        Map<String,String> map =new HashMap<String,String>();
        System.out.println(id);
        int num = shopgouwuService.deleteById(id);
        if (num > 0) {
            map.put("msg", "删除成功");
            return map;
        } else {
            map.put("msg", "加入失败");
            return map;
        }
    }
}
