class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (m == 1 && n == 1) return 0;

        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>( (a, b) -> a[2] - b[2]);

        heap.add(new int[]{0, 0, 0});
        visited[0][0] = 0;

        while(!heap.isEmpty()) {
            int[] arr = heap.poll();
            int i = arr[0];
            int j = arr[1];
            int k = arr[2];

            if (i == m - 1 && j == n - 1) {
                return k;
            }

            if (grid[i][j] == 1) {
                k = k + 1;
            }

            if (i - 1 >= 0) {
                if (visited[i- 1][j] > k) {
                    visited[i-1][j] = k;
                    heap.add(new int[]{i - 1, j, k});
                }
            }

            if (j - 1 >= 0) {
                if (visited[i][j- 1] > k) {
                    visited[i][j-1] = k;
                    heap.add(new int[]{i, j - 1, k});
                }
            }

            if (i + 1 < m) {
                if (visited[i + 1][j] > k) {
                    visited[i + 1][j] = k;
                    heap.add(new int[]{i + 1, j, k});
                }
            }

            if (j + 1 < n) {
                if (visited[i][j + 1] > k) {
                    visited[i][j + 1] = k;
                    heap.add(new int[]{i, j + 1, k});
                }
            }
        }

        return visited[m-1][n-1];
        
    }
}