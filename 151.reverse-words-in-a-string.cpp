#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=151 lang=cpp
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution
{
public:
    string reverseWords(string s)
    {
        stack<string> words;
        string ans = "";

        for (int i = 0; i < s.size(); i++)
        {
            if (s[i] == ' ')
            {
                continue;
            }
            string word = "";
            while (s[i] != ' ' && i < s.size())
            {
                word.push_back(s[i++]);
            }
            words.push(word);
        }
        while (!words.empty())
        {
            ans += words.top() + " ";
            words.pop();
        }
        ans.pop_back();
        return ans;

        // reverse(s.begin(), s.end());
        // int l = 0, r = 0, i = 0, n = s.size();
        // while (i < n)
        // {
        //     while (i < n && s[i] != ' ')
        //         s[r++] = s[i++];

        //     if (l < r)
        //     {                                          // if we can find a non-empty word then
        //         reverse(s.begin() + l, s.begin() + r); // reverse current word
        //         if (r == n)
        //             break;
        //         s[r++] = ' '; // set empty space
        //         l = r;
        //     }
        //     ++i; // now i == n or s[i] == ' ', so we skip that character!
        // }
        // if (r > 0 && s[r - 1] == ' ')
        //     --r; // skip last empty character if have
        // s.resize(r);
        // return s;
    }
};
// @lc code=end
