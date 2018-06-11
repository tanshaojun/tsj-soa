package com.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class StaticConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/assets/css/**").addResourceLocations("classpath:/static/assets/css/");
        registry.addResourceHandler("/static/assets/i/**").addResourceLocations("classpath:/static/assets/i/");
        registry.addResourceHandler("/static/assets/js/**").addResourceLocations("classpath:/static/assets/js/");
        registry.addResourceHandler("/static/assets/fonts/**").addResourceLocations("classpath:/static/assets/fonts/");
        registry.addResourceHandler("/static/images/**").addResourceLocations("classpath:/static/images/");
        super.addResourceHandlers(registry);
    }
}
