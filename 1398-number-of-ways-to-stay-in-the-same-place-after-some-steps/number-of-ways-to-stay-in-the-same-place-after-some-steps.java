class Solution {

    int MAX_STEP;
    int MOD = 1000000007;
    public int numWays(int steps, int arrLen) {
        MAX_STEP = steps;
        int[][] dp = new int[steps + 1][steps + 1];
        for(int i = 0; i <= steps; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, steps, arrLen, dp);
    }

    int solve(int i, int steps, int arrLen, int[][] dp) {
        if (steps == 0 || i == MAX_STEP) {
            if (i == 0) return 1;
            return 0;
        }

        if (dp[i][steps] != -1) return dp[i][steps];

        int ans = 0;
        if (i > 0) {
            ans += solve(i - 1, steps - 1, arrLen, dp);
            ans %= MOD;
        } 
        
        if (i + 1 < arrLen) {
            ans += solve(i + 1, steps - 1, arrLen, dp);
            ans %= MOD;
        }

        ans += solve(i, steps - 1, arrLen, dp);
        ans %= MOD;

        return  dp[i][steps] = ans;
    }
}