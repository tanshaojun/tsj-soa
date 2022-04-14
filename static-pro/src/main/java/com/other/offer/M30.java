package com.other.offer;

import java.util.Stack;

public class M30 {

    /**
     * 包含min函数的栈
     */
    class MinStack {
        Stack<Integer> data_stack = null;
        Stack<Integer> min_stack = null;

        public MinStack() {
            data_stack = new Stack<>();
            min_stack = new Stack<>();
        }

        /**
         * 添加一个元素
         * min栈永远保存最小的元素，当添加的元素比min栈栈顶的元素小时，则入栈，否则在添加一次min栈中栈顶的值
         *
         * @param val
         */
        public void push(int val) {
            int min = val;
            if (!min_stack.isEmpty() && min < val) {
                min = min_stack.peek();
            }
            data_stack.push(val);
            min_stack.push(min);
        }

        /**
         * 直接从min栈中获取就行
         *
         * @return
         */
        public int getMin() {
            if (!min_stack.isEmpty()) {
                return min_stack.peek();
            }
            return -1;
        }

        /**
         * 弹出一个元素
         *
         * @return
         */
        public int pop() {
            if (!data_stack.isEmpty()) {
                min_stack.pop();
                return data_stack.pop();
            }
            return -1;
        }
    }


}
