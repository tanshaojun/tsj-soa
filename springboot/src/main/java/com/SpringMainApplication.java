package com;


import com.config.DynamicDataSourceRegister;
import com.config.StartupListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.mapper")
@Import(DynamicDataSourceRegister.class)
public class SpringMainApplication {
    public static void main(String[] args) {
        SpringApplication run = new SpringApplication(SpringMainApplication.class);
        run.addListeners(new StartupListener());
        run.run(args);
        System.out.println("测试git是否成功");
        System.out.println("测试git是否成功");
        System.out.println("测试git是否成功");
        System.out.println("测试git是否成功");
    }
}
