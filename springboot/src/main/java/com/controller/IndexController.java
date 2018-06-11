package com.controller;

import com.bean.Log;
import com.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private LogService logService;

    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        List<Log> alls = logService.getAlls();
        mv.addObject("logs", alls);
        return mv;
    }

    @RequestMapping(value = "/toInfo")
    public ModelAndView toInfo(Integer id) {
        ModelAndView mv = new ModelAndView("info");
        Log log = logService.findLogById(id);
        mv.addObject("logInfo", log);
        return mv;
    }

    @RequestMapping(value = "/toImgs")
    public ModelAndView toImgs() {
        ModelAndView mv = new ModelAndView("imgs");
        return mv;
    }

    @RequestMapping(value = "/toTimemachine")
    public ModelAndView toTimeMachine() {
        ModelAndView mv = new ModelAndView("timemachine");
        return mv;
    }

    @RequestMapping(value = "/toMyLogs")
    public ModelAndView toMyLogs() {
        ModelAndView mv = new ModelAndView("mylogs");
        return mv;
    }
}
