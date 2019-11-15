package com.other.leetcode;

/**
 * 551. 学生出勤记录 I
 */
public class _551_CheckRecord {

    public static boolean checkRecord(String s) {
        int count = 0;
        if (s.length() > 1) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (count == 0 && 'A' == c) {
                    count++;
                } else if (count == 1 && 'A' == c) {
                    return false;
                }
                if ((i - 1) >= 0 && (i - 2) >= 0 && s.charAt(i) == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i - 2) ==
                        'L') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkRecord("LLL"));
    }

}
