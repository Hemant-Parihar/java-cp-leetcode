class Solution {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;

        while(i < n && j < n) {
            if (nums[i] != 0) {
                i++;
            } else {
                j = Math.max(j + 1, i + 1);
                if (j < n && nums[j] != 0) {
                    swap(nums, i, j);
                }
            }
        }
    }
}