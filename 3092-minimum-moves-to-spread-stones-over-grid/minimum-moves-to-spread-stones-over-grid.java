class Solution {
    public int minimumMoves(int[][] grid) {
        int n = 3;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++;
            }
        }
        if (count == 0) return 0;
        return solve(count, grid);
    }

    int solve(int count, int[][] grid) {
        int n = 3;
        if (count == 0) return 0;

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    for(int k = 0; k < n; k++) {
                        for(int l = 0; l < n; l++) {
                            if (grid[k][l] > 1) {
                                // we can use this 1.
                                grid[k][l] = grid[k][l] - 1;
                                grid[i][j] = 1;
                                int dis = Math.abs(k - i) + Math.abs(l - j);
                                ans = Math.min(ans, dis + solve(count - 1, grid));
                                grid[i][j] = 0;
                                grid[k][l] = grid[k][l] + 1;
                            }
                        }
                    }
                }
            }
        }

        return ans;
        
    }
}