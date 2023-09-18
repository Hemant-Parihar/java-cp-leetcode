class Solution {
    public long maximumSum(List<Integer> nums) {
        int n = nums.size();
        long ans = 0;

        for(int i = 0; i < n; i++) {
            int j = i + 1;
            long temp_ans = nums.get(i);
            while(j < n) {
                int val = (i + 1) * (j + 1);
                int sq_val = (int) Math.sqrt(val);
                if (sq_val * sq_val == val) {
                    temp_ans += nums.get(j);
                }
                j++;
            }
            ans = Math.max(ans, temp_ans);
        }

        return ans;
    }
}