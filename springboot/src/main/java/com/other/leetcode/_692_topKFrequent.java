package com.other.leetcode;

import java.util.*;

/**
 * 692. 前K个高频单词
 *
 * @Author tansj
 * @Date 2021-05-20 10:12
 * @Version 1.0
 */
public class _692_topKFrequent {

    public List<String> topKFrequent(String[] words, int k) {

        List<String> res = new ArrayList<>();
        Map<String, Test> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.get(words[i]) == null) {
                map.put(words[i], new Test(1, words[i]));
            } else {
                Test test = map.get(words[i]);
                test.count = test.count + 1;
                map.put(words[i], test);
            }
        }

        PriorityQueue<Test> queue = new PriorityQueue<>(Comparator.comparing(Test::getCount).reversed().thenComparing(Test::getName));
        for (Map.Entry<String, Test> entry : map.entrySet()) {
            queue.add(entry.getValue());
        }

        while (k > 0) {
            res.add(queue.poll().name);
            k--;
        }

        return res;
    }

    class Test {
        int count;
        String name;

        public Test(int count, String name) {
            this.count = count;
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
