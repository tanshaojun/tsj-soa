package com.other.leetcode;

import java.util.List;

/**
 * 1773. 统计匹配检索规则的物品数量
 *
 * @Author tansj
 * @Date 2021-05-12 15:44
 * @Version 1.0
 */
public class _1773_countMatches {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0;
        if ("color".equals(ruleKey)) {
            index = 1;
        } else if ("name".equals(ruleKey)) {
            index = 2;
        }
        int res = 0;
        for (List<String> item : items) {
            if (ruleValue.equals(item.get(index))) {
                res++;
            }
        }
        return res;
    }

}
