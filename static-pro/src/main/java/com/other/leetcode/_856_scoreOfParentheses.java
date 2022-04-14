package com.other.leetcode;

import java.util.Stack;

/**
 * 856. 括号的分数
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/1119:40
 */
public class _856_scoreOfParentheses {

    public static int scoreOfParentheses(String S) {
        int cur = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(cur);
                cur = 0;
            } else {
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }

    public static int scoreOfParentheses1(String S) {
        Stack<String> stack = new Stack<>();
        int sum = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(String.valueOf(c));
            } else {
                String pop = stack.pop();
                if ("(".equals(pop)) {
                    stack.push("1");
                } else {
                    String peek = stack.peek();
                    if ("(".equals(peek)) {
                        stack.pop();
                        stack.push(Integer.valueOf(pop) * 2 + "");
                    } else {
                        while (!"(".equals(pop)) {
                            sum += Integer.valueOf(pop);
                            pop = stack.pop();
                        }
                        stack.push(Integer.valueOf(sum) * 2 + "");
                        sum = 0;
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            sum += Integer.valueOf(stack.pop());
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(()(()()))"));
    }
}
