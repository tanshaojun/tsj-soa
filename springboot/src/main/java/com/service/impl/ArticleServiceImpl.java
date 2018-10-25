package com.service.impl;

import com.mapper.ArticleMapper;
import com.model.Article;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> findArticleByShow(int show) {
        return articleMapper.findArticleByShow(show);
    }
}
