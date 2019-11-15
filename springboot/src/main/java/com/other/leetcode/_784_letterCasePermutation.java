package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/15 11:35
 */
public class _784_letterCasePermutation {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<String>();
        dfs(S.toCharArray(), ans, 0);
        return ans;
    }

    public static void dfs(char[] arr, List<String> e, int index) {
        if (index == arr.length) {
            e.add(String.valueOf(arr));
            return;
        }
        dfs(arr, e, index + 1);
        if (arr[index] < '0' || arr[index] > '9') {
            arr[index] ^= 32;
            dfs(arr, e, index + 1);
        }
    }

}
