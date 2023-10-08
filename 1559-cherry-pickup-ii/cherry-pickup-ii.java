class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(0, 0, m - 1, grid, dp);
    }

    int solve(int i, int j, int l, int[][] grid, int[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;
        if (j < 0 || l < 0 || j >= m || l >= m) return Integer.MIN_VALUE;

        if (i == n - 1) {
            if (j != l) 
                return grid[i][j] + grid[i][l];
            return grid[i][j];
        }

        if (dp[i][j][l] != -1) {
            return dp[i][j][l];
        }

        int ans = 0;
        int val;
        if (j != l) {
            val = grid[i][j] + grid[i][l];
        } else {
            val = grid[i][j];
        }
        
        ans = Math.max(ans, val + solve(i + 1, j - 1, l - 1, grid, dp));
        ans = Math.max(ans, val + solve(i + 1, j, l - 1, grid, dp));
        ans = Math.max(ans, val + solve(i + 1, j + 1, l - 1, grid, dp));

        ans = Math.max(ans, val + solve(i + 1, j - 1, l, grid, dp));
        ans = Math.max(ans, val + solve(i + 1, j, l, grid, dp));
        ans = Math.max(ans, val + solve(i + 1, j + 1, l, grid, dp));

        ans = Math.max(ans, val + solve(i + 1, j - 1, l + 1, grid, dp));
        ans = Math.max(ans, val + solve(i + 1, j, l + 1, grid, dp));
        ans = Math.max(ans, val + solve(i + 1, j + 1, l + 1, grid, dp));

        return dp[i][j][l] = ans;
    }
}