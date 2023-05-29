package May2023;

import java.util.*;

/*
 * @lc app=leetcode id=2130 lang=java
 *
 * [2130] Maximum Twin Sum of a Linked List
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
    public int pairSum(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode point = head;

        while (point != null) {
            arr.add(point.val);
            point = point.next;
        }

        int maxSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            int currTwinSum = arr.get(i) + arr.get(arr.size() - 1 - i);
            if (currTwinSum > maxSum)
                maxSum = currTwinSum;
        }
        return maxSum;
    }
}
// @lc code=end