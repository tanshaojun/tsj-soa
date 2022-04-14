package com.other.offer;

public class M29 {


    /**
     * 顺时针打印矩阵
     *
     * @param arr
     */
    public void printMatrixClockwisely(int[][] arr) {
        if (null == arr || 0 == arr.length) return;
        int x = arr.length;
        int y = arr[0].length;
        int start = 0;
        while (x > start * 2 && y > start * 2) {
            int endX = y - start - 1;
            int endY = x - start - 1;
            //从左到右打印
            for (int i = start; i <= endX; i++) {
                System.out.print(arr[start][i]);
            }
            if (start < endY) {
                //从上到下打印
                for (int i = start + 1; i <= endY; i++) {
                    System.out.print(arr[i][endX]);
                }
            }
            if (start < endX && start < endY) {
                //从右到左打印
                for (int i = endX - 1; i >= start; i--) {
                    System.out.print(arr[endY][i]);
                }
            }
            if (start < endX && start < endY - 1) {
                //从下到上打印
                for (int i = endY - 1; i >= start + 1; i--) {
                    System.out.print(arr[i][start]);
                }
            }
            start++;
        }

    }


}
