class Solution {
    public int minTimeToReach(int[][] moveTime) {
        
        int n = moveTime.length;
        int m = moveTime[0].length;
        
        int[][] min = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                min[i][j] = Integer.MAX_VALUE;
            }
        }
        
        bfs(moveTime, min);

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         System.out.print(min[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return min[n-1][m-1];
    }

    class Node {
        int i;
        int j;
        int time;
        Node(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    void bfs(int[][] moveTime, int[][] min) {

        int n = moveTime.length;
        int m = moveTime[0].length;

        PriorityQueue<Node> pq = new PriorityQueue<Node>( (a, b) -> a.time - b.time );

        pq.add(new Node(0, 0, 0));
        while(pq.size() > 0) {
            Node node = pq.poll();
            int i = node.i;
            int j = node.j;
            int time = node.time;

            if (time >= min[i][j]) continue;

            min[i][j] = node.time;

            if (i == n - 1 && j == m - 1) break;
            
            if (i - 1 >= 0 && time < min[i-1][j]) {
                pq.add(new Node(i - 1, j, Math.max( time + 1, moveTime[i-1][j] + 1 ) ));
            } 
            if (i + 1 < n && time < min[i+1][j] ) {
                pq.add(new Node(i + 1, j, Math.max( time + 1, moveTime[i + 1][j] + 1) ) );
            } 
            if (j - 1 >= 0 && time < min[i][j - 1]) {
                pq.add(new Node(i, j - 1, Math.max( time + 1, moveTime[i][j - 1] + 1) ) );
            } 
            if (j + 1 < m && time < min[i][j + 1]) {
                pq.add( new Node (i, j + 1, Math.max( time + 1, moveTime[i][j + 1]  + 1) ) );
            }
            
        }
    }
    
    void dfs(int i, int j, int time, int[][] moveTime, int[][] min) {
        if (i < 0 || j < 0 || i >= moveTime.length || j >= moveTime[0].length || time >= min[i][j]) return;
    
        
        if ( time > moveTime[i][j]) {
            // That's mean we can reach to this at this time
            
        } else if (!(i == 0 && j == 0 )) {
            time = moveTime[i][j] + 1;
        }
        
        min[i][j] = time;
        
        dfs(i + 1, j, time + 1, moveTime, min);
        dfs(i - 1, j, time + 1, moveTime, min);
        
        dfs(i, j - 1, time + 1, moveTime, min);
        dfs(i, j + 1, time + 1, moveTime, min);
    }
}