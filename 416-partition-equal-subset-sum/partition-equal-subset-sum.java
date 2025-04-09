class Solution {
    int tsum = 0;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            tsum += nums[i];
        }
        int[][] dp = new int[n][tsum + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, tsum, nums, dp);
    }

    boolean solve(int i, int sum, int tsum, int[] nums, int[][] dp) {
        if (i >= nums.length || 2*sum > tsum) return false;
        if (2*sum == tsum) return true;

        if (dp[i][sum] != -1) {
            if (dp[i][sum] == 1) return true;
            else return false;
        }
        
        boolean val = solve(i + 1, sum + nums[i], tsum, nums, dp) || solve(i + 1, sum, tsum, nums, dp);

        if (val == true) {
            dp[i][sum] = 1;
        } else {
            dp[i][sum] = 0;
        }

        return val;
    }
}