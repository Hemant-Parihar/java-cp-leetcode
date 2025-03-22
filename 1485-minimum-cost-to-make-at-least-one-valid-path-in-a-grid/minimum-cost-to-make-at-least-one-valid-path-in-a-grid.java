class Solution {
    
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        solve(0, 0, 0, grid, ans);
        return ans[m - 1][n - 1];
    }

    void solve(int i, int j, int cost, int[][] grid, int[][] ans) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || ans[i][j] <= cost) {
            return;
        }
        if (cost > 200) return;
        
        ans[i][j] = cost;
        if (grid[i][j] == 1) {
            solve(i + 1, j, cost + 1, grid, ans);
            solve(i - 1, j, cost + 1, grid, ans);
            solve(i, j + 1, cost, grid, ans);
            solve(i, j - 1, cost + 1, grid, ans);
        } else if (grid[i][j] == 2) {
            solve(i + 1, j, cost + 1, grid, ans);
            solve(i - 1, j, cost + 1, grid, ans);
            solve(i, j + 1, cost + 1, grid, ans);
            solve(i, j - 1, cost, grid, ans);
        } else if (grid[i][j] == 3) {
            solve(i + 1, j, cost, grid, ans);
            solve(i - 1, j, cost + 1, grid, ans);
            solve(i, j + 1, cost + 1, grid, ans);
            solve(i, j - 1, cost + 1, grid, ans);
        } else {
            solve(i + 1, j, cost + 1, grid, ans);
            solve(i - 1, j, cost, grid, ans);
            solve(i, j + 1, cost + 1, grid, ans);
            solve(i, j - 1, cost + 1, grid, ans);
        }
        
    }
}