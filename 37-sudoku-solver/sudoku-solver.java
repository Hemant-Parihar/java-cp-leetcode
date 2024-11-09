class Solution {
    boolean found = false;
    public void solveSudoku(char[][] board) {
        char[][] grid = new char[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                grid[i][j] = board[i][j];
            }
        }
        solve(0, 0, grid, board);
    }

    void solve(int i, int j, char[][] grid, char[][] board) {
        if (i >= 9) {
            for(int x = 0; x < 9; x++) {
                for(int y = 0; y < 9; y++) {
                    board[x][y] = grid[x][y];
                }
            }
            found = true;
            return;
        }

        if (j >= 9) {
            solve(i + 1, 0, grid, board);
            return;
        }

        if (grid[i][j] != '.') {
            solve(i, j + 1, grid, board);
            return;
        }

        for(int k = 1; k <= 9 && found == false; k++) {
            if ( validate(i, j, grid, (char) (k + '0') ) ) {
                grid[i][j] = (char) ('0' + k);
                solve(i, j + 1, grid, board);
                grid[i][j] = '.';
            }
        }
    }

    boolean validate(int i, int j, char[][] grid, char val) {
        // check that row don't have it.
        for(int k = 0; k < grid.length; k++) {
            if (grid[i][k] == val) return false;
            if (grid[k][j] == val) return false;
        }

        int block_i = (i / 3);
        int block_j = (j / 3);

        for(int x = 3*block_i; x < 3*block_i + 3; x++) {
            for(int y = 3*block_j; y < 3*block_j + 3; y++) {
                if (grid[x][y] == val) return false;
            }
        }

        return true;
    }
}