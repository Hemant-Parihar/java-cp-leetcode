class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 1; i < n; i++) {
            int temp_ans = 1;
            for(int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    temp_ans = Math.max(temp_ans, 1 + dp[j]);
                }
            }
            dp[i] = temp_ans;
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}