package com.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class StartupListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Map<Object, Object> map = new HashMap<>(16);
        DruidDataSource dss = new DruidDataSource();
        dss.setDriverClassName("com.mysql.jdbc.Driver");
        dss.setUrl("jdbc:mysql://127.0.0.1:3306/saas_manage?useUnicode=true&characterEncoding=UTF-8" +
                "&zeroDateTimeBehavior=convertToNull");
        dss.setUsername("root");
        dss.setPassword("root");
        dss.setInitialSize(1000);
        dss.setMaxActive(1000);
        dss.setMinIdle(1);
        dss.setMaxWait(6000L);
        dss.setPoolPreparedStatements(true);
        dss.setMaxOpenPreparedStatements(50);
        dss.setValidationQuery("SELECT 1");
        dss.setTestOnBorrow(false);
        dss.setTestOnReturn(false);
        dss.setTestWhileIdle(true);
        dss.setTimeBetweenEvictionRunsMillis(60000L);
        dss.setMinEvictableIdleTimeMillis(25200000L);
        dss.setRemoveAbandoned(true);
        dss.setRemoveAbandonedTimeout(1800);
        dss.setLogAbandoned(false);
        try {
            dss.setFilters("stat");
        } catch (SQLException var9) {
            var9.printStackTrace();
        }
        map.put("manage", dss);
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(map);
    }
}
