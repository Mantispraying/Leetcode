package May2023;

import java.util.*;
/*
 * @lc app=leetcode id=1035 lang=java
 *
 * [1035] Uncrossed Lines
 */

// @lc code=start
class Solution {
    private int maxUncrossedLines(int[] nums1, int[] nums2, int num1, int num2, int[][] dp) {
        if (num1 < 0 || num2 < 0)
            return 0;
        if (dp[num1][num2] != -1)
            return dp[num1][num2];
        if (nums1[num1] == nums2[num2])
            return dp[num1][num2] = maxUncrossedLines(nums1, nums2, num1 - 1, num2 - 1, dp) + 1;
        return dp[num1][num2] = Math.max(maxUncrossedLines(nums1, nums2, num1 - 1, num2, dp),
                maxUncrossedLines(nums1, nums2, num1, num2 - 1, dp));
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxUncrossedLines(nums1, nums2, nums1.length - 1, nums2.length - 1, dp);
    }
}
// @lc code=end