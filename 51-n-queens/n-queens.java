class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[][] grid = new int[n][n];
        solve(0, n, grid);
        return ans;
    }

    void solve(int i, int k, int[][] grid) {
        int n = grid.length;

        if (k == 0 && i == n) {
            // no queue is left to be placed.
            List<String> list = new ArrayList<>();
            for(int x = 0; x < grid.length; x++) {
                StringBuilder str = new StringBuilder();

                for(int y = 0; y < grid.length; y++) {
                    if (grid[x][y] == 1) {
                        str.append('Q');
                    } else {
                        str.append('.');
                    }
                }
                list.add(str.toString());
            }

            ans.add(list);
        }

        if (k != 0 && i == n) return;

        // We will try to place the queen in the whole row, if we failed we return.
        for(int j = 0; j < n; j++) {
            boolean canBePlace = validate(i, j, grid);
            if ( canBePlace == true) {
                // we will place the queen here.
                grid[i][j] = 1;
                solve(i + 1, k - 1, grid);
                grid[i][j] = 0;
            }
        }
    }

    boolean validate(int i, int j, int[][] grid) {
        for(int k = 0; k < i; k++) {
            if (grid[k][j] == 1) {
                return false;
            }
        }

        int x = i - 1;
        int y = j - 1;

        while( x >= 0 && y >= 0) {
            if (grid[x][y] == 1) return false;
            x--;
            y--;
        }
        
        x = i - 1;
        y = j + 1;

        while( x >= 0 && y < grid.length) {
            if (grid[x][y] == 1) return false;
            x--;
            y++;
        }

        return true;
    }
}