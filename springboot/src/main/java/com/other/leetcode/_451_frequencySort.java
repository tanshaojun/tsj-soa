package com.other.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. 根据字符出现频率排序
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/15 15:40
 */
public class _451_frequencySort {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (Character c : map.keySet()) {
            pq.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Character c = pq.poll();
            Integer size = map.get(c);
            while (size > 0) {
                sb.append(c);
                size--;
            }
        }
        return sb.toString();
    }

}
