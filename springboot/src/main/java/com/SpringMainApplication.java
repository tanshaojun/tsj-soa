package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.mapper")
public class SpringMainApplication {
    public static void main(String[] args) {
        SpringApplication run = new SpringApplication(SpringMainApplication.class);
        run.run(args);
    }
}
