class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int ans = 0;

        int count = 2;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(i, j, grid, count));
                    count++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    ans = Math.max(ans, dfs(i, j, grid, count));
                    grid[i][j] = 0;
                    count++;
                }
            }
        }

        return ans;
    }

    int dfs(int i, int j, int[][] grid, int val) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == val || grid[i][j] == 0) {
            return 0;
        }
        int count = 1;
        grid[i][j] = val;
        count += dfs(i + 1, j, grid, val);
        count += dfs(i - 1, j, grid, val);
        count += dfs(i, j + 1, grid, val);
        count += dfs(i, j - 1, grid, val);
        return count;
    }

}