package January2023;

import java.util.*;
/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] > intervals[i][1])
                newList.add(intervals[i]);
            else if (newInterval[1] < intervals[i][0]) {
                newList.add(newInterval);
                newInterval = intervals[i];
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        newList.add(newInterval);
        return newList.toArray(new int[newList.size()][2]);
    }
}
// @lc code=end