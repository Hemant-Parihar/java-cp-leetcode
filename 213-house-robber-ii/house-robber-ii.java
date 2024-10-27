class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int l = nums[n-1] + solveL(n - 3, nums, dp);
        Arrays.fill(dp, -1);
        int f = nums[0] + solveF(n - 2, nums, dp);
        Arrays.fill(dp, -1);
        int not_lf = solve(n - 2, nums, dp);
        int ans = Math.max(l, f);
        return Math.max(ans, not_lf);
    }

    int solve(int i, int[] nums, int[] dp) {
        if (i <= 0) return 0;
        if (dp[i] != -1) return dp[i];
        int p = nums[i] + solveL(i - 2, nums, dp);
        int up = solveL(i - 1, nums, dp);
        dp[i] = Math.max(p, up);
        return Math.max(p, up);
    }

    int solveL(int i, int[] nums, int[] dp) {
        if (i <= 0) return 0;
        if (dp[i] != -1) return dp[i];
        int p = nums[i] + solveL(i - 2, nums, dp);
        int up = solveL(i - 1, nums, dp);
        dp[i] = Math.max(p, up);
        return Math.max(p, up);
    }

    int solveF(int i, int[] nums, int[] dp) {
        if (i <= 1) return 0;
        if (dp[i] != -1) return dp[i];
        int p = nums[i] + solveF(i - 2, nums, dp);
        int up = solveF(i - 1, nums, dp);
        dp[i] = Math.max(p, up);
        return Math.max(p, up);
    }
}