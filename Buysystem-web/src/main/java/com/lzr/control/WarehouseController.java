package com.lzr.control;

import com.lzr.service.WarehouseService;
import com.lzr.service.WareshopService;
import com.lzr.vo.PageVo;
import com.lzr.vo.Shop;
import com.lzr.vo.Warehouse;
import com.lzr.vo.Wareshop;
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
    public Map shopzhuanyi(String shopid, String warehouseid, String shopcount, int wareid) {
        /*System.out.println(shopid+"shopid");
        System.out.println(warehouseid+"warehouseid");
        System.out.println(shopcount+"shopcount");
        System.out.println(wareid+"wareid");*/
        String[] shopids = shopid.split(",");
        String[] warehouseids = warehouseid.split(",");
        String[] shopcounts = shopcount.split(",");
        List<Integer> shopidss = new ArrayList<>();
        List<Integer> warehouseidss = new ArrayList<>();
        List<Integer> shopcountss = new ArrayList<>();
        int num=0;
        for (int i = 0; i < warehouseids.length - 1; i++) {
            shopidss.add(Integer.parseInt(shopids[i]));
            warehouseidss.add(Integer.parseInt(warehouseids[i]));
            shopcountss.add(Integer.parseInt(shopcounts[i]));
        }
        for (int i = 0; i < shopidss.size() - 1; i++){
            Wareshop wareshop=new Wareshop();
            Warehouse warehouse=new Warehouse();
            Shop shop=new Shop();
            shop.setShopid(shopidss.get(i));
            //要转移的仓库
            warehouse.setWareid(warehouseidss.get(0));
            wareshop.setShopid(shop);
            wareshop.setWareid(warehouse);
            /*查看转移的仓库的仓库有没有那个商品*/
            List<Wareshop> wareshops=wareshopService.query(wareshop);
            /*如果有的话*/
            if (wareshops.size()>0){
                Wareshop wareshop1=new Wareshop();
                wareshop1.setWsshid(wareshops.get(1).getWsshid());
                wareshop1.setShopcount(shopcountss.get(i));
                //如果转移的仓库有那个商品的话就修改商品数量
                int num1=wareshopService.updateById(wareshop1);
                //仓库报表---------------------------

            }else {
                Wareshop wareshop2=new Wareshop();
                Warehouse warehouse2=new Warehouse();
                warehouse2.setWareid(warehouseidss.get(0));
                wareshop2.setShopcount(shopcountss.get(0));
                wareshop2.setWareid(warehouse2);
                wareshop2.setShopcount(shopcountss.get(0));
                //如果转移的仓库没有那个商品的话就添加
                int num2=wareshopService.insert(wareshop2);
                //仓库报表---------------------------

            }
            //原来的仓库减去商品数量
            Wareshop wareshop3=new Wareshop();
            wareshop3.setShopcount(-shopcountss.get(0));
            Warehouse warehouse3=new Warehouse();
            warehouse3.setWareid(wareid);
            wareshop3.setWareid(warehouse3);
            shop.setShopid(shopidss.get(i));
            /*查看转移的仓库的仓库有没有那个商品*/
            List<Wareshop> wareshops3=wareshopService.query(wareshop3);
            System.out.println(wareshops3.get(0));
            wareshop3.setWareid(wareshops3.get(0).getWareid());
            num=wareshopService.updateById(wareshop3);
            //仓库报表-------------------------------

        }
        Map<String, String> map = new HashMap<String, String>();
        if (num > 0) {
            map.put("msg", "转移成功");
        } else {
            map.put("msg", "转移失败");
        }
        return map;
    }
}