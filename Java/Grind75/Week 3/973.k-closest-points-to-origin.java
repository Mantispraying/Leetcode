import java.util.*;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (k == points.length) {
            return points;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (p1, p2) -> Double.compare(p2[0] * p2[0] + p2[1] * p2[1],
                        p1[0] * p1[0] + p1[1] * p1[1]));
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.toArray(new int[0][0]);
    }
}
// @lc code=end
