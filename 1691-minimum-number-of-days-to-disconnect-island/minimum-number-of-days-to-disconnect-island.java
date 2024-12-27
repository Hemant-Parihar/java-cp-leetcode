class Solution {
    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (validate(grid)) return 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (validate(grid)) return 1;
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    boolean validate(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 1;
                }
            }
        }

        if (count > 1 || count == 0) return true;
        return false;
    }

    void dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == 2) {
            return;
        }

        grid[i][j] = 2;
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }
}