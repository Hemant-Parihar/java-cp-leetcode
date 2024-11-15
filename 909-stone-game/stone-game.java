class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int tsum = 0;
        for(int i = 0; i < n; i++) {
            tsum += piles[i];
        }
        int[][][] dp = new int[n][n][2];
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                for(int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int val = solve(0, n - 1, 0, piles, dp);
        if (val > tsum / 2) return true;
        return false;
    }

    int solve(int i, int j, int turn, int[] piles, int[][][] dp) {
        if (i > j) return 0;
        if (i == j) return piles[i];

        if (dp[i][j][turn] != -1) return dp[i][j][turn];


        int ans = 0;
        if (turn == 0) {
            ans = Math.max(
                    piles[i] + solve(i + 1, j, 1, piles, dp), 
                    piles[j] + solve(i, j - 1, 1, piles, dp)
                );
        } else {
            ans = Math.max(
                piles[i] + solve(i + 1, j, 0, piles, dp), 
                piles[j] + solve(i, j - 1, 0, piles, dp)
            );
        }

        dp[i][j][turn] = ans;
        return ans;
    }
}