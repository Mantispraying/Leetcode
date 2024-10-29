package December2022;

import java.util.*;
/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 */

// @lc code=start
class Solution {
    private boolean dfs(int node, int color, int[] colors, Map<Integer, ArrayList<Integer>> neighbors) {
        colors[node] = color;
        if (!neighbors.containsKey(node))
            return true;
        for (int neighbor : neighbors.get(node)) {
            if (colors[node] == colors[neighbor])
                return false;
            if (colors[neighbor] == -1)
                if (!dfs(neighbor, 1 - color, colors, neighbors))
                    return false;
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, ArrayList<Integer>> neighbors = new HashMap<>();
        for (int[] dislike : dislikes) {
            neighbors.computeIfAbsent(dislike[0], value -> new ArrayList<>()).add(dislike[1]);
            neighbors.computeIfAbsent(dislike[1], value -> new ArrayList<>()).add(dislike[0]);
        }
        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);
        for (int i = 1; i <= n; i++)
            if (colors[i] == -1)
                if (!dfs(i, 0, colors, neighbors))
                    return false;
        return true;
    }
}
// @lc code=end
