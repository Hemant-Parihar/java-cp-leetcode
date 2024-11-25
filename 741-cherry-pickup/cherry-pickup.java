class Solution {
    boolean val = false;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][][] dp = new int[n][n][n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        int ans = Math.max(0, solve(0, 0, 0, 0, grid, dp));
        if (val == false) return 0;
        return ans;
    }

    int solve(int i1, int j1, int i2, int j2, int[][] grid, int[][][][] dp) {
        int n = grid.length;
        if (i1 >= n || j1 >= n || i2 >= n || j2 >= n || grid[i1][j1] == -1 || grid[i2][j2] == -1) return Integer.MIN_VALUE;

        if(i1 == n - 1 && j1 == n - 1 && i2 == n - 1 && j2 == n-1) {
            val = true;
            return grid[i1][j1];
        }

        if (dp[i1][j1][i2][j2] != -1) return dp[i1][j1][i2][j2];
            

        int ans = 0;
        if (i1 == i2 && j1 == j2) {
            ans += grid[i1][j1];
        } else {
            ans += grid[i1][j1] + grid[i2][j2];
        }
        
        int temp = Integer.MIN_VALUE;
        temp = Math.max(temp, solve(i1 + 1, j1, i2, j2 + 1, grid, dp));
        temp = Math.max(temp, solve(i1 + 1, j1, i2 + 1, j2, grid, dp));
        temp = Math.max(temp, solve(i1, j1 + 1, i2, j2 + 1, grid, dp));
        temp = Math.max(temp, solve(i1, j1 + 1, i2 + 1, j2, grid, dp)); 
        
        return dp[i1][j1][i2][j2] = (ans + temp);
    }
}