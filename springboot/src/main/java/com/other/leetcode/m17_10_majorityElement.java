package com.other.leetcode;

/**
 * 面试题 17.10. 主要元素
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/26 13:42
 */
public class m17_10_majorityElement {


    /**
     * 摩尔投票法加验证
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                t = nums[i];
                count++;
            } else if (t == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == t) {
                count++;
            }
        }
        return count > nums.length / 2 ? t : -1;
    }

}
