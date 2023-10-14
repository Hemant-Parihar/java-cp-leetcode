class Solution {

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        long[][] dp = new long[n][n];
        for(long[] row: dp) {
            Arrays.fill(row, -1);
        }
        return (int)solve(0, 0, cost, time, dp);
    }

    long solve(int i, int done, int[] cost, int[] time, long[][] dp) {
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


        long p = cost[i] + solve(i + 1, 1 + done + time[i], cost, time, dp);
        long up = solve(i + 1, done, cost, time, dp);

        return dp[i][done] = Math.min(p, up);
    }
}