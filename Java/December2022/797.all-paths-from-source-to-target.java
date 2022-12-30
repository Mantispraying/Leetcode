package December2022;

import java.util.*;
/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// @lc code=start
class Solution {
    private List<List<Integer>> getPath(int node, int[][] graph, Map<Integer, List<List<Integer>>> map) {
        if (map.containsKey(node))
            return map.get(node);
        List<List<Integer>> res = new ArrayList<>();
        if (node == graph.length - 1) {
            List<Integer> path = new LinkedList<>();
            path.add(node);
            res.add(path);
        } else {
            for (int nextNode : graph[node]) {
                List<List<Integer>> thisPaths = getPath(nextNode, graph, map);
                for (List<Integer> path : thisPaths) {
                    LinkedList<Integer> newPath = new LinkedList<>(path);
                    newPath.addFirst(node);
                    res.add(newPath);
                }
            }
        }
        map.put(node, res);
        return res;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        return getPath(0, graph, map);
    }
}

// @lc code=end
class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
        sol.allPathsSourceTarget(graph);
    }
}