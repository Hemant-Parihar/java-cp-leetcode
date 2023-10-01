class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        long sum = 0;
        int ans = Integer.MAX_VALUE;
        
        long temp_sum = 0;
        for(int k = 0; k < n; k++) {
            temp_sum += nums[k];
        }
        
        int i = 0;
        int j = 0;
        while(sum + temp_sum < target) {
            sum += temp_sum;
            j += n;
        }
        int temp = j;
        
        while(j < temp + 2* n) {
            if (sum >= target) {
                if (sum == target) {
                    ans = Math.min(ans, j - i);
                }
                sum -= nums[i % n];
                i++;
            } else {
                sum += nums[j % n];
                j++;
            }
            // System.out.println(j + " " + i + " " + sum);
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}