class Solution {
    public String stoneGameIII(int[] nums) {
        int n = nums.length;
        int tsum = 0;
        for(int i = 0; i < n; i++) {
            tsum += nums[i];
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int val = solve(0, nums, dp);

        if (val > (tsum - val)) return "Alice";
        else if (val < (tsum - val)) return "Bob";
        else return "Tie";
    }

    int solve(int i, int[] nums, int[] dp) {
        if (i >= nums.length) return 0;
        if (i == nums.length - 1) return nums[i];

        if (dp[i] != -1) return dp[i];

        int ans = 0;

        ans = Math.max(
            nums[i] + Math.min(
                solve(i + 2, nums, dp),
                Math.min(
                    solve(i + 3, nums, dp),
                    solve(i + 4, nums, dp)
                )
            ), 

            nums[i] + nums[i + 1] + Math.min(

                solve(i + 3, nums, dp),
                Math.min(
                    solve(i + 4, nums, dp),
                    solve(i + 5, nums, dp)
                )
            )
        );

        if (i + 2 < nums.length) {
            ans = Math.max( 
                ans,
                nums[i] + nums[i + 1] + nums[i + 2] + Math.min(
                    solve(i + 4, nums, dp),
                    Math.min(
                        solve(i + 5, nums, dp),
                        solve(i + 6, nums, dp)
                    )
                )
            );
        }

        return dp[i] = ans;
    }
}