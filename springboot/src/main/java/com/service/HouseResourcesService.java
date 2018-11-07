package com.service;

import com.model.House;

import java.util.List;

public interface HouseResourcesService {
    List<House> findAll();

    List<House> findHouse(Integer startpage, Integer size);
}
