package com.other.leetcode;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/8/6 19:08
 */
public class _1013_CanThreePartsEqualSum {
    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) sum += A[i];
        if (sum % 3 != 0) return false;
        int avg = sum / 3;
        sum = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == avg) {
                sum = 0;
                count++;
            }
            if (count == 2) return true;
        }
        return count == 3;
    }

    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
    }
}
