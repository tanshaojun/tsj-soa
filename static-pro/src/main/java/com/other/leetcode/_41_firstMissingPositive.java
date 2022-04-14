package com.other.leetcode;


/**
 * 41. 缺失的第一个正数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/4 10:38
 */
public class _41_firstMissingPositive {

    /**
     * 原始数组 3,4,-1,1
     * 1.默认期望的数组是排好序的则按 1 2 3 4 排列
     * 设置两个指针，left指针表示排好序的结束位置，right表示数组的长度
     * 第一个判断：假如数组中的值大于数组的长度或者小于等0,则该数组的长度需要减少 则期望的数组长度减少,right减少
     * 第二个判断：如果当前位置上的值是对的，index++，left++ 则说明left前面排好序了
     * 第三个判断：
     * a.如果3不在索引2的位置上，则交换
     * b.如果3在索引2的位置上,则说明重复了，期望的数组长度减少，right减少
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (null == nums || 0 == nums.length) return 1;
        int left = 0;
        int right = nums.length;
        int index = 0;
        while (index < right) {
            if (nums[index] > right || nums[index] <= left) {
                swap(nums, index, --right);
            } else if (nums[index] == index + 1) {
                index++;
                left++;
            } else {
                if (nums[nums[index] - 1] == nums[index]) {
                    swap(nums, index, --right);
                } else {
                    swap(nums, nums[index] - 1, index);
                }
            }
        }
        return left + 1;
    }

    private void swap(int[] arr, int l, int r) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

}
