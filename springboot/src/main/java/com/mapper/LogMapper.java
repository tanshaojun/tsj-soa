package com.mapper;

import com.bean.Log;
import com.bean.LogVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogMapper {
    List<Log> selectAlls();

    Log findLogById(@Param("id") Integer id);

    List<LogVO> selectAll(@Param("type") Integer type);
}
