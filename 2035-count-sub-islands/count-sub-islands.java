class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;

        boolean[][] v = new boolean[m][n];

        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && v[i][j] == false) {
                    if ( dfs(i, j, grid1, grid2, v) ) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    boolean dfs(int i, int j, int[][] grid1, int[][] grid2, boolean[][] v) {
        if (i < 0 || j < 0 || i >= grid1.length || j >= grid1[0].length || v[i][j] == true || grid2[i][j] == 0) return true;

        if (grid2[i][j] != grid1[i][j]) return false;

        v[i][j] = true;
        boolean u = dfs(i - 1, j, grid1, grid2, v);
        boolean p = dfs(i + 1, j, grid1, grid2, v);
        boolean w = dfs(i, j - 1, grid1, grid2, v);
        boolean x = dfs(i, j + 1, grid1, grid2, v);

        if (u && p && w && x) return true;
        return false;
    }
}