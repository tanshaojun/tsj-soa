package com.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 229. 求众数 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/12 16:05
 */
public class _229_majorityElement {

    public List<Integer> majorityElement(int[] nums) {
        if (null == nums || 0 == nums.length) return new ArrayList<>();
        if (nums.length < 3) return new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toSet()));
        int index = 0;
        int a = nums[index];
        int a1 = 1;
        int b = 0;
        int b1 = 0;
        index++;
        for (; index < nums.length; index++) {
            if (nums[index] != a) {
                b = nums[index];
                b1 = 1;
                break;
            }
            a1++;
        }
        index++;
        for (; index < nums.length; index++) {
            int num = nums[index];
            if (a1 == 0 && b1 == 0) {
                a1 = 1;
                a = num;
            } else if (a1 == 0 && b1 != 0 && b == num) {
                b1++;
            } else if (a1 == 0 && b1 != 0) {
                a1 = 1;
                a = num;
            } else if (a1 != 0 && b1 == 0 && a == num) {
                a1++;
            } else if (a1 != 0 && b1 == 0) {
                b1 = 1;
                b = num;
            } else if (a1 != 0 && b1 != 0 && a == num) {
                a1++;
            } else if (a1 != 0 && b1 != 0 && b == num) {
                b1++;
            } else {
                a1--;
                b1--;
            }
        }
        int a2 = 0;
        int b2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (a1 > 0 && a == nums[i]) {
                a2++;
            }
            if (b1 > 0 && b == nums[i]) {
                b2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (a2 > nums.length / 3) {
            res.add(a);
        }
        if (b2 > nums.length / 3) {
            res.add(b);
        }
        return res;
    }

}
