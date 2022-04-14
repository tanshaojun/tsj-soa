package com.other.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1346. 检查整数及其两倍数是否存在
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/26 15:04
 */
public class _1346_checkIfExist {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i : arr) {
            if (i == 0) {
                count++;
            } else {
                set.add(i);
            }
        }
        if (count >= 2) {
            return true;
        }
        for (int i : arr) {
            if ((i & 1) == 0) {
                if (set.contains(i * 2) || set.contains(i / 2)) {
                    return true;
                }
            } else {
                if (set.contains(i * 2)) {
                    return true;
                }
            }
        }
        return false;
    }

}
