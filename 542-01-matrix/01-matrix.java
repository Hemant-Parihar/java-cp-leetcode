class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> pq = new LinkedList<>();
        int[][] dis = new int[m][n];

        for(int i = 0; i < m; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    pq.add(new int[]{0, i, j});
                    dis[i][j] = 0;
                }
            }
        }

        while(!pq.isEmpty()) {

            int[] node = (int[]) pq.poll();
            int d = node[0];
            int i = node[1];
            int j = node[2];

            if (i + 1 < m && dis[i + 1][j] > (d + 1)) {
                dis[i + 1][j] = d + 1;
                pq.add(new int[]{d + 1, i + 1, j});
            }

            if (i - 1 >= 0 && dis[i - 1][j] > (d + 1)) {
                dis[i - 1][j] = d + 1;
                pq.add(new int[]{d + 1, i - 1, j});
            }

            if (j + 1 < n && dis[i][j + 1] > (d + 1)) {
                dis[i][j + 1] = d + 1;
                pq.add(new int[]{d + 1, i, j + 1});
            }

            if (j - 1 >= 0 && dis[i][j - 1] > (d + 1)) {
                dis[i][j - 1] = d + 1;
                pq.add(new int[]{d + 1, i, j - 1});
            }

        }

        return dis;
    }
}