import java.util.*;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pair : prerequisites) {
            graph[pair[1]].add(pair[0]);
            indegree[pair[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int ele = queue.poll();
            order.add(ele);
            for (int curr : graph[ele]) {
                indegree[curr]--;
                if (indegree[curr] == 0) {
                    queue.offer(curr);
                }
            }
        }
        if (order.size() != numCourses) {
            return new int[0];
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < res.length; i++) {
            res[i] = order.get(i);
        }
        return res;
    }
}
// @lc code=end
