class Solution {
    int total = 0;
    int tar = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            total += nums[i];
        }

        tar = target;
        return solve(n - 1, nums, 0);
    }

    int solve(int i, int[] nums, int sum) {
        if (i < 0) {
            int neg = total - sum;
            if (sum - neg == tar) return 1;
            else return 0;
        }

        return solve(i - 1, nums, sum + nums[i]) + solve(i - 1, nums, sum);
    }
}