import java.util.*;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        int[] interval = Arrays.copyOf(intervals[0], 2);
        for (int i = 1; i < intervals.length; i++) {
            if (interval[1] >= intervals[i][0]) {
                interval[1] = Math.max(interval[1], intervals[i][1]);
            } else {
                merged.add(interval);
                interval = Arrays.copyOf(intervals[i], 2);
            }
        }
        merged.add(interval);
        return merged.toArray(new int[merged.size()][]);
    }
}
// @lc code=end
