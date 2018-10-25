package com.mapper;

import com.model.Article;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ArticleMapper extends Mapper<Article> {
    /**
     * 查询显示的文章
     *
     * @param show
     * @return
     */
    List<Article> findArticleByShow(@Param("show") int show);
}
