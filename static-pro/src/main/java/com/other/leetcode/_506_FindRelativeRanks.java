package com.other.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 506. 相对名次
 */
public class _506_FindRelativeRanks {
    public static String[] findRelativeRanks(int[] nums) {
        String[] strings = new String[nums.length];
        int[] ints = Arrays.stream(nums).sorted().toArray();
        Map<Integer, String> map = new HashMap<>(16);
        for (int i = 0; i < ints.length; i++) {
            if (ints.length - i == 1) {
                map.put(ints[i], "Gold Medal");
            } else if ((ints.length - i == 2)) {
                map.put(ints[i], "Silver Medal");
            } else if ((ints.length - i == 3)) {
                map.put(ints[i], "Bronze Medal");
            } else {
                map.put(ints[i], String.valueOf(ints.length - i));
            }
        }
        for (int i = 0; i < nums.length; i++) {
            String s = map.get(nums[i]);
            strings[i] = s;
        }
        return strings;
    }

    public static void main(String[] args) {
        System.out.println(findRelativeRanks(new int[]{}));
    }
}
