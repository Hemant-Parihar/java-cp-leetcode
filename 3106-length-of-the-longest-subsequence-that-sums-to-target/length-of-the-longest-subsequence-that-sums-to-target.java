class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        
        int[][] dp = new int[n][target + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        int val =  solve(0, nums, target, dp);
        return val < 0 ? -1 : val;
    }
    
    int solve(int i, List<Integer> nums, int target, int[][] dp) {
        if (target == 0) return 0;
        if (target < 0 || i == nums.size()) return Integer.MIN_VALUE;

        if (dp[i][target] != -1) return dp[i][target];
        
        int p = Integer.MIN_VALUE;
        if (nums.get(i) <= target) {
            p = 1 + solve(i + 1, nums, target - nums.get(i), dp);
        }
        int up = solve(i + 1, nums, target, dp);
        
        return dp[i][target] = Math.max(p, up);
    }
}