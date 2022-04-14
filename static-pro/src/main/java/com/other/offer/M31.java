package com.other.offer;

import java.util.Stack;

public class M31 {


    /**
     * 栈的压入，弹出序列
     * 设置一个辅助栈，依次把弹出序列压入辅助栈，如果辅助栈顶元素和原始栈栈顶元素相等，则都弹出
     * 最后栈为空就说明弹出序列是栈的压入序列
     *
     * @param pushOrder
     * @param popOrder
     * @return
     */
    public boolean isPopOrder(int[] pushOrder, int[] popOrder) {
        if (null == popOrder || null == popOrder || popOrder.length != pushOrder.length) return false;

        Stack<Integer> push_stack = new Stack<>();
        for (int i : pushOrder) {
            push_stack.push(i);
        }
        //辅助栈
        Stack<Integer> tmp_stack = new Stack<>();
        for (int i : popOrder) {
            tmp_stack.push(i);
            while (!tmp_stack.isEmpty() && !push_stack.isEmpty() && (tmp_stack.peek() == push_stack.peek())) {
                tmp_stack.pop();
                push_stack.pop();
            }
        }
        return push_stack.isEmpty();
    }

}
