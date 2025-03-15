class Solution {
    int INT_MAX = 1000000000;
    
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, cost, time, dp);
    }

    int solve(int i, int w, int[] cost, int[] time, int[][] dp) {
        int n = cost.length;
        if (w >= n) return 0;
        if (i == n) return INT_MAX;

        if (dp[i][w] != -1) return dp[i][w];

        return dp[i][w] =  Math.min(
            cost[i] + solve(i + 1, w + time[i] + 1, cost, time, dp),
            solve(i + 1, w, cost, time, dp)
        );
    }
}