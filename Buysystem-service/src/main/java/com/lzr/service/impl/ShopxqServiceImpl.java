package com.lzr.service.impl;
import com.lzr.dao.ShopxqMapping;
import com.lzr.service.ShopxqService;
import com.lzr.vo.Shopxq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShopxqServiceImpl implements ShopxqService {
     @Autowired
     ShopxqMapping shopxqMapping;

    @Override
    public List<Shopxq> queryAll() {
        return shopxqMapping.queryAll();
    }

    @Override
    public Shopxq queryById(int id) {
        return shopxqMapping.queryById(id);
    }


    @Override
    public int insert(Shopxq shopxq) {
        return shopxqMapping.insert(shopxq);
    }

    @Override
    public int updateById(Shopxq shopxq) {
        return shopxqMapping.updateById(shopxq);
    }

    @Override
    public int deleteById(int shopid) {
        return shopxqMapping.deleteById(shopid);
    }
}
