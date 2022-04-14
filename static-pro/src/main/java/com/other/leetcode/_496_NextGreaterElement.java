package com.other.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 */
public class _496_NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i : nums2) {
            while (!stack.isEmpty() && stack.peek() < i) {
                Integer pop = stack.pop();
                if (map.containsKey(pop)) res[map.get(pop)] = i;
            }
            stack.add(i);
        }
        return res;
    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int len = nums2.length - 1;
        for (int i = 0; i < nums1.length; i++) {
            int tmp = nums1[i];
            nums1[i] = -1;
            boolean flag = false;
            for (int j = 0; j <= len; j++) {
                if (tmp == nums2[j]) {
                    flag = true;
                }
                if (flag) {
                    if (tmp < nums2[j]) {
                        nums1[i] = nums2[j];
                        break;
                    }
                }
            }
        }
        return nums1;
    }

}
