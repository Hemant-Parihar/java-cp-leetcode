class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int ans = 0;

        int[][] sum = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                sum[i][j] = matrix[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }

        // for(int i = 0; i <= n; i++) {
        //     for(int j = 0; j <= m; j++) {
        //         System.out.print(sum[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // if (matrix[0][0] == target) ans++;
        // for(int j = 1; j < m; j++) {
        //     matrix[0][j] = matrix[0][j] + matrix[0][j-1];
        //     if (matrix[0][j] == target) ans++;
        // }

        // for(int i = 1; i < n; i++) {
        //     matrix[i][0] = matrix[i][0] + matrix[i-1][0];
        //     if (matrix[i][0] == target) ans++;
        // }

        // for(int i = 1; i < n; i++) {
        //     for(int j = 1; j < n; j++) {
        //         matrix[i][j] = matrix[i][j] + matrix[i][j-1] + matrix[i-1][j] - matrix[i-1][j-1];
        //     }
        // }


        for(int x1 = 0; x1 < n; x1++) {
            for(int y1 = 0; y1 < m; y1++) {
                

                for(int x2 = x1; x2 < n; x2++) {

                    for(int y2 = y1; y2 < m; y2++) {
                        
                        int val = sum[x2 + 1][y2 + 1] - sum[x2+1][y1] - sum[x1][y2+1] + sum[x1][y1];
                        // System.out.println(val + "  x1: " + x1 + " y1: " + y1 + " x1: " + x2 + " y2: " + y2);
                        // System.out.println(sum[x2 + 1][y2 + 1] + " " + sum[x2+1][y1] + " " +  sum[x1][y2+1] + " " + sum[x1+1][y1+1]);
                        if (val == target) ans++;
                        
                    }
                }

            }
        }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return ans;
    }
}