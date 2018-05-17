package com.tsj.controller;

import com.bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Created by Administrator on 2018/5/9 0009.
 */
@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    private static String url = "http://localhost:8001/findAll";

    @RequestMapping("/findAll")
    public String findAll() {
        ResponseEntity<String> listResponseEntity = restTemplate.postForEntity(url, "", String.class);
        return listResponseEntity.getBody();
    }
}
