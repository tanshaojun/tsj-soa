package com.other.leetcode;

public class search {
    public static   void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 10, 12}, 9));
    }

    public static   int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int m = s + ((e - s) >> 1);
            if (nums[m] == target) return m;
            if (nums[m] > target) e = m - 1;
            else s = m + 1;
        }
        return -1;

    }
}
