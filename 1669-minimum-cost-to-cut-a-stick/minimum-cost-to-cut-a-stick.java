class Solution {
    public int minCost(int n, int[] cuts) {
        int[][] dp = new int[103][103];
        for(int i = 0; i < 101; i++) {
            Arrays.fill(dp[i], -1);
        }
        Arrays.sort(cuts);
        int[] arr = new int[cuts.length + 2];
        arr[0] = 0;
        arr[cuts.length + 1] = n;
        for(int i = 0; i < cuts.length; i++) {
            arr[i + 1] = cuts[i];
        }
        return solve(0, arr.length - 1, arr, dp);
    }

    int solve(int i, int j, int[] cuts, int[][] dp) {
        int ans = Integer.MAX_VALUE;
        boolean f = false;

        if (dp[i][j] != -1) return dp[i][j];

        for(int k = i + 1; k < j; k++) {
            f = true;
            int temp_ans = (cuts[j] - cuts[i]) + solve(i, k, cuts, dp) + solve(k, j, cuts, dp);
            ans = Math.min(ans, temp_ans);
        }

        dp[i][j] = f ? ans : 0;
        return dp[i][j];
    }
}