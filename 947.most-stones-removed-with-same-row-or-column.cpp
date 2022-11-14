#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=947 lang=cpp
 *
 * [947] Most Stones Removed with Same Row or Column
 */

// @lc code=start
class Solution
{
public:
    vector<int> parent;
    int find(int x)
    {
        return parent[x] == x ? x : parent[x] = find(parent[x]);
    }

    int removeStones(vector<vector<int>> &stones)
    {
        int n = stones.size();
        parent.resize(n + 1, 0);
        for (int i = 0; i <= n; i++)
        {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                {
                    int a = find(i);
                    int b = find(j);
                    if (a != b)
                    {
                        parent[b] = a;
                    }
                }
            }
        }
        int connected = 0;
        for (int i = 0; i < n; i++)
        {
            if (parent[i] == i)
            {
                connected++;
            }
        }
        return n - connected;
    }
};
// @lc code=end
int main()
{
    Solution sol;
    vector<vector<int>> stones = {{0, 1}, {1, 0}, {1, 1}};
    sol.removeStones(stones);
    return 0;
}