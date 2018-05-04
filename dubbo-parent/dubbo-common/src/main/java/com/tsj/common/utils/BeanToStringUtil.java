package com.tsj.common.utils;

import java.lang.reflect.Field;
import java.util.Optional;

public class BeanToStringUtil {
    public static String getSignParameter(Object o, Class<?> c) {
        StringBuffer result = new StringBuffer();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Optional<Object> valueOpt = Optional.ofNullable(field.get(o));
                if (valueOpt.isPresent()) {
                    result.append(field.getName() + ":" + field.get(o) + ";");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }

}
