package com.tsj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Administrator on 2018/5/10 0010.
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaMain {
    public static void main(String[] args) {
        SpringApplication springApplication=new SpringApplication(SpringCloudEurekaMain.class);
        springApplication.run(args);
    }
}
