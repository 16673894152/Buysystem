package com.lzr.control;

import com.lzr.service.GouwuaddressService;
import com.lzr.vo.Gouwuaddress;
import com.lzr.vo.Shopgouwu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

}
