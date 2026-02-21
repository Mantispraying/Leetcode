import java.util.*;

/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int targetSum = 0;
        for (int i = 0; i < nums.length; i++) {
            targetSum += nums[i];
        }
        if ((targetSum & 1) == 1) {
            return false;
        }
        targetSum = targetSum >> 1;
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = targetSum; i >= num; i--) {
                if (dp[i]) {
                    continue;
                }
                dp[i] = dp[i] || dp[i - num];
                if (dp[targetSum]) {
                    return true;
                }
            }
        }
        return dp[targetSum];
        // Set Implementation
        // Set<Integer> dp = new HashSet<>();
        // dp.add(0);
        // for (int num : nums) {
        // Set<Integer> tempSet = new HashSet<>();
        // for (Integer integer : dp) {
        // tempSet.add(integer);
        // if (num + integer <= targetSum) {
        // tempSet.add(num + integer);
        // }
        // }
        // dp = tempSet;
        // }
        // return dp.contains(targetSum);
    }
}
// @lc code=end
