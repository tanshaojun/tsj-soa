package com.tsj.common.utils;

import java.util.UUID;

public class RandomUtils extends org.apache.commons.lang.math.RandomUtils {

    public static String genUUIDLowerCase() {
        return UUID.randomUUID().toString().replace("-", "_").toLowerCase();
    }
}
