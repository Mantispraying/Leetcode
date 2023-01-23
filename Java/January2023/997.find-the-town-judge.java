package January2023;

import java.util.*;
/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 */

// @lc code=start
class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            map.computeIfAbsent(trust[i][0], (val) -> new ArrayList<>()).add(trust[i][1]);
        }
        int townJudge = 0;
        for (int i = 0; i <= n; i++) {
            if (!map.containsKey(i)) {
                if (townJudge != 0)
                    return -1;
                else
                    townJudge = i;
            }
        }
        for (List<Integer> list : map.values()) {
            if (!list.contains(townJudge))
                return -1;
        }
        return townJudge;
    }
}
// @lc code=end