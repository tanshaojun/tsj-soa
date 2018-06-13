package com.controller;

import com.bean.AdvertManage;
import com.bean.Log;
import com.bean.Share;
import com.service.AdvertManageService;
import com.service.LogService;
import com.service.ShareService;
import com.utils.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    @Autowired
    private LogService logService;

    @Autowired
    private AdvertManageService advertManageService;

    @Autowired
    private ShareService shareService;

    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        List<Log> alls = logService.getAlls();
        mv.addObject("logs", alls);
        List<AdvertManage> advs = advertManageService.findAll();
        mv.addObject("advs", advs);
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
        List<Share> list = shareService.findAll();
        mv.addObject("shares", list);
        return mv;
    }

    @RequestMapping(value = "/toTimemachine")
    public ModelAndView toTimeMachine() {
        ModelAndView mv = new ModelAndView("timemachine");
        List<Log> alls = logService.getAlls();
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Map<String, List<Log>>> collect = alls.stream().collect(
                Collectors.groupingBy(
                        l -> bf.format(l.getCreateTime()).substring(0, 4), Collectors.groupingBy(l -> bf.format(l
                                .getCreateTime()).substring(5, 7))
                )
        );
        mv.addObject("timemachines", SortUtils.sortMapByKey(collect));
        return mv;
    }

    @RequestMapping(value = "/toMyLogs")
    public ModelAndView toMyLogs() {
        ModelAndView mv = new ModelAndView("mylogs");
        List<Log> alls = logService.getAlls();
        mv.addObject("logs", alls);
        return mv;
    }

    @RequestMapping(value = "/toMyInfo")
    public ModelAndView toMyInfo() {
        ModelAndView mv = new ModelAndView("myinfo");
        return mv;
    }
}
