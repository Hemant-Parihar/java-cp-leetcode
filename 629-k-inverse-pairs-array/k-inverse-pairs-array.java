class Solution {
    int MOD = 1000000007;
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        // for(int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                dp[i][j] = 0;
                for(int t = 1; t <= i; t++) {
                    if ( (j - i + t) >= 0) {
                        dp[i][j] += dp[i - 1][j - i + t];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }

        return dp[n][k];
        // return solve(n, k, dp);
    }

    int solve(int n, int k, int[][] dp) {
        if (k < 0) return 0;
        if (k == 0) return 1;

        if (dp[n][k] != -1) return dp[n][k];

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            ans += solve(n - 1, k - n + i, dp);
            ans %= MOD;
        }

        dp[n][k] = ans;
        return ans;
    }
}