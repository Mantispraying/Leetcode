import java.util.*;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : prerequisites) {
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
        }
        // int[] vis = new int[numCourses];
        // int[] pathVis = new int[numCourses];
        // for (int key : graph.keySet()) {
        // if (!dfs(graph, vis, key, pathVis)) {
        // return false;
        // }
        // }
        return bfs(numCourses, prerequisites, graph);
    }

    private boolean bfs(int numCourses, int[][] prerequisites, Map<Integer, List<Integer>> graph) {
        int[] indegree = new int[numCourses];
        List<Integer> sorted = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int[] pair : prerequisites) {
            indegree[pair[1]]++;
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                sorted.add(i);
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int ele = queue.poll();
            for (Integer i : graph.getOrDefault(ele, new ArrayList<>())) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    sorted.add(i);
                    queue.offer(i);
                }

            }
        }
        if (sorted.size() != numCourses) {
            return false;
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int[] vis, int i, int[] pathVis) {
        if (vis[i] == 1) {
            return true;
        }
        if (pathVis[i] == 1) {
            return false;
        }
        pathVis[i] = 1;
        for (int course : graph.getOrDefault(i, new ArrayList<>())) {
            if (!dfs(graph, vis, course, pathVis)) {
                return false;
            }
        }
        pathVis[i] = 0;
        vis[i] = 1;
        return true;
    }
}
// @lc code=end
