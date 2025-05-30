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
                    pq.add(new int[]{i, j});
                    dis[i][j] = 0;
                }
            }
        }

        int level = 0;

        while(!pq.isEmpty()) {

            int size = pq.size();
            level++;
            for(int k = 0; k < size; k++) {
                
                int[] node = (int[]) pq.poll();
                int i = node[0];
                int j = node[1];

                if (i + 1 < m && dis[i + 1][j] > level) {
                    dis[i + 1][j] = level;
                    pq.add(new int[]{i + 1, j});
                }

                if (i - 1 >= 0 && dis[i - 1][j] > level) {
                    dis[i - 1][j] = level;
                    pq.add(new int[]{i - 1, j});
                }

                if (j + 1 < n && dis[i][j + 1] > level) {
                    dis[i][j + 1] = level;
                    pq.add(new int[]{i, j + 1});
                }

                if (j - 1 >= 0 && dis[i][j - 1] > level) {
                    dis[i][j - 1] = level;
                    pq.add(new int[]{i, j - 1});
                }

            }
        }

        return dis;
    }
}