package com.tsj.common.utils;

/**
 * @author 谭少军
 * @version V1.0
 * @description 描述该类是做什么的
 * @ClassName: ${type_name}
 * @Date ${date} ${time}
 * Copyright(c) 2015 www.aiwue.com  All rights reserved
 * <p>
 * ${tags}
 */
public class DataSourceHolder {
    private static final ThreadLocal<String> datasourcce = new ThreadLocal<String>();

    public static void setCustomeType(String type){
        datasourcce.set(type);
    }

    public static String getCustomeType(){
        return datasourcce.get();
    }

    public static void remove(){
        datasourcce.remove();
    }
}
