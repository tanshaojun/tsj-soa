package com.tsj.controller;

import com.bean.Dept;
import com.tsj.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/5/9 0009.
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("/findAll")
    public List<Dept> findAll() {
        return deptService.findAll();
    }
}
