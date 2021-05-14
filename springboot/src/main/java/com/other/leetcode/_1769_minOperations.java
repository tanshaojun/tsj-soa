package com.other.leetcode;

/**
 * 1769. 移动所有球到每个盒子所需的最小操作数
 *
 * @Author tansj
 * @Date 2021-05-11 11:03
 * @Version 1.0
 */
public class _1769_minOperations {

    public int[] minOperations(String boxes) {
        int length = boxes.length();

        int[] leftBox = new int[length];
        int[] leftDp = new int[length];
        leftDp[0] = 0;
        leftBox[0] = boxes.charAt(0) - '0';
        for (int i = 1; i < length; i++) {
            leftDp[i] += leftBox[i - 1];
            leftDp[i] += leftDp[i - 1];
            leftBox[i] += leftBox[i - 1];
            leftBox[i] += boxes.charAt(i) - '0';
        }

        int[] rightBox = new int[length];
        int[] rightDp = new int[length];
        rightDp[length - 1] = 0;
        rightBox[length - 1] = boxes.charAt(length - 1) - '0';
        for (int i = length - 2; i >= 0; i--) {
            rightDp[i] += rightBox[i + 1];
            rightDp[i] += rightDp[i + 1];
            rightBox[i] += rightBox[i + 1];
            rightBox[i] += boxes.charAt(i) - '0';
        }

        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = leftDp[i] + rightDp[i];
        }
        return res;
    }

}
