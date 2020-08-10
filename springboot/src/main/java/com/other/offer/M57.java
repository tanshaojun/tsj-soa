package com.other.offer;


public class M57 {


    /**
     * 和为s的数字
     * <p>
     * 设置两个指针，左指针指向数组的开头，右指针指向结尾，由于数组是递增的
     * 相加如果大于s，则右指针向左移动，
     * 小于s，则左指针向右移动
     *
     * @param arr
     * @return
     */
    public int[] findNumberWithSum(int[] arr, int s) {
        if (null == arr || arr.length < 2) return null;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] > s) {
                right--;
            } else if (arr[left] + arr[right] < s) {
                left++;
            } else {
                return new int[]{arr[left], arr[right]};
            }
        }
        return null;
    }


    /**
     * 和为s的连续正数序列
     *
     * @param s
     */
    public void findContinuousSequence(int s) {
        if (s < 3) return;
        int left = 1;
        int right = 2;
        int sum = left + right;
        //s+1 是为了奇数多循环一次
        int mid = (s + 1) / 2;
        while (left < mid) {
            //相等则输出
            if (sum == s) {
                for (int i = left; i <= right; i++) {
                    System.out.print(i);
                }
                System.out.println();
            }
            //大于s，则减少，在判断
            while (sum > s && left < mid) {
                sum -= left;
                left++;
                if (sum == s) {
                    for (int i = left; i <= right; i++) {
                        System.out.print(i);
                    }
                    System.out.println();
                }
            }
            right++;
            sum += right;
        }
    }

}
