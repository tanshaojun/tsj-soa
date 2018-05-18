package com.tsj.mapper;

import com.bean.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2018/5/9 0009.
 */
@Mapper
public interface DeptMapper {
    List<Dept> findAll();
}
