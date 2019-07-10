package com.other.leetcode;

/**
 * 287. 寻找重复数
 * Created with IntelliJ IDEA
 * name tan shaojun
 * Date: 2019/6/15
 * Time: 1:41 PM
 */
public class _287_FindDuplicate {

    public static int findDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }
        int index = nums[0];
        int index1 = nums[nums[0]];
        while (index != index1) {
            index = nums[index];
            index1 = nums[nums[index1]];
        }
        index = 0;
        while (index != index1) {
            index = nums[index];
            index1 = nums[index1];
        }
        return index1;

    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 2, 4, 2}));
    }
}
