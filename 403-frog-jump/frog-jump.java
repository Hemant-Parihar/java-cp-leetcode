class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n+1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, stones, dp);
    }

    boolean solve(int index, int lastJump, int[] stones, int[][] dp) {
        int n = stones.length;
        if (index == n - 1) {
            // we have reached the end.
            return true;
        }

        if (dp[index][lastJump] != -1) {
            if (dp[index][lastJump] == 1) return true;
            return false;
        }
        
        for(int j = index + 1; j < n; j++) {

            if (stones[j] > (stones[index] + lastJump + 1)) {
                break;
            }

            if ( stones[j] == (stones[index] + lastJump - 1) ) {
                if (solve(j, lastJump - 1, stones, dp)) {
                    dp[index][lastJump] = 1;
                    return true;
                }
            } else if ( stones[j] == (stones[index] + lastJump) ) {
                if (solve(j, lastJump, stones, dp)) {
                    dp[index][lastJump] = 1;
                    return true;
                };
            } else if ( stones[j] == (stones[index] + lastJump + 1) ) {
                if (solve(j, lastJump + 1, stones, dp)) {
                    dp[index][lastJump] = 1;
                    return true;
                }
            }
        }

        dp[index][lastJump] = 0;
        return false;
    }
}