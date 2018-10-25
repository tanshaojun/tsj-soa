package com.service;

import com.model.Tag;

import java.util.List;

public interface TagService {
    /**
     * 查询所有标签
     *
     * @return
     */
    List<Tag> findAll();
}
