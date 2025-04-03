class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return solve(0, questions, dp);
    }

    long solve(int i, int[][] q, long[] dp) {
        if (i >= q.length) return 0;

        if (dp[i] != -1) return dp[i];

        return dp[i] = Math.max(q[i][0] + solve(i + q[i][1] + 1, q, dp), solve(i + 1, q, dp));
    }
}