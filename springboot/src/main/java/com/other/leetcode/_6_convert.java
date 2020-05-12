package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 6. Z 字形变换
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/12 11:06
 */
public class _6_convert {

    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(new StringBuilder());
        }
        int row = 0;
        boolean flags = false;
        for (char c : s.toCharArray()) {
            list.get(row).append(c);
            if (0 == row || numRows - 1 == row) flags = !flags;
            row += flags ? 1 : -1;
        }
        StringBuffer sb = new StringBuffer();
        for (StringBuilder l : list) {
            sb.append(l);
        }
        return sb.toString();
    }


    public String convert1(String s, int numRows) {
        if (1 == numRows) return s;
        int len = s.length();
        char[][] t = new char[numRows][len];
        int a = 0;
        int c = 0;
        for (int i = 0; i < len; ) {
            if (a < numRows) {
                t[a++][c] = s.charAt(i);
                i++;
            } else {
                a--;
                while (a > 0) {
                    if (i >= len) break;
                    t[--a][++c] = s.charAt(i);
                    i++;
                }
                a++;
            }
        }
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if (!Objects.equals(t[i][j], '\u0000')) {
                    sb.append(t[i][j]);
                }
            }
        }
        return sb.toString();
    }

}
