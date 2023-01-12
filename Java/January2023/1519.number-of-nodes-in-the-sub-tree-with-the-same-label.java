package January2023;

import java.util.*;
/*
 * @lc app=leetcode id=1519 lang=java
 *
 * [1519] Number of Nodes in the Sub-Tree With the Same Label
 */

// @lc code=start
class Solution {
    private int[] dfs(int node, int parent, HashMap<Integer, List<Integer>> tree, char[] labels, int[] ans) {
        int[] nodeCounts = new int[26];
        nodeCounts[labels[node] - 'a'] = 1;
        if (!tree.containsKey(node))
            return nodeCounts;
        for (int child : tree.get(node)) {
            if (child == parent)
                continue;
            int[] childCount = dfs(child, node, tree, labels, ans);
            for (int i = 0; i < 26; i++) {
                nodeCounts[i] += childCount[i];
            }
        }
        ans[node] = nodeCounts[labels[node] - 'a'];
        return nodeCounts;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        HashMap<Integer, List<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            tree.computeIfAbsent(edge[0], value -> new ArrayList<>()).add(edge[1]);
            tree.computeIfAbsent(edge[1], value -> new ArrayList<>()).add(edge[0]);
        }
        int[] ans = new int[n];
        dfs(0, -1, tree, labels.toCharArray(), ans);
        return ans;
    }
}
// @lc code=end