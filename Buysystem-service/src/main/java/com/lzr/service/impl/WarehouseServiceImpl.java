package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzr.dao.WarehouseMapping;
import com.lzr.service.WarehouseService;
import com.lzr.vo.PageVo;
import com.lzr.vo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
     @Autowired
     WarehouseMapping warehouseMapping;



    @Override
    public PageVo<Warehouse> queryLike(Warehouse warehouse, int page, int rows) {
        PageVo<Warehouse> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(warehouseMapping.queryLike(warehouse));
        //获取总的记录数量
        pageVo.setTotal(warehouseMapping.queryLike(warehouse).size());
        /*  List<RoleInfo> querycount=roleInfoMapping.querycount();
        //将人数传入querylike集合里面的属性里面去
        for (RoleInfo roleall: pageVo.getRows()){
            for(RoleInfo role:querycount){
                if(roleall.getRid() == role.getRid()){
                    roleall.setCount(role.getCount());
                }
            }
        }*/
        List<Warehouse> querylist=warehouseMapping.queryLike1();
        for (Warehouse warehouseall: pageVo.getRows()){
            for(Warehouse warehouse1:querylist){
                if(warehouseall.getWareid() == warehouse1.getWareid()){
                    warehouseall.setShopcount(warehouse1.getShopcount());
                    warehouseall.setTypecount(warehouse1.getTypecount());
                }
            }
        }
        System.out.println(pageVo.getRows()+"数据");
        return pageVo;
    }

    @Override
    public List<Warehouse> queryAll() {
        return warehouseMapping.queryAll();
    }

    @Override
    public Warehouse queryById(int id) {
        return warehouseMapping.queryById(id);
    }

    @Override
    public int insert(Warehouse warehouse) {
        return warehouseMapping.insert(warehouse);
    }

    @Override
    public int updateById(Warehouse warehouse) {
        return warehouseMapping.updateById(warehouse);
    }

    @Override
    public int deleteById(int id) {
        return warehouseMapping.deleteById(id);
    }
}
