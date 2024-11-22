class Solution {
    int INT_MAX = 1000000007;
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n+ 1][n + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(0, 0, cost, time, dp);
    }

    int solve(int i, int t, int[] cost, int[] time, int[][] dp) {
        int n = cost.length;
        if ( t >= cost.length) return 0;

        if (i == cost.length) {
            return INT_MAX;
        }

        if (dp[i][t] != -1) return dp[i][t]; 

        return dp[i][t] = Math.min( 
                cost[i] + solve(i + 1, Math.min(1 + t + time[i], n), cost, time, dp),
                solve(i + 1, t, cost, time, dp) 
            );
    }
}