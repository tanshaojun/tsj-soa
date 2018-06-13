package com.service.impl;

import com.bean.Share;
import com.mapper.ShareMapper;
import com.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shareServiceImpl")
public class ShareServiceImpl implements ShareService {
    @Autowired
    private ShareMapper shareMapper;

    @Override
    public List<Share> findAll() {
        return shareMapper.findAll();
    }
}
