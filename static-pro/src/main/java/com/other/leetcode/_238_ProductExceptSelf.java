package com.other.leetcode;

/**
 * 238. 除自身以外数组的乘积
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/10/29 17:45
 */
public class _238_ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        //计算左边的乘积
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k *= nums[i];
        }
        k = 1;
        //乘右边的乘积
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i : productExceptSelf(new int[]{1, 2, 3, 4})) {
            System.out.println(i);
        }
    }

}
