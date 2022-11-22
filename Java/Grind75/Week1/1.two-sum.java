import java.util.*;
/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            Integer diff = target - nums[i];

            if (mp.containsKey(diff)) {

                int[] ans = { mp.get(diff), i };
                return ans;

            }

            mp.put(nums[i], i);
        }
        return null;
    }
}
// @lc code=end
