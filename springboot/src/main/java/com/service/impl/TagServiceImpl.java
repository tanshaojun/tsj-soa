package com.service.impl;

import com.mapper.TagMapper;
import com.model.Tag;
import com.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tagService")
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> findAll() {
        return tagMapper.selectAll();
    }
}
