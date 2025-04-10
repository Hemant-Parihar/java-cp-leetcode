class Solution {
    int ans = 0;
    public int subsetXORSum(int[] nums) {
        solve(0, 0, nums);
        return ans;
    }

    void solve(int i, int sum, int[] nums) {
        if (i == nums.length) {
            ans += sum;
            return;
        }

        solve(i + 1, sum ^ nums[i], nums);
        solve(i + 1, sum, nums);
    }

}