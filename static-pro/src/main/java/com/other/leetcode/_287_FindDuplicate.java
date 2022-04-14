package com.other.leetcode;

/**
 * 287. 寻找重复数
 * Created with IntelliJ IDEA
 * name tan shaojun
 * Date: 2019/6/15
 * Time: 1:41 PM
 */
public class _287_FindDuplicate {

    public int findDuplicate(int[] nums) {
        if (nums.length <= 1) return -1;
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }


}
