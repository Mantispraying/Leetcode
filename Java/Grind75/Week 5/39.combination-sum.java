import java.util.*;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int pos, int[] candidates, int target, int sum, List<Integer> curr, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (sum > target || pos >= candidates.length) {
            return;
        }
        curr.add(candidates[pos]);
        dfs(pos, candidates, target, sum + candidates[pos], curr, ans);
        curr.remove(curr.size() - 1);
        dfs(pos + 1, candidates, target, sum, curr, ans);
    }
}
// @lc code=end
