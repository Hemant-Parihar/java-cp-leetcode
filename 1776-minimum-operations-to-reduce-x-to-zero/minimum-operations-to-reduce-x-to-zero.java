class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int target = sum - x;
        System.out.println(target);
        if (target < 0) return -1;
        System.out.println(target);
        int i = 0;
        int j = 0;
        sum = 0;
        int ans = -1;
        while(j < n) {
            if (sum == target) {
                ans = Math.max(ans, j - i);
                sum -= nums[i];
                i++;
            } else if (sum < target) {
                sum += nums[j];
                j++;
            } else {
                sum -= nums[i];
                i++;
            }
        }
        while(i < j) {
            if (sum == target) {
                ans = Math.max(ans, j - i);
            }
            sum -= nums[i];
            i++;
        }
        if (ans == -1) return -1;
        return n - ans;
    }
}