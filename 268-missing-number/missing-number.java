class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i] ^ i;
        }
        return ans ^ n;
    }
}