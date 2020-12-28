package com.lzr.control;

import com.lzr.service.GouwuaddressService;
import com.lzr.vo.Gouwuaddress;
import com.lzr.vo.Shopgouwu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/shopcardaddress")
public class GouwuaddressController {

    @Autowired
    GouwuaddressService addressService;

    /*
     * 根据用户id查看用户购物地址详情
     * */
    @RequestMapping("/queryByuserid.action")
    @ResponseBody
    public List<Gouwuaddress> queryByuserid(int userid) {
        System.out.println(userid);
        return addressService.queryById(userid);
    }

    /*
     * 购物车添加商品
     * */
    @RequestMapping("/insertAddress.action")
    @ResponseBody
    @CrossOrigin
    public Map insert(Gouwuaddress gouwuaddress){
        Map<String,String> map =new HashMap<String,String>();
        System.out.println(gouwuaddress);
        int num = addressService.insert(gouwuaddress);
        if (num > 0) {
            map.put("msg", "添加成功");
            return map;
        } else {
            map.put("msg", "加入失败");
            return map;
        }
    }

}
