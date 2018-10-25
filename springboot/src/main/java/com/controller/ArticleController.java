package com.controller;

import com.model.Article;
import com.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.util.StringUtil;

@Controller
@RequestMapping("article")
public class ArticleController {
    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    /**
     * 跳转到文章详情页面
     *
     * @return
     */
    @RequestMapping("/toArticleInfo")
    public ModelAndView toArticleInfo(Integer id) {
        ModelAndView mv = new ModelAndView("article");
        if (id == null) {
            return new ModelAndView("404");
        }
        Article article = articleService.findById(id);
        mv.addObject("article", article);
        return mv;
    }

}
