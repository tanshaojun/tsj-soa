package com.tsj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Administrator on 2018/5/9 0009.
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringCloudConsumerMain {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringCloudConsumerMain.class);
        springApplication.run(args);
    }
}