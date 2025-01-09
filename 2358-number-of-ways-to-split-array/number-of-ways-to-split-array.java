class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long lsum = 0;
        long rsum = 0;
        for(int i = n - 1; i >= 0; i--) {
            rsum += nums[i];
        }

        int ans = 0;
        for(int i = 0; i < n - 1; i++) {
            lsum += nums[i];
            rsum -= nums[i];
            if (lsum >= rsum) ans++;
        }

        return ans;
    }
}