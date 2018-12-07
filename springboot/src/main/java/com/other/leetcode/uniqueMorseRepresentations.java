package com.other.leetcode;

import java.util.HashSet;
import java.util.Set;

public class uniqueMorseRepresentations {
    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] strings = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            StringBuffer sb = new StringBuffer("");
            for (int j = 0; j < chars.length; j++) {
                sb.append(strings[chars[j] - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
