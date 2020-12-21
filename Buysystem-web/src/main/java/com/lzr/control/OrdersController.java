package com.lzr.control;
import com.lzr.service.OrdersService;
import com.lzr.vo.Orders;
import com.lzr.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;
    @RequestMapping("/querylike.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Orders> querylike(Orders orders,
                                    @RequestParam(value = "page", defaultValue = "1") int page,
                                    @RequestParam(value = "rows", defaultValue = "5") int rows) {
        return ordersService.queryLike(orders, page, rows);
    }
}
