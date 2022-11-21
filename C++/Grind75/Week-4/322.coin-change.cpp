#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=322 lang=cpp
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution
{
private:
    int calculateCoins(vector<int> &coins, int amount, int idx, vector<vector<int>> &dp)
    {
        if (idx == 0)
        {
            if (amount % coins[0] == 0)
            {
                return amount / coins[0];
            }
            return 1e9;
        }
        if (dp[idx][amount] != -1)
        {
            return dp[idx][amount];
        }
        int notTake = calculateCoins(coins, amount, idx - 1, dp);
        int take = 1e9;
        if (amount >= coins[idx])
        {
            take = calculateCoins(coins, amount - coins[idx], idx, dp) + 1;
        }

        int ans = min(take, notTake);
        dp[idx][amount] = ans;
        return ans;
    }

public:
    int coinChange(vector<int> &coins, int amount)
    {
        vector<vector<int>> dp(coins.size(), vector<int>(amount + 1, -1));
        int ans = calculateCoins(coins, amount, coins.size() - 1, dp);
        if (ans >= 1e9)
        {
            return -1;
        }
        return ans;
    }
};
// @lc code=end
int main()
{
    Solution sol;
    vector<int> coins = {3, 7, 405, 436};
    cout << sol.coinChange(coins, 8839) << "\n";
    return 0;
}