package com.other.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 349. 两个数组的交集
 */
public class _349_Intersection {
    public static void main(String[] args) {
        System.out.println(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.get(nums2[i]) != null) {
                set.add(nums2[i]);
            }
        }
        int[] ints = new int[set.size()];
        List<Integer> list = new ArrayList<>();
        list.addAll(set);
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}
