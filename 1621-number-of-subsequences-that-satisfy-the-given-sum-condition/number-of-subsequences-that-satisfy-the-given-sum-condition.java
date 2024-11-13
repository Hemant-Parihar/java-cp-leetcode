class Solution {
    int MOD = 1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if (2*nums[i] <= target) {
                ans++;
            }
        }

        int n = nums.length;

        int[] pow = new int[n + 1];
        pow[0] = 1;

        for(int i = 1; i <= n; i++) {
            pow[i] = (2*pow[i-1]) % MOD;
        }


        int i = 0;
        int j = nums.length - 1;

        while(i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else {
                
                int c = j - i + 1 - 2;

                int val = pow[c + 1] - 1;
                ans = (ans + val) % MOD;

                i++;
            }
        }

        return ans;
    }
}