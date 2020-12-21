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
        System.out.println("来了");
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
        List<Warehouse> warehouseList=warehouseService.queryAll();
        //判断转移数量是否超过仓库最大容量
        for (int i = 0; i <= warehouseList.size() - 1; i++) {
            for (int j = 0; j <= warehouseidss.size() - 1; j++) {
                if(warehouseList.get(i).getWareid() == warehouseidss.get(j)){
                   int setshopcount=shopcountss.get(j)+warehouseList.get(i).getShopcount();
                   System.out.println(setshopcount+"目前容量");
                   warehouseList.get(i).setShopcount(setshopcount);
                   System.out.println(warehouseList.get(i).getWarecount()+"最大容量");
                }
                //如果采购的数量大于最大容量
            }
            int sum=warehouseList.get(i).getShopcount();
            int max= warehouseList.get(i).getWarecount();
            System.out.println("结算目前容量"+sum+"最大容量"+max);
            if(warehouseList.get(i).getShopcount() > warehouseList.get(i).getWarecount()){
                map.put("msg", "转移的数量已超出仓库最大容量----"+warehouseList.get(i).getWarename());
                map.put("type", "error");
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
            map.put("type", "success");
        } else {
            map.put("msg", "转移失败");
            map.put("type", "error");
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

    @RequestMapping("/caigou.action")
    @ResponseBody
    @CrossOrigin
    public Map shopcaigou(String shopid, String warehouseid, String shopcount, String username) {
        Employ employ = new Employ();
        employ.setUsername(username);
        List<Employ> employList = employService.query(employ);
        //*********************************************************

        Map<String, String> map = new HashMap<String, String>();
        String[] shopids = shopid.split(",");
        String[] warehouseids = warehouseid.split(",");
        String[] shopcounts = shopcount.split(",");
        List<Integer> shopidss = new ArrayList<>();
        List<Integer> warehouseidss = new ArrayList<>();
        List<Integer> shopcountss = new ArrayList<>();
        int num = 0;
        /**************************************************/
        for (int i = 0; i <= warehouseids.length - 1; i++) {
            shopidss.add(Integer.parseInt(shopids[i]));
            warehouseidss.add(Integer.parseInt(warehouseids[i]));
            shopcountss.add(Integer.parseInt(shopcounts[i]));
        }
        List<Warehouse> warehouseList = warehouseService.queryAll();
        //判断转移数量是否超过仓库最大容量
        for (int i = 0; i <= warehouseList.size() - 1; i++) {
            for (int j = 0; j <= warehouseidss.size() - 1; j++) {
                if(warehouseList.get(i).getWareid() == warehouseidss.get(j)){
                    int setshopcount=shopcountss.get(j)+warehouseList.get(i).getShopcount();
                    warehouseList.get(i).setShopcount(setshopcount);
                }
            }
            int sum=warehouseList.get(i).getShopcount();
            int max= warehouseList.get(i).getWarecount();
            if(warehouseList.get(i).getShopcount() > warehouseList.get(i).getWarecount()){
                map.put("msg", "采购的数量已超出仓库最大容量----"+warehouseList.get(i).getWarename());
                map.put("type", "error");
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

            //查看仓库是否有这个商品
            List<Wareshop> wareshops = wareshopService.query(wareshop);
            /*如果有的话*/
            if (wareshops.size() > 0) {
                Wareshop wareshop1 = new Wareshop();
                wareshop1.setWsshid(wareshops.get(0).getWsshid());
                wareshop1.setShopcount(shopcountss.get(i));
                //如果转移的仓库有那个商品的话就修改商品数量
                num = wareshopService.updateById(wareshop1);
            } else {
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
                num = wareshopService.insert(wareshop2);
            }
            //仓库报表-------------------------------
            Ckbaobiao ckbaobiao = new Ckbaobiao();
            ckbaobiao.setEmploy(employList.get(0));//操作人
            Shop ckshop = new Shop();
            ckshop.setShopid(shopidss.get(i));      //商品id
            ckbaobiao.setShopid(ckshop);
            Warehouse ckwarehouse = new Warehouse();  //仓库id
            ckwarehouse.setWareid(warehouseidss.get(0));
            ckbaobiao.setWareid(ckwarehouse);
            ckbaobiao.setCount(shopcountss.get(i));    //转入数量
            ckbaobiao.setType(2);                       //转入类型  转移入库
            //添加到仓库报表
            int nums=ckbaobiaoService.insert(ckbaobiao);
        }
        if (num > 0) {
            map.put("msg", "采购成功");
            map.put("type", "success");
        } else {
            map.put("msg", "采购失败");
            map.put("type", "error");
        }
        return map;
    }

}