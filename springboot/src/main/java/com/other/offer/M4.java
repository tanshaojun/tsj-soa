package com.other.offer;

public class M4 {
    
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排列
     * 输入一个整数，判断数组中是否含有该整数 。
     *
     * @param array
     * @return
     */
    public boolean find(int[][] array, int num) {
        if (null == array || 0 == array.length) return false;
        int x = array.length;
        int y = array[0].length;

        int a = 0;
        int b = y - 1;

        while (a < x && b >= 0) {
            if (array[a][b] > num) {
                b--;
            } else if (array[a][b] < num) {
                a++;
            } else {
                return true;
            }
        }
        return false;
    }

}
