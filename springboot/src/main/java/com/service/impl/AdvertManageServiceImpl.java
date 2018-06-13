package com.service.impl;

import com.bean.AdvertManage;
import com.mapper.AdvertManageMapper;
import com.service.AdvertManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("advertManageServiceImpl")
public class AdvertManageServiceImpl implements AdvertManageService {
    @Autowired
    private AdvertManageMapper advertManageMapper;

    @Override
    public List<AdvertManage> findAll() {
        return advertManageMapper.findAll();
    }
}
