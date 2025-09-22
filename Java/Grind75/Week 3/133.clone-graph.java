import java.util.*;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
// @lc code=start
/*
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * public Node() {
 * val = 0;
 * neighbors = new ArrayList<Node>();
 * }
 * public Node(int _val) {
 * val = _val;
 * neighbors = new ArrayList<Node>();
 * }
 * public Node(int _val, ArrayList<Node> _neighbors) {
 * val = _val;
 * neighbors = _neighbors;
 * }
 * }
 */

class Solution {
    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Node ans = new Node(node.val);
        map.put(node.val, ans);
        for (Node neighbor : node.neighbors) {
            if (map.containsKey(neighbor.val)) {
                ans.neighbors.add(map.get(neighbor.val));
            } else {
                ans.neighbors.add(cloneGraph(neighbor));
            }
        }
        return ans;
    }
}
// @lc code=end
