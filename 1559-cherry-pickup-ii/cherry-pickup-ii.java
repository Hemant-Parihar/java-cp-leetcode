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

    int solve(int row, int r1, int r2, int[][] grid, int[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;
        if (row == n) return 0;
        if (r1 < 0 || r2 < 0 || r1 == m || r2 == m) return 0;

        if (dp[row][r1][r2] != -1) return dp[row][r1][r2];
        
        int ans = 0;
        if (r1 == r2) {
            ans += grid[row][r1];
        } else {
            ans = grid[row][r1] + grid[row][r2];
        }


        int temp_ans = 0;
        temp_ans = solve(row + 1, r1 - 1, r2 - 1, grid, dp);
        temp_ans = Math.max(temp_ans, solve(row + 1, r1, r2 - 1, grid, dp));
        temp_ans = Math.max(temp_ans, solve(row + 1, r1 + 1, r2 - 1, grid, dp));
        temp_ans = Math.max(temp_ans, solve(row + 1, r1 - 1, r2, grid, dp));
        temp_ans = Math.max(temp_ans, solve(row + 1, r1 - 1, r2, grid, dp));
        temp_ans = Math.max(temp_ans, solve(row + 1, r1, r2, grid, dp));
        temp_ans = Math.max(temp_ans, solve(row + 1, r1 + 1, r2, grid, dp));
        temp_ans = Math.max(temp_ans, solve(row + 1, r1 - 1, r2 + 1, grid, dp));
        temp_ans = Math.max(temp_ans, solve(row + 1, r1, r2 + 1, grid, dp));
        temp_ans = Math.max(temp_ans, solve(row + 1, r1 + 1, r2 + 1, grid, dp));


        return dp[row][r1][r2] = ans + temp_ans;
    }
}