package com.lzr.control;

import com.lzr.service.CkbaobiaoService;
import com.lzr.service.EmployService;
import com.lzr.service.WarehouseService;
import com.lzr.service.WareshopService;
import com.lzr.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;
    @Autowired
    WareshopService wareshopService;
    @Autowired
    EmployService employService;
    @Autowired
    CkbaobiaoService ckbaobiaoService;

    @RequestMapping("/editwarehouse.action")
    @ResponseBody
    @CrossOrigin
    public Map updateWarehouse(Warehouse warehouse) {
        Map<String, String> map = new HashMap<String, String>();
        if (warehouse.getWareid() == null) {//添加
            warehouse.setJingdu(111);
            warehouse.setWeidu(111);
            warehouse.setIsdelete(1);
            int num = warehouseService.insert(warehouse);
            if (num > 0) {
                map.put("msg", "添加成功");
            } else {
                map.put("msg", "添加失败");
            }
        } else if (warehouse.getWareid() != null) {//修改
            int num = warehouseService.updateById(warehouse);
            if (num > 0) {
                map.put("msg", "修改成功");
            } else {
                map.put("msg", "修改失败");
            }
        }
        return map;
    }

    @RequestMapping("/delwarehouse.action")
    @ResponseBody
    @CrossOrigin
    public Map delwarehouse(Warehouse warehouse) {
        warehouse.setIsdelete(0);

        Map<String, String> map = new HashMap<String, String>();
        int num = warehouseService.updateById(warehouse);
        if (num > 0) {
            map.put("msg", "删除成功");
        } else {
            map.put("msg", "删除失败");
        }
        return map;
    }

    @RequestMapping("/queryall.action")
    @ResponseBody
    @CrossOrigin
    public List<Warehouse> queryall() {

        return warehouseService.queryAll();
    }

    @RequestMapping("/querylike.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Warehouse> querylike(Warehouse warehouse,
                                       @RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "rows", defaultValue = "5") int rows) {
        Warehouse warehouse1 = new Warehouse();
        return warehouseService.queryLike(warehouse, page, rows);
    }

    @RequestMapping("/zhuanyi.action")
    @ResponseBody
    @CrossOrigin
    public Map shopzhuanyi(String shopid, String warehouseid, String shopcount, int wareid, String wsshid, String username) {
        Employ employ = new Employ();
        employ.setUsername(username);
        List<Employ> employList = employService.query(employ);
        //*********************************************************
        Map<String, String> map = new HashMap<String, String>();
        String[] shopids = shopid.split(",");
        String[] warehouseids = warehouseid.split(",");
        String[] shopcounts = shopcount.split(",");
        String[] wsshids = wsshid.split(",");
        List<Integer> shopidss = new ArrayList<>();
        List<Integer> wsshidss = new ArrayList<>();
        List<Integer> warehouseidss = new ArrayList<>();
        List<Integer> shopcountss = new ArrayList<>();
        int num = 1;
        /**************************************************/
        for (int i = 0; i <= warehouseids.length - 1; i++) {
            shopidss.add(Integer.parseInt(shopids[i]));
            warehouseidss.add(Integer.parseInt(warehouseids[i]));
            shopcountss.add(Integer.parseInt(shopcounts[i]));
            wsshidss.add(Integer.parseInt(wsshids[i]));
        }
        //判断转移数量是否超过仓库最大容量
        for (int i = 0; i <= warehouseids.length - 1; i++) {
            Warehouse querywarehouse = warehouseService.queryById(warehouseidss.get(0));
            System.out.println(querywarehouse + "查看仓库");
            System.out.println(querywarehouse.getShopcount() + "查看仓库目前容量");
            Integer integer1 = new Integer(querywarehouse.getWarecount());
            Integer integer2 = new Integer(querywarehouse.getShopcount());
            Integer integer3 = new Integer(shopcountss.get(0));
            int reslut = integer1.intValue() - integer2.intValue() - integer3.intValue();
            if (reslut < 0) {
                map.put("msg", "转移的数量已超出仓库最大容量");
                return map;
            }
        }
        //for循环转移
        for (int i = 0; i <= warehouseids.length - 1; i++) {
            Wareshop wareshop = new Wareshop();
            Warehouse warehouse = new Warehouse();
            Shop shop = new Shop();
            //要转移的商品
            shop.setShopid(shopidss.get(i));
            //要转移的仓库
            warehouse.setWareid(warehouseidss.get(i));
            wareshop.setShopid(shop);
            wareshop.setWareid(warehouse);

            //原来的仓库减去数量
            Wareshop wareshop4 = new Wareshop();
            wareshop4.setWsshid(wsshidss.get(i));
            wareshop4.setShopcount(-shopcountss.get(i));
            num = wareshopService.updateById(wareshop4);

            //仓库报表-------------------------------
            Ckbaobiao ckbaobiao1 = new Ckbaobiao();
            ckbaobiao1.setEmploy(employList.get(0));//操作人
            Shop ckshop1 = new Shop();
            ckshop1.setShopid(shopidss.get(i));      //商品id
            ckbaobiao1.setShopid(ckshop1);
            Warehouse ckwarehouse1 = new Warehouse();  //仓库id
            ckwarehouse1.setWareid(wareid);
            ckbaobiao1.setWareid(ckwarehouse1);
            ckbaobiao1.setCount(shopcountss.get(i));    //转入数量
            ckbaobiao1.setType(5);                       //转入类型  转移入库
            ckbaobiaoService.insert(ckbaobiao1);
            //查看仓库是否有这个商品
            List<Wareshop> wareshops = wareshopService.query(wareshop);
            /*如果有的话*/
            if (wareshops.size() > 0) {
                Wareshop wareshop1 = new Wareshop();
                wareshop1.setWsshid(wareshops.get(0).getWsshid());
                wareshop1.setShopcount(shopcountss.get(i));
                //如果转移的仓库有那个商品的话就修改商品数量
                int num1 = wareshopService.updateById(wareshop1);
            } else {
                System.out.println("如果没有的话");

                Wareshop wareshop2 = new Wareshop();
                Warehouse warehouse2 = new Warehouse();
                Shop shop2 = new Shop();
                warehouse2.setWareid(warehouseidss.get(i));
                shop2.setShopid(shopidss.get(i));
                wareshop2.setShopid(shop2);
                wareshop2.setWareid(warehouse2);
                wareshop2.setIsdelete(1);
                wareshop2.setShopcount(shopcountss.get(i));
                //如果转移的仓库没有那个商品的话就添加
                int num2 = wareshopService.insert(wareshop2);
            }
            //仓库报表-------------------------------
            Ckbaobiao ckbaobiao = new Ckbaobiao();
            ckbaobiao.setEmploy(employList.get(0));//操作人
            Shop ckshop = new Shop();
            ckshop.setShopid(shopidss.get(i));      //商品id
            ckbaobiao.setShopid(ckshop);
            Warehouse ckwarehouse = new Warehouse();  //仓库id
            ckwarehouse.setWareid(wareid);
            ckbaobiao.setWareid(ckwarehouse);
            ckbaobiao.setCount(shopcountss.get(i));    //转入数量
            ckbaobiao.setType(6);                       //转入类型  转移入库
            //添加到仓库报表
            ckbaobiaoService.insert(ckbaobiao);
        }
        if (num > 0) {
            map.put("msg", "转移成功");
        } else {
            map.put("msg", "转移失败");
        }
        return map;
    }


    @RequestMapping("/tuihuo.action")
    @ResponseBody
    @CrossOrigin
    public Map shoptuihuo(String shopcount, String wsshid, String username, String shopid, int wareid) {
        String[] shopids = shopid.split(",");
        String[] shopcounts = shopcount.split(",");
        String[] wsshids = wsshid.split(",");
        List<Integer> shopidss = new ArrayList<>();
        List<Integer> wsshidss = new ArrayList<>();
        List<Integer> shopcountss = new ArrayList<>();
        int num = 1;
        for (int i = 0; i <= wsshids.length - 1; i++) {
            shopidss.add(Integer.parseInt(shopids[i]));
            shopcountss.add(Integer.parseInt(shopcounts[i]));
            wsshidss.add(Integer.parseInt(wsshids[i]));
        }
        for (int i = 0; i <= wsshids.length - 1; i++) {
            /*进行退货 根据wsshid修改仓库商品数量---------------*/
            Wareshop wareshop1 = new Wareshop();
            wareshop1.setWsshid(wsshidss.get(i));
            wareshop1.setShopcount(-shopcountss.get(i));
            num = wareshopService.updateById(wareshop1);
            //仓库报表-------------------------------
            Employ employ = new Employ();
            employ.setUsername(username);
            List<Employ> employList = employService.query(employ);
            Ckbaobiao ckbaobiao = new Ckbaobiao();
            ckbaobiao.setEmploy(employList.get(0));
            Shop ckshop = new Shop();
            ckshop.setShopid(shopidss.get(i));
            ckbaobiao.setShopid(ckshop);
            Warehouse ckwarehouse = new Warehouse();
            ckwarehouse.setWareid(wareid);
            ckbaobiao.setWareid(ckwarehouse);
            ckbaobiao.setCount(shopcountss.get(i));
            ckbaobiao.setType(3);
            //添加到仓库报表
            ckbaobiaoService.insert(ckbaobiao);
        }
        Map<String, String> map = new HashMap<String, String>();
        if (num > 0) {
            map.put("msg", "退货成功");
        } else {
            map.put("msg", "退货失败");
        }
        return map;
    }
}