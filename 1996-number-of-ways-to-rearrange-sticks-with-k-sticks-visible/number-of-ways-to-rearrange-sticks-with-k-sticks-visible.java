class Solution {
    int mod = 1000000007;
    public int rearrangeSticks(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }
        return (int)solve(n, k, dp);
    }

    long solve(int n, int k, long[][] dp) {
        if (n == 0 && k == 0) return 1;
        if (n > 0 && k == 0 || n == 0 && k > 0) return 0;
        
        if (dp[n][k] != -1) return dp[n][k];

        long ans = 0;
        ans = (ans + solve(n -1, k - 1, dp)) % mod;
        ans = (ans + (n -1) * solve(n - 1, k, dp)) % mod;

        return dp[n][k] = ans;
    }
}