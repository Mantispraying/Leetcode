package January2023;

import java.util.*;
/*
 * @lc app=leetcode id=2246 lang=java
 *
 * [2246] Longest Path With Different Adjacent Characters
 */

// @lc code=start
class Solution {
    private int res;

    public int longestPath(int[] parent, String s) {
        res = 0;
        ArrayList<Integer>[] children = new ArrayList[parent.length];
        for (int i = 0; i < parent.length; i++)
            children[i] = new ArrayList<>();
        for (int i = 1; i < parent.length; i++)
            children[parent[i]].add(i);
        dfs(children, s, 0);
        return res;
    }

    private int dfs(ArrayList<Integer>[] children, String s, int i) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int j : children[i]) {
            int cur = dfs(children, s, j);
            if (s.charAt(j) != s.charAt(i))
                queue.offer(-cur);
        }
        int big1 = queue.isEmpty() ? 0 : -queue.poll();
        int big2 = queue.isEmpty() ? 0 : -queue.poll();
        res = Math.max(res, big1 + big2 + 1);
        return big1 + 1;
    }
}
// @lc code=end