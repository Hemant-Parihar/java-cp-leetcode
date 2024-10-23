class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int countZeros = 0;
        int prod = 1;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZeros++;
            }
            prod *= nums[i];
        }

        if (countZeros == 0) {
            for(int i = 0; i < nums.length; i++) {
                nums[i] = prod / nums[i];
            }
        } else if (countZeros == 1) {
            int index = -1;
            int s = 1;
            int e = 1;
            for(int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    index = i;
                } else if (index != -1) {
                    e *= nums[i];
                } else {
                    s *= nums[i];
                }
                nums[i] = 0;
            }
            nums[index] = s*e;
        } else {
            Arrays.fill(nums, 0);
        }
        return nums;
    }
}