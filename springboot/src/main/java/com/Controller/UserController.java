package com.controller;

import com.bean.User;
import com.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login() {
        System.out.println(userService);
        User user = userService.getUser(1);
        System.out.println(user);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/ajax")
    public String ajax(@Param("id") String id) {
        return id;
    }
}
