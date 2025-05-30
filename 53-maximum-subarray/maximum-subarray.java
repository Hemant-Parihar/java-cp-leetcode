class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int tsum = nums[0];

        for(int i = 1; i < n; i++) {
            tsum = Math.max(tsum + nums[i], nums[i]);
            sum = Math.max(sum, tsum);
        }

        return sum;
    }
}