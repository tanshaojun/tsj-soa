package com.other.nieke;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/14 14:23
 */
public class KMPTest {

    public int kmp(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int start1 = 0;
        int start2 = 0;
        int[] nextArr = getNextArr(s2);
        while (start1 < s1.length() && start2 < s2.length()) {
            if (str1[start1] == str2[start2]) {
                start1++;
                start2++;
            } else if (nextArr[start2] == -1) {
                start1++;
            } else {
                start2 = nextArr[start2];
            }
        }
        return start2 == s2.length() ? start1 - start2 : -1;
    }

    private int[] getNextArr(String s2) {
        if (1 == s2.length()) return new int[]{-1};
        int[] next = new int[s2.length()];
        next[0] = -1;
        next[1] = 0;
        int index = 2;
        int preNum = 0;
        char[] chars = s2.toCharArray();
        while (index < s2.length()) {
            if (chars[index - 1] == chars[preNum]) {
                next[index++] = ++preNum;
            } else if (preNum > 0) {
                preNum = next[preNum];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }

}
