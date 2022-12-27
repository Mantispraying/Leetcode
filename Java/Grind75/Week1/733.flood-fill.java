package Grind75.Week1;

/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oColor = image[sr][sc];
        if (color == oColor)
            return image;
        image[sr][sc] = color;
        int[] dir = { 1, 0, -1, 0, 1 };
        for (int i = 1; i < dir.length; i++) {
            int nr = sr + dir[i - 1];
            int nc = sc + dir[i];
            if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == oColor)
                floodFill(image, nr, nc, color);
        }
        return image;
    }
}
// @lc code=end
