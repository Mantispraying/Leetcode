package May2023;

import java.util.*;
/*
 * @lc app=leetcode id=1964 lang=java
 *
 * [1964] Find the Longest Valid Obstacle Course at Each Position
 */

// @lc code=start
class Solution {
    List<Integer> answer;

    private int bisectRight(int[] A, int target, int right) {
        if (right == 0)
            return 0;
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length, lisLength = 0;

        int[] answer = new int[n], lis = new int[n];

        for (int i = 0; i < n; ++i) {
            int height = obstacles[i];

            int idx = bisectRight(lis, height, lisLength);
            if (idx == lisLength)
                lisLength++;

            lis[idx] = height;
            answer[i] = idx + 1;
        }
        return answer;
    }
}
// @lc code=end