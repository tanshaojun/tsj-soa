package com.controller;

import com.bean.Log;
import com.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "log")
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/list")
    public List<Log> list() {
        List<Log> logs = logService.getAlls();
        return logs;
    }
}
