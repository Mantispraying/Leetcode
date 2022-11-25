#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=79 lang=cpp
 *
 * [79] Word Search
 */

// @lc code=start
class Solution
{
public:
    bool dfs(vector<vector<char>> &board, vector<vector<bool>> &vis, pair<int, int> co, int idx, string word)
    {
        if (idx == word.length() - 1)
            return true;

        vis[co.first][co.second] = true;
        int dir[] = {1, 0, -1, 0, 1};
        bool ans = false;
        for (int i = 0; i < 4; i++)
        {
            int nrow = co.first + dir[i];
            int ncol = co.second + dir[i + 1];
            if (nrow >= 0 && ncol >= 0 && nrow < board.size() && ncol < board[0].size() && !vis[nrow][ncol] && board[nrow][ncol] == word[idx + 1])
            {
                ans |= dfs(board, vis, {nrow, ncol}, idx + 1, word);
                vis[nrow][ncol] = false;
            }
        }
        return ans;
    }
    bool exist(vector<vector<char>> &board, string word)
    {
        int rows = board.size(), cols = board[0].size();
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (board[i][j] == word[0])
                {
                    vector<vector<bool>> vis(board.size(), vector<bool>(board[0].size(), false));
                    if (dfs(board, vis, {i, j}, 0, word))
                        return true;
                }
            }
        }
        return false;
    }
};
// @lc code=end
int main()
{
    Solution sol;
    vector<vector<char>> board = {{'A', 'B', 'C', 'E'},
                                  {'S', 'F', 'E', 'S'},
                                  {'A', 'D', 'E', 'E'}};

    sol.exist(board, "ABCESEEEFS");
    return 0;
}