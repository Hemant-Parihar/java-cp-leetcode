class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        long sum = nums[0];
        int ans = nums[0];
        for(int i = 1; i < n; i++) {
            sum += nums[i];
            ans = Math.max(ans, (int) Math.ceil( (double) sum / (i + 1)));
        }
        return ans;
    }
}