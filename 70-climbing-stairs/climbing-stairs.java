class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        dp[2] = 2;
        return solve(n, dp);
    }

    int solve(int i, int[] dp) {
        if (dp[i] != -1) return dp[i];
        int a = solve(i - 1, dp);
        int b = solve(i - 2, dp);
        dp[i] = a + b;
        return dp[i];
    }
}