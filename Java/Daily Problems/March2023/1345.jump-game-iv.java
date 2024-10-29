package March2023;

import java.util.*;
/*
 * @lc app=leetcode id=1345 lang=java
 *
 * [1345] Jump Game IV
 */

// @lc code=start
class Solution {
    public int minJumps(int[] arr) {
        if (arr.length <= 0)
            return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            graph.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visited = new HashSet<>();
        int steps = 0;
        while (!queue.isEmpty()) {
            Queue<Integer> next = new LinkedList<>();
            for (int node : queue) {
                if (node == arr.length - 1)
                    return steps;
                if (node - 1 >= 0 && !visited.contains(node - 1)) {
                    visited.add(node - 1);
                    next.add(node - 1);
                }
                if (node + 1 < arr.length && !visited.contains(node + 1)) {
                    visited.add(node + 1);
                    next.add(node + 1);
                }
                for (int nextNode : graph.get(arr[node])) {
                    if (!visited.contains(nextNode)) {
                        visited.add(nextNode);
                        next.add(nextNode);
                    }
                }
                graph.get(arr[node]).clear();
            }
            queue = next;
            steps++;
        }
        return -1;
    }
}
// @lc code=end