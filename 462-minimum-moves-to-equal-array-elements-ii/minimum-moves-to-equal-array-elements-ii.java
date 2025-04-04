class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid;
        if (n % 2 == 0) {
            mid = nums[n / 2 - 1] + nums[n / 2];
            mid /= 2;
        } else {
            mid = nums[n / 2];
        }
        // System.out.println(mid);

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += Math.abs(nums[i] - mid);
        }
        return ans;
    }
}