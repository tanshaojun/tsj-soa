package com.other.leetcode;

import java.util.HashMap;
import java.util.Map;

public class wordPattern {
    public boolean wordPattern(String pattern, String str) {
        if ("".equals(pattern) || "".equals(str)) {
            return false;
        }
        String[] split = str.split(" ");
        if (split.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>(16);
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                //包含key的情况，要检查对应的value是否一致
                if (!map.get(pattern.charAt(i)).equals(split[i])) {
                    return false;
                }
            } else {
                //不包含key的情况下已经有了对应的value，对应到示例4的错误
                if (map.containsValue(split[i])) {
                    return false;
                } else {
                    map.put(pattern.charAt(i), split[i]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
