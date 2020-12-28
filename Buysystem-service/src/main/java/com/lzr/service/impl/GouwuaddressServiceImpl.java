package com.lzr.service.impl;

import com.lzr.dao.GouwuaddressMapping;
import com.lzr.service.GouwuaddressService;
import com.lzr.vo.Gouwuaddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GouwuaddressServiceImpl implements GouwuaddressService {

    @Autowired
    GouwuaddressMapping addressMapping;

    @Override
    public List<Gouwuaddress> queryById(int id) {
        return addressMapping.queryById(id);
    }

    @Override
    public int insert(Gouwuaddress gouwuaddress) {
        return addressMapping.insert(gouwuaddress);
    }

    @Override
    public int updateById(Gouwuaddress gouwuaddress) {
        return addressMapping.updateById(gouwuaddress);
    }

    @Override
    public int deleteById(int id) {
        return addressMapping.deleteById(id);
    }

    @Override
    public int clearDelivery(Gouwuaddress gouwuaddress) {
        return addressMapping.clearDelivery(gouwuaddress);
    }

    @Override
    public int setDelivery(Gouwuaddress gouwuaddress) {
        return addressMapping.setDelivery(gouwuaddress);
    }
}
