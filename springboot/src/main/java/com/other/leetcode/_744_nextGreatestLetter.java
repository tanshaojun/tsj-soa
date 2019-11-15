package com.other.leetcode;

/**
 * 744. 寻找比目标字母大的最小字母
 */
public class _744_nextGreatestLetter {
    public static char nextGreatestLetter(char[] letters, char target) {
        for (char c : letters) {
            if (c > target) return c;
        }
        return letters[0];
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'z'));
    }
}
