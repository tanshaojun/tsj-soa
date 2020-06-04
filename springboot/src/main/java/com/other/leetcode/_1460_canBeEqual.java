package com.other.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * 1460. 通过翻转子数组使两个数组相等
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/3 16:12
 */
public class _1460_canBeEqual {

    public boolean canBeEqual(int[] target, int[] arr) {
        if (null == target && null == arr) return true;
        if (null == target || null == arr || !Objects.equals(target.length, arr.length)) return false;
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) return false;
        }
        return true;
    }

}
