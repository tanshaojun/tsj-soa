package com.other.leetcode;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/19 17:50
 */
public class _976_largestPerimeter {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            int a = A[i - 2];
            int b = A[i - 1];
            int c = A[i];
            if (c < a + b) return a + b + c;
        }
        return 0;
    }

}
