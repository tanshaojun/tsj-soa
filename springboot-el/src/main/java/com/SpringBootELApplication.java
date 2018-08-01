package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IntelliJ IDEA
 * Created By Kinsey
 * Date: 2018/8/1
 * Time: 下午9:06
 */
@SpringBootApplication
public class SpringBootELApplication {
    public static void main(String[] args) {
        SpringApplication r=new SpringApplication(SpringBootELApplication.class);
        r.run(args);
    }
}
