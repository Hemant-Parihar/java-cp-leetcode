class Solution {
    public int shortestPath(int[][] grid, int K) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (m == 1 && n == 1) return 0;

        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(visited[i], -1);
        }
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, K});
        visited[0][0] = K;
        int steps = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for(int itr = 0; itr < size; itr++) {
                int[] arr = queue.poll();
                int i = arr[0];
                int j = arr[1];
                int k = arr[2];

                if (i == m - 1 && j == n - 1) {
                    print(visited);
                    return steps;
                }

                if (grid[i][j] == 1) {
                    if (k == 0) {
                        continue;
                    }
                    k = k - 1;
                }

                if (i - 1 >= 0) {
                    if (visited[i-1][j] < k) {
                        visited[i-1][j] = k;
                        queue.add(new int[]{i - 1, j, k});
                    }
                }

                if (j - 1 >= 0) {
                    if (visited[i][j-1] < k) {
                        visited[i][j-1] = k;
                        queue.add(new int[]{i, j - 1, k});
                    }
                }

                if (i + 1 < m) {
                    if (visited[i + 1][j] < k) {
                        visited[i + 1][j] = k;
                        queue.add(new int[]{i + 1, j, k});
                    }
                }

                if (j + 1 < n) {
                    if (visited[i][j + 1] < k) {
                        visited[i][j + 1] = k;
                        queue.add(new int[]{i, j + 1, k});
                    }
                }
            }
        }

        return -1;
    }

    void print(int[][] visited) {
        int m = visited.length;
        int n = visited[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }
}