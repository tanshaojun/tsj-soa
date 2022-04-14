package com.other.leetcode;

/**
 * 面试题 08.03. 魔术索引
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/30 15:02
 */
public class m08_03_findMagicIndex {

    /**
     * O(n)
     *
     * @param nums
     * @return
     */
    public int findMagicIndex1(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums.length) break;
            if (i == nums[i]) return i;
        }
        return res;
    }

    int s = -1;

    /**
     * 二分
     *
     * @param nums
     * @return
     */
    public int findMagicIndex(int[] nums) {
        search(nums, 0, nums.length - 1);
        return s;
    }

    private void search(int[] nums, int left, int right) {
        if (left > right) return;
        int mid = left + (right - left) >> 1;
        if (mid == nums[mid]) {
            s = mid;
            search(nums, left, mid - 1);
        } else {
            search(nums, left, mid - 1);
            if (s == -1) {
                search(nums, mid + 1, right);
            }
        }
    }

}
