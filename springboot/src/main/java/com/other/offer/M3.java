package com.other.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 数组中重复的数字(任意一个即可)
 */
public class M3 {


    /**
     * 在一个长度为n的数组里，所有数字在0～n-1范围内，至少有一个是重复的。请找出其中任意一个重复的数字
     *
     * @param array
     * @return
     */
    public int duplicateNum(int[] array) {
        if (null == array || 0 == array.length) return -1;
        for (int i = 0; i < array.length; i++) {
            while (array[i] != i) {
                if (array[i] == array[array[i]]) return array[i];
                int t = array[i];
                array[i] = array[t];
                array[t] = t;
            }
        }
        return -1;
    }

    /**
     * 在一个长度为n+1的数组里，所有数字在1～n范围内，至少有一个是重复的。请找出其中任意一个重复的数字
     *
     * @param array
     * @return
     */
    public int duplicateNum1(int[] array) {
        if (null == array || 0 == array.length) return -1;
        int left = 1;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int count = 0;
            for (int i = 0; i < array.length; i++)
                if (array[i] >= left && array[i] <= mid) count++;
            if (left == right) if (count > 1) return left;
            if (count > (mid - left + 1))
                right = mid;
            else
                left = mid + 1;
        }
        return -1;
    }


}
