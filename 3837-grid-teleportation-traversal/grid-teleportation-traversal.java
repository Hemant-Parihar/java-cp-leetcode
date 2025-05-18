class Solution {
    
    int INT_MAX = 1000000;
    public int minMoves(String[] matrix) {
        int m = matrix.length;
        int n = matrix[0].length();

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> Integer.compare(a[2], b[2]) );
        int[][] v = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(v[i], INT_MAX);
        }
        HashSet<Character> set = new HashSet<>();

        pq.add(new int[]{0, 0, 0});
        v[0][0] = 0;

        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int i = node[0];
            int j = node[1];
            int steps = node[2];

            if (i == m - 1 && j == n - 1) {
                return steps;
            }

            char ch = matrix[i].charAt(j);

            if (ch != '.' && !set.contains(ch)) {
                set.add(ch);
                for(int x = 0; x < m; x++) {
                    for(int y = 0; y < n; y++) {
                        if ( ch == matrix[x].charAt(y) && !(x == i && y == j) && v[x][y] > steps ) {
                            v[x][y] = steps;
                            pq.add(new int[]{x, y, steps});
                        }
                    }
                }
            }

            if (i + 1 < m) {
                if (matrix[i + 1].charAt(j) != '#' && v[i + 1][j] > (steps + 1)) {
                    v[i + 1][j] = steps + 1;
                    pq.add(new int[]{i + 1, j, steps + 1});
                }
            }

            if (i - 1 >= 0) {
                if (matrix[i - 1].charAt(j) != '#' && v[i - 1][j] > (steps + 1)) {
                    v[i - 1][j] = steps + 1;
                    pq.add(new int[]{i - 1, j, steps + 1});
                }
            }

            if (j + 1 < n) {
                if (matrix[i].charAt(j + 1) != '#' && v[i][j + 1] > (steps + 1)) {
                    v[i][j + 1] = steps + 1;
                    pq.add(new int[]{i, j + 1, steps + 1});
                }
            }

            if (j - 1 >= 0) {
                if (matrix[i].charAt(j - 1) != '#' && v[i][j - 1] > (steps + 1)) {
                    v[i][j - 1] = steps + 1;
                    pq.add(new int[]{i, j - 1, steps + 1});
                }
            }
        }
        return - 1;
    }
}