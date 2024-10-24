class Solution {
    public int maxSubArray(int[] nums) {
        int g_sum = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if (sum + nums[i] >= nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            g_sum = Math.max(g_sum, sum);
        }
        return g_sum;
    }
}