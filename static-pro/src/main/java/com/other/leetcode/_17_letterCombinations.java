package com.other.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 17. 电话号码的字母组合
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/3 11:24
 */
public class _17_letterCombinations {

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (null == digits || "".equals(digits) || 0 == digits.length()) return new ArrayList<>();
        Map<Character, String> dicMap = new HashMap<>(16);
        dicMap.put('2', "abc");
        dicMap.put('3', "def");
        dicMap.put('4', "ghi");
        dicMap.put('5', "jkl");
        dicMap.put('6', "mno");
        dicMap.put('7', "pqrs");
        dicMap.put('8', "tuv");
        dicMap.put('9', "wxyz");
        dfs(dicMap, digits, 0, "");
        return res;
    }

    private void dfs(Map<Character, String> dicMap, String digits, int index, String curStr) {
        if (Objects.equals(digits.length(), curStr.length())) {
            res.add(curStr);
            return;
        }
        String dicStr = dicMap.get(digits.charAt(index));
        for (int j = 0; j < dicStr.length(); j++) {
            dfs(dicMap, digits, index + 1, curStr + dicStr.charAt(j));
        }
    }

}
