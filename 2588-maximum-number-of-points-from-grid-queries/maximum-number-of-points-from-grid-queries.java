class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int k = queries.length;
        int[] ans = new int[k];

        List<int[]> q_l = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            int[] val = {queries[i], i};
            q_l.add(val);
        }

        Collections.sort(q_l, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{grid[0][0], 0, 0});

        boolean[][] v = new boolean[m][n];
        v[0][0] = true;

        for(int i = 0; i < k; i++) {
            int[] node = q_l.get(i);
            int val = node[0];

            while(!pq.isEmpty() && pq.peek()[0] < val) {
                count++;
                int[] grid_node = pq.poll();
                int x = grid_node[1];
                int y = grid_node[2];

                if (x - 1 >= 0 && v[x - 1][y] == false) {
                    pq.add(new int[]{grid[x - 1][y], x - 1, y});
                    v[x - 1][y] = true;
                }

                if (x + 1 < m && v[x + 1][y] == false) {
                    pq.add(new int[]{grid[x + 1][y], x + 1, y});
                    v[x + 1][y] = true;
                }

                if (y - 1 >= 0 && v[x][y - 1] == false) {
                    pq.add(new int[]{grid[x][y - 1], x, y - 1});
                    v[x][y-1] = true;
                }

                if (y + 1 < n && v[x][y + 1] == false) {
                    pq.add(new int[]{grid[x][y + 1], x, y + 1});
                    v[x][y + 1] = true;
                }

            }

            // System.out.println(val + " " + count);
            ans[node[1]] = count;
        }

        return ans;
    }
}