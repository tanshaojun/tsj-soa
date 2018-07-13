package com.service.impl;

import com.bean.Comment;
import com.mapper.CommentMapper;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commentServiceImpl")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public Integer insertComment(Comment comment) {
        return commentMapper.insert(comment);
    }
}
