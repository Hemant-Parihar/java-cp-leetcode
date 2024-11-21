class Solution {

    int MOD = 1000000007;
    int MIN_PROFIT;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        MIN_PROFIT = minProfit;
        int[][][] dp = new int[group.length][n + 1][minProfit + 1];
        for(int i = 0; i < group.length; i++) {
            for(int j = 0; j <= n; j++) {
                for(int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(0, n, minProfit, group, profit, dp);
    }

    int solve(int i, int n, int p, int[] group, int[] profit, int[][][] dp) {
        if (i == group.length) {
            if (p <= 0) return 1;
            return 0;
        }

        if (dp[i][n][p] != -1) return dp[i][n][p];

        int pro = 0, up = 0;

        if (group[i] <= n) {
            pro = solve(i + 1, n - group[i], Math.max(p - profit[i], 0), group, profit, dp);
        }
        up = solve(i + 1, n, p, group, profit, dp);

        return dp[i][n][p] = (pro + up) % MOD;
    }
}