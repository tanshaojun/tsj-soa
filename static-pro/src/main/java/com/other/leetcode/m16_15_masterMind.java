package com.other.leetcode;

/**
 * 面试题 16.15. 珠玑妙算
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/3 17:46
 */
public class m16_15_masterMind {
    public int[] masterMind(String solution, String guess) {
        int r = 0;
        int y = 0;
        int g = 0;
        int b = 0;
        int a = 0;
        int c = 0;
        for (int i = 0; i < solution.length(); i++) {
            char s = solution.charAt(i);
            char s1 = guess.charAt(i);
            if (s == s1) {
                a++;
                continue;
            }
            if (s == 'R') {
                if (r < 0) c++;
                r++;
            }
            if (s == 'Y') {
                if (y < 0) c++;
                y++;
            }
            if (s == 'G') {
                if (g < 0) c++;
                g++;
            }
            if (s == 'B') {
                if (b < 0) c++;
                b++;
            }
            if (s1 == 'R') {
                if (r > 0) c++;
                r--;
            }
            if (s1 == 'Y') {
                if (y > 0) c++;
                y--;
            }
            if (s1 == 'G') {
                if (g > 0) c++;
                g--;
            }
            if (s1 == 'B') {
                if (b > 0) c++;
                b--;
            }

        }
        return new int[]{a, c};
    }
}
