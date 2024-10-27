class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(0, nums, dp);
    }

    boolean solve(int i, int[] nums, int[] dp) {
        if (i >= nums.length - 1) return true;
        if (dp[i] != -1) {
            if (dp[i] == 1) return true;
            return false;
        }
        boolean ans = false;
        for(int j = nums[i]; j > 0; j--) {
            ans = solve(i + j, nums, dp);
            if (ans == true) {
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 0;
        return false;
    }
}