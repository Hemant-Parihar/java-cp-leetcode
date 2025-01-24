class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans += solve(i, j, grid);
                } else if (grid[i][j] == -1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    int solve(int i, int j, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int k = i - 1;
        while(k >= 0) {
            if (grid[k][j] == 1 || grid[k][j] == -1) {
                grid[k][j] = -1;
                return 1;
            }
            k--;
        }

        k = i + 1;
        while(k < m) {
            if (grid[k][j] == 1 || grid[k][j] == -1) {
                grid[k][j] = -1;
                return 1;
            }
            k++;
        }

        k = j - 1;
        while(k >= 0) {
            if (grid[i][k] == 1 || grid[i][k] == -1) {
                grid[i][k] = -1;
                return 1;
            }
            k--;
        }

        k = j + 1;
        while(k < n) {
            if (grid[i][k] == 1 || grid[i][k] == -1) {
                grid[i][k] = -1;
                return 1;
            }
            k++;
        }
        
        return 0;
    }
}