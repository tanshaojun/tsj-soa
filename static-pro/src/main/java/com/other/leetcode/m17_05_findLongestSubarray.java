package com.other.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.05.  字母与数字
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/5 16:03
 */
public class m17_05_findLongestSubarray {

    public String[] findLongestSubarray(String[] array) {
        if (null == array || 0 == array.length) return new String[]{};
        int count = 0;
        int max = 0;
        int start = -1;
        int end = -1;
        Map<Integer, Integer> map = new HashMap<>(16);
        map.put(0, -1);
        for (int i = 0; i < array.length; i++) {
            char c = array[i].charAt(0);
            if (c >= '0' && c <= '9') {
                count++;
            } else {
                count--;
            }
            if (map.containsKey(count)) {
                Integer right = map.get(count);
                if (i + 1 - right > max) {
                    max = i + 1 - right;
                    start = right + 1;
                    end = i + 1;
                }
            } else {
                map.put(count, i);
            }
        }
        return start == -1 ? new String[]{} : Arrays.copyOfRange(array, start, end);
    }

    /**
     * 超时
     *
     * @param array
     * @return
     */
//    public String[] findLongestSubarray1(String[] array) {
//        if (null == array || 0 == array.length) return new String[]{};
//        int len = array.length;
//        int[][] t = new int[len + 1][2];
//        for (int i = 1; i <= array.length; i++) {
//            char c = array[i - 1].charAt(0);
//            if (c >= '0' && c <= '9') {
//                t[i][0] = t[i - 1][0] + 1;
//                t[i][1] = t[i - 1][1];
//            } else {
//                t[i][0] = t[i - 1][0];
//                t[i][1] = t[i - 1][1] + 1;
//            }
//        }
//        int max = 0;
//        int start = -1;
//        int end = -1;
//        for (int i = 0; i <= len; i++) {
//            for (int j = i + 1 + max; j <= len; j++) {
//                int a = t[j][0] - t[i][0];
//                int b = t[j][1] - t[i][1];
//                if (a > 0 && b > 0 && a == b) {
//                    int min = Math.min(a, b);
//                    if (min > max) {
//                        max = min;
//                        start = i;
//                        end = j;
//                    }
//                }
//            }
//        }
//        return start == -1 ? new String[]{} : Arrays.copyOfRange(array, start, end);
//    }

}
