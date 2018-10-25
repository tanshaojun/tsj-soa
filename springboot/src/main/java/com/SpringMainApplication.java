package com;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.mapper")
public class SpringMainApplication {

    private final static Logger logger = LoggerFactory.getLogger(SpringMainApplication.class);

    public static void main(String[] args) {
        SpringApplication run = new SpringApplication(SpringMainApplication.class);
        run.run(args);
    }
}
