package com.other.leetcode;

/**
 * 面试题 10.05. 稀疏数组搜索
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/25 16:24
 */
public class m10_05_findString {

    public int findString(String[] words, String s) {
        return find(0, words.length - 1, words, s);
    }

    private int find(int left, int right, String[] words, String s) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ("".equals(words[mid])) {
                int index = find(left, mid - 1, words, s);
                if (-1 == index) return find(mid + 1, right, words, s);
                return index;
            } else {
                int i = s.compareTo(words[mid]);
                if (i == 0) return mid;
                else if (i > 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
