package com.other.offer;

public class M33 {


    /**
     * 二叉搜索树的后序遍历序列
     *
     * @return
     */
    public boolean verifySquenceOfBST(int[] arr) {
        if (null == arr || arr.length < 2) return true;
        return is(0, arr.length - 1, arr);
    }

    private static boolean is(int left, int right, int[] arr) {
        if (left >= right) return true;
        int r = arr[right];
        int index = left;
        //从右到左找到小于最右的值，记录索引
        for (int i = right - 1; i > left; i--) {
            if (arr[i] < r) {
                index = i;
                break;
            }
        }
        //判断右边是否是二叉搜索树
        boolean b = is(index + 1, right - 1, arr);
        if (b) {
            //如果左边有大于最右边的值，直接返回false
            for (int i = left; i < index; i++) {
                if (r < arr[left]) return false;
            }
            //判断左边是否是二叉搜索树
            return is(left, index, arr);
        }
        return false;
    }

}
