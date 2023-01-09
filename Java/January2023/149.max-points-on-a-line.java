package January2023;

import java.util.*;
/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        if (points.length == 1)
            return points.length;
        int linePoints = 2;
        for (int[] point1 : points) {
            HashMap<Double, Integer> freq = new HashMap<>();
            for (int[] point2 : points) {
                if (point1 == point2)
                    continue;
                double slope = 0;
                if (point2[0] == point1[0])
                    slope = Double.POSITIVE_INFINITY;
                else
                    slope = (point2[1] - point1[1]) / (double) (point2[0] - point1[0]);
                freq.merge(slope, 1, Integer::sum);
            }
            linePoints = Math.max(linePoints, Collections.max(freq.values()) + 1);
        }
        return linePoints;
    }
}
// @lc code=end