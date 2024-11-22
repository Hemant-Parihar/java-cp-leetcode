class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int tsum = 0;
        for(int i = 0; i < n; i++) {
            tsum += nums[i];
        }
        
        int val = solve(0, n - 1, nums);

        if (tsum % 2 == 1) {
            if (val > tsum / 2) return true;
        } else {
            if (val >= tsum / 2) return true;
        }
        return false;
    }

    int solve(int i, int j, int[] piles) {
        if (i > j) return 0;
        if (i == j) {
            return piles[i];
        }


        int ans = 0;
        ans = Math.max(
                    piles[i] + Math.min( solve(i + 1, j - 1, piles), solve(i + 2, j, piles) ), 
                    piles[j] + Math.min( solve(i + 1, j - 1, piles), solve(i, j - 2, piles) )
                );

        return ans;
    }
}