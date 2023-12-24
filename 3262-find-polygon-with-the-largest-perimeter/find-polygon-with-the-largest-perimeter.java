class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefixSum = new long[n+1];
        for(int i = 1; i <= n; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }
        long ans = -1;
        for(int i = 2; i < n; i++) {
            if (prefixSum[i] > nums[i]) {
                ans = Math.max(ans, prefixSum[i + 1]);
            }
        }
        return ans;
    }
}