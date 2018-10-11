package com.other.leetcode;

import java.util.HashMap;
import java.util.Map;

public class numJewelsInStones {
    public static   int numJewelsInStones(String J, String S) {
        if ("".equals(J) || "".equals(S)) return 0;
        int count = 0;
        Map<String, Integer> map = new HashMap<>(16);
        for (int i = 0; i < J.length(); i++) {
            map.put(String.valueOf(J.charAt(i)), i);
        }
        for (int i = 0; i < S.length(); i++) {
            String s = String.valueOf(S.charAt(i));
            Integer integer = map.get(s);
            if (integer != null) {
                count++;
            }
        }
        return count;
    }

    public static   void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }
}
