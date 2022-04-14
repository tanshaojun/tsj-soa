package com.other.offer;

public class M11 {


    /**
     * 旋转数组的最小数字
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * <p>
     * 采用二分的方法，设置左右两个指针，每次取中间的数组和开头或者结尾比较，如何中间的大于开头，则说明从左到右是有序的，则把mid赋值给left
     * 如何结尾的值大于中间值，则把mid赋值给right。当左右两指针相差一时，最小值的索引就是right。
     *
     * @param arrays
     * @return
     */
    public int min(int[] arrays) {
        if (null == arrays || 0 == arrays.length) return -1;
        int left = 0;
        int right = arrays.length - 1;
        //由于数组是排序的，如果第一个数字小于最后一个数字，就说明数组本身就是排序的，不走循环
        while (arrays[left] >= arrays[right]) {
            if (right - left == 1) return arrays[right];
            int mid = left + ((right - left) >> 1);

            //如果三个数相等时，此时无法判断指针向左还是向右移动，只能顺序查找
            if (arrays[left] == arrays[mid] && arrays[mid] == arrays[right]) {
                int res = arrays[left];
                for (int i = left + 1; i < right; i++) {
                    if (res > arrays[i]) return arrays[i];
                }
            }

            if (arrays[left] <= arrays[mid]) {
                left = mid;
            } else if (arrays[right] >= arrays[mid]) {
                right = mid;
            }
        }
        return arrays[0];
    }

}
