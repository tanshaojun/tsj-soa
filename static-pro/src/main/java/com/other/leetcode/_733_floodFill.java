package com.other.leetcode;

/**
 * 733. 图像渲染
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/21 9:55
 */
public class _733_floodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (null == image) return image;
        int x = image.length;
        int y = image[0].length;
        if (sr < 0 || sr >= x || sc < 0 || sc >= y) return image;
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        dfs(image, x, y, sr, sc, newColor, oldColor);
        return image;

    }

    private void dfs(int[][] image, int x, int y, int sr, int sc, int newColor, int oldColor) {
        if (sr < 0 || sr >= x || sc < 0 || sc >= y || image[sr][sc] != oldColor) return;
        image[sr][sc] = newColor;
        dfs(image, x, y, sr - 1, sc, newColor, oldColor);
        dfs(image, x, y, sr, sc + 1, newColor, oldColor);
        dfs(image, x, y, sr + 1, sc, newColor, oldColor);
        dfs(image, x, y, sr, sc - 1, newColor, oldColor);
    }


}
