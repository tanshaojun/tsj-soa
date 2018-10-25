package com.service;

import com.model.Article;

import java.util.List;

public interface ArticleService {
    /**
     * 查询显示的文章
     *
     * @param i
     * @return
     */
    List<Article> findArticleByShow(int show);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    Article findById(Integer id);
}
