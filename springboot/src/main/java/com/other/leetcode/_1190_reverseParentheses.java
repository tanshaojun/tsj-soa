package com.other.leetcode;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 1190. 反转每对括号间的子串
 *
 * @Author tansj
 * @Date 2021/5/26 下午3:41
 * @Version 1.0
 */
public class _1190_reverseParentheses {

    public static void main(String[] args) {
        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    public static String reverseParentheses(String s) {
        if (null == s || 0 == s.length()) {
            return s;
        }
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ')') {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    queue.add(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                while (!queue.isEmpty()) {
                    stack.add(queue.poll());
                }
            } else {
                stack.add(String.valueOf(c));
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
