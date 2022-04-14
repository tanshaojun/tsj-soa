package com.other.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 383. 赎金信
 */
public class _383_CanConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> map = new HashMap<>(16);
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.get(String.valueOf(ransomNote.charAt(i))) == null) {
                map.put(String.valueOf(ransomNote.charAt(i)), 1);
            } else {
                Integer integer = map.get(String.valueOf(ransomNote.charAt(i)));
                map.put(String.valueOf(ransomNote.charAt(i)), ++integer);
            }
        }
        for (int i = 0; i < magazine.length(); i++) {
            if (map.get(String.valueOf(magazine.charAt(i))) != null) {
                Integer integer = map.get(String.valueOf(magazine.charAt(i)));
                map.put(String.valueOf(magazine.charAt(i)), --integer);
            }
        }
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            Integer value = next.getValue();
            if (value > 0) return false;
        }
        return true;
    }
}
