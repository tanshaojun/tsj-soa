package com.other.offer;

public class M42 {

    /**
     * 连续子数组的最大和
     *
     * @param arr
     * @return
     */
    public int findGreatestSumOfSubArray(int[] arr) {
        if (null == arr || 0 == arr.length) return 0;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i : arr) {
            cur += i;
            max = Math.max(max, cur);
            if (cur < 0) cur = 0;
        }
        return max;
    }

}
