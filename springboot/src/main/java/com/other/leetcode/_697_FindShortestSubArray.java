package com.other.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 697. 数组的度
 */
public class _697_FindShortestSubArray {
    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 5, 2, 3, 6, 4, 9}));

    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.get(num) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(i);
                list.add(i);
                map.put(num, list);
            } else {
                List<Integer> list = map.get(num);
                Integer integer0 = list.get(0);
                Integer integer1 = list.get(1);
                integer0++;

                List<Integer> nlist = new ArrayList<>();
                nlist.add(integer0);
                nlist.add(integer1);
                nlist.add(i);
                map.put(num, nlist);
            }
        }
        int max = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Integer>> next = iterator.next();
            List<Integer> value = next.getValue();
            Integer integer0 = value.get(0);
            Integer integer1 = value.get(1);
            Integer integer2 = value.get(2);
            int i = integer2 - integer1;
            if (integer0 > max) {
                max = integer0;
                max1 = i + 1;
            } else if (integer0 == max) {
                if (i + 1 < max1) {
                    max = integer0;
                    max1 = i + 1;
                }
            }
        }
        return max1;
    }
}
