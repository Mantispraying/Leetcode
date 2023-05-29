package May2023;

import java.util.*;
/*
 * @lc app=leetcode id=1557 lang=java
 *
 * [1557] Minimum Number of Vertices to Reach All Nodes
 */

// @lc code=start
class Solution {
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    // List to signify if the vertex has an incoming edge or not.
    boolean[] isIncomingEdgeExists = new boolean[n];
    for (List<Integer> edge : edges) {
      isIncomingEdgeExists[edge.get(1)] = true;
    }

    List<Integer> requiredNodes = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      // Store all the nodes that don't have an incoming edge.
      if (!isIncomingEdgeExists[i]) {
        requiredNodes.add(i);
      }
    }

    return requiredNodes;
  }
}
// @lc code=end