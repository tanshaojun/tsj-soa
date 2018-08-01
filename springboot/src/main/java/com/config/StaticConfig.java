package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class StaticConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/static/assets/i/**").addResourceLocations("classpath:/static-bat/assets/i/");
//        registry.addResourceHandler("/static/assets/js/**").addResourceLocations("classpath:/static-bat/assets/js/");
//        registry.addResourceHandler("/static/assets/fonts/**").addResourceLocations("classpath:/static-bat/assets/fonts/");
        registry.addResourceHandler("/static/img/**").addResourceLocations("classpath:/static/img/");
        super.addResourceHandlers(registry);
    }
}
