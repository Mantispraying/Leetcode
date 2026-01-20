import java.util.*;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int index, List<Integer> curr, List<List<Integer>> ans) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (index == nums.length) {
            return;
        }
        if (!curr.contains(nums[index])) {
            curr.add(nums[index]);
            dfs(nums, 0, curr, ans);
            curr.remove(curr.size() - 1);
        }
        dfs(nums, index + 1, curr, ans);
    }
}
// @lc code=end
