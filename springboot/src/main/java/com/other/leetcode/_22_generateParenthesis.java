package com.other.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 22. 括号生成
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/2 17:52
 */
public class _22_generateParenthesis {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n, "");
        return res;
    }

    private void dfs(int leftN, int rightN, int n, String s) {
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }
        if (leftN < n) {
            dfs(leftN + 1, rightN, n, s + "(");
        }
        if (rightN < leftN) {
            dfs(leftN, rightN + 1, n, s + ")");
        }

    }

    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        res.add("");
        while (n > 0) {
            Set<String> set = new HashSet<>();
            for (String re : res) {
                for (int i = 0; i <= re.length(); i++) {
                    set.add(String.format("%s%s%s", re.substring(0, i), "()", re.substring(i)));
                }
            }
            res = new ArrayList<>(set);
            n--;
        }
        Collections.sort(res);
        return res;
    }

}
