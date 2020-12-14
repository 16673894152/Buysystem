package com.lzr.control;

import com.lzr.service.WarehouseService;
import com.lzr.vo.PageVo;
import com.lzr.vo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @RequestMapping("/editwarehouse.action")
    @ResponseBody
    public Map updateWarehouse(Warehouse warehouse) {
        System.out.println(warehouse+"添加或编辑的仓库"+warehouse);
        Map<String, String> map = new HashMap<String, String>();
        if(warehouse.getWareid()==null){//添加
            int num = warehouseService.insert(warehouse);
            if (num > 0) {
                map.put("msg", "添加成功");
            } else {
                map.put("msg", "添加失败");
            }
        }else if(warehouse.getWareid()!=null) {//修改
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
    public Map delemploy(Warehouse warehouse) {
        Warehouse warehouse1=new Warehouse();
        //测试
        warehouse1.setWareid(1);
        warehouse1.setIsdelete(0);

        Map<String, String> map = new HashMap<String, String>();
            int num = warehouseService.updateById(warehouse1);
            if (num > 0) {
                map.put("msg", "删除成功");
            } else {
                map.put("msg", "删除失败");
            }
        return map;
    }
    @RequestMapping("/querylike.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Warehouse> querylike(Warehouse warehouse,
                                   @RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "rows", defaultValue = "5") int rows) {
        Warehouse warehouse1=new Warehouse();
        return warehouseService.queryLike(warehouse, page, rows);
    }
}
