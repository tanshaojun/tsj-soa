package com.other.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/9/24 15:00
 */
public class TestHashMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < 1000000; i++) {
            map.put(i, i);
        }
    }
}
