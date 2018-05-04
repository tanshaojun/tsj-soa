package com.tsj.common.utils;

import java.math.BigDecimal;

public class NumberUtils extends org.apache.commons.lang3.math.NumberUtils {

    public static Integer strToInteger(String str) {
        if (NumberUtils.isDigits(str)) {
            return Integer.valueOf(str);
        }
        return INTEGER_ZERO;
    }

    public static BigDecimal strToBigDecimal(String str) {
        if (NumberUtils.isNumber(str)) {
            return new BigDecimal(str);
        }
        return BigDecimal.ZERO;
    }

}
