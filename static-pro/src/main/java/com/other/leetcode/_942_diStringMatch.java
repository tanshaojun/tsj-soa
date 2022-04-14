package com.other.leetcode;

/**
 * 942. 增减字符串匹配
 */
public class _942_diStringMatch {
    public static void main(String[] args) {
        System.out.println(diStringMatch("DDI"));

    }

    public static int[] diStringMatch(String S) {
        int[] ints = new int[S.length() + 1];
        int l = 0;
        int r = S.length();
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'I') {
                ints[i] = l++;
            }
            if (chars[i] == 'D') {
                ints[i] = r--;
            }
        }
        ints[chars.length] = l;
        return ints;
    }
}
