class Solution {
    int mod = 1000000007;
    public int rearrangeSticks(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], - 1);
        }
        return (int)solve(n, k, dp);
    }

    long solve(int n, int k, long[][] dp) {
        if (n == k) return 1;
        if (n < k) return 0;
        if (n < 1) return 0;
        if (k < 0) return 0;

        
        if (dp[n][k] != -1) return dp[n][k];

        long ans = 0;
        ans = (ans + solve(n -1, k - 1, dp)) % mod;
        ans = (ans + (n -1) * solve(n - 1, k, dp)) % mod;

        return dp[n][k] = ans;
    }
}