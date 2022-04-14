package com.other.leetcode;

/**
 * 686. 重复叠加字符串匹配
 */
public class _686_RepeatedStringMatch {
    public static int repeatedStringMatch(String A, String B) {
        int max = 2 + B.length() / A.length();
        int count = 1;
        StringBuffer sb = new StringBuffer("");
        sb.append(A);
        while (count <= max) {
            if (sb.lastIndexOf(B) > -1) return count;
            count++;
            sb.append(A);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abc", "cabcabca"));
    }
}
