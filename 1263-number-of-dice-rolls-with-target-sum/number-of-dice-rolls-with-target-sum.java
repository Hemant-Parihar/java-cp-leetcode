class Solution {
    int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(n, k, target, 0, dp);
    }

    int solve(int n, int k, int target, int sum, int[][] dp) {
        if (sum == target && n == 0) return 1;
        if (sum > target || n <= 0) return 0;

        if (dp[n][sum] != -1) return dp[n][sum];

        int ans = 0;
        
        for(int i = 1; i <= k; i++) {
            ans += solve(n - 1, k, target, sum + i, dp);
            ans %= mod;
        }

        return dp[n][sum] = ans;
    }
}