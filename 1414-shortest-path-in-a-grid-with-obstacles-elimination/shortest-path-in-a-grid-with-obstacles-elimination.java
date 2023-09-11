class Solution {
    public int shortestPath(int[][] grid, int K) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (m == 1 && n == 1) return 0;

        int[][][] visited = new int[m][n][K + 1];
        Queue<List<Integer>> queue = new LinkedList<>();

        queue.add(new ArrayList<>(List.of(0, 0, K)));
        visited[0][0][K] = -1;
        int steps = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for(int itr = 0; itr < size; itr++) {
                List<Integer> list = queue.poll();
                int i = list.get(0);
                int j = list.get(1);
                int k = list.get(2);

                if (i == m - 1 && j == n - 1) {
                    return steps;
                }

                if (grid[i][j] == 1) {
                    if (k == 0) {
                        continue;
                    }
                    k = k - 1;
                }

                if (i - 1 >= 0) {
                    if (visited[i-1][j][k] == 0) {
                        visited[i-1][j][k] = steps;
                        queue.add(new ArrayList<>(List.of(i - 1, j, k)));
                    }
                }

                if (j - 1 >= 0) {
                    if (visited[i][j-1][k] == 0) {
                        visited[i][j-1][k] = steps;
                        queue.add(new ArrayList<>(List.of(i, j - 1, k)));
                    }
                }

                if (i + 1 < m) {
                    if (visited[i + 1][j][k] == 0) {
                        visited[i + 1][j][k] = steps;
                        queue.add(new ArrayList<>(List.of(i + 1, j, k)));
                    }
                }

                if (j + 1 < n) {
                    if (visited[i][j + 1][k] == 0) {
                        visited[i][j + 1][k] = steps;
                        queue.add(new ArrayList<>(List.of(i, j + 1, k)));
                    }
                }
            }
        }

        return -1;
    }
}