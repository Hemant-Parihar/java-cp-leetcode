class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[][] grid = new long[m + 1][n + 1];
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                grid[i][j] = Math.max(grid[i-1][j], grid[i][j - 1]) + skill[j - 1] * mana[i - 1];
            }
            // System.out.println(Arrays.toString(grid[i]));
            for(int j = n - 1; j >= 1;j--) {
                grid[i][j] = grid[i][j + 1] - skill[j] * mana[i - 1];
            }
            // System.out.println(Arrays.toString(grid[i]));
        }

        // for(int i = 0; i <= m; i++) {
        //     for(int j = 0; j <= n; j++) {
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return grid[m][n];
    }
}