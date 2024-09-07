class Solution {

    int MAX_NUM = 10001;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = solve(n - 1, coins, amount, dp);
        if (ans >= MAX_NUM) return -1;
        return ans;
    }

    int solve(int i, int[] coins, int amount, int[][] dp) {
        if (i < 0) return MAX_NUM;
        if (amount == 0) return 0;

        if (dp[i][amount] != -1) return dp[i][amount];

        int p, up = Integer.MAX_VALUE;
        if (amount - coins[i] >= 0) {
            up = 1 + solve(i, coins, amount - coins[i], dp);
        }
        p = solve(i - 1, coins, amount, dp);
        dp[i][amount] = Math.min(p, up);
        return dp[i][amount];
    }
}