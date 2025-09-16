import java.util.*;

/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
 * public v
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
// @lc code=end
