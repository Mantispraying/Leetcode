package May2023;

/*
 * @lc app=leetcode id=1721 lang=java
 *
 * [1721] Swapping Nodes in a Linked List
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode start = head, end = head;
        for (int i = 1; i < k; i++)
            start = start.next;
        ListNode point = start;
        while (point.next != null) {
            point = point.next;
            end = end.next;
        }
        int temp = start.val;
        start.val = end.val;
        end.val = temp;
        return head;
    }
}
// @lc code=end