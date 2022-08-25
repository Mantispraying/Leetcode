#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=141 lang=cpp
 *
 * [141] Linked List Cycle
 */
struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution
{
public:
    bool hasCycle(ListNode *head)
    {
        // unordered_set<ListNode *> listmp;
        // ListNode *temp = head;

        // while (temp)
        // {
        //     if (listmp.find(temp) != listmp.end())
        //     {
        //         return true;
        //     }
        //     listmp.insert(temp);
        //     temp = temp->next;
        // }
        // return false;

        ListNode *slow = head, *fast = head;
        while (fast != NULL && fast->next != NULL)
        {
            slow = slow->next;
            fast = fast->next->next;

            if (slow == fast)
            {
                return true;
            }
        }
        return false;
    }
};
// @lc code=end
