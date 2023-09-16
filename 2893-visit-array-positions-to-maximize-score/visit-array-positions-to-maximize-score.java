class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[] dp = new long[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        long ans = dp[0];
        int evenIndex, oddIndex;
        evenIndex = oddIndex = -1;
        if (nums[0] % 2 == 0) {
            evenIndex = 0;
        } else {
            oddIndex = 0;
        }
        for(int i = 1; i < n; i++) {
            if (nums[i-1] % 2 == nums[i] % 2) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                if (nums[i] % 2 == 0) {
                    if (evenIndex >= 0) {
                        dp[i] = Math.max(dp[i], dp[evenIndex] + nums[i]);
                    }
                } else {
                    if (oddIndex >= 0) {
                        dp[i] = Math.max(dp[i], dp[oddIndex] + nums[i]);
                    }
                }
                dp[i] = Math.max(dp[i], dp[i-1] + nums[i] - x);
            }

            if (nums[i] % 2 == 0) {
                evenIndex = i;
            } else {
                oddIndex = i;
            }
            ans = Math.max(dp[i], ans);
        }
        // System.out.println(Arrays.toString(dp));
        return ans;
    }
}