import java.util.*;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> tempList = new ArrayList<>();
            for (List<Integer> list : res) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(num);
                tempList.add(temp);
            }
            res.addAll(tempList);
        }
        return res;
    }
}
// @lc code=end
