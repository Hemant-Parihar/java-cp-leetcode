class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(grid[i], -1);
        }
        for(int i = 0; i < guards.length; i++) {
            int u = guards[i][0];
            int v = guards[i][1];
            grid[u][v] = 0; 
        }

        for(int i = 0; i < walls.length; i++) {
            int u = walls[i][0];
            int v = walls[i][1];
            grid[u][v] = 5; 
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    mark(grid, i, j);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == -1) ans++;
            }
        }

        return ans;
    }

    void mark(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        int k = j + 1;
        while(k < n && grid[i][k] < 0) {
            grid[i][k] = -2;
            k++;
        }

        k = j - 1;
        while(k >= 0 && grid[i][k] < 0) {
            grid[i][k] = -2;
            k--;
        }

        k = i + 1;
        while(k < m && grid[k][j] < 0) {
            grid[k][j] = -2;
            k++;
        }

        k = i - 1;
        while(k >= 0 && grid[k][j] < 0) {
            grid[k][j] = -2;
            k--;
        }
    }
}