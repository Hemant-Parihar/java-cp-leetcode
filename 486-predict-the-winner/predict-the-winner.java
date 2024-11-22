class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int tsum = 0;
        for(int i = 0; i < n; i++) {
            tsum += nums[i];
        }
        int[][][] dp = new int[n][n][2];
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                for(int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int val = solve(0, n - 1, nums, dp);
        System.out.println(val);
        if (tsum % 2 == 1) {
            if (val > tsum / 2) return true;
        } else {
            if (val >= tsum / 2) return true;
        }
        return false;
    }

    int solve(int i, int j, int[] piles, int[][][] dp) {
        if (i > j) return 0;
        if (i == j) {
            return piles[i];
        }

        // if (dp[i][j][turn] != -1) return dp[i][j][turn];


        int ans = 0;
        ans = Math.max(
                    piles[i] + Math.min( solve(i + 1, j - 1, piles, dp), solve(i + 2, j, piles, dp) ), 
                    piles[j] + Math.min( solve(i + 1, j - 1, piles, dp), solve(i, j - 2, piles, dp) )
                );

        // dp[i][j][turn] = ans;
        return ans;
    }
}