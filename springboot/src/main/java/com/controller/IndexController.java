package com.controller;

import com.model.Article;
import com.model.Tag;
import com.service.ArticleService;
import com.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        //文章列表
        List<Article> articleList = articleService.findArticleByShow(1);
        mv.addObject("articles", articleList);
        //标签
        List<Tag> tagList = tagService.findAll();
        mv.addObject("tags", tagList);

        return mv;
    }
}
