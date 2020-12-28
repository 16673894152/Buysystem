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
    /*
    * Gouwuaddress表 控制层
    * */
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
     * 用户添加购物地址
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

    /*
    * 清除选中的地址
    * */
    @RequestMapping("/clearDel.action")
    @ResponseBody
    public Map clearDel(Gouwuaddress gouwuaddress){
        Map<String,String> map =new HashMap<String,String>();
        System.out.println(gouwuaddress);
        int num = addressService.clearDelivery(gouwuaddress);
        if (num > 0) {
            map.put("msg", "修改成功");
            return map;
        } else {
            map.put("msg", "修改失败");
            return map;
        }
    }

    /*
    * 根据地址id选中一个地址
    * */
    @RequestMapping("/setDel.action")
    @ResponseBody
    public Map setDel(Gouwuaddress gouwuaddress){
        Map<String,String> map =new HashMap<String,String>();
        System.out.println(gouwuaddress);
        int num = addressService.setDelivery(gouwuaddress);
        if (num > 0) {
            map.put("msg", "修改成功");
            return map;
        } else {
            map.put("msg", "修改失败");
            return map;
        }
    }
}
