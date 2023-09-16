class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] visited = new int[n][m];

        for(int[] row: visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[]{0, 0, 0});

        int ans = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int i = arr[0];
            int j = arr[1];
            int temp_ans = arr[2];

            if (i == n - 1 && j == m - 1) {
                return temp_ans;
            }

            if (i + 1 < n) {
                int val = Math.max(temp_ans, Math.abs(heights[i][j] - heights[i + 1][j]));
                if (visited[i + 1][j] > val) {
                    visited[i + 1][j] = val;
                    queue.add(new int[]{i + 1, j, val});
                }
            }

            if (i - 1 >= 0) {
                int val = Math.max(temp_ans, Math.abs(heights[i][j] - heights[i - 1][j]));
                if (visited[i - 1][j] > val) {
                    visited[i - 1][j] = val;
                    queue.add(new int[]{i - 1, j, val});
                }
            }

            if (j + 1 < m) {
                int val = Math.max(temp_ans, Math.abs(heights[i][j] - heights[i][j + 1]));
                if (visited[i][j + 1] > val) {
                    visited[i][j + 1] = val;
                    queue.add(new int[]{i, j + 1, val});
                }
            }

            if (j - 1 >= 0) {
                int val = Math.max(temp_ans, Math.abs(heights[i][j] - heights[i][j - 1]));
                if (visited[i][j - 1] > val) {
                    visited[i][j - 1] = val;
                    queue.add(new int[]{i, j - 1, val});
                }
            }
        }

        return ans;
    }
}