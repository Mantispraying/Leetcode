package January2023;

import java.util.*;
/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0, pointer = 0;
        for (int i = 0; i < points.length; i++) {
            if (ans == 0 || points[i][0] > pointer) {
                ans++;
                pointer = points[i][1];
            }
        }
        return ans;
    }
}
// @lc code=end