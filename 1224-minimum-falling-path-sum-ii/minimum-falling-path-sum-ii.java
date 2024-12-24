class Solution {
    
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return solve(grid, 0, -1, dp);
    }

    int solve(int[][] grid, int row, int col, int[][] dp) {
        int n = grid.length;
        if (row == n) return 0;

        if (col != -1 && dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }

        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            if (j == col) continue;
            int val = grid[row][j] + solve(grid, row + 1, j, dp);
            if (val < ans) {
                ans = val;
            }
        }

        if (col != -1) {
            dp[row][col] = ans;
        }
        
        return ans;
    }
}