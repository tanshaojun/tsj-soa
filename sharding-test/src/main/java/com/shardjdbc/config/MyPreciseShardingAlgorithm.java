package com.shardjdbc.config;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @Author tansj
 * @Date 2021/8/2 下午3:46
 * @Version 1.0
 */
@Slf4j
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    private static final List<String> PARAM_LIST = Arrays.asList("0", "1");
    private static final List<String> PARAM_LIST1 = Arrays.asList("2", "3");
    private static final List<String> PARAM_LIST2 = Arrays.asList("4", "5");

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        //availableTargetNames拆分出来的物理表【t_user_1,t_user_2】，shardingValue分片字段的值
        for (String availableTargetName : availableTargetNames) {
            String value = "2";
            //尾数0-5存表t_user_1，6-9存表t_user_2
            String colValue = shardingValue.getValue().toString();
            String subLast = shardingValue.getValue().toString().substring(colValue.length() - 1, colValue.length());
            if (PARAM_LIST.contains(subLast)) {
                value = "1";
            } else if (PARAM_LIST1.contains(subLast)) {
                value = "3";
            } else if (PARAM_LIST2.contains(subLast)) {
                value = "4";
            }
            if (availableTargetName.endsWith(value)) {
                return availableTargetName;
            }
        }
        throw new IllegalArgumentException();
    }

}
