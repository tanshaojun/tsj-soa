package com.other.leetcode;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/7/22 10:20
 */
public class m11_minArray {

    public int minArray(int[] numbers) {
        if (null == numbers || 0 == numbers.length) return -1;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

}
