package com.utils;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/22 10:10
 */
public class ArrayUtil {
    /**
     * 随机数组生成器
     *
     * @param minSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int minSize, int maxValue) {
        int[] arr = new int[(int) ((minSize + 1) * Math.random()) + 5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (maxValue * Math.random());
            System.out.print(arr[i]);
            System.out.print("  ");
        }
        return arr;
    }
}
