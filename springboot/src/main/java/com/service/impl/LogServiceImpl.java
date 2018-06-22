package com.service.impl;

import com.bean.Log;
import com.bean.LogVO;
import com.mapper.LogMapper;
import com.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("logServiceImpl")
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public List<Log> getAlls() {
        return logMapper.selectAlls();
    }

    @Override
    public Log findLogById(Integer id) {
        return logMapper.findLogById(id);
    }

    @Override
    public List<LogVO> selectAll() {
        return logMapper.selectAll();
    }
}
