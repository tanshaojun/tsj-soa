package com.service;

import com.bean.Log;
import com.bean.LogVO;

import java.util.List;

public interface LogService {
    List<Log> getAlls();

    Log findLogById(Integer id);

    List<LogVO> selectAll();
}
