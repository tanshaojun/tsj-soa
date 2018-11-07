package com.service.impl;

import com.mapper.HouseResourcesMapper;
import com.model.House;
import com.service.HouseResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("houseResourcesService")
public class HouseResourcesServiceImpl implements HouseResourcesService {

    @Autowired
    private HouseResourcesMapper houseResourcesMapper;

    @Override
    public List<House> findAll() {
        return houseResourcesMapper.selectAll();
    }

    @Override
    public List<House> findHouse(Integer startpage, Integer size) {
        return houseResourcesMapper.findHouse(startpage, size);
    }
}
