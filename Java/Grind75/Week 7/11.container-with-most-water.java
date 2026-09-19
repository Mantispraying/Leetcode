import java.util.*;

/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int min = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, (r - l) * (min));
            while (l < r && height[l] <= min) {
                l++;
            }

            while (l < r && height[r] <= min) {
                r--;
            }
        }
        return maxArea;
    }
}
// @lc code=end
