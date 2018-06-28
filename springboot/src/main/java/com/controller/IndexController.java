package com.controller;

import com.bean.AdvertManage;
import com.bean.Log;
import com.bean.LogVO;
import com.bean.Share;
import com.config.DynamicDataSourceContextHolder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.AdvertManageService;
import com.service.LogService;
import com.service.ShareService;
import com.utils.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    /**
     * 首页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/")
    public ModelAndView index(@RequestParam(value = "pageNum", defaultValue = "1") Integer
                                      pageNum, @RequestParam(value = "pageSize",
            defaultValue = "5") Integer pageSize) {
        DynamicDataSourceContextHolder.setDataSourceType("manage");
        ModelAndView mv = new ModelAndView("index");
        PageHelper.startPage(pageNum, pageSize);
        List<LogVO> list = logService.selectAll();
        PageInfo<LogVO> pageInfo = new PageInfo<LogVO>(list);
        mv.addObject("logs", pageInfo);
        List<AdvertManage> advs = advertManageService.findAll();
        mv.addObject("advs", advs);
        mv.addObject("identification", 0);
        return mv;
    }

    /**
     * 文章详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/toInfo")
    public ModelAndView toInfo(Integer id) {
        ModelAndView mv = new ModelAndView("info");
        Log log = logService.findLogById(id);
        mv.addObject("logInfo", log);

        return mv;
    }

    /**
     * 分享
     *
     * @return
     */
    @RequestMapping(value = "/toImgs")
    public ModelAndView toImgs() {
        ModelAndView mv = new ModelAndView("imgs");
        List<Share> list = shareService.findAll();
        mv.addObject("shares", list);
        mv.addObject("identification", 2);
        return mv;
    }

    /**
     * 时光机
     *
     * @return
     */
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
        mv.addObject("identification", 3);
        return mv;
    }

    /**
     * 我的博客
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/toMyLogs")
    public ModelAndView toMyLogs(@RequestParam(value = "pageNum", defaultValue = "1") Integer
                                         pageNum, @RequestParam(value = "pageSize",
            defaultValue = "10") Integer pageSize) {
        ModelAndView mv = new ModelAndView("mylogs");
        PageHelper.startPage(pageNum, pageSize);
        List<LogVO> list = logService.selectAll();
        PageInfo<LogVO> pageInfo = new PageInfo<LogVO>(list);
        mv.addObject("logs", pageInfo);
        mv.addObject("identification", 1);
        return mv;
    }

    /**
     * 关于我
     *
     * @return
     */
    @RequestMapping(value = "/toMyInfo")
    public ModelAndView toMyInfo() {
        ModelAndView mv = new ModelAndView("myinfo");
        mv.addObject("identification", 4);
        return mv;
    }
}
