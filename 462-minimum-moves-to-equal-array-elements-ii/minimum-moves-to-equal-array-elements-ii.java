class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        Arrays.sort(nums);
        int mid;
        mid = nums[n / 2];
        

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += Math.abs(nums[i] - mid);
        }
        return ans;
    }
}