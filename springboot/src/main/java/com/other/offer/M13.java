package com.other.offer;

public class M13 {


    /**
     * 机器人的运动范围
     * 地上有一个m行n列的方格，一个机器人从坐标(0,0)开始移动，它每次可以向左，右，上，下移动一格，
     * 但不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如 k=18 (35,37) 3+5+3+7=18 可以进入 (35,38) 3+5+3+8 = 19 不能进入
     * <p>
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int count = movingCountCore(m, n, k, 0, 0, visited);
        return count;
    }

    private int movingCountCore(int m, int n, int k, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || (getDigitSum(x) + getDigitSum(y)) > k) return 0;
        int count = 0;
        visited[x][y] = true;
        count++;
        count += movingCountCore(m, n, k, x + 1, y, visited);
        count += movingCountCore(m, n, k, x - 1, y, visited);
        count += movingCountCore(m, n, k, x, y + 1, visited);
        count += movingCountCore(m, n, k, x, y - 1, visited);
        return count;

    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
