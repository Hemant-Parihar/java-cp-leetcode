class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return count(0, nums, target, 0);
    }

    int count(int i, int[] nums, int target, int sum) {
        if (i == nums.length) {
            if (sum == target) return 1;
            return 0;
        }

        int ans = 0;
        ans += count(i + 1, nums, target, sum + nums[i]);
        ans += count(i + 1, nums, target, sum - nums[i]);
        return ans;
    }
}