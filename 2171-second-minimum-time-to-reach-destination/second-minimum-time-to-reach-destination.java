class Solution {

    class Node {
        int v;
        int t;
        Node(int v, int t) {
            this.v = v;
            this.t = t;
        }
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        ArrayList[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<Node>  pq = new LinkedList<>();
        pq.add(new Node(1, 0));
        int found = -1;

        int visit[] = new int[n + 1];
        Arrays.fill(visit, -1);
        visit[1] = 0;

        while(!pq.isEmpty()) {

            int size = pq.size();
            for(int j = 0; j < size; j++) {
                Node node = pq.poll();

                if (node.v == n && found != -1 && found != node.t) return node.t;

                int wait = 0;
                if ( (node.t / change) % 2 == 1 ) {
                    // we need to wait.
                    wait = change - (node.t % change);
                }

                if (node.v == n) found = node.t;

                for(int i = 0; i < graph[node.v].size() ; i++) {
                    int newNode = (int) graph[node.v].get(i);
                    int newTime = node.t + wait + time;

                    if (visit[newNode] == -1 || (visit[newNode] < newTime)) {
                        if (visit[newNode] != -1) {
                            visit[newNode] = Integer.MAX_VALUE;
                        } else {
                            visit[newNode] = newTime;
                        }
                        pq.add(new Node( newNode, newTime) );
                    }
                        
                }
            }

        }

        return -1;
    }
}