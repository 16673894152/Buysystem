package com.lzr.control;

import com.lzr.service.WareshopService;
import com.lzr.vo.PageVo;
import com.lzr.vo.Wareshop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/wareshop")
public class WareshopController {

    @Autowired
    WareshopService wareshopService;

    @RequestMapping("/editwareshop.action")
    @ResponseBody
    public Map updateEmploy(Wareshop wareshop) {
        System.out.println(wareshop+"添加或编辑的仓库"+wareshop);
        Map<String, String> map = new HashMap<String, String>();
        if(wareshop.getWsshid()==null){//wareshop
            int num = wareshopService.insert(wareshop);
            if (num > 0) {
                map.put("msg", "添加成功");
            } else {
                map.put("msg", "添加失败");
            }
        }else if(wareshop.getWareid()!=null) {//修改
            int num = wareshopService.updateById(wareshop);
            if (num > 0) {
                map.put("msg", "修改成功");
            } else {
                map.put("msg", "修改失败");
            }
        }
        return map;
    }

    @RequestMapping("/delwareshop.action")
    @ResponseBody
    public Map delemploy(Wareshop wareshop) {
        Wareshop wareshop1=new Wareshop();
        //测试
        wareshop1.setWsshid(1);
        wareshop1.setIsdelete(0);

        Map<String, String> map = new HashMap<String, String>();
        int num = wareshopService.updateById(wareshop1);
        if (num > 0) {
            map.put("msg", "删除成功");
        } else {
            map.put("msg", "删除失败");
        }
        return map;
    }
    @RequestMapping("/querylike.action")
    @ResponseBody
    public PageVo<Wareshop> querylike(Wareshop wareshop,
                                       @RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "rows", defaultValue = "5") int rows) {
        Wareshop wareshop1=new Wareshop();
        return wareshopService.queryLike(wareshop1, page, rows);
    }
}
