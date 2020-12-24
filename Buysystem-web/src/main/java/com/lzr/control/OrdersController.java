package com.lzr.control;
import com.alibaba.fastjson.JSONObject;
import com.lzr.service.OrdersService;
import com.lzr.service.UserService;
import com.lzr.vo.Orders;
import com.lzr.vo.Orderxq;
import com.lzr.vo.PageVo;
import com.lzr.vo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;
    @Autowired
    UserService userService;

    @RequestMapping("/querylike.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Orders> querylike(Orders orders,
                                    @RequestParam(value = "page", defaultValue = "1") int page,
                                    @RequestParam(value = "rows", defaultValue = "5") int rows) {
        return ordersService.queryLike(orders, page, rows);
    }

    @RequestMapping("/querylikept.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Orders> querylikept(Orders orders, String time,
                                      @RequestParam(value = "page", defaultValue = "1") int page,
                                      @RequestParam(value = "rows", defaultValue = "5") int rows) {
        String starttime1 = "";
        String endtime1 = "";
        if (time != "") {
            //如果不等于空
            String[] shopids = time.split(",");
            //拿时间
            String starttime = shopids[0];
            String endtime = shopids[1];
            //转值
            starttime = starttime.replace("GMT", "").replaceAll("\\(.*\\)", "");
            endtime = endtime.replace("GMT", "").replaceAll("\\(.*\\)", "");
            //将字符串转化为date类型，格式2016-10-12
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z", Locale.ENGLISH);
            Date dateTrans = null;
            Date dateTrans1 = null;
            try {
                dateTrans = format.parse(starttime);
                dateTrans1 = format.parse(endtime);
                starttime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTrans).replace("-", "-");
                endtime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTrans1).replace("-", "-");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        orders.setStarttime(starttime1);
        orders.setEndtime(endtime1);
        if (starttime1 != "") {
        } else {
            orders.setStarttime("");
        }
        return ordersService.queryLikept(orders, page, rows);
    }

    @RequestMapping("/querylike1.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Orders> querylike1(Orders orders,
                                     @RequestParam(value = "page", defaultValue = "1") int page,
                                     @RequestParam(value = "rows", defaultValue = "5") int rows) {
        System.out.println(ordersService.queryLike1(orders, page, rows));
        return ordersService.queryLike1(orders, page, rows);
    }

    @RequestMapping("/querylikept1.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Orders> querylikept1(Orders orders, String time,
                                      @RequestParam(value = "page", defaultValue = "1") int page,
                                      @RequestParam(value = "rows", defaultValue = "5") int rows) {
        String starttime1 = "";
        String endtime1 = "";
        if (time != "") {
            //如果不等于空
            String[] shopids = time.split(",");
            //拿时间
            String starttime = shopids[0];
            String endtime = shopids[1];
            //转值
            starttime = starttime.replace("GMT", "").replaceAll("\\(.*\\)", "");
            endtime = endtime.replace("GMT", "").replaceAll("\\(.*\\)", "");
            //将字符串转化为date类型，格式2016-10-12
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z", Locale.ENGLISH);
            Date dateTrans = null;
            Date dateTrans1 = null;
            try {
                dateTrans = format.parse(starttime);
                dateTrans1 = format.parse(endtime);
                starttime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTrans).replace("-", "-");
                endtime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTrans1).replace("-", "-");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        orders.setStarttime(starttime1);
        orders.setEndtime(endtime1);
        if (starttime1 != "") {
        } else {
            orders.setStarttime("");
        }
        return ordersService.queryLikept1(orders, page, rows);
    }

    @RequestMapping("/shouhuo.action")
    @ResponseBody
    @CrossOrigin
    public String shouhuo(Orders orders) {
        ordersService.updateshouhuo(orders);
        return "成功";
    }

    @RequestMapping("/tihuo.action")
    @ResponseBody
    @CrossOrigin
    public String tihuo(Orders orders) {
        int userid=orders.getShid().getUserid();
        double shmoney=orders.getOrdermoney()/10;
        User user=new User();
        user.setUserid(userid);
        user.setShmoney(shmoney);
        userService.tihuosr(user);
        ordersService.updatetihuo(orders);
        return "成功";
    }
}
