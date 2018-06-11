package com.service;

import com.bean.Log;

import java.util.List;

public interface LogService {
    List<Log> getAlls();

    Log findLogById(Integer id);
}
