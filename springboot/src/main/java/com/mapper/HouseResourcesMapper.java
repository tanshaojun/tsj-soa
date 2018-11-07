package com.mapper;

import com.model.House;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HouseResourcesMapper extends Mapper<House> {
    List<House> findHouse(@Param("startpage") Integer startpage, @Param("size") Integer size);
}
