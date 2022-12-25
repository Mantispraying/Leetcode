package December2022;

import java.util.*;

/*
 * @lc app=leetcode id=2389 lang=java
 *
 * [2389] Longest Subsequence With Limited Sum
 */

// @lc code=start
class Solution {
    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + ((r - l) / 2);
            if (nums[m] < target)
                l = m + 1;
            else if (nums[m] > target)
                r = m - 1;
            else
                return m + 1;
        }
        return nums[l] > target ? l : l + 1;
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] answer = new int[queries.length];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = binarySearch(nums, queries[i]);
        }
        return answer;
    }
}

// @lc code=end
class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 4, 5, 2, 1 };
        int[] queries = { 3, 10, 21 };
        sol.answerQueries(nums, queries);
    }
}