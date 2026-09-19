import java.util.*;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {

    class Node {
        int key;
        int val;
        Node left, right;

        Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    private int capacity;
    private Node first, last;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        first = new Node(-1, -1);
        last = new Node(-1, -1);
        first.right = last;
        last.left = first;
    }

    private void remove(Node node) {
        Node back = node.right;
        Node front = node.left;
        front.right = back;
        back.left = front;
    }

    private void add(Node node) {
        first.right.left = node;
        node.right = first.right;
        first.right = node;
        node.left = first;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            add(node);
            return;
        }
        if (map.size() == capacity) {
            map.remove(last.left.key);
            remove(last.left);
        }
        Node node = new Node(value, key);
        map.put(key, node);
        add(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
