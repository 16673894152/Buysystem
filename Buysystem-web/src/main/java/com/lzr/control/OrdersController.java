package com.lzr.control;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.lzr.config.AlipayConfig;
import com.lzr.service.OrderXqService;
import com.lzr.service.OrdersService;
import com.lzr.service.ShopgouwuService;
import com.lzr.service.UserService;
import com.lzr.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@CrossOrigin
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;
    @Autowired
    UserService userService;

    @Autowired
    ShopgouwuService shopgouwuService;

    @Autowired
    OrderXqService orderXqService;


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
        System.out.println(time + "时间");
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
        int userid = orders.getShid().getUserid();
        double shmoney = orders.getOrdermoney() / 10;
        User user = new User();
        user.setUserid(userid);
        user.setShmoney(shmoney);
        userService.tihuosr(user);
        ordersService.updatetihuo(orders);
        return "成功";
    }


    //点击付款按钮，接收付款金额，生成付款页面
    //返回结果为付款页面代码   前端接收到在页面展示
    @RequestMapping(value = "pay.action", produces = {"text/html;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String pay1(String tradeno, float price, String tradename) {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);


        alipayRequest.setBizContent("{\"out_trade_no\":\"" + tradeno + "\","
                + "\"total_amount\":\"" + price + "\","
                + "\"subject\":\"" + tradename + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = "";
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //输出
        System.out.println(result);

        /*response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();



        out.println("<html>"+result+"</html>");
*/
        return result;
    }

    /*
     * 创建订单
     * */
    @RequestMapping("/createOrder.action")
    @ResponseBody
    public Map createOrder(Orders orders) {
        Map<String, String> map = new HashMap<String, String>();
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        String result = nf.format(orders.getOrdermoney());
        orders.setShshouru(Double.valueOf(result));
        int num = ordersService.insert(orders);
        List<Shopgouwu> gouwus = shopgouwuService.queryByuserid(orders.getUserid().getUserid());
        for(Shopgouwu s : gouwus){
            Orderxq orderxq =new Orderxq();
            Shop shop = new Shop();
            shop.setShopid(s.getShopid().getShopid().getShopid());
            orderxq.setShopid(shop);
            orderxq.setOrderid(orders);
            orderxq.setOrderxqcount(s.getNumber());
            orderxq.setOrderxqmoney(Double.valueOf(nf.format(s.getPrice())));
            int a = orderXqService.insert(orderxq);
        }

        if (num > 0) {
            map.put("msg", "创建成功");
            return map;
        } else {
            map.put("msg", "创建失败");
            return map;
        }
    }

    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        //System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); // 调用SDK验证签名
        //验证签名通过
        if (signVerified) {
            //获得初始化的AlipayClient
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);


            //设置请求参数
            AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();

            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号=" + out_trade_no);
            System.out.println("支付宝交易号=" + trade_no);
            System.out.println("付款金额=" + total_amount);

            alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"trade_no\":\"" + trade_no + "\"}");

            //请求
            String result = alipayClient.execute(alipayRequest).getBody();

            Orders orders = new Orders();
            orders.setOrderbianhao(out_trade_no);
            //输出
            if (result.indexOf("Success") != -1) {
                orders.setOrderstate(2);
                ordersService.updatebydingdanbiaohao(orders);
            } else {
                System.out.println("不包含");
            }

            return "redirect:http://localhost:10086/#/fahuozhong";//跳转付款成功页面
        } else {
            return "redirect:http://localhost:10086/#/fahuozhong";//跳转付款失败页面
        }

    }
    /*根据订单编号修改订单状态 updatebydingdanbiaohao 参数orders 不能为空 */

}
