import java.util.*;

/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */

// @lc code=start
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        List<List<Integer>> graph = new ArrayList<>();
        int[] Degree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            Degree[edge[0]]++;
            Degree[edge[1]]++;
        }

        int[] state = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (Degree[i] == 1) {
                queue.offer(i);
            }
        }

        int total = n;
        while (total > 2) {
            int size = queue.size();
            total -= size;

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int neighbor : graph.get(curr)) {
                    Degree[neighbor]--;
                    if (Degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }

            }
        }

        return new ArrayList<>(queue);
    }
}
// @lc code=end
