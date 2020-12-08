package com.lzr;

import com.lzr.utils.CreateEntityUtil;
import com.lzr.utils.CreateMapUtil;
import com.lzr.vo.*;

public class CreateMain {

    public static void main(String[] args) {
        //创建实体类
      //  createVo();
        //创建dao层
         createMapper();
    }

    public static void createVo() {
        CreateEntityUtil.init("root", "123456",
                "jdbc:mysql://localhost:3306/s3xiangmu4?serverTimezone=UTC&characterEncoding=utf8&useSSL=false",
                "com.mysql.cj.jdbc.Driver", "com.lzr.vo");
        CreateEntityUtil.addTable("employ", "ckbaobiao", "cwbaobiao", "employrole_info", "huiyuan", "menu_info",
                "orders", "orderxq", "role_info", "shanghu", "shop", "shopgouwu", "shoppingjia", "shopput", "shoptype", "shopxq", "user", "wareshop", "warehouse", "xsbaobiao");
        CreateEntityUtil.useFkEntity = true;
        CreateEntityUtil.usePkEntityList = true;
        CreateEntityUtil.addTypeMapper("Longblob", "Byte[]");
        CreateEntityUtil.write(true, true, true);
    }

    public static void createMapper() {
        CreateMapUtil.init("root", "123456",
                "jdbc:mysql://localhost:3306/s3xiangmu4?serverTimezone=UTC&characterEncoding=utf8&useSSL=false",
                "com.mysql.cj.jdbc.Driver", "com.lzr.dao");
        CreateMapUtil.addClass(Employ.class);
        CreateMapUtil.addClass(Ckbaobiao.class);
        CreateMapUtil.addClass(Cwbaobiao.class);
        CreateMapUtil.addClass(EmployroleInfo.class);
        CreateMapUtil.addClass(MenuInfo.class, true, false);
        CreateMapUtil.addClass(RoleInfo.class);
        CreateMapUtil.addClass(Huiyuan.class);
        CreateMapUtil.addClass(Orders.class);
        CreateMapUtil.addClass(Orderxq.class);
        CreateMapUtil.addClass(Shanghu.class);
        CreateMapUtil.addClass(Shop.class);
        CreateMapUtil.addClass(Shopgouwu.class);
        CreateMapUtil.addClass(Shoppingjia.class);
        CreateMapUtil.addClass(Shoptype.class);
        CreateMapUtil.addClass(Shopxq.class);
        CreateMapUtil.addClass(Shopput.class);
        CreateMapUtil.addClass(User.class);
        CreateMapUtil.addClass(Warehouse.class);
        CreateMapUtil.addClass(Wareshop.class);
        CreateMapUtil.addClass(Xsbaobiao.class);
        CreateMapUtil.usePkEntityList = true;
        CreateMapUtil.write();
    }
}
