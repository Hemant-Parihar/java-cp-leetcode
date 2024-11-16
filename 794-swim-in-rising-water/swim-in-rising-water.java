class Solution {
    class Node {
        int i;
        int j;
        int t;
        Node(int i, int j, int h) {
            this.i = i;
            this.j = j;
            this.t = h;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.t - b.t);
        
        boolean[][] v = new boolean[n][n];

        pq.add(new Node(0, 0, grid[0][0]));
        v[0][0] = true;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int i = node.i;
            int j = node.j;

            if (i == n - 1 && j == n - 1) return node.t;

            if (i - 1 >= 0) {
                if (v[i-1][j] == false) {
                    v[i-1][j] = true;
                    pq.add( new Node(i - 1, j, Math.max(node.t, grid[i-1][j]) ) );
                }
            }

            if (j - 1 >= 0) {
                if (v[i][j-1] == false) {
                    v[i][j-1] = true;
                    pq.add(new Node(i, j - 1, Math.max(node.t, grid[i][j-1])));
                }
            }

            if (i + 1 < n) {
                if (v[i+1][j] == false) {
                    v[i+1][j] = true;
                    pq.add(new Node(i + 1, j, Math.max(node.t, grid[i+1][j])));
                }
            }

            if (j + 1 < n) {
                if (v[i][j + 1] == false) {
                    v[i][j+1] = true;
                    pq.add(new Node(i, j + 1, Math.max(node.t, grid[i][j + 1])));
                }  
            }
        }

        return -1;
    }
}