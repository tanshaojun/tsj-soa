package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. 二进制手表
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/3 14:25
 */
public class _401_readBinaryWatch {

    List<String> res = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        if (0 == num) {
            res.add("0:00");
            return res;
        }
        int[] hour = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        dfs(num, hour, 0, 0, 0, 0);
        return res;
    }

    private void dfs(int num, int[] s, int hour, int minute, int start, int n) {
        if (n > num) return;
        if (num == n) {
            StringBuilder sb = new StringBuilder();
            sb.append(hour);
            sb.append(":");
            if (minute < 10) {
                sb.append("0");
            }
            sb.append(minute);
            if (!res.contains(sb.toString())) {
                res.add(sb.toString());
            }
            return;
        }

        for (int i = start; i < s.length; i++) {
            if (i >= 0 && i <= 3 && hour + s[i] < 12) {
                dfs(num, s, hour + s[i], minute, i + 1, n + 1);
            }
            if (i > 3 && minute + s[i] < 60) {
                dfs(num, s, hour, minute + s[i], i + 1, n + 1);
            }
        }

    }

}
