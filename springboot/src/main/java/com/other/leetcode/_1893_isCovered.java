package com.other.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1893. 检查是否区域内所有整数都被覆盖
 *
 * @Author tansj
 * @Date 2021/7/23 上午10:50
 * @Version 1.0
 */
public class _1893_isCovered {


    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int min = -1, max = -1;
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i][0] > max + 1) {
                min = ranges[i][0];
                max = ranges[i][1];
            } else {
                max = Math.max(max, ranges[i][1]);
            }
            if (min <= left && max >= right) {
                return true;
            }
        }
        return false;
    }


}
