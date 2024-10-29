package April2023;
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
    private Node cloneGraph(Node node, Map<Node, Node> visited) {
        Node copyNode = new Node(node.val);
        visited.put(node, copyNode);
        for (Node neighbour : node.neighbors) {
            if (!visited.containsKey(neighbour))
                copyNode.neighbors.add(cloneGraph(neighbour, visited));
            else
                copyNode.neighbors.add(visited.get(neighbour));

        }
        return copyNode;
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        Map<Node, Node> visited = new HashMap<>();
        return cloneGraph(node, visited);
    }
}
// @lc code=end