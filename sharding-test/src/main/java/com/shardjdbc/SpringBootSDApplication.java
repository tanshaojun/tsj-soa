package com.shardjdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author tansj
 * @Date 2021/8/2 下午2:32
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.shardjdbc.mapper")
public class SpringBootSDApplication {
    public static void main(String[] args) {
        SpringApplication r=new SpringApplication(SpringBootSDApplication.class);
        r.run(args);
    }
}
