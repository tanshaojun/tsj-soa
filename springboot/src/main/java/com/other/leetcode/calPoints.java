package com.other.leetcode;

import java.util.Stack;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/5/3117:52
 */
public class calPoints {

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String v : ops) {
            if ("+".equals(v)) {
                Integer pop = stack.pop();
                int n = stack.peek() + pop;
                stack.push(pop);
                stack.push(n);
            } else if ("D".equals(v))
                stack.push(2 * stack.peek());
            else if ("C".equals(v))
                stack.pop();
            else
                stack.push(Integer.valueOf(v));
        }
        int sum = 0;
        for (int score : stack) sum += score;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }
}
