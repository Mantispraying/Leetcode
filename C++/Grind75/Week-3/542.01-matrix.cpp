#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=542 lang=cpp
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution
{
public:
    vector<vector<int>> updateMatrix(vector<vector<int>> &mat)
    {
        int n = mat.size(), m = mat[0].size();
        vector<vector<int>> vis(n, vector<int>(m, 0));
        vector<vector<int>> dis(n, vector<int>(m, 0));
        queue<pair<pair<int, int>, int>> ele;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (mat[i][j] == 0)
                {
                    ele.push({{i, j}, 0});
                    vis[i][j] = 1;
                }
                else
                {
                    vis[i][j] = 0;
                }
            }
        }
        int surrow[] = {-1, 0, +1, 0};
        int surcol[] = {0, +1, 0, -1};
        while (!ele.empty())
        {
            int row = ele.front().first.first;
            int col = ele.front().first.second;
            int step = ele.front().second;

            ele.pop();
            dis[row][col] = step;

            for (int i = 0; i < 4; i++)
            {
                int nrow = row + surrow[i];
                int ncol = col + surcol[i];

                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0)
                {
                    vis[nrow][ncol] = 1;
                    ele.push({{nrow, ncol}, step + 1});
                }
            }
        }

        return dis;
    }
};
// @lc code=end
