package January2023;

import java.util.*;
/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Non-decreasing Subsequences
 */

// @lc code=start
class Solution {
    private void backTrack(int idx, int[] nums, List<Integer> seq, Set<List<Integer>> res) {
        if (idx >= nums.length) {
            if (seq.size() >= 2) {
                res.add(new ArrayList<>(seq));
            }
            return;
        }
        if (seq.isEmpty() || nums[idx] >= seq.get(seq.size() - 1)) {
            seq.add(nums[idx]);
            backTrack(idx + 1, nums, seq, res);
            seq.remove(seq.size() - 1);
        }
        backTrack(idx + 1, nums, seq, res);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> seq = new ArrayList<>();
        backTrack(0, nums, seq, res);
        return new ArrayList<>(res);
    }
}
// @lc code=end