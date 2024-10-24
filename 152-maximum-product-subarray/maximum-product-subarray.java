class Solution {
    public int maxProduct(int[] nums) {
        int g_prod = nums[0];
        int prod = 1;
        boolean flag = true;

        if (nums.length == 1) {
            return nums[0];
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                prod *= nums[i];
                flag = false;
            } else {
                prod = 1;
                flag = true;
            }
            if (flag == false) {
                g_prod = Math.max(g_prod, prod);
            } else {
                g_prod = Math.max(g_prod, 0);
            }
        }

        prod = 1;
        flag = true;
        for(int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                prod *= nums[i];
                flag = false;
            } else {
                prod = 1;
                flag = true;
            }
            if (flag == false) {
                g_prod = Math.max(g_prod, prod);
            } else {
                g_prod = Math.max(g_prod, 0);
            }
        }

        return g_prod;
    }
}