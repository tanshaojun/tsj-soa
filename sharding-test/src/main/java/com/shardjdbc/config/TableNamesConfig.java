package com.shardjdbc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author tansj
 * @Date 2021/8/2 下午5:29
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "db.table")
public class TableNamesConfig {
    String[] names;
    // 起始年 默认 2021
    int startYear;
}
