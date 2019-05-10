package com.other.leetcode;

public class removeOuterParentheses {
    public static String removeOuterParentheses(String S) {
        char[] chars = S.toCharArray();
        StringBuffer sb = new StringBuffer("");
        int count = 0;
        int a = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
            } else {
                count--;
                if (count == 0) {
                    sb.append(S.substring(a + 1, i));
                    a = i + 1;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
}
