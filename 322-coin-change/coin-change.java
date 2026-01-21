class Solution {

    int INT_MAX = 100000;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int dp[][] = new int[n + 1][amount + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }

        int val = solve(n - 1, coins, amount, dp);
        if (val >= INT_MAX) return -1;
        return val;
    }

    int solve(int i, int[] coins, int amount, int[][] dp) {
        if (i < 0) return INT_MAX;

        if (amount == 0) return 0;

        if (dp[i][amount] != -1) return dp[i][amount];

        int p = INT_MAX;
        if (amount >= coins[i]) {
            p = 1 + solve(i, coins, amount - coins[i], dp);
        }
        int up = solve(i - 1, coins, amount, dp);

        return dp[i][amount] = Math.min(p, up);
    }
}