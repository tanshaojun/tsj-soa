package com.other.leetcode;

import com.other.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 590. N叉树的后序遍历
 */
public class _590_Postorder {
    public static List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>(16);
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack1 = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            stack1.push(pop);
            for (int i = 0; i < pop.children.size(); i++) {
                stack.push(pop.children.get(i));
            }
        }
        while (!stack1.isEmpty()) {
            list.add(stack1.pop().val);
        }
        return list;
    }
}
