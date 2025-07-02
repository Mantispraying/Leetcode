import java.util.*;

/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        int originalColor = image[sr][sc];
        image[sr][sc] = color;
        if ((sr + 1) < image.length && image[sr + 1][sc] == originalColor) {
            floodFill(image, sr + 1, sc, color);
        }
        if ((sr - 1) >= 0 && image[sr - 1][sc] == originalColor) {
            floodFill(image, sr - 1, sc, color);
        }
        if ((sc + 1) < image[0].length && image[sr][sc + 1] == originalColor) {
            floodFill(image, sr, sc + 1, color);
        }
        if ((sc - 1) >= 0 && image[sr][sc - 1] == originalColor) {
            floodFill(image, sr, sc - 1, color);
        }
        return image;
    }
}
// @lc code=end
