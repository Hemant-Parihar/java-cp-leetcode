class Solution {

    class Node {
        int x, y, time;
        Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.time = t;
        }
    }

    int Max_TIME = 100000;

    public int minimumTime(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        PriorityQueue<Node> pq = new PriorityQueue<>( (a, b) -> a.time - b.time );

        boolean[][] dp = new boolean[m][n];
        

        pq.add(new Node(0, 0, 0));
        dp[0][0] = true;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int i = node.x;
            int j = node.y;
            int time = node.time;

            if (i == m - 1 && j == n - 1) return time;


            int timeToReach;

            if (i - 1 >= 0 && dp[i - 1][j] == false) {

                if ( grid[i - 1][j] <= (time + 1) ) {
                    timeToReach = time + 1;
                } else {
                    if ( (grid[i - 1][j] - (time + 1)) % 2 == 0) {
                        timeToReach = grid[i - 1][j];
                    } else {
                        timeToReach = grid[i - 1][j] + 1;
                    }
                }

                dp[i - 1][j] = true;
                pq.add( new Node(i - 1, j, timeToReach) );

            }


            if (i + 1 < m && dp[i + 1][j] == false) {

                if ( grid[i + 1][j] <= (time + 1) ) {
                    timeToReach = time + 1;
                } else {
                    if ( (grid[i + 1][j] - (time + 1)) % 2 == 0) {
                        timeToReach = grid[i + 1][j];
                    } else {
                        timeToReach = grid[i + 1][j] + 1;
                    }
                }

                dp[i + 1][j] = true;
                pq.add( new Node(i + 1, j, timeToReach) );

            }


            if (j + 1 < n && dp[i][j + 1] == false) {

                if ( grid[i][j+ 1] <= (time + 1) ) {
                    timeToReach = time + 1;
                } else {
                    if ( ( (grid[i][j + 1] - (time + 1)) % 2 == 0) ) {
                        timeToReach = grid[i][j + 1];
                    } else {
                        timeToReach = grid[i][j + 1] + 1;
                    }
                }

                dp[i][j + 1] = true;
                pq.add(new Node(i, j + 1, timeToReach )) ;
            }



            if (j - 1 >= 0 && dp[i][j - 1] == false) {

                if ( grid[i][j - 1] <= (time + 1) ) {
                    timeToReach = time + 1;
                } else {
                    if ( ( (grid[i][j - 1] - (time + 1)) % 2 == 0) ) {
                        timeToReach = grid[i][j - 1];
                    } else {
                        timeToReach = grid[i][j - 1] + 1;
                    }
                }

                dp[i][j - 1] = true;
                pq.add(new Node(i, j - 1, timeToReach )) ;

            }

        }

        return -1;
    }
}