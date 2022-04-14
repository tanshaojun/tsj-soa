package com.other.leetcode;

import java.util.Arrays;

/**
 * 1366. 通过投票对团队排名
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/12 17:06
 */
public class _1366_rankTeams {

    public String rankTeams(String[] votes) {
        if (null == votes) return "";
        int len = votes[0].length();
        int[][] rank = new int[26][len + 1];
        for (int i = 0; i < 26; i++) {
            rank[i][len] = i;
        }
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                rank[vote.charAt(i) - 'A'][i] += 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(rank, (a, b) -> {
                    for (int i = 0; i < len; i++) {
                        if (a[i] != b[i]) {
                            return -a[i] + b[i];
                        }
                    }
                    return a[len] - b[len];
                }
        );
        for (int i = 0; i < len; i++) {
            sb.append((char) ('A' + rank[i][len]));
        }
        return sb.toString();
    }

}
