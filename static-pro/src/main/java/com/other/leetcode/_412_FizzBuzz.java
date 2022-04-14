package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 */
public class _412_FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) {

        } else {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    list.add("FizzBuzz");
                } else if (i % 3 == 0) {
                    list.add("Fizz");
                } else if (i % 5 == 0) {
                    list.add("Buzz");
                } else {
                    list.add(String.valueOf(i));
                }
            }
        }
        return list;
    }
}
