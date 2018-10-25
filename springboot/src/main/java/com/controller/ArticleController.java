package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("article")
public class ArticleController {

    /**
     * 跳转到文章详情页面
     *
     * @return
     */
    @RequestMapping("/toArticleInfo")
    public ModelAndView toArticleInfo() {
        ModelAndView mv = new ModelAndView("/article");
        return mv;
    }

}
