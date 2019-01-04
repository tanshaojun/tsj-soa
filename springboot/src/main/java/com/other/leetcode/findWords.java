package com.other.leetcode;

import java.util.HashMap;
import java.util.Map;

public class findWords {
    public static void main(String[] args) {
        String[] words = findWords(new String[]{"asdfghjklASDFGHJKLasdfghjklASDFGHJKLzxcvbnmZXCVBNMaew",
                "asdfghjklASDFGHJKLqwertyuiopQWERTYUIOP",
                "zxcvbnmZXCVBNMaewzxcvbnmZXCVBNMaewzxcvbnmZXCVBNMaewzxcvbnmZXCVBNMaew"});
        System.out.println(words);
    }

    public static String[] findWords(String[] words) {
        if (words.length == 0) return words;
        StringBuffer strings = new StringBuffer("");
        String s = "qwertyuiop".toLowerCase();
        String s1 = "asdfghjkl".toLowerCase();
        String s2 = "zxcvbnm".toLowerCase();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Map<String, String> map = null;
            Map<String, String> map1 = null;
            Map<String, String> map2 = null;
            for (int j = 0; j < word.length(); j++) {
                String c = String.valueOf(word.charAt(j)).toLowerCase();
                if (s.contains(c)) {
                    if (map == null) {
                        map = new HashMap<>(16);
                    }
                } else if (s1.contains(c)) {
                    if (map1 == null) {
                        map1 = new HashMap<>(16);
                    }
                } else if (s2.contains(c)) {
                    if (map2 == null) {
                        map2 = new HashMap<>(16);
                    }
                }
            }
            if ((map != null && map1 != null) || (map != null && map2 != null) || (map2 != null && map1 != null) ||
                    (map2 != null && map1 != null && map != null)) {
            } else {
                strings.append(word);
                if (i != words.length - 1) {
                    strings.append(",");
                }
            }
        }
        String s3 = strings.toString();
        if ("".equals(s3)) return new String[]{};
        return s3.split(",");
    }
}
