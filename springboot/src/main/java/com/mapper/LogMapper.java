package com.mapper;

import com.bean.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogMapper {
    List<Log> selectAlls();

    Log findLogById(@Param("id") Integer id);
}
