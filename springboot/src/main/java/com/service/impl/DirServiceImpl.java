package com.service.impl;

import com.bean.Dir;
import com.bean.Log;
import com.bean.LogVO;
import com.mapper.DirMapper;
import com.mapper.LogMapper;
import com.service.DirService;
import com.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dirServiceImpl")
public class DirServiceImpl implements DirService {

    @Autowired
    private DirMapper dirMapper;

    @Override
    public List<Dir> getAll() {
        return dirMapper.getAll();
    }
}
