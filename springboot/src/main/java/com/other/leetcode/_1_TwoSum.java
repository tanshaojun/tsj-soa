package com.other.leetcode;


/**
 * 1 两数之和
 */
public class _1_TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            int c = target - numbers[i];
            int s = 0;
            int e = numbers.length - 1;
            while (s <= e) {
                int m = s + ((e - s) >> 1);
                if (c == numbers[m] && i != m) {
                    int i1 = i + 1;
                    int i2 = m + 1;
                    if (i1 > i2) {
                        i1 = i1 ^ i2;
                        i2 = i1 ^ i2;
                        i1 = i1 ^ i2;
                    }
                    ints[0] = i1;
                    ints[1] = i2;
                    return ints;
                }
                if (numbers[m] > c) e = m - 1;
                else s = m + 1;
            }
        }
        return ints;
    }
}
