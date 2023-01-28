package January2023;

import java.util.*;
/*
 * @lc app=leetcode id=352 lang=java
 *
 * [352] Data Stream as Disjoint Intervals
 */

// @lc code=start
class SummaryRanges {
    List<int[]> ranges;

    public SummaryRanges() {
        ranges = new ArrayList<>();
    }

    public void addNum(int value) {
        int[] newInterval = { value, value };
        List<int[]> newRanges = new ArrayList<>();
        for (int[] range : ranges) {
            if (range[1] < newInterval[0] - 1) {
                newRanges.add(range);
            } else if (newInterval[1] < range[0] - 1) {
                newRanges.add(newInterval);
                newInterval = range;
            } else {
                newInterval[0] = Math.min(newInterval[0], range[0]);
                newInterval[1] = Math.max(newInterval[1], range[1]);
            }
        }
        newRanges.add(newInterval);
        ranges = newRanges;
    }

    public int[][] getIntervals() {
        return ranges.toArray(new int[ranges.size()][2]);
    }
}
/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
// @lc code=end