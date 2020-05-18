package com.other.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1452. 收藏清单
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/18 18:54
 */
public class _1452_peopleIndexes {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> a = favoriteCompanies.get(i);
            boolean flags = true;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i == j) continue;
                List<String> b = favoriteCompanies.get(j);
                Set<String> s = new HashSet<>(b);
                if (s.containsAll(a)) {
                    flags = false;
                    break;
                }
            }
            if (flags) res.add(i);

        }
        return res;
    }

}
