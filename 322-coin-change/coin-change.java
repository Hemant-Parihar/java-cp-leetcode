class Solution {
    int INT_MAX = 100001;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if (amount == 0) return 0;
        int[][] dp = new int[n][amount + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = solve(n - 1, coins, amount, dp);
        if (ans >= INT_MAX) return -1;
        return ans;
    }

    int solve(int index, int[] coins, int amount, int[][] dp) {
        if (index < 0 || amount < 0) return INT_MAX;
        if (amount == 0) return 0;
        if (dp[index][amount] != -1) return dp[index][amount];
        int p = INT_MAX;
        if (amount - coins[index] >= 0) {
            p = 1 +  solve(index, coins, amount - coins[index], dp);
        }
        int up = solve(index - 1, coins, amount, dp);
        dp[index][amount] = Math.min(p, up);
        return dp[index][amount];
    }
}