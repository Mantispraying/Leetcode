/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public static void main(String[] args) {
        int n1 = 342;
        int n2 = 465;
        ListNode l1 = new ListNode(n1 % 10), l2 = new ListNode(n2 % 10);
        n1 /= 10;
        n2 /= 10;
        ListNode curr1 = l1, curr2 = l2;
        while (n1 != 0) {
            curr1.next = new ListNode(n1 % 10);
            curr1 = curr1.next;
            n1 /= 10;
        }
        while (n2 != 0) {
            curr2.next = new ListNode(n2 % 10);
            curr2 = curr2.next;
            n2 /= 10;
        }
        Solution sol = new Solution();
        sol.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1, curr2 = l2, ans = new ListNode(), ansHead = ans;
        int sum = 0;
        while (curr1 != null || curr2 != null) {
            sum /= 10;
            if (curr1 != null) {
                sum += curr1.val;
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                sum += curr2.val;
                curr2 = curr2.next;
            }
            ansHead.next = new ListNode(sum % 10);
            ansHead = ansHead.next;
        }
        if (sum / 10 == 1)
            ansHead.next = new ListNode(1);
        return ans.next;
    }
}
// @lc code=end
