package com.other.leetcode;

/**
 * 75. 颜色分类
 */
public class _75_SortColors {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 0};
        sortColors(ints);
    }

    public static void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length;
        for (int i = 0; i < r; ) {
            if (nums[i] == 0) {
                int t = nums[i];
                nums[i] = nums[l];
                nums[l] = t;
                l++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                r--;
                int t = nums[i];
                nums[i] = nums[r];
                nums[r] = t;
            }
        }
    }

    public static void sortColors1(int[] nums) {
        //zero, [0...zero]==0
        int zero = -1;
        //two,  [two...n-1]==2
        int two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                //swap(nums[i],nums[--two])
                two--;
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
            } else {
                //swap(nums[i++],nums[++zero])
                zero++;
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                i++;
            }
        }
    }
}
