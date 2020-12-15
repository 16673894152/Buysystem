package com.lzr.control;

import com.lzr.service.ShopService;
import com.lzr.service.ShoptypeService;
import com.lzr.vo.PageVo;
import com.lzr.vo.Shop;
import com.lzr.vo.Shoptype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shoptype")
public class ShoptypeController {


    @Autowired
    ShoptypeService shoptypeService;

    @RequestMapping("/editshoptype.action")
    @ResponseBody
    @CrossOrigin
    public Map editshoptype(Shoptype shoptype) {
        System.out.println(shoptype+"添加或编辑的商品类型"+shoptype);
        Map<String, String> map = new HashMap<String, String>();
        if(shoptype.getShoptyid()==null){//wareshop
            int num = shoptypeService.insert(shoptype);
            if (num > 0) {
                map.put("msg", "添加成功");
                return map;
            } else {
                map.put("msg", "添加失败");
            }
        }else if(shoptype.getShoptyid()!=null) {//修改
            int num = shoptypeService.updateById(shoptype);
            if (num > 0) {
                map.put("msg", "修改成功");
            } else {
                map.put("msg", "修改失败");
            }
        }
        return map;
    }

    @RequestMapping("/delshoptype.action")
    @ResponseBody
    @CrossOrigin
    public Map delshoptype(Shoptype shoptype) {
          /*测试
        Shoptype shoptype1=new Shoptype();

        shoptype1.setShoptyid(1);*/

        Map<String, String> map = new HashMap<String, String>();
        int num = shoptypeService.deleteById(shoptype.getShoptyid());
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
    public PageVo<Shoptype> querylike(Shoptype shoptype,
                                    @RequestParam(value = "page", defaultValue = "1") int page,
                                    @RequestParam(value = "rows", defaultValue = "5") int rows){
        Shoptype shoptype1=new Shoptype();
        return shoptypeService.queryLike(shoptype,page,rows);
    }
    @RequestMapping("/queryall.action")
    @ResponseBody
    public List<Shoptype> queryall() {
        return shoptypeService.queryAll();
    }
}