class Solution {
    int MOD = 1000000007;
    public int rearrangeSticks(int n, int k) {
        long[][] dp = new long[n+1][k+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i && j <= k; j++) {
                dp[i][j] = -1;
            }
        }
        return (int)solve(n, k, dp);
    }

    long solve(int n, int k, long[][] dp) {
        if (n == k) return 1;
        if (n < k) return 0;
        if (n < 1) return 0;

        if (dp[n][k] != -1) {
            return dp[n][k];
        }

        long ans = 0;
        ans = (ans + solve(n - 1, k-1, dp));
        ans = (ans + ((n-1) * solve(n-1, k, dp)) % MOD) % MOD;

        dp[n][k] = ans;
        return ans;
    }
}