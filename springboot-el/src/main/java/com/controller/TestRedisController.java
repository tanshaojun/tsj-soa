package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author tansj
 * @Date 2021/10/19 3:35 下午
 * @Version 1.0
 */
@RestController
public class TestRedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test")
    public String test() {
        stringRedisTemplate.opsForValue().set("aa", "bb", 10, TimeUnit.SECONDS);
        return "s";

    }
}
