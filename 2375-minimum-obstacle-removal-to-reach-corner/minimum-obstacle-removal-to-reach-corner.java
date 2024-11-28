class Solution {

    class Node{
        int x;
        int y;
        int val;
        Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>( (a, b) -> a.val - b.val );
        dp[0][0] = 0;
        pq.add(new Node(0, 0, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int i = node.x;
            int j = node.y;
            int val = node.val;

            if (val > dp[i][j]) continue;

            int obs = grid[i][j];

            if (i - 1 >= 0 && dp[i - 1][j] > (val + obs) ) {
                dp[i - 1][j] = (val + obs);
                pq.add(new Node(i - 1, j, val + obs));
            }

            if (i + 1 < m && dp[i + 1][j] > (val + obs)) {
                dp[i + 1][j] = (val + obs);
                pq.add(new Node(i + 1, j, val + obs));
            }

            if (j - 1 >= 0 && dp[i][j - 1] > (val + obs)) {
                dp[i][j - 1] = (val + obs);
                pq.add(new Node(i, j - 1, val + obs));
            }

            if (j + 1 < n && dp[i][j + 1] > (val + obs)) {
                dp[i][j + 1] = (val + obs);

                pq.add(new Node(i, j + 1, val + obs));
            }
        }

        return dp[m - 1][n - 1];

    }
}