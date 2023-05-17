package May2023;

import java.util.*;
/*
 * @lc app=leetcode id=2215 lang=java
 *
 * [2215] Find the Difference of Two Arrays
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = new HashSet<>();
        Set<Integer> numSet2 = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int num : nums1) {
            numSet1.add(num);
        }
        for (int num : nums2) {
            numSet2.add(num);
        }
        List<Integer> list1 = new ArrayList<>();
        for (Integer num : numSet1) {
            if (!numSet2.contains(num))
                list1.add(num);
        }
        ans.add(0, list1);
        List<Integer> list2 = new ArrayList<>();
        for (Integer num : numSet2) {
            if (!numSet1.contains(num))
                list2.add(num);
        }
        ans.add(1, list2);
        return ans;
    }
}
// @lc code=end