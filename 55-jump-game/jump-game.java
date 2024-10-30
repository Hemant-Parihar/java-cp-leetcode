class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int end_to_reach = n -1;
        for(int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= end_to_reach) {
                end_to_reach = i;
            }
        }
        if (end_to_reach == 0) return true;
        return false;
    }
}