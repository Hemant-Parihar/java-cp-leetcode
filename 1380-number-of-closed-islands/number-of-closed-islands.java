class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                dfs(i, 0, grid);
            }
            if (grid[i][n - 1] == 0) {
                dfs(i, n - 1, grid);
            }
        }

        for(int j = 0; j < n; j++) {
            if (grid[0][j] == 0) {
                dfs(0, j, grid);
            }
            if (grid[m - 1][j] == 0) {
                dfs(m - 1, j, grid);
            }
        }

        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans++;
                    dfs(i, j, grid);
                }
            }
        }

        return ans;
    }

    void dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1;
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }
}