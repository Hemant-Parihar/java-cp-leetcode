class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int val = nums[0];
        int ans = 0;
        for(int i = 1; i < n; i++) {
            ans += (nums[i] - val);
        }
        return ans;
    }
}