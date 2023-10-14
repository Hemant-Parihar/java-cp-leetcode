class Solution {

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, cost, time, dp);
    }

    int solve(int i, int done, int[] cost, int[] time, int[][] dp) {
        int n = cost.length;
        if (done >= n) return 0;

        if (i == n) {
            if (done >= n) return 0;
            else {
                return Integer.MAX_VALUE;
            }
        }

        if (dp[i][done] != -1) {
            return dp[i][done];
        }


        long p = cost[i] + (long)solve(i + 1, 1 + done + time[i], cost, time, dp);
        long up = solve(i + 1, done, cost, time, dp);

        return dp[i][done] = (int)Math.min(p, up);
    }
}