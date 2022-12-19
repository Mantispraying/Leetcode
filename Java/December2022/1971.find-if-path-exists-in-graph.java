package December2022;

import java.util.*;
/*
 * @lc app=leetcode id=1971 lang=java
 *
 * [1971] Find if Path Exists in Graph
 */

// @lc code=start
class Solution {
    private boolean dfs(Map<Integer, ArrayList<Integer>> graph, boolean[] seen, int curr, int destination) {
        if (curr == destination)
            return true;
        if (!seen[curr]) {
            seen[curr] = true;
            for (int next : graph.get(curr)) {
                if (dfs(graph, seen, next, destination))
                    return true;
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        boolean[] seen = new boolean[n];
        for (int[] node : edges) {
            graph.computeIfAbsent(node[0], val -> new ArrayList<>()).add(node[1]);
            graph.computeIfAbsent(node[1], val -> new ArrayList<>()).add(node[0]);
        }
        return dfs(graph, seen, source, destination);
    }
}
// @lc code=end
